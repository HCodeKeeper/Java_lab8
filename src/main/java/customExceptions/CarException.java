package customExceptions;

public class CarException extends RuntimeException {

    public CarException(String message) {
        super(message);
    }
    public CarException(String message, Throwable err) {
        super(message, err);
    }
}
