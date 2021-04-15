/*package co.com.sofka.juegocarros.casosdeUso;

import co.com.sofka.juegocarros.modelo.*;
import java.util.ArrayList;
import java.util.List;

public class ConfiguracionJuego {

    public Juego configurarJuego(JuegoDTO juegoDTO){
        int longitud = juegoDTO.getLongitudPista();
        Pista pista = new Pista(1,longitud);
        int longitudEnMetros= longitud*1000;
        int cantidadJugadores = juegoDTO.getNombres().size();
        List<Conductor> conductores = new ArrayList<>();
        for(int x=0; x<cantidadJugadores; x++){
            Carril carril = new Carril(x+1);
            Carro carro = new Carro(carril, longitudEnMetros);
            String nombreJugador = juegoDTO.getNombres().get(x);
            Conductor conductor = new Conductor(nombreJugador, carro);
            conductores.add(conductor);
        }
        Juego juego = new Juego(pista, conductores);
        return juego;
    }
}*/
