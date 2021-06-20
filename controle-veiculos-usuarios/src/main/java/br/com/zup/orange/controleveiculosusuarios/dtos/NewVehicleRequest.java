package br.com.zup.orange.controleveiculosusuarios.dtos;

import br.com.zup.orange.controleveiculosusuarios.clients.ApiFipeResponse;
import br.com.zup.orange.controleveiculosusuarios.models.entities.User;
import br.com.zup.orange.controleveiculosusuarios.models.entities.Vehicle;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class NewVehicleRequest {
    @NotBlank
    private String type;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotBlank
    private String year;

    public String getType() {
        return type;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public String getYear() {
        return year;
    }

    public Vehicle toVehicle(ApiFipeResponse getFipe, User user) {
        int lastDigit = Integer.parseInt(getFipe.getAnoModelo());
        String runDay;
        boolean active;
        int day = LocalDate.now().getDayOfWeek().getValue();
        int weekday;

        if (lastDigit%10 == 0 || lastDigit%10 == 1){
            runDay = "Segundas-Feiras";
            weekday =  1;
        }else if (lastDigit%10 == 2 || lastDigit%10 == 3){
            runDay = "Terças-Feiras";
            weekday =  2;
        }else if (lastDigit%10 == 4 || lastDigit%10 == 5){
            runDay = "Quartas-Feiras";
            weekday =  3;
        }else if (lastDigit%10 == 6 || lastDigit%10 == 7){
            runDay = "Quintas-Feiras";
            weekday =  4;
        }else if (lastDigit%10 == 8 || lastDigit%10 == 9){
            runDay = "Sextas-Feiras";
            weekday =  5;
        } else {runDay = "Final do ano inválido"; weekday = 0;};

        active = day == (weekday);

        return new Vehicle(type,getFipe.getValor(),getFipe.getMarca(),getFipe.getModelo(),
                getFipe.getAnoModelo(),runDay,active,user);
    }
}