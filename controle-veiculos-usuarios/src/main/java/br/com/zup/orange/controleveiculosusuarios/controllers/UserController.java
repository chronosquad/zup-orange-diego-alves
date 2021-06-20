package br.com.zup.orange.controleveiculosusuarios.controllers;

import br.com.zup.orange.controleveiculosusuarios.dtos.NewUserRequest;
import br.com.zup.orange.controleveiculosusuarios.models.entities.User;
import br.com.zup.orange.controleveiculosusuarios.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid NewUserRequest request){
        if (userRepository.existsByEmail(request.getEmail())){
            return ResponseEntity.status(400).body("Email já cadastrado!");
        }
        if (userRepository.existsByCpf(request.getCpf())){
            return ResponseEntity.status(400).body("CPF já cadastrado!");
        }

        User newUser = request.toUser();

        userRepository.save(newUser);

        return ResponseEntity.status(201).body("Usuário cadastrado com sucesso!");
    }

}
