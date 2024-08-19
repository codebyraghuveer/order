package com.tech.order.entity;

import com.tech.order.dto.FoodItemDto;
import com.tech.order.dto.RestaurantDto;
import com.tech.order.dto.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

    private Long orderId;
    private List<FoodItemDto> foodItemDtoList;
    private RestaurantDto restaurantDto;
    private UserInfoDto userInfoDto;
}
