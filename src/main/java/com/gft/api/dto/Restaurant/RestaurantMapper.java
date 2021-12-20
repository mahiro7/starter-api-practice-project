package com.gft.api.dto.Restaurant;

import com.gft.api.entities.Restaurant;

public class RestaurantMapper {

    public static Restaurant fromDTO(RestaurantRegisterDTO dto) {
        return new Restaurant(null, dto.getName(), dto.getEmail(), dto.getCelNumber());
    }

    public static RestaurantQueryDTO fromEntity(Restaurant restaurant) {
        return new RestaurantQueryDTO(restaurant.getId(), restaurant.getName(), restaurant.getEmail(), restaurant.getCelNumber());
    }

}
