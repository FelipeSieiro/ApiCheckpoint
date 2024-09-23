package com.tripair.trip;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripair.trip.DTO.TripRequest;
import com.tripair.user.UserRepository;

@RestController
@RequestMapping(name="/trips")
public class tripController {
    private final tripService tripService;
    private final UserRepository userRepository;

    public tripController(tripService tripService, UserRepository userRepository) {
        this.tripService = tripService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public Page<trip> findAll(@PageableDefault(size = 3) Pageable pageable) {
        return tripService.findAll(pageable);
    }

    @PostMapping
    public trip create(@RequestBody TripRequest tripRequest) {
        System.out.println(tripRequest);
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        trip trip = tripRequest.toModel(user);
        return tripService.create(trip);
    }

}