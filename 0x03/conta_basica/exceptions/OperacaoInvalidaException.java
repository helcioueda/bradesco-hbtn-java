package exceptions;

public class OperacaoInvalidaException extends Exception {

	private static final long serialVersionUID = 8570731400408393976L;

	public OperacaoInvalidaException(String message) {
        super(message);
    }
}