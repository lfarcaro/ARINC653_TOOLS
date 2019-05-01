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
public class ModuleHMTable_SystemStateEntry {

	/**
	 * Parent node.
	 */
	private ModuleHMTable ndParent;

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
	private List<ModuleHMTable_SystemStateEntry_ErrorIDAction> lsModuleHMTable_SystemStateEntry_ErrorIDAction = new LinkedList<ModuleHMTable_SystemStateEntry_ErrorIDAction>();

	/**
	 * Error_ID_Action node map.
	 */
	private Map<Identifier, ModuleHMTable_SystemStateEntry_ErrorIDAction> mpModuleHMTable_SystemStateEntry_ErrorIDAction = new HashMap<Identifier, ModuleHMTable_SystemStateEntry_ErrorIDAction>();

	/**
	 * Constructor.
	 */
	private ModuleHMTable_SystemStateEntry() {
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
	private ModuleHMTable_SystemStateEntry(ModuleHMTable ndParent, Identifier idSystemState, String stDescription) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idSystemState = idSystemState;
		this.stDescription = stDescription;

		// Adds to parent
		if (!ndParent.addModuleHMTable_SystemStateEntry(this)) {
			throw new ConfigurationException("System_State_Entry cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public ModuleHMTable getParent() {
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
	 * @param ndModuleHMTable_SystemStateEntry_ErrorIDAction
	 *            Error_ID_Action.
	 */
	public boolean addModuleHMTable_SystemStateEntry_ErrorIDAction(ModuleHMTable_SystemStateEntry_ErrorIDAction ndModuleHMTable_SystemStateEntry_ErrorIDAction) {

		// Verifies node
		if (ndModuleHMTable_SystemStateEntry_ErrorIDAction == null) {
			return false;
		}

		// Verifies identifier
		if (mpModuleHMTable_SystemStateEntry_ErrorIDAction.containsKey(ndModuleHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier())) {
			return false;
		}

		// Adds node
		lsModuleHMTable_SystemStateEntry_ErrorIDAction.add(ndModuleHMTable_SystemStateEntry_ErrorIDAction);

		// Maps node
		mpModuleHMTable_SystemStateEntry_ErrorIDAction.put(ndModuleHMTable_SystemStateEntry_ErrorIDAction.getErrorIdentifier(), ndModuleHMTable_SystemStateEntry_ErrorIDAction);
		return true;
	}

	/**
	 * Error_ID_Action getter.
	 * 
	 * @param idErrorIdentifier
	 *            ErrorIdentifier.
	 */
	public ModuleHMTable_SystemStateEntry_ErrorIDAction getModuleHMTable_SystemStateEntry_ErrorIDAction(Identifier idErrorIdentifier) {
		return (idErrorIdentifier == null ? null : this.mpModuleHMTable_SystemStateEntry_ErrorIDAction.get(idErrorIdentifier));
	}

	/**
	 * Error_ID_Action ErrorIdentifier set getter.
	 */
	public Set<Identifier> getModuleHMTable_SystemStateEntry_ErrorIDActionErrorIdentifierSet() {
		return this.mpModuleHMTable_SystemStateEntry_ErrorIDAction.keySet();
	}

	/**
	 * Error_ID_Action list getter.
	 */
	public List<ModuleHMTable_SystemStateEntry_ErrorIDAction> getModuleHMTable_SystemStateEntry_ErrorIDActionList() {
		return new LinkedList<ModuleHMTable_SystemStateEntry_ErrorIDAction>(this.lsModuleHMTable_SystemStateEntry_ErrorIDAction);
	}

	@Override
	public int hashCode() {
		return (idSystemState != null ? idSystemState.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof ModuleHMTable_SystemStateEntry)) {
			return false;
		}

		// Casts object
		ModuleHMTable_SystemStateEntry ndModuleHMTable_SystemStateEntry = (ModuleHMTable_SystemStateEntry) obObject;

		// Verifies identifiers
		if ((ndModuleHMTable_SystemStateEntry.getSystemState() == null) || (idSystemState == null)) {
			return ((ndModuleHMTable_SystemStateEntry.getSystemState() == null) && (idSystemState == null));
		}

		// Verifies identifiers
		if (ndModuleHMTable_SystemStateEntry.getSystemState().equals(idSystemState)) {
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
	 *            Module_HM_Table.
	 */
	public static ModuleHMTable_SystemStateEntry cmdLoad(Node ndNode, ModuleHMTable ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODULEHMTABLE_SYSTEMSTATEENTRY.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a System_State_Entry");
		}

		// Creates node
		ModuleHMTable_SystemStateEntry ndModuleHMTable_SystemStateEntry = new ModuleHMTable_SystemStateEntry();

		// Sets parent
		ndModuleHMTable_SystemStateEntry.ndParent = ndParent;

		// Loads attribute
		try {
			ndModuleHMTable_SystemStateEntry.idSystemState = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMSTATE);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemState value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModuleHMTable_SystemStateEntry.idSystemState == null) {
			throw new ConfigurationException("Required attribute SystemState not found");
		}

		// Loads attribute
		ndModuleHMTable_SystemStateEntry.stDescription = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_DESCRIPTION);

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
			if (Module.NODENAME_MODULEHMTABLE_SYSTEMSTATEENTRY_ERRORIDACTION.equals(ndChildNode.getNodeName())) {

				// Loads child
				ModuleHMTable_SystemStateEntry_ErrorIDAction ndModuleHMTable_SystemStateEntry_ErrorIDAction = ModuleHMTable_SystemStateEntry_ErrorIDAction.cmdLoad(ndChildNode, ndModuleHMTable_SystemStateEntry);

				// Verifies child
				if (ndModuleHMTable_SystemStateEntry_ErrorIDAction == null) {
					throw new ConfigurationException("Error while loading a Error_ID_Action node (System_State_Entry child)");
				}

				// Adds child
				ndModuleHMTable_SystemStateEntry.addModuleHMTable_SystemStateEntry_ErrorIDAction(ndModuleHMTable_SystemStateEntry_ErrorIDAction);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in System_State_Entry node");
		}

		// Returns node
		return ndModuleHMTable_SystemStateEntry;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModuleHMTable_SystemStateEntry
	 *            System_State_Entry.
	 */
	public static Element cmdSave(Element elParent, ModuleHMTable_SystemStateEntry ndModuleHMTable_SystemStateEntry) throws ConfigurationException {

		// Creates element
		Element elModuleHMTable_SystemStateEntry = elParent.getOwnerDocument().createElement(Module.NODENAME_MODULEHMTABLE_SYSTEMSTATEENTRY);

		// Verifies required attribute
		if (ndModuleHMTable_SystemStateEntry.getSystemState() == null) {
			throw new ConfigurationException("Required attribute SystemState not assigned in System_State_Entry");
		}

		// Saves attribute
		elModuleHMTable_SystemStateEntry.setAttribute(Module.ATTRIBUTENAME_SYSTEMSTATE, ConfigurationUtilities.getAttributeIdentifier(ndModuleHMTable_SystemStateEntry.getSystemState()));

		// Verifies attribute
		if (ndModuleHMTable_SystemStateEntry.getDescription() != null) {

			// Saves attribute
			elModuleHMTable_SystemStateEntry.setAttribute(Module.ATTRIBUTENAME_DESCRIPTION, ConfigurationUtilities.getAttributeString(ndModuleHMTable_SystemStateEntry.getDescription()));
		}

		// Iterates children
		Iterator<ModuleHMTable_SystemStateEntry_ErrorIDAction> itModuleHMTable_SystemStateEntry_ErrorIDAction = ndModuleHMTable_SystemStateEntry.getModuleHMTable_SystemStateEntry_ErrorIDActionList().iterator();
		while (itModuleHMTable_SystemStateEntry_ErrorIDAction.hasNext()) {

			// Appends child
			elModuleHMTable_SystemStateEntry.appendChild(ModuleHMTable_SystemStateEntry_ErrorIDAction.cmdSave(elModuleHMTable_SystemStateEntry, itModuleHMTable_SystemStateEntry_ErrorIDAction.next()));
		}

		// Returns element
		return elModuleHMTable_SystemStateEntry;
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
	public static ModuleHMTable_SystemStateEntry newInstance(ModuleHMTable ndParent, Identifier idSystemState, String stDescription) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ModuleHMTable_SystemStateEntry(ndParent, idSystemState, stDescription);
	}
}
