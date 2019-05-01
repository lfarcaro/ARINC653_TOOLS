package arinc653.configuration.parser;

import arinc653.configuration.parser.PartitionAction;
import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Error_ID_Action node.
 */
public class PartitionHMTable_SystemStateEntry_ErrorIDAction {

	/**
	 * Parent node.
	 */
	private PartitionHMTable_SystemStateEntry ndParent;

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
	private PartitionAction enAction;

	/**
	 * Other attribute map.
	 */
	private Map<String, String> mpOtherAttribute = new HashMap<String, String>();

	/**
	 * Constructor.
	 */
	private PartitionHMTable_SystemStateEntry_ErrorIDAction() {
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
	private PartitionHMTable_SystemStateEntry_ErrorIDAction(PartitionHMTable_SystemStateEntry ndParent, Identifier idErrorIdentifier, String stDescription, PartitionAction enAction) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idErrorIdentifier = idErrorIdentifier;
		this.stDescription = stDescription;
		this.enAction = enAction;

		// Adds to parent
		if (!ndParent.addPartitionHMTable_SystemStateEntry_ErrorIDAction(this)) {
			throw new ConfigurationException("Error_ID_Action cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public PartitionHMTable_SystemStateEntry getParent() {
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
	public PartitionAction getAction() {
		return this.enAction;
	}

	/**
	 * Action setter.
	 */
	public void setAction(PartitionAction enAction) {
		this.enAction = enAction;
	}

	/**
	 * Other attribute getter.
	 */
	public String getOtherAttribute(String stAttribute) {

		// Verifies attribute
		if (stAttribute == null) {
			return null;
		}

		// Gets other attribute
		return this.mpOtherAttribute.get(stAttribute.intern());
	}

	/**
	 * Other attribute setter.
	 */
	public void setOtherAttribute(String stAttribute, String stValue) {

		// Verifies attribute
		if (stAttribute == null) {
			return;
		}

		// Verifies value
		if (stValue != null) {

			// Sets other attribute
			this.mpOtherAttribute.put(stAttribute.intern(), stValue);
		} else {

			// Removes other attribute
			this.mpOtherAttribute.remove(stAttribute.intern());
		}
	}

	/**
	 * Other attributes getter.
	 */
	public Map<String, String> getOtherAttributes() {

		// Returns a map copy
		return new HashMap<String, String>(this.mpOtherAttribute);
	}

	@Override
	public int hashCode() {
		return (idErrorIdentifier != null ? idErrorIdentifier.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof PartitionHMTable_SystemStateEntry_ErrorIDAction)) {
			return false;
		}

		// Casts object
		PartitionHMTable_SystemStateEntry_ErrorIDAction ndPartitionHMTable_SystemStateEntry_ErrorIDAction = (PartitionHMTable_SystemStateEntry_ErrorIDAction) obObject;

		// Verifies identifiers
		if ((ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier() == null) || (idErrorIdentifier == null)) {
			return ((ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier() == null) && (idErrorIdentifier == null));
		}

		// Verifies identifiers
		if (ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier().equals(idErrorIdentifier)) {
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
	public static PartitionHMTable_SystemStateEntry_ErrorIDAction cmdLoad(Node ndNode, PartitionHMTable_SystemStateEntry ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_PARTITIONHMTABLE_SYSTEMSTATEENTRY_ERRORIDACTION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Error_ID_Action");
		}

		// Creates node
		PartitionHMTable_SystemStateEntry_ErrorIDAction ndPartitionHMTable_SystemStateEntry_ErrorIDAction = new PartitionHMTable_SystemStateEntry_ErrorIDAction();

		// Sets parent
		ndPartitionHMTable_SystemStateEntry_ErrorIDAction.ndParent = ndParent;

		// Loads attribute
		try {
			ndPartitionHMTable_SystemStateEntry_ErrorIDAction.idErrorIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_ERRORIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ErrorIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndPartitionHMTable_SystemStateEntry_ErrorIDAction.idErrorIdentifier == null) {
			throw new ConfigurationException("Required attribute ErrorIdentifier not found");
		}

		// Loads attribute
		ndPartitionHMTable_SystemStateEntry_ErrorIDAction.stDescription = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_DESCRIPTION);

		// Loads attribute
		try {
			ndPartitionHMTable_SystemStateEntry_ErrorIDAction.enAction = ConfigurationUtilities.getEnumerationAttribute(ndNode, Module.ATTRIBUTENAME_ACTION, PartitionAction.class);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute Action value cannot be parsed");
		}

		// Verifies required attribute
		if (ndPartitionHMTable_SystemStateEntry_ErrorIDAction.enAction == null) {
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

			// Sets other attribute
			ndPartitionHMTable_SystemStateEntry_ErrorIDAction.mpOtherAttribute.put(ndAttribute.getNodeName().intern(), ndAttribute.getNodeValue());
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
		return ndPartitionHMTable_SystemStateEntry_ErrorIDAction;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndPartitionHMTable_SystemStateEntry_ErrorIDAction
	 *            Error_ID_Action.
	 */
	public static Element cmdSave(Element elParent, PartitionHMTable_SystemStateEntry_ErrorIDAction ndPartitionHMTable_SystemStateEntry_ErrorIDAction) throws ConfigurationException {

		// Creates element
		Element elPartitionHMTable_SystemStateEntry_ErrorIDAction = elParent.getOwnerDocument().createElement(Module.NODENAME_PARTITIONHMTABLE_SYSTEMSTATEENTRY_ERRORIDACTION);

		// Verifies required attribute
		if (ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier() == null) {
			throw new ConfigurationException("Required attribute ErrorIdentifier not assigned in Error_ID_Action");
		}

		// Saves attribute
		elPartitionHMTable_SystemStateEntry_ErrorIDAction.setAttribute(Module.ATTRIBUTENAME_ERRORIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier()));

		// Verifies attribute
		if (ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getDescription() != null) {

			// Saves attribute
			elPartitionHMTable_SystemStateEntry_ErrorIDAction.setAttribute(Module.ATTRIBUTENAME_DESCRIPTION, ConfigurationUtilities.getAttributeString(ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getDescription()));
		}

		// Verifies required attribute
		if (ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getAction() == null) {
			throw new ConfigurationException("Required attribute Action not assigned in Error_ID_Action");
		}

		// Saves attribute
		elPartitionHMTable_SystemStateEntry_ErrorIDAction.setAttribute(Module.ATTRIBUTENAME_ACTION, ConfigurationUtilities.getAttributeEnumeration(ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getAction()));

		// Iterates other attributes
		Iterator<String> itOtherAttribute = ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getOtherAttributes().keySet().iterator();
		while (itOtherAttribute.hasNext()) {

			// Gets next attribute
			String stAttribute = itOtherAttribute.next();

			// Saves attribute
			elPartitionHMTable_SystemStateEntry_ErrorIDAction.setAttribute(stAttribute, ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getOtherAttribute(stAttribute));
		}

		// Returns element
		return elPartitionHMTable_SystemStateEntry_ErrorIDAction;
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
	public static PartitionHMTable_SystemStateEntry_ErrorIDAction newInstance(PartitionHMTable_SystemStateEntry ndParent, Identifier idErrorIdentifier, String stDescription, PartitionAction enAction) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new PartitionHMTable_SystemStateEntry_ErrorIDAction(ndParent, idErrorIdentifier, stDescription, enAction);
	}
}
