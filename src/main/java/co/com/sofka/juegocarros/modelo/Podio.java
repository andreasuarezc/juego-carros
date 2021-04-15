package co.com.sofka.juegocarros.modelo;

import lombok.Data;

@Data
public class Podio {
    private Integer id;
    private String primerLugar;
    private String segundoLugar;
    private String tercerLugar;

    public Podio(Integer id) {
        this.id = id;
        this.primerLugar = "";
        this.segundoLugar = "";
        this.tercerLugar = "";
    }
}
