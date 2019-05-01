package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Connection_Table node.
 */
public class ConnectionTable {

	/**
	 * Parent node.
	 */
	private Module ndParent;

	/**
	 * Channel node list.
	 */
	private List<Channel> lsChannel = new LinkedList<Channel>();

	/**
	 * Constructor.
	 */
	private ConnectionTable() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 */
	private ConnectionTable(Module ndParent) throws ConfigurationException {
		this.ndParent = ndParent;

		// Adds to parent
		if (!ndParent.addConnectionTable(this)) {
			throw new ConfigurationException("Connection_Table cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Module getParent() {
		return ndParent;
	}

	/**
	 * Channel adder.
	 * 
	 * @param ndChannel
	 *            Channel.
	 */
	public boolean addChannel(Channel ndChannel) {

		// Verifies node
		if (ndChannel == null) {
			return false;
		}

		// Adds node
		lsChannel.add(ndChannel);
		return true;
	}

	/**
	 * Channel list getter.
	 */
	public List<Channel> getChannelList() {
		return new LinkedList<Channel>(this.lsChannel);
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            ARINC_653_Module.
	 */
	public static ConnectionTable cmdLoad(Node ndNode, Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_CONNECTIONTABLE.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Connection_Table");
		}

		// Creates node
		ConnectionTable ndConnectionTable = new ConnectionTable();

		// Sets parent
		ndConnectionTable.ndParent = ndParent;

		// Iterates attributes
		NamedNodeMap nmAttributes = ndNode.getAttributes();
		for (int i = 0; i < nmAttributes.getLength(); i++) {

			// Gets next attribute
			Node ndAttribute = nmAttributes.item(i);

			// Verifies attribute
			if (ndAttribute.getNodeType() != Node.ATTRIBUTE_NODE) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Connection_Table node");
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
			if (Module.NODENAME_CHANNEL.equals(ndChildNode.getNodeName())) {

				// Loads child
				Channel ndChannel = Channel.cmdLoad(ndChildNode, ndConnectionTable);

				// Verifies child
				if (ndChannel == null) {
					throw new ConfigurationException("Error while loading a Channel node (Connection_Table child)");
				}

				// Adds child
				ndConnectionTable.addChannel(ndChannel);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Connection_Table node");
		}

		// Returns node
		return ndConnectionTable;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndConnectionTable
	 *            Connection_Table.
	 */
	public static Element cmdSave(Element elParent, ConnectionTable ndConnectionTable) throws ConfigurationException {

		// Creates element
		Element elConnectionTable = elParent.getOwnerDocument().createElement(Module.NODENAME_CONNECTIONTABLE);

		// Iterates children
		Iterator<Channel> itChannel = ndConnectionTable.getChannelList().iterator();
		while (itChannel.hasNext()) {

			// Appends child
			elConnectionTable.appendChild(Channel.cmdSave(elConnectionTable, itChannel.next()));
		}

		// Returns element
		return elConnectionTable;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 */
	public static ConnectionTable newInstance(Module ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ConnectionTable(ndParent);
	}
}
