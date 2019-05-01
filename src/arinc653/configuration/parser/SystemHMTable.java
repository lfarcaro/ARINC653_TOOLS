package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
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
 * Auto-generated parser for System_HM_Table node.
 */
public class SystemHMTable {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * System_State_Entry node list.
	 */
	private List<SystemHMTable_SystemStateEntry> lsSystemHMTable_SystemStateEntry = new LinkedList<SystemHMTable_SystemStateEntry>();

	/**
	 * System_State_Entry node map.
	 */
	private Map<Identifier, SystemHMTable_SystemStateEntry> mpSystemHMTable_SystemStateEntry = new HashMap<Identifier, SystemHMTable_SystemStateEntry>();

	/**
	 * SysHM_Ext:Extension node list.
	 */
	private List<SysHMExt$Extension> lsSysHMExt$Extension = new LinkedList<SysHMExt$Extension>();

	/**
	 * Constructor.
	 */
	private SystemHMTable() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 */
	private SystemHMTable(Module ndParent) throws ConfigurationException {
		this.ndParent = ndParent;

		// Adds to parent
		if (!ndParent.addSystemHMTable(this)) {
			throw new ConfigurationException("System_HM_Table cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
		return ndParent;
	}

	/**
	 * System_State_Entry adder.
	 * 
	 * @param ndSystemHMTable_SystemStateEntry
	 *            System_State_Entry.
	 */
	public boolean addSystemHMTable_SystemStateEntry(SystemHMTable_SystemStateEntry ndSystemHMTable_SystemStateEntry) {

		// Verifies node
		if (ndSystemHMTable_SystemStateEntry == null) {
			return false;
		}

		// Verifies identifier
		if (mpSystemHMTable_SystemStateEntry.containsKey(ndSystemHMTable_SystemStateEntry.getSystemState())) {
			return false;
		}

		// Adds node
		lsSystemHMTable_SystemStateEntry.add(ndSystemHMTable_SystemStateEntry);

		// Maps node
		mpSystemHMTable_SystemStateEntry.put(ndSystemHMTable_SystemStateEntry.getSystemState(), ndSystemHMTable_SystemStateEntry);
		return true;
	}

	/**
	 * System_State_Entry getter.
	 * 
	 * @param idSystemState
	 *            SystemState.
	 */
	public SystemHMTable_SystemStateEntry getSystemHMTable_SystemStateEntry(Identifier idSystemState) {
		return (idSystemState == null ? null : this.mpSystemHMTable_SystemStateEntry.get(idSystemState));
	}

	/**
	 * System_State_Entry SystemState set getter.
	 */
	public Set<Identifier> getSystemHMTable_SystemStateEntrySystemStateSet() {
		return this.mpSystemHMTable_SystemStateEntry.keySet();
	}

	/**
	 * System_State_Entry list getter.
	 */
	public List<SystemHMTable_SystemStateEntry> getSystemHMTable_SystemStateEntryList() {
		return new LinkedList<SystemHMTable_SystemStateEntry>(this.lsSystemHMTable_SystemStateEntry);
	}

	/**
	 * SysHM_Ext:Extension adder.
	 * 
	 * @param ndSysHMExt$Extension
	 *            SysHM_Ext:Extension.
	 */
	public boolean addSysHMExt$Extension(SysHMExt$Extension ndSysHMExt$Extension) {

		// Verifies node
		if (ndSysHMExt$Extension == null) {
			return false;
		}

		// Adds node
		lsSysHMExt$Extension.add(ndSysHMExt$Extension);
		return true;
	}

	/**
	 * SysHM_Ext:Extension list getter.
	 */
	public List<SysHMExt$Extension> getSysHMExt$ExtensionList() {
		return new LinkedList<SysHMExt$Extension>(this.lsSysHMExt$Extension);
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            ARINC_653_Module.
	 */
	public static SystemHMTable cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_SYSTEMHMTABLE.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a System_HM_Table");
		}

		// Creates node
		SystemHMTable ndSystemHMTable = new SystemHMTable();

		// Sets parent
		ndSystemHMTable.ndParent = ndParent;

		// Iterates attributes
		NamedNodeMap nmAttributes = ndNode.getAttributes();
		for (int i = 0; i < nmAttributes.getLength(); i++) {

			// Gets next attribute
			Node ndAttribute = nmAttributes.item(i);

			// Verifies attribute
			if (ndAttribute.getNodeType() != Node.ATTRIBUTE_NODE) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in System_HM_Table node");
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
			if (Module.NODENAME_SYSTEMHMTABLE_SYSTEMSTATEENTRY.equals(ndChildNode.getNodeName())) {

				// Loads child
				SystemHMTable_SystemStateEntry ndSystemHMTable_SystemStateEntry = SystemHMTable_SystemStateEntry.cmdLoad(ndChildNode, ndSystemHMTable);

				// Verifies child
				if (ndSystemHMTable_SystemStateEntry == null) {
					throw new ConfigurationException("Error while loading a System_State_Entry node (System_HM_Table child)");
				}

				// Adds child
				ndSystemHMTable.addSystemHMTable_SystemStateEntry(ndSystemHMTable_SystemStateEntry);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_SYSHMEXT$EXTENSION.equals(ndChildNode.getNodeName())) {

				// Loads child
				SysHMExt$Extension ndSysHMExt$Extension = SysHMExt$Extension.cmdLoad(ndChildNode, ndSystemHMTable);

				// Verifies child
				if (ndSysHMExt$Extension == null) {
					throw new ConfigurationException("Error while loading a SysHM_Ext:Extension node (System_HM_Table child)");
				}

				// Adds child
				ndSystemHMTable.addSysHMExt$Extension(ndSysHMExt$Extension);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in System_HM_Table node");
		}

		// Returns node
		return ndSystemHMTable;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndSystemHMTable
	 *            System_HM_Table.
	 */
	public static Element cmdSave(Element elParent, SystemHMTable ndSystemHMTable) throws ConfigurationException {

		// Creates element
		Element elSystemHMTable = elParent.getOwnerDocument().createElement(Module.NODENAME_SYSTEMHMTABLE);

		// Iterates children
		Iterator<SystemHMTable_SystemStateEntry> itSystemHMTable_SystemStateEntry = ndSystemHMTable.getSystemHMTable_SystemStateEntryList().iterator();
		while (itSystemHMTable_SystemStateEntry.hasNext()) {

			// Appends child
			elSystemHMTable.appendChild(SystemHMTable_SystemStateEntry.cmdSave(elSystemHMTable, itSystemHMTable_SystemStateEntry.next()));
		}

		// Iterates children
		Iterator<SysHMExt$Extension> itSysHMExt$Extension = ndSystemHMTable.getSysHMExt$ExtensionList().iterator();
		while (itSysHMExt$Extension.hasNext()) {

			// Appends child
			elSystemHMTable.appendChild(SysHMExt$Extension.cmdSave(elSystemHMTable, itSysHMExt$Extension.next()));
		}

		// Returns element
		return elSystemHMTable;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 */
	public static SystemHMTable newInstance(Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new SystemHMTable(ndParent);
	}
}
