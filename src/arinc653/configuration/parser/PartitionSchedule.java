package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Partition_Schedule node.
 */
public class PartitionSchedule {

	/**
	 * Parent node.
	 */
	private ModuleSchedule ndParent;

	/**
	 * PartitionIdentifier attribute.
	 */
	private Identifier idPartitionIdentifier;

	/**
	 * PartitionName attribute.
	 */
	private String stPartitionName;

	/**
	 * PeriodSeconds attribute.
	 */
	private BigDecimal bdPeriodSeconds;

	/**
	 * PeriodDurationSeconds attribute.
	 */
	private BigDecimal bdPeriodDurationSeconds;

	/**
	 * Window_Schedule node list.
	 */
	private List<WindowSchedule> lsWindowSchedule = new LinkedList<WindowSchedule>();

	/**
	 * Constructor.
	 */
	private PartitionSchedule() {
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
	 * @param bdPeriodSeconds
	 *            PeriodSeconds.
	 * @param bdPeriodDurationSeconds
	 *            PeriodDurationSeconds.
	 */
	private PartitionSchedule(ModuleSchedule ndParent, Identifier idPartitionIdentifier, String stPartitionName, BigDecimal bdPeriodSeconds, BigDecimal bdPeriodDurationSeconds) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idPartitionIdentifier = idPartitionIdentifier;
		this.stPartitionName = stPartitionName;
		this.bdPeriodSeconds = bdPeriodSeconds;
		this.bdPeriodDurationSeconds = bdPeriodDurationSeconds;

		// Adds to parent
		if (!ndParent.addPartitionSchedule(this)) {
			throw new ConfigurationException("Partition_Schedule cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public ModuleSchedule getParent() {
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
	 * PeriodSeconds getter.
	 */
	public BigDecimal getPeriodSeconds() {
		return this.bdPeriodSeconds;
	}

	/**
	 * PeriodSeconds setter.
	 */
	public void setPeriodSeconds(BigDecimal bdPeriodSeconds) {
		this.bdPeriodSeconds = bdPeriodSeconds;
	}

	/**
	 * PeriodDurationSeconds getter.
	 */
	public BigDecimal getPeriodDurationSeconds() {
		return this.bdPeriodDurationSeconds;
	}

	/**
	 * PeriodDurationSeconds setter.
	 */
	public void setPeriodDurationSeconds(BigDecimal bdPeriodDurationSeconds) {
		this.bdPeriodDurationSeconds = bdPeriodDurationSeconds;
	}

	/**
	 * Window_Schedule adder.
	 * 
	 * @param ndWindowSchedule
	 *            Window_Schedule.
	 */
	public boolean addWindowSchedule(WindowSchedule ndWindowSchedule) {

		// Verifies node
		if (ndWindowSchedule == null) {
			return false;
		}

		// Adds node
		lsWindowSchedule.add(ndWindowSchedule);
		return true;
	}

	/**
	 * Window_Schedule list getter.
	 */
	public List<WindowSchedule> getWindowScheduleList() {
		return new LinkedList<WindowSchedule>(this.lsWindowSchedule);
	}

	@Override
	public int hashCode() {
		return (idPartitionIdentifier != null ? idPartitionIdentifier.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof PartitionSchedule)) {
			return false;
		}

		// Casts object
		PartitionSchedule ndPartitionSchedule = (PartitionSchedule) obObject;

		// Verifies identifiers
		if ((ndPartitionSchedule.getPartitionIdentifier() == null) || (idPartitionIdentifier == null)) {
			return ((ndPartitionSchedule.getPartitionIdentifier() == null) && (idPartitionIdentifier == null));
		}

		// Verifies identifiers
		if (ndPartitionSchedule.getPartitionIdentifier().equals(idPartitionIdentifier)) {
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
	 *            Module_Schedule.
	 */
	public static PartitionSchedule cmdLoad(Node ndNode, ModuleSchedule ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_PARTITIONSCHEDULE.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Partition_Schedule");
		}

		// Creates node
		PartitionSchedule ndPartitionSchedule = new PartitionSchedule();

		// Sets parent
		ndPartitionSchedule.ndParent = ndParent;

		// Loads attribute
		try {
			ndPartitionSchedule.idPartitionIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PartitionIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndPartitionSchedule.idPartitionIdentifier == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not found");
		}

		// Loads attribute
		ndPartitionSchedule.stPartitionName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONNAME);

		// Loads attribute
		try {
			ndPartitionSchedule.bdPeriodSeconds = ConfigurationUtilities.getDecimalAttribute(ndNode, Module.ATTRIBUTENAME_PERIODSECONDS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PeriodSeconds value cannot be parsed");
		}

		// Verifies required attribute
		if (ndPartitionSchedule.bdPeriodSeconds == null) {
			throw new ConfigurationException("Required attribute PeriodSeconds not found");
		}

		// Loads attribute
		try {
			ndPartitionSchedule.bdPeriodDurationSeconds = ConfigurationUtilities.getDecimalAttribute(ndNode, Module.ATTRIBUTENAME_PERIODDURATIONSECONDS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PeriodDurationSeconds value cannot be parsed");
		}

		// Verifies required attribute
		if (ndPartitionSchedule.bdPeriodDurationSeconds == null) {
			throw new ConfigurationException("Required attribute PeriodDurationSeconds not found");
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
			if (Module.ATTRIBUTENAME_PERIODSECONDS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PERIODDURATIONSECONDS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Partition_Schedule node");
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
			if (Module.NODENAME_WINDOWSCHEDULE.equals(ndChildNode.getNodeName())) {

				// Loads child
				WindowSchedule ndWindowSchedule = WindowSchedule.cmdLoad(ndChildNode, ndPartitionSchedule);

				// Verifies child
				if (ndWindowSchedule == null) {
					throw new ConfigurationException("Error while loading a Window_Schedule node (Partition_Schedule child)");
				}

				// Adds child
				ndPartitionSchedule.addWindowSchedule(ndWindowSchedule);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Partition_Schedule node");
		}

		// Returns node
		return ndPartitionSchedule;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndPartitionSchedule
	 *            Partition_Schedule.
	 */
	public static Element cmdSave(Element elParent, PartitionSchedule ndPartitionSchedule) throws ConfigurationException {

		// Creates element
		Element elPartitionSchedule = elParent.getOwnerDocument().createElement(Module.NODENAME_PARTITIONSCHEDULE);

		// Verifies required attribute
		if (ndPartitionSchedule.getPartitionIdentifier() == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not assigned in Partition_Schedule");
		}

		// Saves attribute
		elPartitionSchedule.setAttribute(Module.ATTRIBUTENAME_PARTITIONIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndPartitionSchedule.getPartitionIdentifier()));

		// Verifies attribute
		if (ndPartitionSchedule.getPartitionName() != null) {

			// Saves attribute
			elPartitionSchedule.setAttribute(Module.ATTRIBUTENAME_PARTITIONNAME, ConfigurationUtilities.getAttributeString(ndPartitionSchedule.getPartitionName()));
		}

		// Verifies required attribute
		if (ndPartitionSchedule.getPeriodSeconds() == null) {
			throw new ConfigurationException("Required attribute PeriodSeconds not assigned in Partition_Schedule");
		}

		// Saves attribute
		elPartitionSchedule.setAttribute(Module.ATTRIBUTENAME_PERIODSECONDS, ConfigurationUtilities.getAttributeDecimal(ndPartitionSchedule.getPeriodSeconds()));

		// Verifies required attribute
		if (ndPartitionSchedule.getPeriodDurationSeconds() == null) {
			throw new ConfigurationException("Required attribute PeriodDurationSeconds not assigned in Partition_Schedule");
		}

		// Saves attribute
		elPartitionSchedule.setAttribute(Module.ATTRIBUTENAME_PERIODDURATIONSECONDS, ConfigurationUtilities.getAttributeDecimal(ndPartitionSchedule.getPeriodDurationSeconds()));

		// Iterates children
		Iterator<WindowSchedule> itWindowSchedule = ndPartitionSchedule.getWindowScheduleList().iterator();
		while (itWindowSchedule.hasNext()) {

			// Appends child
			elPartitionSchedule.appendChild(WindowSchedule.cmdSave(elPartitionSchedule, itWindowSchedule.next()));
		}

		// Returns element
		return elPartitionSchedule;
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
	 * @param bdPeriodSeconds
	 *            PeriodSeconds.
	 * @param bdPeriodDurationSeconds
	 *            PeriodDurationSeconds.
	 */
	public static PartitionSchedule newInstance(ModuleSchedule ndParent, Identifier idPartitionIdentifier, String stPartitionName, BigDecimal bdPeriodSeconds, BigDecimal bdPeriodDurationSeconds) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new PartitionSchedule(ndParent, idPartitionIdentifier, stPartitionName, bdPeriodSeconds, bdPeriodDurationSeconds);
	}
}
