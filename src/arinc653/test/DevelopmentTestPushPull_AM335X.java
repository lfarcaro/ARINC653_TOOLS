package arinc653.test;

import java.io.File;

import arinc653.configuration.tools.TargetPlatform;
import arinc653.configuration.tools.schedulegenerator.ScheduleGenerator;

/**
 * Development test pushing class.
 * 
 * @author Luís Fernando Arcaro
 */
public class DevelopmentTestPushPull_AM335X {

	/**
	 * Main method.
	 * 
	 * @param args Arguments.
	 */
	public static void main(String[] args) {
		try {

			boolean blPushNotPull = false;
			String stTest = "007_SYSTEMPARTITION";
			TargetPlatform tpTargetPlatform = TargetPlatform.ARMV7A_AM335X;
			File flTestTemplateDirectory = new File(Tests.flARINC653Directory, "Application");
			File flTestModule = new File(flTestTemplateDirectory, "module.xml");

			// Pulls development test
			if (!blPushNotPull) {

				// Pulls test
				Tests.cmdPullTest(stTest, tpTargetPlatform, flTestTemplateDirectory);
			} else {

				// Pushes test
				Tests.cmdPushTest(stTest, tpTargetPlatform, null, flTestTemplateDirectory);
			}

			// Generates schedule
			ScheduleGenerator.cmdGenerateSchedule(flTestModule, "PNG", new File(flTestTemplateDirectory, "module.png"));
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}
