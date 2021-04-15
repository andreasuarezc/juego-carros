package co.com.sofka.juegocarros;

public class NotFoundIdException extends RuntimeException {
    public NotFoundIdException(String message){
        super(message);
    }
}