package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for ModExt:Extension_Module_ARMV7A_Z7000 node.
 */
public class ModExt$Extension_Module_ARMV7A_Z7000 {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * Constructor.
	 */
	private ModExt$Extension_Module_ARMV7A_Z7000() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 */
	private ModExt$Extension_Module_ARMV7A_Z7000(Module ndParent) throws ConfigurationException {
		this.ndParent = ndParent;

		// Adds to parent
		if (!ndParent.addModExt$Extension_Module_ARMV7A_Z7000(this)) {
			throw new ConfigurationException("ModExt:Extension_Module_ARMV7A_Z7000 cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
		return ndParent;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            ARINC_653_Module.
	 */
	public static ModExt$Extension_Module_ARMV7A_Z7000 cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A_Z7000.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a ModExt:Extension_Module_ARMV7A_Z7000");
		}

		// Creates node
		ModExt$Extension_Module_ARMV7A_Z7000 ndModExt$Extension_Module_ARMV7A_Z7000 = new ModExt$Extension_Module_ARMV7A_Z7000();

		// Sets parent
		ndModExt$Extension_Module_ARMV7A_Z7000.ndParent = ndParent;

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
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in ModExt:Extension_Module_ARMV7A_Z7000 node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in ModExt:Extension_Module_ARMV7A_Z7000 node");
		}

		// Returns node
		return ndModExt$Extension_Module_ARMV7A_Z7000;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModExt$Extension_Module_ARMV7A_Z7000
	 *            ModExt:Extension_Module_ARMV7A_Z7000.
	 */
	public static Element cmdSave(Element elParent, ModExt$Extension_Module_ARMV7A_Z7000 ndModExt$Extension_Module_ARMV7A_Z7000) throws ConfigurationException {

		// Creates element
		Element elModExt$Extension_Module_ARMV7A_Z7000 = elParent.getOwnerDocument().createElement(Module.NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A_Z7000);

		// Returns element
		return elModExt$Extension_Module_ARMV7A_Z7000;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 */
	public static ModExt$Extension_Module_ARMV7A_Z7000 newInstance(Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ModExt$Extension_Module_ARMV7A_Z7000(ndParent);
	}
}
