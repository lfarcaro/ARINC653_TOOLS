package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.DecOrHexLong;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for PartitionExt:Extension node.
 */
public class PartitionExt$Extension {

	/**
	 * Parent node.
	 */
	private Partition ndParent;

	/**
	 * StackSize attribute.
	 */
	private DecOrHexLong dhStackSize;

	/**
	 * ErrorHandler attribute.
	 */
	private String stErrorHandler;

	/**
	 * ErrorHandlerStackSize attribute.
	 */
	private DecOrHexLong dhErrorHandlerStackSize;

	/**
	 * SuppressPartitionIdleProcessMainLoop attribute.
	 */
	private Boolean blSuppressPartitionIdleProcessMainLoop;

	/**
	 * SuppressErrorHandlerStopCall attribute.
	 */
	private Boolean blSuppressErrorHandlerStopCall;

	/**
	 * MaximumErrorStatusCount attribute.
	 */
	private Integer inMaximumErrorStatusCount;

	/**
	 * MaximumBufferCount attribute.
	 */
	private Integer inMaximumBufferCount;

	/**
	 * MaximumBlackboardCount attribute.
	 */
	private Integer inMaximumBlackboardCount;

	/**
	 * MaximumSemaphoreCount attribute.
	 */
	private Integer inMaximumSemaphoreCount;

	/**
	 * MaximumEventCount attribute.
	 */
	private Integer inMaximumEventCount;

	/**
	 * PredefinedSystemPartition attribute.
	 */
	private Boolean blPredefinedSystemPartition;

	/**
	 * Constructor.
	 */
	private PartitionExt$Extension() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhStackSize
	 *            StackSize.
	 * @param stErrorHandler
	 *            ErrorHandler.
	 * @param dhErrorHandlerStackSize
	 *            ErrorHandlerStackSize.
	 * @param blSuppressPartitionIdleProcessMainLoop
	 *            SuppressPartitionIdleProcessMainLoop.
	 * @param blSuppressErrorHandlerStopCall
	 *            SuppressErrorHandlerStopCall.
	 * @param inMaximumErrorStatusCount
	 *            MaximumErrorStatusCount.
	 * @param inMaximumBufferCount
	 *            MaximumBufferCount.
	 * @param inMaximumBlackboardCount
	 *            MaximumBlackboardCount.
	 * @param inMaximumSemaphoreCount
	 *            MaximumSemaphoreCount.
	 * @param inMaximumEventCount
	 *            MaximumEventCount.
	 * @param blPredefinedSystemPartition
	 *            PredefinedSystemPartition.
	 */
	private PartitionExt$Extension(Partition ndParent, DecOrHexLong dhStackSize, String stErrorHandler, DecOrHexLong dhErrorHandlerStackSize, Boolean blSuppressPartitionIdleProcessMainLoop, Boolean blSuppressErrorHandlerStopCall, Integer inMaximumErrorStatusCount, Integer inMaximumBufferCount, Integer inMaximumBlackboardCount, Integer inMaximumSemaphoreCount, Integer inMaximumEventCount, Boolean blPredefinedSystemPartition) throws ConfigurationException {
		this.ndParent = ndParent;
		this.dhStackSize = dhStackSize;
		this.stErrorHandler = stErrorHandler;
		this.dhErrorHandlerStackSize = dhErrorHandlerStackSize;
		this.blSuppressPartitionIdleProcessMainLoop = blSuppressPartitionIdleProcessMainLoop;
		this.blSuppressErrorHandlerStopCall = blSuppressErrorHandlerStopCall;
		this.inMaximumErrorStatusCount = inMaximumErrorStatusCount;
		this.inMaximumBufferCount = inMaximumBufferCount;
		this.inMaximumBlackboardCount = inMaximumBlackboardCount;
		this.inMaximumSemaphoreCount = inMaximumSemaphoreCount;
		this.inMaximumEventCount = inMaximumEventCount;
		this.blPredefinedSystemPartition = blPredefinedSystemPartition;

		// Adds to parent
		if (!ndParent.addPartitionExt$Extension(this)) {
			throw new ConfigurationException("PartitionExt:Extension cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Partition getParent() {
		return ndParent;
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
	 * ErrorHandler getter.
	 */
	public String getErrorHandler() {
		return this.stErrorHandler;
	}

	/**
	 * ErrorHandler setter.
	 */
	public void setErrorHandler(String stErrorHandler) {
		this.stErrorHandler = stErrorHandler;
	}

	/**
	 * ErrorHandlerStackSize getter.
	 */
	public DecOrHexLong getErrorHandlerStackSize() {
		return this.dhErrorHandlerStackSize;
	}

	/**
	 * ErrorHandlerStackSize setter.
	 */
	public void setErrorHandlerStackSize(DecOrHexLong dhErrorHandlerStackSize) {
		this.dhErrorHandlerStackSize = dhErrorHandlerStackSize;
	}

	/**
	 * SuppressPartitionIdleProcessMainLoop getter.
	 */
	public Boolean getSuppressPartitionIdleProcessMainLoop() {
		return this.blSuppressPartitionIdleProcessMainLoop;
	}

	/**
	 * SuppressPartitionIdleProcessMainLoop setter.
	 */
	public void setSuppressPartitionIdleProcessMainLoop(Boolean blSuppressPartitionIdleProcessMainLoop) {
		this.blSuppressPartitionIdleProcessMainLoop = blSuppressPartitionIdleProcessMainLoop;
	}

	/**
	 * SuppressErrorHandlerStopCall getter.
	 */
	public Boolean getSuppressErrorHandlerStopCall() {
		return this.blSuppressErrorHandlerStopCall;
	}

	/**
	 * SuppressErrorHandlerStopCall setter.
	 */
	public void setSuppressErrorHandlerStopCall(Boolean blSuppressErrorHandlerStopCall) {
		this.blSuppressErrorHandlerStopCall = blSuppressErrorHandlerStopCall;
	}

	/**
	 * MaximumErrorStatusCount getter.
	 */
	public Integer getMaximumErrorStatusCount() {
		return this.inMaximumErrorStatusCount;
	}

	/**
	 * MaximumErrorStatusCount setter.
	 */
	public void setMaximumErrorStatusCount(Integer inMaximumErrorStatusCount) {
		this.inMaximumErrorStatusCount = inMaximumErrorStatusCount;
	}

	/**
	 * MaximumBufferCount getter.
	 */
	public Integer getMaximumBufferCount() {
		return this.inMaximumBufferCount;
	}

	/**
	 * MaximumBufferCount setter.
	 */
	public void setMaximumBufferCount(Integer inMaximumBufferCount) {
		this.inMaximumBufferCount = inMaximumBufferCount;
	}

	/**
	 * MaximumBlackboardCount getter.
	 */
	public Integer getMaximumBlackboardCount() {
		return this.inMaximumBlackboardCount;
	}

	/**
	 * MaximumBlackboardCount setter.
	 */
	public void setMaximumBlackboardCount(Integer inMaximumBlackboardCount) {
		this.inMaximumBlackboardCount = inMaximumBlackboardCount;
	}

	/**
	 * MaximumSemaphoreCount getter.
	 */
	public Integer getMaximumSemaphoreCount() {
		return this.inMaximumSemaphoreCount;
	}

	/**
	 * MaximumSemaphoreCount setter.
	 */
	public void setMaximumSemaphoreCount(Integer inMaximumSemaphoreCount) {
		this.inMaximumSemaphoreCount = inMaximumSemaphoreCount;
	}

	/**
	 * MaximumEventCount getter.
	 */
	public Integer getMaximumEventCount() {
		return this.inMaximumEventCount;
	}

	/**
	 * MaximumEventCount setter.
	 */
	public void setMaximumEventCount(Integer inMaximumEventCount) {
		this.inMaximumEventCount = inMaximumEventCount;
	}

	/**
	 * PredefinedSystemPartition getter.
	 */
	public Boolean getPredefinedSystemPartition() {
		return this.blPredefinedSystemPartition;
	}

	/**
	 * PredefinedSystemPartition setter.
	 */
	public void setPredefinedSystemPartition(Boolean blPredefinedSystemPartition) {
		this.blPredefinedSystemPartition = blPredefinedSystemPartition;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Partition.
	 */
	public static PartitionExt$Extension cmdLoad(Node ndNode, Partition ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_PARTITIONEXT$EXTENSION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a PartitionExt:Extension");
		}

		// Creates node
		PartitionExt$Extension ndPartitionExt$Extension = new PartitionExt$Extension();

		// Sets parent
		ndPartitionExt$Extension.ndParent = ndParent;

		// Loads attribute
		try {
			ndPartitionExt$Extension.dhStackSize = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_STACKSIZE);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute StackSize value cannot be parsed");
		}

		// Loads attribute
		ndPartitionExt$Extension.stErrorHandler = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_ERRORHANDLER);

		// Loads attribute
		try {
			ndPartitionExt$Extension.dhErrorHandlerStackSize = ConfigurationUtilities.getDecOrHexLongAttribute(ndNode, Module.ATTRIBUTENAME_ERRORHANDLERSTACKSIZE);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ErrorHandlerStackSize value cannot be parsed");
		}

		// Loads attribute
		try {
			ndPartitionExt$Extension.blSuppressPartitionIdleProcessMainLoop = ConfigurationUtilities.getBooleanAttribute(ndNode, Module.ATTRIBUTENAME_SUPPRESSPARTITIONIDLEPROCESSMAINLOOP);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SuppressPartitionIdleProcessMainLoop value cannot be parsed");
		}

		// Loads attribute
		try {
			ndPartitionExt$Extension.blSuppressErrorHandlerStopCall = ConfigurationUtilities.getBooleanAttribute(ndNode, Module.ATTRIBUTENAME_SUPPRESSERRORHANDLERSTOPCALL);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SuppressErrorHandlerStopCall value cannot be parsed");
		}

		// Loads attribute
		try {
			ndPartitionExt$Extension.inMaximumErrorStatusCount = ConfigurationUtilities.getIntegerAttribute(ndNode, Module.ATTRIBUTENAME_MAXIMUMERRORSTATUSCOUNT);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute MaximumErrorStatusCount value cannot be parsed");
		}

		// Loads attribute
		try {
			ndPartitionExt$Extension.inMaximumBufferCount = ConfigurationUtilities.getIntegerAttribute(ndNode, Module.ATTRIBUTENAME_MAXIMUMBUFFERCOUNT);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute MaximumBufferCount value cannot be parsed");
		}

		// Loads attribute
		try {
			ndPartitionExt$Extension.inMaximumBlackboardCount = ConfigurationUtilities.getIntegerAttribute(ndNode, Module.ATTRIBUTENAME_MAXIMUMBLACKBOARDCOUNT);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute MaximumBlackboardCount value cannot be parsed");
		}

		// Loads attribute
		try {
			ndPartitionExt$Extension.inMaximumSemaphoreCount = ConfigurationUtilities.getIntegerAttribute(ndNode, Module.ATTRIBUTENAME_MAXIMUMSEMAPHORECOUNT);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute MaximumSemaphoreCount value cannot be parsed");
		}

		// Loads attribute
		try {
			ndPartitionExt$Extension.inMaximumEventCount = ConfigurationUtilities.getIntegerAttribute(ndNode, Module.ATTRIBUTENAME_MAXIMUMEVENTCOUNT);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute MaximumEventCount value cannot be parsed");
		}

		// Loads attribute
		try {
			ndPartitionExt$Extension.blPredefinedSystemPartition = ConfigurationUtilities.getBooleanAttribute(ndNode, Module.ATTRIBUTENAME_PREDEFINEDSYSTEMPARTITION);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PredefinedSystemPartition value cannot be parsed");
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
			if (Module.ATTRIBUTENAME_STACKSIZE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_ERRORHANDLER.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_ERRORHANDLERSTACKSIZE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SUPPRESSPARTITIONIDLEPROCESSMAINLOOP.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SUPPRESSERRORHANDLERSTOPCALL.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MAXIMUMERRORSTATUSCOUNT.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MAXIMUMBUFFERCOUNT.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MAXIMUMBLACKBOARDCOUNT.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MAXIMUMSEMAPHORECOUNT.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MAXIMUMEVENTCOUNT.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PREDEFINEDSYSTEMPARTITION.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in PartitionExt:Extension node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in PartitionExt:Extension node");
		}

		// Returns node
		return ndPartitionExt$Extension;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndPartitionExt$Extension
	 *            PartitionExt:Extension.
	 */
	public static Element cmdSave(Element elParent, PartitionExt$Extension ndPartitionExt$Extension) throws ConfigurationException {

		// Creates element
		Element elPartitionExt$Extension = elParent.getOwnerDocument().createElement(Module.NODENAME_PARTITIONEXT$EXTENSION);

		// Verifies attribute
		if (ndPartitionExt$Extension.getStackSize() != null) {

			// Saves attribute
			elPartitionExt$Extension.setAttribute(Module.ATTRIBUTENAME_STACKSIZE, ConfigurationUtilities.getAttributeDecOrHexLong(ndPartitionExt$Extension.getStackSize()));
		}

		// Verifies attribute
		if (ndPartitionExt$Extension.getErrorHandler() != null) {

			// Saves attribute
			elPartitionExt$Extension.setAttribute(Module.ATTRIBUTENAME_ERRORHANDLER, ConfigurationUtilities.getAttributeString(ndPartitionExt$Extension.getErrorHandler()));
		}

		// Verifies attribute
		if (ndPartitionExt$Extension.getErrorHandlerStackSize() != null) {

			// Saves attribute
			elPartitionExt$Extension.setAttribute(Module.ATTRIBUTENAME_ERRORHANDLERSTACKSIZE, ConfigurationUtilities.getAttributeDecOrHexLong(ndPartitionExt$Extension.getErrorHandlerStackSize()));
		}

		// Verifies attribute
		if (ndPartitionExt$Extension.getSuppressPartitionIdleProcessMainLoop() != null) {

			// Saves attribute
			elPartitionExt$Extension.setAttribute(Module.ATTRIBUTENAME_SUPPRESSPARTITIONIDLEPROCESSMAINLOOP, ConfigurationUtilities.getAttributeBoolean(ndPartitionExt$Extension.getSuppressPartitionIdleProcessMainLoop()));
		}

		// Verifies attribute
		if (ndPartitionExt$Extension.getSuppressErrorHandlerStopCall() != null) {

			// Saves attribute
			elPartitionExt$Extension.setAttribute(Module.ATTRIBUTENAME_SUPPRESSERRORHANDLERSTOPCALL, ConfigurationUtilities.getAttributeBoolean(ndPartitionExt$Extension.getSuppressErrorHandlerStopCall()));
		}

		// Verifies attribute
		if (ndPartitionExt$Extension.getMaximumErrorStatusCount() != null) {

			// Saves attribute
			elPartitionExt$Extension.setAttribute(Module.ATTRIBUTENAME_MAXIMUMERRORSTATUSCOUNT, ConfigurationUtilities.getAttributeInteger(ndPartitionExt$Extension.getMaximumErrorStatusCount()));
		}

		// Verifies attribute
		if (ndPartitionExt$Extension.getMaximumBufferCount() != null) {

			// Saves attribute
			elPartitionExt$Extension.setAttribute(Module.ATTRIBUTENAME_MAXIMUMBUFFERCOUNT, ConfigurationUtilities.getAttributeInteger(ndPartitionExt$Extension.getMaximumBufferCount()));
		}

		// Verifies attribute
		if (ndPartitionExt$Extension.getMaximumBlackboardCount() != null) {

			// Saves attribute
			elPartitionExt$Extension.setAttribute(Module.ATTRIBUTENAME_MAXIMUMBLACKBOARDCOUNT, ConfigurationUtilities.getAttributeInteger(ndPartitionExt$Extension.getMaximumBlackboardCount()));
		}

		// Verifies attribute
		if (ndPartitionExt$Extension.getMaximumSemaphoreCount() != null) {

			// Saves attribute
			elPartitionExt$Extension.setAttribute(Module.ATTRIBUTENAME_MAXIMUMSEMAPHORECOUNT, ConfigurationUtilities.getAttributeInteger(ndPartitionExt$Extension.getMaximumSemaphoreCount()));
		}

		// Verifies attribute
		if (ndPartitionExt$Extension.getMaximumEventCount() != null) {

			// Saves attribute
			elPartitionExt$Extension.setAttribute(Module.ATTRIBUTENAME_MAXIMUMEVENTCOUNT, ConfigurationUtilities.getAttributeInteger(ndPartitionExt$Extension.getMaximumEventCount()));
		}

		// Verifies attribute
		if (ndPartitionExt$Extension.getPredefinedSystemPartition() != null) {

			// Saves attribute
			elPartitionExt$Extension.setAttribute(Module.ATTRIBUTENAME_PREDEFINEDSYSTEMPARTITION, ConfigurationUtilities.getAttributeBoolean(ndPartitionExt$Extension.getPredefinedSystemPartition()));
		}

		// Returns element
		return elPartitionExt$Extension;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param dhStackSize
	 *            StackSize.
	 * @param stErrorHandler
	 *            ErrorHandler.
	 * @param dhErrorHandlerStackSize
	 *            ErrorHandlerStackSize.
	 * @param blSuppressPartitionIdleProcessMainLoop
	 *            SuppressPartitionIdleProcessMainLoop.
	 * @param blSuppressErrorHandlerStopCall
	 *            SuppressErrorHandlerStopCall.
	 * @param inMaximumErrorStatusCount
	 *            MaximumErrorStatusCount.
	 * @param inMaximumBufferCount
	 *            MaximumBufferCount.
	 * @param inMaximumBlackboardCount
	 *            MaximumBlackboardCount.
	 * @param inMaximumSemaphoreCount
	 *            MaximumSemaphoreCount.
	 * @param inMaximumEventCount
	 *            MaximumEventCount.
	 * @param blPredefinedSystemPartition
	 *            PredefinedSystemPartition.
	 */
	public static PartitionExt$Extension newInstance(Partition ndParent, DecOrHexLong dhStackSize, String stErrorHandler, DecOrHexLong dhErrorHandlerStackSize, Boolean blSuppressPartitionIdleProcessMainLoop, Boolean blSuppressErrorHandlerStopCall, Integer inMaximumErrorStatusCount, Integer inMaximumBufferCount, Integer inMaximumBlackboardCount, Integer inMaximumSemaphoreCount, Integer inMaximumEventCount, Boolean blPredefinedSystemPartition) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new PartitionExt$Extension(ndParent, dhStackSize, stErrorHandler, dhErrorHandlerStackSize, blSuppressPartitionIdleProcessMainLoop, blSuppressErrorHandlerStopCall, inMaximumErrorStatusCount, inMaximumBufferCount, inMaximumBlackboardCount, inMaximumSemaphoreCount, inMaximumEventCount, blPredefinedSystemPartition);
	}
}
