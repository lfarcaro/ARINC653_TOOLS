package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Destination node.
 */
public class Destination {

	/**
	 * Parent node.
	 */
	private Channel ndParent;

	/**
	 * Pseudo_Partition node list.
	 */
	private List<Destination_PseudoPartition> lsDestination_PseudoPartition = new LinkedList<Destination_PseudoPartition>();

	/**
	 * Standard_Partition node list.
	 */
	private List<Destination_StandardPartition> lsDestination_StandardPartition = new LinkedList<Destination_StandardPartition>();

	/**
	 * Constructor.
	 */
	private Destination() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 */
	private Destination(Channel ndParent) throws ConfigurationException {
		this.ndParent = ndParent;

		// Adds to parent
		if (!ndParent.addDestination(this)) {
			throw new ConfigurationException("Destination cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Channel getParent() {
		return ndParent;
	}

	/**
	 * Pseudo_Partition adder.
	 * 
	 * @param ndDestination_PseudoPartition
	 *            Pseudo_Partition.
	 */
	public boolean addDestination_PseudoPartition(Destination_PseudoPartition ndDestination_PseudoPartition) {

		// Verifies node
		if (ndDestination_PseudoPartition == null) {
			return false;
		}

		// Adds node
		lsDestination_PseudoPartition.add(ndDestination_PseudoPartition);
		return true;
	}

	/**
	 * Pseudo_Partition list getter.
	 */
	public List<Destination_PseudoPartition> getDestination_PseudoPartitionList() {
		return new LinkedList<Destination_PseudoPartition>(this.lsDestination_PseudoPartition);
	}

	/**
	 * Standard_Partition adder.
	 * 
	 * @param ndDestination_StandardPartition
	 *            Standard_Partition.
	 */
	public boolean addDestination_StandardPartition(Destination_StandardPartition ndDestination_StandardPartition) {

		// Verifies node
		if (ndDestination_StandardPartition == null) {
			return false;
		}

		// Adds node
		lsDestination_StandardPartition.add(ndDestination_StandardPartition);
		return true;
	}

	/**
	 * Standard_Partition list getter.
	 */
	public List<Destination_StandardPartition> getDestination_StandardPartitionList() {
		return new LinkedList<Destination_StandardPartition>(this.lsDestination_StandardPartition);
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Channel.
	 */
	public static Destination cmdLoad(Node ndNode, Channel ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_DESTINATION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Destination");
		}

		// Creates node
		Destination ndDestination = new Destination();

		// Sets parent
		ndDestination.ndParent = ndParent;

		// Iterates attributes
		NamedNodeMap nmAttributes = ndNode.getAttributes();
		for (int i = 0; i < nmAttributes.getLength(); i++) {

			// Gets next attribute
			Node ndAttribute = nmAttributes.item(i);

			// Verifies attribute
			if (ndAttribute.getNodeType() != Node.ATTRIBUTE_NODE) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Destination node");
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
			if (Module.NODENAME_DESTINATION_PSEUDOPARTITION.equals(ndChildNode.getNodeName())) {

				// Loads child
				Destination_PseudoPartition ndDestination_PseudoPartition = Destination_PseudoPartition.cmdLoad(ndChildNode, ndDestination);

				// Verifies child
				if (ndDestination_PseudoPartition == null) {
					throw new ConfigurationException("Error while loading a Pseudo_Partition node (Destination child)");
				}

				// Adds child
				ndDestination.addDestination_PseudoPartition(ndDestination_PseudoPartition);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_DESTINATION_STANDARDPARTITION.equals(ndChildNode.getNodeName())) {

				// Loads child
				Destination_StandardPartition ndDestination_StandardPartition = Destination_StandardPartition.cmdLoad(ndChildNode, ndDestination);

				// Verifies child
				if (ndDestination_StandardPartition == null) {
					throw new ConfigurationException("Error while loading a Standard_Partition node (Destination child)");
				}

				// Adds child
				ndDestination.addDestination_StandardPartition(ndDestination_StandardPartition);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Destination node");
		}

		// Returns node
		return ndDestination;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndDestination
	 *            Destination.
	 */
	public static Element cmdSave(Element elParent, Destination ndDestination) throws ConfigurationException {

		// Creates element
		Element elDestination = elParent.getOwnerDocument().createElement(Module.NODENAME_DESTINATION);

		// Iterates children
		Iterator<Destination_PseudoPartition> itDestination_PseudoPartition = ndDestination.getDestination_PseudoPartitionList().iterator();
		while (itDestination_PseudoPartition.hasNext()) {

			// Appends child
			elDestination.appendChild(Destination_PseudoPartition.cmdSave(elDestination, itDestination_PseudoPartition.next()));
		}

		// Iterates children
		Iterator<Destination_StandardPartition> itDestination_StandardPartition = ndDestination.getDestination_StandardPartitionList().iterator();
		while (itDestination_StandardPartition.hasNext()) {

			// Appends child
			elDestination.appendChild(Destination_StandardPartition.cmdSave(elDestination, itDestination_StandardPartition.next()));
		}

		// Returns element
		return elDestination;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 */
	public static Destination newInstance(Channel ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new Destination(ndParent);
	}
}
