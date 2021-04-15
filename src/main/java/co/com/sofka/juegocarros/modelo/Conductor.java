package co.com.sofka.juegocarros.modelo;

import lombok.Data;

@Data
public class Conductor {
    private String nombre;
    private Carro carro;

    public Conductor(String nombre, Carro carro) {
        this.nombre = nombre;
        this.carro = carro;
    }
}
