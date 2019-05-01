package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Channel node.
 */
public class Channel {

	/**
	 * Parent node.
	 */
	private ConnectionTable ndParent;

	/**
	 * ChannelIdentifier attribute.
	 */
	private Identifier idChannelIdentifier;

	/**
	 * ChannelName attribute.
	 */
	private String stChannelName;

	/**
	 * Source node list.
	 */
	private List<Source> lsSource = new LinkedList<Source>();

	/**
	 * Destination node list.
	 */
	private List<Destination> lsDestination = new LinkedList<Destination>();

	/**
	 * Constructor.
	 */
	private Channel() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idChannelIdentifier
	 *            ChannelIdentifier.
	 * @param stChannelName
	 *            ChannelName.
	 */
	private Channel(ConnectionTable ndParent, Identifier idChannelIdentifier, String stChannelName) throws ConfigurationException {
		this.ndParent = ndParent;
		this.idChannelIdentifier = idChannelIdentifier;
		this.stChannelName = stChannelName;

		// Adds to parent
		if (!ndParent.addChannel(this)) {
			throw new ConfigurationException("Channel cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public ConnectionTable getParent() {
		return ndParent;
	}

	/**
	 * ChannelIdentifier getter.
	 */
	public Identifier getChannelIdentifier() {
		return this.idChannelIdentifier;
	}

	/**
	 * ChannelIdentifier setter.
	 */
	public void setChannelIdentifier(Identifier idChannelIdentifier) {
		this.idChannelIdentifier = idChannelIdentifier;
	}

	/**
	 * ChannelName getter.
	 */
	public String getChannelName() {
		return this.stChannelName;
	}

	/**
	 * ChannelName setter.
	 */
	public void setChannelName(String stChannelName) {
		this.stChannelName = stChannelName;
	}

	/**
	 * Source adder.
	 * 
	 * @param ndSource
	 *            Source.
	 */
	public boolean addSource(Source ndSource) {

		// Verifies node
		if (ndSource == null) {
			return false;
		}

		// Adds node
		lsSource.add(ndSource);
		return true;
	}

	/**
	 * Source list getter.
	 */
	public List<Source> getSourceList() {
		return new LinkedList<Source>(this.lsSource);
	}

	/**
	 * Destination adder.
	 * 
	 * @param ndDestination
	 *            Destination.
	 */
	public boolean addDestination(Destination ndDestination) {

		// Verifies node
		if (ndDestination == null) {
			return false;
		}

		// Adds node
		lsDestination.add(ndDestination);
		return true;
	}

	/**
	 * Destination list getter.
	 */
	public List<Destination> getDestinationList() {
		return new LinkedList<Destination>(this.lsDestination);
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Connection_Table.
	 */
	public static Channel cmdLoad(Node ndNode, ConnectionTable ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_CHANNEL.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Channel");
		}

		// Creates node
		Channel ndChannel = new Channel();

		// Sets parent
		ndChannel.ndParent = ndParent;

		// Loads attribute
		try {
			ndChannel.idChannelIdentifier = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_CHANNELIDENTIFIER);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ChannelIdentifier value cannot be parsed");
		}

		// Verifies required attribute
		if (ndChannel.idChannelIdentifier == null) {
			throw new ConfigurationException("Required attribute ChannelIdentifier not found");
		}

		// Loads attribute
		ndChannel.stChannelName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_CHANNELNAME);

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
			if (Module.ATTRIBUTENAME_CHANNELIDENTIFIER.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_CHANNELNAME.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Channel node");
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
			if (Module.NODENAME_SOURCE.equals(ndChildNode.getNodeName())) {

				// Loads child
				Source ndSource = Source.cmdLoad(ndChildNode, ndChannel);

				// Verifies child
				if (ndSource == null) {
					throw new ConfigurationException("Error while loading a Source node (Channel child)");
				}

				// Adds child
				ndChannel.addSource(ndSource);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_DESTINATION.equals(ndChildNode.getNodeName())) {

				// Loads child
				Destination ndDestination = Destination.cmdLoad(ndChildNode, ndChannel);

				// Verifies child
				if (ndDestination == null) {
					throw new ConfigurationException("Error while loading a Destination node (Channel child)");
				}

				// Adds child
				ndChannel.addDestination(ndDestination);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Channel node");
		}

		// Returns node
		return ndChannel;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndChannel
	 *            Channel.
	 */
	public static Element cmdSave(Element elParent, Channel ndChannel) throws ConfigurationException {

		// Creates element
		Element elChannel = elParent.getOwnerDocument().createElement(Module.NODENAME_CHANNEL);

		// Verifies required attribute
		if (ndChannel.getChannelIdentifier() == null) {
			throw new ConfigurationException("Required attribute ChannelIdentifier not assigned in Channel");
		}

		// Saves attribute
		elChannel.setAttribute(Module.ATTRIBUTENAME_CHANNELIDENTIFIER, ConfigurationUtilities.getAttributeIdentifier(ndChannel.getChannelIdentifier()));

		// Verifies attribute
		if (ndChannel.getChannelName() != null) {

			// Saves attribute
			elChannel.setAttribute(Module.ATTRIBUTENAME_CHANNELNAME, ConfigurationUtilities.getAttributeString(ndChannel.getChannelName()));
		}

		// Iterates children
		Iterator<Source> itSource = ndChannel.getSourceList().iterator();
		while (itSource.hasNext()) {

			// Appends child
			elChannel.appendChild(Source.cmdSave(elChannel, itSource.next()));
		}

		// Iterates children
		Iterator<Destination> itDestination = ndChannel.getDestinationList().iterator();
		while (itDestination.hasNext()) {

			// Appends child
			elChannel.appendChild(Destination.cmdSave(elChannel, itDestination.next()));
		}

		// Returns element
		return elChannel;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param idChannelIdentifier
	 *            ChannelIdentifier.
	 * @param stChannelName
	 *            ChannelName.
	 */
	public static Channel newInstance(ConnectionTable ndParent, Identifier idChannelIdentifier, String stChannelName) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new Channel(ndParent, idChannelIdentifier, stChannelName);
	}
}
