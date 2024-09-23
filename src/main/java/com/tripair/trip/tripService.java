package com.tripair.trip;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class tripService {
    private final tripRepository TripRepository;

    public tripService (tripRepository repository){
        this.TripRepository =repository;
    }

    public Page<trip> findAll(Pageable pageable){
        return TripRepository.findAll(pageable);
    }

    public trip create(trip trip) {
        return TripRepository.save(trip);
    }
}
