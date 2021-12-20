package com.gft.api.dto.user;

import com.gft.api.dto.Restaurant.RestaurantMapper;
import com.gft.api.entities.Profile;
import com.gft.api.entities.Restaurant;
import com.gft.api.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {
    public static User fromDTO(UserRegisterDTO dto) {
        Profile profile = new Profile();
        profile.setId(dto.getProfileId());

        Restaurant restaurant = new Restaurant();
        restaurant.setId(dto.getRestaurantId());

        return new User(null, dto.getEmail(), new BCryptPasswordEncoder().encode(dto.getPassword()), profile, restaurant);
    }

    public static UserQueryDTO fromEntity(User user) {

        return new UserQueryDTO(user.getEmail(), user.getProfile().getName(), RestaurantMapper.fromEntity(user.getRestaurant()));

    }
}
