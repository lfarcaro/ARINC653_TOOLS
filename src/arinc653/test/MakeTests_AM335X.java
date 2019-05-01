package arinc653.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import arinc653.configuration.tools.TargetPlatform;

/**
 * AM335X make tests class.
 * 
 * @author Luís Fernando Arcaro
 */
public class MakeTests_AM335X {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {
		try {

			// Ignored tests list
			List<String> lsIgnored = Arrays.asList(new String[] {});

			// Special tests list
			List<String> lsSpecial = Arrays.asList(new String[] {});

			// Test make interval
			int inIntervalStart = Integer.MIN_VALUE;
			int inIntervalEnd = Integer.MAX_VALUE;

			// Opens input
			BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			try {

				// Gets tests
				List<String> lsTests = TestUtilities.getTests();

				// Sorts tests
				Collections.sort(lsTests);

				// Removes special tests
				lsTests.removeAll(lsSpecial);

				// Adds special tests
				lsTests.addAll(lsSpecial);

				// Iterates tests
				Iterator<String> itTest = lsTests.iterator();
				while (itTest.hasNext()) {

					// Gets next test
					String stTest = itTest.next();

					// Verifies ignored test
					if (lsIgnored.contains(stTest)) {

						// Shows message
						System.out.println();
						System.out.println("IGNORING TEST: " + stTest);
						continue;
					}

					// Matches test number
					Matcher mtTestNumber = Pattern.compile("^([0-9]+)_.*$").matcher(stTest);

					// Verifies match
					if (!mtTestNumber.matches()) {
						throw new Exception("Test '" + stTest + "' does not indicate a number");
					}

					// Gets test number
					String stTestNumber = mtTestNumber.group(1);

					// Parses test number
					int inTestNumber = Integer.parseInt(stTestNumber);

					// Verifies test number against interval
					if ((inTestNumber < inIntervalStart) || (inTestNumber > inIntervalEnd)) {
						continue;
					}

					// Shows message
					System.out.println("Making test '" + stTest + "' (" + stTestNumber + ")...");

					// Pushes test
					TestUtilities.cmdPushTest(stTest, TargetPlatform.AM335X, new File(CurrentTest.flARINC653Directory, "Application/module.xml"), new File(CurrentTest.flARINC653Directory, "Application"));

					// Output file
					File flOutput = new File(CurrentTest.flARINC653Directory, "Release/APP");

					// Verifies output file
					if (flOutput.exists()) {

						// Deletes output file
						if (!flOutput.delete()) {
							throw new Exception("Output file could not be deleted");
						}
					}

					// Verifies special tests
					if (lsSpecial.contains(stTest)) {

						// Asks for intervention
						System.out.println();
						System.out.println("INTERVENTION NEEDED:");
						System.out.println("This test has special modules, and therefore the default build script is not correct for it.");
						System.out.println("Please build it using the compiler and press ENTER to finish.");
						System.out.println();

						// Reads input line
						brBufferedReader.readLine();
					}

					// Delays
					Thread.sleep(1000);

					// Makes
					{
						System.out.println("Making...");
						Process prProcess = Runtime.getRuntime().exec(new String[] {"cmd", "/c", "MAKE_RELEASE"}, null, CurrentTest.flARINC653Directory);
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

					// Copies output file
					FileInputStream isOutput = new FileInputStream(flOutput);
					try {
						FileOutputStream osOutput = new FileOutputStream("Test/Output/AM335X/" + stTestNumber);
						try {
							byte[] btBuffer = new byte[4096];
							while (true) {
								int inCount = isOutput.read(btBuffer);
								if (inCount <= 0) {
									break;
								}
								osOutput.write(btBuffer, 0, inCount);
							}
						} finally {
							osOutput.close();
						}
					} finally {
						isOutput.close();
					}
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