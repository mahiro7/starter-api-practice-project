package com.gft.api.dto.user;

public class UserRegisterDTO {
    private String email;
    private String password;
    private Long profileId;
    private Long restaurantId;

    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String email, String password, Long profileId, Long restaurantId) {
        this.email = email;
        this.password = password;
        this.profileId = profileId;
        this.restaurantId = restaurantId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
