package exceptions;

public class LivroInvalidoException extends Exception {

	private static final long serialVersionUID = -5344006671491023011L;

	public LivroInvalidoException(String message) {
        super(message);
    }
}