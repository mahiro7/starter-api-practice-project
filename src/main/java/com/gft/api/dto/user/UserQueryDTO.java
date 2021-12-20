package com.gft.api.dto.user;

import com.gft.api.dto.Restaurant.RestaurantQueryDTO;

public class UserQueryDTO {
    private String email;
    private String profileName;
    private RestaurantQueryDTO restaurant;

    public UserQueryDTO() {
    }

    public UserQueryDTO(String email, String profileName, RestaurantQueryDTO restaurant) {
        this.email = email;
        this.profileName = profileName;
        this.restaurant = restaurant;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public RestaurantQueryDTO getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantQueryDTO restaurant) {
        this.restaurant = restaurant;
    }
}
