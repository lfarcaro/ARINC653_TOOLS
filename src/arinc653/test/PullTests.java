package arinc653.test;

import java.util.Iterator;

import arinc653.configuration.tools.TargetPlatform;

/**
 * Test pulling class.
 * 
 * @author Luís Fernando Arcaro
 */
public class PullTests {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {
		try {

			// Target platform
			TargetPlatform tpTargetPlatform = TargetPlatform.AM335X;

			// Iterates tests
			Iterator<String> itTest = TestUtilities.getTests().iterator();
			while (itTest.hasNext()) {

				// Gets next test
				String stTest = itTest.next();

				// Shows test
				System.out.println("Test: " + stTest);

				// Pulls test
				TestUtilities.cmdPullTest(stTest, tpTargetPlatform, null);
			}
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}