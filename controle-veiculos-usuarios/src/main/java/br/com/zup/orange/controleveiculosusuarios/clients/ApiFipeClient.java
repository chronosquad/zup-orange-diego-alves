package br.com.zup.orange.controleveiculosusuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ApiFipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface ApiFipeClient {

    @GetMapping("/{type}/marcas/{brand}/modelos/{model}/anos/{year}")
    ApiFipeResponse getFullFipe(@PathVariable String type, @PathVariable String brand,
                                @PathVariable String model, @PathVariable String year);
}










