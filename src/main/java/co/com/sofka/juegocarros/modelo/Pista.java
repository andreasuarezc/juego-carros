package co.com.sofka.juegocarros.modelo;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class Pista {
    private Integer id;
    @NotBlank(message = "La Distancia en Kilómetros de la pista es obligatorio")
    @Min(value = 1, message = "La pista debe tener una distancia de mínimo 1 Km")
    private Integer longitudPista;

    public Pista(Integer id, @NotBlank(message = "La Distancia en Kilómetros de la pista es obligatorio") @Min(value = 1, message = "La pista debe tener una distancia de mínimo 1 Km") Integer longitudPista) {
        this.id = id;
        this.longitudPista = longitudPista;
    }
}
