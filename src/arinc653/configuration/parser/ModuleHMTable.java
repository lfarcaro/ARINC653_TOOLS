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
 * Auto-generated parser for Module_HM_Table node.
 */
public class ModuleHMTable {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * ModuleCallback attribute.
	 */
	private String stModuleCallback;

	/**
	 * System_State_Entry node list.
	 */
	private List<ModuleHMTable_SystemStateEntry> lsModuleHMTable_SystemStateEntry = new LinkedList<ModuleHMTable_SystemStateEntry>();

	/**
	 * System_State_Entry node map.
	 */
	private Map<Identifier, ModuleHMTable_SystemStateEntry> mpModuleHMTable_SystemStateEntry = new HashMap<Identifier, ModuleHMTable_SystemStateEntry>();

	/**
	 * Mod_HM_Ext:Extension node list.
	 */
	private List<ModHMExt$Extension> lsModHMExt$Extension = new LinkedList<ModHMExt$Extension>();

	/**
	 * Constructor.
	 */
	private ModuleHMTable() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stModuleCallback
	 *            ModuleCallback.
	 */
	private ModuleHMTable(Module ndParent, String stModuleCallback) throws ConfigurationException {
		this.ndParent = ndParent;
		this.stModuleCallback = stModuleCallback;

		// Adds to parent
		if (!ndParent.addModuleHMTable(this)) {
			throw new ConfigurationException("Module_HM_Table cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
		return ndParent;
	}

	/**
	 * ModuleCallback getter.
	 */
	public String getModuleCallback() {
		return this.stModuleCallback;
	}

	/**
	 * ModuleCallback setter.
	 */
	public void setModuleCallback(String stModuleCallback) {
		this.stModuleCallback = stModuleCallback;
	}

	/**
	 * System_State_Entry adder.
	 * 
	 * @param ndModuleHMTable_SystemStateEntry
	 *            System_State_Entry.
	 */
	public boolean addModuleHMTable_SystemStateEntry(ModuleHMTable_SystemStateEntry ndModuleHMTable_SystemStateEntry) {

		// Verifies node
		if (ndModuleHMTable_SystemStateEntry == null) {
			return false;
		}

		// Verifies identifier
		if (mpModuleHMTable_SystemStateEntry.containsKey(ndModuleHMTable_SystemStateEntry.getSystemState())) {
			return false;
		}

		// Adds node
		lsModuleHMTable_SystemStateEntry.add(ndModuleHMTable_SystemStateEntry);

		// Maps node
		mpModuleHMTable_SystemStateEntry.put(ndModuleHMTable_SystemStateEntry.getSystemState(), ndModuleHMTable_SystemStateEntry);
		return true;
	}

	/**
	 * System_State_Entry getter.
	 * 
	 * @param idSystemState
	 *            SystemState.
	 */
	public ModuleHMTable_SystemStateEntry getModuleHMTable_SystemStateEntry(Identifier idSystemState) {
		return (idSystemState == null ? null : this.mpModuleHMTable_SystemStateEntry.get(idSystemState));
	}

	/**
	 * System_State_Entry SystemState set getter.
	 */
	public Set<Identifier> getModuleHMTable_SystemStateEntrySystemStateSet() {
		return this.mpModuleHMTable_SystemStateEntry.keySet();
	}

	/**
	 * System_State_Entry list getter.
	 */
	public List<ModuleHMTable_SystemStateEntry> getModuleHMTable_SystemStateEntryList() {
		return new LinkedList<ModuleHMTable_SystemStateEntry>(this.lsModuleHMTable_SystemStateEntry);
	}

	/**
	 * Mod_HM_Ext:Extension adder.
	 * 
	 * @param ndModHMExt$Extension
	 *            Mod_HM_Ext:Extension.
	 */
	public boolean addModHMExt$Extension(ModHMExt$Extension ndModHMExt$Extension) {

		// Verifies node
		if (ndModHMExt$Extension == null) {
			return false;
		}

		// Adds node
		lsModHMExt$Extension.add(ndModHMExt$Extension);
		return true;
	}

	/**
	 * Mod_HM_Ext:Extension list getter.
	 */
	public List<ModHMExt$Extension> getModHMExt$ExtensionList() {
		return new LinkedList<ModHMExt$Extension>(this.lsModHMExt$Extension);
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            ARINC_653_Module.
	 */
	public static ModuleHMTable cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODULEHMTABLE.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Module_HM_Table");
		}

		// Creates node
		ModuleHMTable ndModuleHMTable = new ModuleHMTable();

		// Sets parent
		ndModuleHMTable.ndParent = ndParent;

		// Loads attribute
		ndModuleHMTable.stModuleCallback = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_MODULECALLBACK);

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
			if (Module.ATTRIBUTENAME_MODULECALLBACK.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Module_HM_Table node");
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
			if (Module.NODENAME_MODULEHMTABLE_SYSTEMSTATEENTRY.equals(ndChildNode.getNodeName())) {

				// Loads child
				ModuleHMTable_SystemStateEntry ndModuleHMTable_SystemStateEntry = ModuleHMTable_SystemStateEntry.cmdLoad(ndChildNode, ndModuleHMTable);

				// Verifies child
				if (ndModuleHMTable_SystemStateEntry == null) {
					throw new ConfigurationException("Error while loading a System_State_Entry node (Module_HM_Table child)");
				}

				// Adds child
				ndModuleHMTable.addModuleHMTable_SystemStateEntry(ndModuleHMTable_SystemStateEntry);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_MODHMEXT$EXTENSION.equals(ndChildNode.getNodeName())) {

				// Loads child
				ModHMExt$Extension ndModHMExt$Extension = ModHMExt$Extension.cmdLoad(ndChildNode, ndModuleHMTable);

				// Verifies child
				if (ndModHMExt$Extension == null) {
					throw new ConfigurationException("Error while loading a Mod_HM_Ext:Extension node (Module_HM_Table child)");
				}

				// Adds child
				ndModuleHMTable.addModHMExt$Extension(ndModHMExt$Extension);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Module_HM_Table node");
		}

		// Returns node
		return ndModuleHMTable;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModuleHMTable
	 *            Module_HM_Table.
	 */
	public static Element cmdSave(Element elParent, ModuleHMTable ndModuleHMTable) throws ConfigurationException {

		// Creates element
		Element elModuleHMTable = elParent.getOwnerDocument().createElement(Module.NODENAME_MODULEHMTABLE);

		// Verifies attribute
		if (ndModuleHMTable.getModuleCallback() != null) {

			// Saves attribute
			elModuleHMTable.setAttribute(Module.ATTRIBUTENAME_MODULECALLBACK, ConfigurationUtilities.getAttributeString(ndModuleHMTable.getModuleCallback()));
		}

		// Iterates children
		Iterator<ModuleHMTable_SystemStateEntry> itModuleHMTable_SystemStateEntry = ndModuleHMTable.getModuleHMTable_SystemStateEntryList().iterator();
		while (itModuleHMTable_SystemStateEntry.hasNext()) {

			// Appends child
			elModuleHMTable.appendChild(ModuleHMTable_SystemStateEntry.cmdSave(elModuleHMTable, itModuleHMTable_SystemStateEntry.next()));
		}

		// Iterates children
		Iterator<ModHMExt$Extension> itModHMExt$Extension = ndModuleHMTable.getModHMExt$ExtensionList().iterator();
		while (itModHMExt$Extension.hasNext()) {

			// Appends child
			elModuleHMTable.appendChild(ModHMExt$Extension.cmdSave(elModuleHMTable, itModHMExt$Extension.next()));
		}

		// Returns element
		return elModuleHMTable;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stModuleCallback
	 *            ModuleCallback.
	 */
	public static ModuleHMTable newInstance(Module ndParent, String stModuleCallback) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ModuleHMTable(ndParent, stModuleCallback);
	}
}
