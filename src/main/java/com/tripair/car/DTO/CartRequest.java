package com.tripair.car.DTO;

import com.tripair.car.car;
import com.tripair.user.User;

public record CartRequest(float valorCar) {

        public car toModel(User user) {
            return car.builder()
                    .valorCar(valorCar)
                    .user(user) // Associar o carrinho ao usuário
                    .build();
        }
    }

