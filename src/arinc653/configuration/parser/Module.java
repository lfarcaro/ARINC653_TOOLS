package arinc653.configuration.parser;

import arinc653.configuration.parserresources.ConfigurationException;
import arinc653.configuration.parserresources.ConfigurationUtilities;
import arinc653.configuration.parserresources.Identifier;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Auto-generated parser for ARINC_653_Module node.
 */
public class Module {

	/**
	 * Channel node name.
	 */
	public static final String NODENAME_CHANNEL = "Channel";

	/**
	 * Connection_Table node name.
	 */
	public static final String NODENAME_CONNECTIONTABLE = "Connection_Table";

	/**
	 * Destination node name.
	 */
	public static final String NODENAME_DESTINATION = "Destination";

	/**
	 * Pseudo_Partition node name.
	 */
	public static final String NODENAME_DESTINATION_PSEUDOPARTITION = "Pseudo_Partition";

	/**
	 * Standard_Partition node name.
	 */
	public static final String NODENAME_DESTINATION_STANDARDPARTITION = "Standard_Partition";

	/**
	 * Error_ID_Level node name.
	 */
	public static final String NODENAME_ERRORIDLEVEL = "Error_ID_Level";

	/**
	 * Memory_Requirements node name.
	 */
	public static final String NODENAME_MEMORYREQUIREMENTS = "Memory_Requirements";

	/**
	 * ModExt:Extension node name.
	 */
	public static final String NODENAME_MODEXT$EXTENSION = "ModExt:Extension";

	/**
	 * ModExt:Extension_Module_ARMV7A node name.
	 */
	public static final String NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A = "ModExt:Extension_Module_ARMV7A";

	/**
	 * ModExt:Extension_Module_ARMV7A_AM335X node name.
	 */
	public static final String NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A_AM335X = "ModExt:Extension_Module_ARMV7A_AM335X";

	/**
	 * ModExt:Extension_Module_ARMV7A_Z7000 node name.
	 */
	public static final String NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A_Z7000 = "ModExt:Extension_Module_ARMV7A_Z7000";

	/**
	 * ModExt:Extension_System_ARMV7A node name.
	 */
	public static final String NODENAME_MODEXT$EXTENSION_SYSTEM_ARMV7A = "ModExt:Extension_System_ARMV7A";

	/**
	 * Mod_HM_Ext:Extension node name.
	 */
	public static final String NODENAME_MODHMEXT$EXTENSION = "Mod_HM_Ext:Extension";

	/**
	 * ARINC_653_Module node name.
	 */
	public static final String NODENAME_MODULE = "ARINC_653_Module";

	/**
	 * Module_HM_Table node name.
	 */
	public static final String NODENAME_MODULEHMTABLE = "Module_HM_Table";

	/**
	 * System_State_Entry node name.
	 */
	public static final String NODENAME_MODULEHMTABLE_SYSTEMSTATEENTRY = "System_State_Entry";

	/**
	 * Error_ID_Action node name.
	 */
	public static final String NODENAME_MODULEHMTABLE_SYSTEMSTATEENTRY_ERRORIDACTION = "Error_ID_Action";

	/**
	 * Module_Schedule node name.
	 */
	public static final String NODENAME_MODULESCHEDULE = "Module_Schedule";

	/**
	 * Part_HM_Ext:Extension node name.
	 */
	public static final String NODENAME_PARTHMEXT$EXTENSION = "Part_HM_Ext:Extension";

	/**
	 * Partition node name.
	 */
	public static final String NODENAME_PARTITION = "Partition";

	/**
	 * PartitionExt:Extension node name.
	 */
	public static final String NODENAME_PARTITIONEXT$EXTENSION = "PartitionExt:Extension";

	/**
	 * Partition_HM_Table node name.
	 */
	public static final String NODENAME_PARTITIONHMTABLE = "Partition_HM_Table";

	/**
	 * System_State_Entry node name.
	 */
	public static final String NODENAME_PARTITIONHMTABLE_SYSTEMSTATEENTRY = "System_State_Entry";

	/**
	 * Error_ID_Action node name.
	 */
	public static final String NODENAME_PARTITIONHMTABLE_SYSTEMSTATEENTRY_ERRORIDACTION = "Error_ID_Action";

	/**
	 * Partition_Memory node name.
	 */
	public static final String NODENAME_PARTITIONMEMORY = "Partition_Memory";

	/**
	 * Partition_Schedule node name.
	 */
	public static final String NODENAME_PARTITIONSCHEDULE = "Partition_Schedule";

	/**
	 * Proc_Ext:Extension node name.
	 */
	public static final String NODENAME_PROCEXT$EXTENSION = "Proc_Ext:Extension";

	/**
	 * Process node name.
	 */
	public static final String NODENAME_PROCESS = "Process";

	/**
	 * Queuing_Port node name.
	 */
	public static final String NODENAME_QUEUINGPORT = "Queuing_Port";

	/**
	 * PortExt:Extension node name.
	 */
	public static final String NODENAME_QUEUINGPORT_PORTEXT$EXTENSION = "PortExt:Extension";

	/**
	 * Sampling_Port node name.
	 */
	public static final String NODENAME_SAMPLINGPORT = "Sampling_Port";

	/**
	 * PortExt:Extension node name.
	 */
	public static final String NODENAME_SAMPLINGPORT_PORTEXT$EXTENSION = "PortExt:Extension";

	/**
	 * Source node name.
	 */
	public static final String NODENAME_SOURCE = "Source";

	/**
	 * Pseudo_Partition node name.
	 */
	public static final String NODENAME_SOURCE_PSEUDOPARTITION = "Pseudo_Partition";

	/**
	 * Standard_Partition node name.
	 */
	public static final String NODENAME_SOURCE_STANDARDPARTITION = "Standard_Partition";

	/**
	 * SysHM_Ext:Extension node name.
	 */
	public static final String NODENAME_SYSHMEXT$EXTENSION = "SysHM_Ext:Extension";

	/**
	 * System_HM_Table node name.
	 */
	public static final String NODENAME_SYSTEMHMTABLE = "System_HM_Table";

	/**
	 * SysHM_Ext:Error_ID_Action node name.
	 */
	public static final String NODENAME_SYSTEMHMTABLE_SYSHMEXT$EXTENSION_SYSHMEXT$ERRORIDACTION = "SysHM_Ext:Error_ID_Action";

	/**
	 * System_State_Entry node name.
	 */
	public static final String NODENAME_SYSTEMHMTABLE_SYSTEMSTATEENTRY = "System_State_Entry";

	/**
	 * Window_Schedule node name.
	 */
	public static final String NODENAME_WINDOWSCHEDULE = "Window_Schedule";

	/**
	 * Access attribute name.
	 */
	public static final String ATTRIBUTENAME_ACCESS = "Access";

	/**
	 * Action attribute name.
	 */
	public static final String ATTRIBUTENAME_ACTION = "Action";

	/**
	 * BasePriority attribute name.
	 */
	public static final String ATTRIBUTENAME_BASEPRIORITY = "BasePriority";

	/**
	 * ChannelIdentifier attribute name.
	 */
	public static final String ATTRIBUTENAME_CHANNELIDENTIFIER = "ChannelIdentifier";

	/**
	 * ChannelName attribute name.
	 */
	public static final String ATTRIBUTENAME_CHANNELNAME = "ChannelName";

	/**
	 * Criticality attribute name.
	 */
	public static final String ATTRIBUTENAME_CRITICALITY = "Criticality";

	/**
	 * Deadline attribute name.
	 */
	public static final String ATTRIBUTENAME_DEADLINE = "Deadline";

	/**
	 * DefaultStackSize attribute name.
	 */
	public static final String ATTRIBUTENAME_DEFAULTSTACKSIZE = "DefaultStackSize";

	/**
	 * Description attribute name.
	 */
	public static final String ATTRIBUTENAME_DESCRIPTION = "Description";

	/**
	 * Direction attribute name.
	 */
	public static final String ATTRIBUTENAME_DIRECTION = "Direction";

	/**
	 * DisableHealthMonitoring attribute name.
	 */
	public static final String ATTRIBUTENAME_DISABLEHEALTHMONITORING = "DisableHealthMonitoring";

	/**
	 * EntryPoint attribute name.
	 */
	public static final String ATTRIBUTENAME_ENTRYPOINT = "EntryPoint";

	/**
	 * ErrorCode attribute name.
	 */
	public static final String ATTRIBUTENAME_ERRORCODE = "ErrorCode";

	/**
	 * ErrorHandler attribute name.
	 */
	public static final String ATTRIBUTENAME_ERRORHANDLER = "ErrorHandler";

	/**
	 * ErrorHandlerStackSize attribute name.
	 */
	public static final String ATTRIBUTENAME_ERRORHANDLERSTACKSIZE = "ErrorHandlerStackSize";

	/**
	 * ErrorIdentifier attribute name.
	 */
	public static final String ATTRIBUTENAME_ERRORIDENTIFIER = "ErrorIdentifier";

	/**
	 * ErrorLevel attribute name.
	 */
	public static final String ATTRIBUTENAME_ERRORLEVEL = "ErrorLevel";

	/**
	 * MajorFrameSeconds attribute name.
	 */
	public static final String ATTRIBUTENAME_MAJORFRAMESECONDS = "MajorFrameSeconds";

	/**
	 * MaxMessageSize attribute name.
	 */
	public static final String ATTRIBUTENAME_MAXMESSAGESIZE = "MaxMessageSize";

	/**
	 * MaxNbMessages attribute name.
	 */
	public static final String ATTRIBUTENAME_MAXNBMESSAGES = "MaxNbMessages";

	/**
	 * MaximumBlackboardCount attribute name.
	 */
	public static final String ATTRIBUTENAME_MAXIMUMBLACKBOARDCOUNT = "MaximumBlackboardCount";

	/**
	 * MaximumBufferCount attribute name.
	 */
	public static final String ATTRIBUTENAME_MAXIMUMBUFFERCOUNT = "MaximumBufferCount";

	/**
	 * MaximumErrorStatusCount attribute name.
	 */
	public static final String ATTRIBUTENAME_MAXIMUMERRORSTATUSCOUNT = "MaximumErrorStatusCount";

	/**
	 * MaximumEventCount attribute name.
	 */
	public static final String ATTRIBUTENAME_MAXIMUMEVENTCOUNT = "MaximumEventCount";

	/**
	 * MaximumSemaphoreCount attribute name.
	 */
	public static final String ATTRIBUTENAME_MAXIMUMSEMAPHORECOUNT = "MaximumSemaphoreCount";

	/**
	 * ModuleCallback attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULECALLBACK = "ModuleCallback";

	/**
	 * ModuleCallbackStackSize attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULECALLBACKSTACKSIZE = "ModuleCallbackStackSize";

	/**
	 * ModuleCodeRegionPhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULECODEREGIONPHYSICALADDRESS = "ModuleCodeRegionPhysicalAddress";

	/**
	 * ModuleCodeRegionSizeBytes attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULECODEREGIONSIZEBYTES = "ModuleCodeRegionSizeBytes";

	/**
	 * ModuleDataRegionPhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULEDATAREGIONPHYSICALADDRESS = "ModuleDataRegionPhysicalAddress";

	/**
	 * ModuleDataRegionSizeBytes attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULEDATAREGIONSIZEBYTES = "ModuleDataRegionSizeBytes";

	/**
	 * ModuleFLTranslationTableRegionPhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULEFLTRANSLATIONTABLEREGIONPHYSICALADDRESS = "ModuleFLTranslationTableRegionPhysicalAddress";

	/**
	 * ModuleFLTranslationTableRegionSizeBytes attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULEFLTRANSLATIONTABLEREGIONSIZEBYTES = "ModuleFLTranslationTableRegionSizeBytes";

	/**
	 * ModuleHeapRegionPhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULEHEAPREGIONPHYSICALADDRESS = "ModuleHeapRegionPhysicalAddress";

	/**
	 * ModuleHeapRegionSizeBytes attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULEHEAPREGIONSIZEBYTES = "ModuleHeapRegionSizeBytes";

	/**
	 * ModuleId attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULEID = "ModuleId";

	/**
	 * ModuleName attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULENAME = "ModuleName";

	/**
	 * ModuleNetworkPhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULENETWORKPHYSICALADDRESS = "ModuleNetworkPhysicalAddress";

	/**
	 * ModuleSLTranslationTableRegionPhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULESLTRANSLATIONTABLEREGIONPHYSICALADDRESS = "ModuleSLTranslationTableRegionPhysicalAddress";

	/**
	 * ModuleSLTranslationTableRegionSizeBytes attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULESLTRANSLATIONTABLEREGIONSIZEBYTES = "ModuleSLTranslationTableRegionSizeBytes";

	/**
	 * ModuleStackRegionPhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULESTACKREGIONPHYSICALADDRESS = "ModuleStackRegionPhysicalAddress";

	/**
	 * ModuleStackRegionSizeBytes attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULESTACKREGIONSIZEBYTES = "ModuleStackRegionSizeBytes";

	/**
	 * ModuleVersion attribute name.
	 */
	public static final String ATTRIBUTENAME_MODULEVERSION = "ModuleVersion";

	/**
	 * Name attribute name.
	 */
	public static final String ATTRIBUTENAME_NAME = "Name";

	/**
	 * PartitionCallback attribute name.
	 */
	public static final String ATTRIBUTENAME_PARTITIONCALLBACK = "PartitionCallback";

	/**
	 * PartitionCallbackStackSize attribute name.
	 */
	public static final String ATTRIBUTENAME_PARTITIONCALLBACKSTACKSIZE = "PartitionCallbackStackSize";

	/**
	 * PartitionIdentifier attribute name.
	 */
	public static final String ATTRIBUTENAME_PARTITIONIDENTIFIER = "PartitionIdentifier";

	/**
	 * PartitionName attribute name.
	 */
	public static final String ATTRIBUTENAME_PARTITIONNAME = "PartitionName";

	/**
	 * PartitionPeriodStart attribute name.
	 */
	public static final String ATTRIBUTENAME_PARTITIONPERIODSTART = "PartitionPeriodStart";

	/**
	 * PeriodDurationSeconds attribute name.
	 */
	public static final String ATTRIBUTENAME_PERIODDURATIONSECONDS = "PeriodDurationSeconds";

	/**
	 * PeriodSeconds attribute name.
	 */
	public static final String ATTRIBUTENAME_PERIODSECONDS = "PeriodSeconds";

	/**
	 * PhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_PHYSICALADDRESS = "PhysicalAddress";

	/**
	 * PortName attribute name.
	 */
	public static final String ATTRIBUTENAME_PORTNAME = "PortName";

	/**
	 * PredefinedSystemPartition attribute name.
	 */
	public static final String ATTRIBUTENAME_PREDEFINEDSYSTEMPARTITION = "PredefinedSystemPartition";

	/**
	 * Procedure attribute name.
	 */
	public static final String ATTRIBUTENAME_PROCEDURE = "Procedure";

	/**
	 * QueuingDiscipline attribute name.
	 */
	public static final String ATTRIBUTENAME_QUEUINGDISCIPLINE = "QueuingDiscipline";

	/**
	 * RefreshRateSeconds attribute name.
	 */
	public static final String ATTRIBUTENAME_REFRESHRATESECONDS = "RefreshRateSeconds";

	/**
	 * RegionName attribute name.
	 */
	public static final String ATTRIBUTENAME_REGIONNAME = "RegionName";

	/**
	 * SizeBytes attribute name.
	 */
	public static final String ATTRIBUTENAME_SIZEBYTES = "SizeBytes";

	/**
	 * StackSize attribute name.
	 */
	public static final String ATTRIBUTENAME_STACKSIZE = "StackSize";

	/**
	 * StartDelay attribute name.
	 */
	public static final String ATTRIBUTENAME_STARTDELAY = "StartDelay";

	/**
	 * SuppressErrorHandlerStopCall attribute name.
	 */
	public static final String ATTRIBUTENAME_SUPPRESSERRORHANDLERSTOPCALL = "SuppressErrorHandlerStopCall";

	/**
	 * SuppressMainLoop attribute name.
	 */
	public static final String ATTRIBUTENAME_SUPPRESSMAINLOOP = "SuppressMainLoop";

	/**
	 * SuppressModuleIdlePartitionMainLoop attribute name.
	 */
	public static final String ATTRIBUTENAME_SUPPRESSMODULEIDLEPARTITIONMAINLOOP = "SuppressModuleIdlePartitionMainLoop";

	/**
	 * SuppressPartitionIdleProcessMainLoop attribute name.
	 */
	public static final String ATTRIBUTENAME_SUPPRESSPARTITIONIDLEPROCESSMAINLOOP = "SuppressPartitionIdleProcessMainLoop";

	/**
	 * SuppressStart attribute name.
	 */
	public static final String ATTRIBUTENAME_SUPPRESSSTART = "SuppressStart";

	/**
	 * SuppressSuspension attribute name.
	 */
	public static final String ATTRIBUTENAME_SUPPRESSSUSPENSION = "SuppressSuspension";

	/**
	 * SuspensionTimeSeconds attribute name.
	 */
	public static final String ATTRIBUTENAME_SUSPENSIONTIMESECONDS = "SuspensionTimeSeconds";

	/**
	 * SystemBootRegionPhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_SYSTEMBOOTREGIONPHYSICALADDRESS = "SystemBootRegionPhysicalAddress";

	/**
	 * SystemBootRegionSizeBytes attribute name.
	 */
	public static final String ATTRIBUTENAME_SYSTEMBOOTREGIONSIZEBYTES = "SystemBootRegionSizeBytes";

	/**
	 * SystemCodeRegionPhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_SYSTEMCODEREGIONPHYSICALADDRESS = "SystemCodeRegionPhysicalAddress";

	/**
	 * SystemCodeRegionSizeBytes attribute name.
	 */
	public static final String ATTRIBUTENAME_SYSTEMCODEREGIONSIZEBYTES = "SystemCodeRegionSizeBytes";

	/**
	 * SystemDataRegionPhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_SYSTEMDATAREGIONPHYSICALADDRESS = "SystemDataRegionPhysicalAddress";

	/**
	 * SystemDataRegionSizeBytes attribute name.
	 */
	public static final String ATTRIBUTENAME_SYSTEMDATAREGIONSIZEBYTES = "SystemDataRegionSizeBytes";

	/**
	 * SystemPartition attribute name.
	 */
	public static final String ATTRIBUTENAME_SYSTEMPARTITION = "SystemPartition";

	/**
	 * SystemRAMMemoryPhysicalAddress attribute name.
	 */
	public static final String ATTRIBUTENAME_SYSTEMRAMMEMORYPHYSICALADDRESS = "SystemRAMMemoryPhysicalAddress";

	/**
	 * SystemRAMMemorySizeBytes attribute name.
	 */
	public static final String ATTRIBUTENAME_SYSTEMRAMMEMORYSIZEBYTES = "SystemRAMMemorySizeBytes";

	/**
	 * SystemState attribute name.
	 */
	public static final String ATTRIBUTENAME_SYSTEMSTATE = "SystemState";

	/**
	 * TimeCapacitySeconds attribute name.
	 */
	public static final String ATTRIBUTENAME_TIMECAPACITYSECONDS = "TimeCapacitySeconds";

	/**
	 * Type attribute name.
	 */
	public static final String ATTRIBUTENAME_TYPE = "Type";

	/**
	 * WindowDurationSeconds attribute name.
	 */
	public static final String ATTRIBUTENAME_WINDOWDURATIONSECONDS = "WindowDurationSeconds";

	/**
	 * WindowIdentifier attribute name.
	 */
	public static final String ATTRIBUTENAME_WINDOWIDENTIFIER = "WindowIdentifier";

	/**
	 * WindowStartSeconds attribute name.
	 */
	public static final String ATTRIBUTENAME_WINDOWSTARTSECONDS = "WindowStartSeconds";

	/**
	 * ModuleName attribute.
	 */
	private String stModuleName;

	/**
	 * ModuleVersion attribute.
	 */
	private String stModuleVersion;

	/**
	 * ModuleId attribute.
	 */
	private Identifier idModuleId;

	/**
	 * Other attribute map.
	 */
	private Map<String, String> mpOtherAttribute = new HashMap<String, String>();

	/**
	 * System_HM_Table node list.
	 */
	private List<SystemHMTable> lsSystemHMTable = new LinkedList<SystemHMTable>();

	/**
	 * Module_HM_Table node list.
	 */
	private List<ModuleHMTable> lsModuleHMTable = new LinkedList<ModuleHMTable>();

	/**
	 * Partition node list.
	 */
	private List<Partition> lsPartition = new LinkedList<Partition>();

	/**
	 * Partition node map.
	 */
	private Map<Identifier, Partition> mpPartition = new HashMap<Identifier, Partition>();

	/**
	 * Partition_Memory node list.
	 */
	private List<PartitionMemory> lsPartitionMemory = new LinkedList<PartitionMemory>();

	/**
	 * Partition_Memory node map.
	 */
	private Map<Identifier, PartitionMemory> mpPartitionMemory = new HashMap<Identifier, PartitionMemory>();

	/**
	 * Module_Schedule node list.
	 */
	private List<ModuleSchedule> lsModuleSchedule = new LinkedList<ModuleSchedule>();

	/**
	 * Partition_HM_Table node list.
	 */
	private List<PartitionHMTable> lsPartitionHMTable = new LinkedList<PartitionHMTable>();

	/**
	 * Partition_HM_Table node map.
	 */
	private Map<Identifier, PartitionHMTable> mpPartitionHMTable = new HashMap<Identifier, PartitionHMTable>();

	/**
	 * Connection_Table node list.
	 */
	private List<ConnectionTable> lsConnectionTable = new LinkedList<ConnectionTable>();

	/**
	 * ModExt:Extension node list.
	 */
	private List<ModExt$Extension> lsModExt$Extension = new LinkedList<ModExt$Extension>();

	/**
	 * ModExt:Extension_System_ARMV7A node list.
	 */
	private List<ModExt$Extension_System_ARMV7A> lsModExt$Extension_System_ARMV7A = new LinkedList<ModExt$Extension_System_ARMV7A>();

	/**
	 * ModExt:Extension_Module_ARMV7A node list.
	 */
	private List<ModExt$Extension_Module_ARMV7A> lsModExt$Extension_Module_ARMV7A = new LinkedList<ModExt$Extension_Module_ARMV7A>();

	/**
	 * ModExt:Extension_Module_ARMV7A_AM335X node list.
	 */
	private List<ModExt$Extension_Module_ARMV7A_AM335X> lsModExt$Extension_Module_ARMV7A_AM335X = new LinkedList<ModExt$Extension_Module_ARMV7A_AM335X>();

	/**
	 * ModExt:Extension_Module_ARMV7A_Z7000 node list.
	 */
	private List<ModExt$Extension_Module_ARMV7A_Z7000> lsModExt$Extension_Module_ARMV7A_Z7000 = new LinkedList<ModExt$Extension_Module_ARMV7A_Z7000>();

	/**
	 * Constructor.
	 */
	private Module() {
	}

	/**
	 * Constructor.
	 * 
	 * @param stModuleName
	 *            ModuleName.
	 * @param stModuleVersion
	 *            ModuleVersion.
	 * @param idModuleId
	 *            ModuleId.
	 */
	private Module(String stModuleName, String stModuleVersion, Identifier idModuleId) throws ConfigurationException {
		this.stModuleName = stModuleName;
		this.stModuleVersion = stModuleVersion;
		this.idModuleId = idModuleId;
	}

	/**
	 * ModuleName getter.
	 */
	public String getModuleName() {
		return this.stModuleName;
	}

	/**
	 * ModuleName setter.
	 */
	public void setModuleName(String stModuleName) {
		this.stModuleName = stModuleName;
	}

	/**
	 * ModuleVersion getter.
	 */
	public String getModuleVersion() {
		return this.stModuleVersion;
	}

	/**
	 * ModuleVersion setter.
	 */
	public void setModuleVersion(String stModuleVersion) {
		this.stModuleVersion = stModuleVersion;
	}

	/**
	 * ModuleId getter.
	 */
	public Identifier getModuleId() {
		return this.idModuleId;
	}

	/**
	 * ModuleId setter.
	 */
	public void setModuleId(Identifier idModuleId) {
		this.idModuleId = idModuleId;
	}

	/**
	 * Other attribute getter.
	 */
	public String getOtherAttribute(String stAttribute) {

		// Verifies attribute
		if (stAttribute == null) {
			return null;
		}

		// Gets other attribute
		return this.mpOtherAttribute.get(stAttribute.intern());
	}

	/**
	 * Other attribute setter.
	 */
	public void setOtherAttribute(String stAttribute, String stValue) {

		// Verifies attribute
		if (stAttribute == null) {
			return;
		}

		// Verifies value
		if (stValue != null) {

			// Sets other attribute
			this.mpOtherAttribute.put(stAttribute.intern(), stValue);
		} else {

			// Removes other attribute
			this.mpOtherAttribute.remove(stAttribute.intern());
		}
	}

	/**
	 * Other attributes getter.
	 */
	public Map<String, String> getOtherAttributes() {

		// Returns a map copy
		return new HashMap<String, String>(this.mpOtherAttribute);
	}

	/**
	 * System_HM_Table adder.
	 * 
	 * @param ndSystemHMTable
	 *            System_HM_Table.
	 */
	public boolean addSystemHMTable(SystemHMTable ndSystemHMTable) {

		// Verifies node
		if (ndSystemHMTable == null) {
			return false;
		}

		// Adds node
		lsSystemHMTable.add(ndSystemHMTable);
		return true;
	}

	/**
	 * System_HM_Table list getter.
	 */
	public List<SystemHMTable> getSystemHMTableList() {
		return new LinkedList<SystemHMTable>(this.lsSystemHMTable);
	}

	/**
	 * Module_HM_Table adder.
	 * 
	 * @param ndModuleHMTable
	 *            Module_HM_Table.
	 */
	public boolean addModuleHMTable(ModuleHMTable ndModuleHMTable) {

		// Verifies node
		if (ndModuleHMTable == null) {
			return false;
		}

		// Adds node
		lsModuleHMTable.add(ndModuleHMTable);
		return true;
	}

	/**
	 * Module_HM_Table list getter.
	 */
	public List<ModuleHMTable> getModuleHMTableList() {
		return new LinkedList<ModuleHMTable>(this.lsModuleHMTable);
	}

	/**
	 * Partition adder.
	 * 
	 * @param ndPartition
	 *            Partition.
	 */
	public boolean addPartition(Partition ndPartition) {

		// Verifies node
		if (ndPartition == null) {
			return false;
		}

		// Verifies identifier
		if (mpPartition.containsKey(ndPartition.getPartitionIdentifier())) {
			return false;
		}

		// Adds node
		lsPartition.add(ndPartition);

		// Maps node
		mpPartition.put(ndPartition.getPartitionIdentifier(), ndPartition);
		return true;
	}

	/**
	 * Partition getter.
	 * 
	 * @param idPartitionIdentifier
	 *            PartitionIdentifier.
	 */
	public Partition getPartition(Identifier idPartitionIdentifier) {
		return (idPartitionIdentifier == null ? null : this.mpPartition.get(idPartitionIdentifier));
	}

	/**
	 * Partition PartitionIdentifier set getter.
	 */
	public Set<Identifier> getPartitionPartitionIdentifierSet() {
		return this.mpPartition.keySet();
	}

	/**
	 * Partition list getter.
	 */
	public List<Partition> getPartitionList() {
		return new LinkedList<Partition>(this.lsPartition);
	}

	/**
	 * Partition_Memory adder.
	 * 
	 * @param ndPartitionMemory
	 *            Partition_Memory.
	 */
	public boolean addPartitionMemory(PartitionMemory ndPartitionMemory) {

		// Verifies node
		if (ndPartitionMemory == null) {
			return false;
		}

		// Verifies identifier
		if (mpPartitionMemory.containsKey(ndPartitionMemory.getPartitionIdentifier())) {
			return false;
		}

		// Adds node
		lsPartitionMemory.add(ndPartitionMemory);

		// Maps node
		mpPartitionMemory.put(ndPartitionMemory.getPartitionIdentifier(), ndPartitionMemory);
		return true;
	}

	/**
	 * Partition_Memory getter.
	 * 
	 * @param idPartitionIdentifier
	 *            PartitionIdentifier.
	 */
	public PartitionMemory getPartitionMemory(Identifier idPartitionIdentifier) {
		return (idPartitionIdentifier == null ? null : this.mpPartitionMemory.get(idPartitionIdentifier));
	}

	/**
	 * Partition_Memory PartitionIdentifier set getter.
	 */
	public Set<Identifier> getPartitionMemoryPartitionIdentifierSet() {
		return this.mpPartitionMemory.keySet();
	}

	/**
	 * Partition_Memory list getter.
	 */
	public List<PartitionMemory> getPartitionMemoryList() {
		return new LinkedList<PartitionMemory>(this.lsPartitionMemory);
	}

	/**
	 * Module_Schedule adder.
	 * 
	 * @param ndModuleSchedule
	 *            Module_Schedule.
	 */
	public boolean addModuleSchedule(ModuleSchedule ndModuleSchedule) {

		// Verifies node
		if (ndModuleSchedule == null) {
			return false;
		}

		// Adds node
		lsModuleSchedule.add(ndModuleSchedule);
		return true;
	}

	/**
	 * Module_Schedule list getter.
	 */
	public List<ModuleSchedule> getModuleScheduleList() {
		return new LinkedList<ModuleSchedule>(this.lsModuleSchedule);
	}

	/**
	 * Partition_HM_Table adder.
	 * 
	 * @param ndPartitionHMTable
	 *            Partition_HM_Table.
	 */
	public boolean addPartitionHMTable(PartitionHMTable ndPartitionHMTable) {

		// Verifies node
		if (ndPartitionHMTable == null) {
			return false;
		}

		// Verifies identifier
		if (mpPartitionHMTable.containsKey(ndPartitionHMTable.getPartitionIdentifier())) {
			return false;
		}

		// Adds node
		lsPartitionHMTable.add(ndPartitionHMTable);

		// Maps node
		mpPartitionHMTable.put(ndPartitionHMTable.getPartitionIdentifier(), ndPartitionHMTable);
		return true;
	}

	/**
	 * Partition_HM_Table getter.
	 * 
	 * @param idPartitionIdentifier
	 *            PartitionIdentifier.
	 */
	public PartitionHMTable getPartitionHMTable(Identifier idPartitionIdentifier) {
		return (idPartitionIdentifier == null ? null : this.mpPartitionHMTable.get(idPartitionIdentifier));
	}

	/**
	 * Partition_HM_Table PartitionIdentifier set getter.
	 */
	public Set<Identifier> getPartitionHMTablePartitionIdentifierSet() {
		return this.mpPartitionHMTable.keySet();
	}

	/**
	 * Partition_HM_Table list getter.
	 */
	public List<PartitionHMTable> getPartitionHMTableList() {
		return new LinkedList<PartitionHMTable>(this.lsPartitionHMTable);
	}

	/**
	 * Connection_Table adder.
	 * 
	 * @param ndConnectionTable
	 *            Connection_Table.
	 */
	public boolean addConnectionTable(ConnectionTable ndConnectionTable) {

		// Verifies node
		if (ndConnectionTable == null) {
			return false;
		}

		// Adds node
		lsConnectionTable.add(ndConnectionTable);
		return true;
	}

	/**
	 * Connection_Table list getter.
	 */
	public List<ConnectionTable> getConnectionTableList() {
		return new LinkedList<ConnectionTable>(this.lsConnectionTable);
	}

	/**
	 * ModExt:Extension adder.
	 * 
	 * @param ndModExt$Extension
	 *            ModExt:Extension.
	 */
	public boolean addModExt$Extension(ModExt$Extension ndModExt$Extension) {

		// Verifies node
		if (ndModExt$Extension == null) {
			return false;
		}

		// Adds node
		lsModExt$Extension.add(ndModExt$Extension);
		return true;
	}

	/**
	 * ModExt:Extension list getter.
	 */
	public List<ModExt$Extension> getModExt$ExtensionList() {
		return new LinkedList<ModExt$Extension>(this.lsModExt$Extension);
	}

	/**
	 * ModExt:Extension_System_ARMV7A adder.
	 * 
	 * @param ndModExt$Extension_System_ARMV7A
	 *            ModExt:Extension_System_ARMV7A.
	 */
	public boolean addModExt$Extension_System_ARMV7A(ModExt$Extension_System_ARMV7A ndModExt$Extension_System_ARMV7A) {

		// Verifies node
		if (ndModExt$Extension_System_ARMV7A == null) {
			return false;
		}

		// Adds node
		lsModExt$Extension_System_ARMV7A.add(ndModExt$Extension_System_ARMV7A);
		return true;
	}

	/**
	 * ModExt:Extension_System_ARMV7A list getter.
	 */
	public List<ModExt$Extension_System_ARMV7A> getModExt$Extension_System_ARMV7AList() {
		return new LinkedList<ModExt$Extension_System_ARMV7A>(this.lsModExt$Extension_System_ARMV7A);
	}

	/**
	 * ModExt:Extension_Module_ARMV7A adder.
	 * 
	 * @param ndModExt$Extension_Module_ARMV7A
	 *            ModExt:Extension_Module_ARMV7A.
	 */
	public boolean addModExt$Extension_Module_ARMV7A(ModExt$Extension_Module_ARMV7A ndModExt$Extension_Module_ARMV7A) {

		// Verifies node
		if (ndModExt$Extension_Module_ARMV7A == null) {
			return false;
		}

		// Adds node
		lsModExt$Extension_Module_ARMV7A.add(ndModExt$Extension_Module_ARMV7A);
		return true;
	}

	/**
	 * ModExt:Extension_Module_ARMV7A list getter.
	 */
	public List<ModExt$Extension_Module_ARMV7A> getModExt$Extension_Module_ARMV7AList() {
		return new LinkedList<ModExt$Extension_Module_ARMV7A>(this.lsModExt$Extension_Module_ARMV7A);
	}

	/**
	 * ModExt:Extension_Module_ARMV7A_AM335X adder.
	 * 
	 * @param ndModExt$Extension_Module_ARMV7A_AM335X
	 *            ModExt:Extension_Module_ARMV7A_AM335X.
	 */
	public boolean addModExt$Extension_Module_ARMV7A_AM335X(ModExt$Extension_Module_ARMV7A_AM335X ndModExt$Extension_Module_ARMV7A_AM335X) {

		// Verifies node
		if (ndModExt$Extension_Module_ARMV7A_AM335X == null) {
			return false;
		}

		// Adds node
		lsModExt$Extension_Module_ARMV7A_AM335X.add(ndModExt$Extension_Module_ARMV7A_AM335X);
		return true;
	}

	/**
	 * ModExt:Extension_Module_ARMV7A_AM335X list getter.
	 */
	public List<ModExt$Extension_Module_ARMV7A_AM335X> getModExt$Extension_Module_ARMV7A_AM335XList() {
		return new LinkedList<ModExt$Extension_Module_ARMV7A_AM335X>(this.lsModExt$Extension_Module_ARMV7A_AM335X);
	}

	/**
	 * ModExt:Extension_Module_ARMV7A_Z7000 adder.
	 * 
	 * @param ndModExt$Extension_Module_ARMV7A_Z7000
	 *            ModExt:Extension_Module_ARMV7A_Z7000.
	 */
	public boolean addModExt$Extension_Module_ARMV7A_Z7000(ModExt$Extension_Module_ARMV7A_Z7000 ndModExt$Extension_Module_ARMV7A_Z7000) {

		// Verifies node
		if (ndModExt$Extension_Module_ARMV7A_Z7000 == null) {
			return false;
		}

		// Adds node
		lsModExt$Extension_Module_ARMV7A_Z7000.add(ndModExt$Extension_Module_ARMV7A_Z7000);
		return true;
	}

	/**
	 * ModExt:Extension_Module_ARMV7A_Z7000 list getter.
	 */
	public List<ModExt$Extension_Module_ARMV7A_Z7000> getModExt$Extension_Module_ARMV7A_Z7000List() {
		return new LinkedList<ModExt$Extension_Module_ARMV7A_Z7000>(this.lsModExt$Extension_Module_ARMV7A_Z7000);
	}

	/**
	 * Loading method.
	 * 
	 * @param ndNode
	 *            Node.
	 */
	public static Module cmdLoad(Node ndNode) throws ConfigurationException {

		// Verifies node
		if (ndNode == null) {
			throw new ConfigurationException("Cannot load null node");
		}

		// Verifies node
		if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!Module.NODENAME_MODULE.equals(ndNode.getNodeName()))) {
			throw new ConfigurationException("Node does not represent a ARINC_653_Module");
		}

		// Creates node
		Module ndModule = new Module();

		// Loads attribute
		ndModule.stModuleName = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_MODULENAME);

		// Loads attribute
		ndModule.stModuleVersion = ConfigurationUtilities.getStringAttribute(ndNode, Module.ATTRIBUTENAME_MODULEVERSION);

		// Loads attribute
		try {
			ndModule.idModuleId = ConfigurationUtilities.getIdentifierAttribute(ndNode, Module.ATTRIBUTENAME_MODULEID);
		} catch (Exception e) {
			throw new ConfigurationException("Attribute ModuleId value cannot be parsed");
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
			if (Module.ATTRIBUTENAME_MODULENAME.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULEVERSION.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Verifies attribute
			if (Module.ATTRIBUTENAME_MODULEID.equals(ndAttribute.getNodeName())) {
				continue;
			}

			// Sets other attribute
			ndModule.mpOtherAttribute.put(ndAttribute.getNodeName().intern(), ndAttribute.getNodeValue());
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
			if (Module.NODENAME_SYSTEMHMTABLE.equals(ndChildNode.getNodeName())) {

				// Loads child
				SystemHMTable ndSystemHMTable = SystemHMTable.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndSystemHMTable == null) {
					throw new ConfigurationException("Error while loading a System_HM_Table node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addSystemHMTable(ndSystemHMTable);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_MODULEHMTABLE.equals(ndChildNode.getNodeName())) {

				// Loads child
				ModuleHMTable ndModuleHMTable = ModuleHMTable.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndModuleHMTable == null) {
					throw new ConfigurationException("Error while loading a Module_HM_Table node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addModuleHMTable(ndModuleHMTable);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_PARTITION.equals(ndChildNode.getNodeName())) {

				// Loads child
				Partition ndPartition = Partition.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndPartition == null) {
					throw new ConfigurationException("Error while loading a Partition node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addPartition(ndPartition);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_PARTITIONMEMORY.equals(ndChildNode.getNodeName())) {

				// Loads child
				PartitionMemory ndPartitionMemory = PartitionMemory.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndPartitionMemory == null) {
					throw new ConfigurationException("Error while loading a Partition_Memory node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addPartitionMemory(ndPartitionMemory);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_MODULESCHEDULE.equals(ndChildNode.getNodeName())) {

				// Loads child
				ModuleSchedule ndModuleSchedule = ModuleSchedule.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndModuleSchedule == null) {
					throw new ConfigurationException("Error while loading a Module_Schedule node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addModuleSchedule(ndModuleSchedule);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_PARTITIONHMTABLE.equals(ndChildNode.getNodeName())) {

				// Loads child
				PartitionHMTable ndPartitionHMTable = PartitionHMTable.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndPartitionHMTable == null) {
					throw new ConfigurationException("Error while loading a Partition_HM_Table node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addPartitionHMTable(ndPartitionHMTable);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_CONNECTIONTABLE.equals(ndChildNode.getNodeName())) {

				// Loads child
				ConnectionTable ndConnectionTable = ConnectionTable.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndConnectionTable == null) {
					throw new ConfigurationException("Error while loading a Connection_Table node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addConnectionTable(ndConnectionTable);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_MODEXT$EXTENSION.equals(ndChildNode.getNodeName())) {

				// Loads child
				ModExt$Extension ndModExt$Extension = ModExt$Extension.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndModExt$Extension == null) {
					throw new ConfigurationException("Error while loading a ModExt:Extension node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addModExt$Extension(ndModExt$Extension);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_MODEXT$EXTENSION_SYSTEM_ARMV7A.equals(ndChildNode.getNodeName())) {

				// Loads child
				ModExt$Extension_System_ARMV7A ndModExt$Extension_System_ARMV7A = ModExt$Extension_System_ARMV7A.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndModExt$Extension_System_ARMV7A == null) {
					throw new ConfigurationException("Error while loading a ModExt:Extension_System_ARMV7A node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addModExt$Extension_System_ARMV7A(ndModExt$Extension_System_ARMV7A);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A.equals(ndChildNode.getNodeName())) {

				// Loads child
				ModExt$Extension_Module_ARMV7A ndModExt$Extension_Module_ARMV7A = ModExt$Extension_Module_ARMV7A.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndModExt$Extension_Module_ARMV7A == null) {
					throw new ConfigurationException("Error while loading a ModExt:Extension_Module_ARMV7A node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addModExt$Extension_Module_ARMV7A(ndModExt$Extension_Module_ARMV7A);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A_AM335X.equals(ndChildNode.getNodeName())) {

				// Loads child
				ModExt$Extension_Module_ARMV7A_AM335X ndModExt$Extension_Module_ARMV7A_AM335X = ModExt$Extension_Module_ARMV7A_AM335X.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndModExt$Extension_Module_ARMV7A_AM335X == null) {
					throw new ConfigurationException("Error while loading a ModExt:Extension_Module_ARMV7A_AM335X node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addModExt$Extension_Module_ARMV7A_AM335X(ndModExt$Extension_Module_ARMV7A_AM335X);
				continue;
			}

			// Verifies node
			if (Module.NODENAME_MODEXT$EXTENSION_MODULE_ARMV7A_Z7000.equals(ndChildNode.getNodeName())) {

				// Loads child
				ModExt$Extension_Module_ARMV7A_Z7000 ndModExt$Extension_Module_ARMV7A_Z7000 = ModExt$Extension_Module_ARMV7A_Z7000.cmdLoad(ndChildNode, ndModule);

				// Verifies child
				if (ndModExt$Extension_Module_ARMV7A_Z7000 == null) {
					throw new ConfigurationException("Error while loading a ModExt:Extension_Module_ARMV7A_Z7000 node (ARINC_653_Module child)");
				}

				// Adds child
				ndModule.addModExt$Extension_Module_ARMV7A_Z7000(ndModExt$Extension_Module_ARMV7A_Z7000);
				continue;
			}

			// Throws exception
			throw new ConfigurationException("Unexpected node " + ndChildNode.getNodeName() + " found in ARINC_653_Module node");
		}

		// Returns node
		return ndModule;
	}

	/**
	 * Document loading method.
	 * 
	 * @param dcDocument
	 *            Document.
	 */
	public static Module cmdLoadDocument(Document dcDocument) throws ConfigurationException {

		// Verifies document
		if (dcDocument == null) {
			throw new ConfigurationException("Cannot load null document");
		}

		// Iterates child nodes
		NodeList nlNodeList = dcDocument.getChildNodes();
		for (int i = 0; i < nlNodeList.getLength(); i++) {

			// Gets next child node
			Node ndChildNode = nlNodeList.item(i);

			// Verifies node
			if ((ndChildNode.getNodeType() == Node.ELEMENT_NODE) && (Module.NODENAME_MODULE.equals(ndChildNode.getNodeName()))) {

				// Loads node
				return Module.cmdLoad(ndChildNode);
			} else if (ndChildNode.getNodeType() == Node.ELEMENT_NODE) {
				throw new ConfigurationException("Unknown node found in document");
			}
		}

		// Throws exception
		throw new ConfigurationException("No node found in document");
	}

	/**
	 * Stream loading method.
	 * 
	 * @param isInputStream
	 *            Stream.
	 */
	public static Module cmdLoadStream(InputStream isInputStream) throws ConfigurationException {
		try {

			// Verifies stream
			if (isInputStream == null) {
				throw new ConfigurationException("Cannot load null stream");
			}

			// Creates document builder factory
			DocumentBuilderFactory fcDocumentBuilderFactory = DocumentBuilderFactory.newInstance();

			// Creates document builder
			DocumentBuilder dbDocumentBuilder = fcDocumentBuilderFactory.newDocumentBuilder();

			// Parses document
			Document dcDocument = dbDocumentBuilder.parse(isInputStream);

			// Loads document
			return Module.cmdLoadDocument(dcDocument);
		} catch (ConfigurationException e) {

			// Throws exception
			throw e;
		} catch (Throwable t) {

			// Throws exception
			throw new ConfigurationException("Error while loading stream", t);
		}
	}

	/**
	 * File loading method.
	 * 
	 * @param flFile
	 *            File.
	 */
	public static Module cmdLoadFile(File flFile) throws ConfigurationException {
		try {

			// Creates input stream
			InputStream isInputStream = new FileInputStream(flFile);
			try {

				// Loads stream
				return Module.cmdLoadStream(isInputStream);
			} finally {

				// Closes input stream
				isInputStream.close();
			}
		} catch (ConfigurationException e) {

			// Throws exception
			throw e;
		} catch (Throwable t) {

			// Throws exception
			throw new ConfigurationException("Error while loading file", t);
		}
	}

	/**
	 * Resource loading method.
	 * 
	 * @param stResource
	 *            Resource.
	 */
	public static Module cmdLoadResource(String stResource) throws ConfigurationException {
		try {

			// Loads stream
			return Module.cmdLoadStream(Module.class.getResourceAsStream(stResource));
		} catch (ConfigurationException e) {

			// Throws exception
			throw e;
		} catch (Throwable t) {

			// Throws exception
			throw new ConfigurationException("Error while loading resource", t);
		}
	}

	/**
	 * String loading method.
	 * 
	 * @param stString
	 *            String.
	 */
	public static Module cmdLoadString(String stString) throws ConfigurationException {

		// Verifies string
		if (stString == null) {
			throw new ConfigurationException("Cannot load null string");
		}

		// Loads stream
		return Module.cmdLoadStream(new ByteArrayInputStream(stString.getBytes()));
	}

	/**
	 * Saving method.
	 * 
	 * @param elParent
	 *            Parent.
	 * @param ndModule
	 *            ARINC_653_Module.
	 */
	public static Element cmdSave(Element elParent, Module ndModule) throws ConfigurationException {

		// Creates element
		Element elModule = elParent.getOwnerDocument().createElement(Module.NODENAME_MODULE);

		// Verifies attribute
		if (ndModule.getModuleName() != null) {

			// Saves attribute
			elModule.setAttribute(Module.ATTRIBUTENAME_MODULENAME, ConfigurationUtilities.getAttributeString(ndModule.getModuleName()));
		}

		// Verifies attribute
		if (ndModule.getModuleVersion() != null) {

			// Saves attribute
			elModule.setAttribute(Module.ATTRIBUTENAME_MODULEVERSION, ConfigurationUtilities.getAttributeString(ndModule.getModuleVersion()));
		}

		// Verifies attribute
		if (ndModule.getModuleId() != null) {

			// Saves attribute
			elModule.setAttribute(Module.ATTRIBUTENAME_MODULEID, ConfigurationUtilities.getAttributeIdentifier(ndModule.getModuleId()));
		}

		// Iterates other attributes
		Iterator<String> itOtherAttribute = ndModule.getOtherAttributes().keySet().iterator();
		while (itOtherAttribute.hasNext()) {

			// Gets next attribute
			String stAttribute = itOtherAttribute.next();

			// Saves attribute
			elModule.setAttribute(stAttribute, ndModule.getOtherAttribute(stAttribute));
		}

		// Iterates children
		Iterator<SystemHMTable> itSystemHMTable = ndModule.getSystemHMTableList().iterator();
		while (itSystemHMTable.hasNext()) {

			// Appends child
			elModule.appendChild(SystemHMTable.cmdSave(elModule, itSystemHMTable.next()));
		}

		// Iterates children
		Iterator<ModuleHMTable> itModuleHMTable = ndModule.getModuleHMTableList().iterator();
		while (itModuleHMTable.hasNext()) {

			// Appends child
			elModule.appendChild(ModuleHMTable.cmdSave(elModule, itModuleHMTable.next()));
		}

		// Iterates children
		Iterator<Partition> itPartition = ndModule.getPartitionList().iterator();
		while (itPartition.hasNext()) {

			// Appends child
			elModule.appendChild(Partition.cmdSave(elModule, itPartition.next()));
		}

		// Iterates children
		Iterator<PartitionMemory> itPartitionMemory = ndModule.getPartitionMemoryList().iterator();
		while (itPartitionMemory.hasNext()) {

			// Appends child
			elModule.appendChild(PartitionMemory.cmdSave(elModule, itPartitionMemory.next()));
		}

		// Iterates children
		Iterator<ModuleSchedule> itModuleSchedule = ndModule.getModuleScheduleList().iterator();
		while (itModuleSchedule.hasNext()) {

			// Appends child
			elModule.appendChild(ModuleSchedule.cmdSave(elModule, itModuleSchedule.next()));
		}

		// Iterates children
		Iterator<PartitionHMTable> itPartitionHMTable = ndModule.getPartitionHMTableList().iterator();
		while (itPartitionHMTable.hasNext()) {

			// Appends child
			elModule.appendChild(PartitionHMTable.cmdSave(elModule, itPartitionHMTable.next()));
		}

		// Iterates children
		Iterator<ConnectionTable> itConnectionTable = ndModule.getConnectionTableList().iterator();
		while (itConnectionTable.hasNext()) {

			// Appends child
			elModule.appendChild(ConnectionTable.cmdSave(elModule, itConnectionTable.next()));
		}

		// Iterates children
		Iterator<ModExt$Extension> itModExt$Extension = ndModule.getModExt$ExtensionList().iterator();
		while (itModExt$Extension.hasNext()) {

			// Appends child
			elModule.appendChild(ModExt$Extension.cmdSave(elModule, itModExt$Extension.next()));
		}

		// Iterates children
		Iterator<ModExt$Extension_System_ARMV7A> itModExt$Extension_System_ARMV7A = ndModule.getModExt$Extension_System_ARMV7AList().iterator();
		while (itModExt$Extension_System_ARMV7A.hasNext()) {

			// Appends child
			elModule.appendChild(ModExt$Extension_System_ARMV7A.cmdSave(elModule, itModExt$Extension_System_ARMV7A.next()));
		}

		// Iterates children
		Iterator<ModExt$Extension_Module_ARMV7A> itModExt$Extension_Module_ARMV7A = ndModule.getModExt$Extension_Module_ARMV7AList().iterator();
		while (itModExt$Extension_Module_ARMV7A.hasNext()) {

			// Appends child
			elModule.appendChild(ModExt$Extension_Module_ARMV7A.cmdSave(elModule, itModExt$Extension_Module_ARMV7A.next()));
		}

		// Iterates children
		Iterator<ModExt$Extension_Module_ARMV7A_AM335X> itModExt$Extension_Module_ARMV7A_AM335X = ndModule.getModExt$Extension_Module_ARMV7A_AM335XList().iterator();
		while (itModExt$Extension_Module_ARMV7A_AM335X.hasNext()) {

			// Appends child
			elModule.appendChild(ModExt$Extension_Module_ARMV7A_AM335X.cmdSave(elModule, itModExt$Extension_Module_ARMV7A_AM335X.next()));
		}

		// Iterates children
		Iterator<ModExt$Extension_Module_ARMV7A_Z7000> itModExt$Extension_Module_ARMV7A_Z7000 = ndModule.getModExt$Extension_Module_ARMV7A_Z7000List().iterator();
		while (itModExt$Extension_Module_ARMV7A_Z7000.hasNext()) {

			// Appends child
			elModule.appendChild(ModExt$Extension_Module_ARMV7A_Z7000.cmdSave(elModule, itModExt$Extension_Module_ARMV7A_Z7000.next()));
		}

		// Returns element
		return elModule;
	}

	/**
	 * Document saving method.
	 * 
	 * @param ndModule
	 *            ARINC_653_Module.
	 */
	public static Document cmdSaveDocument(Module ndModule) throws ConfigurationException {

		// Document
		Document dcDocument = null;
		try {

			// Creates document builder factory
			DocumentBuilderFactory fcDocumentBuilderFactory = DocumentBuilderFactory.newInstance();

			// Creates document builder
			DocumentBuilder dbDocumentBuilder = fcDocumentBuilderFactory.newDocumentBuilder();

			// Creates document
			dcDocument = dbDocumentBuilder.newDocument();

			// Sets as standalone
			dcDocument.setXmlStandalone(true);
		} catch (Throwable t) {

			// Throws exception
			throw new ConfigurationException("Error while creating document", t);
		}

		// Creates root element
		Element elModule = dcDocument.createElement(Module.NODENAME_MODULE);

		// Appends child
		dcDocument.appendChild(Module.cmdSave(elModule, ndModule));

		// Returns document
		return dcDocument;
	}

	/**
	 * String saving method.
	 * 
	 * @param ndModule
	 *            ARINC_653_Module.
	 */
	public static String cmdSaveString(Module ndModule) throws ConfigurationException {
		try {

			// Saves document
			Document dcDocument = Module.cmdSaveDocument(ndModule);

			// Creates transformer
			Transformer trTransformer = TransformerFactory.newInstance().newTransformer();

			// Sets indentation
			trTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

			// Creates stream result
			StreamResult srStreamResult = new StreamResult(new StringWriter());

			// Creates source
			DOMSource srSource = new DOMSource(dcDocument);

			// Transforms
			trTransformer.transform(srSource, srStreamResult);

			// Returns
			return srStreamResult.getWriter().toString();
		} catch (ConfigurationException e) {

			// Throws exception
			throw e;
		} catch (Throwable t) {

			// Throws exception
			throw new ConfigurationException("Error while saving string", t);
		}
	}

	/**
	 * File saving method.
	 * 
	 * @param ndModule
	 *            ARINC_653_Module.
	 * @param flFile
	 *            File.
	 */
	public static void cmdSaveFile(Module ndModule, File flFile) throws ConfigurationException {
		try {

			// Saves string
			String stString = cmdSaveString(ndModule);

			// Verifies string
			if (stString == null) {
				throw new ConfigurationException("Invalid string saved");
			}

			// Opens writer
			PrintWriter pwPrintWriter = new PrintWriter(flFile, "UTF-8");
			try {

				// Writes
				pwPrintWriter.write(stString);
			} finally {

				// Closes writer
				pwPrintWriter.close();
			}
		} catch (ConfigurationException e) {

			// Throws exception
			throw e;
		} catch (Throwable t) {

			// Throws exception
			throw new ConfigurationException("Error while saving file", t);
		}
	}

	/**
	 * Constructor.
	 * 
	 * @param stModuleName
	 *            ModuleName.
	 * @param stModuleVersion
	 *            ModuleVersion.
	 * @param idModuleId
	 *            ModuleId.
	 */
	public static Module newInstance(String stModuleName, String stModuleVersion, Identifier idModuleId) throws ConfigurationException {

		// Returns
		return new Module(stModuleName, stModuleVersion, idModuleId);
	}
}
