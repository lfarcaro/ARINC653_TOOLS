package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexString;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Pseudo_Partition node.
 */
public class Source_PseudoPartition {

	/**
	 * Parent node.
	 */
	private Source ndParent;

	/**
	 * Name attribute.
	 */
	private String stName;

	/**
	 * PhysicalAddress attribute.
	 */
	private DecOrHexString dhPhysicalAddress;

	/**
	 * Procedure attribute.
	 */
	private String stProcedure;

	/**
	 * Constructor.
	 */
	private Source_PseudoPartition() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stName
	 *            Name.
	 * @param dhPhysicalAddress
	 *            PhysicalAddress.
	 * @param stProcedure
	 *            Procedure.
	 */
	private Source_PseudoPartition(Source ndParent, String stName, DecOrHexString dhPhysicalAddress, String stProcedure) throws ConfigurationException {
		this.ndParent = ndParent;
		this.stName = stName;
		this.dhPhysicalAddress = dhPhysicalAddress;
		this.stProcedure = stProcedure;

		// Adds to parent
		if (!ndParent.addSource_PseudoPartition(this)) {
			throw new ConfigurationException("Pseudo_Partition cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Source getParent() {
		return ndParent;
	}

	/**
	 * Name getter.
	 */
	public String getName() {
		return this.stName;
	}

	/**
	 * Name setter.
	 */
	public void setName(String stName) {
		this.stName = stName;
	}

	/**
	 * PhysicalAddress getter.
	 */
	public DecOrHexString getPhysicalAddress() {
		return this.dhPhysicalAddress;
	}

	/**
	 * PhysicalAddress setter.
	 */
	public void setPhysicalAddress(DecOrHexString dhPhysicalAddress) {
		this.dhPhysicalAddress = dhPhysicalAddress;
	}

	/**
	 * Procedure getter.
	 */
	public String getProcedure() {
		return this.stProcedure;
	}

	/**
	 * Procedure setter.
	 */
	public void setProcedure(String stProcedure) {
		this.stProcedure = stProcedure;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Source.
	 */
	public static Source_PseudoPartition cmdLoad(Node ndNode, Source ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_SOURCE_PSEUDOPARTITION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Pseudo_Partition");
		}

		// Creates node
		Source_PseudoPartition ndSource_PseudoPartition = new Source_PseudoPartition();

		// Sets parent
		ndSource_PseudoPartition.ndParent = ndParent;

		// Loads attribute
		ndSource_PseudoPartition.stName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_NAME);

		// Loads attribute
		try {
			ndSource_PseudoPartition.dhPhysicalAddress = ConfigurationUtilities.getDecOrHexStringAttribute(ndNode, Module.ATTRIBUTENAME_PHYSICALADDRESS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PhysicalAddress value cannot be parsed");
		}

		// Loads attribute
		ndSource_PseudoPartition.stProcedure = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_PROCEDURE);

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
			if (Module.ATTRIBUTENAME_NAME.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PHYSICALADDRESS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PROCEDURE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Pseudo_Partition node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Pseudo_Partition node");
		}

		// Returns node
		return ndSource_PseudoPartition;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndSource_PseudoPartition
	 *            Pseudo_Partition.
	 */
	public static Element cmdSave(Element elParent, Source_PseudoPartition ndSource_PseudoPartition) throws ConfigurationException {

		// Creates element
		Element elSource_PseudoPartition = elParent.getOwnerDocument().createElement(Module.NODENAME_SOURCE_PSEUDOPARTITION);

		// Verifies attribute
		if (ndSource_PseudoPartition.getName() != null) {

			// Saves attribute
			elSource_PseudoPartition.setAttribute(Module.ATTRIBUTENAME_NAME, ConfigurationUtilities.getAttributeString(ndSource_PseudoPartition.getName()));
		}

		// Verifies attribute
		if (ndSource_PseudoPartition.getPhysicalAddress() != null) {

			// Saves attribute
			elSource_PseudoPartition.setAttribute(Module.ATTRIBUTENAME_PHYSICALADDRESS, ConfigurationUtilities.getAttributeDecOrHexString(ndSource_PseudoPartition.getPhysicalAddress()));
		}

		// Verifies attribute
		if (ndSource_PseudoPartition.getProcedure() != null) {

			// Saves attribute
			elSource_PseudoPartition.setAttribute(Module.ATTRIBUTENAME_PROCEDURE, ConfigurationUtilities.getAttributeString(ndSource_PseudoPartition.getProcedure()));
		}

		// Returns element
		return elSource_PseudoPartition;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stName
	 *            Name.
	 * @param dhPhysicalAddress
	 *            PhysicalAddress.
	 * @param stProcedure
	 *            Procedure.
	 */
	public static Source_PseudoPartition newInstance(Source ndParent, String stName, DecOrHexString dhPhysicalAddress, String stProcedure) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new Source_PseudoPartition(ndParent, stName, dhPhysicalAddress, stProcedure);
	}
}
