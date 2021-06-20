package br.com.zup.orange.controleveiculosusuarios.controllers;

import br.com.zup.orange.controleveiculosusuarios.clients.ApiFipeClient;
import br.com.zup.orange.controleveiculosusuarios.clients.ApiFipeResponse;
import br.com.zup.orange.controleveiculosusuarios.dtos.NewVehicleRequest;
import br.com.zup.orange.controleveiculosusuarios.dtos.VehicleResponse;
import br.com.zup.orange.controleveiculosusuarios.exception.ResourseNotFoundException;
import br.com.zup.orange.controleveiculosusuarios.models.entities.User;
import br.com.zup.orange.controleveiculosusuarios.models.entities.Vehicle;
import br.com.zup.orange.controleveiculosusuarios.models.repositories.UserRepository;
import br.com.zup.orange.controleveiculosusuarios.models.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/vehicle")
public class vehicleController {

    @Autowired
    private ApiFipeClient apiFipeClient;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping("/{userId}")
    public ResponseEntity<?> createVehicle(@RequestBody @Valid NewVehicleRequest request, @PathVariable int userId){
        ApiFipeResponse responseController = apiFipeClient.getFullFipe(request.getType(), request.getBrand(),
                request.getModel(), request.getYear());

        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourseNotFoundException("Usuário não encontrado com id: "+userId));

        Vehicle newVehicle = request.toVehicle(responseController, user);

        vehicleRepository.save(newVehicle);

        return ResponseEntity.status(201).body("Veículo cadastrado com sucesso!");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity <?> list(@PathVariable int userId){
        userRepository.findById(userId).orElseThrow(()->
                new ResourseNotFoundException("Usuário não encontrado com id: "+userId));

        List<Vehicle> list = vehicleRepository.findAllByUserId(userId);
        List<VehicleResponse> listVehicleResponse = list.stream().map(VehicleResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.status(200).body(listVehicleResponse);
    }
}
