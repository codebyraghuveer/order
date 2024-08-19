package com.tech.order.service;

import com.tech.order.dto.OrderDto;
import com.tech.order.dto.OrderDtoFromFE;
import com.tech.order.dto.UserInfoDto;
import com.tech.order.entity.Order;
import com.tech.order.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SequenceGenerator sequenceGenerator;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDto saveOrderInDb(OrderDtoFromFE orderDtoFromFE) {
        int newOrderId = sequenceGenerator.generateNextOrderId();
        //fetch userDto by userId
        UserInfoDto userInfoDto = fetchUserDetailsByUserId(orderDtoFromFE.getUserId());
        Order orderToBeSaved = new Order(
                Long.valueOf(newOrderId),
                orderDtoFromFE.getFoodItemDtoList(),
                orderDtoFromFE.getRestaurantDto(),
                userInfoDto
        );
        orderRepository.save(orderToBeSaved);
        return modelMapper.map(orderToBeSaved, OrderDto.class);
    }

    private UserInfoDto fetchUserDetailsByUserId(Long userId) {
        return restTemplate.getForObject("http://USER-INFO/user/getUser/" + userId, UserInfoDto.class);
    }
}
