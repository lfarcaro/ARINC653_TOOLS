package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
import java.math.BigDecimal;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Window_Schedule node.
 */
public class WindowSchedule {

	/**
	 * Parent node.
	 */
	private PartitionSchedule ndParent;

	/**
	 * WindowIdentifier attribute.
	 */
	private Identifier idWindowIdentifier;

	/**
	 * WindowStartSeconds attribute.
	 */
	private BigDecimal bdWindowStartSeconds;

	/**
	 * WindowDurationSeconds attribute.
	 */
	private BigDecimal bdWindowDurationSeconds;

	/**
	 * PartitionPeriodStart attribute.
	 */
	private Boolean blPartitionPeriodStart;

	/**
	 * Constructor.
	 */
	private WindowSchedule() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idWindowIdentifier
	 *            WindowIdentifier.
	 * @param bdWindowStartSeconds
	 *            WindowStartSeconds.
	 * @param bdWindowDurationSeconds
	 *            WindowDurationSeconds.
	 * @param blPartitionPeriodStart
	 *            PartitionPeriodStart.
	 */
	private WindowSchedule(PartitionSchedule ndParent, Identifier idWindowIdentifier, BigDecimal bdWindowStartSeconds, BigDecimal bdWindowDurationSeconds, Boolean blPartitionPeriodStart) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idWindowIdentifier = idWindowIdentifier;
		this.bdWindowStartSeconds = bdWindowStartSeconds;
		this.bdWindowDurationSeconds = bdWindowDurationSeconds;
		this.blPartitionPeriodStart = blPartitionPeriodStart;

		// Adds to parent
		if (!ndParent.addWindowSchedule(this)) {
			throw new ConfigurationException("Window_Schedule cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public PartitionSchedule getParent() {
		return ndParent;
	}

	/**
	 * WindowIdentifier getter.
	 */
	public Identifier getWindowIdentifier() {
		return this.idWindowIdentifier;
	}

	/**
	 * WindowIdentifier setter.
	 */
	public void setWindowIdentifier(Identifier idWindowIdentifier) {
		this.idWindowIdentifier = idWindowIdentifier;
	}

	/**
	 * WindowStartSeconds getter.
	 */
	public BigDecimal getWindowStartSeconds() {
		return this.bdWindowStartSeconds;
	}

	/**
	 * WindowStartSeconds setter.
	 */
	public void setWindowStartSeconds(BigDecimal bdWindowStartSeconds) {
		this.bdWindowStartSeconds = bdWindowStartSeconds;
	}

	/**
	 * WindowDurationSeconds getter.
	 */
	public BigDecimal getWindowDurationSeconds() {
		return this.bdWindowDurationSeconds;
	}

	/**
	 * WindowDurationSeconds setter.
	 */
	public void setWindowDurationSeconds(BigDecimal bdWindowDurationSeconds) {
		this.bdWindowDurationSeconds = bdWindowDurationSeconds;
	}

	/**
	 * PartitionPeriodStart getter.
	 */
	public Boolean getPartitionPeriodStart() {
		return this.blPartitionPeriodStart;
	}

	/**
	 * PartitionPeriodStart setter.
	 */
	public void setPartitionPeriodStart(Boolean blPartitionPeriodStart) {
		this.blPartitionPeriodStart = blPartitionPeriodStart;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Partition_Schedule.
	 */
	public static WindowSchedule cmdLoad(Node ndNode, PartitionSchedule ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_WINDOWSCHEDULE.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Window_Schedule");
		}

		// Creates node
		WindowSchedule ndWindowSchedule = new WindowSchedule();

		// Sets parent
		ndWindowSchedule.ndParent = ndParent;

		// Loads attribute
		try {
			ndWindowSchedule.idWindowIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_WINDOWIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute WindowIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndWindowSchedule.idWindowIdentifier == null) {
			throw new ConfigurationException("Required attribute WindowIdentifier not found");
		}

		// Loads attribute
		try {
			ndWindowSchedule.bdWindowStartSeconds = ConfigurationUtilities.getDecimalAttribute(ndNode, Module.ATTRIBUTENAME_WINDOWSTARTSECONDS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute WindowStartSeconds value cannot be parsed");
		}

		// Verifies required attribute
		if (ndWindowSchedule.bdWindowStartSeconds == null) {
			throw new ConfigurationException("Required attribute WindowStartSeconds not found");
		}

		// Loads attribute
		try {
			ndWindowSchedule.bdWindowDurationSeconds = ConfigurationUtilities.getDecimalAttribute(ndNode, Module.ATTRIBUTENAME_WINDOWDURATIONSECONDS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute WindowDurationSeconds value cannot be parsed");
		}

		// Verifies required attribute
		if (ndWindowSchedule.bdWindowDurationSeconds == null) {
			throw new ConfigurationException("Required attribute WindowDurationSeconds not found");
		}

		// Loads attribute
		try {
			ndWindowSchedule.blPartitionPeriodStart = ConfigurationUtilities.getBooleanAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONPERIODSTART);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PartitionPeriodStart value cannot be parsed");
		}

		// Verifies required attribute
		if (ndWindowSchedule.blPartitionPeriodStart == null) {
			ndWindowSchedule.blPartitionPeriodStart = false;
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
			if (Module.ATTRIBUTENAME_WINDOWIDENTIFIER.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_WINDOWSTARTSECONDS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_WINDOWDURATIONSECONDS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PARTITIONPERIODSTART.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Window_Schedule node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Window_Schedule node");
		}

		// Returns node
		return ndWindowSchedule;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndWindowSchedule
	 *            Window_Schedule.
	 */
	public static Element cmdSave(Element elParent, WindowSchedule ndWindowSchedule) throws ConfigurationException {

		// Creates element
		Element elWindowSchedule = elParent.getOwnerDocument().createElement(Module.NODENAME_WINDOWSCHEDULE);

		// Verifies required attribute
		if (ndWindowSchedule.getWindowIdentifier() == null) {
			throw new ConfigurationException("Required attribute WindowIdentifier not assigned in Window_Schedule");
		}

		// Saves attribute
		elWindowSchedule.setAttribute(Module.ATTRIBUTENAME_WINDOWIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndWindowSchedule.getWindowIdentifier()));

		// Verifies required attribute
		if (ndWindowSchedule.getWindowStartSeconds() == null) {
			throw new ConfigurationException("Required attribute WindowStartSeconds not assigned in Window_Schedule");
		}

		// Saves attribute
		elWindowSchedule.setAttribute(Module.ATTRIBUTENAME_WINDOWSTARTSECONDS, ConfigurationUtilities.getAttributeDecimal(ndWindowSchedule.getWindowStartSeconds()));

		// Verifies required attribute
		if (ndWindowSchedule.getWindowDurationSeconds() == null) {
			throw new ConfigurationException("Required attribute WindowDurationSeconds not assigned in Window_Schedule");
		}

		// Saves attribute
		elWindowSchedule.setAttribute(Module.ATTRIBUTENAME_WINDOWDURATIONSECONDS, ConfigurationUtilities.getAttributeDecimal(ndWindowSchedule.getWindowDurationSeconds()));

		// Verifies attribute
		if (ndWindowSchedule.getPartitionPeriodStart() != null) {

			// Saves attribute
			elWindowSchedule.setAttribute(Module.ATTRIBUTENAME_PARTITIONPERIODSTART, ConfigurationUtilities.getAttributeBoolean(ndWindowSchedule.getPartitionPeriodStart()));
		}

		// Returns element
		return elWindowSchedule;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idWindowIdentifier
	 *            WindowIdentifier.
	 * @param bdWindowStartSeconds
	 *            WindowStartSeconds.
	 * @param bdWindowDurationSeconds
	 *            WindowDurationSeconds.
	 * @param blPartitionPeriodStart
	 *            PartitionPeriodStart.
	 */
	public static WindowSchedule newInstance(PartitionSchedule ndParent, Identifier idWindowIdentifier, BigDecimal bdWindowStartSeconds, BigDecimal bdWindowDurationSeconds, Boolean blPartitionPeriodStart) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new WindowSchedule(ndParent, idWindowIdentifier, bdWindowStartSeconds, bdWindowDurationSeconds, blPartitionPeriodStart);
	}
}
