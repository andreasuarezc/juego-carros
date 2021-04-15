package co.com.sofka.juegocarros.modelo;

import lombok.Data;
import java.util.List;

@Data
public class Juego {
    /*
    @OneToOne(targetEntity = Pista.class)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)*/
    private Pista pista;
    /*
    @OneToMany(targetEntity = Jugador.class)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)*/
    private List<Conductor> conductores;
    /*@OneToOne(targetEntity = Podio.class)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)*/
    private Podio podio;

    public Juego(Pista pista, List<Conductor> conductores) {
        this.pista = pista;
        this.conductores = conductores;
        this.podio = new Podio(1);
    }

}
