package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexLong;
import arinc653.configuration.parserresources.DecOrHexString;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for ModExt:Extension_AM335X node.
 */
public class ModExt$Extension_AM335X {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * RAMMemoryPhysicalAddress attribute.
	 */
	private DecOrHexLong dhRAMMemoryPhysicalAddress;

	/**
	 * RAMMemorySizeBytes attribute.
	 */
	private DecOrHexLong dhRAMMemorySizeBytes;

	/**
	 * SystemBootRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhSystemBootRegionPhysicalAddress;

	/**
	 * SystemBootRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhSystemBootRegionSizeBytes;

	/**
	 * SystemStackRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhSystemStackRegionPhysicalAddress;

	/**
	 * SystemStackRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhSystemStackRegionSizeBytes;

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
	 * SystemHeapRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhSystemHeapRegionPhysicalAddress;

	/**
	 * SystemHeapRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhSystemHeapRegionSizeBytes;

	/**
	 * SystemFLTranslationTableRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhSystemFLTranslationTableRegionPhysicalAddress;

	/**
	 * SystemFLTranslationTableRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhSystemFLTranslationTableRegionSizeBytes;

	/**
	 * SystemSLTranslationTableRegionPhysicalAddress attribute.
	 */
	private DecOrHexLong dhSystemSLTranslationTableRegionPhysicalAddress;

	/**
	 * SystemSLTranslationTableRegionSizeBytes attribute.
	 */
	private DecOrHexLong dhSystemSLTranslationTableRegionSizeBytes;

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
	 * ModuleNetworkPhysicalAddress attribute.
	 */
	private DecOrHexString dhModuleNetworkPhysicalAddress;

	/**
	 * Constructor.
	 */
	private ModExt$Extension_AM335X() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhRAMMemoryPhysicalAddress
	 *            RAMMemoryPhysicalAddress.
	 * @param dhRAMMemorySizeBytes
	 *            RAMMemorySizeBytes.
	 * @param dhSystemBootRegionPhysicalAddress
	 *            SystemBootRegionPhysicalAddress.
	 * @param dhSystemBootRegionSizeBytes
	 *            SystemBootRegionSizeBytes.
	 * @param dhSystemStackRegionPhysicalAddress
	 *            SystemStackRegionPhysicalAddress.
	 * @param dhSystemStackRegionSizeBytes
	 *            SystemStackRegionSizeBytes.
	 * @param dhSystemCodeRegionPhysicalAddress
	 *            SystemCodeRegionPhysicalAddress.
	 * @param dhSystemCodeRegionSizeBytes
	 *            SystemCodeRegionSizeBytes.
	 * @param dhSystemDataRegionPhysicalAddress
	 *            SystemDataRegionPhysicalAddress.
	 * @param dhSystemDataRegionSizeBytes
	 *            SystemDataRegionSizeBytes.
	 * @param dhSystemHeapRegionPhysicalAddress
	 *            SystemHeapRegionPhysicalAddress.
	 * @param dhSystemHeapRegionSizeBytes
	 *            SystemHeapRegionSizeBytes.
	 * @param dhSystemFLTranslationTableRegionPhysicalAddress
	 *            SystemFLTranslationTableRegionPhysicalAddress.
	 * @param dhSystemFLTranslationTableRegionSizeBytes
	 *            SystemFLTranslationTableRegionSizeBytes.
	 * @param dhSystemSLTranslationTableRegionPhysicalAddress
	 *            SystemSLTranslationTableRegionPhysicalAddress.
	 * @param dhSystemSLTranslationTableRegionSizeBytes
	 *            SystemSLTranslationTableRegionSizeBytes.
	 * @param dhModuleCodeRegionPhysicalAddress
	 *            ModuleCodeRegionPhysicalAddress.
	 * @param dhModuleCodeRegionSizeBytes
	 *            ModuleCodeRegionSizeBytes.
	 * @param dhModuleDataRegionPhysicalAddress
	 *            ModuleDataRegionPhysicalAddress.
	 * @param dhModuleDataRegionSizeBytes
	 *            ModuleDataRegionSizeBytes.
	 * @param dhModuleNetworkPhysicalAddress
	 *            ModuleNetworkPhysicalAddress.
	 */
	private ModExt$Extension_AM335X(Module ndParent, DecOrHexLong dhRAMMemoryPhysicalAddress, DecOrHexLong dhRAMMemorySizeBytes, DecOrHexLong dhSystemBootRegionPhysicalAddress, DecOrHexLong dhSystemBootRegionSizeBytes, DecOrHexLong dhSystemStackRegionPhysicalAddress, DecOrHexLong dhSystemStackRegionSizeBytes, DecOrHexLong dhSystemCodeRegionPhysicalAddress, DecOrHexLong dhSystemCodeRegionSizeBytes, DecOrHexLong dhSystemDataRegionPhysicalAddress, DecOrHexLong dhSystemDataRegionSizeBytes, DecOrHexLong dhSystemHeapRegionPhysicalAddress, DecOrHexLong dhSystemHeapRegionSizeBytes, DecOrHexLong dhSystemFLTranslationTableRegionPhysicalAddress, DecOrHexLong dhSystemFLTranslationTableRegionSizeBytes, DecOrHexLong dhSystemSLTranslationTableRegionPhysicalAddress, DecOrHexLong dhSystemSLTranslationTableRegionSizeBytes, DecOrHexLong dhModuleCodeRegionPhysicalAddress, DecOrHexLong dhModuleCodeRegionSizeBytes, DecOrHexLong dhModuleDataRegionPhysicalAddress, DecOrHexLong dhModuleDataRegionSizeBytes, DecOrHexString dhModuleNetworkPhysicalAddress) throws ConfigurationException {
		this.ndParent = ndParent;
		this.dhRAMMemoryPhysicalAddress = dhRAMMemoryPhysicalAddress;
		this.dhRAMMemorySizeBytes = dhRAMMemorySizeBytes;
		this.dhSystemBootRegionPhysicalAddress = dhSystemBootRegionPhysicalAddress;
		this.dhSystemBootRegionSizeBytes = dhSystemBootRegionSizeBytes;
		this.dhSystemStackRegionPhysicalAddress = dhSystemStackRegionPhysicalAddress;
		this.dhSystemStackRegionSizeBytes = dhSystemStackRegionSizeBytes;
		this.dhSystemCodeRegionPhysicalAddress = dhSystemCodeRegionPhysicalAddress;
		this.dhSystemCodeRegionSizeBytes = dhSystemCodeRegionSizeBytes;
		this.dhSystemDataRegionPhysicalAddress = dhSystemDataRegionPhysicalAddress;
		this.dhSystemDataRegionSizeBytes = dhSystemDataRegionSizeBytes;
		this.dhSystemHeapRegionPhysicalAddress = dhSystemHeapRegionPhysicalAddress;
		this.dhSystemHeapRegionSizeBytes = dhSystemHeapRegionSizeBytes;
		this.dhSystemFLTranslationTableRegionPhysicalAddress = dhSystemFLTranslationTableRegionPhysicalAddress;
		this.dhSystemFLTranslationTableRegionSizeBytes = dhSystemFLTranslationTableRegionSizeBytes;
		this.dhSystemSLTranslationTableRegionPhysicalAddress = dhSystemSLTranslationTableRegionPhysicalAddress;
		this.dhSystemSLTranslationTableRegionSizeBytes = dhSystemSLTranslationTableRegionSizeBytes;
		this.dhModuleCodeRegionPhysicalAddress = dhModuleCodeRegionPhysicalAddress;
		this.dhModuleCodeRegionSizeBytes = dhModuleCodeRegionSizeBytes;
		this.dhModuleDataRegionPhysicalAddress = dhModuleDataRegionPhysicalAddress;
		this.dhModuleDataRegionSizeBytes = dhModuleDataRegionSizeBytes;
		this.dhModuleNetworkPhysicalAddress = dhModuleNetworkPhysicalAddress;

		// Adds to parent
		if (!ndParent.addModExt$Extension_AM335X(this)) {
			throw new ConfigurationException("ModExt:Extension_AM335X cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
		return ndParent;
	}

	/**
	 * RAMMemoryPhysicalAddress getter.
	 */
	public DecOrHexLong getRAMMemoryPhysicalAddress() {
		return this.dhRAMMemoryPhysicalAddress;
	}

	/**
	 * RAMMemoryPhysicalAddress setter.
	 */
	public void setRAMMemoryPhysicalAddress(DecOrHexLong dhRAMMemoryPhysicalAddress) {
		this.dhRAMMemoryPhysicalAddress = dhRAMMemoryPhysicalAddress;
	}

	/**
	 * RAMMemorySizeBytes getter.
	 */
	public DecOrHexLong getRAMMemorySizeBytes() {
		return this.dhRAMMemorySizeBytes;
	}

	/**
	 * RAMMemorySizeBytes setter.
	 */
	public void setRAMMemorySizeBytes(DecOrHexLong dhRAMMemorySizeBytes) {
		this.dhRAMMemorySizeBytes = dhRAMMemorySizeBytes;
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
	 * SystemStackRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getSystemStackRegionPhysicalAddress() {
		return this.dhSystemStackRegionPhysicalAddress;
	}

	/**
	 * SystemStackRegionPhysicalAddress setter.
	 */
	public void setSystemStackRegionPhysicalAddress(DecOrHexLong dhSystemStackRegionPhysicalAddress) {
		this.dhSystemStackRegionPhysicalAddress = dhSystemStackRegionPhysicalAddress;
	}

	/**
	 * SystemStackRegionSizeBytes getter.
	 */
	public DecOrHexLong getSystemStackRegionSizeBytes() {
		return this.dhSystemStackRegionSizeBytes;
	}

	/**
	 * SystemStackRegionSizeBytes setter.
	 */
	public void setSystemStackRegionSizeBytes(DecOrHexLong dhSystemStackRegionSizeBytes) {
		this.dhSystemStackRegionSizeBytes = dhSystemStackRegionSizeBytes;
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
	 * SystemHeapRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getSystemHeapRegionPhysicalAddress() {
		return this.dhSystemHeapRegionPhysicalAddress;
	}

	/**
	 * SystemHeapRegionPhysicalAddress setter.
	 */
	public void setSystemHeapRegionPhysicalAddress(DecOrHexLong dhSystemHeapRegionPhysicalAddress) {
		this.dhSystemHeapRegionPhysicalAddress = dhSystemHeapRegionPhysicalAddress;
	}

	/**
	 * SystemHeapRegionSizeBytes getter.
	 */
	public DecOrHexLong getSystemHeapRegionSizeBytes() {
		return this.dhSystemHeapRegionSizeBytes;
	}

	/**
	 * SystemHeapRegionSizeBytes setter.
	 */
	public void setSystemHeapRegionSizeBytes(DecOrHexLong dhSystemHeapRegionSizeBytes) {
		this.dhSystemHeapRegionSizeBytes = dhSystemHeapRegionSizeBytes;
	}

	/**
	 * SystemFLTranslationTableRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getSystemFLTranslationTableRegionPhysicalAddress() {
		return this.dhSystemFLTranslationTableRegionPhysicalAddress;
	}

	/**
	 * SystemFLTranslationTableRegionPhysicalAddress setter.
	 */
	public void setSystemFLTranslationTableRegionPhysicalAddress(DecOrHexLong dhSystemFLTranslationTableRegionPhysicalAddress) {
		this.dhSystemFLTranslationTableRegionPhysicalAddress = dhSystemFLTranslationTableRegionPhysicalAddress;
	}

	/**
	 * SystemFLTranslationTableRegionSizeBytes getter.
	 */
	public DecOrHexLong getSystemFLTranslationTableRegionSizeBytes() {
		return this.dhSystemFLTranslationTableRegionSizeBytes;
	}

	/**
	 * SystemFLTranslationTableRegionSizeBytes setter.
	 */
	public void setSystemFLTranslationTableRegionSizeBytes(DecOrHexLong dhSystemFLTranslationTableRegionSizeBytes) {
		this.dhSystemFLTranslationTableRegionSizeBytes = dhSystemFLTranslationTableRegionSizeBytes;
	}

	/**
	 * SystemSLTranslationTableRegionPhysicalAddress getter.
	 */
	public DecOrHexLong getSystemSLTranslationTableRegionPhysicalAddress() {
		return this.dhSystemSLTranslationTableRegionPhysicalAddress;
	}

	/**
	 * SystemSLTranslationTableRegionPhysicalAddress setter.
	 */
	public void setSystemSLTranslationTableRegionPhysicalAddress(DecOrHexLong dhSystemSLTranslationTableRegionPhysicalAddress) {
		this.dhSystemSLTranslationTableRegionPhysicalAddress = dhSystemSLTranslationTableRegionPhysicalAddress;
	}

	/**
	 * SystemSLTranslationTableRegionSizeBytes getter.
	 */
	public DecOrHexLong getSystemSLTranslationTableRegionSizeBytes() {
		return this.dhSystemSLTranslationTableRegionSizeBytes;
	}

	/**
	 * SystemSLTranslationTableRegionSizeBytes setter.
	 */
	public void setSystemSLTranslationTableRegionSizeBytes(DecOrHexLong dhSystemSLTranslationTableRegionSizeBytes) {
		this.dhSystemSLTranslationTableRegionSizeBytes = dhSystemSLTranslationTableRegionSizeBytes;
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
	public static ModExt$Extension_AM335X cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODEXT$EXTENSION_AM335X.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a ModExt:Extension_AM335X");
		}

		// Creates node
		ModExt$Extension_AM335X ndModExt$Extension_AM335X = new ModExt$Extension_AM335X();

		// Sets parent
		ndModExt$Extension_AM335X.ndParent = ndParent;

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhRAMMemoryPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_RAMMEMORYPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute RAMMemoryPhysicalAddress value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhRAMMemoryPhysicalAddress == null) {
			throw new ConfigurationException("Required attribute RAMMemoryPhysicalAddress not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhRAMMemorySizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_RAMMEMORYSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute RAMMemorySizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhRAMMemorySizeBytes == null) {
			throw new ConfigurationException("Required attribute RAMMemorySizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemBootRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMBOOTREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemBootRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemBootRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMBOOTREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemBootRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhSystemBootRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute SystemBootRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemStackRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMSTACKREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemStackRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemStackRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMSTACKREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemStackRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhSystemStackRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute SystemStackRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemCodeRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMCODEREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemCodeRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemCodeRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMCODEREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemCodeRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhSystemCodeRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute SystemCodeRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemDataRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMDATAREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemDataRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemDataRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMDATAREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemDataRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhSystemDataRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute SystemDataRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemHeapRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMHEAPREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemHeapRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemHeapRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMHEAPREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemHeapRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhSystemHeapRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute SystemHeapRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemFLTranslationTableRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMFLTRANSLATIONTABLEREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemFLTranslationTableRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemFLTranslationTableRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMFLTRANSLATIONTABLEREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemFLTranslationTableRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhSystemFLTranslationTableRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute SystemFLTranslationTableRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemSLTranslationTableRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMSLTRANSLATIONTABLEREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemSLTranslationTableRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhSystemSLTranslationTableRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMSLTRANSLATIONTABLEREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemSLTranslationTableRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhSystemSLTranslationTableRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute SystemSLTranslationTableRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhModuleCodeRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULECODEREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleCodeRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhModuleCodeRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULECODEREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleCodeRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhModuleCodeRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute ModuleCodeRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhModuleDataRegionPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULEDATAREGIONPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleDataRegionPhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhModuleDataRegionSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MODULEDATAREGIONSIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleDataRegionSizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhModuleDataRegionSizeBytes == null) {
			throw new ConfigurationException("Required attribute ModuleDataRegionSizeBytes not found");
		}

		// Loads attribute
		try {
			ndModExt$Extension_AM335X.dhModuleNetworkPhysicalAddress = ConfigurationUtilities.getDecOrHexStringAttribute(ndNode, Module.ATTRIBUTENAME_MODULENETWORKPHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleNetworkPhysicalAddress value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.dhModuleNetworkPhysicalAddress == null) {
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
			if (Module.ATTRIBUTENAME_RAMMEMORYPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_RAMMEMORYSIZEBYTES.equals(ndAttribute.getNodeName())) {
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
			if (Module.ATTRIBUTENAME_SYSTEMSTACKREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMSTACKREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
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

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMHEAPREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMHEAPREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMFLTRANSLATIONTABLEREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMFLTRANSLATIONTABLEREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMSLTRANSLATIONTABLEREGIONPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMSLTRANSLATIONTABLEREGIONSIZEBYTES.equals(ndAttribute.getNodeName())) {
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
			if (Module.ATTRIBUTENAME_MODULENETWORKPHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in ModExt:Extension_AM335X node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in ModExt:Extension_AM335X node");
		}

		// Returns node
		return ndModExt$Extension_AM335X;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModExt$Extension_AM335X
	 *            ModExt:Extension_AM335X.
	 */
	public static Element cmdSave(Element elParent, ModExt$Extension_AM335X ndModExt$Extension_AM335X) throws ConfigurationException {

		// Creates element
		Element elModExt$Extension_AM335X = elParent.getOwnerDocument().createElement(Module.NODENAME_MODEXT$EXTENSION_AM335X);

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getRAMMemoryPhysicalAddress() == null) {
			throw new ConfigurationException("Required attribute RAMMemoryPhysicalAddress not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_RAMMEMORYPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getRAMMemoryPhysicalAddress()));

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getRAMMemorySizeBytes() == null) {
			throw new ConfigurationException("Required attribute RAMMemorySizeBytes not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_RAMMEMORYSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getRAMMemorySizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_AM335X.getSystemBootRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMBOOTREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemBootRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getSystemBootRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute SystemBootRegionSizeBytes not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMBOOTREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemBootRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_AM335X.getSystemStackRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMSTACKREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemStackRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getSystemStackRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute SystemStackRegionSizeBytes not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMSTACKREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemStackRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_AM335X.getSystemCodeRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMCODEREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemCodeRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getSystemCodeRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute SystemCodeRegionSizeBytes not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMCODEREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemCodeRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_AM335X.getSystemDataRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMDATAREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemDataRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getSystemDataRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute SystemDataRegionSizeBytes not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMDATAREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemDataRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_AM335X.getSystemHeapRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMHEAPREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemHeapRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getSystemHeapRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute SystemHeapRegionSizeBytes not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMHEAPREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemHeapRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_AM335X.getSystemFLTranslationTableRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMFLTRANSLATIONTABLEREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemFLTranslationTableRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getSystemFLTranslationTableRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute SystemFLTranslationTableRegionSizeBytes not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMFLTRANSLATIONTABLEREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemFLTranslationTableRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_AM335X.getSystemSLTranslationTableRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMSLTRANSLATIONTABLEREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemSLTranslationTableRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getSystemSLTranslationTableRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute SystemSLTranslationTableRegionSizeBytes not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_SYSTEMSLTRANSLATIONTABLEREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getSystemSLTranslationTableRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_AM335X.getModuleCodeRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_MODULECODEREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getModuleCodeRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getModuleCodeRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute ModuleCodeRegionSizeBytes not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_MODULECODEREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getModuleCodeRegionSizeBytes()));

		// Verifies attribute
		if (ndModExt$Extension_AM335X.getModuleDataRegionPhysicalAddress() != null) {

			// Saves attribute
			elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_MODULEDATAREGIONPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getModuleDataRegionPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getModuleDataRegionSizeBytes() == null) {
			throw new ConfigurationException("Required attribute ModuleDataRegionSizeBytes not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_MODULEDATAREGIONSIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndModExt$Extension_AM335X.getModuleDataRegionSizeBytes()));

		// Verifies required attribute
		if (ndModExt$Extension_AM335X.getModuleNetworkPhysicalAddress() == null) {
			throw new ConfigurationException("Required attribute ModuleNetworkPhysicalAddress not assigned in ModExt:Extension_AM335X");
		}

		// Saves attribute
		elModExt$Extension_AM335X.setAttribute(Module.ATTRIBUTENAME_MODULENETWORKPHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexString(ndModExt$Extension_AM335X.getModuleNetworkPhysicalAddress()));

		// Returns element
		return elModExt$Extension_AM335X;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhRAMMemoryPhysicalAddress
	 *            RAMMemoryPhysicalAddress.
	 * @param dhRAMMemorySizeBytes
	 *            RAMMemorySizeBytes.
	 * @param dhSystemBootRegionPhysicalAddress
	 *            SystemBootRegionPhysicalAddress.
	 * @param dhSystemBootRegionSizeBytes
	 *            SystemBootRegionSizeBytes.
	 * @param dhSystemStackRegionPhysicalAddress
	 *            SystemStackRegionPhysicalAddress.
	 * @param dhSystemStackRegionSizeBytes
	 *            SystemStackRegionSizeBytes.
	 * @param dhSystemCodeRegionPhysicalAddress
	 *            SystemCodeRegionPhysicalAddress.
	 * @param dhSystemCodeRegionSizeBytes
	 *            SystemCodeRegionSizeBytes.
	 * @param dhSystemDataRegionPhysicalAddress
	 *            SystemDataRegionPhysicalAddress.
	 * @param dhSystemDataRegionSizeBytes
	 *            SystemDataRegionSizeBytes.
	 * @param dhSystemHeapRegionPhysicalAddress
	 *            SystemHeapRegionPhysicalAddress.
	 * @param dhSystemHeapRegionSizeBytes
	 *            SystemHeapRegionSizeBytes.
	 * @param dhSystemFLTranslationTableRegionPhysicalAddress
	 *            SystemFLTranslationTableRegionPhysicalAddress.
	 * @param dhSystemFLTranslationTableRegionSizeBytes
	 *            SystemFLTranslationTableRegionSizeBytes.
	 * @param dhSystemSLTranslationTableRegionPhysicalAddress
	 *            SystemSLTranslationTableRegionPhysicalAddress.
	 * @param dhSystemSLTranslationTableRegionSizeBytes
	 *            SystemSLTranslationTableRegionSizeBytes.
	 * @param dhModuleCodeRegionPhysicalAddress
	 *            ModuleCodeRegionPhysicalAddress.
	 * @param dhModuleCodeRegionSizeBytes
	 *            ModuleCodeRegionSizeBytes.
	 * @param dhModuleDataRegionPhysicalAddress
	 *            ModuleDataRegionPhysicalAddress.
	 * @param dhModuleDataRegionSizeBytes
	 *            ModuleDataRegionSizeBytes.
	 * @param dhModuleNetworkPhysicalAddress
	 *            ModuleNetworkPhysicalAddress.
	 */
	public static ModExt$Extension_AM335X newInstance(Module ndParent, DecOrHexLong dhRAMMemoryPhysicalAddress, DecOrHexLong dhRAMMemorySizeBytes, DecOrHexLong dhSystemBootRegionPhysicalAddress, DecOrHexLong dhSystemBootRegionSizeBytes, DecOrHexLong dhSystemStackRegionPhysicalAddress, DecOrHexLong dhSystemStackRegionSizeBytes, DecOrHexLong dhSystemCodeRegionPhysicalAddress, DecOrHexLong dhSystemCodeRegionSizeBytes, DecOrHexLong dhSystemDataRegionPhysicalAddress, DecOrHexLong dhSystemDataRegionSizeBytes, DecOrHexLong dhSystemHeapRegionPhysicalAddress, DecOrHexLong dhSystemHeapRegionSizeBytes, DecOrHexLong dhSystemFLTranslationTableRegionPhysicalAddress, DecOrHexLong dhSystemFLTranslationTableRegionSizeBytes, DecOrHexLong dhSystemSLTranslationTableRegionPhysicalAddress, DecOrHexLong dhSystemSLTranslationTableRegionSizeBytes, DecOrHexLong dhModuleCodeRegionPhysicalAddress, DecOrHexLong dhModuleCodeRegionSizeBytes, DecOrHexLong dhModuleDataRegionPhysicalAddress, DecOrHexLong dhModuleDataRegionSizeBytes, DecOrHexString dhModuleNetworkPhysicalAddress) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ModExt$Extension_AM335X(ndParent, dhRAMMemoryPhysicalAddress, dhRAMMemorySizeBytes, dhSystemBootRegionPhysicalAddress, dhSystemBootRegionSizeBytes, dhSystemStackRegionPhysicalAddress, dhSystemStackRegionSizeBytes, dhSystemCodeRegionPhysicalAddress, dhSystemCodeRegionSizeBytes, dhSystemDataRegionPhysicalAddress, dhSystemDataRegionSizeBytes, dhSystemHeapRegionPhysicalAddress, dhSystemHeapRegionSizeBytes, dhSystemFLTranslationTableRegionPhysicalAddress, dhSystemFLTranslationTableRegionSizeBytes, dhSystemSLTranslationTableRegionPhysicalAddress, dhSystemSLTranslationTableRegionSizeBytes, dhModuleCodeRegionPhysicalAddress, dhModuleCodeRegionSizeBytes, dhModuleDataRegionPhysicalAddress, dhModuleDataRegionSizeBytes, dhModuleNetworkPhysicalAddress);
	}
}
