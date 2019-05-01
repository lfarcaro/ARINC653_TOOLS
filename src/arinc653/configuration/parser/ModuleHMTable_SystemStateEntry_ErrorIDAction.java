package arinc653.configuration.parser;

import arinc653.configuration.parser.ModuleAction;
import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Error_ID_Action node.
 */
public class ModuleHMTable_SystemStateEntry_ErrorIDAction {

	/**
	 * Parent node.
	 */
	private ModuleHMTable_SystemStateEntry ndParent;

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
	private ModuleAction enAction;

	/**
	 * Constructor.
	 */
	private ModuleHMTable_SystemStateEntry_ErrorIDAction() {
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
	private ModuleHMTable_SystemStateEntry_ErrorIDAction(ModuleHMTable_SystemStateEntry ndParent, Identifier idErrorIdentifier, String stDescription, ModuleAction enAction) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idErrorIdentifier = idErrorIdentifier;
		this.stDescription = stDescription;
		this.enAction = enAction;

		// Adds to parent
		if (!ndParent.addModuleHMTable_SystemStateEntry_ErrorIDAction(this)) {
			throw new ConfigurationException("Error_ID_Action cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public ModuleHMTable_SystemStateEntry getParent() {
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
	public ModuleAction getAction() {
		return this.enAction;
	}

	/**
	 * Action setter.
	 */
	public void setAction(ModuleAction enAction) {
		this.enAction = enAction;
	}

	@Override
	public int hashCode() {
		return (idErrorIdentifier != null ? idErrorIdentifier.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof ModuleHMTable_SystemStateEntry_ErrorIDAction)) {
			return false;
		}

		// Casts object
		ModuleHMTable_SystemStateEntry_ErrorIDAction ndModuleHMTable_SystemStateEntry_ErrorIDAction = (ModuleHMTable_SystemStateEntry_ErrorIDAction) obObject;

		// Verifies identifiers
		if ((ndModuleHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier() == null) || (idErrorIdentifier == null)) {
			return ((ndModuleHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier() == null) && (idErrorIdentifier == null));
		}

		// Verifies identifiers
		if (ndModuleHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier().equals(idErrorIdentifier)) {
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
	public static ModuleHMTable_SystemStateEntry_ErrorIDAction cmdLoad(Node ndNode, ModuleHMTable_SystemStateEntry ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODULEHMTABLE_SYSTEMSTATEENTRY_ERRORIDACTION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Error_ID_Action");
		}

		// Creates node
		ModuleHMTable_SystemStateEntry_ErrorIDAction ndModuleHMTable_SystemStateEntry_ErrorIDAction = new ModuleHMTable_SystemStateEntry_ErrorIDAction();

		// Sets parent
		ndModuleHMTable_SystemStateEntry_ErrorIDAction.ndParent = ndParent;

		// Loads attribute
		try {
			ndModuleHMTable_SystemStateEntry_ErrorIDAction.idErrorIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_ERRORIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ErrorIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModuleHMTable_SystemStateEntry_ErrorIDAction.idErrorIdentifier == null) {
			throw new ConfigurationException("Required attribute ErrorIdentifier not found");
		}

		// Loads attribute
		ndModuleHMTable_SystemStateEntry_ErrorIDAction.stDescription = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_DESCRIPTION);

		// Loads attribute
		try {
			ndModuleHMTable_SystemStateEntry_ErrorIDAction.enAction = ConfigurationUtilities.getEnumerationAttribute(ndNode, Module.ATTRIBUTENAME_ACTION, ModuleAction.class);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute Action value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModuleHMTable_SystemStateEntry_ErrorIDAction.enAction == null) {
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
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Error_ID_Action node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Error_ID_Action node");
		}

		// Returns node
		return ndModuleHMTable_SystemStateEntry_ErrorIDAction;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModuleHMTable_SystemStateEntry_ErrorIDAction
	 *            Error_ID_Action.
	 */
	public static Element cmdSave(Element elParent, ModuleHMTable_SystemStateEntry_ErrorIDAction ndModuleHMTable_SystemStateEntry_ErrorIDAction) throws ConfigurationException {

		// Creates element
		Element elModuleHMTable_SystemStateEntry_ErrorIDAction = elParent.getOwnerDocument().createElement(Module.NODENAME_MODULEHMTABLE_SYSTEMSTATEENTRY_ERRORIDACTION);

		// Verifies required attribute
		if (ndModuleHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier() == null) {
			throw new ConfigurationException("Required attribute ErrorIdentifier not assigned in Error_ID_Action");
		}

		// Saves attribute
		elModuleHMTable_SystemStateEntry_ErrorIDAction.setAttribute(Module.ATTRIBUTENAME_ERRORIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndModuleHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier()));

		// Verifies attribute
		if (ndModuleHMTable_SystemStateEntry_ErrorIDAction.getDescription() != null) {

			// Saves attribute
			elModuleHMTable_SystemStateEntry_ErrorIDAction.setAttribute(Module.ATTRIBUTENAME_DESCRIPTION, ConfigurationUtilities.getAttributeString(ndModuleHMTable_SystemStateEntry_ErrorIDAction.getDescription()));
		}

		// Verifies required attribute
		if (ndModuleHMTable_SystemStateEntry_ErrorIDAction.getAction() == null) {
			throw new ConfigurationException("Required attribute Action not assigned in Error_ID_Action");
		}

		// Saves attribute
		elModuleHMTable_SystemStateEntry_ErrorIDAction.setAttribute(Module.ATTRIBUTENAME_ACTION, ConfigurationUtilities.getAttributeEnumeration(ndModuleHMTable_SystemStateEntry_ErrorIDAction.getAction()));

		// Returns element
		return elModuleHMTable_SystemStateEntry_ErrorIDAction;
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
	public static ModuleHMTable_SystemStateEntry_ErrorIDAction newInstance(ModuleHMTable_SystemStateEntry ndParent, Identifier idErrorIdentifier, String stDescription, ModuleAction enAction) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ModuleHMTable_SystemStateEntry_ErrorIDAction(ndParent, idErrorIdentifier, stDescription, enAction);
	}
}
