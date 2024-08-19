package com.tech.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDto {

    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private Number price;
    private String restaurantCode;
    private Integer quantity;
}
