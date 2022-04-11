package arinc653.test;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import arinc653.configuration.tools.TargetPlatform;

/**
 * Test pushing class.
 * 
 * @author Luís Fernando Arcaro
 */
public class TestsPush {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {
		try {

			// Target platform list
			List<TargetPlatform> lsTargetPlatform = new LinkedList<TargetPlatform>(Arrays.asList(TargetPlatform.values()));

			// Iterates tests
			Iterator<String> itTest = Tests.getTests().iterator();
			while (itTest.hasNext()) {

				// Gets next test
				String stTest = itTest.next();

				// Shows test
				System.out.println("Test: " + stTest);

				// Iterates target platforms
				Iterator<TargetPlatform> itTargetPlatform = lsTargetPlatform.iterator();
				while (itTargetPlatform.hasNext()) {

					// Gets next target platform
					TargetPlatform tpTargetPlatform = itTargetPlatform.next();

					// Verifies target platform compatibility
					if (Tests.isCompatibleTargetPlatform(stTest, tpTargetPlatform)) {

						// Pushes test
						Tests.cmdPushTest(stTest, tpTargetPlatform, null, null);
					}
				}
			}

			// Pushes special tests
			Tests.cmdPushSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "QUEUINGPORT_PSEUDO_MODULE1"), TargetPlatform.ARMV7A_AM335X);
			Tests.cmdPushSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "QUEUINGPORT_PSEUDO_MODULE2"), TargetPlatform.ARMV7A_AM335X);
			Tests.cmdPushSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "QUEUINGPORT_PSEUDO_MODULE3"), TargetPlatform.ARMV7A_AM335X);
			Tests.cmdPushSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "SAMPLINGPORT_PSEUDO_MODULE1"), TargetPlatform.ARMV7A_AM335X);
			Tests.cmdPushSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "SAMPLINGPORT_PSEUDO_MODULE2"), TargetPlatform.ARMV7A_AM335X);
			Tests.cmdPushSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "SAMPLINGPORT_PSEUDO_MODULE3"), TargetPlatform.ARMV7A_AM335X);
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}