package arinc653.configuration.parsergenerator;

/**
 * Attribute.
 * 
 * @author Luís Fernando Arcaro
 */
public class Attribute {

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
	 * Attribute type.
	 */
	private AttributeType atAttributeType;

	/**
	 * Required.
	 */
	private boolean blRequired = true;

	/**
	 * Default value;
	 */
	private String stDefaultValue;

	/**
	 * Constructor.
	 * 
	 * @param ndParentNode
	 *            Parent node.
	 * @param stName
	 *            Name.
	 * @param stJavaName
	 *            Java name.
	 * @param atAttributeType
	 *            Attribute type.
	 */
	public Attribute(Node ndParentNode, String stName, String stJavaName, AttributeType atAttributeType) {
		this.ndParentNode = ndParentNode;
		this.stName = stName;
		this.stJavaName = stJavaName;
		this.atAttributeType = atAttributeType;

		// Adds to parent node
		if (ndParentNode != null) {
			if (!ndParentNode.addAttribute(this)) {
				throw new RuntimeException("Cannot add attribute to parent node");
			}
		}
	}

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
	public Attribute(Node ndParentNode, String stName, String stJavaName) {
		this(ndParentNode, stName, stJavaName, AttributeType_STRING.INSTANCE);
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
	 * Attribute type getter.
	 */
	public AttributeType getAttributeType() {
		return atAttributeType;
	}

	/**
	 * Required setter.
	 */
	public void setRequired(boolean blRequired) {
		this.blRequired = blRequired;
	}

	/**
	 * Required getter.
	 */
	public boolean getRequired() {
		return blRequired;
	}

	/**
	 * Default value setter.
	 */
	public void setDefaultValue(String stDefaultValue) {
		this.stDefaultValue = stDefaultValue;
	}

	/**
	 * Default value getter.
	 */
	public String getDefaultValue() {
		return stDefaultValue;
	}

	@Override
	public String toString() {
		return stName + (stJavaName.equals(stName) ? "" : " (" + stJavaName + ")");
	}
}