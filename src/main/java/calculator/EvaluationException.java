package calculator;

public class EvaluationException extends Exception {
    private final int errorPosition;

    public EvaluationException(String message, int errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

    public int getErrorPosition() {
        return errorPosition;
    }
}
