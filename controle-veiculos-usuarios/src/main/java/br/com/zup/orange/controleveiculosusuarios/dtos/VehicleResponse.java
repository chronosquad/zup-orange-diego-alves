package br.com.zup.orange.controleveiculosusuarios.dtos;

import br.com.zup.orange.controleveiculosusuarios.models.entities.Vehicle;

public class VehicleResponse {
    private String type;
    private String value;
    private String brand;
    private String model;
    private String year;
    private String runDay;
    private Boolean active;
    private String userName;

    public VehicleResponse(Vehicle vehicle) {
        this.type = vehicle.getType();
        this.value = vehicle.getValue();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.year = vehicle.getYear();
        this.runDay = vehicle.getRunDay();
        this.active = vehicle.getActive();
        this.userName = vehicle.getUser().getName();
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
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

    public String getUserName() {
        return userName;
    }

    public String getRunDay(){
        return runDay;
    }

    public Boolean getActive(){
        return active;
    }

}
