package br.com.zup.orange.controleveiculosusuarios.models.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true, length = 11)
    private String cpf;

    private LocalDate birthdate;

    @Deprecated
    public User() {
    }

    public User(String name, String email, String cpf, LocalDate birthdate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }

    public String getName() {
        return this.name;
    }
}
