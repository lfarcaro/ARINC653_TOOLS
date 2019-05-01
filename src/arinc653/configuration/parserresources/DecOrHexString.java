package arinc653.configuration.parserresources;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DecOrHex stored as String.
 * 
 * @author Luís Fernando Arcaro
 */
public final class DecOrHexString {

	/**
	 * Byte pattern.
	 */
	private static final Pattern ptByte = Pattern.compile("([0-9a-fA-F]{2})");

	/**
	 * Value.
	 */
	private String stValue;

	/**
	 * Constructor.
	 * 
	 * @param stValue
	 *            Value.
	 */
	public DecOrHexString(String stValue) {
		this.stValue = stValue;
	}

	/**
	 * Value getter.
	 */
	public String getValue() {
		return stValue;
	}

	/**
	 * Bytes getter.
	 * 
	 * @param inRequiredLength
	 *            Required length or null to ignore.
	 */
	public byte[] getBytes(Integer inRequiredLength) {

		// Verifies value
		if (stValue == null) {
			return null;
		}

		// Verifies prefix
		if (((stValue.length() % 2) != 0) || (!stValue.startsWith("0x"))) {
			return null;
		}

		// Gets hexadecimal value
		String stHexadecimalValue = stValue.substring(2);

		// Creates byte array
		byte[] btByte = new byte[stHexadecimalValue.length() / 2];

		// Verifies required length
		if (inRequiredLength != null) {

			// Verifies byte array length
			if (btByte.length != inRequiredLength) {
				return null;
			}
		}

		// Index
		int inIndex = 0;

		// Creates matcher
		Matcher mtMatcher = ptByte.matcher(stHexadecimalValue);

		// Finds next byte
		while (mtMatcher.find()) {

			// Parses byte
			btByte[inIndex++] = (byte) (Integer.parseInt(mtMatcher.group(1), 16) & 0xFF);
		}

		// Returns bytes
		return btByte;
	}

	@Override
	public String toString() {
		return stValue;
	}
}