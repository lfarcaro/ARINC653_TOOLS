package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexLong;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for ModExt:Extension_Module_ARMV7A node.
 */
public class ModExt$Extension_Module_ARMV7A {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * ModuleStackRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhModuleStackRegionPhysicalAddress;

	/**
	 * ModuleStackRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhModuleStackRegionSizeBytes;

	/**
	 * ModuleCodeRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhModuleCodeRegionPhysicalAddress;

	/**
	 * ModuleCodeRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhModuleCodeRegionSizeBytes;

	/**
	 * ModuleDataRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhModuleDataRegionPhysicalAddress;

	/**
	 * ModuleDataRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhModuleDataRegionSizeBytes;

	/**
	 * ModuleHeapRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhModuleHeapRegionPhysicalAddress;

	/**
	 * ModuleHeapRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhModuleHeapRegionSizeBytes;

	/**
	 * ModuleFLTranslationTableRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhModuleFLTranslationTableRegionPhysicalAddress;

	/**
	 * ModuleFLTranslationTableRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhModuleFLTranslationTableRegionSizeBytes;

	/**
	 * ModuleSLTranslationTableRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhModuleSLTranslationTableRegionPhysicalAddress;

	/**
	 * ModuleSLTranslationTableRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhModuleSLTranslationTableRegionSizeBytes;

	/**
	 * Constructor.
	 */
	private ModExt$Extension_Module_ARMV7A() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhModuleStackRegionPhysicalAddress
	 *            ModuleStackRegionPhysicalAddress.
	 * @param dhModuleStackRegionSizeBytes
	 *            ModuleStackRegionSizeBytes.
	 * @param dhModuleCodeRegionPhysicalAddress
	 *            ModuleCodeRegionPhysicalAddress.
	 * @param dhModuleCodeRegionSizeBytes
	 *            ModuleCodeRegionSizeBytes.
	 * @param dhModuleDataRegionPhysicalAddress
	 *            ModuleDataRegionPhysicalAddress.
	 * @param dhModuleDataRegionSizeBytes
	 *            ModuleDataRegionSizeBytes.
	 * @param dhModuleHeapRegionPhysicalAddress
	 *            ModuleHeapRegionPhysicalAddress.
	 * @param dhModuleHeapRegionSizeBytes
	 *            ModuleHeapRegionSizeBytes.
	 * @param dhModuleFLTranslationTableRegionPhysicalAddress
	 *            ModuleFLTranslationTableRegionPhysicalAddress.
	 * @param dhModuleFLTranslationTableRegionSizeBytes
	 *            ModuleFLTranslationTableRegionSizeBytes.
	 * @param dhModuleSLTranslationTableRegionPhysicalAddress
	 *            ModuleSLTranslationTableRegionPhysicalAddress.
	 * @param dhModuleSLTranslationTableRegionSizeBytes
	 *            ModuleSLTranslationTableRegionSizeBytes.
	 */
	private ModExt$Extension_Module_ARMV7A(Module ndParent, DecOrHexLong dhModuleStackRegionPhysicalAddress, DecOrHexLong dhModuleStackRegionSizeBytes, DecOrHexLong dhModuleCodeRegionPhysicalAddress, DecOrHexLong dhModuleCodeRegionSizeBytes, DecOrHexLong dhModuleDataRegionPhysicalAddress, DecOrHexLong dhModuleDataRegionSizeBytes, DecOrHexLong dhModuleHeapRegionPhysicalAddress, DecOrHexLong dhModuleHeapRegionSizeBytes, DecOrHexLong dhModuleFLTranslationTableRegionPhysicalAddress, DecOrHexLong dhModuleFLTranslationTableRegionSizeBytes, DecOrHexLong dhModuleSLTranslationTableRegionPhysicalAddress, DecOrHexLong dhModuleSLTranslationTableRegionSizeBytes) throws ConfigurationException {
		this.ndParent = ndParent;
		this.dhModuleStackRegionPhysicalAddress = dhModuleStackRegionPhysicalAddress;
		this.dhModuleStackRegionSizeBytes = dhModuleStackRegionSizeBytes;
		this.dhModuleCodeRegionPhysicalAddress = dhModuleCodeRegionPhysicalAddress;
		this.dhModuleCodeRegionSizeBytes = dhModuleCodeRegionSizeBytes;
		this.dhModuleDataRegionPhysicalAddress = dhModuleDataRegionPhysicalAddress;
		this.dhModuleDataRegionSizeBytes = dhModuleDataRegionSizeBytes;
		this.dhModuleHeapRegionPhysicalAddress = dhModuleHeapRegionPhysicalAddress;
		this.dhModuleHeapRegionSizeBytes = dhModuleHeapRegionSizeBytes;
		this.dhModuleFLTranslationTableRegionPhysicalAddress = dhModuleFLTranslationTableRegionPhysicalAddress;
		this.dhModuleFLTranslationTableRegionSizeBytes = dhModuleFLTranslationTableRegionSizeBytes;
		this.dhModuleSLTranslationTableRegionPhysicalAddress = dhModuleSLTranslationTableRegionPhysicalAddress;
		this.dhModuleSLTranslationTableRegionSizeBytes = dhModuleSLTranslationTableRegionSizeBytes;

		// Adds to parent
		if (!ndParent.addModExt$Extension_Module_ARMV7A(this)) {
			throw new ConfigurationException("ModExt:Extension_Module_ARMV7A cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
		return ndParent;
	}

	/**
	 * ModuleStackRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getModuleStackRegionPhysicalAddress() {
		return this.dhModuleStackRegionPhysicalAddress;
	}

	/**
	 * ModuleStackRegionPhysicalAddress setter.
	 */
	public void setModuleStackRegionPhysicalAddress(DecOrHexLong dhModuleStackRegionPhysicalAddress) {
		this.dhModuleStackRegionPhysicalAddress = dhModuleStackRegionPhysicalAddress;
	}

	/**
	 * ModuleStackRegionSizeBytes getter.
	 */
	public DecOrHexLong getModuleStackRegionSizeBytes() {
		return this.dhModuleStackRegionSizeBytes;
	}

	/**
	 * ModuleStackRegionSizeBytes setter.
	 */
	public void setModuleStackRegionSizeBytes(DecOrHexLong dhModuleStackRegionSizeBytes) {
		this.dhModuleStackRegionSizeBytes = dhModuleStackRegionSizeBytes;
	}

	/**
	 * ModuleCodeRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getModuleCodeRegionPhysicalAddress() {
		return this.dhModuleCodeRegionPhysicalAddress;
	}

	/**
	 * ModuleCodeRegionPhysicalAddress setter.
	 */
	public void setModuleCodeRegionPhysicalAddress(DecOrHexLong dhModuleCodeRegionPhysicalAddress) {
		this.dhModuleCodeRegionPhysicalAddress = dhModuleCodeRegionPhysicalAddress;
	}

	/**
	 * ModuleCodeRegionSizeBytes getter.
	 */
	public DecOrHexLong getModuleCodeRegionSizeBytes() {
		return this.dhModuleCodeRegionSizeBytes;
	}

	/**
	 * ModuleCodeRegionSizeBytes setter.
	 */
	public void setModuleCodeRegionSizeBytes(DecOrHexLong dhModuleCodeRegionSizeBytes) {
		this.dhModuleCodeRegionSizeBytes = dhModuleCodeRegionSizeBytes;
	}

	/**
	 * ModuleDataRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getModuleDataRegionPhysicalAddress() {
		return this.dhModuleDataRegionPhysicalAddress;
	}

	/**
	 * ModuleDataRegionPhysicalAddress setter.
	 */
	public void setModuleDataRegionPhysicalAddress(DecOrHexLong dhModuleDataRegionPhysicalAddress) {
		this.dhModuleDataRegionPhysicalAddress = dhModuleDataRegionPhysicalAddress;
	}

	/**
	 * ModuleDataRegionSizeBytes getter.
	 */
	public DecOrHexLong getModuleDataRegionSizeBytes() {
		return this.dhModuleDataRegionSizeBytes;
	}

	/**
	 * ModuleDataRegionSizeBytes setter.
	 */
	public void setModuleDataRegionSizeBytes(DecOrHexLong dhModuleDataRegionSizeBytes) {
		this.dhModuleDataRegionSizeBytes = dhModuleDataRegionSizeBytes;
	}

	/**
	 * ModuleHeapRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getModuleHeapRegionPhysicalAddress() {
		return this.dhModuleHeapRegionPhysicalAddress;
	}

	/**
	 * ModuleHeapRegionPhysicalAddress setter.
	 */
	public void setModuleHeapRegionPhysicalAddress(DecOrHexLong dhModuleHeapRegionPhysicalAddress) {
		this.dhModuleHeapRegionPhysicalAddress = dhModuleHeapRegionPhysicalAddress;
	}

	/**
	 * ModuleHeapRegionSizeBytes getter.
	 */
	public DecOrHexLong getModuleHeapRegionSizeBytes() {
		return this.dhModuleHeapRegionSizeBytes;
	}

	/**
	 * ModuleHeapRegionSizeBytes setter.
	 */
	public void setModuleHeapRegionSizeBytes(DecOrHexLong dhModuleHeapRegionSizeBytes) {
		this.dhModuleHeapRegionSizeBytes = dhModuleHeapRegionSizeBytes;
	}

	/**
	 * ModuleFLTranslationTableRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getModuleFLTranslationTableRegionPhysicalAddress() {
		return this.dhModuleFLTranslationTableRegionPhysicalAddress;
	}

	/**
	 * ModuleFLTranslationTableRegionPhysicalAddress setter.
	 */
	public void setModuleFLTranslationTableRegionPhysicalAddress(DecOrHexLong dhModuleFLTranslationTableRegionPhysicalAddress) {
		this.dhModuleFLTranslationTableRegionPhysicalAddress = dhModuleFLTranslationTableRegionPhysicalAddress;
	}

	/**
	 * ModuleFLTranslationTableRegionSizeBytes getter.
	 */
	public DecOrHexLong getModuleFLTranslationTableRegionSizeBytes() {
		return this.dhModuleFLTranslationTableRegionSizeBytes;
	}

	/**
	 * ModuleFLTranslationTableRegionSizeBytes setter.
	 */
	public void setModuleFLTranslationTableRegionSizeBytes(DecOrHexLong dhModuleFLTranslationTableRegionSizeBytes) {
		this.dhModuleFLTranslationTableRegionSizeBytes = dhModuleFLTranslationTableRegionSizeBytes;
	}

	/**
	 * ModuleSLTranslationTableRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getModuleSLTranslationTableRegionPhysicalAddress() {
		return this.dhModuleSLTranslationTableRegionPhysicalAddress;
	}

	/**
	 * ModuleSLTranslationTableRegionPhysicalAddress setter.
	 */
	public void setModuleSLTranslationTableRegionPhysicalAddress(DecOrHexLong dhModuleSLTranslationTableRegionPhysicalAddress) {
		this.dhModuleSLTranslationTableRegionPhysicalAddress = dhModuleSLTranslationTableRegionPhysicalAddress;
	}

	/**
	 * ModuleSLTranslationTableRegionSizeBytes getter.
	 */
	public DecOrHexLong getModuleSLTranslationTableRegionSizeBytes() {
		return this.dhModuleSLTranslationTableRegionSizeBytes;
	}

	/**
	 * ModuleSLTranslationTableRegionSizeBytes setter.
	 */
	public void setModuleSLTranslationTableRegionSizeBytes(DecOrHexLong dhModuleSLTranslationTableRegionSizeBytes) {
		this.dhModuleSLTranslationTableRegionSizeBytes = dhModuleSLTranslationTableRegionSizeBytes;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            ARINC_653_Module.
	 */
	public static ModExt$Extension_Module_ARMV7A cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a ModExt:Extension_Module_ARMV7A");
		}

		// Creates node
		ModExt$Extension_Module_ARMV7A ndModExt$Extension_Module_ARMV7A = new ModExt$Extension_Module_ARMV7A();

		// Sets parent
		ndModExt$Extension_Module_ARMV7A.ndParent = ndParent;

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleStackRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULESTACKREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleStackRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleStackRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULESTACKREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleStackRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.dhModuleStackRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute ModuleStackRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleCodeRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULECODEREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleCodeRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleCodeRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULECODEREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleCodeRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.dhModuleCodeRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute ModuleCodeRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleDataRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULEDATAREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleDataRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleDataRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULEDATAREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleDataRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.dhModuleDataRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute ModuleDataRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleHeapRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULEHEAPREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleHeapRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleHeapRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULEHEAPREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleHeapRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.dhModuleHeapRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute ModuleHeapRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleFLTranslationTableRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULEFLTRANSLATIONTABLEREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleFLTranslationTableRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleFLTranslationTableRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULEFLTRANSLATIONTABLEREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleFLTranslationTableRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.dhModuleFLTranslationTableRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute ModuleFLTranslationTableRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleSLTranslationTableRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULESLTRANSLATIONTABLEREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleSLTranslationTableRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_Module_ARMV7A.dhModuleSLTranslationTableRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULESLTRANSLATIONTABLEREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleSLTranslationTableRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.dhModuleSLTranslationTableRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute ModuleSLTranslationTableRegionSizeBytes not found");
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
			if (Module.ATTRIBUTENAME_MODULESTACKREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULESTACKREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULECODEREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULECODEREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULEDATAREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULEDATAREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULEHEAPREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULEHEAPREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULEFLTRANSLATIONTABLEREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULEFLTRANSLATIONTABLEREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULESLTRANSLATIONTABLEREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULESLTRANSLATIONTABLEREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in ModExt:Extension_Module_ARMV7A node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in ModExt:Extension_Module_ARMV7A node");
		}

		// Returns node
		return ndModExt$Extension_Module_ARMV7A;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModExt$Extension_Module_ARMV7A
	 *            ModExt:Extension_Module_ARMV7A.
	 */
	public static Element cmdSave(Element elParent, ModExt$Extension_Module_ARMV7A ndModExt$Extension_Module_ARMV7A) throws ConfigurationException {

		// Creates element
		Element elModExt$Extension_Module_ARMV7A = elParent.getOwnerDocument().createElement(Module.NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A);

		// Verifies attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleStackRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULESTACKREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleStackRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleStackRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute ModuleStackRegionSizeBytes not assigned in ModExt:Extension_Module_ARMV7A");
		}

		// Saves attribute
		elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULESTACKREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleStackRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleCodeRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULECODEREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleCodeRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleCodeRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute ModuleCodeRegionSizeBytes not assigned in ModExt:Extension_Module_ARMV7A");
		}

		// Saves attribute
		elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULECODEREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleCodeRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleDataRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULEDATAREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleDataRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleDataRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute ModuleDataRegionSizeBytes not assigned in ModExt:Extension_Module_ARMV7A");
		}

		// Saves attribute
		elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULEDATAREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleDataRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleHeapRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULEHEAPREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleHeapRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleHeapRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute ModuleHeapRegionSizeBytes not assigned in ModExt:Extension_Module_ARMV7A");
		}

		// Saves attribute
		elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULEHEAPREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleHeapRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleFLTranslationTableRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULEFLTRANSLATIONTABLEREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleFLTranslationTableRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleFLTranslationTableRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute ModuleFLTranslationTableRegionSizeBytes not assigned in ModExt:Extension_Module_ARMV7A");
		}

		// Saves attribute
		elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULEFLTRANSLATIONTABLEREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleFLTranslationTableRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleSLTranslationTableRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULESLTRANSLATIONTABLEREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleSLTranslationTableRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_Module_ARMV7A.getModuleSLTranslationTableRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute ModuleSLTranslationTableRegionSizeBytes not assigned in ModExt:Extension_Module_ARMV7A");
		}

		// Saves attribute
		elModExt$Extension_Module_ARMV7A.setAttribute(Module.ATTRIBUTENAME_MODULESLTRANSLATIONTABLEREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_Module_ARMV7A.getModuleSLTranslationTableRegionSizeBytes()));

		// Returns element
		return elModExt$Extension_Module_ARMV7A;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhModuleStackRegionPhysicalAddress
	 *            ModuleStackRegionPhysicalAddress.
	 * @param dhModuleStackRegionSizeBytes
	 *            ModuleStackRegionSizeBytes.
	 * @param dhModuleCodeRegionPhysicalAddress
	 *            ModuleCodeRegionPhysicalAddress.
	 * @param dhModuleCodeRegionSizeBytes
	 *            ModuleCodeRegionSizeBytes.
	 * @param dhModuleDataRegionPhysicalAddress
	 *            ModuleDataRegionPhysicalAddress.
	 * @param dhModuleDataRegionSizeBytes
	 *            ModuleDataRegionSizeBytes.
	 * @param dhModuleHeapRegionPhysicalAddress
	 *            ModuleHeapRegionPhysicalAddress.
	 * @param dhModuleHeapRegionSizeBytes
	 *            ModuleHeapRegionSizeBytes.
	 * @param dhModuleFLTranslationTableRegionPhysicalAddress
	 *            ModuleFLTranslationTableRegionPhysicalAddress.
	 * @param dhModuleFLTranslationTableRegionSizeBytes
	 *            ModuleFLTranslationTableRegionSizeBytes.
	 * @param dhModuleSLTranslationTableRegionPhysicalAddress
	 *            ModuleSLTranslationTableRegionPhysicalAddress.
	 * @param dhModuleSLTranslationTableRegionSizeBytes
	 *            ModuleSLTranslationTableRegionSizeBytes.
	 */
	public static ModExt$Extension_Module_ARMV7A newInstance(Module ndParent, DecOrHexLong dhModuleStackRegionPhysicalAddress, DecOrHexLong dhModuleStackRegionSizeBytes, DecOrHexLong dhModuleCodeRegionPhysicalAddress, DecOrHexLong dhModuleCodeRegionSizeBytes, DecOrHexLong dhModuleDataRegionPhysicalAddress, DecOrHexLong dhModuleDataRegionSizeBytes, DecOrHexLong dhModuleHeapRegionPhysicalAddress, DecOrHexLong dhModuleHeapRegionSizeBytes, DecOrHexLong dhModuleFLTranslationTableRegionPhysicalAddress, DecOrHexLong dhModuleFLTranslationTableRegionSizeBytes, DecOrHexLong dhModuleSLTranslationTableRegionPhysicalAddress, DecOrHexLong dhModuleSLTranslationTableRegionSizeBytes) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ModExt$Extension_Module_ARMV7A(ndParent, dhModuleStackRegionPhysicalAddress, dhModuleStackRegionSizeBytes, dhModuleCodeRegionPhysicalAddress, dhModuleCodeRegionSizeBytes, dhModuleDataRegionPhysicalAddress, dhModuleDataRegionSizeBytes, dhModuleHeapRegionPhysicalAddress, dhModuleHeapRegionSizeBytes, dhModuleFLTranslationTableRegionPhysicalAddress, dhModuleFLTranslationTableRegionSizeBytes, dhModuleSLTranslationTableRegionPhysicalAddress, dhModuleSLTranslationTableRegionSizeBytes);
	}
}
