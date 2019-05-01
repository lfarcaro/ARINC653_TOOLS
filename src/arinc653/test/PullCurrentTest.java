package arinc653.test;

/**
 * Current test pulling class.
 * 
 * @author Luís Fernando Arcaro
 */
public class PullCurrentTest {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {
		try {

			// Pulls test
			TestUtilities.cmdPullTest(CurrentTest.stCurrentTest, CurrentTest.tpTargetPlatform, CurrentTest.flOutputDirectory);
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}