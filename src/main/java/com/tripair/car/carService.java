package com.tripair.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tripair.trip.trip;
import com.tripair.trip.tripRepository;
@Service
public class carService {

   

    @Autowired
    private tripRepository tripRepository;

    private final carRepository carRepository;

    public carService(carRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Método para buscar todos os carrinhos com paginação
    public Page<car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    // Método para criar um novo carrinho
    public car create(car car) {
        return carRepository.save(car);
    }

    public void addTrip(Long cartId, trip trip) {
        car cart = carRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        // Adiciona a viagem ao carrinho
        cart.addTrip(trip);

        // Atualiza o valor do carrinho no banco de dados
        carRepository.addTripToCart(cartId, trip.getValor());
    }

    public void removeTrip(Long cartId, trip trip) {
        car cart = carRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        // Remove a viagem do carrinho
        cart.removeTrip(trip);

        // Atualiza o valor do carrinho no banco de dados
        carRepository.removeTripFromCart(cartId, trip.getValor());
    }
}

