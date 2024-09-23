package com.tripair.car;

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

import com.tripair.car.DTO.CartRequest;
import com.tripair.user.UserRepository;

@RestController
@RequestMapping("/cars")
public class carController {
    

    private final carService carService;
    private final UserRepository userRepository;

    public carController(carService carService, UserRepository userRepository) {
        this.carService = carService;
        this.userRepository = userRepository;
    }

    // Endpoint para listar todos os carrinhos com paginação
    @GetMapping
    public Page<car> findAll(@PageableDefault(size = 3) Pageable pageable) {
        return carService.findAll(pageable);
    }

    // Endpoint para criar um novo carrinho
    @PostMapping
    public car create(@RequestBody CartRequest cartRequest) {
        // Obter o email do usuário autenticado no contexto de segurança
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        
        // Buscar o usuário pelo email
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        // Criar o carrinho a partir do CartRequest e associar ao usuário
        car car = cartRequest.toModel(user);
        
        // Salvar e retornar o carrinho criado
        return carService.create(car);
    }
}

