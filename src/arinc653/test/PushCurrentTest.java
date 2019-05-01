package arinc653.test;

import java.io.File;

/**
 * Current test pushing class.
 * 
 * @author Luís Fernando Arcaro
 */
public class PushCurrentTest {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {
		try {

			// Pushes test
			TestUtilities.cmdPushTest(CurrentTest.stCurrentTest, CurrentTest.tpTargetPlatform, new File(CurrentTest.flOutputDirectory, "module.xml"), CurrentTest.flOutputDirectory);
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}