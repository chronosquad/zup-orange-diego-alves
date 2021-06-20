package br.com.zup.orange.controleveiculosusuarios.models.repositories;

import br.com.zup.orange.controleveiculosusuarios.models.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
}