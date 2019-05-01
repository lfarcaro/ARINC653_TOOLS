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
public class Destination_StandardPartition {

	/**
	 * Parent node.
	 */
	private Destination ndParent;

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
	private Destination_StandardPartition() {
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
	private Destination_StandardPartition(Destination ndParent, Identifier idPartitionIdentifier, String stPartitionName, String stPortName, DecOrHexLong dhPhysicalAddress) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idPartitionIdentifier = idPartitionIdentifier;
		this.stPartitionName = stPartitionName;
		this.stPortName = stPortName;
		this.dhPhysicalAddress = dhPhysicalAddress;

		// Adds to parent
		if (!ndParent.addDestination_StandardPartition(this)) {
			throw new ConfigurationException("Standard_Partition cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Destination getParent() {
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
	 *            Destination.
	 */
	public static Destination_StandardPartition cmdLoad(Node ndNode, Destination ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_DESTINATION_STANDARDPARTITION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Standard_Partition");
		}

		// Creates node
		Destination_StandardPartition ndDestination_StandardPartition = new Destination_StandardPartition();

		// Sets parent
		ndDestination_StandardPartition.ndParent = ndParent;

		// Loads attribute
		try {
			ndDestination_StandardPartition.idPartitionIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PartitionIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndDestination_StandardPartition.idPartitionIdentifier == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not found");
		}

		// Loads attribute
		ndDestination_StandardPartition.stPartitionName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONNAME);

		// Loads attribute
		ndDestination_StandardPartition.stPortName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_PORTNAME);

		// Verifies attribute
		if (ndDestination_StandardPartition.stPortName == null) {
			throw new ConfigurationException("Required attribute PortName not found");
		}

		// Loads attribute
		try {
			ndDestination_StandardPartition.dhPhysicalAddress = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_PHYSICALADDRESS);
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
		return ndDestination_StandardPartition;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndDestination_StandardPartition
	 *            Standard_Partition.
	 */
	public static Element cmdSave(Element elParent, Destination_StandardPartition ndDestination_StandardPartition) throws ConfigurationException {

		// Creates element
		Element elDestination_StandardPartition = elParent.getOwnerDocument().createElement(Module.NODENAME_DESTINATION_STANDARDPARTITION);

		// Verifies required attribute
		if (ndDestination_StandardPartition.getPartitionIdentifier() == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not assigned in Standard_Partition");
		}

		// Saves attribute
		elDestination_StandardPartition.setAttribute(Module.ATTRIBUTENAME_PARTITIONIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndDestination_StandardPartition.getPartitionIdentifier()));

		// Verifies attribute
		if (ndDestination_StandardPartition.getPartitionName() != null) {

			// Saves attribute
			elDestination_StandardPartition.setAttribute(Module.ATTRIBUTENAME_PARTITIONNAME, ConfigurationUtilities.getAttributeString(ndDestination_StandardPartition.getPartitionName()));
		}

		// Verifies required attribute
		if (ndDestination_StandardPartition.getPortName() == null) {
			throw new ConfigurationException("Required attribute PortName not assigned in Standard_Partition");
		}

		// Saves attribute
		elDestination_StandardPartition.setAttribute(Module.ATTRIBUTENAME_PORTNAME, ConfigurationUtilities.getAttributeString(ndDestination_StandardPartition.getPortName()));

		// Verifies attribute
		if (ndDestination_StandardPartition.getPhysicalAddress() != null) {

			// Saves attribute
			elDestination_StandardPartition.setAttribute(Module.ATTRIBUTENAME_PHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexLong(ndDestination_StandardPartition.getPhysicalAddress()));
		}

		// Returns element
		return elDestination_StandardPartition;
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
	public static Destination_StandardPartition newInstance(Destination ndParent, Identifier idPartitionIdentifier, String stPartitionName, String stPortName, DecOrHexLong dhPhysicalAddress) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new Destination_StandardPartition(ndParent, idPartitionIdentifier, stPartitionName, stPortName, dhPhysicalAddress);
	}
}
