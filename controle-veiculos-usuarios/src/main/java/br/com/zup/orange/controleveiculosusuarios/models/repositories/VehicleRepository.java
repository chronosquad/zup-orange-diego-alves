package br.com.zup.orange.controleveiculosusuarios.models.repositories;

import br.com.zup.orange.controleveiculosusuarios.models.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findAllByUserId(int userId);

}
