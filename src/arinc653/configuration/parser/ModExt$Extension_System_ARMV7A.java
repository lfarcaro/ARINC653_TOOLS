package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexLong;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for ModExt:Extension_System_ARMV7A node.
 */
public class ModExt$Extension_System_ARMV7A {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * SystemRAMMemoryPhysicalAddress attribute.
	 */
	private DecOrHexLong dhSystemRAMMemoryPhysicalAddress;

	/**
	 * SystemRAMMemorySizeBytes attribute.
	 */
	private DecOrHexLong dhSystemRAMMemorySizeBytes;

	/**
	 * SystemBootRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhSystemBootRegionPhysicalAddress;

	/**
	 * SystemBootRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhSystemBootRegionSizeBytes;

	/**
	 * SystemCodeRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhSystemCodeRegionPhysicalAddress;

	/**
	 * SystemCodeRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhSystemCodeRegionSizeBytes;

	/**
	 * SystemDataRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhSystemDataRegionPhysicalAddress;

	/**
	 * SystemDataRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhSystemDataRegionSizeBytes;

	/**
	 * Constructor.
	 */
	private ModExt$Extension_System_ARMV7A() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhSystemRAMMemoryPhysicalAddress
	 *            SystemRAMMemoryPhysicalAddress.
	 * @param dhSystemRAMMemorySizeBytes
	 *            SystemRAMMemorySizeBytes.
	 * @param dhSystemBootRegionPhysicalAddress
	 *            SystemBootRegionPhysicalAddress.
	 * @param dhSystemBootRegionSizeBytes
	 *            SystemBootRegionSizeBytes.
	 * @param dhSystemCodeRegionPhysicalAddress
	 *            SystemCodeRegionPhysicalAddress.
	 * @param dhSystemCodeRegionSizeBytes
	 *            SystemCodeRegionSizeBytes.
	 * @param dhSystemDataRegionPhysicalAddress
	 *            SystemDataRegionPhysicalAddress.
	 * @param dhSystemDataRegionSizeBytes
	 *            SystemDataRegionSizeBytes.
	 */
	private ModExt$Extension_System_ARMV7A(Module ndParent, DecOrHexLong dhSystemRAMMemoryPhysicalAddress, DecOrHexLong dhSystemRAMMemorySizeBytes, DecOrHexLong dhSystemBootRegionPhysicalAddress, DecOrHexLong dhSystemBootRegionSizeBytes, DecOrHexLong dhSystemCodeRegionPhysicalAddress, DecOrHexLong dhSystemCodeRegionSizeBytes, DecOrHexLong dhSystemDataRegionPhysicalAddress, DecOrHexLong dhSystemDataRegionSizeBytes) throws ConfigurationException {
		this.ndParent = ndParent;
		this.dhSystemRAMMemoryPhysicalAddress = dhSystemRAMMemoryPhysicalAddress;
		this.dhSystemRAMMemorySizeBytes = dhSystemRAMMemorySizeBytes;
		this.dhSystemBootRegionPhysicalAddress = dhSystemBootRegionPhysicalAddress;
		this.dhSystemBootRegionSizeBytes = dhSystemBootRegionSizeBytes;
		this.dhSystemCodeRegionPhysicalAddress = dhSystemCodeRegionPhysicalAddress;
		this.dhSystemCodeRegionSizeBytes = dhSystemCodeRegionSizeBytes;
		this.dhSystemDataRegionPhysicalAddress = dhSystemDataRegionPhysicalAddress;
		this.dhSystemDataRegionSizeBytes = dhSystemDataRegionSizeBytes;

		// Adds to parent
		if (!ndParent.addModExt$Extension_System_ARMV7A(this)) {
			throw new ConfigurationException("ModExt:Extension_System_ARMV7A cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
		return ndParent;
	}

	/**
	 * SystemRAMMemoryPhysicalAddress getter.
	 */
	public DecOrHexLong getSystemRAMMemoryPhysicalAddress() {
		return this.dhSystemRAMMemoryPhysicalAddress;
	}

	/**
	 * SystemRAMMemoryPhysicalAddress setter.
	 */
	public void setSystemRAMMemoryPhysicalAddress(DecOrHexLong dhSystemRAMMemoryPhysicalAddress) {
		this.dhSystemRAMMemoryPhysicalAddress = dhSystemRAMMemoryPhysicalAddress;
	}

	/**
	 * SystemRAMMemorySizeBytes getter.
	 */
	public DecOrHexLong getSystemRAMMemorySizeBytes() {
		return this.dhSystemRAMMemorySizeBytes;
	}

	/**
	 * SystemRAMMemorySizeBytes setter.
	 */
	public void setSystemRAMMemorySizeBytes(DecOrHexLong dhSystemRAMMemorySizeBytes) {
		this.dhSystemRAMMemorySizeBytes = dhSystemRAMMemorySizeBytes;
	}

	/**
	 * SystemBootRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getSystemBootRegionPhysicalAddress() {
		return this.dhSystemBootRegionPhysicalAddress;
	}

	/**
	 * SystemBootRegionPhysicalAddress setter.
	 */
	public void setSystemBootRegionPhysicalAddress(DecOrHexLong dhSystemBootRegionPhysicalAddress) {
		this.dhSystemBootRegionPhysicalAddress = dhSystemBootRegionPhysicalAddress;
	}

	/**
	 * SystemBootRegionSizeBytes getter.
	 */
	public DecOrHexLong getSystemBootRegionSizeBytes() {
		return this.dhSystemBootRegionSizeBytes;
	}

	/**
	 * SystemBootRegionSizeBytes setter.
	 */
	public void setSystemBootRegionSizeBytes(DecOrHexLong dhSystemBootRegionSizeBytes) {
		this.dhSystemBootRegionSizeBytes = dhSystemBootRegionSizeBytes;
	}

	/**
	 * SystemCodeRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getSystemCodeRegionPhysicalAddress() {
		return this.dhSystemCodeRegionPhysicalAddress;
	}

	/**
	 * SystemCodeRegionPhysicalAddress setter.
	 */
	public void setSystemCodeRegionPhysicalAddress(DecOrHexLong dhSystemCodeRegionPhysicalAddress) {
		this.dhSystemCodeRegionPhysicalAddress = dhSystemCodeRegionPhysicalAddress;
	}

	/**
	 * SystemCodeRegionSizeBytes getter.
	 */
	public DecOrHexLong getSystemCodeRegionSizeBytes() {
		return this.dhSystemCodeRegionSizeBytes;
	}

	/**
	 * SystemCodeRegionSizeBytes setter.
	 */
	public void setSystemCodeRegionSizeBytes(DecOrHexLong dhSystemCodeRegionSizeBytes) {
		this.dhSystemCodeRegionSizeBytes = dhSystemCodeRegionSizeBytes;
	}

	/**
	 * SystemDataRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getSystemDataRegionPhysicalAddress() {
		return this.dhSystemDataRegionPhysicalAddress;
	}

	/**
	 * SystemDataRegionPhysicalAddress setter.
	 */
	public void setSystemDataRegionPhysicalAddress(DecOrHexLong dhSystemDataRegionPhysicalAddress) {
		this.dhSystemDataRegionPhysicalAddress = dhSystemDataRegionPhysicalAddress;
	}

	/**
	 * SystemDataRegionSizeBytes getter.
	 */
	public DecOrHexLong getSystemDataRegionSizeBytes() {
		return this.dhSystemDataRegionSizeBytes;
	}

	/**
	 * SystemDataRegionSizeBytes setter.
	 */
	public void setSystemDataRegionSizeBytes(DecOrHexLong dhSystemDataRegionSizeBytes) {
		this.dhSystemDataRegionSizeBytes = dhSystemDataRegionSizeBytes;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            ARINC_653_Module.
	 */
	public static ModExt$Extension_System_ARMV7A cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODEXT$EXTENSION_SYSTEM_ARMV7A.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a ModExt:Extension_System_ARMV7A");
		}

		// Creates node
		ModExt$Extension_System_ARMV7A ndModExt$Extension_System_ARMV7A = new ModExt$Extension_System_ARMV7A();

		// Sets parent
		ndModExt$Extension_System_ARMV7A.ndParent = ndParent;

		// Loads attribute
		try {
			ndModExt$Extension_System_ARMV7A.dhSystemRAMMemoryPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMRAMMEMORYPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemRAMMemoryPhysicalAddress value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_System_ARMV7A.dhSystemRAMMemoryPhysicalAddress == null) {
			throw new ConfigurationException("Required attribute SystemRAMMemoryPhysicalAddress not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_System_ARMV7A.dhSystemRAMMemorySizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMRAMMEMORYSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemRAMMemorySizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_System_ARMV7A.dhSystemRAMMemorySizeBytes == null) {
			throw new ConfigurationException("Required attribute SystemRAMMemorySizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_System_ARMV7A.dhSystemBootRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMBOOTREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemBootRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_System_ARMV7A.dhSystemBootRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMBOOTREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemBootRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_System_ARMV7A.dhSystemBootRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute SystemBootRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_System_ARMV7A.dhSystemCodeRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMCODEREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemCodeRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_System_ARMV7A.dhSystemCodeRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMCODEREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemCodeRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_System_ARMV7A.dhSystemCodeRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute SystemCodeRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_System_ARMV7A.dhSystemDataRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMDATAREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemDataRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_System_ARMV7A.dhSystemDataRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMDATAREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemDataRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_System_ARMV7A.dhSystemDataRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute SystemDataRegionSizeBytes not found");
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
			if (Module.ATTRIBUTENAME_SYSTEMRAMMEMORYPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMRAMMEMORYSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMBOOTREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMBOOTREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMCODEREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMCODEREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMDATAREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMDATAREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in ModExt:Extension_System_ARMV7A node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in ModExt:Extension_System_ARMV7A node");
		}

		// Returns node
		return ndModExt$Extension_System_ARMV7A;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModExt$Extension_System_ARMV7A
	 *            ModExt:Extension_System_ARMV7A.
	 */
	public static Element cmdSave(Element elParent, ModExt$Extension_System_ARMV7A ndModExt$Extension_System_ARMV7A) throws ConfigurationException {

		// Creates element
		Element elModExt$Extension_System_ARMV7A = elParent.getOwnerDocument().createElement(Module.NODENAME_MODEXT$EXTENSION_SYSTEM_ARMV7A);

		// Verifies required attribute
		if (ndModExt$Extension_System_ARMV7A.getSystemRAMMemoryPhysicalAddress() == null) {
			throw new ConfigurationException("Required attribute SystemRAMMemoryPhysicalAddress not assigned in ModExt:Extension_System_ARMV7A");
		}

		// Saves attribute
		elModExt$Extension_System_ARMV7A.setAttribute(Module.ATTRIBUTENAME_SYSTEMRAMMEMORYPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_System_ARMV7A.getSystemRAMMemoryPhysicalAddress()));

		// Verifies required attribute
		if (ndModExt$Extension_System_ARMV7A.getSystemRAMMemorySizeBytes() == null) {
			throw new ConfigurationException("Required attribute SystemRAMMemorySizeBytes not assigned in ModExt:Extension_System_ARMV7A");
		}

		// Saves attribute
		elModExt$Extension_System_ARMV7A.setAttribute(Module.ATTRIBUTENAME_SYSTEMRAMMEMORYSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_System_ARMV7A.getSystemRAMMemorySizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_System_ARMV7A.getSystemBootRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_System_ARMV7A.setAttribute(Module.ATTRIBUTENAME_SYSTEMBOOTREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_System_ARMV7A.getSystemBootRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_System_ARMV7A.getSystemBootRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute SystemBootRegionSizeBytes not assigned in ModExt:Extension_System_ARMV7A");
		}

		// Saves attribute
		elModExt$Extension_System_ARMV7A.setAttribute(Module.ATTRIBUTENAME_SYSTEMBOOTREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_System_ARMV7A.getSystemBootRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_System_ARMV7A.getSystemCodeRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_System_ARMV7A.setAttribute(Module.ATTRIBUTENAME_SYSTEMCODEREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_System_ARMV7A.getSystemCodeRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_System_ARMV7A.getSystemCodeRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute SystemCodeRegionSizeBytes not assigned in ModExt:Extension_System_ARMV7A");
		}

		// Saves attribute
		elModExt$Extension_System_ARMV7A.setAttribute(Module.ATTRIBUTENAME_SYSTEMCODEREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_System_ARMV7A.getSystemCodeRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_System_ARMV7A.getSystemDataRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_System_ARMV7A.setAttribute(Module.ATTRIBUTENAME_SYSTEMDATAREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_System_ARMV7A.getSystemDataRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_System_ARMV7A.getSystemDataRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute SystemDataRegionSizeBytes not assigned in ModExt:Extension_System_ARMV7A");
		}

		// Saves attribute
		elModExt$Extension_System_ARMV7A.setAttribute(Module.ATTRIBUTENAME_SYSTEMDATAREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_System_ARMV7A.getSystemDataRegionSizeBytes()));

		// Returns element
		return elModExt$Extension_System_ARMV7A;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhSystemRAMMemoryPhysicalAddress
	 *            SystemRAMMemoryPhysicalAddress.
	 * @param dhSystemRAMMemorySizeBytes
	 *            SystemRAMMemorySizeBytes.
	 * @param dhSystemBootRegionPhysicalAddress
	 *            SystemBootRegionPhysicalAddress.
	 * @param dhSystemBootRegionSizeBytes
	 *            SystemBootRegionSizeBytes.
	 * @param dhSystemCodeRegionPhysicalAddress
	 *            SystemCodeRegionPhysicalAddress.
	 * @param dhSystemCodeRegionSizeBytes
	 *            SystemCodeRegionSizeBytes.
	 * @param dhSystemDataRegionPhysicalAddress
	 *            SystemDataRegionPhysicalAddress.
	 * @param dhSystemDataRegionSizeBytes
	 *            SystemDataRegionSizeBytes.
	 */
	public static ModExt$Extension_System_ARMV7A newInstance(Module ndParent, DecOrHexLong dhSystemRAMMemoryPhysicalAddress, DecOrHexLong dhSystemRAMMemorySizeBytes, DecOrHexLong dhSystemBootRegionPhysicalAddress, DecOrHexLong dhSystemBootRegionSizeBytes, DecOrHexLong dhSystemCodeRegionPhysicalAddress, DecOrHexLong dhSystemCodeRegionSizeBytes, DecOrHexLong dhSystemDataRegionPhysicalAddress, DecOrHexLong dhSystemDataRegionSizeBytes) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ModExt$Extension_System_ARMV7A(ndParent, dhSystemRAMMemoryPhysicalAddress, dhSystemRAMMemorySizeBytes, dhSystemBootRegionPhysicalAddress, dhSystemBootRegionSizeBytes, dhSystemCodeRegionPhysicalAddress, dhSystemCodeRegionSizeBytes, dhSystemDataRegionPhysicalAddress, dhSystemDataRegionSizeBytes);
	}
}
