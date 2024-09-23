package com.tripair.user.DTO;
import com.tripair.user.User;

public record UserProfileResponse(
        String name,
        String email
       
) {
    public UserProfileResponse(User user){
        this(user.getName(), user.getEmail());
    }
}