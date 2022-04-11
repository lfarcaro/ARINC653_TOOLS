package arinc653.configuration.parserresources;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Node;

/**
 * Configuration utilities.
 * 
 * @author Luís Fernando Arcaro
 */
public class ConfigurationUtilities {

	/**
	 * Decimal value pattern.
	 */
	private static final Pattern ptDecimalValue = Pattern.compile("([+-]{0,1})([0-9]+)");

	/**
	 * Hexadecimal value pattern.
	 */
	private static final Pattern ptHexadecimalValue = Pattern.compile("([+-]{0,1})0x([0-9a-fA-F]+)");

	/**
	 * Node attribute getter.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param stAttribute
	 *            Attribute.
	 */
	public static String getNodeAttribute(Node ndNode, String stAttribute) {

		// Verifies node
		if (ndNode == null) {
			return null;
		}

		// Gets attribute node
		Node ndAttribute = ndNode.getAttributes().getNamedItem(stAttribute);

		// Verifies attribute node
		if (ndAttribute == null) {
			return null;
		}

		// Returns text content
		return ndAttribute.getTextContent();
	}

	/**
	 * Parse decimal or hexadecimal long method.
	 * 
	 * @param stValue
	 *            Value.
	 */
	public static Long cmdParseDecimalOrHexadecimalLong(String stValue) {

		// Verifies value
		if (stValue == null) {
			return null;
		}

		// Gets decimal matcher
		Matcher mtDecimalValue = ptDecimalValue.matcher(stValue);

		// Verifies decimal match
		if (mtDecimalValue.matches()) {
			return Long.parseLong(stValue);
		}

		// Gets hexadecimal matcher
		Matcher mtHexadecimalValue = ptHexadecimalValue.matcher(stValue);

		// Verifies hexadecimal match
		if (mtHexadecimalValue.matches()) {
			return Long.parseLong(mtHexadecimalValue.group(2), 16) * ("-".equals(mtHexadecimalValue.group(1)) ? -1 : 1);
		}

		// Not matched
		return null;
	}

	/**
	 * Attribute getter.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param stAttribute
	 *            Attribute.
	 */
	public static String getStringAttribute(Node ndNode, String stAttribute) {
		return getNodeAttribute(ndNode, stAttribute);
	}

	/**
	 * Attribute getter.
	 * 
	 * @param stAttribute
	 *            Attribute.
	 */
	public static String getAttributeString(String stAttribute) {
		return stAttribute;
	}

	/**
	 * Attribute getter.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param stAttribute
	 *            Attribute.
	 */
	public static Integer getIntegerAttribute(Node ndNode, String stAttribute) {

		// Gets node attribute
		String stNodeAttribute = getNodeAttribute(ndNode, stAttribute);

		// Verifies node attribute
		if (stNodeAttribute == null) {
			return null;
		}

		// Parses node attribute
		return Integer.parseInt(stNodeAttribute);
	}

	/**
	 * Attribute getter.
	 * 
	 * @param inAttribute
	 *            Attribute.
	 */
	public static String getAttributeInteger(Integer inAttribute) {

		// Verifies attribute
		if (inAttribute == null) {
			return null;
		}

		// Converts
		return Integer.toString(inAttribute);
	}

	/**
	 * Attribute getter.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param stAttribute
	 *            Attribute.
	 */
	public static Boolean getBooleanAttribute(Node ndNode, String stAttribute) {

		// Gets node attribute
		String stNodeAttribute = getNodeAttribute(ndNode, stAttribute);

		// Verifies node attribute
		if (stNodeAttribute == null) {
			return null;
		}

		// Parses node attribute
		return Boolean.parseBoolean(stNodeAttribute);
	}

	/**
	 * Attribute getter.
	 * 
	 * @param blAttribute
	 *            Attribute.
	 */
	public static String getAttributeBoolean(Boolean blAttribute) {

		// Verifies attribute
		if (blAttribute == null) {
			return null;
		}

		// Converts
		return Boolean.toString(blAttribute);
	}

	/**
	 * Attribute getter.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param stAttribute
	 *            Attribute.
	 */
	public static BigDecimal getDecimalAttribute(Node ndNode, String stAttribute) {

		// Gets node attribute
		String stNodeAttribute = getNodeAttribute(ndNode, stAttribute);

		// Verifies node attribute
		if (stNodeAttribute == null) {
			return null;
		}

		// Parses node attribute
		return new BigDecimal(stNodeAttribute);
	}

	/**
	 * Attribute getter.
	 * 
	 * @param bdAttribute
	 *            Attribute.
	 */
	public static String getAttributeDecimal(BigDecimal bdAttribute) {

		// Verifies attribute
		if (bdAttribute == null) {
			return null;
		}

		// Converts
		return bdAttribute.toString();
	}

	/**
	 * Attribute getter.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param stAttribute
	 *            Attribute.
	 */
	public static Identifier getIdentifierAttribute(Node ndNode, String stAttribute) {

		// Gets node attribute
		String stNodeAttribute = getNodeAttribute(ndNode, stAttribute);

		// Verifies attribute
		if (stNodeAttribute == null) {
			return null;
		}

		// Parses decimal or hexadecimal long
		Long lnIdentifier = cmdParseDecimalOrHexadecimalLong(stNodeAttribute);

		// Gets decimal matcher
		Matcher mtDecimalValue = ptDecimalValue.matcher(stNodeAttribute);

		// Verifies decimal match
		if (mtDecimalValue.matches()) {
			return new Identifier(lnIdentifier, false);
		}

		// Gets hexadecimal matcher
		Matcher mtHexadecimalValue = ptHexadecimalValue.matcher(stNodeAttribute);

		// Verifies hexadecimal match
		if (mtHexadecimalValue.matches()) {
			return new Identifier(lnIdentifier, true);
		}

		// Parsing failed
		throw new NumberFormatException("Invalid identifier '" + stNodeAttribute + "'");
	}

	/**
	 * Attribute getter.
	 * 
	 * @param idAttribute
	 *            Attribute.
	 */
	public static String getAttributeIdentifier(Identifier idAttribute) {

		// Verifies identifier
		if (idAttribute == null) {
			return null;
		}

		// Verifies identifier
		if (idAttribute.getIdentifier() == null) {
			return null;
		}

		// Verifies hexadecimal
		if (idAttribute.getHexadecimal()) {
			if (idAttribute.getIdentifier() < 0) {
				return "-0x" + Long.toString(idAttribute.getIdentifier() * -1, 16).toUpperCase();
			} else {
				return "0x" + Long.toString(idAttribute.getIdentifier(), 16).toUpperCase();
			}
		}

		// Returns value
		return Long.toString(idAttribute.getIdentifier());
	}

	/**
	 * Attribute getter.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param stAttribute
	 *            Attribute.
	 */
	public static DecOrHexLong getDecOrHexLongAttribute(Node ndNode, String stAttribute) {

		// Gets node attribute
		String stNodeAttribute = getNodeAttribute(ndNode, stAttribute);

		// Verifies attribute
		if (stNodeAttribute == null) {
			return null;
		}

		// Parses decimal or hexadecimal long
		Long lnDecOrHexLong = cmdParseDecimalOrHexadecimalLong(stNodeAttribute);

		// Gets decimal matcher
		Matcher mtDecimalValue = ptDecimalValue.matcher(stNodeAttribute);

		// Verifies decimal match
		if (mtDecimalValue.matches()) {
			return new DecOrHexLong(lnDecOrHexLong, false);
		}

		// Gets hexadecimal matcher
		Matcher mtHexadecimalValue = ptHexadecimalValue.matcher(stNodeAttribute);

		// Verifies hexadecimal match
		if (mtHexadecimalValue.matches()) {
			return new DecOrHexLong(lnDecOrHexLong, true);
		}

		// Parsing failed
		throw new NumberFormatException("Invalid decimal or hexadecimal value '" + stNodeAttribute + "'");
	}

	/**
	 * Attribute getter.
	 * 
	 * @param dhAttribute
	 *            Attribute.
	 */
	public static String getAttributeDecOrHexLong(DecOrHexLong dhAttribute) {

		// Verifies decimal or hexadecimal
		if (dhAttribute == null) {
			return null;
		}

		// Verifies decimal or hexadecimal
		if (dhAttribute.getValue() == null) {
			return null;
		}

		// Verifies hexadecimal
		if (dhAttribute.getHexadecimal()) {
			if (dhAttribute.getValue() < 0) {
				return "-0x" + Long.toString(dhAttribute.getValue() * -1, 16).toUpperCase();
			} else {
				return "0x" + Long.toString(dhAttribute.getValue(), 16).toUpperCase();
			}
		}

		// Returns value
		return Long.toString(dhAttribute.getValue());
	}

	/**
	 * Attribute getter.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param stAttribute
	 *            Attribute.
	 */
	public static DecOrHexString getDecOrHexStringAttribute(Node ndNode, String stAttribute) {

		// Gets node attribute
		String stNodeAttribute = getNodeAttribute(ndNode, stAttribute);

		// Verifies attribute
		if (stNodeAttribute == null) {
			return null;
		}

		// Verifies attribute
		if ("".equals(stNodeAttribute)) {
			return null;
		}

		// Returns
		return new DecOrHexString(stNodeAttribute);
	}

	/**
	 * Attribute getter.
	 * 
	 * @param dhAttribute
	 *            Attribute.
	 */
	public static String getAttributeDecOrHexString(DecOrHexString dhAttribute) {

		// Verifies decimal or hexadecimal
		if (dhAttribute == null) {
			return null;
		}

		// Verifies value
		if (dhAttribute.getValue() == null) {
			return null;
		}

		// Returns value
		return dhAttribute.getValue();
	}

	/**
	 * Attribute getter.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param stAttribute
	 *            Attribute.
	 */
	public static <A extends Enum<A>> A getEnumerationAttribute(Node ndNode, String stAttribute, Class<A> enEnum) {

		// Gets node attribute
		String stNodeAttribute = getNodeAttribute(ndNode, stAttribute);

		// Verifies attribute
		if (stNodeAttribute == null) {
			return null;
		}

		// Parses value
		return Enum.valueOf(enEnum, stNodeAttribute);
	}

	/**
	 * Attribute getter.
	 * 
	 * @param enAttribute
	 *            Attribute.
	 */
	public static <A extends Enum<A>> String getAttributeEnumeration(Enum<A> enAttribute) {

		// Verifies enumeration
		if (enAttribute == null) {
			return null;
		}

		// Returns attribute name
		return enAttribute.name();
	}
}