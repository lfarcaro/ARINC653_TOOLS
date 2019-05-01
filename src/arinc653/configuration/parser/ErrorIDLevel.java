package arinc653.configuration.parser;

import arinc653.configuration.parser.ErrorCode;
import arinc653.configuration.parser.ErrorLevel;
import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Error_ID_Level node.
 */
public class ErrorIDLevel {

	/**
	 * Parent node.
	 */
	private SystemHMTable_SystemStateEntry ndParent;

	/**
	 * ErrorIdentifier attribute.
	 */
	private Identifier idErrorIdentifier;

	/**
	 * Description attribute.
	 */
	private String stDescription;

	/**
	 * ErrorLevel attribute.
	 */
	private ErrorLevel enErrorLevel;

	/**
	 * ErrorCode attribute.
	 */
	private ErrorCode enErrorCode;

	/**
	 * Constructor.
	 */
	private ErrorIDLevel() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idErrorIdentifier
	 *            ErrorIdentifier.
	 * @param stDescription
	 *            Description.
	 * @param enErrorLevel
	 *            ErrorLevel.
	 * @param enErrorCode
	 *            ErrorCode.
	 */
	private ErrorIDLevel(SystemHMTable_SystemStateEntry ndParent, Identifier idErrorIdentifier, String stDescription, ErrorLevel enErrorLevel, ErrorCode enErrorCode) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idErrorIdentifier = idErrorIdentifier;
		this.stDescription = stDescription;
		this.enErrorLevel = enErrorLevel;
		this.enErrorCode = enErrorCode;

		// Adds to parent
		if (!ndParent.addErrorIDLevel(this)) {
			throw new ConfigurationException("Error_ID_Level cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public SystemHMTable_SystemStateEntry getParent() {
		return ndParent;
	}

	/**
	 * ErrorIdentifier getter.
	 */
	public Identifier getErrorIdentifier() {
		return this.idErrorIdentifier;
	}

	/**
	 * ErrorIdentifier setter.
	 */
	public void setErrorIdentifier(Identifier idErrorIdentifier) {
		this.idErrorIdentifier = idErrorIdentifier;
	}

	/**
	 * Description getter.
	 */
	public String getDescription() {
		return this.stDescription;
	}

	/**
	 * Description setter.
	 */
	public void setDescription(String stDescription) {
		this.stDescription = stDescription;
	}

	/**
	 * ErrorLevel getter.
	 */
	public ErrorLevel getErrorLevel() {
		return this.enErrorLevel;
	}

	/**
	 * ErrorLevel setter.
	 */
	public void setErrorLevel(ErrorLevel enErrorLevel) {
		this.enErrorLevel = enErrorLevel;
	}

	/**
	 * ErrorCode getter.
	 */
	public ErrorCode getErrorCode() {
		return this.enErrorCode;
	}

	/**
	 * ErrorCode setter.
	 */
	public void setErrorCode(ErrorCode enErrorCode) {
		this.enErrorCode = enErrorCode;
	}

	@Override
	public int hashCode() {
		return (idErrorIdentifier != null ? idErrorIdentifier.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof ErrorIDLevel)) {
			return false;
		}

		// Casts object
		ErrorIDLevel ndErrorIDLevel = (ErrorIDLevel) obObject;

		// Verifies identifiers
		if ((ndErrorIDLevel.getErrorIdentifier() == null) || (idErrorIdentifier == null)) {
			return ((ndErrorIDLevel.getErrorIdentifier() == null) && (idErrorIdentifier == null));
		}

		// Verifies identifiers
		if (ndErrorIDLevel.getErrorIdentifier().equals(idErrorIdentifier)) {
			return true;
		}

		// Not equal
		return false;
	}

	@Override
	public String toString() {
		return (idErrorIdentifier != null ? idErrorIdentifier.toString() : super.toString());
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            System_State_Entry.
	 */
	public static ErrorIDLevel cmdLoad(Node ndNode, SystemHMTable_SystemStateEntry ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_ERRORIDLEVEL.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Error_ID_Level");
		}

		// Creates node
		ErrorIDLevel ndErrorIDLevel = new ErrorIDLevel();

		// Sets parent
		ndErrorIDLevel.ndParent = ndParent;

		// Loads attribute
		try {
			ndErrorIDLevel.idErrorIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_ERRORIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ErrorIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndErrorIDLevel.idErrorIdentifier == null) {
			throw new ConfigurationException("Required attribute ErrorIdentifier not found");
		}

		// Loads attribute
		ndErrorIDLevel.stDescription = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_DESCRIPTION);

		// Loads attribute
		try {
			ndErrorIDLevel.enErrorLevel = ConfigurationUtilities.getEnumerationAttribute(ndNode, Module.ATTRIBUTENAME_ERRORLEVEL, ErrorLevel.class);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ErrorLevel value cannot be parsed");
		}

		// Verifies required attribute
		if (ndErrorIDLevel.enErrorLevel == null) {
			throw new ConfigurationException("Required attribute ErrorLevel not found");
		}

		// Loads attribute
		try {
			ndErrorIDLevel.enErrorCode = ConfigurationUtilities.getEnumerationAttribute(ndNode, Module.ATTRIBUTENAME_ERRORCODE, ErrorCode.class);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ErrorCode value cannot be parsed");
		}

		// Iterates attributes
		NamedNodeMap nmAttributes = ndNode.getAttributes();
		for (int i = 0; i < nmAttributes.getLength(); i++) {

			// Gets next attribute
			Node ndAttribute = nmAttributes.item(i);

			// Verifies attribute
			if (ndAttribute.getNodeType() != Node.ATTRIBUTE_NODE) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_ERRORIDENTIFIER.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_DESCRIPTION.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_ERRORLEVEL.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_ERRORCODE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Error_ID_Level node");
		}

		// Iterates child nodes
		NodeList nlNodeList = ndNode.getChildNodes();
		for (int i = 0; i < nlNodeList.getLength(); i++) {

			// Gets next child node
			Node ndChildNode = nlNodeList.item(i);

			// Verifies node
			if (ndChildNode.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Error_ID_Level node");
		}

		// Returns node
		return ndErrorIDLevel;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndErrorIDLevel
	 *            Error_ID_Level.
	 */
	public static Element cmdSave(Element elParent, ErrorIDLevel ndErrorIDLevel) throws ConfigurationException {

		// Creates element
		Element elErrorIDLevel = elParent.getOwnerDocument().createElement(Module.NODENAME_ERRORIDLEVEL);

		// Verifies required attribute
		if (ndErrorIDLevel.getErrorIdentifier() == null) {
			throw new ConfigurationException("Required attribute ErrorIdentifier not assigned in Error_ID_Level");
		}

		// Saves attribute
		elErrorIDLevel.setAttribute(Module.ATTRIBUTENAME_ERRORIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndErrorIDLevel.getErrorIdentifier()));

		// Verifies attribute
		if (ndErrorIDLevel.getDescription() != null) {

			// Saves attribute
			elErrorIDLevel.setAttribute(Module.ATTRIBUTENAME_DESCRIPTION, ConfigurationUtilities.getAttributeString(ndErrorIDLevel.getDescription()));
		}

		// Verifies required attribute
		if (ndErrorIDLevel.getErrorLevel() == null) {
			throw new ConfigurationException("Required attribute ErrorLevel not assigned in Error_ID_Level");
		}

		// Saves attribute
		elErrorIDLevel.setAttribute(Module.ATTRIBUTENAME_ERRORLEVEL, ConfigurationUtilities.getAttributeEnumeration(ndErrorIDLevel.getErrorLevel()));

		// Verifies attribute
		if (ndErrorIDLevel.getErrorCode() != null) {

			// Saves attribute
			elErrorIDLevel.setAttribute(Module.ATTRIBUTENAME_ERRORCODE, ConfigurationUtilities.getAttributeEnumeration(ndErrorIDLevel.getErrorCode()));
		}

		// Returns element
		return elErrorIDLevel;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idErrorIdentifier
	 *            ErrorIdentifier.
	 * @param stDescription
	 *            Description.
	 * @param enErrorLevel
	 *            ErrorLevel.
	 * @param enErrorCode
	 *            ErrorCode.
	 */
	public static ErrorIDLevel newInstance(SystemHMTable_SystemStateEntry ndParent, Identifier idErrorIdentifier, String stDescription, ErrorLevel enErrorLevel, ErrorCode enErrorCode) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ErrorIDLevel(ndParent, idErrorIdentifier, stDescription, enErrorLevel, enErrorCode);
	}
}
