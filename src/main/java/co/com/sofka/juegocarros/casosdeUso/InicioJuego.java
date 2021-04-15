package co.com.sofka.juegocarros.casosdeUso;

import co.com.sofka.juegocarros.modelo.Conductor;
import co.com.sofka.juegocarros.modelo.Juego;
import co.com.sofka.juegocarros.modelo.Podio;
import java.util.List;

public class InicioJuego {
    public void iniciarJuego(Juego juego){
        int avance;
        boolean detenerJuego = false;
        List<Conductor> conductores = juego.getConductores();
        Podio podio = juego.getPodio();
        while (detenerJuego==false){
            for (int x=0; x<conductores.size(); x++){
                Conductor conductor = conductores.get(x);
                int distancia= ((int) Math.floor((Math.random() * 6) + 1)*100);
                int meta = conductor.getCarro().getMeta();
                System.out.println(conductores.get(x));
                avance = conductor.getCarro().getAvance();
                if(avance<meta){
                    avance= avance + distancia;
                    conductor.getCarro().setAvance(avance);
                }else {
                    if(podio.getPrimerLugar()==""){
                        podio.setPrimerLugar(conductor.getNombre());
                        conductor.getCarro().setMovimiento(false);
                    }else if(podio.getSegundoLugar() == "" && conductor.getCarro().isMovimiento() == true){
                        podio.setSegundoLugar(conductor.getNombre());
                        conductor.getCarro().setMovimiento(false);
                    }
                    else if (podio.getTercerLugar()== "" && conductor.getCarro().isMovimiento() == true){
                        podio.setTercerLugar(conductor.getNombre());
                        conductor.getCarro().setMovimiento(false);
                        detenerJuego = true;
                        break;
                    }
                }

            }
        }
        System.out.println(juego.getPodio());
    }

}
