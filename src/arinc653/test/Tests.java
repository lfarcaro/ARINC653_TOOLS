package arinc653.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import arinc653.configuration.tools.TargetPlatform;
import arinc653.configuration.tools.schedulegenerator.ScheduleGenerator;
import arinc653.configuration.tools.templategenerator.TemplateGenerator;
import arinc653.templatemanager.Artifact;
import arinc653.templatemanager.Language_C;
import arinc653.templatemanager.Language_XML;
import arinc653.templatemanager.Mask;

/**
 * Tests.
 * 
 * @author Luís Fernando Arcaro
 */
public class Tests {

	/**
	 * ARMV7A AM335X serial port name.
	 */
	public static final String stARMV7A_AM335X_SerialPort = "COM8";

	/**
	 * ARINC653 directory.
	 */
	public static final File flARINC653Directory = new File("D:\\CCSWorkspace\\ARINC653_AM335X");

	/*
	 * Tests' directories.
	 */
	public static File flTestDirectory = new File("Test");
	public static File flScenarioDirectory = new File(flTestDirectory, "Scenario");
	public static File flTemplateDirectory = new File(flTestDirectory, "Template");
	public static File flOutputDirectory = new File(flTestDirectory, "Output");
	public static File flModule = new File(flScenarioDirectory, "Module.xml");
	public static File flSpecialTestDirectory_ARMV7A_AM335X = new File("Test_ARMV7A_AM335X");
	public static File flSpecialTestDirectory_ARMV7A_Z7000 = new File("Test_ARMV7A_Z7000");

	/**
	 * Scenario.
	 * 
	 * @author Luís Fernando Arcaro
	 */
	public static class Scenario {

		/**
		 * System HM table.
		 */
		private String stSystem_HM_Table;

		/**
		 * Module HM table.
		 */
		private String stModule_HM_Table;

		/**
		 * Partition.
		 */
		private String stPartition;

		/**
		 * Partition memory.
		 */
		private String stPartition_Memory;

		/**
		 * Module schedule.
		 */
		private String stModule_Schedule;

		/**
		 * Partition HM table.
		 */
		private String stPartition_HM_Table;

		/**
		 * Connection table.
		 */
		private String stConnection_Table;

		/**
		 * Module extended information.
		 */
		private String stModExt;

		/**
		 * Compatible target platform set.
		 */
		private Set<TargetPlatform> stCompatibleTargetPlatform = null;

		/**
		 * Constructor.
		 */
		public Scenario(String stSystem_HM_Table, String stModule_HM_Table, String stPartition, String stPartition_Memory, String stModule_Schedule, String stPartition_HM_Table, String stConnection_Table, String stModExt, TargetPlatform[] tpCompatibleTargetPlatform) {
			this.stSystem_HM_Table = stSystem_HM_Table;
			this.stModule_HM_Table = stModule_HM_Table;
			this.stPartition = stPartition;
			this.stPartition_Memory = stPartition_Memory;
			this.stModule_Schedule = stModule_Schedule;
			this.stPartition_HM_Table = stPartition_HM_Table;
			this.stConnection_Table = stConnection_Table;
			this.stModExt = stModExt;
			if (tpCompatibleTargetPlatform != null) {
				this.stCompatibleTargetPlatform = new HashSet<TargetPlatform>(Arrays.asList(tpCompatibleTargetPlatform));
			}
		}

		/**
		 * Constructor.
		 */
		public Scenario(String stSystem_HM_Table, String stModule_HM_Table, String stPartition, String stPartition_Memory, String stModule_Schedule, String stPartition_HM_Table, String stConnection_Table, String stModExt) {
			this(stSystem_HM_Table, stModule_HM_Table, stPartition, stPartition_Memory, stModule_Schedule, stPartition_HM_Table, stConnection_Table, stModExt, null);
		}

		/**
		 * System HM table getter.
		 */
		public String getSystem_HM_Table() {
			return stSystem_HM_Table;
		}

		/**
		 * Module HM table getter.
		 */
		public String getModule_HM_Table() {
			return stModule_HM_Table;
		}

		/**
		 * Partition getter.
		 */
		public String getPartition() {
			return stPartition;
		}

		/**
		 * Partition memory getter.
		 */
		public String getPartition_Memory() {
			return stPartition_Memory;
		}

		/**
		 * Module schedule getter.
		 */
		public String getModule_Schedule() {
			return stModule_Schedule;
		}

		/**
		 * Partition HM table getter.
		 */
		public String getPartition_HM_Table() {
			return stPartition_HM_Table;
		}

		/**
		 * Connection table getter.
		 */
		public String getConnection_Table() {
			return stConnection_Table;
		}

		/**
		 * Module extended information getter.
		 */
		public String getModExt() {
			return stModExt;
		}

		/**
		 * Compatible target platform verifier.
		 */
		public boolean isCompatibleTargetPlatform(TargetPlatform tpTargetPlatform) {
			return (stCompatibleTargetPlatform != null ? (stCompatibleTargetPlatform.contains(tpTargetPlatform)) : true);
		}

		/**
		 * Identity getter.
		 */
		private String getIdentity() {
			return stSystem_HM_Table + stModule_HM_Table + stPartition + stPartition_Memory + stModule_Schedule + stPartition_HM_Table + stConnection_Table + stModExt;
		}

		@Override
		public int hashCode() {
			return getIdentity().hashCode();
		}

		@Override
		public boolean equals(Object obObject) {

			// Verifies object
			if (!(obObject instanceof Scenario)) {
				return false;
			}

			// Casts object
			Scenario scScenario = (Scenario) obObject;

			// Compares identities
			return scScenario.getIdentity().equals(getIdentity());
		}
	}

	/**
	 * Test scenario map.
	 */
	private static final Map<String, Scenario> mpTestScenario = new HashMap<String, Scenario>();
	static {

		// Fills test scenario map
		mpTestScenario.put("001_SLOWPARTITIONSCHEDULING", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_001", "Partition_Memory_001", "Module_Schedule_002", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("002_FASTPARTITIONSCHEDULING", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_001", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("003_SLOWPROCESSSCHEDULING", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_015", "Partition_Memory_001", "Module_Schedule_002", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("004_FASTPROCESSSCHEDULING", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("005_TESTCOUNTERCALIBRATION", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_023", "Partition_Memory_001", "Module_Schedule_002", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("006_RETURNPOINT", new Scenario("System_HM_Table_002", "Module_HM_Table_001", "Partition_006", "Partition_Memory_001", "Module_Schedule_002", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_002"));
		mpTestScenario.put("007_SYSTEMPARTITION", new Scenario("System_HM_Table_003", "Module_HM_Table_002", "Partition_024", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_002", "Connection_Table_001", "ModExt_001"));

		mpTestScenario.put("101_SETMODULEMODE_IDLE", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("102_SETMODULEMODE_COLDSTART", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("103_GETPARTITIONID", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("104_GETPARTITIONSTATUS", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("105_SETPARTITIONMODE_IDLE_PROCESS", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("106_SETPARTITIONMODE_IDLE_PARTITIONERRORHANDLER", new Scenario("System_HM_Table_002", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("107_SETPARTITIONMODE_IDLE_PARTITIONHMCALLBACK", new Scenario("System_HM_Table_002", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_002", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("108_SETPARTITIONMODE_COLDSTART_PROCESS", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("109_SETPARTITIONMODE_COLDSTART_PARTITIONERRORHANDLER", new Scenario("System_HM_Table_002", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("110_SETPARTITIONMODE_COLDSTART_PARTITIONHMCALLBACK", new Scenario("System_HM_Table_002", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_002", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("111_GETPROCESSID", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("112_GETPROCESSSTATUS", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("113_SETPRIORITY", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("114_SUSPEND_RESUME", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_014", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("115_SUSPENDSELF_RESUME", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_008", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("116_SUSPENDSELF_RESUME_TIMEOUT", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_003", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("117_TIMEDWAIT", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("118_TIMEDWAIT_SUSPEND_RESUME", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_003", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("119_TIMEDWAIT_COOPERATIVESCHEDULING", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_019", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("120_REPLENISH", new Scenario("System_HM_Table_002", "Module_HM_Table_001", "Partition_004", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("121_STOPSELF_START", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("122_STOPSELF_DELAYEDSTART", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("123_STOP_START", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("124_STOP_START_PERIODSTART", new Scenario("System_HM_Table_002", "Module_HM_Table_001", "Partition_009", "Partition_Memory_001", "Module_Schedule_004", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("125_STOP_DELAYEDSTART", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("126_DELAYEDSTART", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_002", "Partition_Memory_001", "Module_Schedule_003", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("127_LOCKPREEMPTION_UNLOCKPREEMPTION", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_017", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("128_LOCKPREEMPTION_STOPSELF_PROCESS", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("129_LOCKPREEMPTION_STOPSELF_PARTITIONERRORHANDLER", new Scenario("System_HM_Table_002", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("130_GETMYID", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));

		mpTestScenario.put("201_WAITRESOURCE_SIGNALRESOURCE", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_013", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("202_WAITRESOURCE_SETPRIORITY_SIGNALRESOURCE", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_013", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("203_WAITRESOURCE_SIGNALRESOURCE_TIMEOUT", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_013", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("204_WAITRESOURCE_SUSPEND_TIMEOUT_RESUME", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_016", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("205_WAITRESOURCE_SUSPEND_SIGNALRESOURCE_RESUME", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_007", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("206_WAITRESOURCE_SUSPEND_RESUME_SIGNALRESOURCE", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_007", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));

		mpTestScenario.put("301_EVENT", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_013", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("302_SEMAPHORE_FIFO", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_013", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("303_SEMAPHORE_PRIORITY", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_013", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("304_SEMAPHORE_DEADLOCK", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_020", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("305_BLACKBOARD", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("306_BUFFER", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_010", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("307_BUFFER_FIFO", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_005", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("308_BUFFER_PRIORITY", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_005", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("309_BUFFER_TIMEOUT_RECEIVE", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_005", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("310_BUFFER_TIMEOUT_SEND", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_011", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("311_BUFFER_FULL_EMPTY", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_012", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("312_SAMPLINGPORT_STANDARD", new Scenario("System_HM_Table_003", "Module_HM_Table_001", "Partition_021", "Partition_Memory_002", "Module_Schedule_005", "Partition_HM_Table_003", "Connection_Table_002", "ModExt_001"));
		mpTestScenario.put("313_SAMPLINGPORT_PSEUDO_MODULE1", new Scenario("System_HM_Table_003", "Module_HM_Table_001", "Partition_025", "Partition_Memory_002", "Module_Schedule_005", "Partition_HM_Table_003", "Connection_Table_004", "ModExt_001"));
		mpTestScenario.put("314_SAMPLINGPORT_PSEUDO_MODULE2", new Scenario("System_HM_Table_003", "Module_HM_Table_001", "Partition_025", "Partition_Memory_002", "Module_Schedule_005", "Partition_HM_Table_003", "Connection_Table_005", "ModExt_003"));
		mpTestScenario.put("315_QUEUINGPORT_STANDARD", new Scenario("System_HM_Table_003", "Module_HM_Table_001", "Partition_022", "Partition_Memory_002", "Module_Schedule_005", "Partition_HM_Table_003", "Connection_Table_003", "ModExt_001"));
		mpTestScenario.put("316_QUEUINGPORT_PSEUDO_MODULE1", new Scenario("System_HM_Table_003", "Module_HM_Table_001", "Partition_026", "Partition_Memory_002", "Module_Schedule_005", "Partition_HM_Table_003", "Connection_Table_004", "ModExt_001"));
		mpTestScenario.put("317_QUEUINGPORT_PSEUDO_MODULE2", new Scenario("System_HM_Table_003", "Module_HM_Table_001", "Partition_026", "Partition_Memory_002", "Module_Schedule_005", "Partition_HM_Table_003", "Connection_Table_005", "ModExt_003"));

		mpTestScenario.put("401_HEALTHMONITORING_CURRENTSYSTEMSTATE", new Scenario("System_HM_Table_003", "Module_HM_Table_002", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_002", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("402_HEALTHMONITORING_PROPAGATION_APPLICATIONERROR", new Scenario("System_HM_Table_003", "Module_HM_Table_002", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_002", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("403_HEALTHMONITORING_PROPAGATION_STACKOVERFLOW", new Scenario("System_HM_Table_003", "Module_HM_Table_002", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_002", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("404_HEALTHMONITORING_PROPAGATION_MEMORYVIOLATION", new Scenario("System_HM_Table_003", "Module_HM_Table_002", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_002", "Connection_Table_001", "ModExt_001"));

		mpTestScenario.put("501_FLOATINGPOINT", new Scenario("System_HM_Table_001", "Module_HM_Table_001", "Partition_018", "Partition_Memory_001", "Module_Schedule_001", "Partition_HM_Table_001", "Connection_Table_001", "ModExt_001"));
		mpTestScenario.put("502_SAMPLINGPORT_SENSOR_MODULE1", new Scenario("System_HM_Table_003", "Module_HM_Table_001", "Partition_027", "Partition_Memory_002", "Module_Schedule_005", "Partition_HM_Table_003", "Connection_Table_006", "ModExt_001", new TargetPlatform[] { TargetPlatform.ARMV7A_AM335X }));
		mpTestScenario.put("503_SAMPLINGPORT_SENSOR_MODULE2", new Scenario("System_HM_Table_003", "Module_HM_Table_001", "Partition_028", "Partition_Memory_002", "Module_Schedule_005", "Partition_HM_Table_003", "Connection_Table_007", "ModExt_003", new TargetPlatform[] { TargetPlatform.ARMV7A_AM335X }));
	}

	/**
	 * Tests getter.
	 */
	public static List<String> getTests() {

		// Gets tests
		List<String> lsTests = new LinkedList<String>(mpTestScenario.keySet());

		// Sorts tests
		Collections.sort(lsTests);

		// Returns list
		return lsTests;
	}

	/**
	 * Scenario getter.
	 * 
	 * @param stTest Test.
	 */
	public static Scenario getScenario(String stTest) {
		return mpTestScenario.get(stTest);
	}

	/**
	 * Compatible target platform verifier.
	 * 
	 * @param stTest           Test.
	 * @param tpTargetPlatform Target platform.
	 */
	public static boolean isCompatibleTargetPlatform(String stTest, TargetPlatform tpTargetPlatform) throws Throwable {

		// Gets scenario
		Scenario scScenario = mpTestScenario.get(stTest);

		// Verifies scenario
		if (scScenario == null) {
			throw new Exception("Test '" + stTest + "' has no scenario");
		}

		// Verifies target platform compatibility
		return scScenario.isCompatibleTargetPlatform(tpTargetPlatform);
	}

	/**
	 * Mask directory getter.
	 * 
	 * @param stMaskName             Mask name.
	 * @param blArchitectureSpecific Architecture-specific flag.
	 * @param blPlatformSpecific     Platform-specific flag.
	 * @param tpTargetPlatform       Target platform.
	 */
	private static String getMaskDirectory(String stMaskName, boolean blArchitectureSpecific, boolean blPlatformSpecific, TargetPlatform tpTargetPlatform) {
		if (blArchitectureSpecific) {
			return stMaskName + "_" + tpTargetPlatform.getArchitectureName();
		} else if (blPlatformSpecific) {
			return stMaskName + "_" + tpTargetPlatform.name();
		} else {
			return stMaskName;
		}
	}

	/**
	 * Push test method.
	 * 
	 * @param stTest                  Test.
	 * @param tpTargetPlatform        Target platform.
	 * @param flTestModule            Test module file. If null default is assumed.
	 * @param flTestTemplateDirectory Test template directory.
	 */
	public static void cmdPushTest(String stTest, TargetPlatform tpTargetPlatform, File flTestModule, File flTestTemplateDirectory) throws Throwable {

		// Gets scenario
		Scenario scScenario = mpTestScenario.get(stTest);

		// Verifies scenario
		if (scScenario == null) {
			throw new Exception("Test '" + stTest + "' has no scenario");
		}

		// Target platform output directory
		File flTargetPlatformOutputDirectory = new File(flOutputDirectory, tpTargetPlatform.name());

		// Verifies target platform output directory
		if (!flTargetPlatformOutputDirectory.exists()) {

			// Creates target platform output directory
			flTargetPlatformOutputDirectory.mkdirs();
		}

		// Parameters
		flTestModule = (flTestModule != null ? flTestModule : new File(flTargetPlatformOutputDirectory, stTest + "/module.xml"));
		flTestTemplateDirectory = (flTestTemplateDirectory != null ? flTestTemplateDirectory : new File(flTargetPlatformOutputDirectory, stTest));

		// Loads scenario masks
		Mask msSystem_HM_Table = Mask.cmdLoad(new File(flScenarioDirectory, getMaskDirectory("System_HM_Table", tpTargetPlatform.getArchitectureSpecific_SystemHMTable(), tpTargetPlatform.getPlatformSpecific_SystemHMTable(), tpTargetPlatform) + "/" + scScenario.getSystem_HM_Table() + ".msk"));
		Mask msModule_HM_Table = Mask.cmdLoad(new File(flScenarioDirectory, getMaskDirectory("Module_HM_Table", tpTargetPlatform.getArchitectureSpecific_ModuleHMTable(), tpTargetPlatform.getPlatformSpecific_ModuleHMTable(), tpTargetPlatform) + "/" + scScenario.getModule_HM_Table() + ".msk"));
		Mask msPartition = Mask.cmdLoad(new File(flScenarioDirectory, "Partition/" + scScenario.getPartition() + ".msk"));
		Mask msPartition_Memory = Mask.cmdLoad(new File(flScenarioDirectory, getMaskDirectory("Partition_Memory", tpTargetPlatform.getArchitectureSpecific_PartitionMemory(), tpTargetPlatform.getPlatformSpecific_PartitionMemory(), tpTargetPlatform) + "/" + scScenario.getPartition_Memory() + ".msk"));
		Mask msModule_Schedule = Mask.cmdLoad(new File(flScenarioDirectory, "Module_Schedule/" + scScenario.getModule_Schedule() + ".msk"));
		Mask msPartition_HM_Table = Mask.cmdLoad(new File(flScenarioDirectory, getMaskDirectory("Partition_HM_Table", tpTargetPlatform.getArchitectureSpecific_PartitionHMTable(), tpTargetPlatform.getPlatformSpecific_PartitionHMTable(), tpTargetPlatform) + "/" + scScenario.getPartition_HM_Table() + ".msk"));
		Mask msConnection_Table = Mask.cmdLoad(new File(flScenarioDirectory, "Connection_Table/" + scScenario.getConnection_Table() + ".msk"));
		Mask msModExt = Mask.cmdLoad(new File(flScenarioDirectory, getMaskDirectory("ModExt", tpTargetPlatform.getArchitectureSpecific_ModExt(), tpTargetPlatform.getPlatformSpecific_ModExt(), tpTargetPlatform) + "/" + scScenario.getModExt() + ".msk"));

		// Merges masks
		Mask msMask = Mask.cmdMerge(msSystem_HM_Table, msModule_HM_Table, msPartition, msPartition_Memory, msModule_Schedule, msPartition_HM_Table, msConnection_Table, msModExt);

		// Expands
		msMask.cmdExpand(Language_XML.INSTANCE, flModule, flTestModule);

		// Creates template generator
		TemplateGenerator tgTemplateGenerator = TemplateGenerator.getInstance(tpTargetPlatform);

		// Generates template
		List<File> lsFile = tgTemplateGenerator.cmdGenerateTemplate(new File[] { flTestModule }, tpTargetPlatform, flTestTemplateDirectory, null, null, null, null);

		// Loads test mask
		Mask msTest = Mask.cmdLoad(new File(flTemplateDirectory, stTest + ".msk"));

		// Iterates files
		Iterator<File> itFile = lsFile.iterator();
		while (itFile.hasNext()) {

			// Gets next file
			File flFile = itFile.next();

			// Expands
			msTest.cmdExpand(Language_C.INSTANCE, flFile, flFile);
		}

		// Generates schedule
		ScheduleGenerator.cmdGenerateSchedule(flTestModule, "PNG", new File(flTestTemplateDirectory, "module.png"));
	}

	/**
	 * Push special test method.
	 * 
	 * @param flTestDirectory  Test directory.
	 * @param tpTargetPlatform Target platform.
	 */
	public static void cmdPushSpecialTest(File flTestDirectory, TargetPlatform tpTargetPlatform) throws Throwable {

		// Parameters
		File flTestModule = new File(flTestDirectory, "module.xml");

		// Creates template generator
		TemplateGenerator tgTemplateGenerator = TemplateGenerator.getInstance(tpTargetPlatform);

		// Generates template
		tgTemplateGenerator.cmdGenerateTemplate(new File[] { flTestModule }, tpTargetPlatform, flTestDirectory, null, null, null, null);

		// Loads artifact
		Artifact arArtifact = Artifact.cmdLoad(null, new File(flTestDirectory, "Template.art"));

		// Expands artifact
		arArtifact.cmdExpand(new Language_C(), flTestDirectory, ".*\\.c", "configuration\\.c", true);

		// Generates schedule
		ScheduleGenerator.cmdGenerateSchedule(flTestModule, "PNG", new File(flTestDirectory, "module.png"));
	}

	/**
	 * Pull test method.
	 * 
	 * @param stTest                  Test.
	 * @param tpTargetPlatform        Target platform.
	 * @param flTestTemplateDirectory Test template directory.
	 */
	public static void cmdPullTest(String stTest, TargetPlatform tpTargetPlatform, File flTestTemplateDirectory) throws Throwable {

		// Target platform output directory
		File flTargetPlatformOutputDirectory = new File(flOutputDirectory, tpTargetPlatform.name());

		// Verifies target platform output directory
		if (!flTargetPlatformOutputDirectory.exists()) {
			throw new Exception("Target platform output directory does not exist");
		}

		// Parameters
		flTestTemplateDirectory = (flTestTemplateDirectory != null ? flTestTemplateDirectory : new File(flTargetPlatformOutputDirectory, stTest));

		// Creates artifact
		Artifact arArtifact = new Artifact(null);

		// Collapses
		arArtifact.cmdCollapse(Language_C.INSTANCE, flTestTemplateDirectory, ".+\\.[ch]", null, false);

		// Creates mask array
		Mask[] msMasks = new Mask[arArtifact.getMaskNames().size()];

		// Index
		int inIndex = 0;

		// Iterates mask names
		Iterator<String> itMaskName = arArtifact.getMaskNames().iterator();
		while (itMaskName.hasNext()) {

			// Gets next mask
			msMasks[inIndex++] = arArtifact.getMask(itMaskName.next(), false);
		}

		// Merges masks
		Mask msMask = Mask.cmdMerge(msMasks);

		// Saves mask
		Mask.cmdSave(msMask, new File(flTemplateDirectory, stTest + ".msk"));
	}

	/**
	 * Pull special test method.
	 * 
	 * @param flTestDirectory Test directory.
	 */
	public static void cmdPullSpecialTest(File flTestDirectory) throws Throwable {

		// Creates artifact
		Artifact arArtifact = new Artifact(null);

		// Collapses
		arArtifact.cmdCollapse(Language_C.INSTANCE, flTestDirectory, ".+\\.[ch]", null, false);

		// Saves artifact
		Artifact.cmdSave(arArtifact, new File(flTestDirectory, "Template.art"));
	}

	/**
	 * Test building method.
	 * 
	 * @param stTest Test.
	 */
	public static void cmdBuildTest(String stTest) throws Throwable {

		// Shows message
		System.out.println("Making test '" + stTest + "'...");

		// Pushes test
		Tests.cmdPushTest(stTest, TargetPlatform.ARMV7A_AM335X, new File(Tests.flARINC653Directory, "Application/module.xml"), new File(Tests.flARINC653Directory, "Application"));

		// Output files
		File flOutputAPP = new File(Tests.flARINC653Directory, "Release/APP");
		File flOutputAPP_XMODEM = new File(Tests.flARINC653Directory, "Release/APP_XMODEM");

		// Verifies output files
		if (flOutputAPP.exists()) {

			// Deletes output file
			if (!flOutputAPP.delete()) {
				throw new Exception("Output file could not be deleted");
			}
		}
		if (flOutputAPP_XMODEM.exists()) {

			// Deletes output file
			if (!flOutputAPP_XMODEM.delete()) {
				throw new Exception("Output file could not be deleted");
			}
		}

		// Delays
		Thread.sleep(1000);

		// Cleans
		{
			System.out.println("Cleaning...");
			Process prProcess;
			if (System.getProperty("os.name").toLowerCase().contains("windows")) {
				prProcess = new ProcessBuilder(new String[] { "cmd", "/c", "CLEAN_RELEASE" }).inheritIO().directory(Tests.flARINC653Directory).start();
			} else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
				prProcess = new ProcessBuilder(new String[] { "bash", "CLEAN_RELEASE.sh" }).inheritIO().directory(Tests.flARINC653Directory).start();
			} else {
				throw new RuntimeException("Operating system not supported");
			}
			BufferedReader brOutput = new BufferedReader(new InputStreamReader(prProcess.getInputStream()));
			while (true) {
				String stLine = brOutput.readLine();
				if (stLine == null) {
					break;
				}
				System.out.println(stLine);
			}
			brOutput.close();
			prProcess.waitFor();
		}

		// Makes
		{
			System.out.println("Making...");
			Process prProcess;
			if (System.getProperty("os.name").toLowerCase().contains("windows")) {
				prProcess = new ProcessBuilder(new String[] { "cmd", "/c", "MAKE_RELEASE" }).inheritIO().directory(Tests.flARINC653Directory).start();
			} else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
				prProcess = new ProcessBuilder(new String[] { "bash", "MAKE_RELEASE.sh" }).inheritIO().directory(Tests.flARINC653Directory).start();
			} else {
				throw new RuntimeException("Operating system not supported");
			}
			BufferedReader brOutput = new BufferedReader(new InputStreamReader(prProcess.getInputStream()));
			while (true) {
				String stLine = brOutput.readLine();
				if (stLine == null) {
					break;
				}
				System.out.println(stLine);
			}
			brOutput.close();
			prProcess.waitFor();
		}

		// Delays
		Thread.sleep(1000);

		// Copy output files
		File flOutputCopyAPP = new File("Test/Output/ARMV7A_AM335X/" + stTest + "_APP");
		File flOutputCopyAPP_XMODEM = new File("Test/Output/ARMV7A_AM335X/" + stTest + "_APP_XMODEM");

		// Removes old copy output files
		if (flOutputCopyAPP.exists()) {
			flOutputCopyAPP.delete();
		}
		if (flOutputCopyAPP_XMODEM.exists()) {
			flOutputCopyAPP_XMODEM.delete();
		}

		// Copies application binaries
		Files.copy(flOutputAPP.toPath(), flOutputCopyAPP.toPath());
		Files.copy(flOutputAPP_XMODEM.toPath(), flOutputCopyAPP_XMODEM.toPath());
	}
}
