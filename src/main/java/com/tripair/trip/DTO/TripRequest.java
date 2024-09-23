package com.tripair.trip.DTO;



import com.tripair.trip.trip;
import com.tripair.user.User;

public record TripRequest(String nameLocal, float valor, String fotourl) {

    public trip toModel(User user) {
        return trip
                .builder()
                .nameLocal(nameLocal)
                .valor(valor)
                .fotourl(fotourl)
                .user(user)
                .build();
    }
}
