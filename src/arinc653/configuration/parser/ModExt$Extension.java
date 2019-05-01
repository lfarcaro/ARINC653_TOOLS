package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexLong;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for ModExt:Extension node.
 */
public class ModExt$Extension {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * DefaultStackSize attribute.
	 */
	private DecOrHexLong dhDefaultStackSize;

	/**
	 * SuppressModuleIdlePartitionMainLoop attribute.
	 */
	private Boolean blSuppressModuleIdlePartitionMainLoop;

	/**
	 * Constructor.
	 */
	private ModExt$Extension() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhDefaultStackSize
	 *            DefaultStackSize.
	 * @param blSuppressModuleIdlePartitionMainLoop
	 *            SuppressModuleIdlePartitionMainLoop.
	 */
	private ModExt$Extension(Module ndParent, DecOrHexLong dhDefaultStackSize, Boolean blSuppressModuleIdlePartitionMainLoop) throws ConfigurationException {
		this.ndParent = ndParent;
		this.dhDefaultStackSize = dhDefaultStackSize;
		this.blSuppressModuleIdlePartitionMainLoop = blSuppressModuleIdlePartitionMainLoop;

		// Adds to parent
		if (!ndParent.addModExt$Extension(this)) {
			throw new ConfigurationException("ModExt:Extension cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
		return ndParent;
	}

	/**
	 * DefaultStackSize getter.
	 */
	public DecOrHexLong getDefaultStackSize() {
		return this.dhDefaultStackSize;
	}

	/**
	 * DefaultStackSize setter.
	 */
	public void setDefaultStackSize(DecOrHexLong dhDefaultStackSize) {
		this.dhDefaultStackSize = dhDefaultStackSize;
	}

	/**
	 * SuppressModuleIdlePartitionMainLoop getter.
	 */
	public Boolean getSuppressModuleIdlePartitionMainLoop() {
		return this.blSuppressModuleIdlePartitionMainLoop;
	}

	/**
	 * SuppressModuleIdlePartitionMainLoop setter.
	 */
	public void setSuppressModuleIdlePartitionMainLoop(Boolean blSuppressModuleIdlePartitionMainLoop) {
		this.blSuppressModuleIdlePartitionMainLoop = blSuppressModuleIdlePartitionMainLoop;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            ARINC_653_Module.
	 */
	public static ModExt$Extension cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODEXT$EXTENSION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a ModExt:Extension");
		}

		// Creates node
		ModExt$Extension ndModExt$Extension = new ModExt$Extension();

		// Sets parent
		ndModExt$Extension.ndParent = ndParent;

		// Loads attribute
		try {
			ndModExt$Extension.dhDefaultStackSize = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_DEFAULTSTACKSIZE);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute DefaultStackSize value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension.dhDefaultStackSize == null) {
			throw new ConfigurationException("Required attribute DefaultStackSize not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension.blSuppressModuleIdlePartitionMainLoop = ConfigurationUtilities.getBooleanAttribute(ndNode, Module.ATTRIBUTENAME_SUPPRESSMODULEIDLEPARTITIONMAINLOOP);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SuppressModuleIdlePartitionMainLoop value cannot be parsed");
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
			if (Module.ATTRIBUTENAME_DEFAULTSTACKSIZE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SUPPRESSMODULEIDLEPARTITIONMAINLOOP.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in ModExt:Extension node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in ModExt:Extension node");
		}

		// Returns node
		return ndModExt$Extension;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModExt$Extension
	 *            ModExt:Extension.
	 */
	public static Element cmdSave(Element elParent, ModExt$Extension ndModExt$Extension) throws ConfigurationException {

		// Creates element
		Element elModExt$Extension = elParent.getOwnerDocument().createElement(Module.NODENAME_MODEXT$EXTENSION);

		// Verifies required attribute
		if (ndModExt$Extension.getDefaultStackSize() == null) {
			throw new ConfigurationException("Required attribute DefaultStackSize not assigned in ModExt:Extension");
		}

		// Saves attribute
		elModExt$Extension.setAttribute(Module.ATTRIBUTENAME_DEFAULTSTACKSIZE, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension.getDefaultStackSize()));

		// Verifies attribute
		if (ndModExt$Extension.getSuppressModuleIdlePartitionMainLoop() != null) {

			// Saves attribute
			elModExt$Extension.setAttribute(Module.ATTRIBUTENAME_SUPPRESSMODULEIDLEPARTITIONMAINLOOP, ConfigurationUtilities.getAttributeBoolean(ndModExt$Extension.getSuppressModuleIdlePartitionMainLoop()));
		}

		// Returns element
		return elModExt$Extension;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhDefaultStackSize
	 *            DefaultStackSize.
	 * @param blSuppressModuleIdlePartitionMainLoop
	 *            SuppressModuleIdlePartitionMainLoop.
	 */
	public static ModExt$Extension newInstance(Module ndParent, DecOrHexLong dhDefaultStackSize, Boolean blSuppressModuleIdlePartitionMainLoop) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ModExt$Extension(ndParent, dhDefaultStackSize, blSuppressModuleIdlePartitionMainLoop);
	}
}
