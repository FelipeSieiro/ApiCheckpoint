package com.tripair.trip;

import com.tripair.car.car;
import com.tripair.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trips")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    String nameLocal;
    float valor;
    String fotourl;

    // Várias viagens podem ter um único usuário
    @ManyToOne
    User user;

    // Uma viagem pode ter apenas um carrinho
    @OneToOne
    car car;
}

