package com.cg.services.impl;

import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;
import com.cg.dto.order_itemDTO.OrderItemResult;
import com.cg.mapper.OrderItemMapper;
import com.cg.mapper.OrderMapper;
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
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
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

    @Override
    public List<OrderResult> findAll() {
        return orderRepository.findAll()
                .stream().map(order -> orderMapper.toDTO(order))
                .collect(Collectors.toList());
    }

    @Override
    public OrderResult findById(Long id) {
        return orderMapper.toDTO(orderRepository.findById(id).get());
    }

    @Override
    public OrderResult saveOrderImport(OrderCreate orderCreate, OrderItemResult orderItemResult) {

        Optional<User> userOptional = userRepository.findById(orderCreate.getUserId());

        if (!userOptional.isPresent()){
            throw new RuntimeException("ID người dùng không tồn tại");
        }

        Long itemId = orderItemResult.getItemId();

        Optional<Item> itemOptional = itemRepository.findById(itemId);

        if (itemOptional.isPresent()){
            throw new RuntimeException("Không tìm thấy ID sản phẩm!");
        }

        Order newOrder = orderMapper.toModelOrder(orderCreate);

        OrderItem newOrderItem = orderItemMapper.toModal(orderItemResult);

        Item newItem = new Item();

        newItem.setPrice(newOrderItem.getPrice());
        newItem.setQuantity(newOrderItem.getQuantity());
        newItem.setOrderId(newOrderItem.getOrderId());
        newItem.setUpdatedBy(newOrderItem.getProductId());
        newItem.setUserId(userOptional.get().getId());
        newItem.setCreatedBy(userOptional.get().getId());
        newItem.setCreatedAt(Instant.now());








        newOrder.setOrderStatus(OrderStatus.PENDING);

        return orderMapper.toDTO(orderRepository.save(newOrder));

    }
}
