package co.com.sofka.juegocarros.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "El nombre del conductor es obligatorio")
    @Size(min = 2, max = 15, message = "El nombre del conductor debe tener entre 2 y 15 caracteres")
    private String nombre;
    private int puntos;
    private int record;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.record = 0;
    }

    public Jugador(Integer id, @NotBlank(message = "El nombre del conductor es obligatorio") @Size(min = 2, max = 15, message = "El nombre del conductor debe tener entre 2 y 15 caracteres") String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Jugador() {
    }
}

