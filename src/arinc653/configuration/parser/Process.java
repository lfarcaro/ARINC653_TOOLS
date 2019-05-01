package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexLong;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Process node.
 */
public class Process {

	/**
	 * Parent node.
	 */
	private Partition ndParent;

	/**
	 * Name attribute.
	 */
	private String stName;

	/**
	 * StackSize attribute.
	 */
	private DecOrHexLong dhStackSize;

	/**
	 * Proc_Ext:Extension node list.
	 */
	private List<ProcExt$Extension> lsProcExt$Extension = new LinkedList<ProcExt$Extension>();

	/**
	 * Constructor.
	 */
	private Process() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stName
	 *            Name.
	 * @param dhStackSize
	 *            StackSize.
	 */
	private Process(Partition ndParent, String stName, DecOrHexLong dhStackSize) throws ConfigurationException {
		this.ndParent = ndParent;
		this.stName = stName;
		this.dhStackSize = dhStackSize;

		// Adds to parent
		if (!ndParent.addProcess(this)) {
			throw new ConfigurationException("Process cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Partition getParent() {
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
	 * StackSize getter.
	 */
	public DecOrHexLong getStackSize() {
		return this.dhStackSize;
	}

	/**
	 * StackSize setter.
	 */
	public void setStackSize(DecOrHexLong dhStackSize) {
		this.dhStackSize = dhStackSize;
	}

	/**
	 * Proc_Ext:Extension adder.
	 * 
	 * @param ndProcExt$Extension
	 *            Proc_Ext:Extension.
	 */
	public boolean addProcExt$Extension(ProcExt$Extension ndProcExt$Extension) {

		// Verifies node
		if (ndProcExt$Extension == null) {
			return false;
		}

		// Adds node
		lsProcExt$Extension.add(ndProcExt$Extension);
		return true;
	}

	/**
	 * Proc_Ext:Extension list getter.
	 */
	public List<ProcExt$Extension> getProcExt$ExtensionList() {
		return new LinkedList<ProcExt$Extension>(this.lsProcExt$Extension);
	}

	@Override
	public int hashCode() {
		return (stName != null ? stName.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof Process)) {
			return false;
		}

		// Casts object
		Process ndProcess = (Process) obObject;

		// Verifies identifiers
		if ((ndProcess.getName() == null) || (stName == null)) {
			return ((ndProcess.getName() == null) && (stName == null));
		}

		// Verifies identifiers
		if (ndProcess.getName().equals(stName)) {
			return true;
		}

		// Not equal
		return false;
	}

	@Override
	public String toString() {
		return (stName != null ? stName.toString() : super.toString());
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Partition.
	 */
	public static Process cmdLoad(Node ndNode, Partition ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_PROCESS.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Process");
		}

		// Creates node
		Process ndProcess = new Process();

		// Sets parent
		ndProcess.ndParent = ndParent;

		// Loads attribute
		ndProcess.stName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_NAME);

		// Loads attribute
		try {
			ndProcess.dhStackSize = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_STACKSIZE);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute StackSize value cannot be parsed");
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
			if (Module.ATTRIBUTENAME_NAME.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_STACKSIZE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Process node");
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
			if (Module.NODENAME_PROCEXT$EXTENSION.equals(ndChildNode.getNodeName())) {

				// Loads child
				ProcExt$Extension ndProcExt$Extension = ProcExt$Extension.cmdLoad(ndChildNode, ndProcess);

				// Verifies child
				if (ndProcExt$Extension == null) {
					throw new ConfigurationException("Error while loading a Proc_Ext:Extension node (Process child)");
				}

				// Adds child
				ndProcess.addProcExt$Extension(ndProcExt$Extension);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Process node");
		}

		// Returns node
		return ndProcess;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndProcess
	 *            Process.
	 */
	public static Element cmdSave(Element elParent, Process ndProcess) throws ConfigurationException {

		// Creates element
		Element elProcess = elParent.getOwnerDocument().createElement(Module.NODENAME_PROCESS);

		// Verifies attribute
		if (ndProcess.getName() != null) {

			// Saves attribute
			elProcess.setAttribute(Module.ATTRIBUTENAME_NAME, ConfigurationUtilities.getAttributeString(ndProcess.getName()));
		}

		// Verifies attribute
		if (ndProcess.getStackSize() != null) {

			// Saves attribute
			elProcess.setAttribute(Module.ATTRIBUTENAME_STACKSIZE, ConfigurationUtilities.getAttributeDecOrHexLong(ndProcess.getStackSize()));
		}

		// Iterates children
		Iterator<ProcExt$Extension> itProcExt$Extension = ndProcess.getProcExt$ExtensionList().iterator();
		while (itProcExt$Extension.hasNext()) {

			// Appends child
			elProcess.appendChild(ProcExt$Extension.cmdSave(elProcess, itProcExt$Extension.next()));
		}

		// Returns element
		return elProcess;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stName
	 *            Name.
	 * @param dhStackSize
	 *            StackSize.
	 */
	public static Process newInstance(Partition ndParent, String stName, DecOrHexLong dhStackSize) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new Process(ndParent, stName, dhStackSize);
	}
}
