public class InvalidOperationException extends Exception {
    private String message;

    public InvalidOperationException(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
