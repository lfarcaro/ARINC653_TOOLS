package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Module_Schedule node.
 */
public class ModuleSchedule {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * MajorFrameSeconds attribute.
	 */
	private BigDecimal bdMajorFrameSeconds;

	/**
	 * Partition_Schedule node list.
	 */
	private List<PartitionSchedule> lsPartitionSchedule = new LinkedList<PartitionSchedule>();

	/**
	 * Partition_Schedule node map.
	 */
	private Map<Identifier, PartitionSchedule> mpPartitionSchedule = new HashMap<Identifier, PartitionSchedule>();

	/**
	 * Constructor.
	 */
	private ModuleSchedule() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param bdMajorFrameSeconds
	 *            MajorFrameSeconds.
	 */
	private ModuleSchedule(Module ndParent, BigDecimal bdMajorFrameSeconds) throws ConfigurationException {
		this.ndParent = ndParent;
		this.bdMajorFrameSeconds = bdMajorFrameSeconds;

		// Adds to parent
		if (!ndParent.addModuleSchedule(this)) {
			throw new ConfigurationException("Module_Schedule cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
		return ndParent;
	}

	/**
	 * MajorFrameSeconds getter.
	 */
	public BigDecimal getMajorFrameSeconds() {
		return this.bdMajorFrameSeconds;
	}

	/**
	 * MajorFrameSeconds setter.
	 */
	public void setMajorFrameSeconds(BigDecimal bdMajorFrameSeconds) {
		this.bdMajorFrameSeconds = bdMajorFrameSeconds;
	}

	/**
	 * Partition_Schedule adder.
	 * 
	 * @param ndPartitionSchedule
	 *            Partition_Schedule.
	 */
	public boolean addPartitionSchedule(PartitionSchedule ndPartitionSchedule) {

		// Verifies node
		if (ndPartitionSchedule == null) {
			return false;
		}

		// Verifies identifier
		if (mpPartitionSchedule.containsKey(ndPartitionSchedule.getPartitionIdentifier())) {
			return false;
		}

		// Adds node
		lsPartitionSchedule.add(ndPartitionSchedule);

		// Maps node
		mpPartitionSchedule.put(ndPartitionSchedule.getPartitionIdentifier(), ndPartitionSchedule);
		return true;
	}

	/**
	 * Partition_Schedule getter.
	 * 
	 * @param idPartitionIdentifier
	 *            PartitionIdentifier.
	 */
	public PartitionSchedule getPartitionSchedule(Identifier idPartitionIdentifier) {
		return (idPartitionIdentifier == null ? null : this.mpPartitionSchedule.get(idPartitionIdentifier));
	}

	/**
	 * Partition_Schedule PartitionIdentifier set getter.
	 */
	public Set<Identifier> getPartitionSchedulePartitionIdentifierSet() {
		return this.mpPartitionSchedule.keySet();
	}

	/**
	 * Partition_Schedule list getter.
	 */
	public List<PartitionSchedule> getPartitionScheduleList() {
		return new LinkedList<PartitionSchedule>(this.lsPartitionSchedule);
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            ARINC_653_Module.
	 */
	public static ModuleSchedule cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODULESCHEDULE.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Module_Schedule");
		}

		// Creates node
		ModuleSchedule ndModuleSchedule = new ModuleSchedule();

		// Sets parent
		ndModuleSchedule.ndParent = ndParent;

		// Loads attribute
		try {
			ndModuleSchedule.bdMajorFrameSeconds = ConfigurationUtilities.getDecimalAttribute(ndNode, Module.ATTRIBUTENAME_MAJORFRAMESECONDS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute MajorFrameSeconds value cannot be parsed");
		}

		// Verifies required attribute
		if (ndModuleSchedule.bdMajorFrameSeconds == null) {
			throw new ConfigurationException("Required attribute MajorFrameSeconds not found");
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
			if (Module.ATTRIBUTENAME_MAJORFRAMESECONDS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Module_Schedule node");
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
			if (Module.NODENAME_PARTITIONSCHEDULE.equals(ndChildNode.getNodeName())) {

				// Loads child
				PartitionSchedule ndPartitionSchedule = PartitionSchedule.cmdLoad(ndChildNode, ndModuleSchedule);

				// Verifies child
				if (ndPartitionSchedule == null) {
					throw new ConfigurationException("Error while loading a Partition_Schedule node (Module_Schedule child)");
				}

				// Adds child
				ndModuleSchedule.addPartitionSchedule(ndPartitionSchedule);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Module_Schedule node");
		}

		// Returns node
		return ndModuleSchedule;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModuleSchedule
	 *            Module_Schedule.
	 */
	public static Element cmdSave(Element elParent, ModuleSchedule ndModuleSchedule) throws ConfigurationException {

		// Creates element
		Element elModuleSchedule = elParent.getOwnerDocument().createElement(Module.NODENAME_MODULESCHEDULE);

		// Verifies required attribute
		if (ndModuleSchedule.getMajorFrameSeconds() == null) {
			throw new ConfigurationException("Required attribute MajorFrameSeconds not assigned in Module_Schedule");
		}

		// Saves attribute
		elModuleSchedule.setAttribute(Module.ATTRIBUTENAME_MAJORFRAMESECONDS, ConfigurationUtilities.getAttributeDecimal(ndModuleSchedule.getMajorFrameSeconds()));

		// Iterates children
		Iterator<PartitionSchedule> itPartitionSchedule = ndModuleSchedule.getPartitionScheduleList().iterator();
		while (itPartitionSchedule.hasNext()) {

			// Appends child
			elModuleSchedule.appendChild(PartitionSchedule.cmdSave(elModuleSchedule, itPartitionSchedule.next()));
		}

		// Returns element
		return elModuleSchedule;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param bdMajorFrameSeconds
	 *            MajorFrameSeconds.
	 */
	public static ModuleSchedule newInstance(Module ndParent, BigDecimal bdMajorFrameSeconds) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ModuleSchedule(ndParent, bdMajorFrameSeconds);
	}
}
