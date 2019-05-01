package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for System_State_Entry node.
 */
public class PartitionHMTable_SystemStateEntry {

	/**
	 * Parent node.
	 */
	private PartitionHMTable ndParent;

	/**
	 * SystemState attribute.
	 */
	private Identifier idSystemState;

	/**
	 * Description attribute.
	 */
	private String stDescription;

	/**
	 * Error_ID_Action node list.
	 */
	private List<PartitionHMTable_SystemStateEntry_ErrorIDAction> lsPartitionHMTable_SystemStateEntry_ErrorIDAction = new LinkedList<PartitionHMTable_SystemStateEntry_ErrorIDAction>();

	/**
	 * Error_ID_Action node map.
	 */
	private Map<Identifier, PartitionHMTable_SystemStateEntry_ErrorIDAction> mpPartitionHMTable_SystemStateEntry_ErrorIDAction = new HashMap<Identifier, PartitionHMTable_SystemStateEntry_ErrorIDAction>();

	/**
	 * Constructor.
	 */
	private PartitionHMTable_SystemStateEntry() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idSystemState
	 *            SystemState.
	 * @param stDescription
	 *            Description.
	 */
	private PartitionHMTable_SystemStateEntry(PartitionHMTable ndParent, Identifier idSystemState, String stDescription) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idSystemState = idSystemState;
		this.stDescription = stDescription;

		// Adds to parent
		if (!ndParent.addPartitionHMTable_SystemStateEntry(this)) {
			throw new ConfigurationException("System_State_Entry cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public PartitionHMTable getParent() {
		return ndParent;
	}

	/**
	 * SystemState getter.
	 */
	public Identifier getSystemState() {
		return this.idSystemState;
	}

	/**
	 * SystemState setter.
	 */
	public void setSystemState(Identifier idSystemState) {
		this.idSystemState = idSystemState;
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
	 * Error_ID_Action adder.
	 * 
	 * @param ndPartitionHMTable_SystemStateEntry_ErrorIDAction
	 *            Error_ID_Action.
	 */
	public boolean addPartitionHMTable_SystemStateEntry_ErrorIDAction(PartitionHMTable_SystemStateEntry_ErrorIDAction ndPartitionHMTable_SystemStateEntry_ErrorIDAction) {

		// Verifies node
		if (ndPartitionHMTable_SystemStateEntry_ErrorIDAction == null) {
			return false;
		}

		// Verifies identifier
		if (mpPartitionHMTable_SystemStateEntry_ErrorIDAction.containsKey(ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier())) {
			return false;
		}

		// Adds node
		lsPartitionHMTable_SystemStateEntry_ErrorIDAction.add(ndPartitionHMTable_SystemStateEntry_ErrorIDAction);

		// Maps node
		mpPartitionHMTable_SystemStateEntry_ErrorIDAction.put(ndPartitionHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier(), ndPartitionHMTable_SystemStateEntry_ErrorIDAction);
		return true;
	}

	/**
	 * Error_ID_Action getter.
	 * 
	 * @param idErrorIdentifier
	 *            ErrorIdentifier.
	 */
	public PartitionHMTable_SystemStateEntry_ErrorIDAction getPartitionHMTable_SystemStateEntry_ErrorIDAction(Identifier idErrorIdentifier) {
		return (idErrorIdentifier == null ? null : this.mpPartitionHMTable_SystemStateEntry_ErrorIDAction.get(idErrorIdentifier));
	}

	/**
	 * Error_ID_Action ErrorIdentifier set getter.
	 */
	public Set<Identifier> getPartitionHMTable_SystemStateEntry_ErrorIDActionErrorIdentifierSet() {
		return this.mpPartitionHMTable_SystemStateEntry_ErrorIDAction.keySet();
	}

	/**
	 * Error_ID_Action list getter.
	 */
	public List<PartitionHMTable_SystemStateEntry_ErrorIDAction> getPartitionHMTable_SystemStateEntry_ErrorIDActionList() {
		return new LinkedList<PartitionHMTable_SystemStateEntry_ErrorIDAction>(this.lsPartitionHMTable_SystemStateEntry_ErrorIDAction);
	}

	@Override
	public int hashCode() {
		return (idSystemState != null ? idSystemState.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof PartitionHMTable_SystemStateEntry)) {
			return false;
		}

		// Casts object
		PartitionHMTable_SystemStateEntry ndPartitionHMTable_SystemStateEntry = (PartitionHMTable_SystemStateEntry) obObject;

		// Verifies identifiers
		if ((ndPartitionHMTable_SystemStateEntry.getSystemState() == null) || (idSystemState == null)) {
			return ((ndPartitionHMTable_SystemStateEntry.getSystemState() == null) && (idSystemState == null));
		}

		// Verifies identifiers
		if (ndPartitionHMTable_SystemStateEntry.getSystemState().equals(idSystemState)) {
			return true;
		}

		// Not equal
		return false;
	}

	@Override
	public String toString() {
		return (idSystemState != null ? idSystemState.toString() : super.toString());
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Partition_HM_Table.
	 */
	public static PartitionHMTable_SystemStateEntry cmdLoad(Node ndNode, PartitionHMTable ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_PARTITIONHMTABLE_SYSTEMSTATEENTRY.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a System_State_Entry");
		}

		// Creates node
		PartitionHMTable_SystemStateEntry ndPartitionHMTable_SystemStateEntry = new PartitionHMTable_SystemStateEntry();

		// Sets parent
		ndPartitionHMTable_SystemStateEntry.ndParent = ndParent;

		// Loads attribute
		try {
			ndPartitionHMTable_SystemStateEntry.idSystemState = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMSTATE);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemState value cannot be parsed");
		}

		// Verifies required attribute
		if (ndPartitionHMTable_SystemStateEntry.idSystemState == null) {
			throw new ConfigurationException("Required attribute SystemState not found");
		}

		// Loads attribute
		ndPartitionHMTable_SystemStateEntry.stDescription = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_DESCRIPTION);

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
			if (Module.ATTRIBUTENAME_SYSTEMSTATE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_DESCRIPTION.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in System_State_Entry node");
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

			// Verifies node
			if (Module.NODENAME_PARTITIONHMTABLE_SYSTEMSTATEENTRY_ERRORIDACTION.equals(ndChildNode.getNodeName())) {

				// Loads child
				PartitionHMTable_SystemStateEntry_ErrorIDAction ndPartitionHMTable_SystemStateEntry_ErrorIDAction = PartitionHMTable_SystemStateEntry_ErrorIDAction.cmdLoad(ndChildNode, ndPartitionHMTable_SystemStateEntry);

				// Verifies child
				if (ndPartitionHMTable_SystemStateEntry_ErrorIDAction == null) {
					throw new ConfigurationException("Error while loading a Error_ID_Action node (System_State_Entry child)");
				}

				// Adds child
				ndPartitionHMTable_SystemStateEntry.addPartitionHMTable_SystemStateEntry_ErrorIDAction(ndPartitionHMTable_SystemStateEntry_ErrorIDAction);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in System_State_Entry node");
		}

		// Returns node
		return ndPartitionHMTable_SystemStateEntry;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndPartitionHMTable_SystemStateEntry
	 *            System_State_Entry.
	 */
	public static Element cmdSave(Element elParent, PartitionHMTable_SystemStateEntry ndPartitionHMTable_SystemStateEntry) throws ConfigurationException {

		// Creates element
		Element elPartitionHMTable_SystemStateEntry = elParent.getOwnerDocument().createElement(Module.NODENAME_PARTITIONHMTABLE_SYSTEMSTATEENTRY);

		// Verifies required attribute
		if (ndPartitionHMTable_SystemStateEntry.getSystemState() == null) {
			throw new ConfigurationException("Required attribute SystemState not assigned in System_State_Entry");
		}

		// Saves attribute
		elPartitionHMTable_SystemStateEntry.setAttribute(Module.ATTRIBUTENAME_SYSTEMSTATE, ConfigurationUtilities.getAttributeIdentifier(ndPartitionHMTable_SystemStateEntry.getSystemState()));

		// Verifies attribute
		if (ndPartitionHMTable_SystemStateEntry.getDescription() != null) {

			// Saves attribute
			elPartitionHMTable_SystemStateEntry.setAttribute(Module.ATTRIBUTENAME_DESCRIPTION, ConfigurationUtilities.getAttributeString(ndPartitionHMTable_SystemStateEntry.getDescription()));
		}

		// Iterates children
		Iterator<PartitionHMTable_SystemStateEntry_ErrorIDAction> itPartitionHMTable_SystemStateEntry_ErrorIDAction = ndPartitionHMTable_SystemStateEntry.getPartitionHMTable_SystemStateEntry_ErrorIDActionList().iterator();
		while (itPartitionHMTable_SystemStateEntry_ErrorIDAction.hasNext()) {

			// Appends child
			elPartitionHMTable_SystemStateEntry.appendChild(PartitionHMTable_SystemStateEntry_ErrorIDAction.cmdSave(elPartitionHMTable_SystemStateEntry, itPartitionHMTable_SystemStateEntry_ErrorIDAction.next()));
		}

		// Returns element
		return elPartitionHMTable_SystemStateEntry;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idSystemState
	 *            SystemState.
	 * @param stDescription
	 *            Description.
	 */
	public static PartitionHMTable_SystemStateEntry newInstance(PartitionHMTable ndParent, Identifier idSystemState, String stDescription) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new PartitionHMTable_SystemStateEntry(ndParent, idSystemState, stDescription);
	}
}
