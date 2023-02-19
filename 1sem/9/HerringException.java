public class HerringException extends Exception{
    public HerringException() {
    }

    public HerringException(String message) {
        super(message);
    }

    public HerringException(String message, Throwable cause) {
        super(message, cause);
    }

    public HerringException(Throwable cause) {
        super(cause);
    }

    public HerringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}