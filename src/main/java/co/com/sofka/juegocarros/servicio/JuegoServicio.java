package co.com.sofka.juegocarros.servicio;

import co.com.sofka.juegocarros.NotFoundIdException;
import co.com.sofka.juegocarros.casosdeUso.InicioJuego;
import co.com.sofka.juegocarros.modelo.*;
import co.com.sofka.juegocarros.repositorio.JuegoRepositorio;
import co.com.sofka.juegocarros.repositorio.JugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class JuegoServicio {
    public static final String NO_FAULT_ID = "No existe el id de la lista";
    @Autowired
    private JuegoRepositorio juegoRepositorio;
    @Autowired
    private JugadorRepositorio jugadorRepositorio;
    //private ConfiguracionJuego configuracionJuego = new ConfiguracionJuego();
    private InicioJuego inicioJuego = new InicioJuego();

    public JuegoDTO crearjuego(JuegoDTO juego) {
        JuegoDTO juegoDTO = new JuegoDTO();
        juegoDTO.setLongitudPista(juego.getLongitudPista());
        System.out.println(juego.getLongitudPista());
        var id = juegoRepositorio.save(juegoDTO).getId();
        juego.setId(id);
        return juego;
    }

    public Jugador crearJugador(Integer juegoId, Jugador jugador) {
        var listaJugadores = juegoRepositorio.findById(juegoId)
                .orElseThrow(() -> new NotFoundIdException(NO_FAULT_ID));
        var nuevojugador = new Jugador();

        nuevojugador.setNombre(jugador.getNombre());
        nuevojugador.setId(jugador.getId());

        //addition new to-do
        listaJugadores.getJugadores().add(nuevojugador);

        var actualizarLista = juegoRepositorio.save(listaJugadores);
        //last item
        var ultimoJugador = actualizarLista.getJugadores()
                .stream()
                .max(Comparator.comparingInt(item -> item.getId().intValue()))
                .orElseThrow();
        jugador.setId(ultimoJugador.getId());
        return jugador;
    }

    public Set<JuegoDTO> obtenerJuego() {
        return StreamSupport
                .stream(juegoRepositorio.findAll().spliterator(), false)
                .map(juego -> {
                    var listaJugadores = juego.getJugadores()
                            .stream()
                            .map(item -> new Jugador(item.getId(), item.getNombre()))
                            .collect(Collectors.toSet());
                    return new JuegoDTO(juego.getId(), juego.getLongitudPista(), listaJugadores);
                })
                .collect(Collectors.toSet());
    }

    public Set<Jugador> listarJugadores(Integer id) {
        return juegoRepositorio.findById(id)
                .orElseThrow(() -> new NotFoundIdException(NO_FAULT_ID))
                .getJugadores().stream()
                .map(item -> new Jugador(item.getId(), item.getNombre()))
                .collect(Collectors.toSet());
    }
    /*

    public void iniciarJuego(JuegoDTO juegoDTO){
        Juego juego = configuracionJuego.configurarJuego(juegoDTO);
        System.out.println(juego);
        inicioJuego.iniciarJuego(juego);
    }
    public Jugador añadirJugador(Integer juegoId, Jugador jugador) {
        var listaJugadores = juegoRepositorio.findById(juegoId)
                .orElseThrow(() -> new NotFoundIdException(NO_FAULT_ID));
        var nuevojugador = new Jugador();

        nuevojugador.setNombre(jugador.getNombre());
        nuevojugador.setId(jugador.getId());

        //addition new to-do
        listaJugadores.getJugadores().add(nuevojugador);

        var actualizarLista = juegoRepositorio.save(listaJugadores);
        //last item
        var ultimoJugador = actualizarLista.getJugadores()
                .stream()
                .max(Comparator.comparingInt(item -> item.getId().intValue()))
                .orElseThrow();
        jugador.setId(ultimoJugador.getId());
        return jugador;
    }

    public Set<Jugador> listarJugadores (Integer id) {
        return juegoRepositorio.findById(id)
                .orElseThrow(() -> new NotFoundIdException(NO_FAULT_ID))
                .getJugadores().stream()
                .map(item -> new Jugador(item.getId(), item.getNombre()))
                .collect(Collectors.toSet());
    }

    public Jugador actualizarJugador(Integer juegoId, Jugador jugador) {
        var listaJugadores = juegoRepositorio.findById(juegoId)
                .orElseThrow(() -> new NotFoundIdException(NO_FAULT_ID));
        //edit to-do
        for(var item : listaJugadores.getJugadores()){
            if(item.getId().equals(jugador.getId())){
                item.setNombre(Objects.requireNonNull(jugador.getNombre()));
                item.setId(Objects.requireNonNull(jugador.getId()));
            }
        }
        juegoRepositorio.save(listaJugadores);
        return jugador;
    }

    public void eliminarJugador(Integer id) {
        var toDo = jugadorRepositorio.findById(id).orElseThrow();
        jugadorRepositorio.delete(toDo);
    }*/
}
