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
 * Auto-generated parser for SysHM_Ext:Extension node.
 */
public class SysHMExt$Extension {

	/**
	 * Parent node.
	 */
	private SystemHMTable ndParent;

	/**
	 * DisableHealthMonitoring attribute.
	 */
	private Boolean blDisableHealthMonitoring;

	/**
	 * SysHM_Ext:Error_ID_Action node list.
	 */
	private List<SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction> lsSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction = new LinkedList<SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction>();

	/**
	 * SysHM_Ext:Error_ID_Action node map.
	 */
	private Map<Identifier, SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction> mpSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction = new HashMap<Identifier, SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction>();

	/**
	 * Constructor.
	 */
	private SysHMExt$Extension() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param blDisableHealthMonitoring
	 *            DisableHealthMonitoring.
	 */
	private SysHMExt$Extension(SystemHMTable ndParent, Boolean blDisableHealthMonitoring) throws ConfigurationException {
		this.ndParent = ndParent;
		this.blDisableHealthMonitoring = blDisableHealthMonitoring;

		// Adds to parent
		if (!ndParent.addSysHMExt$Extension(this)) {
			throw new ConfigurationException("SysHM_Ext:Extension cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public SystemHMTable getParent() {
		return ndParent;
	}

	/**
	 * DisableHealthMonitoring getter.
	 */
	public Boolean getDisableHealthMonitoring() {
		return this.blDisableHealthMonitoring;
	}

	/**
	 * DisableHealthMonitoring setter.
	 */
	public void setDisableHealthMonitoring(Boolean blDisableHealthMonitoring) {
		this.blDisableHealthMonitoring = blDisableHealthMonitoring;
	}

	/**
	 * SysHM_Ext:Error_ID_Action adder.
	 * 
	 * @param ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction
	 *            SysHM_Ext:Error_ID_Action.
	 */
	public boolean addSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction(SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction) {

		// Verifies node
		if (ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction == null) {
			return false;
		}

		// Verifies identifier
		if (mpSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.containsKey(ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.getErrorIdentifier())) {
			return false;
		}

		// Adds node
		lsSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.add(ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction);

		// Maps node
		mpSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.put(ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.getErrorIdentifier(), ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction);
		return true;
	}

	/**
	 * SysHM_Ext:Error_ID_Action getter.
	 * 
	 * @param idErrorIdentifier
	 *            ErrorIdentifier.
	 */
	public SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction getSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction(Identifier idErrorIdentifier) {
		return (idErrorIdentifier == null ? null : this.mpSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.get(idErrorIdentifier));
	}

	/**
	 * SysHM_Ext:Error_ID_Action ErrorIdentifier set getter.
	 */
	public Set<Identifier> getSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDActionErrorIdentifierSet() {
		return this.mpSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.keySet();
	}

	/**
	 * SysHM_Ext:Error_ID_Action list getter.
	 */
	public List<SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction> getSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDActionList() {
		return new LinkedList<SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction>(this.lsSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction);
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            System_HM_Table.
	 */
	public static SysHMExt$Extension cmdLoad(Node ndNode, SystemHMTable ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_SYSHMEXT$EXTENSION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a SysHM_Ext:Extension");
		}

		// Creates node
		SysHMExt$Extension ndSysHMExt$Extension = new SysHMExt$Extension();

		// Sets parent
		ndSysHMExt$Extension.ndParent = ndParent;

		// Loads attribute
		try {
			ndSysHMExt$Extension.blDisableHealthMonitoring = ConfigurationUtilities.getBooleanAttribute(ndNode, Module.ATTRIBUTENAME_DISABLEHEALTHMONITORING);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute DisableHealthMonitoring value cannot be parsed");
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
			if (Module.ATTRIBUTENAME_DISABLEHEALTHMONITORING.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in SysHM_Ext:Extension node");
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
			if (Module.NODENAME_SYSTEMHMTABLE_SYSHMEXT$EXTENSION_SYSHMEXT$ERRORIDACTION.equals(ndChildNode.getNodeName())) {

				// Loads child
				SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction = SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.cmdLoad(ndChildNode, ndSysHMExt$Extension);

				// Verifies child
				if (ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction == null) {
					throw new ConfigurationException("Error while loading a SysHM_Ext:Error_ID_Action node (SysHM_Ext:Extension child)");
				}

				// Adds child
				ndSysHMExt$Extension.addSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction(ndSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in SysHM_Ext:Extension node");
		}

		// Returns node
		return ndSysHMExt$Extension;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndSysHMExt$Extension
	 *            SysHM_Ext:Extension.
	 */
	public static Element cmdSave(Element elParent, SysHMExt$Extension ndSysHMExt$Extension) throws ConfigurationException {

		// Creates element
		Element elSysHMExt$Extension = elParent.getOwnerDocument().createElement(Module.NODENAME_SYSHMEXT$EXTENSION);

		// Verifies attribute
		if (ndSysHMExt$Extension.getDisableHealthMonitoring() != null) {

			// Saves attribute
			elSysHMExt$Extension.setAttribute(Module.ATTRIBUTENAME_DISABLEHEALTHMONITORING, ConfigurationUtilities.getAttributeBoolean(ndSysHMExt$Extension.getDisableHealthMonitoring()));
		}

		// Iterates children
		Iterator<SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction> itSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction = ndSysHMExt$Extension.getSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDActionList().iterator();
		while (itSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.hasNext()) {

			// Appends child
			elSysHMExt$Extension.appendChild(SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.cmdSave(elSysHMExt$Extension, itSystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction.next()));
		}

		// Returns element
		return elSysHMExt$Extension;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param blDisableHealthMonitoring
	 *            DisableHealthMonitoring.
	 */
	public static SysHMExt$Extension newInstance(SystemHMTable ndParent, Boolean blDisableHealthMonitoring) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new SysHMExt$Extension(ndParent, blDisableHealthMonitoring);
	}
}
