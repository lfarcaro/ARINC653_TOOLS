package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexLong;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Memory_Requirements node.
 */
public class MemoryRequirements {

	/**
	 * Parent node.
	 */
	private PartitionMemory ndParent;

	/**
	 * RegionName attribute.
	 */
	private String stRegionName;

	/**
	 * Type attribute.
	 */
	private String stType;

	/**
	 * SizeBytes attribute.
	 */
	private DecOrHexLong dhSizeBytes;

	/**
	 * PhysicalAddress attribute.
	 */
	private DecOrHexLong dhPhysicalAddress;

	/**
	 * Access attribute.
	 */
	private String stAccess;

	/**
	 * Constructor.
	 */
	private MemoryRequirements() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stRegionName
	 *            RegionName.
	 * @param stType
	 *            Type.
	 * @param dhSizeBytes
	 *            SizeBytes.
	 * @param dhPhysicalAddress
	 *            PhysicalAddress.
	 * @param stAccess
	 *            Access.
	 */
	private MemoryRequirements(PartitionMemory ndParent, String stRegionName, String stType, DecOrHexLong dhSizeBytes, DecOrHexLong dhPhysicalAddress, String stAccess) throws ConfigurationException {
		this.ndParent = ndParent;
		this.stRegionName = stRegionName;
		this.stType = stType;
		this.dhSizeBytes = dhSizeBytes;
		this.dhPhysicalAddress = dhPhysicalAddress;
		this.stAccess = stAccess;

		// Adds to parent
		if (!ndParent.addMemoryRequirements(this)) {
			throw new ConfigurationException("Memory_Requirements cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public PartitionMemory getParent() {
		return ndParent;
	}

	/**
	 * RegionName getter.
	 */
	public String getRegionName() {
		return this.stRegionName;
	}

	/**
	 * RegionName setter.
	 */
	public void setRegionName(String stRegionName) {
		this.stRegionName = stRegionName;
	}

	/**
	 * Type getter.
	 */
	public String getType() {
		return this.stType;
	}

	/**
	 * Type setter.
	 */
	public void setType(String stType) {
		this.stType = stType;
	}

	/**
	 * SizeBytes getter.
	 */
	public DecOrHexLong getSizeBytes() {
		return this.dhSizeBytes;
	}

	/**
	 * SizeBytes setter.
	 */
	public void setSizeBytes(DecOrHexLong dhSizeBytes) {
		this.dhSizeBytes = dhSizeBytes;
	}

	/**
	 * PhysicalAddress getter.
	 */
	public DecOrHexLong getPhysicalAddress() {
		return this.dhPhysicalAddress;
	}

	/**
	 * PhysicalAddress setter.
	 */
	public void setPhysicalAddress(DecOrHexLong dhPhysicalAddress) {
		this.dhPhysicalAddress = dhPhysicalAddress;
	}

	/**
	 * Access getter.
	 */
	public String getAccess() {
		return this.stAccess;
	}

	/**
	 * Access setter.
	 */
	public void setAccess(String stAccess) {
		this.stAccess = stAccess;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Partition_Memory.
	 */
	public static MemoryRequirements cmdLoad(Node ndNode, PartitionMemory ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MEMORYREQUIREMENTS.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Memory_Requirements");
		}

		// Creates node
		MemoryRequirements ndMemoryRequirements = new MemoryRequirements();

		// Sets parent
		ndMemoryRequirements.ndParent = ndParent;

		// Loads attribute
		ndMemoryRequirements.stRegionName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_REGIONNAME);

		// Loads attribute
		ndMemoryRequirements.stType = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_TYPE);

		// Verifies attribute
		if (ndMemoryRequirements.stType == null) {
			throw new ConfigurationException("Required attribute Type not found");
		}

		// Loads attribute
		try {
			ndMemoryRequirements.dhSizeBytes = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_SIZEBYTES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SizeBytes value cannot be parsed");
		}

		// Verifies required attribute
		if (ndMemoryRequirements.dhSizeBytes == null) {
			throw new ConfigurationException("Required attribute SizeBytes not found");
		}

		// Loads attribute
		try {
			ndMemoryRequirements.dhPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_PHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		ndMemoryRequirements.stAccess = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_ACCESS);

		// Verifies attribute
		if (ndMemoryRequirements.stAccess == null) {
			throw new ConfigurationException("Required attribute Access not found");
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
			if (Module.ATTRIBUTENAME_REGIONNAME.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_TYPE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SIZEBYTES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_ACCESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Memory_Requirements node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Memory_Requirements node");
		}

		// Returns node
		return ndMemoryRequirements;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndMemoryRequirements
	 *            Memory_Requirements.
	 */
	public static Element cmdSave(Element elParent, MemoryRequirements ndMemoryRequirements) throws ConfigurationException {

		// Creates element
		Element elMemoryRequirements = elParent.getOwnerDocument().createElement(Module.NODENAME_MEMORYREQUIREMENTS);

		// Verifies attribute
		if (ndMemoryRequirements.getRegionName() != null) {

			// Saves attribute
			elMemoryRequirements.setAttribute(Module.ATTRIBUTENAME_REGIONNAME, ConfigurationUtilities.getAttributeString(ndMemoryRequirements.getRegionName()));
		}

		// Verifies required attribute
		if (ndMemoryRequirements.getType() == null) {
			throw new ConfigurationException("Required attribute Type not assigned in Memory_Requirements");
		}

		// Saves attribute
		elMemoryRequirements.setAttribute(Module.ATTRIBUTENAME_TYPE, ConfigurationUtilities.getAttributeString(ndMemoryRequirements.getType()));

		// Verifies required attribute
		if (ndMemoryRequirements.getSizeBytes() == null) {
			throw new ConfigurationException("Required attribute SizeBytes not assigned in Memory_Requirements");
		}

		// Saves attribute
		elMemoryRequirements.setAttribute(Module.ATTRIBUTENAME_SIZEBYTES, ConfigurationUtilities.getAttributeDecOrHexLong(ndMemoryRequirements.getSizeBytes()));

		// Verifies attribute
		if (ndMemoryRequirements.getPhysicalAddress() != null) {

			// Saves attribute
			elMemoryRequirements.setAttribute(Module.ATTRIBUTENAME_PHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndMemoryRequirements.getPhysicalAddress()));
		}

		// Verifies required attribute
		if (ndMemoryRequirements.getAccess() == null) {
			throw new ConfigurationException("Required attribute Access not assigned in Memory_Requirements");
		}

		// Saves attribute
		elMemoryRequirements.setAttribute(Module.ATTRIBUTENAME_ACCESS, ConfigurationUtilities.getAttributeString(ndMemoryRequirements.getAccess()));

		// Returns element
		return elMemoryRequirements;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stRegionName
	 *            RegionName.
	 * @param stType
	 *            Type.
	 * @param dhSizeBytes
	 *            SizeBytes.
	 * @param dhPhysicalAddress
	 *            PhysicalAddress.
	 * @param stAccess
	 *            Access.
	 */
	public static MemoryRequirements newInstance(PartitionMemory ndParent, String stRegionName, String stType, DecOrHexLong dhSizeBytes, DecOrHexLong dhPhysicalAddress, String stAccess) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new MemoryRequirements(ndParent, stRegionName, stType, dhSizeBytes, dhPhysicalAddress, stAccess);
	}
}
