package project12;

/**
 * an Exception class for the game
 */
public class InvalidOperationException extends Exception {
    private String message;
    private ErrorCode errorCode;

    /**
     * a constructor for the class
     * @param errorCode
     * @param message
     */
    public InvalidOperationException(ErrorCode errorCode, String message) {
        this.message = message;
        this.errorCode = errorCode;
    }

    /**
     * enum of status variables
     */
    public enum ErrorCode {
        INVALID_PASSENGER,
        INVALID_LINE,
        INSUFFICIENT_DIAMONDS,
        INVALID_AGENT,
        INVALID_SUPERVISOR
    }

    /**
     * get the error code
     * @return
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * to string for the class
     * @return
     */
    public String toString() {
        return message;
    }
}
