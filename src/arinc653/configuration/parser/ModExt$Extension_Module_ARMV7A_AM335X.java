package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexString;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for ModExt:Extension_Module_ARMV7A_AM335X node.
 */
public class ModExt$Extension_Module_ARMV7A_AM335X {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * ModuleNetworkPhysicalAddress attribute.
	 */
	private DecOrHexString dhModuleNetworkPhysicalAddress;

	/**
	 * Constructor.
	 */
	private ModExt$Extension_Module_ARMV7A_AM335X() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhModuleNetworkPhysicalAddress
	 *            ModuleNetworkPhysicalAddress.
	 */
	private ModExt$Extension_Module_ARMV7A_AM335X(Module ndParent, DecOrHexString dhModuleNetworkPhysicalAddress) throws ConfigurationException {
		this.ndParent = ndParent;
		this.dhModuleNetworkPhysicalAddress = dhModuleNetworkPhysicalAddress;

		// Adds to parent
		if (!ndParent.addModExt$Extension_Module_ARMV7A_AM335X(this)) {
			throw new ConfigurationException("ModExt:Extension_Module_ARMV7A_AM335X cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
		return ndParent;
	}

	/**
	 * ModuleNetworkPhysicalAddress getter.
	 */
	public DecOrHexString getModuleNetworkPhysicalAddress() {
		return this.dhModuleNetworkPhysicalAddress;
	}

	/**
	 * ModuleNetworkPhysicalAddress setter.
	 */
	public void setModuleNetworkPhysicalAddress(DecOrHexString dhModuleNetworkPhysicalAddress) {
		this.dhModuleNetworkPhysicalAddress = dhModuleNetworkPhysicalAddress;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            ARINC_653_Module.
	 */
	public static ModExt$Extension_Module_ARMV7A_AM335X cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A_AM335X.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a ModExt:Extension_Module_ARMV7A_AM335X");
		}

		// Creates node
		ModExt$Extension_Module_ARMV7A_AM335X ndModExt$Extension_Module_ARMV7A_AM335X = new ModExt$Extension_Module_ARMV7A_AM335X();

		// Sets parent
		ndModExt$Extension_Module_ARMV7A_AM335X.ndParent = ndParent;

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A_AM335X.dhModuleNetworkPhysicalAddress = ConfigurationUtilities.getDecOrHexStringAttribute(ndNode, Module.ATTRIBUTENAME_MODULENETWORKPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleNetworkPhysicalAddress value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A_AM335X.dhModuleNetworkPhysicalAddress == null) {
			throw new ConfigurationException("Required attribute ModuleNetworkPhysicalAddress not found");
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
			if (Module.ATTRIBUTENAME_MODULENETWORKPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in ModExt:Extension_Module_ARMV7A_AM335X node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in ModExt:Extension_Module_ARMV7A_AM335X node");
		}

		// Returns node
		return ndModExt$Extension_Module_ARMV7A_AM335X;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModExt$Extension_Module_ARMV7A_AM335X
	 *            ModExt:Extension_Module_ARMV7A_AM335X.
	 */
	public static Element cmdSave(Element elParent, ModExt$Extension_Module_ARMV7A_AM335X ndModExt$Extension_Module_ARMV7A_AM335X) throws ConfigurationException {

		// Creates element
		Element elModExt$Extension_Module_ARMV7A_AM335X = elParent.getOwnerDocument().createElement(Module.NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A_AM335X);

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A_AM335X.getModuleNetworkPhysicalAddress() == null) {
			throw new ConfigurationException("Required attribute ModuleNetworkPhysicalAddress not assigned in ModExt:Extension_Module_ARMV7A_AM335X");
		}

		// Saves attribute
		elModExt$Extension_Module_ARMV7A_AM335X.setAttribute(Module.ATTRIBUTENAME_MODULENETWORKPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexString(ndModExt$Extension_Module_ARMV7A_AM335X.getModuleNetworkPhysicalAddress()));

		// Returns element
		return elModExt$Extension_Module_ARMV7A_AM335X;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhModuleNetworkPhysicalAddress
	 *            ModuleNetworkPhysicalAddress.
	 */
	public static ModExt$Extension_Module_ARMV7A_AM335X newInstance(Module ndParent, DecOrHexString dhModuleNetworkPhysicalAddress) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ModExt$Extension_Module_ARMV7A_AM335X(ndParent, dhModuleNetworkPhysicalAddress);
	}
}
