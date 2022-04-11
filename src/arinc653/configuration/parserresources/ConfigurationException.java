package arinc653.configuration.parserresources;

/**
 * Configuration exception.
 * 
 * @author Luís Fernando Arcaro
 */
public class ConfigurationException extends Exception {

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
	public ConfigurationException(String stMessage) {
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
	public ConfigurationException(String stMessage, Throwable thCause) {
		super(stMessage);

		// Verifies cause
		if (thCause != null) {
			super.initCause(thCause);
		}
	}
}