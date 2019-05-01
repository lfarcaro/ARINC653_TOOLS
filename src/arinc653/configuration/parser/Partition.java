package arinc653.configuration.parser;

import arinc653.configuration.parser.Criticality;
import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
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
 * Auto-generated parser for Partition node.
 */
public class Partition {

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
	 * Criticality attribute.
	 */
	private Criticality enCriticality;

	/**
	 * SystemPartition attribute.
	 */
	private Boolean blSystemPartition;

	/**
	 * EntryPoint attribute.
	 */
	private String stEntryPoint;

	/**
	 * Sampling_Port node list.
	 */
	private List<SamplingPort> lsSamplingPort = new LinkedList<SamplingPort>();

	/**
	 * Sampling_Port node map.
	 */
	private Map<String, SamplingPort> mpSamplingPort = new HashMap<String, SamplingPort>();

	/**
	 * Queuing_Port node list.
	 */
	private List<QueuingPort> lsQueuingPort = new LinkedList<QueuingPort>();

	/**
	 * Queuing_Port node map.
	 */
	private Map<String, QueuingPort> mpQueuingPort = new HashMap<String, QueuingPort>();

	/**
	 * Process node list.
	 */
	private List<Process> lsProcess = new LinkedList<Process>();

	/**
	 * Process node map.
	 */
	private Map<String, Process> mpProcess = new HashMap<String, Process>();

	/**
	 * PartitionExt:Extension node list.
	 */
	private List<PartitionExt$Extension> lsPartitionExt$Extension = new LinkedList<PartitionExt$Extension>();

	/**
	 * Constructor.
	 */
	private Partition() {
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
	 * @param enCriticality
	 *            Criticality.
	 * @param blSystemPartition
	 *            SystemPartition.
	 * @param stEntryPoint
	 *            EntryPoint.
	 */
	private Partition(Module ndParent, Identifier idPartitionIdentifier, String stPartitionName, Criticality enCriticality, Boolean blSystemPartition, String stEntryPoint) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idPartitionIdentifier = idPartitionIdentifier;
		this.stPartitionName = stPartitionName;
		this.enCriticality = enCriticality;
		this.blSystemPartition = blSystemPartition;
		this.stEntryPoint = stEntryPoint;

		// Adds to parent
		if (!ndParent.addPartition(this)) {
			throw new ConfigurationException("Partition cannot be added (probably its identifier attribute is duplicated)");
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
	 * Criticality getter.
	 */
	public Criticality getCriticality() {
		return this.enCriticality;
	}

	/**
	 * Criticality setter.
	 */
	public void setCriticality(Criticality enCriticality) {
		this.enCriticality = enCriticality;
	}

	/**
	 * SystemPartition getter.
	 */
	public Boolean getSystemPartition() {
		return this.blSystemPartition;
	}

	/**
	 * SystemPartition setter.
	 */
	public void setSystemPartition(Boolean blSystemPartition) {
		this.blSystemPartition = blSystemPartition;
	}

	/**
	 * EntryPoint getter.
	 */
	public String getEntryPoint() {
		return this.stEntryPoint;
	}

	/**
	 * EntryPoint setter.
	 */
	public void setEntryPoint(String stEntryPoint) {
		this.stEntryPoint = stEntryPoint;
	}

	/**
	 * Sampling_Port adder.
	 * 
	 * @param ndSamplingPort
	 *            Sampling_Port.
	 */
	public boolean addSamplingPort(SamplingPort ndSamplingPort) {

		// Verifies node
		if (ndSamplingPort == null) {
			return false;
		}

		// Verifies identifier
		if (mpSamplingPort.containsKey(ndSamplingPort.getName())) {
			return false;
		}

		// Adds node
		lsSamplingPort.add(ndSamplingPort);

		// Maps node
		mpSamplingPort.put(ndSamplingPort.getName(), ndSamplingPort);
		return true;
	}

	/**
	 * Sampling_Port getter.
	 * 
	 * @param stName
	 *            Name.
	 */
	public SamplingPort getSamplingPort(String stName) {
		return (stName == null ? null : this.mpSamplingPort.get(stName));
	}

	/**
	 * Sampling_Port Name set getter.
	 */
	public Set<String> getSamplingPortNameSet() {
		return this.mpSamplingPort.keySet();
	}

	/**
	 * Sampling_Port list getter.
	 */
	public List<SamplingPort> getSamplingPortList() {
		return new LinkedList<SamplingPort>(this.lsSamplingPort);
	}

	/**
	 * Queuing_Port adder.
	 * 
	 * @param ndQueuingPort
	 *            Queuing_Port.
	 */
	public boolean addQueuingPort(QueuingPort ndQueuingPort) {

		// Verifies node
		if (ndQueuingPort == null) {
			return false;
		}

		// Verifies identifier
		if (mpQueuingPort.containsKey(ndQueuingPort.getName())) {
			return false;
		}

		// Adds node
		lsQueuingPort.add(ndQueuingPort);

		// Maps node
		mpQueuingPort.put(ndQueuingPort.getName(), ndQueuingPort);
		return true;
	}

	/**
	 * Queuing_Port getter.
	 * 
	 * @param stName
	 *            Name.
	 */
	public QueuingPort getQueuingPort(String stName) {
		return (stName == null ? null : this.mpQueuingPort.get(stName));
	}

	/**
	 * Queuing_Port Name set getter.
	 */
	public Set<String> getQueuingPortNameSet() {
		return this.mpQueuingPort.keySet();
	}

	/**
	 * Queuing_Port list getter.
	 */
	public List<QueuingPort> getQueuingPortList() {
		return new LinkedList<QueuingPort>(this.lsQueuingPort);
	}

	/**
	 * Process adder.
	 * 
	 * @param ndProcess
	 *            Process.
	 */
	public boolean addProcess(Process ndProcess) {

		// Verifies node
		if (ndProcess == null) {
			return false;
		}

		// Verifies identifier
		if (mpProcess.containsKey(ndProcess.getName())) {
			return false;
		}

		// Adds node
		lsProcess.add(ndProcess);

		// Maps node
		mpProcess.put(ndProcess.getName(), ndProcess);
		return true;
	}

	/**
	 * Process getter.
	 * 
	 * @param stName
	 *            Name.
	 */
	public Process getProcess(String stName) {
		return (stName == null ? null : this.mpProcess.get(stName));
	}

	/**
	 * Process Name set getter.
	 */
	public Set<String> getProcessNameSet() {
		return this.mpProcess.keySet();
	}

	/**
	 * Process list getter.
	 */
	public List<Process> getProcessList() {
		return new LinkedList<Process>(this.lsProcess);
	}

	/**
	 * PartitionExt:Extension adder.
	 * 
	 * @param ndPartitionExt$Extension
	 *            PartitionExt:Extension.
	 */
	public boolean addPartitionExt$Extension(PartitionExt$Extension ndPartitionExt$Extension) {

		// Verifies node
		if (ndPartitionExt$Extension == null) {
			return false;
		}

		// Adds node
		lsPartitionExt$Extension.add(ndPartitionExt$Extension);
		return true;
	}

	/**
	 * PartitionExt:Extension list getter.
	 */
	public List<PartitionExt$Extension> getPartitionExt$ExtensionList() {
		return new LinkedList<PartitionExt$Extension>(this.lsPartitionExt$Extension);
	}

	@Override
	public int hashCode() {
		return (idPartitionIdentifier != null ? idPartitionIdentifier.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof Partition)) {
			return false;
		}

		// Casts object
		Partition ndPartition = (Partition) obObject;

		// Verifies identifiers
		if ((ndPartition.getPartitionIdentifier() == null) || (idPartitionIdentifier == null)) {
			return ((ndPartition.getPartitionIdentifier() == null) && (idPartitionIdentifier == null));
		}

		// Verifies identifiers
		if (ndPartition.getPartitionIdentifier().equals(idPartitionIdentifier)) {
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
	public static Partition cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_PARTITION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Partition");
		}

		// Creates node
		Partition ndPartition = new Partition();

		// Sets parent
		ndPartition.ndParent = ndParent;

		// Loads attribute
		try {
			ndPartition.idPartitionIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PartitionIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndPartition.idPartitionIdentifier == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not found");
		}

		// Loads attribute
		ndPartition.stPartitionName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_PARTITIONNAME);

		// Loads attribute
		try {
			ndPartition.enCriticality = ConfigurationUtilities.getEnumerationAttribute(ndNode, Module.ATTRIBUTENAME_CRITICALITY, Criticality.class);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute Criticality value cannot be parsed");
		}

		// Loads attribute
		try {
			ndPartition.blSystemPartition = ConfigurationUtilities.getBooleanAttribute(ndNode, Module.ATTRIBUTENAME_SYSTEMPARTITION);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SystemPartition value cannot be parsed");
		}

		// Verifies required attribute
		if (ndPartition.blSystemPartition == null) {
			ndPartition.blSystemPartition = false;
		}

		// Loads attribute
		ndPartition.stEntryPoint = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_ENTRYPOINT);

		// Verifies attribute
		if (ndPartition.stEntryPoint == null) {
			throw new ConfigurationException("Required attribute EntryPoint not found");
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
			if (Module.ATTRIBUTENAME_CRITICALITY.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SYSTEMPARTITION.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_ENTRYPOINT.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Partition node");
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
			if (Module.NODENAME_SAMPLINGPORT.equals(ndChildNode.getNodeName())) {

				// Loads child
				SamplingPort ndSamplingPort = SamplingPort.cmdLoad(ndChildNode, ndPartition);

				// Verifies child
				if (ndSamplingPort == null) {
					throw new ConfigurationException("Error while loading a Sampling_Port node (Partition child)");
				}

				// Adds child
				ndPartition.addSamplingPort(ndSamplingPort);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_QUEUINGPORT.equals(ndChildNode.getNodeName())) {

				// Loads child
				QueuingPort ndQueuingPort = QueuingPort.cmdLoad(ndChildNode, ndPartition);

				// Verifies child
				if (ndQueuingPort == null) {
					throw new ConfigurationException("Error while loading a Queuing_Port node (Partition child)");
				}

				// Adds child
				ndPartition.addQueuingPort(ndQueuingPort);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_PROCESS.equals(ndChildNode.getNodeName())) {

				// Loads child
				Process ndProcess = Process.cmdLoad(ndChildNode, ndPartition);

				// Verifies child
				if (ndProcess == null) {
					throw new ConfigurationException("Error while loading a Process node (Partition child)");
				}

				// Adds child
				ndPartition.addProcess(ndProcess);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_PARTITIONEXT$EXTENSION.equals(ndChildNode.getNodeName())) {

				// Loads child
				PartitionExt$Extension ndPartitionExt$Extension = PartitionExt$Extension.cmdLoad(ndChildNode, ndPartition);

				// Verifies child
				if (ndPartitionExt$Extension == null) {
					throw new ConfigurationException("Error while loading a PartitionExt:Extension node (Partition child)");
				}

				// Adds child
				ndPartition.addPartitionExt$Extension(ndPartitionExt$Extension);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Partition node");
		}

		// Returns node
		return ndPartition;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndPartition
	 *            Partition.
	 */
	public static Element cmdSave(Element elParent, Partition ndPartition) throws ConfigurationException {

		// Creates element
		Element elPartition = elParent.getOwnerDocument().createElement(Module.NODENAME_PARTITION);

		// Verifies required attribute
		if (ndPartition.getPartitionIdentifier() == null) {
			throw new ConfigurationException("Required attribute PartitionIdentifier not assigned in Partition");
		}

		// Saves attribute
		elPartition.setAttribute(Module.ATTRIBUTENAME_PARTITIONIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndPartition.getPartitionIdentifier()));

		// Verifies attribute
		if (ndPartition.getPartitionName() != null) {

			// Saves attribute
			elPartition.setAttribute(Module.ATTRIBUTENAME_PARTITIONNAME, ConfigurationUtilities.getAttributeString(ndPartition.getPartitionName()));
		}

		// Verifies attribute
		if (ndPartition.getCriticality() != null) {

			// Saves attribute
			elPartition.setAttribute(Module.ATTRIBUTENAME_CRITICALITY, ConfigurationUtilities.getAttributeEnumeration(ndPartition.getCriticality()));
		}

		// Verifies attribute
		if (ndPartition.getSystemPartition() != null) {

			// Saves attribute
			elPartition.setAttribute(Module.ATTRIBUTENAME_SYSTEMPARTITION, ConfigurationUtilities.getAttributeBoolean(ndPartition.getSystemPartition()));
		}

		// Verifies required attribute
		if (ndPartition.getEntryPoint() == null) {
			throw new ConfigurationException("Required attribute EntryPoint not assigned in Partition");
		}

		// Saves attribute
		elPartition.setAttribute(Module.ATTRIBUTENAME_ENTRYPOINT, ConfigurationUtilities.getAttributeString(ndPartition.getEntryPoint()));

		// Iterates children
		Iterator<SamplingPort> itSamplingPort = ndPartition.getSamplingPortList().iterator();
		while (itSamplingPort.hasNext()) {

			// Appends child
			elPartition.appendChild(SamplingPort.cmdSave(elPartition, itSamplingPort.next()));
		}

		// Iterates children
		Iterator<QueuingPort> itQueuingPort = ndPartition.getQueuingPortList().iterator();
		while (itQueuingPort.hasNext()) {

			// Appends child
			elPartition.appendChild(QueuingPort.cmdSave(elPartition, itQueuingPort.next()));
		}

		// Iterates children
		Iterator<Process> itProcess = ndPartition.getProcessList().iterator();
		while (itProcess.hasNext()) {

			// Appends child
			elPartition.appendChild(Process.cmdSave(elPartition, itProcess.next()));
		}

		// Iterates children
		Iterator<PartitionExt$Extension> itPartitionExt$Extension = ndPartition.getPartitionExt$ExtensionList().iterator();
		while (itPartitionExt$Extension.hasNext()) {

			// Appends child
			elPartition.appendChild(PartitionExt$Extension.cmdSave(elPartition, itPartitionExt$Extension.next()));
		}

		// Returns element
		return elPartition;
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
	 * @param enCriticality
	 *            Criticality.
	 * @param blSystemPartition
	 *            SystemPartition.
	 * @param stEntryPoint
	 *            EntryPoint.
	 */
	public static Partition newInstance(Module ndParent, Identifier idPartitionIdentifier, String stPartitionName, Criticality enCriticality, Boolean blSystemPartition, String stEntryPoint) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new Partition(ndParent, idPartitionIdentifier, stPartitionName, enCriticality, blSystemPartition, stEntryPoint);
	}
}
