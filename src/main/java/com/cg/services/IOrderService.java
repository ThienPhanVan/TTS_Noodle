package com.cg.services;

<<<<<<< HEAD
import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;
import java.util.List;
=======

import com.cg.dto.order.OrderParam;
import com.cg.dto.order.OrderResult;

>>>>>>> development
public interface IOrderService {
    List<OrderResult> findAll ();

    OrderResult findById(Long id);

    OrderResult createOrderImport(OrderCreate orderCreate);


    List<OrderResult> getAllOrderByUserId(Long userId);

<<<<<<< HEAD
=======
    OrderResult customerOrder(OrderParam orderParam);
>>>>>>> development
}
