package exceptions;

public class EmptyException extends Exception {

    public EmptyException() {
        super ("Esta vacio");
    }

    public EmptyException(String msg) {
        super (msg);
    }
    public EmptyException(Throwable cause) {
        super (cause);
    }
}
