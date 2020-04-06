package cl.anderson.errorhandling.controlleradvice.city.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException() {
        super("No data found");
    }
}
