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
 * Auto-generated parser for Partition_HM_Table node.
 */
public class PartitionHMTable {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * PartitionIdentifier attribute.
	 */
	private Identifier idPartitionIdentifier;

	/**
	 * PartitionName attribute.
	 */
	private String stPartitionName;

	/**
	 * PartitionCallback attribute.
	 */
	private String stPartitionCallback;

	/**
	 * System_State_Entry node list.
	 */
	private List<PartitionHMTable_SystemStateEntry> lsPartitionHMTable_SystemStateEntry = new LinkedList<PartitionHMTable_SystemStateEntry>();

	/**
	 * System_State_Entry node map.
	 */
	private Map<Identifier, PartitionHMTable_SystemStateEntry> mpPartitionHMTable_SystemStateEntry = new HashMap<Identifier, PartitionHMTable_SystemStateEntry>();

	/**
	 * Part_HM_Ext:Extension node list.
	 */
	private List<PartHMExt$Extension> lsPartHMExt$Extension = new LinkedList<PartHMExt$Extension>();

	/**
	 * Constructor.
	 */
	private PartitionHMTable() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idPartitionIdentifier
	 *            PartitionIdentifier.
	 * @param stPartitionName
	 *            PartitionName.
	 * @param stPartitionCallback
	 *            PartitionCallback.
	 */
	private PartitionHMTable(Module ndParent, Identifier idPartitionIdentifier, String stPartitionName, String stPartitionCallback) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idPartitionIdentifier = idPartitionIdentifier;
		this.stPartitionName = stPartitionName;
		this.stPartitionCallback = stPartitionCallback;

		// Adds to parent
		if (!ndParent.addPartitionHMTable(this)) {
			throw new ConfigurationException("Partition_HM_Table cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
		return ndParent;
	}

	/**
	 * PartitionIdentifier getter.
	 */
	public Identifier getPartitionIdentifier() {
		return this.idPartitionIdentifier;
	}

	/**
	 * PartitionIdentifier setter.
	 */
	public void setPartitionIdentifier(Identifier idPartitionIdentifier) {
		this.idPartitionIdentifier = idPartitionIdentifier;
	}

	/**
	 * PartitionName getter.
	 */
	public String getPartitionName() {
		return this.stPartitionName;
	}

	/**
	 * PartitionName setter.
	 */
	public void setPartitionName(String stPartitionName) {
		this.stPartitionName = stPartitionName;
	}

	/**
	 * PartitionCallback getter.
	 */
	public String getPartitionCallback() {
		return this.stPartitionCallback;
	}

	/**
	 * PartitionCallback setter.
	 */
	public void setPartitionCallback(String stPartitionCallback) {
		this.stPartitionCallback = stPartitionCallback;
	}

	/**
	 * System_State_Entry adder.
	 * 
	 * @param ndPartitionHMTable_SystemStateEntry
	 *            System_State_Entry.
	 */
	public boolean addPartitionHMTable_SystemStateEntry(PartitionHMTable_SystemStateEntry ndPartitionHMTable_SystemStateEntry) {

		// Verifies node
		if (ndPartitionHMTable_SystemStateEntry == null) {
			return false;
		}

		// Verifies identifier
		if (mpPartitionHMTable_SystemStateEntry.containsKey(ndPartitionHMTable_SystemStateEntry.getSystemState())) {
			return false;
		}

		// Adds node
		lsPartitionHMTable_SystemStateEntry.add(ndPartitionHMTable_SystemStateEntry);

		// Maps node
		mpPartitionHMTable_SystemStateEntry.put(ndPartitionHMTable_SystemStateEntry.getSystemState(), ndPartitionHMTable_SystemStateEntry);
		return true;
	}

	/**
	 * System_State_Entry getter.
	 * 
	 * @param idSystemState
	 *            SystemState.
	 */
	public PartitionHMTable_SystemStateEntry getPartitionHMTable_SystemStateEntry(Identifier idSystemState) {
		return (idSystemState == null ? null : this.mpPartitionHMTable_SystemStateEntry.get(idSystemState));
	}

	/**
	 * System_State_Entry SystemState set getter.
	 */
	public Set<Identifier> getPartitionHMTable_SystemStateEntrySystemStateSet() {
		return this.mpPartitionHMTable_SystemStateEntry.keySet();
	}

	/**
	 * System_State_Entry list getter.
	 */
	public List<PartitionHMTable_SystemStateEntry> getPartitionHMTable_SystemStateEntryList() {
		return new LinkedList<PartitionHMTable_SystemStateEntry>(this.lsPartitionHMTable_SystemStateEntry);
	}

	/**
	 * Part_HM_Ext:Extension adder.
	 * 
	 * @param ndPartHMExt$Extension
	 *            Part_HM_Ext:Extension.
	 */
	public boolean addPartHMExt$Extension(PartHMExt$Extension ndPartHMExt$Extension) {

		// Verifies node
		if (ndPartHMExt$Extension == null) {
			return false;
		}

		// Adds node
		lsPartHMExt$Extension.add(ndPartHMExt$Extension);
		return true;
	}

	/**
	 * Part_HM_Ext:Extension list getter.
	 */
	public List<PartHMExt$Extension> getPartHMExt$ExtensionList() {
		return new LinkedList<PartHMExt$Extension>(this.lsPartHMExt$Extension);
	}

	@Override
	public int hashCode() {
		return (idPartitionIdentifier != null ? idPartitionIdentifier.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof PartitionHMTable)) {
			return false;
		}

		// Casts object
		PartitionHMTable ndPartitionHMTable = (PartitionHMTable) obObject;

		// Verifies identifiers
		if ((ndPartitionHMTable.getPartitionIdentifier() == null) || (idPartitionIdentifier == null)) {
			return ((ndPartitionHMTable.getPartitionIdentifier() == null) && (idPartitionIdentifier == null));
		}

		// Verifies identifiers
		if (ndPartitionHMTable.getPartitionIdentifier().equals(idPartitionIdentifier)) {
			return true;
		}

		// Not equal
		return false;
	}

	@Override
	public String toString() {
		return (idPartitionIdentifier != null ? idPartitionIdentifier.toString() : super.toString());
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            ARINC_653_Module.
	 */
	public static PartitionHMTable cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_PARTITIONHMTABLE.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Partition_HM_Table");
		}

		// Creates node
		PartitionHMTable ndPartitionHMTable = new PartitionHMTable();

		// Sets parent
		ndPartitionHMTable.ndParent = ndParent;

		// Loads attribute
		try {
			ndPartitionHMTable.idPartitionIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PartitionIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndPartitionHMTable.idPartitionIdentifier == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not found");
		}

		// Loads attribute
		ndPartitionHMTable.stPartitionName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONNAME);

		// Loads attribute
		ndPartitionHMTable.stPartitionCallback = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONCALLBACK);

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
			if (Module.ATTRIBUTENAME_PARTITIONIDENTIFIER.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PARTITIONNAME.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PARTITIONCALLBACK.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Partition_HM_Table node");
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
			if (Module.NODENAME_PARTITIONHMTABLE_SYSTEMSTATEENTRY.equals(ndChildNode.getNodeName())) {

				// Loads child
				PartitionHMTable_SystemStateEntry ndPartitionHMTable_SystemStateEntry = PartitionHMTable_SystemStateEntry.cmdLoad(ndChildNode, ndPartitionHMTable);

				// Verifies child
				if (ndPartitionHMTable_SystemStateEntry == null) {
					throw new ConfigurationException("Error while loading a System_State_Entry node (Partition_HM_Table child)");
				}

				// Adds child
				ndPartitionHMTable.addPartitionHMTable_SystemStateEntry(ndPartitionHMTable_SystemStateEntry);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_PARTHMEXT$EXTENSION.equals(ndChildNode.getNodeName())) {

				// Loads child
				PartHMExt$Extension ndPartHMExt$Extension = PartHMExt$Extension.cmdLoad(ndChildNode, ndPartitionHMTable);

				// Verifies child
				if (ndPartHMExt$Extension == null) {
					throw new ConfigurationException("Error while loading a Part_HM_Ext:Extension node (Partition_HM_Table child)");
				}

				// Adds child
				ndPartitionHMTable.addPartHMExt$Extension(ndPartHMExt$Extension);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Partition_HM_Table node");
		}

		// Returns node
		return ndPartitionHMTable;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndPartitionHMTable
	 *            Partition_HM_Table.
	 */
	public static Element cmdSave(Element elParent, PartitionHMTable ndPartitionHMTable) throws ConfigurationException {

		// Creates element
		Element elPartitionHMTable = elParent.getOwnerDocument().createElement(Module.NODENAME_PARTITIONHMTABLE);

		// Verifies required attribute
		if (ndPartitionHMTable.getPartitionIdentifier() == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not assigned in Partition_HM_Table");
		}

		// Saves attribute
		elPartitionHMTable.setAttribute(Module.ATTRIBUTENAME_PARTITIONIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndPartitionHMTable.getPartitionIdentifier()));

		// Verifies attribute
		if (ndPartitionHMTable.getPartitionName() != null) {

			// Saves attribute
			elPartitionHMTable.setAttribute(Module.ATTRIBUTENAME_PARTITIONNAME, ConfigurationUtilities.getAttributeString(ndPartitionHMTable.getPartitionName()));
		}

		// Verifies attribute
		if (ndPartitionHMTable.getPartitionCallback() != null) {

			// Saves attribute
			elPartitionHMTable.setAttribute(Module.ATTRIBUTENAME_PARTITIONCALLBACK, ConfigurationUtilities.getAttributeString(ndPartitionHMTable.getPartitionCallback()));
		}

		// Iterates children
		Iterator<PartitionHMTable_SystemStateEntry> itPartitionHMTable_SystemStateEntry = ndPartitionHMTable.getPartitionHMTable_SystemStateEntryList().iterator();
		while (itPartitionHMTable_SystemStateEntry.hasNext()) {

			// Appends child
			elPartitionHMTable.appendChild(PartitionHMTable_SystemStateEntry.cmdSave(elPartitionHMTable, itPartitionHMTable_SystemStateEntry.next()));
		}

		// Iterates children
		Iterator<PartHMExt$Extension> itPartHMExt$Extension = ndPartitionHMTable.getPartHMExt$ExtensionList().iterator();
		while (itPartHMExt$Extension.hasNext()) {

			// Appends child
			elPartitionHMTable.appendChild(PartHMExt$Extension.cmdSave(elPartitionHMTable, itPartHMExt$Extension.next()));
		}

		// Returns element
		return elPartitionHMTable;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idPartitionIdentifier
	 *            PartitionIdentifier.
	 * @param stPartitionName
	 *            PartitionName.
	 * @param stPartitionCallback
	 *            PartitionCallback.
	 */
	public static PartitionHMTable newInstance(Module ndParent, Identifier idPartitionIdentifier, String stPartitionName, String stPartitionCallback) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new PartitionHMTable(ndParent, idPartitionIdentifier, stPartitionName, stPartitionCallback);
	}
}
