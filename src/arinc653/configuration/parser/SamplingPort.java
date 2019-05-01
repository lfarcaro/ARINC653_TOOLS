package arinc653.configuration.parser;

import arinc653.configuration.parser.Direction;
import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexLong;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Sampling_Port node.
 */
public class SamplingPort {

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
	 * RefreshRateSeconds attribute.
	 */
	private BigDecimal bdRefreshRateSeconds;

	/**
	 * PortExt:Extension node list.
	 */
	private List<SamplingPort_PortExt$Extension> lsSamplingPort_PortExt$Extension = new LinkedList<SamplingPort_PortExt$Extension>();

	/**
	 * Constructor.
	 */
	private SamplingPort() {
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
	 * @param bdRefreshRateSeconds
	 *            RefreshRateSeconds.
	 */
	private SamplingPort(Partition ndParent, String stName, DecOrHexLong dhMaxMessageSize, Direction enDirection, BigDecimal bdRefreshRateSeconds) throws ConfigurationException {
		this.ndParent = ndParent;
		this.stName = stName;
		this.dhMaxMessageSize = dhMaxMessageSize;
		this.enDirection = enDirection;
		this.bdRefreshRateSeconds = bdRefreshRateSeconds;

		// Adds to parent
		if (!ndParent.addSamplingPort(this)) {
			throw new ConfigurationException("Sampling_Port cannot be added (probably its identifier attribute is duplicated)");
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
	 * RefreshRateSeconds getter.
	 */
	public BigDecimal getRefreshRateSeconds() {
		return this.bdRefreshRateSeconds;
	}

	/**
	 * RefreshRateSeconds setter.
	 */
	public void setRefreshRateSeconds(BigDecimal bdRefreshRateSeconds) {
		this.bdRefreshRateSeconds = bdRefreshRateSeconds;
	}

	/**
	 * PortExt:Extension adder.
	 * 
	 * @param ndSamplingPort_PortExt$Extension
	 *            PortExt:Extension.
	 */
	public boolean addSamplingPort_PortExt$Extension(SamplingPort_PortExt$Extension ndSamplingPort_PortExt$Extension) {

		// Verifies node
		if (ndSamplingPort_PortExt$Extension == null) {
			return false;
		}

		// Adds node
		lsSamplingPort_PortExt$Extension.add(ndSamplingPort_PortExt$Extension);
		return true;
	}

	/**
	 * PortExt:Extension list getter.
	 */
	public List<SamplingPort_PortExt$Extension> getSamplingPort_PortExt$ExtensionList() {
		return new LinkedList<SamplingPort_PortExt$Extension>(this.lsSamplingPort_PortExt$Extension);
	}

	@Override
	public int hashCode() {
		return (stName != null ? stName.hashCode() : super.hashCode());
	}

	@Override
	public boolean equals(Object obObject) {

		// Verifies object
		if (!(obObject instanceof SamplingPort)) {
			return false;
		}

		// Casts object
		SamplingPort ndSamplingPort = (SamplingPort) obObject;

		// Verifies identifiers
		if ((ndSamplingPort.getName() == null) || (stName == null)) {
			return ((ndSamplingPort.getName() == null) && (stName == null));
		}

		// Verifies identifiers
		if (ndSamplingPort.getName().equals(stName)) {
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
	public static SamplingPort cmdLoad(Node ndNode, Partition ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_SAMPLINGPORT.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Sampling_Port");
		}

		// Creates node
		SamplingPort ndSamplingPort = new SamplingPort();

		// Sets parent
		ndSamplingPort.ndParent = ndParent;

		// Loads attribute
		ndSamplingPort.stName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_NAME);

		// Verifies attribute
		if (ndSamplingPort.stName == null) {
			throw new ConfigurationException("Required attribute Name not found");
		}

		// Loads attribute
		try {
			ndSamplingPort.dhMaxMessageSize = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_MAXMESSAGESIZE);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute MaxMessageSize value cannot be parsed");
		}

		// Verifies required attribute
		if (ndSamplingPort.dhMaxMessageSize == null) {
			throw new ConfigurationException("Required attribute MaxMessageSize not found");
		}

		// Loads attribute
		try {
			ndSamplingPort.enDirection = ConfigurationUtilities.getEnumerationAttribute(ndNode, Module.ATTRIBUTENAME_DIRECTION, Direction.class);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute Direction value cannot be parsed");
		}

		// Verifies required attribute
		if (ndSamplingPort.enDirection == null) {
			throw new ConfigurationException("Required attribute Direction not found");
		}

		// Loads attribute
		try {
			ndSamplingPort.bdRefreshRateSeconds = ConfigurationUtilities.getDecimalAttribute(ndNode, Module.ATTRIBUTENAME_REFRESHRATESECONDS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute RefreshRateSeconds value cannot be parsed");
		}

		// Verifies required attribute
		if (ndSamplingPort.bdRefreshRateSeconds == null) {
			throw new ConfigurationException("Required attribute RefreshRateSeconds not found");
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
			if (Module.ATTRIBUTENAME_REFRESHRATESECONDS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Sampling_Port node");
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
			if (Module.NODENAME_SAMPLINGPORT_PORTEXT$EXTENSION.equals(ndChildNode.getNodeName())) {

				// Loads child
				SamplingPort_PortExt$Extension ndSamplingPort_PortExt$Extension = SamplingPort_PortExt$Extension.cmdLoad(ndChildNode, ndSamplingPort);

				// Verifies child
				if (ndSamplingPort_PortExt$Extension == null) {
					throw new ConfigurationException("Error while loading a PortExt:Extension node (Sampling_Port child)");
				}

				// Adds child
				ndSamplingPort.addSamplingPort_PortExt$Extension(ndSamplingPort_PortExt$Extension);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Sampling_Port node");
		}

		// Returns node
		return ndSamplingPort;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndSamplingPort
	 *            Sampling_Port.
	 */
	public static Element cmdSave(Element elParent, SamplingPort ndSamplingPort) throws ConfigurationException {

		// Creates element
		Element elSamplingPort = elParent.getOwnerDocument().createElement(Module.NODENAME_SAMPLINGPORT);

		// Verifies required attribute
		if (ndSamplingPort.getName() == null) {
			throw new ConfigurationException("Required attribute Name not assigned in Sampling_Port");
		}

		// Saves attribute
		elSamplingPort.setAttribute(Module.ATTRIBUTENAME_NAME, ConfigurationUtilities.getAttributeString(ndSamplingPort.getName()));

		// Verifies required attribute
		if (ndSamplingPort.getMaxMessageSize() == null) {
			throw new ConfigurationException("Required attribute MaxMessageSize not assigned in Sampling_Port");
		}

		// Saves attribute
		elSamplingPort.setAttribute(Module.ATTRIBUTENAME_MAXMESSAGESIZE, ConfigurationUtilities.getAttributeDecOrHexLong(ndSamplingPort.getMaxMessageSize()));

		// Verifies required attribute
		if (ndSamplingPort.getDirection() == null) {
			throw new ConfigurationException("Required attribute Direction not assigned in Sampling_Port");
		}

		// Saves attribute
		elSamplingPort.setAttribute(Module.ATTRIBUTENAME_DIRECTION, ConfigurationUtilities.getAttributeEnumeration(ndSamplingPort.getDirection()));

		// Verifies required attribute
		if (ndSamplingPort.getRefreshRateSeconds() == null) {
			throw new ConfigurationException("Required attribute RefreshRateSeconds not assigned in Sampling_Port");
		}

		// Saves attribute
		elSamplingPort.setAttribute(Module.ATTRIBUTENAME_REFRESHRATESECONDS, ConfigurationUtilities.getAttributeDecimal(ndSamplingPort.getRefreshRateSeconds()));

		// Iterates children
		Iterator<SamplingPort_PortExt$Extension> itSamplingPort_PortExt$Extension = ndSamplingPort.getSamplingPort_PortExt$ExtensionList().iterator();
		while (itSamplingPort_PortExt$Extension.hasNext()) {

			// Appends child
			elSamplingPort.appendChild(SamplingPort_PortExt$Extension.cmdSave(elSamplingPort, itSamplingPort_PortExt$Extension.next()));
		}

		// Returns element
		return elSamplingPort;
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
	 * @param bdRefreshRateSeconds
	 *            RefreshRateSeconds.
	 */
	public static SamplingPort newInstance(Partition ndParent, String stName, DecOrHexLong dhMaxMessageSize, Direction enDirection, BigDecimal bdRefreshRateSeconds) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new SamplingPort(ndParent, stName, dhMaxMessageSize, enDirection, bdRefreshRateSeconds);
	}
}
