package com.tech.order.controller;

import com.tech.order.dto.OrderDto;
import com.tech.order.dto.OrderDtoFromFE;
import com.tech.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFE orderDtoFromFE) {
        OrderDto savedOrderInDb = orderService.saveOrderInDb(orderDtoFromFE);
        return new ResponseEntity<>(savedOrderInDb, HttpStatus.CREATED);
    }
}
