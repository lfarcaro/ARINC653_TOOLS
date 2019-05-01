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
 * Auto-generated parser for Source node.
 */
public class Source {

	/**
	 * Parent node.
	 */
	private Channel ndParent;

	/**
	 * Pseudo_Partition node list.
	 */
	private List<Source_PseudoPartition> lsSource_PseudoPartition = new LinkedList<Source_PseudoPartition>();

	/**
	 * Standard_Partition node list.
	 */
	private List<Source_StandardPartition> lsSource_StandardPartition = new LinkedList<Source_StandardPartition>();

	/**
	 * Constructor.
	 */
	private Source() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 */
	private Source(Channel ndParent) throws ConfigurationException {
		this.ndParent = ndParent;

		// Adds to parent
		if (!ndParent.addSource(this)) {
			throw new ConfigurationException("Source cannot be added (probably its identifier attribute is duplicated)");
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
	 * @param ndSource_PseudoPartition
	 *            Pseudo_Partition.
	 */
	public boolean addSource_PseudoPartition(Source_PseudoPartition ndSource_PseudoPartition) {

		// Verifies node
		if (ndSource_PseudoPartition == null) {
			return false;
		}

		// Adds node
		lsSource_PseudoPartition.add(ndSource_PseudoPartition);
		return true;
	}

	/**
	 * Pseudo_Partition list getter.
	 */
	public List<Source_PseudoPartition> getSource_PseudoPartitionList() {
		return new LinkedList<Source_PseudoPartition>(this.lsSource_PseudoPartition);
	}

	/**
	 * Standard_Partition adder.
	 * 
	 * @param ndSource_StandardPartition
	 *            Standard_Partition.
	 */
	public boolean addSource_StandardPartition(Source_StandardPartition ndSource_StandardPartition) {

		// Verifies node
		if (ndSource_StandardPartition == null) {
			return false;
		}

		// Adds node
		lsSource_StandardPartition.add(ndSource_StandardPartition);
		return true;
	}

	/**
	 * Standard_Partition list getter.
	 */
	public List<Source_StandardPartition> getSource_StandardPartitionList() {
		return new LinkedList<Source_StandardPartition>(this.lsSource_StandardPartition);
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Channel.
	 */
	public static Source cmdLoad(Node ndNode, Channel ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_SOURCE.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Source");
		}

		// Creates node
		Source ndSource = new Source();

		// Sets parent
		ndSource.ndParent = ndParent;

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
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Source node");
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
			if (Module.NODENAME_SOURCE_PSEUDOPARTITION.equals(ndChildNode.getNodeName())) {

				// Loads child
				Source_PseudoPartition ndSource_PseudoPartition = Source_PseudoPartition.cmdLoad(ndChildNode, ndSource);

				// Verifies child
				if (ndSource_PseudoPartition == null) {
					throw new ConfigurationException("Error while loading a Pseudo_Partition node (Source child)");
				}

				// Adds child
				ndSource.addSource_PseudoPartition(ndSource_PseudoPartition);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_SOURCE_STANDARDPARTITION.equals(ndChildNode.getNodeName())) {

				// Loads child
				Source_StandardPartition ndSource_StandardPartition = Source_StandardPartition.cmdLoad(ndChildNode, ndSource);

				// Verifies child
				if (ndSource_StandardPartition == null) {
					throw new ConfigurationException("Error while loading a Standard_Partition node (Source child)");
				}

				// Adds child
				ndSource.addSource_StandardPartition(ndSource_StandardPartition);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Source node");
		}

		// Returns node
		return ndSource;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndSource
	 *            Source.
	 */
	public static Element cmdSave(Element elParent, Source ndSource) throws ConfigurationException {

		// Creates element
		Element elSource = elParent.getOwnerDocument().createElement(Module.NODENAME_SOURCE);

		// Iterates children
		Iterator<Source_PseudoPartition> itSource_PseudoPartition = ndSource.getSource_PseudoPartitionList().iterator();
		while (itSource_PseudoPartition.hasNext()) {

			// Appends child
			elSource.appendChild(Source_PseudoPartition.cmdSave(elSource, itSource_PseudoPartition.next()));
		}

		// Iterates children
		Iterator<Source_StandardPartition> itSource_StandardPartition = ndSource.getSource_StandardPartitionList().iterator();
		while (itSource_StandardPartition.hasNext()) {

			// Appends child
			elSource.appendChild(Source_StandardPartition.cmdSave(elSource, itSource_StandardPartition.next()));
		}

		// Returns element
		return elSource;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 */
	public static Source newInstance(Channel ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new Source(ndParent);
	}
}
