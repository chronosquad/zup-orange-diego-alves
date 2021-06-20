package br.com.zup.orange.controleveiculosusuarios.models.entities;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String value;
    private String brand;
    private String model;
    private String year;
    private String runDay;
    private Boolean active;

    @ManyToOne
    private User user;

    @Deprecated
    public Vehicle() {
    }

    public Vehicle(String type, String value, String brand, String model, String year, String runDay,
                   Boolean active, User user) {
        this.type = type;
        this.value = value;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.user = user;
        this.runDay = runDay;
        this.active = active;
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

    public User getUser() {
        return user;
    }

    public String getRunDay() {
        return runDay;
    }

    public Boolean getActive(){
        return active;
    }
}
