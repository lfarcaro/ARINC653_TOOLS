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
public class SystemHMTable_SystemStateEntry {

	/**
	 * Parent node.
	 */
	private SystemHMTable ndParent;

	/**
	 * SystemState attribute.
	 */
	private Identifier idSystemState;

	/**
	 * Description attribute.
	 */
	private String stDescription;

	/**
	 * Error_ID_Level node list.
	 */
	private List<ErrorIDLevel> lsErrorIDLevel = new LinkedList<ErrorIDLevel>();

	/**
	 * Error_ID_Level node map.
	 */
	private Map<Identifier, ErrorIDLevel> mpErrorIDLevel = new HashMap<Identifier, ErrorIDLevel>();

	/**
	 * Constructor.
	 */
	private SystemHMTable_SystemStateEntry() {
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
	private SystemHMTable_SystemStateEntry(SystemHMTable ndParent, Identifier idSystemState, String stDescription) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idSystemState = idSystemState;
		this.stDescription = stDescription;

		// Adds to parent
		if (!ndParent.addSystemHMTable_SystemStateEntry(this)) {
			throw new ConfigurationException("System_State_Entry cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public SystemHMTable getParent() {
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
	 * Error_ID_Level adder.
	 * 
	 * @param ndErrorIDLevel
	 *            Error_ID_Level.
	 */
	public boolean addErrorIDLevel(ErrorIDLevel ndErrorIDLevel) {

		// Verifies node
		if (ndErrorIDLevel == null) {
			return false;
		}

		// Verifies identifier
		if (mpErrorIDLevel.containsKey(ndErrorIDLevel.getErrorIdentifier())) {
			return false;
		}

		// Adds node
		lsErrorIDLevel.add(ndErrorIDLevel);

		// Maps node
		mpErrorIDLevel.put(ndErrorIDLevel.getErrorIdentifier(), ndErrorIDLevel);
		return true;
	}

	/**
	 * Error_ID_Level getter.
	 * 
	 * @param idErrorIdentifier
	 *            ErrorIdentifier.
	 */
	public ErrorIDLevel getErrorIDLevel(Identifier idErrorIdentifier) {
		return (idErrorIdentifier == null ? null : this.mpErrorIDLevel.get(idErrorIdentifier));
	}

	/**
	 * Error_ID_Level ErrorIdentifier set getter.
	 */
	public Set<Identifier> getErrorIDLevelErrorIdentifierSet() {
		return this.mpErrorIDLevel.keySet();
	}

	/**
	 * Error_ID_Level list getter.
	 */
	public List<ErrorIDLevel> getErrorIDLevelList() {
		return new LinkedList<ErrorIDLevel>(this.lsErrorIDLevel);
	}

	@Override
	public int hashCode() {
		return (idSystemState != null ? idSystemState.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof SystemHMTable_SystemStateEntry)) {
			return false;
		}

		// Casts object
		SystemHMTable_SystemStateEntry ndSystemHMTable_SystemStateEntry = (SystemHMTable_SystemStateEntry) obObject;

		// Verifies identifiers
		if ((ndSystemHMTable_SystemStateEntry.getSystemState() == null) || (idSystemState == null)) {
			return ((ndSystemHMTable_SystemStateEntry.getSystemState() == null) && (idSystemState == null));
		}

		// Verifies identifiers
		if (ndSystemHMTable_SystemStateEntry.getSystemState().equals(idSystemState)) {
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
	 *            System_HM_Table.
	 */
	public static SystemHMTable_SystemStateEntry cmdLoad(Node ndNode, SystemHMTable ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_SYSTEMHMTABLE_SYSTEMSTATEENTRY.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a System_State_Entry");
		}

		// Creates node
		SystemHMTable_SystemStateEntry ndSystemHMTable_SystemStateEntry = new SystemHMTable_SystemStateEntry();

		// Sets parent
		ndSystemHMTable_SystemStateEntry.ndParent = ndParent;

		// Loads attribute
		try {
			ndSystemHMTable_SystemStateEntry.idSystemState = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMSTATE);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemState value cannot be parsed");
		}

		// Verifies required attribute
		if (ndSystemHMTable_SystemStateEntry.idSystemState == null) {
			throw new ConfigurationException("Required attribute SystemState not found");
		}

		// Loads attribute
		ndSystemHMTable_SystemStateEntry.stDescription = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_DESCRIPTION);

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
			if (Module.NODENAME_ERRORIDLEVEL.equals(ndChildNode.getNodeName())) {

				// Loads child
				ErrorIDLevel ndErrorIDLevel = ErrorIDLevel.cmdLoad(ndChildNode, ndSystemHMTable_SystemStateEntry);

				// Verifies child
				if (ndErrorIDLevel == null) {
					throw new ConfigurationException("Error while loading a Error_ID_Level node (System_State_Entry child)");
				}

				// Adds child
				ndSystemHMTable_SystemStateEntry.addErrorIDLevel(ndErrorIDLevel);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in System_State_Entry node");
		}

		// Returns node
		return ndSystemHMTable_SystemStateEntry;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndSystemHMTable_SystemStateEntry
	 *            System_State_Entry.
	 */
	public static Element cmdSave(Element elParent, SystemHMTable_SystemStateEntry ndSystemHMTable_SystemStateEntry) throws ConfigurationException {

		// Creates element
		Element elSystemHMTable_SystemStateEntry = elParent.getOwnerDocument().createElement(Module.NODENAME_SYSTEMHMTABLE_SYSTEMSTATEENTRY);

		// Verifies required attribute
		if (ndSystemHMTable_SystemStateEntry.getSystemState() == null) {
			throw new ConfigurationException("Required attribute SystemState not assigned in System_State_Entry");
		}

		// Saves attribute
		elSystemHMTable_SystemStateEntry.setAttribute(Module.ATTRIBUTENAME_SYSTEMSTATE, ConfigurationUtilities.getAttributeIdentifier(ndSystemHMTable_SystemStateEntry.getSystemState()));

		// Verifies attribute
		if (ndSystemHMTable_SystemStateEntry.getDescription() != null) {

			// Saves attribute
			elSystemHMTable_SystemStateEntry.setAttribute(Module.ATTRIBUTENAME_DESCRIPTION, ConfigurationUtilities.getAttributeString(ndSystemHMTable_SystemStateEntry.getDescription()));
		}

		// Iterates children
		Iterator<ErrorIDLevel> itErrorIDLevel = ndSystemHMTable_SystemStateEntry.getErrorIDLevelList().iterator();
		while (itErrorIDLevel.hasNext()) {

			// Appends child
			elSystemHMTable_SystemStateEntry.appendChild(ErrorIDLevel.cmdSave(elSystemHMTable_SystemStateEntry, itErrorIDLevel.next()));
		}

		// Returns element
		return elSystemHMTable_SystemStateEntry;
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
	public static SystemHMTable_SystemStateEntry newInstance(SystemHMTable ndParent, Identifier idSystemState, String stDescription) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new SystemHMTable_SystemStateEntry(ndParent, idSystemState, stDescription);
	}
}
