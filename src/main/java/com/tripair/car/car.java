package com.tripair.car;

import java.util.List;

import com.tripair.trip.trip;
import com.tripair.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class car {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    // Um carrinho pode ter várias viagens
    @OneToMany(mappedBy = "car")
    List<trip> trips;

    // Um carrinho pode ter somente um usuário
    @OneToOne
    User user;

    float valorCar;

    public void addTrip(trip trip) {
        trips.add(trip);
        this.valorCar += trip.getValor(); // Atualiza o valor total do carrinho com a nova viagem
    }
    
    public void removeTrip(trip trip) {
        trips.remove(trip);
        this.valorCar -= trip.getValor(); // Atualiza o valor total ao remover a viagem
    }
    
}
