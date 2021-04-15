package co.com.sofka.juegocarros.repositorio;

import co.com.sofka.juegocarros.modelo.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepositorio extends JpaRepository<Jugador, Integer> {
}
