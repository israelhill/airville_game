public class InvalidOperationException extends Exception {
    private String message;
    private ErrorCode errorCode;

    public InvalidOperationException(ErrorCode errorCode, String message) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public enum ErrorCode {
        INVALID_PASSENGER,
        INVALID_LINE,
        INSUFFICIENT_DIAMONDS,
        INVALID_AGENT,
        INVALID_SUPERVISOR
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String toString() {
        return message;
    }
}
