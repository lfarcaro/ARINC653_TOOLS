package arinc653.test;

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
public class PushTests {

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
			Iterator<String> itTest = TestUtilities.getTests().iterator();
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
					if (TestUtilities.isCompatibleTargetPlatform(stTest, tpTargetPlatform)) {

						// Pushes test
						TestUtilities.cmdPushTest(stTest, tpTargetPlatform, null, null);
					}
				}
			}
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}