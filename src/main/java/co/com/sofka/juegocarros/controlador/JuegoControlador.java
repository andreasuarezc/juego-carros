package co.com.sofka.juegocarros.controlador;

import co.com.sofka.juegocarros.modelo.JuegoDTO;
import co.com.sofka.juegocarros.modelo.Jugador;
import co.com.sofka.juegocarros.servicio.JuegoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JuegoControlador {

    @Autowired
    private JuegoServicio juegoServicio;

    @PostMapping(value = "api/juego")
    public JuegoDTO crearJuego(@RequestBody JuegoDTO juego){
        System.out.println(juego.getLongitudPista());
        return juegoServicio.crearjuego(juego);
    }

    @PostMapping(value = "api/{juegoId}/jugador")
    public ResponseEntity<String> crearJugador(@PathVariable("juegoId") Integer juegoId,@Valid @RequestBody Jugador jugador){
        juegoServicio.crearJugador(juegoId, jugador);
        return ResponseEntity.ok("Tarea añadida correctamente");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping(value = "api/juego")
    public Iterable<JuegoDTO> obtenerJuego(){
        return juegoServicio.obtenerJuego();
    }

    @GetMapping(value = "api/{juegoId}/jugadores")
    public Iterable<Jugador> listarJugadores(@PathVariable("juegoId") Integer juegoId){
        return juegoServicio.listarJugadores(juegoId);
    }
    /*
    @PostMapping(value = "/juego")
    public ResponseEntity<String> iniciarJuego(@Valid @RequestBody JuegoDTO juegoDTO) {
        juegoServicio.iniciarJuego(juegoDTO);
        return ResponseEntity.ok("Juego iniciado correctamente");
    }

    @PostMapping(value = "/{juegoId}/jugador")
    public ResponseEntity<String> añadirJugador(@PathVariable("juegoId") Integer juegoId, @Valid @RequestBody Jugador jugador){
        juegoServicio.añadirJugador(juegoId, jugador);
        return ResponseEntity.ok("Tarea añadida correctamente");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping(value = "/{juegoId}/jugadores")
    public Iterable<Jugador> listarJugadores(@PathVariable("juegoId") Integer juegoId){
        return juegoServicio.listarJugadores(juegoId);
    }

    @PutMapping(value = "/{juegoId}/jugador")
    public Jugador actualizarJugador(@PathVariable("juegoId") Integer juegoId, @RequestBody Jugador jugador){
        if(jugador.getId() != null){
            return juegoServicio.actualizarJugador(juegoId, jugador);
        }
        throw new NotFoundIdException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "/{id}/jugador")
    public void eliminarJugador(@PathVariable("id")Integer id){
        juegoServicio.eliminarJugador(id);
    }*/
}
