package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexLong;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Part_HM_Ext:Extension node.
 */
public class PartHMExt$Extension {

	/**
	 * Parent node.
	 */
	private PartitionHMTable ndParent;

	/**
	 * PartitionCallbackStackSize attribute.
	 */
	private DecOrHexLong dhPartitionCallbackStackSize;

	/**
	 * Constructor.
	 */
	private PartHMExt$Extension() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhPartitionCallbackStackSize
	 *            PartitionCallbackStackSize.
	 */
	private PartHMExt$Extension(PartitionHMTable ndParent, DecOrHexLong dhPartitionCallbackStackSize) throws ConfigurationException {
		this.ndParent = ndParent;
		this.dhPartitionCallbackStackSize = dhPartitionCallbackStackSize;

		// Adds to parent
		if (!ndParent.addPartHMExt$Extension(this)) {
			throw new ConfigurationException("Part_HM_Ext:Extension cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public PartitionHMTable getParent() {
		return ndParent;
	}

	/**
	 * PartitionCallbackStackSize getter.
	 */
	public DecOrHexLong getPartitionCallbackStackSize() {
		return this.dhPartitionCallbackStackSize;
	}

	/**
	 * PartitionCallbackStackSize setter.
	 */
	public void setPartitionCallbackStackSize(DecOrHexLong dhPartitionCallbackStackSize) {
		this.dhPartitionCallbackStackSize = dhPartitionCallbackStackSize;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Partition_HM_Table.
	 */
	public static PartHMExt$Extension cmdLoad(Node ndNode, PartitionHMTable ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_PARTHMEXT$EXTENSION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Part_HM_Ext:Extension");
		}

		// Creates node
		PartHMExt$Extension ndPartHMExt$Extension = new PartHMExt$Extension();

		// Sets parent
		ndPartHMExt$Extension.ndParent = ndParent;

		// Loads attribute
		try {
			ndPartHMExt$Extension.dhPartitionCallbackStackSize = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONCALLBACKSTACKSIZE);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PartitionCallbackStackSize value cannot be parsed");
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
			if (Module.ATTRIBUTENAME_PARTITIONCALLBACKSTACKSIZE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Part_HM_Ext:Extension node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Part_HM_Ext:Extension node");
		}

		// Returns node
		return ndPartHMExt$Extension;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndPartHMExt$Extension
	 *            Part_HM_Ext:Extension.
	 */
	public static Element cmdSave(Element elParent, PartHMExt$Extension ndPartHMExt$Extension) throws ConfigurationException {

		// Creates element
		Element elPartHMExt$Extension = elParent.getOwnerDocument().createElement(Module.NODENAME_PARTHMEXT$EXTENSION);

		// Verifies attribute
		if (ndPartHMExt$Extension.getPartitionCallbackStackSize() != null) {

			// Saves attribute
			elPartHMExt$Extension.setAttribute(Module.ATTRIBUTENAME_PARTITIONCALLBACKSTACKSIZE, ConfigurationUtilities.getAttributeDecOrHexLong(ndPartHMExt$Extension.getPartitionCallbackStackSize()));
		}

		// Returns element
		return elPartHMExt$Extension;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhPartitionCallbackStackSize
	 *            PartitionCallbackStackSize.
	 */
	public static PartHMExt$Extension newInstance(PartitionHMTable ndParent, DecOrHexLong dhPartitionCallbackStackSize) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new PartHMExt$Extension(ndParent, dhPartitionCallbackStackSize);
	}
}
