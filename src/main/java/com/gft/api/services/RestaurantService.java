package com.gft.api.services;

import com.gft.api.entities.Restaurant;
import com.gft.api.exceptions.EntityNotFoundException;
import com.gft.api.repositories.RestaurantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return this.restaurantRepository.save(restaurant);
    }

    public Page<Restaurant> findAllRestaurants(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

    public Restaurant getRestaurant(Long id) {
        Optional<Restaurant> optional = restaurantRepository.findById(id);

        return optional.orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
    }

    public Restaurant updateRestaurant(Restaurant restaurant, Long id) {
        Restaurant restaurantOriginal = this.getRestaurant(id);

        restaurant.setId(restaurantOriginal.getId());

        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        Restaurant restaurantOriginal = this.getRestaurant(id);

        restaurantRepository.delete(restaurantOriginal);
    }
}
