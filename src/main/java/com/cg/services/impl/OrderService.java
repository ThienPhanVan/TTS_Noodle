package com.cg.services.impl;

import com.cg.dto.order.OrderItemParam;
import com.cg.dto.order.OrderParam;
import com.cg.dto.order.OrderResult;
import com.cg.dto.userDTO.CreateUserParam;
import com.cg.exceptions.NotEnoughQuantityException;
import com.cg.exceptions.NotFoundException;
import com.cg.mapper.OrderItemMapper;
import com.cg.mapper.OrderMapper;
import com.cg.mapper.UserMapper;
import com.cg.repositories.ItemRepository;
import com.cg.repositories.OrderItemRepository;
import com.cg.repositories.OrderRepository;
import com.cg.repositories.UserRepository;
import com.cg.repositories.model.*;
import com.cg.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service

public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public OrderResult customerOrder(OrderParam orderParam) {

//        Transient
        Long userId = orderParam.getUserId();
        if (userId != null) {
            Optional<User> optional = userRepository.findById(userId);
            if (!optional.isPresent())
                throw new NotFoundException("Không Tìm Thấy Id Khách Hàng!");
        }
        Order order = orderMapper.toModel(orderParam);
        order.setFullName(orderParam.getFullName());
        order.setPhone(orderParam.getPhone());
        order.setAddress(orderParam.getAddress());
        order.setCreatedAt(Instant.now());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setCreatedBy(2L);
        order.setOrderType(OrderType.CUSTOMER);
        order.setGrandTotal(new BigDecimal(355));
        order = orderRepository.save(order);

        BigDecimal grandTotal;

        //xu ly list orderItems
        for (OrderItemParam itemParam : orderParam.getOrderItems()) {
            //kiem tra product ton tai
            if (!itemRepository.existsById(itemParam.getProductId()))
                throw new NotFoundException("Không Tìm Thấy productId " + itemParam.getProductId());

            // lay toan item theo productId
            List<Item> items = itemRepository.findAllByProductIdOrderByCreatedAt(itemParam.getProductId());
            long totalAvailable = items.stream()
                    .mapToInt(Item::getAvailable)
                    .sum();
            // nếu tổng sản phẩm nhỏ hơn số lượng order thì gửi thông báo số lượng k đủ
            if (totalAvailable < itemParam.getQuantity())
                throw new NotEnoughQuantityException("Không đủ số lượng, vui lòng kiểm tra số lượng!");
            // lấy số lượng order
            int quantityCustomer = itemParam.getQuantity();
            for (Item item : items) {
                if (quantityCustomer == 0)
                    throw new NotEnoughQuantityException("Số lượng nhập vào phải lớn hơn 0!");
                int available = item.getAvailable();
              //  int sold = item.getSold();
                if (quantityCustomer >= available) {
                    quantityCustomer -= available;
                    System.out.println("available= " +available);
                    System.out.println("quantity= " +quantityCustomer);
                    item.setAvailable(0);
                    item.setSold(available);
                } else {
                    available -= quantityCustomer;
                    item.setAvailable(available);
                    item.setSold( item.getSold() + quantityCustomer);
                }

                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(item.getQuantity());
                orderItem.setProductId(item.getProductId());
                orderItem.setItemId(item.getId());
                orderItem.setOrderId(order.getId());
                orderItem.setPrice(new BigDecimal(7));
                orderItemRepository.save(orderItem);

            }
            //order Item
        }
        return orderMapper.toDTO(order);
    }
}
