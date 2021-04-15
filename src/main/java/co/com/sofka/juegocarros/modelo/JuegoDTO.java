package co.com.sofka.juegocarros.modelo;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class JuegoDTO {
    @Id
    @Column(name= "juego_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private int longitudPista;
    @OneToMany(fetch = FetchType.LAZY,cascade=javax.persistence.CascadeType.REMOVE)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<Jugador> jugadores;

    public JuegoDTO( int longitudPista) {
        this.longitudPista = longitudPista;
    }

    public JuegoDTO(Integer id, int longitudPista, Set<Jugador> jugadores) {
        this.id = id;
        this.longitudPista = longitudPista;
        this.jugadores = jugadores;
    }

    public JuegoDTO() {
    }
}
