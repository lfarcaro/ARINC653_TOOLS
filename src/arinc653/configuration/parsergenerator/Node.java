package arinc653.configuration.parsergenerator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Node.
 * 
 * @author Luís Fernando Arcaro
 */
public class Node {

	/**
	 * Parent node.
	 */
	private Node ndParentNode;

	/**
	 * Name.
	 */
	private String stName;

	/**
	 * Java name.
	 */
	private String stJavaName;

	/**
	 * Attribute list.
	 */
	private List<Attribute> lsAttribute = new LinkedList<Attribute>();

	/**
	 * Attribute map.
	 */
	private Map<String, Attribute> mpAttribute = new HashMap<String, Attribute>();

	/**
	 * Node list.
	 */
	private List<Node> lsNode = new LinkedList<Node>();

	/**
	 * Node map.
	 */
	private Map<String, Node> mpNode = new HashMap<String, Node>();

	/**
	 * Identification attribute.
	 */
	private String stIdentificationAttribute;

	/**
	 * Ignored node pattern.
	 */
	private String stIgnoredNodePattern;

	/**
	 * Allow other attributes.
	 */
	private boolean blAllowOtherAttributes = false;

	/**
	 * Constructor.
	 * 
	 * @param ndParentNode
	 *            Parent node.
	 * @param stName
	 *            Name.
	 * @param stJavaName
	 *            Java name.
	 */
	public Node(Node ndParentNode, String stName, String stJavaName) {
		this.ndParentNode = ndParentNode;
		this.stName = stName;
		this.stJavaName = stJavaName;

		// Adds to parent node
		if (ndParentNode != null) {
			if (!ndParentNode.addNode(this)) {
				throw new RuntimeException("Cannot add node to parent node");
			}
		}
	}

	/**
	 * Parent node getter.
	 */
	public Node getParentNode() {
		return ndParentNode;
	}

	/**
	 * Name getter.
	 */
	public String getName() {
		return stName;
	}

	/**
	 * Java name getter.
	 */
	public String getJavaName() {
		return stJavaName;
	}

	/**
	 * Attributes getter.
	 */
	public List<Attribute> getAttributes() {
		return lsAttribute;
	}

	/**
	 * Nodes getter.
	 */
	public List<Node> getNodes() {
		return lsNode;
	}

	/**
	 * Attribute adder.
	 * 
	 * @param atAttribute
	 *            Attribute.
	 */
	public boolean addAttribute(Attribute atAttribute) {

		// Verifies attribute
		if (mpAttribute.containsKey(atAttribute.getName().intern())) {
			return false;
		}

		// Adds attribute
		lsAttribute.add(atAttribute);

		// Adds attribute
		mpAttribute.put(atAttribute.getName().intern(), atAttribute);
		return true;
	}

	/**
	 * Attribute getter.
	 * 
	 * @param stName
	 *            Name.
	 */
	public Attribute getAttribute(String stName) {

		// Verifies attribute
		if (!mpAttribute.containsKey(stName.intern())) {
			return null;
		}

		// Gets attribute
		return mpAttribute.get(stName.intern());
	}

	/**
	 * Node adder.
	 * 
	 * @param ndNode
	 *            Node.
	 */
	public boolean addNode(Node ndNode) {

		// Verifies node
		if (mpNode.containsKey(ndNode.getName().intern())) {
			return false;
		}

		// Adds node
		lsNode.add(ndNode);

		// Adds node
		mpNode.put(ndNode.getName().intern(), ndNode);
		return true;
	}

	/**
	 * Node getter.
	 * 
	 * @param stName
	 *            Name.
	 */
	public Node getNode(String stName) {

		// Verifies node
		if (!mpNode.containsKey(stName.intern())) {
			return null;
		}

		// Gets node
		return mpNode.get(stName.intern());
	}

	/**
	 * Identification attribute setter.
	 */
	public void setIdentificationAttribute(String stIdentificationAttribute) {
		this.stIdentificationAttribute = stIdentificationAttribute;
	}

	/**
	 * Identification attribute getter.
	 */
	public String getIdentificationAttribute() {
		return stIdentificationAttribute;
	}

	/**
	 * Ignored node pattern setter.
	 */
	public void setIgnoredNodePattern(String stIgnoredNodePattern) {
		this.stIgnoredNodePattern = stIgnoredNodePattern;
	}

	/**
	 * Ignored node pattern getter.
	 */
	public String getIgnoredNodePattern() {
		return stIgnoredNodePattern;
	}

	/**
	 * Allow other attributes setter.
	 */
	public void setAllowOtherAttributes(boolean blAllowOtherAttributes) {
		this.blAllowOtherAttributes = blAllowOtherAttributes;
	}

	/**
	 * Allow other attributes getter.
	 */
	public boolean getAllowOtherAttributes() {
		return blAllowOtherAttributes;
	}

	/**
	 * Root verification method.
	 */
	public boolean isRoot() {
		return (ndParentNode == null);
	}

	/**
	 * Recursive node list getter.
	 */
	private void getRecursiveNodeList(List<Node> lsRecursiveNode) {

		// Adds node
		lsRecursiveNode.add(this);

		// Iterates nodes
		Iterator<Node> itNode = lsNode.iterator();
		while (itNode.hasNext()) {

			// Gets next node
			Node ndNode = itNode.next();

			// Gets recursive node list
			ndNode.getRecursiveNodeList(lsRecursiveNode);
		}
	}

	/**
	 * Recursive node list getter.
	 */
	public List<Node> getRecursiveNodeList() {

		// Creates recursive node list
		List<Node> lsRecursiveNode = new LinkedList<Node>();

		// Gets recursive node list
		getRecursiveNodeList(lsRecursiveNode);

		// Returns recursive node list
		return lsRecursiveNode;
	}

	/**
	 * Recursive attribute list getter.
	 */
	private void getRecursiveAttributeList(List<Attribute> lsRecursiveAttribute) {

		// Adds attributes
		lsRecursiveAttribute.addAll(lsAttribute);

		// Iterates nodes
		Iterator<Node> itNode = lsNode.iterator();
		while (itNode.hasNext()) {

			// Gets next node
			Node ndNode = itNode.next();

			// Gets attribute list
			ndNode.getRecursiveAttributeList(lsRecursiveAttribute);
		}
	}

	/**
	 * Recursive attribute list getter.
	 */
	public List<Attribute> getRecursiveAttributeList() {

		// Creates recursive attribute list
		List<Attribute> lsRecursiveAttribute = new LinkedList<Attribute>();

		// Gets recursive attribute list
		getRecursiveAttributeList(lsRecursiveAttribute);

		// Returns recursive attribute list
		return lsRecursiveAttribute;
	}

	/**
	 * Root getter.
	 */
	public Node getRoot() {

		// Prepares node
		Node ndNode = this;

		// Search root loop
		while (!ndNode.isRoot()) {

			// Gets parent
			ndNode = ndNode.getParentNode();
		}

		// Returns node
		return ndNode;
	}

	@Override
	public String toString() {
		return stName + (stJavaName.equals(stName) ? "" : " (" + stJavaName + ")");
	}
}