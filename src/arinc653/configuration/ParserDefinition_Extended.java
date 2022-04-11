package arinc653.configuration;

import java.util.Iterator;

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
 * Class that holds the extended parser definition.
 * 
 * @author Luís Fernando Arcaro
 */
public class ParserDefinition_Extended {

	/**
	 * Queuing discipline enumeration.
	 */
	public static AttributeType_ENUMERATION atAttributeType_ENUMERATION_QueuingDiscipline = new AttributeType_ENUMERATION("QueuingDiscipline", new String[] { "FIFO", "PRIORITY" });

	/**
	 * System action enumeration.
	 */
	public static AttributeType_ENUMERATION atAttributeType_ENUMERATION_SystemAction = new AttributeType_ENUMERATION("SystemAction", new String[] { "SHUTDOWN", "RESET" });

	/**
	 * Deadline enumeration.
	 */
	public static AttributeType_ENUMERATION atAttributeType_ENUMERATION_Deadline = new AttributeType_ENUMERATION("Deadline", new String[] { "SOFT", "HARD" });

	/**
	 * Prepare module node method.
	 */
	@SuppressWarnings("unused")
	public static Node cmdPrepareModuleNode() {

		// Prepares module node
		Node ndModule = ParserDefinition_Basic.cmdPrepareModuleNode();

		// Iterates all nodes
		Iterator<Node> itNode = ndModule.getRecursiveNodeList().iterator();
		while (itNode.hasNext()) {

			// Gets next node
			Node ndNode = itNode.next();

			// Ignores no nodes
			ndNode.setIgnoredNodePattern(null);
		}

		// System health monitoring table node
		Node ndSystemHMTable = ndModule.getNode("System_HM_Table");
		{
			Node ndSysHMExt$Extension = new Node(ndSystemHMTable, "SysHM_Ext:Extension", "SysHMExt$Extension");
			{
				Attribute atDisableHealthMonitoring = new Attribute(ndSysHMExt$Extension, "DisableHealthMonitoring", "DisableHealthMonitoring", AttributeType_BOOLEAN.INSTANCE);
				atDisableHealthMonitoring.setRequired(false);
			}
			{
				Node ndErrorIDAction = new Node(ndSysHMExt$Extension, "SysHM_Ext:Error_ID_Action", "SystemHMTable_SysHMExt$Extension_SysHMExt$ErrorIDAction");
				ndErrorIDAction.setIdentificationAttribute("ErrorIdentifier");
				{
					Attribute atErrorIdentifier = new Attribute(ndErrorIDAction, "ErrorIdentifier", "ErrorIdentifier", AttributeType_IDENTIFIER.INSTANCE);
					Attribute atDescription = new Attribute(ndErrorIDAction, "Description", "Description");
					atDescription.setRequired(false);
					Attribute atAction = new Attribute(ndErrorIDAction, "Action", "Action", atAttributeType_ENUMERATION_SystemAction);
				}
			}
		}

		// Module health monitoring table node
		Node ndModuleHMTable = ndModule.getNode("Module_HM_Table");
		{
			Node ndModHMExt$Extension = new Node(ndModuleHMTable, "Mod_HM_Ext:Extension", "ModHMExt$Extension");
			{
				Attribute atModuleCallbackStackSize = new Attribute(ndModHMExt$Extension, "ModuleCallbackStackSize", "ModuleCallbackStackSize", AttributeType_DECORHEXLONG.INSTANCE);
				atModuleCallbackStackSize.setRequired(false);
			}
		}

		// Partition node
		Node ndPartition = ndModule.getNode("Partition");
		{
			Node ndPartitionExt$Extension = new Node(ndPartition, "PartitionExt:Extension", "PartitionExt$Extension");
			{
				Attribute atStackSize = new Attribute(ndPartitionExt$Extension, "StackSize", "StackSize", AttributeType_DECORHEXLONG.INSTANCE);
				atStackSize.setRequired(false);
				Attribute atErrorHandler = new Attribute(ndPartitionExt$Extension, "ErrorHandler", "ErrorHandler");
				atErrorHandler.setRequired(false);
				Attribute atErrorHandlerStackSize = new Attribute(ndPartitionExt$Extension, "ErrorHandlerStackSize", "ErrorHandlerStackSize", AttributeType_DECORHEXLONG.INSTANCE);
				atErrorHandlerStackSize.setRequired(false);
				Attribute atSuppressPartitionIdleProcessMainLoop = new Attribute(ndPartitionExt$Extension, "SuppressPartitionIdleProcessMainLoop", "SuppressPartitionIdleProcessMainLoop", AttributeType_BOOLEAN.INSTANCE);
				atSuppressPartitionIdleProcessMainLoop.setRequired(false);
				Attribute atSuppressErrorHandlerStopCall = new Attribute(ndPartitionExt$Extension, "SuppressErrorHandlerStopCall", "SuppressErrorHandlerStopCall", AttributeType_BOOLEAN.INSTANCE);
				atSuppressErrorHandlerStopCall.setRequired(false);
				Attribute atMaximumErrorStatusCount = new Attribute(ndPartitionExt$Extension, "MaximumErrorStatusCount", "MaximumErrorStatusCount", AttributeType_INTEGER.INSTANCE);
				atMaximumErrorStatusCount.setRequired(false);
				Attribute atMaximumBufferCount = new Attribute(ndPartitionExt$Extension, "MaximumBufferCount", "MaximumBufferCount", AttributeType_INTEGER.INSTANCE);
				atMaximumBufferCount.setRequired(false);
				Attribute atMaximumBlackboardCount = new Attribute(ndPartitionExt$Extension, "MaximumBlackboardCount", "MaximumBlackboardCount", AttributeType_INTEGER.INSTANCE);
				atMaximumBlackboardCount.setRequired(false);
				Attribute atMaximumSemaphoreCount = new Attribute(ndPartitionExt$Extension, "MaximumSemaphoreCount", "MaximumSemaphoreCount", AttributeType_INTEGER.INSTANCE);
				atMaximumSemaphoreCount.setRequired(false);
				Attribute atMaximumEventCount = new Attribute(ndPartitionExt$Extension, "MaximumEventCount", "MaximumEventCount", AttributeType_INTEGER.INSTANCE);
				atMaximumEventCount.setRequired(false);
				Attribute atPredefinedSystemPartition = new Attribute(ndPartitionExt$Extension, "PredefinedSystemPartition", "PredefinedSystemPartition", AttributeType_BOOLEAN.INSTANCE);
				atPredefinedSystemPartition.setRequired(false);
			}
		}
		{

			// Sampling port node
			Node ndSamplingPort = ndPartition.getNode("Sampling_Port");
			{
				Node ndPortExt$Extension = new Node(ndSamplingPort, "PortExt:Extension", "SamplingPort_PortExt$Extension");
				{
					Attribute atQueuingDiscipline = new Attribute(ndPortExt$Extension, "QueuingDiscipline", "QueuingDiscipline", atAttributeType_ENUMERATION_QueuingDiscipline);
					atQueuingDiscipline.setRequired(false);
				}
			}

			// Queuing port node
			Node ndQueuingPort = ndPartition.getNode("Queuing_Port");
			{
				Node ndPortExt$Extension = new Node(ndQueuingPort, "PortExt:Extension", "QueuingPort_PortExt$Extension");
				{
					Attribute atQueuingDiscipline = new Attribute(ndPortExt$Extension, "QueuingDiscipline", "QueuingDiscipline", atAttributeType_ENUMERATION_QueuingDiscipline);
					atQueuingDiscipline.setRequired(false);
				}
			}
		}

		// Process node
		Node ndProcess = ndModule.getNode("Partition").getNode("Process");
		{
			Node ndProcExt$Extension = new Node(ndProcess, "Proc_Ext:Extension", "ProcExt$Extension");
			{
				Attribute atEntryPoint = new Attribute(ndProcExt$Extension, "EntryPoint", "EntryPoint");
				atEntryPoint.setRequired(false);
				Attribute atBasePriority = new Attribute(ndProcExt$Extension, "BasePriority", "BasePriority", AttributeType_INTEGER.INSTANCE);
				Attribute atPeriodSeconds = new Attribute(ndProcExt$Extension, "PeriodSeconds", "PeriodSeconds", AttributeType_DECIMAL.INSTANCE);
				atPeriodSeconds.setRequired(false);
				Attribute atTimeCapacitySeconds = new Attribute(ndProcExt$Extension, "TimeCapacitySeconds", "TimeCapacitySeconds", AttributeType_DECIMAL.INSTANCE);
				atTimeCapacitySeconds.setRequired(false);
				Attribute atDeadline = new Attribute(ndProcExt$Extension, "Deadline", "Deadline", atAttributeType_ENUMERATION_Deadline);
				Attribute atStartDelay = new Attribute(ndProcExt$Extension, "StartDelay", "StartDelay", AttributeType_DECIMAL.INSTANCE);
				atStartDelay.setRequired(false);
				Attribute atSuspensionTimeSeconds = new Attribute(ndProcExt$Extension, "SuspensionTimeSeconds", "SuspensionTimeSeconds", AttributeType_DECIMAL.INSTANCE);
				atSuspensionTimeSeconds.setRequired(false);
				Attribute atSuppressStart = new Attribute(ndProcExt$Extension, "SuppressStart", "SuppressStart", AttributeType_BOOLEAN.INSTANCE);
				atSuppressStart.setRequired(false);
				Attribute atSuppressMainLoop = new Attribute(ndProcExt$Extension, "SuppressMainLoop", "SuppressMainLoop", AttributeType_BOOLEAN.INSTANCE);
				atSuppressMainLoop.setRequired(false);
				Attribute atSuppressSuspension = new Attribute(ndProcExt$Extension, "SuppressSuspension", "SuppressSuspension", AttributeType_BOOLEAN.INSTANCE);
				atSuppressSuspension.setRequired(false);
			}
		}

		// Partition health monitoring table node
		Node ndPartitionHMTable = ndModule.getNode("Partition_HM_Table");
		{
			Node ndPartHMExt$Extension = new Node(ndPartitionHMTable, "Part_HM_Ext:Extension", "PartHMExt$Extension");
			{
				Attribute atPartitionCallbackStackSize = new Attribute(ndPartHMExt$Extension, "PartitionCallbackStackSize", "PartitionCallbackStackSize", AttributeType_DECORHEXLONG.INSTANCE);
				atPartitionCallbackStackSize.setRequired(false);
			}
		}

		// Module extended information node
		{
			Node ndModExt$Extension = new Node(ndModule, "ModExt:Extension", "ModExt$Extension");
			{
				Attribute atDefaultStackSize = new Attribute(ndModExt$Extension, "DefaultStackSize", "DefaultStackSize", AttributeType_DECORHEXLONG.INSTANCE);
				Attribute atSuppressModuleIdlePartitionMainLoop = new Attribute(ndModExt$Extension, "SuppressModuleIdlePartitionMainLoop", "SuppressModuleIdlePartitionMainLoop", AttributeType_BOOLEAN.INSTANCE);
				atSuppressModuleIdlePartitionMainLoop.setRequired(false);
			}
			Node ndModExt$Extension_System_ARMV7A = new Node(ndModule, "ModExt:Extension_System_ARMV7A", "ModExt$Extension_System_ARMV7A");
			{
				Attribute atSystemRAMMemoryPhysicalAddress = new Attribute(ndModExt$Extension_System_ARMV7A, "SystemRAMMemoryPhysicalAddress", "SystemRAMMemoryPhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
				Attribute atSystemRAMMemorySizeBytes = new Attribute(ndModExt$Extension_System_ARMV7A, "SystemRAMMemorySizeBytes", "SystemRAMMemorySizeBytes", AttributeType_DECORHEXLONG.INSTANCE);

				Attribute atSystemBootRegionPhysicalAddress = new Attribute(ndModExt$Extension_System_ARMV7A, "SystemBootRegionPhysicalAddress", "SystemBootRegionPhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
				atSystemBootRegionPhysicalAddress.setRequired(false);
				Attribute atSystemBootRegionSizeBytes = new Attribute(ndModExt$Extension_System_ARMV7A, "SystemBootRegionSizeBytes", "SystemBootRegionSizeBytes", AttributeType_DECORHEXLONG.INSTANCE);

				Attribute atSystemCodeRegionPhysicalAddress = new Attribute(ndModExt$Extension_System_ARMV7A, "SystemCodeRegionPhysicalAddress", "SystemCodeRegionPhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
				atSystemCodeRegionPhysicalAddress.setRequired(false);
				Attribute atSystemCodeRegionSizeBytes = new Attribute(ndModExt$Extension_System_ARMV7A, "SystemCodeRegionSizeBytes", "SystemCodeRegionSizeBytes", AttributeType_DECORHEXLONG.INSTANCE);

				Attribute atSystemDataRegionPhysicalAddress = new Attribute(ndModExt$Extension_System_ARMV7A, "SystemDataRegionPhysicalAddress", "SystemDataRegionPhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
				atSystemDataRegionPhysicalAddress.setRequired(false);
				Attribute atSystemDataRegionSizeBytes = new Attribute(ndModExt$Extension_System_ARMV7A, "SystemDataRegionSizeBytes", "SystemDataRegionSizeBytes", AttributeType_DECORHEXLONG.INSTANCE);
			}
			Node ndModExt$Extension_Module_ARMV7A = new Node(ndModule, "ModExt:Extension_Module_ARMV7A", "ModExt$Extension_Module_ARMV7A");
			{
				Attribute atModuleStackRegionPhysicalAddress = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleStackRegionPhysicalAddress", "ModuleStackRegionPhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
				atModuleStackRegionPhysicalAddress.setRequired(false);
				Attribute atModuleStackRegionSizeBytes = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleStackRegionSizeBytes", "ModuleStackRegionSizeBytes", AttributeType_DECORHEXLONG.INSTANCE);

				Attribute atModuleCodeRegionPhysicalAddress = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleCodeRegionPhysicalAddress", "ModuleCodeRegionPhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
				atModuleCodeRegionPhysicalAddress.setRequired(false);
				Attribute atModuleCodeRegionSizeBytes = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleCodeRegionSizeBytes", "ModuleCodeRegionSizeBytes", AttributeType_DECORHEXLONG.INSTANCE);

				Attribute atModuleDataRegionPhysicalAddress = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleDataRegionPhysicalAddress", "ModuleDataRegionPhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
				atModuleDataRegionPhysicalAddress.setRequired(false);
				Attribute atModuleDataRegionSizeBytes = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleDataRegionSizeBytes", "ModuleDataRegionSizeBytes", AttributeType_DECORHEXLONG.INSTANCE);

				Attribute atModuleHeapRegionPhysicalAddress = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleHeapRegionPhysicalAddress", "ModuleHeapRegionPhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
				atModuleHeapRegionPhysicalAddress.setRequired(false);
				Attribute atModuleHeapRegionSizeBytes = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleHeapRegionSizeBytes", "ModuleHeapRegionSizeBytes", AttributeType_DECORHEXLONG.INSTANCE);

				Attribute atModuleFLTranslationTableRegionPhysicalAddress = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleFLTranslationTableRegionPhysicalAddress", "ModuleFLTranslationTableRegionPhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
				atModuleFLTranslationTableRegionPhysicalAddress.setRequired(false);
				Attribute atModuleFLTranslationTableRegionSizeBytes = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleFLTranslationTableRegionSizeBytes", "ModuleFLTranslationTableRegionSizeBytes", AttributeType_DECORHEXLONG.INSTANCE);

				Attribute atModuleSLTranslationTableRegionPhysicalAddress = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleSLTranslationTableRegionPhysicalAddress", "ModuleSLTranslationTableRegionPhysicalAddress", AttributeType_DECORHEXLONG.INSTANCE);
				atModuleSLTranslationTableRegionPhysicalAddress.setRequired(false);
				Attribute atModuleSLTranslationTableRegionSizeBytes = new Attribute(ndModExt$Extension_Module_ARMV7A, "ModuleSLTranslationTableRegionSizeBytes", "ModuleSLTranslationTableRegionSizeBytes", AttributeType_DECORHEXLONG.INSTANCE);
			}
			Node ndModExt$Extension_Module_ARMV7A_AM335X = new Node(ndModule, "ModExt:Extension_Module_ARMV7A_AM335X", "ModExt$Extension_Module_ARMV7A_AM335X");
			{
				Attribute atModuleNetworkPhysicalAddress = new Attribute(ndModExt$Extension_Module_ARMV7A_AM335X, "ModuleNetworkPhysicalAddress", "ModuleNetworkPhysicalAddress", AttributeType_DECORHEXSTRING.INSTANCE);
			}
			Node ndModExt$Extension_Module_ARMV7A_Z7000 = new Node(ndModule, "ModExt:Extension_Module_ARMV7A_Z7000", "ModExt$Extension_Module_ARMV7A_Z7000");
			{
				// No attributes yet
			}
		}
		return ndModule;
	}
}