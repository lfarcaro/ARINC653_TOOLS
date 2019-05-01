package arinc653.configuration.parser;

import arinc653.configuration.parser.Direction;
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
 * Auto-generated parser for Queuing_Port node.
 */
public class QueuingPort {

	/**
	 * Parent node.
	 */
	private Partition ndParent;

	/**
	 * Name attribute.
	 */
	private String stName;

	/**
	 * MaxMessageSize attribute.
	 */
	private DecOrHexLong dhMaxMessageSize;

	/**
	 * Direction attribute.
	 */
	private Direction enDirection;

	/**
	 * MaxNbMessages attribute.
	 */
	private Integer inMaxNbMessages;

	/**
	 * PortExt:Extension node list.
	 */
	private List<QueuingPort_PortExt$Extension> lsQueuingPort_PortExt$Extension = new LinkedList<QueuingPort_PortExt$Extension>();

	/**
	 * Constructor.
	 */
	private QueuingPort() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stName
	 *            Name.
	 * @param dhMaxMessageSize
	 *            MaxMessageSize.
	 * @param enDirection
	 *            Direction.
	 * @param inMaxNbMessages
	 *            MaxNbMessages.
	 */
	private QueuingPort(Partition ndParent, String stName, DecOrHexLong dhMaxMessageSize, Direction enDirection, Integer inMaxNbMessages) throws ConfigurationException {
		this.ndParent = ndParent;
		this.stName = stName;
		this.dhMaxMessageSize = dhMaxMessageSize;
		this.enDirection = enDirection;
		this.inMaxNbMessages = inMaxNbMessages;

		// Adds to parent
		if (!ndParent.addQueuingPort(this)) {
			throw new ConfigurationException("Queuing_Port cannot be added (probably its identifier attribute is duplicated)");
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
	 * MaxMessageSize getter.
	 */
	public DecOrHexLong getMaxMessageSize() {
		return this.dhMaxMessageSize;
	}

	/**
	 * MaxMessageSize setter.
	 */
	public void setMaxMessageSize(DecOrHexLong dhMaxMessageSize) {
		this.dhMaxMessageSize = dhMaxMessageSize;
	}

	/**
	 * Direction getter.
	 */
	public Direction getDirection() {
		return this.enDirection;
	}

	/**
	 * Direction setter.
	 */
	public void setDirection(Direction enDirection) {
		this.enDirection = enDirection;
	}

	/**
	 * MaxNbMessages getter.
	 */
	public Integer getMaxNbMessages() {
		return this.inMaxNbMessages;
	}

	/**
	 * MaxNbMessages setter.
	 */
	public void setMaxNbMessages(Integer inMaxNbMessages) {
		this.inMaxNbMessages = inMaxNbMessages;
	}

	/**
	 * PortExt:Extension adder.
	 * 
	 * @param ndQueuingPort_PortExt$Extension
	 *            PortExt:Extension.
	 */
	public boolean addQueuingPort_PortExt$Extension(QueuingPort_PortExt$Extension ndQueuingPort_PortExt$Extension) {

		// Verifies node
		if (ndQueuingPort_PortExt$Extension == null) {
			return false;
		}

		// Adds node
		lsQueuingPort_PortExt$Extension.add(ndQueuingPort_PortExt$Extension);
		return true;
	}

	/**
	 * PortExt:Extension list getter.
	 */
	public List<QueuingPort_PortExt$Extension> getQueuingPort_PortExt$ExtensionList() {
		return new LinkedList<QueuingPort_PortExt$Extension>(this.lsQueuingPort_PortExt$Extension);
	}

	@Override
	public int hashCode() {
		return (stName != null ? stName.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof QueuingPort)) {
			return false;
		}

		// Casts object
		QueuingPort ndQueuingPort = (QueuingPort) obObject;

		// Verifies identifiers
		if ((ndQueuingPort.getName() == null) || (stName == null)) {
			return ((ndQueuingPort.getName() == null) && (stName == null));
		}

		// Verifies identifiers
		if (ndQueuingPort.getName().equals(stName)) {
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
	public static QueuingPort cmdLoad(Node ndNode, Partition ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_QUEUINGPORT.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Queuing_Port");
		}

		// Creates node
		QueuingPort ndQueuingPort = new QueuingPort();

		// Sets parent
		ndQueuingPort.ndParent = ndParent;

		// Loads attribute
		ndQueuingPort.stName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_NAME);

		// Verifies attribute
		if (ndQueuingPort.stName == null) {
			throw new ConfigurationException("Required attribute Name not found");
		}

		// Loads attribute
		try {
			ndQueuingPort.dhMaxMessageSize = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MAXMESSAGESIZE);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute MaxMessageSize value cannot be parsed");
		}

		// Verifies required attribute
		if (ndQueuingPort.dhMaxMessageSize == null) {
			throw new ConfigurationException("Required attribute MaxMessageSize not found");
		}

		// Loads attribute
		try {
			ndQueuingPort.enDirection = ConfigurationUtilities.getEnumerationAttribute(ndNode, Module.ATTRIBUTENAME_DIRECTION, Direction.class);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute Direction value cannot be parsed");
		}

		// Verifies required attribute
		if (ndQueuingPort.enDirection == null) {
			throw new ConfigurationException("Required attribute Direction not found");
		}

		// Loads attribute
		try {
			ndQueuingPort.inMaxNbMessages = ConfigurationUtilities.getIntegerAttribute(ndNode, Module.ATTRIBUTENAME_MAXNBMESSAGES);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute MaxNbMessages value cannot be parsed");
		}

		// Verifies required attribute
		if (ndQueuingPort.inMaxNbMessages == null) {
			throw new ConfigurationException("Required attribute MaxNbMessages not found");
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
			if (Module.ATTRIBUTENAME_MAXMESSAGESIZE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_DIRECTION.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MAXNBMESSAGES.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Queuing_Port node");
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
			if (Module.NODENAME_QUEUINGPORT_PORTEXT$EXTENSION.equals(ndChildNode.getNodeName())) {

				// Loads child
				QueuingPort_PortExt$Extension ndQueuingPort_PortExt$Extension = QueuingPort_PortExt$Extension.cmdLoad(ndChildNode, ndQueuingPort);

				// Verifies child
				if (ndQueuingPort_PortExt$Extension == null) {
					throw new ConfigurationException("Error while loading a PortExt:Extension node (Queuing_Port child)");
				}

				// Adds child
				ndQueuingPort.addQueuingPort_PortExt$Extension(ndQueuingPort_PortExt$Extension);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Queuing_Port node");
		}

		// Returns node
		return ndQueuingPort;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndQueuingPort
	 *            Queuing_Port.
	 */
	public static Element cmdSave(Element elParent, QueuingPort ndQueuingPort) throws ConfigurationException {

		// Creates element
		Element elQueuingPort = elParent.getOwnerDocument().createElement(Module.NODENAME_QUEUINGPORT);

		// Verifies required attribute
		if (ndQueuingPort.getName() == null) {
			throw new ConfigurationException("Required attribute Name not assigned in Queuing_Port");
		}

		// Saves attribute
		elQueuingPort.setAttribute(Module.ATTRIBUTENAME_NAME, ConfigurationUtilities.getAttributeString(ndQueuingPort.getName()));

		// Verifies required attribute
		if (ndQueuingPort.getMaxMessageSize() == null) {
			throw new ConfigurationException("Required attribute MaxMessageSize not assigned in Queuing_Port");
		}

		// Saves attribute
		elQueuingPort.setAttribute(Module.ATTRIBUTENAME_MAXMESSAGESIZE, ConfigurationUtilities.getAttributeDecOrHexLong(ndQueuingPort.getMaxMessageSize()));

		// Verifies required attribute
		if (ndQueuingPort.getDirection() == null) {
			throw new ConfigurationException("Required attribute Direction not assigned in Queuing_Port");
		}

		// Saves attribute
		elQueuingPort.setAttribute(Module.ATTRIBUTENAME_DIRECTION, ConfigurationUtilities.getAttributeEnumeration(ndQueuingPort.getDirection()));

		// Verifies required attribute
		if (ndQueuingPort.getMaxNbMessages() == null) {
			throw new ConfigurationException("Required attribute MaxNbMessages not assigned in Queuing_Port");
		}

		// Saves attribute
		elQueuingPort.setAttribute(Module.ATTRIBUTENAME_MAXNBMESSAGES, ConfigurationUtilities.getAttributeInteger(ndQueuingPort.getMaxNbMessages()));

		// Iterates children
		Iterator<QueuingPort_PortExt$Extension> itQueuingPort_PortExt$Extension = ndQueuingPort.getQueuingPort_PortExt$ExtensionList().iterator();
		while (itQueuingPort_PortExt$Extension.hasNext()) {

			// Appends child
			elQueuingPort.appendChild(QueuingPort_PortExt$Extension.cmdSave(elQueuingPort, itQueuingPort_PortExt$Extension.next()));
		}

		// Returns element
		return elQueuingPort;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stName
	 *            Name.
	 * @param dhMaxMessageSize
	 *            MaxMessageSize.
	 * @param enDirection
	 *            Direction.
	 * @param inMaxNbMessages
	 *            MaxNbMessages.
	 */
	public static QueuingPort newInstance(Partition ndParent, String stName, DecOrHexLong dhMaxMessageSize, Direction enDirection, Integer inMaxNbMessages) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new QueuingPort(ndParent, stName, dhMaxMessageSize, enDirection, inMaxNbMessages);
	}
}
