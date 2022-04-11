package arinc653.configuration;

import java.io.File;
import java.util.regex.Pattern;

import arinc653.configuration.parsergenerator.Attribute;
import arinc653.configuration.parsergenerator.AttributeType_BOOLEAN;
import arinc653.configuration.parsergenerator.AttributeType_DECIMAL;
import arinc653.configuration.parsergenerator.AttributeType_DECORHEXLONG;
import arinc653.configuration.parsergenerator.AttributeType_DECORHEXSTRING;
import arinc653.configuration.parsergenerator.AttributeType_ENUMERATION;
import arinc653.configuration.parsergenerator.AttributeType_IDENTIFIER;
import arinc653.configuration.parsergenerator.AttributeType_INTEGER;
import arinc653.configuration.parsergenerator.Node;

/**
 * Class that holds the basic parser definition.
 * 
 * @author Luís Fernando Arcaro
 */
public class ParserDefinition_Basic {

	/**
	 * Directory.
	 */
	public static File flDirectory = new File("src/arinc653/configuration/parser");

	/**
	 * Package.
	 */
	public static String stPackage = "arinc653.configuration.parser";

	/**
	 * Resources package.
	 */
	public static String stResourcesPackage = "arinc653.configuration.parserresources";

	/**
	 * Exception class.
	 */
	public static String stExceptionClass = "ConfigurationException";

	/**
	 * Error level enumeration.
	 */
	public static AttributeType_ENUMERATION atAttributeType_ENUMERATION_ErrorLevel = new AttributeType_ENUMERATION("ErrorLevel", new String[] { "MODULE", "PARTITION", "PROCESS" });

	/**
	 * Error code enumeration.
	 */
	public static AttributeType_ENUMERATION atAttributeType_ENUMERATION_ErrorCode = new AttributeType_ENUMERATION("ErrorCode", new String[] { "DEADLINE_MISSED", "APPLICATION_ERROR", "NUMERIC_ERROR", "ILLEGAL_REQUEST", "STACK_OVERFLOW", "MEMORY_VIOLATION", "HARDWARE_FAULT", "POWER_FAIL" });

	/**
	 * Module action enumeration.
	 */
	public static AttributeType_ENUMERATION atAttributeType_ENUMERATION_ModuleAction = new AttributeType_ENUMERATION("ModuleAction", new String[] { "IGNORE", "SHUTDOWN", "RESET" });

	/**
	 * Criticality enumeration.
	 */
	public static AttributeType_ENUMERATION atAttributeType_ENUMERATION_Criticality = new AttributeType_ENUMERATION("Criticality", new String[] { "LEVEL_A", "LEVEL_B", "LEVEL_C", "LEVEL_D", "LEVEL_E" });

	/**
	 * Direction enumeration.
	 */
	public static AttributeType_ENUMERATION atAttributeType_ENUMERATION_Direction = new AttributeType_ENUMERATION("Direction", new String[] { "SOURCE", "DESTINATION" });

	/**
	 * Partition action enumeration.
	 */
	public static AttributeType_ENUMERATION atAttributeType_ENUMERATION_PartitionAction = new AttributeType_ENUMERATION("PartitionAction", new String[] { "IGNORE", "IDLE", "WARM_START", "COLD_START" });

	/**
	 * Prepare module node method.
	 */
	@SuppressWarnings("unused")
	public static Node cmdPrepareModuleNode() {
		Node ndModule = new Node(null, "ARINC_653_Module", "Module");
		ndModule.setIgnoredNodePattern("^" + Pattern.quote("ModExt:") + ".+$");
		ndModule.setAllowOtherAttributes(true);
		{
			Attribute atModuleName = new Attribute(ndModule, "ModuleName", "ModuleName");
			atModuleName.setRequired(false);
			Attribute atModuleVersion = new Attribute(ndModule, "ModuleVersion", "ModuleVersion");
			atModuleVersion.setRequired(false);
			Attribute atModuleId = new Attribute(ndModule, "ModuleId", "ModuleId", AttributeType_IDENTIFIER.INSTANCE);
			atModuleId.setRequired(false);
		}
		{
			Node ndSystemHMTable = new Node(ndModule, "System_HM_Table", "SystemHMTable");
			ndSystemHMTable.setIgnoredNodePattern("^" + Pattern.quote("SysHM_Ext:") + ".+$");
			{
				Node ndSystemStateEntry = new Node(ndSystemHMTable, "System_State_Entry", "SystemHMTable_SystemStateEntry");
				ndSystemStateEntry.setIdentificationAttribute("SystemState");
				{
					Attribute atSystemState = new Attribute(ndSystemStateEntry, "SystemState", "SystemState", AttributeType_IDENTIFIER.INSTANCE);
					Attribute atDescription = new Attribute(ndSystemStateEntry, "Description", "Description");
					atDescription.setRequired(false);
				}
				{
					Node ndErrorIDLevel = new Node(ndSystemStateEntry, "Error_ID_Level", "ErrorIDLevel");
					ndErrorIDLevel.setIdentificationAttribute("ErrorIdentifier");
					{
						Attribute atErrorIdentifier = new Attribute(ndErrorIDLevel, "ErrorIdentifier", "ErrorIdentifier", AttributeType_IDENTIFIER.INSTANCE);
						Attribute atDescription = new Attribute(ndErrorIDLevel, "Description", "Description");
						atDescription.setRequired(false);
						Attribute atErrorLevel = new Attribute(ndErrorIDLevel, "ErrorLevel", "ErrorLevel", atAttributeType_ENUMERATION_ErrorLevel);
						Attribute atErrorCode = new Attribute(ndErrorIDLevel, "ErrorCode", "ErrorCode", atAttributeType_ENUMERATION_ErrorCode);
						atErrorCode.setRequired(false);
					}
				}
			}
		}
		{
			Node ndModuleHMTable = new Node(ndModule, "Module_HM_Table", "ModuleHMTable");
			ndModuleHMTable.setIgnoredNodePattern("^" + Pattern.quote("Mod_HM_Ext:") + ".+$");
			{
				Attribute atModuleCallback = new Attribute(ndModuleHMTable, "ModuleCallback", "ModuleCallback");
				atModuleCallback.setRequired(false);
			}
			{
				Node ndSystemStateEntry = new Node(ndModuleHMTable, "System_State_Entry", "ModuleHMTable_SystemStateEntry");
				ndSystemStateEntry.setIdentificationAttribute("SystemState");
				{
					Attribute atSystemState = new Attribute(ndSystemStateEntry, "SystemState", "SystemState", AttributeType_IDENTIFIER.INSTANCE);
					Attribute atDescription = new Attribute(ndSystemStateEntry, "Description", "Description");
					atDescription.setRequired(false);
				}
				{
					Node ndErrorIDAction = new Node(ndSystemStateEntry, "Error_ID_Action", "ModuleHMTable_SystemStateEntry_ErrorIDAction");
					ndErrorIDAction.setIdentificationAttribute("ErrorIdentifier");
					{
						Attribute atErrorIdentifier = new Attribute(ndErrorIDAction, "ErrorIdentifier", "ErrorIdentifier", AttributeType_IDENTIFIER.INSTANCE);
						Attribute atDescription = new Attribute(ndErrorIDAction, "Description", "Description");
						atDescription.setRequired(false);
						Attribute atAction = new Attribute(ndErrorIDAction, "Action", "Action", atAttributeType_ENUMERATION_ModuleAction);
					}
				}
			}
		}
		{
			Node ndPartition = new Node(ndModule, "Partition", "Partition");
			ndPartition.setIdentificationAttribute("PartitionIdentifier");
			ndPartition.setIgnoredNodePattern("^" + Pattern.quote("PartitionExt:") + ".+$");
			{
				Attribute atPartitionIdentifier = new Attribute(ndPartition, "PartitionIdentifier", "PartitionIdentifier", AttributeType_IDENTIFIER.INSTANCE);
				Attribute atPartitionName = new Attribute(ndPartition, "PartitionName", "PartitionName");
				atPartitionName.setRequired(false);
				Attribute atCriticality = new Attribute(ndPartition, "Criticality", "Criticality", atAttributeType_ENUMERATION_Criticality);
				atCriticality.setRequired(false);
				// atCriticality.setDefaultValue("Criticality.LEVEL_A");
				Attribute atSystemPartition = new Attribute(ndPartition, "SystemPartition", "SystemPartition", AttributeType_BOOLEAN.INSTANCE);
				atSystemPartition.setRequired(false);
				atSystemPartition.setDefaultValue("false");
				Attribute atEntryPoint = new Attribute(ndPartition, "EntryPoint", "EntryPoint");
			}
			{
				Node ndSamplingPort = new Node(ndPartition, "Sampling_Port", "SamplingPort");
				ndSamplingPort.setIdentificationAttribute("Name");
				ndSamplingPort.setIgnoredNodePattern("^" + Pattern.quote("PortExt:") + ".+$");
				{
					Attribute atName = new Attribute(ndSamplingPort, "Name", "Name");
					Attribute atMaxMessageSize = new Attribute(ndSamplingPort, "MaxMessageSize", "MaxMessageSize", AttributeType_DECORHEXLONG.INSTANCE);
					Attribute atDirection = new Attribute(ndSamplingPort, "Direction", "Direction", atAttributeType_ENUMERATION_Direction);
					Attribute atRefreshRateSeconds = new Attribute(ndSamplingPort, "RefreshRateSeconds", "RefreshRateSeconds", AttributeType_DECIMAL.INSTANCE);
				}
				Node ndQueuingPort = new Node(ndPartition, "Queuing_Port", "QueuingPort");
				ndQueuingPort.setIdentificationAttribute("Name");
				ndQueuingPort.setIgnoredNodePattern("^" + Pattern.quote("PortExt:") + ".+$");
				{
					Attribute atName = new Attribute(ndQueuingPort, "Name", "Name");
					Attribute atMaxMessageSize = new Attribute(ndQueuingPort, "MaxMessageSize", "MaxMessageSize", AttributeType_DECORHEXLONG.INSTANCE);
					Attribute atDirection = new Attribute(ndQueuingPort, "Direction", "Direction", atAttributeType_ENUMERATION_Direction);
					Attribute atMaxNbMessages = new Attribute(ndQueuingPort, "MaxNbMessages", "MaxNbMessages", AttributeType_INTEGER.INSTANCE);
				}
				Node ndProcess = new Node(ndPartition, "Process", "Process");
				ndProcess.setIdentificationAttribute("Name");
				ndProcess.setIgnoredNodePattern("^" + Pattern.quote("Proc_Ext:") + ".+$");
				{
					Attribute atName = new Attribute(ndProcess, "Name", "Name");
					atName.setRequired(false);
					Attribute atStackSize = new Attribute(ndProcess, "StackSize", "StackSize", AttributeType_DECORHEXLONG.INSTANCE);
					atStackSize.setRequired(false);
				}
			}
		}
		{
			Node ndPartitionMemory = new Node(ndModule, "Partition_Memory", "PartitionMemory");
			ndPartitionMemory.setIdentificationAttribute("PartitionIdentifier");
			ndPartitionMemory.setIgnoredNodePattern("^" + Pattern.quote("Memory_Ext:") + ".+$");
			{
				Attribute atPartitionIdentifier = new Attribute(ndPartitionMemory, "PartitionIdentifier", "PartitionIdentifier", AttributeType_IDENTIFIER.INSTANCE);
				Attribute atPartitionName = new Attribute(ndPartitionMemory, "PartitionName", "PartitionName");
				atPartitionName.setRequired(false);
			}
			{
				Node ndMemoryRequirements = new Node(ndPartitionMemory, "Memory_Requirements", "MemoryRequirements");
				{
					Attribute atRegionName = new Attribute(ndMemoryRequirements, "RegionName", "RegionName");
					atRegionName.setRequired(false);
					Attribute atType = new Attribute(ndMemoryRequirements, "Type", "Type");
					Attribute atSizeBytes = new Attribute(ndMemoryRequirements, "SizeBytes", "SizeBytes", AttributeType_DECORHEXLONG.INSTANCE);
					Attribute atPhysicalAddress = new Attribute(ndMemoryRequirements, "PhysicalAddress", "PhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
					atPhysicalAddress.setRequired(false);
					Attribute atAccess = new Attribute(ndMemoryRequirements, "Access", "Access");
				}
			}
		}
		{
			Node ndModuleSchedule = new Node(ndModule, "Module_Schedule", "ModuleSchedule");
			ndModuleSchedule.setIgnoredNodePattern("^" + Pattern.quote("Part_Sched_Ext:") + ".+$");
			{
				Attribute atMajorFrameSeconds = new Attribute(ndModuleSchedule, "MajorFrameSeconds", "MajorFrameSeconds", AttributeType_DECIMAL.INSTANCE);
			}
			{
				Node ndPartitionSchedule = new Node(ndModuleSchedule, "Partition_Schedule", "PartitionSchedule");
				ndPartitionSchedule.setIdentificationAttribute("PartitionIdentifier");
				ndPartitionSchedule.setIgnoredNodePattern("^" + Pattern.quote("Window_Sched_Ext:") + ".+$");
				{
					Attribute atPartitionIdentifier = new Attribute(ndPartitionSchedule, "PartitionIdentifier", "PartitionIdentifier", AttributeType_IDENTIFIER.INSTANCE);
					Attribute atPartitionName = new Attribute(ndPartitionSchedule, "PartitionName", "PartitionName");
					atPartitionName.setRequired(false);
					Attribute atPeriodSeconds = new Attribute(ndPartitionSchedule, "PeriodSeconds", "PeriodSeconds", AttributeType_DECIMAL.INSTANCE);
					Attribute atPeriodDurationSeconds = new Attribute(ndPartitionSchedule, "PeriodDurationSeconds", "PeriodDurationSeconds", AttributeType_DECIMAL.INSTANCE);
				}
				{
					Node ndWindowSchedule = new Node(ndPartitionSchedule, "Window_Schedule", "WindowSchedule");
					{
						Attribute atWindowIdentifier = new Attribute(ndWindowSchedule, "WindowIdentifier", "WindowIdentifier", AttributeType_IDENTIFIER.INSTANCE);
						Attribute atWindowStartSeconds = new Attribute(ndWindowSchedule, "WindowStartSeconds", "WindowStartSeconds", AttributeType_DECIMAL.INSTANCE);
						Attribute atWindowDurationSeconds = new Attribute(ndWindowSchedule, "WindowDurationSeconds", "WindowDurationSeconds", AttributeType_DECIMAL.INSTANCE);
						Attribute atPartitionPeriodStart = new Attribute(ndWindowSchedule, "PartitionPeriodStart", "PartitionPeriodStart", AttributeType_BOOLEAN.INSTANCE);
						atPartitionPeriodStart.setRequired(false);
						atPartitionPeriodStart.setDefaultValue("false");
					}
				}
			}
		}
		{
			Node ndPartitionHMTable = new Node(ndModule, "Partition_HM_Table", "PartitionHMTable");
			ndPartitionHMTable.setIgnoredNodePattern("^" + Pattern.quote("Part_HM_Ext:") + ".+$");
			ndPartitionHMTable.setIdentificationAttribute("PartitionIdentifier");
			{
				Attribute atPartitionIdentifier = new Attribute(ndPartitionHMTable, "PartitionIdentifier", "PartitionIdentifier", AttributeType_IDENTIFIER.INSTANCE);
				Attribute atPartitionName = new Attribute(ndPartitionHMTable, "PartitionName", "PartitionName");
				atPartitionName.setRequired(false);
				Attribute atPartitionCallback = new Attribute(ndPartitionHMTable, "PartitionCallback", "PartitionCallback");
				atPartitionCallback.setRequired(false);
			}
			{
				Node ndSystemStateEntry = new Node(ndPartitionHMTable, "System_State_Entry", "PartitionHMTable_SystemStateEntry");
				ndSystemStateEntry.setIdentificationAttribute("SystemState");
				{
					Attribute atSystemState = new Attribute(ndSystemStateEntry, "SystemState", "SystemState", AttributeType_IDENTIFIER.INSTANCE);
					Attribute atDescription = new Attribute(ndSystemStateEntry, "Description", "Description");
					atDescription.setRequired(false);
				}
				{
					Node ndErrorIDAction = new Node(ndSystemStateEntry, "Error_ID_Action", "PartitionHMTable_SystemStateEntry_ErrorIDAction");
					ndErrorIDAction.setIdentificationAttribute("ErrorIdentifier");
					ndErrorIDAction.setAllowOtherAttributes(true);
					{
						Attribute atErrorIdentifier = new Attribute(ndErrorIDAction, "ErrorIdentifier", "ErrorIdentifier", AttributeType_IDENTIFIER.INSTANCE);
						Attribute atDescription = new Attribute(ndErrorIDAction, "Description", "Description");
						atDescription.setRequired(false);
						Attribute atAction = new Attribute(ndErrorIDAction, "Action", "Action", atAttributeType_ENUMERATION_PartitionAction);
					}
				}
			}
		}
		{
			Node ndConnectionTable = new Node(ndModule, "Connection_Table", "ConnectionTable");
			{
				Node ndChannel = new Node(ndConnectionTable, "Channel", "Channel");
				{
					Attribute atChannelIdentifier = new Attribute(ndChannel, "ChannelIdentifier", "ChannelIdentifier", AttributeType_IDENTIFIER.INSTANCE);
					Attribute atChannelName = new Attribute(ndChannel, "ChannelName", "ChannelName");
					atChannelName.setRequired(false);
				}
				{
					Node ndSource = new Node(ndChannel, "Source", "Source");
					{
						Node ndPseudoPartition = new Node(ndSource, "Pseudo_Partition", "Source_PseudoPartition");
						{
							Attribute atName = new Attribute(ndPseudoPartition, "Name", "Name");
							atName.setRequired(false);
							Attribute atPhysicalAddress = new Attribute(ndPseudoPartition, "PhysicalAddress", "PhysicalAddress", AttributeType_DECORHEXSTRING.INSTANCE);
							atPhysicalAddress.setRequired(false);
							Attribute atProcedure = new Attribute(ndPseudoPartition, "Procedure", "Procedure");
							atProcedure.setRequired(false);
						}
						Node ndStandardPartition = new Node(ndSource, "Standard_Partition", "Source_StandardPartition");
						{
							Attribute atPartitionIdentifier = new Attribute(ndStandardPartition, "PartitionIdentifier", "PartitionIdentifier", AttributeType_IDENTIFIER.INSTANCE);
							Attribute atPartitionName = new Attribute(ndStandardPartition, "PartitionName", "PartitionName");
							atPartitionName.setRequired(false);
							Attribute atPortName = new Attribute(ndStandardPartition, "PortName", "PortName");
							Attribute atPhysicalAddress = new Attribute(ndStandardPartition, "PhysicalAddress", "PhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
							atPhysicalAddress.setRequired(false);
						}
					}
					Node ndDestination = new Node(ndChannel, "Destination", "Destination");
					{
						Node ndPseudoPartition = new Node(ndDestination, "Pseudo_Partition", "Destination_PseudoPartition");
						{
							Attribute atName = new Attribute(ndPseudoPartition, "Name", "Name");
							atName.setRequired(false);
							Attribute atPhysicalAddress = new Attribute(ndPseudoPartition, "PhysicalAddress", "PhysicalAddress", AttributeType_DECORHEXSTRING.INSTANCE);
							atPhysicalAddress.setRequired(false);
							Attribute atProcedure = new Attribute(ndPseudoPartition, "Procedure", "Procedure");
							atProcedure.setRequired(false);
						}
						Node ndStandardPartition = new Node(ndDestination, "Standard_Partition", "Destination_StandardPartition");
						{
							Attribute atPartitionIdentifier = new Attribute(ndStandardPartition, "PartitionIdentifier", "PartitionIdentifier", AttributeType_IDENTIFIER.INSTANCE);
							Attribute atPartitionName = new Attribute(ndStandardPartition, "PartitionName", "PartitionName");
							atPartitionName.setRequired(false);
							Attribute atPortName = new Attribute(ndStandardPartition, "PortName", "PortName");
							Attribute atPhysicalAddress = new Attribute(ndStandardPartition, "PhysicalAddress", "PhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
							atPhysicalAddress.setRequired(false);
						}
					}
				}
			}
		}
		return ndModule;
	}
}