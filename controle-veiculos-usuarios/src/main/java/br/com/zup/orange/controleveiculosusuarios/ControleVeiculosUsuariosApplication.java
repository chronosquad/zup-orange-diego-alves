package br.com.zup.orange.controleveiculosusuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ControleVeiculosUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleVeiculosUsuariosApplication.class, args);
    }

}
