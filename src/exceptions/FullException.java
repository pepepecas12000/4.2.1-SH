package exceptions;

public class FullException extends Exception {

    public FullException() {
        super ("Esta lleno");
    }

    public FullException(String msg) {
        super (msg);
    }
    public FullException(Throwable cause) {
        super (cause);
    }
}
