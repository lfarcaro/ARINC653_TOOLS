package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexLong;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Mod_HM_Ext:Extension node.
 */
public class ModHMExt$Extension {

	/**
	 * Parent node.
	 */
	private ModuleHMTable ndParent;

	/**
	 * ModuleCallbackStackSize attribute.
	 */
	private DecOrHexLong dhModuleCallbackStackSize;

	/**
	 * Constructor.
	 */
	private ModHMExt$Extension() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhModuleCallbackStackSize
	 *            ModuleCallbackStackSize.
	 */
	private ModHMExt$Extension(ModuleHMTable ndParent, DecOrHexLong dhModuleCallbackStackSize) throws ConfigurationException {
		this.ndParent = ndParent;
		this.dhModuleCallbackStackSize = dhModuleCallbackStackSize;

		// Adds to parent
		if (!ndParent.addModHMExt$Extension(this)) {
			throw new ConfigurationException("Mod_HM_Ext:Extension cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public ModuleHMTable getParent() {
		return ndParent;
	}

	/**
	 * ModuleCallbackStackSize getter.
	 */
	public DecOrHexLong getModuleCallbackStackSize() {
		return this.dhModuleCallbackStackSize;
	}

	/**
	 * ModuleCallbackStackSize setter.
	 */
	public void setModuleCallbackStackSize(DecOrHexLong dhModuleCallbackStackSize) {
		this.dhModuleCallbackStackSize = dhModuleCallbackStackSize;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Module_HM_Table.
	 */
	public static ModHMExt$Extension cmdLoad(Node ndNode, ModuleHMTable ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODHMEXT$EXTENSION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Mod_HM_Ext:Extension");
		}

		// Creates node
		ModHMExt$Extension ndModHMExt$Extension = new ModHMExt$Extension();

		// Sets parent
		ndModHMExt$Extension.ndParent = ndParent;

		// Loads attribute
		try {
			ndModHMExt$Extension.dhModuleCallbackStackSize = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULECALLBACKSTACKSIZE);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleCallbackStackSize value cannot be parsed");
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
			if (Module.ATTRIBUTENAME_MODULECALLBACKSTACKSIZE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Mod_HM_Ext:Extension node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Mod_HM_Ext:Extension node");
		}

		// Returns node
		return ndModHMExt$Extension;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModHMExt$Extension
	 *            Mod_HM_Ext:Extension.
	 */
	public static Element cmdSave(Element elParent, ModHMExt$Extension ndModHMExt$Extension) throws ConfigurationException {

		// Creates element
		Element elModHMExt$Extension = elParent.getOwnerDocument().createElement(Module.NODENAME_MODHMEXT$EXTENSION);

		// Verifies attribute
		if (ndModHMExt$Extension.getModuleCallbackStackSize() != null) {

			// Saves attribute
			elModHMExt$Extension.setAttribute(Module.ATTRIBUTENAME_MODULECALLBACKSTACKSIZE, ConfigurationUtilities.getAttributeDecOrHexLong(ndModHMExt$Extension.getModuleCallbackStackSize()));
		}

		// Returns element
		return elModHMExt$Extension;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhModuleCallbackStackSize
	 *            ModuleCallbackStackSize.
	 */
	public static ModHMExt$Extension newInstance(ModuleHMTable ndParent, DecOrHexLong dhModuleCallbackStackSize) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ModHMExt$Extension(ndParent, dhModuleCallbackStackSize);
	}
}
