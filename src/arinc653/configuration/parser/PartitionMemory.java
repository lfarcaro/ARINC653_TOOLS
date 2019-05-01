package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Partition_Memory node.
 */
public class PartitionMemory {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * PartitionIdentifier attribute.
	 */
	private Identifier idPartitionIdentifier;

	/**
	 * PartitionName attribute.
	 */
	private String stPartitionName;

	/**
	 * Memory_Requirements node list.
	 */
	private List<MemoryRequirements> lsMemoryRequirements = new LinkedList<MemoryRequirements>();

	/**
	 * Constructor.
	 */
	private PartitionMemory() {
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
	 */
	private PartitionMemory(Module ndParent, Identifier idPartitionIdentifier, String stPartitionName) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idPartitionIdentifier = idPartitionIdentifier;
		this.stPartitionName = stPartitionName;

		// Adds to parent
		if (!ndParent.addPartitionMemory(this)) {
			throw new ConfigurationException("Partition_Memory cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
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
	 * Memory_Requirements adder.
	 * 
	 * @param ndMemoryRequirements
	 *            Memory_Requirements.
	 */
	public boolean addMemoryRequirements(MemoryRequirements ndMemoryRequirements) {

		// Verifies node
		if (ndMemoryRequirements == null) {
			return false;
		}

		// Adds node
		lsMemoryRequirements.add(ndMemoryRequirements);
		return true;
	}

	/**
	 * Memory_Requirements list getter.
	 */
	public List<MemoryRequirements> getMemoryRequirementsList() {
		return new LinkedList<MemoryRequirements>(this.lsMemoryRequirements);
	}

	@Override
	public int hashCode() {
		return (idPartitionIdentifier != null ? idPartitionIdentifier.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof PartitionMemory)) {
			return false;
		}

		// Casts object
		PartitionMemory ndPartitionMemory = (PartitionMemory) obObject;

		// Verifies identifiers
		if ((ndPartitionMemory.getPartitionIdentifier() == null) || (idPartitionIdentifier == null)) {
			return ((ndPartitionMemory.getPartitionIdentifier() == null) && (idPartitionIdentifier == null));
		}

		// Verifies identifiers
		if (ndPartitionMemory.getPartitionIdentifier().equals(idPartitionIdentifier)) {
			return true;
		}

		// Not equal
		return false;
	}

	@Override
	public String toString() {
		return (idPartitionIdentifier != null ? idPartitionIdentifier.toString() : super.toString());
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            ARINC_653_Module.
	 */
	public static PartitionMemory cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_PARTITIONMEMORY.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Partition_Memory");
		}

		// Creates node
		PartitionMemory ndPartitionMemory = new PartitionMemory();

		// Sets parent
		ndPartitionMemory.ndParent = ndParent;

		// Loads attribute
		try {
			ndPartitionMemory.idPartitionIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PartitionIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndPartitionMemory.idPartitionIdentifier == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not found");
		}

		// Loads attribute
		ndPartitionMemory.stPartitionName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONNAME);

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

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Partition_Memory node");
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

			// Verifies node
			if (Module.NODENAME_MEMORYREQUIREMENTS.equals(ndChildNode.getNodeName())) {

				// Loads child
				MemoryRequirements ndMemoryRequirements = MemoryRequirements.cmdLoad(ndChildNode, ndPartitionMemory);

				// Verifies child
				if (ndMemoryRequirements == null) {
					throw new ConfigurationException("Error while loading a Memory_Requirements node (Partition_Memory child)");
				}

				// Adds child
				ndPartitionMemory.addMemoryRequirements(ndMemoryRequirements);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Partition_Memory node");
		}

		// Returns node
		return ndPartitionMemory;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndPartitionMemory
	 *            Partition_Memory.
	 */
	public static Element cmdSave(Element elParent, PartitionMemory ndPartitionMemory) throws ConfigurationException {

		// Creates element
		Element elPartitionMemory = elParent.getOwnerDocument().createElement(Module.NODENAME_PARTITIONMEMORY);

		// Verifies required attribute
		if (ndPartitionMemory.getPartitionIdentifier() == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not assigned in Partition_Memory");
		}

		// Saves attribute
		elPartitionMemory.setAttribute(Module.ATTRIBUTENAME_PARTITIONIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndPartitionMemory.getPartitionIdentifier()));

		// Verifies attribute
		if (ndPartitionMemory.getPartitionName() != null) {

			// Saves attribute
			elPartitionMemory.setAttribute(Module.ATTRIBUTENAME_PARTITIONNAME, ConfigurationUtilities.getAttributeString(ndPartitionMemory.getPartitionName()));
		}

		// Iterates children
		Iterator<MemoryRequirements> itMemoryRequirements = ndPartitionMemory.getMemoryRequirementsList().iterator();
		while (itMemoryRequirements.hasNext()) {

			// Appends child
			elPartitionMemory.appendChild(MemoryRequirements.cmdSave(elPartitionMemory, itMemoryRequirements.next()));
		}

		// Returns element
		return elPartitionMemory;
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
	 */
	public static PartitionMemory newInstance(Module ndParent, Identifier idPartitionIdentifier, String stPartitionName) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new PartitionMemory(ndParent, idPartitionIdentifier, stPartitionName);
	}
}
