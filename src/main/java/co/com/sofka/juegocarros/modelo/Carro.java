package co.com.sofka.juegocarros.modelo;

import lombok.Data;

@Data
public class Carro {
    private Carril carril;
    private int meta;
    private int avance;
    private boolean movimiento;

    public Carro(Carril carril, int meta) {
        this.carril = carril;
        this.meta = meta;
        this.avance = 0;
        this.movimiento = true;
    }

}
