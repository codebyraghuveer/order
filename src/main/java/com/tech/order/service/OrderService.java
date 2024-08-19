package com.tech.order.service;

import com.tech.order.dto.OrderDto;
import com.tech.order.dto.OrderDtoFromFE;

public interface OrderService {

    OrderDto saveOrderInDb(OrderDtoFromFE orderDtoFromFE);
}
