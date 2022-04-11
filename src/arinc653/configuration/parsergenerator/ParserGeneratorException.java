package arinc653.configuration.parsergenerator;

/**
 * Parser generator exception.
 * 
 * @author Luís Fernando Arcaro
 */
public class ParserGeneratorException extends Exception {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param stMessage
	 *            Message.
	 */
	public ParserGeneratorException(String stMessage) {
		super(stMessage);
	}

	/**
	 * Constructor.
	 * 
	 * @param stMessage
	 *            Message.
	 * @param thCause
	 *            Cause.
	 */
	public ParserGeneratorException(String stMessage, Throwable thCause) {
		super(stMessage);

		// Verifies cause
		if (thCause != null) {
			super.initCause(thCause);
		}
	}
}