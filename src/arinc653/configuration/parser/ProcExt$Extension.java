package arinc653.configuration.parser;

import arinc653.configuration.parser.Deadline;
import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import java.math.BigDecimal;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for Proc_Ext:Extension node.
 */
public class ProcExt$Extension {

	/**
	 * Parent node.
	 */
	private Process ndParent;

	/**
	 * EntryPoint attribute.
	 */
	private String stEntryPoint;

	/**
	 * BasePriority attribute.
	 */
	private Integer inBasePriority;

	/**
	 * PeriodSeconds attribute.
	 */
	private BigDecimal bdPeriodSeconds;

	/**
	 * TimeCapacitySeconds attribute.
	 */
	private BigDecimal bdTimeCapacitySeconds;

	/**
	 * Deadline attribute.
	 */
	private Deadline enDeadline;

	/**
	 * StartDelay attribute.
	 */
	private BigDecimal bdStartDelay;

	/**
	 * SuspensionTimeSeconds attribute.
	 */
	private BigDecimal bdSuspensionTimeSeconds;

	/**
	 * SuppressStart attribute.
	 */
	private Boolean blSuppressStart;

	/**
	 * SuppressMainLoop attribute.
	 */
	private Boolean blSuppressMainLoop;

	/**
	 * SuppressSuspension attribute.
	 */
	private Boolean blSuppressSuspension;

	/**
	 * Constructor.
	 */
	private ProcExt$Extension() {
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stEntryPoint
	 *            EntryPoint.
	 * @param inBasePriority
	 *            BasePriority.
	 * @param bdPeriodSeconds
	 *            PeriodSeconds.
	 * @param bdTimeCapacitySeconds
	 *            TimeCapacitySeconds.
	 * @param enDeadline
	 *            Deadline.
	 * @param bdStartDelay
	 *            StartDelay.
	 * @param bdSuspensionTimeSeconds
	 *            SuspensionTimeSeconds.
	 * @param blSuppressStart
	 *            SuppressStart.
	 * @param blSuppressMainLoop
	 *            SuppressMainLoop.
	 * @param blSuppressSuspension
	 *            SuppressSuspension.
	 */
	private ProcExt$Extension(Process ndParent, String stEntryPoint, Integer inBasePriority, BigDecimal bdPeriodSeconds, BigDecimal bdTimeCapacitySeconds, Deadline enDeadline, BigDecimal bdStartDelay, BigDecimal bdSuspensionTimeSeconds, Boolean blSuppressStart, Boolean blSuppressMainLoop, Boolean blSuppressSuspension) throws ConfigurationException {
		this.ndParent = ndParent;
		this.stEntryPoint = stEntryPoint;
		this.inBasePriority = inBasePriority;
		this.bdPeriodSeconds = bdPeriodSeconds;
		this.bdTimeCapacitySeconds = bdTimeCapacitySeconds;
		this.enDeadline = enDeadline;
		this.bdStartDelay = bdStartDelay;
		this.bdSuspensionTimeSeconds = bdSuspensionTimeSeconds;
		this.blSuppressStart = blSuppressStart;
		this.blSuppressMainLoop = blSuppressMainLoop;
		this.blSuppressSuspension = blSuppressSuspension;

		// Adds to parent
		if (!ndParent.addProcExt$Extension(this)) {
			throw new ConfigurationException("Proc_Ext:Extension cannot be added (probably its identifier attribute is duplicated)");
		}
	}

	/**
	 * Parent node getter.
	 */
	public Process getParent() {
		return ndParent;
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
	 * BasePriority getter.
	 */
	public Integer getBasePriority() {
		return this.inBasePriority;
	}

	/**
	 * BasePriority setter.
	 */
	public void setBasePriority(Integer inBasePriority) {
		this.inBasePriority = inBasePriority;
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
	 * TimeCapacitySeconds getter.
	 */
	public BigDecimal getTimeCapacitySeconds() {
		return this.bdTimeCapacitySeconds;
	}

	/**
	 * TimeCapacitySeconds setter.
	 */
	public void setTimeCapacitySeconds(BigDecimal bdTimeCapacitySeconds) {
		this.bdTimeCapacitySeconds = bdTimeCapacitySeconds;
	}

	/**
	 * Deadline getter.
	 */
	public Deadline getDeadline() {
		return this.enDeadline;
	}

	/**
	 * Deadline setter.
	 */
	public void setDeadline(Deadline enDeadline) {
		this.enDeadline = enDeadline;
	}

	/**
	 * StartDelay getter.
	 */
	public BigDecimal getStartDelay() {
		return this.bdStartDelay;
	}

	/**
	 * StartDelay setter.
	 */
	public void setStartDelay(BigDecimal bdStartDelay) {
		this.bdStartDelay = bdStartDelay;
	}

	/**
	 * SuspensionTimeSeconds getter.
	 */
	public BigDecimal getSuspensionTimeSeconds() {
		return this.bdSuspensionTimeSeconds;
	}

	/**
	 * SuspensionTimeSeconds setter.
	 */
	public void setSuspensionTimeSeconds(BigDecimal bdSuspensionTimeSeconds) {
		this.bdSuspensionTimeSeconds = bdSuspensionTimeSeconds;
	}

	/**
	 * SuppressStart getter.
	 */
	public Boolean getSuppressStart() {
		return this.blSuppressStart;
	}

	/**
	 * SuppressStart setter.
	 */
	public void setSuppressStart(Boolean blSuppressStart) {
		this.blSuppressStart = blSuppressStart;
	}

	/**
	 * SuppressMainLoop getter.
	 */
	public Boolean getSuppressMainLoop() {
		return this.blSuppressMainLoop;
	}

	/**
	 * SuppressMainLoop setter.
	 */
	public void setSuppressMainLoop(Boolean blSuppressMainLoop) {
		this.blSuppressMainLoop = blSuppressMainLoop;
	}

	/**
	 * SuppressSuspension getter.
	 */
	public Boolean getSuppressSuspension() {
		return this.blSuppressSuspension;
	}

	/**
	 * SuppressSuspension setter.
	 */
	public void setSuppressSuspension(Boolean blSuppressSuspension) {
		this.blSuppressSuspension = blSuppressSuspension;
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 * @param ndParent
	 *            Process.
	 */
	public static ProcExt$Extension cmdLoad(Node ndNode, Process ndParent) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			throw new ConfigurationException("Cannot load non-root with null parent");
		}

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_PROCEXT$EXTENSION.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a Proc_Ext:Extension");
		}

		// Creates node
		ProcExt$Extension ndProcExt$Extension = new ProcExt$Extension();

		// Sets parent
		ndProcExt$Extension.ndParent = ndParent;

		// Loads attribute
		ndProcExt$Extension.stEntryPoint = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_ENTRYPOINT);

		// Loads attribute
		try {
			ndProcExt$Extension.inBasePriority = ConfigurationUtilities.getIntegerAttribute(ndNode, Module.ATTRIBUTENAME_BASEPRIORITY);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute BasePriority value cannot be parsed");
		}

		// Verifies required attribute
		if (ndProcExt$Extension.inBasePriority == null) {
			throw new ConfigurationException("Required attribute BasePriority not found");
		}

		// Loads attribute
		try {
			ndProcExt$Extension.bdPeriodSeconds = ConfigurationUtilities.getDecimalAttribute(ndNode, Module.ATTRIBUTENAME_PERIODSECONDS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute PeriodSeconds value cannot be parsed");
		}

		// Loads attribute
		try {
			ndProcExt$Extension.bdTimeCapacitySeconds = ConfigurationUtilities.getDecimalAttribute(ndNode, Module.ATTRIBUTENAME_TIMECAPACITYSECONDS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute TimeCapacitySeconds value cannot be parsed");
		}

		// Loads attribute
		try {
			ndProcExt$Extension.enDeadline = ConfigurationUtilities.getEnumerationAttribute(ndNode, Module.ATTRIBUTENAME_DEADLINE, Deadline.class);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute Deadline value cannot be parsed");
		}

		// Verifies required attribute
		if (ndProcExt$Extension.enDeadline == null) {
			throw new ConfigurationException("Required attribute Deadline not found");
		}

		// Loads attribute
		try {
			ndProcExt$Extension.bdStartDelay = ConfigurationUtilities.getDecimalAttribute(ndNode, Module.ATTRIBUTENAME_STARTDELAY);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute StartDelay value cannot be parsed");
		}

		// Loads attribute
		try {
			ndProcExt$Extension.bdSuspensionTimeSeconds = ConfigurationUtilities.getDecimalAttribute(ndNode, Module.ATTRIBUTENAME_SUSPENSIONTIMESECONDS);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SuspensionTimeSeconds value cannot be parsed");
		}

		// Loads attribute
		try {
			ndProcExt$Extension.blSuppressStart = ConfigurationUtilities.getBooleanAttribute(ndNode, Module.ATTRIBUTENAME_SUPPRESSSTART);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SuppressStart value cannot be parsed");
		}

		// Loads attribute
		try {
			ndProcExt$Extension.blSuppressMainLoop = ConfigurationUtilities.getBooleanAttribute(ndNode, Module.ATTRIBUTENAME_SUPPRESSMAINLOOP);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SuppressMainLoop value cannot be parsed");
		}

		// Loads attribute
		try {
			ndProcExt$Extension.blSuppressSuspension = ConfigurationUtilities.getBooleanAttribute(ndNode, Module.ATTRIBUTENAME_SUPPRESSSUSPENSION);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute SuppressSuspension value cannot be parsed");
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
			if (Module.ATTRIBUTENAME_ENTRYPOINT.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_BASEPRIORITY.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_PERIODSECONDS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_TIMECAPACITYSECONDS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_DEADLINE.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_STARTDELAY.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SUSPENSIONTIMESECONDS.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SUPPRESSSTART.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SUPPRESSMAINLOOP.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_SUPPRESSSUSPENSION.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected attribute " + ndAttribute.getNodeName() + " found in Proc_Ext:Extension node");
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
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in Proc_Ext:Extension node");
		}

		// Returns node
		return ndProcExt$Extension;
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndProcExt$Extension
	 *            Proc_Ext:Extension.
	 */
	public static Element cmdSave(Element elParent, ProcExt$Extension ndProcExt$Extension) throws ConfigurationException {

		// Creates element
		Element elProcExt$Extension = elParent.getOwnerDocument().createElement(Module.NODENAME_PROCEXT$EXTENSION);

		// Verifies attribute
		if (ndProcExt$Extension.getEntryPoint() != null) {

			// Saves attribute
			elProcExt$Extension.setAttribute(Module.ATTRIBUTENAME_ENTRYPOINT, ConfigurationUtilities.getAttributeString(ndProcExt$Extension.getEntryPoint()));
		}

		// Verifies required attribute
		if (ndProcExt$Extension.getBasePriority() == null) {
			throw new ConfigurationException("Required attribute BasePriority not assigned in Proc_Ext:Extension");
		}

		// Saves attribute
		elProcExt$Extension.setAttribute(Module.ATTRIBUTENAME_BASEPRIORITY, ConfigurationUtilities.getAttributeInteger(ndProcExt$Extension.getBasePriority()));

		// Verifies attribute
		if (ndProcExt$Extension.getPeriodSeconds() != null) {

			// Saves attribute
			elProcExt$Extension.setAttribute(Module.ATTRIBUTENAME_PERIODSECONDS, ConfigurationUtilities.getAttributeDecimal(ndProcExt$Extension.getPeriodSeconds()));
		}

		// Verifies attribute
		if (ndProcExt$Extension.getTimeCapacitySeconds() != null) {

			// Saves attribute
			elProcExt$Extension.setAttribute(Module.ATTRIBUTENAME_TIMECAPACITYSECONDS, ConfigurationUtilities.getAttributeDecimal(ndProcExt$Extension.getTimeCapacitySeconds()));
		}

		// Verifies required attribute
		if (ndProcExt$Extension.getDeadline() == null) {
			throw new ConfigurationException("Required attribute Deadline not assigned in Proc_Ext:Extension");
		}

		// Saves attribute
		elProcExt$Extension.setAttribute(Module.ATTRIBUTENAME_DEADLINE, ConfigurationUtilities.getAttributeEnumeration(ndProcExt$Extension.getDeadline()));

		// Verifies attribute
		if (ndProcExt$Extension.getStartDelay() != null) {

			// Saves attribute
			elProcExt$Extension.setAttribute(Module.ATTRIBUTENAME_STARTDELAY, ConfigurationUtilities.getAttributeDecimal(ndProcExt$Extension.getStartDelay()));
		}

		// Verifies attribute
		if (ndProcExt$Extension.getSuspensionTimeSeconds() != null) {

			// Saves attribute
			elProcExt$Extension.setAttribute(Module.ATTRIBUTENAME_SUSPENSIONTIMESECONDS, ConfigurationUtilities.getAttributeDecimal(ndProcExt$Extension.getSuspensionTimeSeconds()));
		}

		// Verifies attribute
		if (ndProcExt$Extension.getSuppressStart() != null) {

			// Saves attribute
			elProcExt$Extension.setAttribute(Module.ATTRIBUTENAME_SUPPRESSSTART, ConfigurationUtilities.getAttributeBoolean(ndProcExt$Extension.getSuppressStart()));
		}

		// Verifies attribute
		if (ndProcExt$Extension.getSuppressMainLoop() != null) {

			// Saves attribute
			elProcExt$Extension.setAttribute(Module.ATTRIBUTENAME_SUPPRESSMAINLOOP, ConfigurationUtilities.getAttributeBoolean(ndProcExt$Extension.getSuppressMainLoop()));
		}

		// Verifies attribute
		if (ndProcExt$Extension.getSuppressSuspension() != null) {

			// Saves attribute
			elProcExt$Extension.setAttribute(Module.ATTRIBUTENAME_SUPPRESSSUSPENSION, ConfigurationUtilities.getAttributeBoolean(ndProcExt$Extension.getSuppressSuspension()));
		}

		// Returns element
		return elProcExt$Extension;
	}

	/**
	 * Constructor.
	 * 
	 * @param ndParent
	 *            Parent.
	 * @param stEntryPoint
	 *            EntryPoint.
	 * @param inBasePriority
	 *            BasePriority.
	 * @param bdPeriodSeconds
	 *            PeriodSeconds.
	 * @param bdTimeCapacitySeconds
	 *            TimeCapacitySeconds.
	 * @param enDeadline
	 *            Deadline.
	 * @param bdStartDelay
	 *            StartDelay.
	 * @param bdSuspensionTimeSeconds
	 *            SuspensionTimeSeconds.
	 * @param blSuppressStart
	 *            SuppressStart.
	 * @param blSuppressMainLoop
	 *            SuppressMainLoop.
	 * @param blSuppressSuspension
	 *            SuppressSuspension.
	 */
	public static ProcExt$Extension newInstance(Process ndParent, String stEntryPoint, Integer inBasePriority, BigDecimal bdPeriodSeconds, BigDecimal bdTimeCapacitySeconds, Deadline enDeadline, BigDecimal bdStartDelay, BigDecimal bdSuspensionTimeSeconds, Boolean blSuppressStart, Boolean blSuppressMainLoop, Boolean blSuppressSuspension) throws ConfigurationException {

		// Verifies parent
		if (ndParent == null) {
			return null;
		}

		// Returns
		return new ProcExt$Extension(ndParent, stEntryPoint, inBasePriority, bdPeriodSeconds, bdTimeCapacitySeconds, enDeadline, bdStartDelay, bdSuspensionTimeSeconds, blSuppressStart, blSuppressMainLoop, blSuppressSuspension);
	}
}
