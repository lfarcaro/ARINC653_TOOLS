package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexLong;
import arinc653.configuration.parserresources.Identifier;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Standard_Partition node.
 */
public class Source_StandardPartition {

	/**
	 * Parent node.
	 */
	private Source ndParent;

	/**
	 * PartitionIdentifier attribute.
	 */
	private Identifier idPartitionIdentifier;

	/**
	 * PartitionName attribute.
	 */
	private String stPartitionName;

	/**
	 * PortName attribute.
	 */
	private String stPortName;

	/**
	 * PhysicalAddress attribute.
	 */
	private DecOrHexLong dhPhysicalAddress;

	/**
	 * Constructor.
	 */
	private Source_StandardPartition() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idPartitionIdentifier
	 *            PartitionIdentifier.
	 * @param stPartitionName
	 *            PartitionName.
	 * @param stPortName
	 *            PortName.
	 * @param dhPhysicalAddress
	 *            PhysicalAddress.
	 */
	private Source_StandardPartition(Source ndParent, Identifier idPartitionIdentifier, String stPartitionName, String stPortName, DecOrHexLong dhPhysicalAddress) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idPartitionIdentifier = idPartitionIdentifier;
		this.stPartitionName = stPartitionName;
		this.stPortName = stPortName;
		this.dhPhysicalAddress = dhPhysicalAddress;

		// Adds to parent
		if (!ndParent.addSource_StandardPartition(this)) {
			throw new ConfigurationException("Standard_Partition cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Source getParent() {
		return ndParent;
	}

	/**
	 * PartitionIdentifier getter.
	 */
	public Identifier getPartitionIdentifier() {
		return this.idPartitionIdentifier;
	}

	/**
	 * PartitionIdentifier setter.
	 */
	public void setPartitionIdentifier(Identifier idPartitionIdentifier) {
		this.idPartitionIdentifier = idPartitionIdentifier;
	}

	/**
	 * PartitionName getter.
	 */
	public String getPartitionName() {
		return this.stPartitionName;
	}

	/**
	 * PartitionName setter.
	 */
	public void setPartitionName(String stPartitionName) {
		this.stPartitionName = stPartitionName;
	}

	/**
	 * PortName getter.
	 */
	public String getPortName() {
		return this.stPortName;
	}

	/**
	 * PortName setter.
	 */
	public void setPortName(String stPortName) {
		this.stPortName = stPortName;
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
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Source.
	 */
	public static Source_StandardPartition cmdLoad(Node ndNode, Source ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_SOURCE_STANDARDPARTITION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Standard_Partition");
		}

		// Creates node
		Source_StandardPartition ndSource_StandardPartition = new Source_StandardPartition();

		// Sets parent
		ndSource_StandardPartition.ndParent = ndParent;

		// Loads attribute
		try {
			ndSource_StandardPartition.idPartitionIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PartitionIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndSource_StandardPartition.idPartitionIdentifier == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not found");
		}

		// Loads attribute
		ndSource_StandardPartition.stPartitionName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONNAME);

		// Loads attribute
		ndSource_StandardPartition.stPortName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_PORTNAME);

		// Verifies attribute
		if (ndSource_StandardPartition.stPortName == null) {
			throw new ConfigurationException("Required attribute PortName not found");
		}

		// Loads attribute
		try {
			ndSource_StandardPartition.dhPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_PHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PhysicalAddress value cannot be parsed");
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
			if (Module.ATTRIBUTENAME_PARTITIONIDENTIFIER.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PARTITIONNAME.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PORTNAME.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Standard_Partition node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Standard_Partition node");
		}

		// Returns node
		return ndSource_StandardPartition;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndSource_StandardPartition
	 *            Standard_Partition.
	 */
	public static Element cmdSave(Element elParent, Source_StandardPartition ndSource_StandardPartition) throws ConfigurationException {

		// Creates element
		Element elSource_StandardPartition = elParent.getOwnerDocument().createElement(Module.NODENAME_SOURCE_STANDARDPARTITION);

		// Verifies required attribute
		if (ndSource_StandardPartition.getPartitionIdentifier() == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not assigned in Standard_Partition");
		}

		// Saves attribute
		elSource_StandardPartition.setAttribute(Module.ATTRIBUTENAME_PARTITIONIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndSource_StandardPartition.getPartitionIdentifier()));

		// Verifies attribute
		if (ndSource_StandardPartition.getPartitionName() != null) {

			// Saves attribute
			elSource_StandardPartition.setAttribute(Module.ATTRIBUTENAME_PARTITIONNAME, ConfigurationUtilities.getAttributeString(ndSource_StandardPartition.getPartitionName()));
		}

		// Verifies required attribute
		if (ndSource_StandardPartition.getPortName() == null) {
			throw new ConfigurationException("Required attribute PortName not assigned in Standard_Partition");
		}

		// Saves attribute
		elSource_StandardPartition.setAttribute(Module.ATTRIBUTENAME_PORTNAME, ConfigurationUtilities.getAttributeString(ndSource_StandardPartition.getPortName()));

		// Verifies attribute
		if (ndSource_StandardPartition.getPhysicalAddress() != null) {

			// Saves attribute
			elSource_StandardPartition.setAttribute(Module.ATTRIBUTENAME_PHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndSource_StandardPartition.getPhysicalAddress()));
		}

		// Returns element
		return elSource_StandardPartition;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idPartitionIdentifier
	 *            PartitionIdentifier.
	 * @param stPartitionName
	 *            PartitionName.
	 * @param stPortName
	 *            PortName.
	 * @param dhPhysicalAddress
	 *            PhysicalAddress.
	 */
	public static Source_StandardPartition newInstance(Source ndParent, Identifier idPartitionIdentifier, String stPartitionName, String stPortName, DecOrHexLong dhPhysicalAddress) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new Source_StandardPartition(ndParent, idPartitionIdentifier, stPartitionName, stPortName, dhPhysicalAddress);
	}
}
