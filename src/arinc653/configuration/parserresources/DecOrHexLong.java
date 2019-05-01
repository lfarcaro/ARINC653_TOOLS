package arinc653.configuration.parserresources;

/**
 * DecOrHex stored as Long.
 * 
 * @author Luís Fernando Arcaro
 */
public final class DecOrHexLong {

	/**
	 * Value.
	 */
	private Long lnValue;

	/**
	 * Hexadecimal.
	 */
	private boolean blHexadecimal;

	/**
	 * Constructor.
	 * 
	 * @param lnValue
	 *            Value.
	 * @param blHexadecimal
	 *            Hexadecimal.
	 */
	public DecOrHexLong(Long lnValue, boolean blHexadecimal) {
		this.lnValue = lnValue;
		this.blHexadecimal = blHexadecimal;
	}

	/**
	 * Value getter.
	 */
	public Long getValue() {
		return lnValue;
	}

	/**
	 * Hexadecimal getter.
	 */
	public boolean getHexadecimal() {
		return blHexadecimal;
	}

	@Override
	public String toString() {
		return Long.toString(lnValue);
	}
}