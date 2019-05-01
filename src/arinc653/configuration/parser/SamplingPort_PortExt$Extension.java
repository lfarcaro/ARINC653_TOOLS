package arinc653.configuration.parser;

import arinc653.configuration.parser.QueuingDiscipline;
import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for PortExt:Extension node.
 */
public class SamplingPort_PortExt$Extension {

	/**
	 * Parent node.
	 */
	private SamplingPort ndParent;

	/**
	 * QueuingDiscipline attribute.
	 */
	private QueuingDiscipline enQueuingDiscipline;

	/**
	 * Constructor.
	 */
	private SamplingPort_PortExt$Extension() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param enQueuingDiscipline
	 *            QueuingDiscipline.
	 */
	private SamplingPort_PortExt$Extension(SamplingPort ndParent, QueuingDiscipline enQueuingDiscipline) throws ConfigurationException {
		this.ndParent = ndParent;
		this.enQueuingDiscipline = enQueuingDiscipline;

		// Adds to parent
		if (!ndParent.addSamplingPort_PortExt$Extension(this)) {
			throw new ConfigurationException("PortExt:Extension cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public SamplingPort getParent() {
		return ndParent;
	}

	/**
	 * QueuingDiscipline getter.
	 */
	public QueuingDiscipline getQueuingDiscipline() {
		return this.enQueuingDiscipline;
	}

	/**
	 * QueuingDiscipline setter.
	 */
	public void setQueuingDiscipline(QueuingDiscipline enQueuingDiscipline) {
		this.enQueuingDiscipline = enQueuingDiscipline;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Sampling_Port.
	 */
	public static SamplingPort_PortExt$Extension cmdLoad(Node ndNode, SamplingPort ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_SAMPLINGPORT_PORTEXT$EXTENSION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a PortExt:Extension");
		}

		// Creates node
		SamplingPort_PortExt$Extension ndSamplingPort_PortExt$Extension = new SamplingPort_PortExt$Extension();

		// Sets parent
		ndSamplingPort_PortExt$Extension.ndParent = ndParent;

		// Loads attribute
		try {
			ndSamplingPort_PortExt$Extension.enQueuingDiscipline = ConfigurationUtilities.getEnumerationAttribute(ndNode, Module.ATTRIBUTENAME_QUEUINGDISCIPLINE, QueuingDiscipline.class);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute QueuingDiscipline value cannot be parsed");
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
			if (Module.ATTRIBUTENAME_QUEUINGDISCIPLINE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in PortExt:Extension node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in PortExt:Extension node");
		}

		// Returns node
		return ndSamplingPort_PortExt$Extension;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndSamplingPort_PortExt$Extension
	 *            PortExt:Extension.
	 */
	public static Element cmdSave(Element elParent, SamplingPort_PortExt$Extension ndSamplingPort_PortExt$Extension) throws ConfigurationException {

		// Creates element
		Element elSamplingPort_PortExt$Extension = elParent.getOwnerDocument().createElement(Module.NODENAME_SAMPLINGPORT_PORTEXT$EXTENSION);

		// Verifies attribute
		if (ndSamplingPort_PortExt$Extension.getQueuingDiscipline() != null) {

			// Saves attribute
			elSamplingPort_PortExt$Extension.setAttribute(Module.ATTRIBUTENAME_QUEUINGDISCIPLINE, ConfigurationUtilities.getAttributeEnumeration(ndSamplingPort_PortExt$Extension.getQueuingDiscipline()));
		}

		// Returns element
		return elSamplingPort_PortExt$Extension;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param enQueuingDiscipline
	 *            QueuingDiscipline.
	 */
	public static SamplingPort_PortExt$Extension newInstance(SamplingPort ndParent, QueuingDiscipline enQueuingDiscipline) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new SamplingPort_PortExt$Extension(ndParent, enQueuingDiscipline);
	}
}
