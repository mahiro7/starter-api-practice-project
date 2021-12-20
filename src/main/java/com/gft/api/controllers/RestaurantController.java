package com.gft.api.controllers;

import com.gft.api.dto.Restaurant.RestaurantMapper;
import com.gft.api.dto.Restaurant.RestaurantQueryDTO;
import com.gft.api.dto.Restaurant.RestaurantRegisterDTO;
import com.gft.api.entities.Restaurant;
import com.gft.api.services.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<Page<RestaurantQueryDTO>> getRestaurants(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(restaurantService.findAllRestaurants(pageable)
                .map(RestaurantMapper::fromEntity)
        );
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<RestaurantQueryDTO> saveRestaurant(@RequestBody RestaurantRegisterDTO dto) {
        Restaurant restaurant = restaurantService.saveRestaurant(RestaurantMapper.fromDTO(dto));

        return ResponseEntity.ok(RestaurantMapper.fromEntity(restaurant));
    }

    @GetMapping("{id}")
    public ResponseEntity<RestaurantQueryDTO> getRestaurant(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);

        return ResponseEntity.ok(RestaurantMapper.fromEntity(restaurant));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<RestaurantQueryDTO> updateRestaurant(@RequestBody RestaurantRegisterDTO dto, @PathVariable Long id){
        Restaurant restaurant = restaurantService.updateRestaurant(RestaurantMapper.fromDTO(dto), id);

        return ResponseEntity.ok(RestaurantMapper.fromEntity(restaurant));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<RestaurantQueryDTO> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);

        return ResponseEntity.ok().build();
    }

}
