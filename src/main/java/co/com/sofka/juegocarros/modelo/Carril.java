package co.com.sofka.juegocarros.modelo;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class Carril {
    @NotBlank(message = "La posición del carril es obligatorio")
    private Integer posicion;

    public Carril(@NotBlank(message = "La posición del carril es obligatorio") Integer posicion) {
        this.posicion = posicion;
    }
}
