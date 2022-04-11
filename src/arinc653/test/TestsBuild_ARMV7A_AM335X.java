package arinc653.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Test building class - ARMV7A AM335X.
 * 
 * @author Luís Fernando Arcaro
 */
public class TestsBuild_ARMV7A_AM335X {

	/**
	 * Main method.
	 * 
	 * @param args Arguments.
	 */
	public static void main(String[] args) {
		try {

			// Opens input
			BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			try {

				// Gets tests
				List<String> lsTests = Tests.getTests();

				// Sorts tests
				Collections.sort(lsTests);

				// Iterates tests
				Iterator<String> itTest = lsTests.iterator();
				while (itTest.hasNext()) {

					// Gets next test
					String stTest = itTest.next();

					// Builds test
					Tests.cmdBuildTest(stTest);
				}
			} finally {

				// Closes input
				brBufferedReader.close();
			}
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}