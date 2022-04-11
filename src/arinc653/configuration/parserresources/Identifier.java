package arinc653.configuration.parserresources;

/**
 * Identifier.
 * 
 * @author Luís Fernando Arcaro
 */
public final class Identifier {

	/**
	 * Identifier.
	 */
	private Long lnIdentifier;

	/**
	 * Hexadecimal.
	 */
	private boolean blHexadecimal;

	/**
	 * Constructor.
	 * 
	 * @param lnIdentifier
	 *            Identifier.
	 * @param blHexadecimal
	 *            Hexadecimal.
	 */
	public Identifier(Long lnIdentifier, boolean blHexadecimal) {
		this.lnIdentifier = lnIdentifier;
		this.blHexadecimal = blHexadecimal;
	}

	/**
	 * Constructor.
	 * 
	 * @param lnIdentifier
	 *            Identifier.
	 */
	public Identifier(Long lnIdentifier) {
		this(lnIdentifier, false);
	}

	/**
	 * Identifier getter.
	 */
	public Long getIdentifier() {
		return lnIdentifier;
	}

	/**
	 * Hexadecimal getter.
	 */
	public boolean getHexadecimal() {
		return blHexadecimal;
	}

	@Override
	public int hashCode() {
		return (lnIdentifier != null ? lnIdentifier.intValue() : 0);
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof Identifier)) {
			return false;
		}

		// Casts object
		Identifier idIdentifier = (Identifier) obObject;

		// Verifies identifiers
		if ((idIdentifier.getIdentifier() == null) || (lnIdentifier == null)) {
			return ((idIdentifier.getIdentifier() == null) && (lnIdentifier == null));
		}

		// Verifies identifiers
		if (idIdentifier.getIdentifier().equals(lnIdentifier)) {
			return true;
		}

		// Not equal
		return false;
	}

	@Override
	public String toString() {
		return Long.toString(lnIdentifier);
	}
}