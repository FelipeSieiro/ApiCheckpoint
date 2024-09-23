package com.tripair.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface carRepository extends JpaRepository<car,Long> {
      // Método para adicionar uma Trip ao carrinho
    @Modifying
    @Transactional
    @Query("UPDATE car c SET c.valorCar = c.valorCar + :valor WHERE c.id = :cartId")
    void addTripToCart(@Param("cartId") Long cartId, @Param("valor") float valor);

    // Método para remover uma Trip do carrinho
    @Modifying
    @Transactional
    @Query("UPDATE car c SET c.valorCar = c.valorCar - :valor WHERE c.id = :cartId")
    void removeTripFromCart(@Param("cartId") Long cartId, @Param("valor") float valor);
}
