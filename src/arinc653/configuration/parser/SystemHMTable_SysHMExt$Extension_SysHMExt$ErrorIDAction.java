package arinc653.configuration.parser;

import arinc653.configuration.parser.SystemAction;
import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for SysHM_Ext:Error_ID_Action node.
 */
public class SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction {

	/**
	 * Parent node.
	 */
	private SysHMExt$Extension ndParent;

	/**
	 * ErrorIdentifier attribute.
	 */
	private Identifier idErrorIdentifier;

	/**
	 * Description attribute.
	 */
	private String stDescription;

	/**
	 * Action attribute.
	 */
	private SystemAction enAction;

	/**
	 * Constructor.
	 */
	private SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction() {
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
	 * @param enAction
	 *            Action.
	 */
	private SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction(SysHMExt$Extension ndParent, Identifier idErrorIdentifier, String stDescription, SystemAction enAction) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idErrorIdentifier = idErrorIdentifier;
		this.stDescription = stDescription;
		this.enAction = enAction;

		// Adds to parent
		if (!ndParent.addSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction(this)) {
			throw new ConfigurationException("SysHM_Ext:Error_ID_Action cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public SysHMExt$Extension getParent() {
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
	 * Action getter.
	 */
	public SystemAction getAction() {
		return this.enAction;
	}

	/**
	 * Action setter.
	 */
	public void setAction(SystemAction enAction) {
		this.enAction = enAction;
	}

	@Override
	public int hashCode() {
		return (idErrorIdentifier != null ? idErrorIdentifier.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction)) {
			return false;
		}

		// Casts object
		SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction = (SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction) obObject;

		// Verifies identifiers
		if ((ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.getErrorIdentifier() == null) || (idErrorIdentifier == null)) {
			return ((ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.getErrorIdentifier() == null) && (idErrorIdentifier == null));
		}

		// Verifies identifiers
		if (ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.getErrorIdentifier().equals(idErrorIdentifier)) {
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
	 *            SysHM_Ext:Extension.
	 */
	public static SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction cmdLoad(Node ndNode, SysHMExt$Extension ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_SYSTEMHMTABLE_SYSHMEXT$EXTENSION_SYSHMEXT$ERRORIDACTION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a SysHM_Ext:Error_ID_Action");
		}

		// Creates node
		SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction = new SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction();

		// Sets parent
		ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.ndParent = ndParent;

		// Loads attribute
		try {
			ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.idErrorIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_ERRORIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ErrorIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.idErrorIdentifier == null) {
			throw new ConfigurationException("Required attribute ErrorIdentifier not found");
		}

		// Loads attribute
		ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.stDescription = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_DESCRIPTION);

		// Loads attribute
		try {
			ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.enAction = ConfigurationUtilities.getEnumerationAttribute(ndNode, Module.ATTRIBUTENAME_ACTION, SystemAction.class);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute Action value cannot be parsed");
		}

		// Verifies required attribute
		if (ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.enAction == null) {
			throw new ConfigurationException("Required attribute Action not found");
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
			if (Module.ATTRIBUTENAME_ACTION.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in SysHM_Ext:Error_ID_Action node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in SysHM_Ext:Error_ID_Action node");
		}

		// Returns node
		return ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction
	 *            SysHM_Ext:Error_ID_Action.
	 */
	public static Element cmdSave(Element elParent, SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction) throws ConfigurationException {

		// Creates element
		Element elSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction = elParent.getOwnerDocument().createElement(Module.NODENAME_SYSTEMHMTABLE_SYSHMEXT$EXTENSION_SYSHMEXT$ERRORIDACTION);

		// Verifies required attribute
		if (ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.getErrorIdentifier() == null) {
			throw new ConfigurationException("Required attribute ErrorIdentifier not assigned in SysHM_Ext:Error_ID_Action");
		}

		// Saves attribute
		elSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.setAttribute(Module.ATTRIBUTENAME_ERRORIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.getErrorIdentifier()));

		// Verifies attribute
		if (ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.getDescription() != null) {

			// Saves attribute
			elSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.setAttribute(Module.ATTRIBUTENAME_DESCRIPTION, ConfigurationUtilities.getAttributeString(ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.getDescription()));
		}

		// Verifies required attribute
		if (ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.getAction() == null) {
			throw new ConfigurationException("Required attribute Action not assigned in SysHM_Ext:Error_ID_Action");
		}

		// Saves attribute
		elSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.setAttribute(Module.ATTRIBUTENAME_ACTION, ConfigurationUtilities.getAttributeEnumeration(ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.getAction()));

		// Returns element
		return elSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction;
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
	 * @param enAction
	 *            Action.
	 */
	public static SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction newInstance(SysHMExt$Extension ndParent, Identifier idErrorIdentifier, String stDescription, SystemAction enAction) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction(ndParent, idErrorIdentifier, stDescription, enAction);
	}
}
