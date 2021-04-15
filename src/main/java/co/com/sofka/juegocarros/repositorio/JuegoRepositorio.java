package co.com.sofka.juegocarros.repositorio;

import co.com.sofka.juegocarros.modelo.JuegoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepositorio extends JpaRepository <JuegoDTO, Integer>{
}
