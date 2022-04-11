package arinc653.test;

import java.io.File;
import java.util.Iterator;

import arinc653.configuration.tools.TargetPlatform;

/**
 * Test pulling class.
 * 
 * @author Luís Fernando Arcaro
 */
public class TestsPull {

	/**
	 * Main method.
	 * 
	 * @param args Arguments.
	 */
	public static void main(String[] args) {
		try {

			// Target platform
			TargetPlatform tpTargetPlatform = TargetPlatform.ARMV7A_AM335X;

			// Iterates tests
			Iterator<String> itTest = Tests.getTests().iterator();
			while (itTest.hasNext()) {

				// Gets next test
				String stTest = itTest.next();

				// Shows test
				System.out.println("Test: " + stTest);

				// Pulls test
				Tests.cmdPullTest(stTest, tpTargetPlatform, null);
			}

			// Pulls special tests
			Tests.cmdPullSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "QUEUINGPORT_PSEUDO_MODULE1"));
			Tests.cmdPullSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "QUEUINGPORT_PSEUDO_MODULE2"));
			Tests.cmdPullSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "QUEUINGPORT_PSEUDO_MODULE3"));
			Tests.cmdPullSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "SAMPLINGPORT_PSEUDO_MODULE1"));
			Tests.cmdPullSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "SAMPLINGPORT_PSEUDO_MODULE2"));
			Tests.cmdPullSpecialTest(new File(Tests.flSpecialTestDirectory_ARMV7A_AM335X, "SAMPLINGPORT_PSEUDO_MODULE3"));
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}