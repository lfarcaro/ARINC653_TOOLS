package arinc653.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import svluis.port.protocol.XModem;
import svluis.port.protocol.XModem.XModemMode;
import svluis.port.serialport.NativeSerialPortWindows;

/**
 * Tests running application.
 * 
 * @author Luís Fernando Arcaro
 */
public class TestsRun_ARMV7A_AM335X {

	/**
	 * Event admission entry.
	 * 
	 * @author Luís Fernando Arcaro
	 */
	private static class EventAdmissionEntry {

		/**
		 * Time.
		 */
		public double dbTime;

		/**
		 * Tolerance.
		 */
		public double dbTolerance;

		/**
		 * Test minimum admissions.
		 */
		public Integer inTestMinimumAdmissions = null;

		/**
		 * Test maximum admissions.
		 */
		public Integer inTestMaximumAdmissions = null;

		/**
		 * Test round minimum admissions.
		 */
		public Integer inTestRoundMinimumAdmissions = null;

		/**
		 * Test round maximum admissions.
		 */
		public Integer inTestRoundMaximumAdmissions = null;

		/**
		 * Test admissions.
		 */
		public int inTestAdmissions;

		/**
		 * Test round admissions.
		 */
		public int inTestRoundAdmissions;

		/**
		 * Constructor.
		 * 
		 * @param dbTime      Time.
		 * @param dbTolerance Tolerance.
		 */
		public EventAdmissionEntry(double dbTime, double dbTolerance) {
			this.dbTime = dbTime;
			this.dbTolerance = dbTolerance;
		}

		/**
		 * Test resetting method.
		 */
		public void cmdResetTest() {
			this.inTestAdmissions = 0;
			this.inTestRoundAdmissions = 0;
		}

		/**
		 * Test round resetting method.
		 */
		public void cmdResetTestRound() {
			this.inTestRoundAdmissions = 0;
		}

		/**
		 * Event admission method.
		 * 
		 * @param dbTime Time.
		 */
		public boolean cmdAdmit(double dbTime) {

			// Calculates absolute slack
			double dbSlack = Math.abs(Math.max(dbTime, this.dbTime) - Math.min(dbTime, this.dbTime));

			// Checks slack against tolerance
			if (dbSlack <= this.dbTolerance) {

				// Verifies if minimum slack ticks are respected
				if (this.dbTolerance - dbSlack <= inMinimumSlackTicks * (1d / inTicksPerSecond)) {

					// Prints warning
					System.out.printf("***** SLACK WARNING *****: Event at time %.05f was less than %d ticks away from the tolerance limit (time %.05f, tolerance %.05f)\n", dbTime, inMinimumSlackTicks, this.dbTime, this.dbTolerance);

					// Sets test warning flag
					blTestWarning = true;

					// Sets test round warning flag
					blTestRoundWarning = true;
				}

				// Counts test admission
				inTestAdmissions++;

				// Counts test round admission
				inTestRoundAdmissions++;
				return true;
			} else {
				return false;
			}
		}

		@Override
		public String toString() {
			return String.format("%.05f~%.05f", dbTime, dbTolerance);
		}
	}

	/**
	 * Ticks per second.
	 */
	private static int inTicksPerSecond;

	/**
	 * Minimum slack ticks.
	 */
	private static int inMinimumSlackTicks;

	/**
	 * Major frame duration in seconds.
	 */
	private static double dbMajorFrameDuration;

	/**
	 * Major frame start event map. Used to re-synchronize the test timing with the
	 * major frame start to eliminate drifts. The keys are event descriptor strings,
	 * and the values are the major frame times in which the major frame (re)start
	 * is expected to occur, associated with a tolerance.
	 */
	private static final Map<String, Set<EventAdmissionEntry>> mpMajorFrameStartEvent = new HashMap<String, Set<EventAdmissionEntry>>();

	/**
	 * Event time validation map. Used to validate events' timing. The keys are
	 * event descriptor strings, and the values are the major frame times in which
	 * the associated event is expected to occur, associated with a tolerance.
	 */
	private static final Map<String, Set<EventAdmissionEntry>> mpEventTimeValidation = new HashMap<String, Set<EventAdmissionEntry>>();

	/**
	 * Expected successful test rounds.
	 */
	private static int inExpectedSuccessfulTestRounds;

	/**
	 * Maximum unsuccessful test rounds.
	 */
	private static int inMaximumUnsuccessfulTestRounds;

	/**
	 * Test environment - Major frame zero time.
	 */
	private static double dbTestRoundMajorFrameZeroTime;

	/**
	 * Test environment - Test round running.
	 */
	private static boolean blTestRoundRunning;

	/**
	 * Test environment - Test round failed.
	 */
	private static boolean blTestRoundFailed;

	/**
	 * Test environment - Current test round.
	 */
	private static int inCurrentTestRound;

	/**
	 * Test environment - Successful test rounds.
	 */
	private static int inSuccessfulTestRounds;

	/**
	 * Test environment - Unsuccessful test rounds.
	 */
	private static int inUnsuccessfulTestRounds;

	/**
	 * Test environment - Test warning.
	 */
	private static boolean blTestWarning;

	/**
	 * Test environment - Test round warning.
	 */
	private static boolean blTestRoundWarning;

	/**
	 * Method for adding an event admission entry.
	 * 
	 * @param mpEventAdmissionEntry Event admission entry map.
	 * @param stEventDescriptor     Event descriptor string.
	 * @param dbTime                Expected time for the event.
	 * @param dbTolerance           Tolerance for the event time validation.
	 */
	private static EventAdmissionEntry addEventAdmissionEntry(Map<String, Set<EventAdmissionEntry>> mpEventAdmissionEntry, String stEventDescriptor, double dbTime, double dbTolerance) {
		Set<EventAdmissionEntry> stEventAdmissionEntry = mpEventAdmissionEntry.get(stEventDescriptor);
		if (stEventAdmissionEntry == null) {
			stEventAdmissionEntry = new HashSet<EventAdmissionEntry>();
			mpEventAdmissionEntry.put(stEventDescriptor, stEventAdmissionEntry);
		}
		EventAdmissionEntry enEventAdmissionEntry = new EventAdmissionEntry(dbTime, dbTolerance);
		stEventAdmissionEntry.add(enEventAdmissionEntry);
		return enEventAdmissionEntry;
	}

	/**
	 * Method for admitting an event.
	 * 
	 * @param mpEventAdmissionEntry Event admission entry map.
	 * @param stEventDescriptor     Event descriptor string.
	 * @param dbTime                Time in which the event was registered.
	 * @param blVerbose             Verbose output.
	 */
	private static boolean cmdAdmitEvent(Map<String, Set<EventAdmissionEntry>> mpEventAdmissionEntry, String stEventDescriptor, double dbTime, boolean blVerbose) {
		Set<EventAdmissionEntry> stEventAdmissionEntry = mpEventAdmissionEntry.get(stEventDescriptor);
		if (stEventAdmissionEntry != null) {
			boolean blEventAdmitted = false;
			Iterator<EventAdmissionEntry> itEventAdmissionEntry = stEventAdmissionEntry.iterator();
			while (itEventAdmissionEntry.hasNext()) {
				EventAdmissionEntry enEventAdmissionEntry = itEventAdmissionEntry.next();
				if (enEventAdmissionEntry.cmdAdmit(dbTime)) {
					blEventAdmitted = true;
					break;
				}
			}
			if (!blEventAdmitted) {
				if (blVerbose) {
					System.out.printf("ERROR: Event '%s' expected at %s but observed at %.05f\n", stEventDescriptor, Arrays.toString(stEventAdmissionEntry.toArray(new EventAdmissionEntry[] {})), dbTime);
				}
				return false;
			} else {
				if (blVerbose) {
					System.out.printf("SUCCESS: Event '%s' expected at %s and observed at %.05f\n", stEventDescriptor, Arrays.toString(stEventAdmissionEntry.toArray(new EventAdmissionEntry[] {})), dbTime);
				}
				return true;
			}
		} else {
			if (blVerbose) {
				System.out.printf("ERROR: Event '%s' admissions not declared but event observed at %.05f\n", stEventDescriptor, dbTime);
			}
			return false;
		}
	}

	/**
	 * File loading method.
	 * 
	 * @param flFile File.
	 */
	private static boolean cmdLoadTestFile(File flFile) {
		try {
			BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(flFile)));
			try {
				boolean blDefinedTicksPerSecond = false;
				boolean blDefinedMinimumSlackTicks = false;
				boolean blDefinedMajorFrameDuration = false;
				boolean blDefinedMajorFrameStartEvent = false;
				boolean blDefinedEventTimeValidation = false;
				boolean blDefinedExpectedSuccessfulTestRounds = false;
				boolean blDefinedMaximumUnsuccessfulTestRounds = false;
				while (true) {
					String stLine = brBufferedReader.readLine();
					if (stLine == null) {
						break;
					}
					stLine = stLine.trim();
					if (stLine.equals("inTicksPerSecond")) {
						stLine = brBufferedReader.readLine();
						if (stLine == null) {
							throw new RuntimeException("No value provided for entry 'inTicksPerSecond'");
						}
						stLine = stLine.trim();
						try {
							inTicksPerSecond = Integer.valueOf(stLine);
						} catch (Exception e) {
							throw new RuntimeException("Invalid value read for entry 'inTicksPerSecond'");
						}
						blDefinedTicksPerSecond = true;
					} else if (stLine.equals("inMinimumSlackTicks")) {
						stLine = brBufferedReader.readLine();
						if (stLine == null) {
							throw new RuntimeException("No value provided for entry 'inMinimumSlackTicks'");
						}
						stLine = stLine.trim();
						try {
							inMinimumSlackTicks = Integer.valueOf(stLine);
						} catch (Exception e) {
							throw new RuntimeException("Invalid value read for entry 'inMinimumSlackTicks'");
						}
						blDefinedMinimumSlackTicks = true;
					} else if (stLine.equals("dbMajorFrameDuration")) {
						stLine = brBufferedReader.readLine();
						if (stLine == null) {
							throw new RuntimeException("No value provided for entry 'dbMajorFrameDuration'");
						}
						stLine = stLine.trim();
						try {
							dbMajorFrameDuration = Double.valueOf(stLine);
						} catch (Exception e) {
							throw new RuntimeException("Invalid value read for entry 'dbMajorFrameDuration'");
						}
						blDefinedMajorFrameDuration = true;
					} else if (stLine.equals("mpMajorFrameStartEvent")) {
						mpMajorFrameStartEvent.clear();
						while (true) {
							stLine = brBufferedReader.readLine();
							if (stLine == null) {
								break;
							}
							stLine = stLine.trim();
							if (stLine.equals("")) {
								break;
							}
							String[] stParts1 = stLine.split(Pattern.quote("|"));
							if (stParts1.length != 2) {
								throw new RuntimeException("Invalid line provided for entry 'mpMajorFrameStartEvent'");
							}
							String[] stParts2 = stParts1[0].trim().split(Pattern.quote(" "));
							if (stParts2.length != 2) {
								throw new RuntimeException("Invalid line provided for entry 'mpMajorFrameStartEvent'");
							}
							double dbTime;
							try {
								dbTime = Double.valueOf(stParts2[0].trim());
							} catch (Exception e) {
								throw new RuntimeException("Invalid time value provided for entry 'mpMajorFrameStartEvent'");
							}
							double dbTolerance;
							try {
								dbTolerance = Double.valueOf(stParts2[1].trim());
							} catch (Exception e) {
								throw new RuntimeException("Invalid tolerance value provided for entry 'mpMajorFrameStartEvent'");
							}
							addEventAdmissionEntry(mpMajorFrameStartEvent, stParts1[1].trim(), dbTime, dbTolerance);
						}
						blDefinedMajorFrameStartEvent = true;
					} else if (stLine.equals("mpEventTimeValidation")) {
						mpEventTimeValidation.clear();
						while (true) {
							stLine = brBufferedReader.readLine();
							if (stLine == null) {
								break;
							}
							stLine = stLine.trim();
							if (stLine.equals("")) {
								break;
							}
							String[] stParts = stLine.split(Pattern.quote("|"));
							if (stParts.length != 3) {
								throw new RuntimeException("Invalid line provided for entry 'mpEventTimeValidation'");
							}
							String[] stParts1 = stParts[0].trim().split(Pattern.quote(" "));
							if (stParts1.length != 2) {
								throw new RuntimeException("Invalid line provided for entry 'mpEventTimeValidation'");
							}
							double dbTime;
							try {
								dbTime = Double.valueOf(stParts1[0].trim());
							} catch (Exception e) {
								throw new RuntimeException("Invalid time value provided for entry 'mpEventTimeValidation'");
							}
							double dbTolerance;
							try {
								dbTolerance = Double.valueOf(stParts1[1].trim());
							} catch (Exception e) {
								throw new RuntimeException("Invalid tolerance value provided for entry 'mpEventTimeValidation'");
							}
							EventAdmissionEntry enEventAdmissionEntry = addEventAdmissionEntry(mpEventTimeValidation, stParts[2].trim(), dbTime, dbTolerance);
							String[] stParts2 = stParts[1].trim().split(Pattern.quote(" "));
							if (stParts2.length != 4) {
								throw new RuntimeException("Invalid line provided for entry 'mpEventTimeValidation'");
							}
							int inIndex = 0;
							if (!stParts2[inIndex].equals("-")) {
								try {
									enEventAdmissionEntry.inTestRoundMinimumAdmissions = Integer.valueOf(stParts2[inIndex]);
								} catch (Exception e) {
									throw new RuntimeException("Invalid value provided for entry 'mpEventTimeValidation'");
								}
							}
							inIndex++;
							if (!stParts2[inIndex].equals("-")) {
								try {
									enEventAdmissionEntry.inTestRoundMaximumAdmissions = Integer.valueOf(stParts2[inIndex]);
								} catch (Exception e) {
									throw new RuntimeException("Invalid value provided for entry 'mpEventTimeValidation'");
								}
							}
							inIndex++;
							if (!stParts2[inIndex].equals("-")) {
								try {
									enEventAdmissionEntry.inTestMinimumAdmissions = Integer.valueOf(stParts2[inIndex]);
								} catch (Exception e) {
									throw new RuntimeException("Invalid value provided for entry 'mpEventTimeValidation'");
								}
							}
							inIndex++;
							if (!stParts2[inIndex].equals("-")) {
								try {
									enEventAdmissionEntry.inTestMaximumAdmissions = Integer.valueOf(stParts2[inIndex]);
								} catch (Exception e) {
									throw new RuntimeException("Invalid value provided for entry 'mpEventTimeValidation'");
								}
							}
							inIndex++;
						}
						blDefinedEventTimeValidation = true;
					} else if (stLine.equals("inExpectedSuccessfulTestRounds")) {
						stLine = brBufferedReader.readLine();
						if (stLine == null) {
							throw new RuntimeException("No value provided for entry 'inExpectedSuccessfulTestRounds'");
						}
						stLine = stLine.trim();
						try {
							inExpectedSuccessfulTestRounds = Integer.valueOf(stLine);
						} catch (Exception e) {
							throw new RuntimeException("Invalid value read for entry 'inExpectedSuccessfulTestRounds'");
						}
						blDefinedExpectedSuccessfulTestRounds = true;
					} else if (stLine.equals("inMaximumUnsuccessfulTestRounds")) {
						stLine = brBufferedReader.readLine();
						if (stLine == null) {
							throw new RuntimeException("No value provided for entry 'inMaximumUnsuccessfulTestRounds'");
						}
						stLine = stLine.trim();
						try {
							inMaximumUnsuccessfulTestRounds = Integer.valueOf(stLine);
						} catch (Exception e) {
							throw new RuntimeException("Invalid value read for entry 'inMaximumUnsuccessfulTestRounds'");
						}
						blDefinedMaximumUnsuccessfulTestRounds = true;
					} else if (stLine.equals("")) {
					} else {
						System.out.printf("ERROR: Unexpected line '" + stLine + "' found\n");
					}
				}
				if (!blDefinedTicksPerSecond) {
					System.out.printf("ERROR: Entry 'inTicksPerSecond' was not defined in the test file\n");
					return false;
				}
				if (!blDefinedMinimumSlackTicks) {
					System.out.printf("ERROR: Entry 'inMinimumSlackTicks' was not defined in the test file\n");
					return false;
				}
				if (!blDefinedMajorFrameDuration) {
					System.out.printf("ERROR: Entry 'dbMajorFrameDuration' was not defined in the test file\n");
					return false;
				}
				if (!blDefinedMajorFrameStartEvent) {
					System.out.printf("ERROR: Entry 'mpMajorFrameStartEvent' was not defined in the test file\n");
					return false;
				}
				if (!blDefinedEventTimeValidation) {
					System.out.printf("ERROR: Entry 'mpEventTimeValidation' was not defined in the test file\n");
					return false;
				}
				if (!blDefinedExpectedSuccessfulTestRounds) {
					System.out.printf("ERROR: Entry 'inExpectedSuccessfulTestRounds' was not defined in the test file\n");
					return false;
				}
				if (!blDefinedMaximumUnsuccessfulTestRounds) {
					System.out.printf("ERROR: Entry 'inMaximumUnsuccessfulTestRounds' was not defined in the test file\n");
					return false;
				}
				return true;
			} finally {
				brBufferedReader.close();
			}
		} catch (Exception e) {
			System.out.printf("ERROR: Exception '%s' while reading the file\n", e.getMessage());
			return false;
		}
	}

	/*
	 * Test event processing results.
	 */
	private static final int PROCESSEVENT_PROCEED = 0;
	private static final int PROCESSEVENT_SUCCESSFUL = 1;
	private static final int PROCESSEVENT_UNSUCCESSFUL = 2;

	/**
	 * Event processing method.
	 * 
	 * @param stEvent Event.
	 * 
	 * @return Returns true if the test is finished.
	 */
	private static int cmdProcessEvent(String stEvent) {

		// Gets event information
		String[] stEventInformation = stEvent.split(Pattern.quote(" "));

		// Prepares event descriptor
		String stEventDescriptor = String.join(" ", Arrays.copyOfRange(stEventInformation, 1, stEventInformation.length));

		// Parses event time
		double dbEventTime;
		try {
			dbEventTime = Long.valueOf(stEventInformation[0]) * (1d / (double) inTicksPerSecond);
		} catch (Throwable t) {

			// Shows warning
			System.out.printf("WARNING: A malformed event '" + stEvent + "' was received and ignored\n");

			// Sets test warning flag
			blTestWarning = true;

			// Sets test round warning flag
			blTestRoundWarning = true;

			// Verifies if there is a test round running
			if (blTestRoundRunning) {

				// The current test round failed
				blTestRoundFailed = true;
			}

			// Proceeds
			return PROCESSEVENT_PROCEED;
		}

		// Calculates major frame time
		double dbTime = dbEventTime - dbTestRoundMajorFrameZeroTime;

		// Shows event
		//System.out.printf("Event %s @ %.05f\n", stEventDescriptor, dbTime);
		System.out.printf("%.05f 0.00050 | 1 1 1 1 | %s\n", dbTime, stEventDescriptor);

		// Gets command
		String stCommand = stEventInformation[1];

		// Handles context switch
		if ("CS".equals(stCommand)) {

			// Verifies major frame start event
			if (cmdAdmitEvent(mpMajorFrameStartEvent, stEventDescriptor, dbTime, false)) {

				// Sets major frame zero time
				dbTestRoundMajorFrameZeroTime = dbEventTime;

				// Updates time
				dbTime = 0d;

				// Prints note
				System.out.printf("NOTE: Major frame zero time set to %.05f\n", dbTestRoundMajorFrameZeroTime);

				// Verifies if there was a test round running
				if (blTestRoundRunning) {

					// Verifies if events' admission frequency was as expected in the test round
					for (Map.Entry<String, Set<EventAdmissionEntry>> enEventTimeValidation : mpEventTimeValidation.entrySet()) {
						for (EventAdmissionEntry enEventAdmissionEntry : enEventTimeValidation.getValue()) {
							if (enEventAdmissionEntry.inTestRoundMinimumAdmissions != null) {
								if (enEventAdmissionEntry.inTestRoundAdmissions < enEventAdmissionEntry.inTestRoundMinimumAdmissions) {

									// Prints error
									System.out.printf("ERROR: Event %s admission at %.05f~%.05f was not observed the minimum times %d in test round %d (it was observed %d times)\n", enEventTimeValidation.getKey(), enEventAdmissionEntry.dbTime, enEventAdmissionEntry.dbTolerance, enEventAdmissionEntry.inTestRoundMinimumAdmissions, inCurrentTestRound, enEventAdmissionEntry.inTestRoundAdmissions);

									// The current test round failed
									blTestRoundFailed = true;
								}
							}
							if (enEventAdmissionEntry.inTestRoundMaximumAdmissions != null) {
								if (enEventAdmissionEntry.inTestRoundAdmissions > enEventAdmissionEntry.inTestRoundMaximumAdmissions) {

									// Prints error
									System.out.printf("ERROR: Event %s admission at %.05f~%.05f was observed more than the maximum times %d in test round %d (it was observed %d times)\n", enEventTimeValidation.getKey(), enEventAdmissionEntry.dbTime, enEventAdmissionEntry.dbTolerance, enEventAdmissionEntry.inTestRoundMaximumAdmissions, inCurrentTestRound, enEventAdmissionEntry.inTestRoundAdmissions);

									// The current test round failed
									blTestRoundFailed = true;
								}
							}
						}
					}

					// If the test round did not fail
					if (!blTestRoundFailed) {

						// Test round successful

						// Verifies test round warnings
						if (blTestRoundWarning) {

							// Prints warning
							System.out.printf("WARNING: Test round %d had warnings issued\n", inCurrentTestRound);
						}

						// Prints note
						System.out.printf("NOTE: Test round %d was successful\n", inCurrentTestRound);

						// Increases current test round
						inCurrentTestRound++;

						// Increases the number of successful test rounds
						inSuccessfulTestRounds++;

						// If the limit was reached, the test was successful
						if (inSuccessfulTestRounds >= inExpectedSuccessfulTestRounds) {

							// Test successful flag
							boolean blTestSuccessful = true;

							// Verifies if events' admission frequency was as expected in the test
							for (Map.Entry<String, Set<EventAdmissionEntry>> enEventTimeValidation : mpEventTimeValidation.entrySet()) {
								for (EventAdmissionEntry enEventAdmissionEntry : enEventTimeValidation.getValue()) {
									if (enEventAdmissionEntry.inTestMinimumAdmissions != null) {
										if (enEventAdmissionEntry.inTestAdmissions < enEventAdmissionEntry.inTestMinimumAdmissions) {

											// Prints error
											System.out.printf("ERROR: Event %s admission at %.05f~%.05f was not observed the minimum times %d in the test (it was observed %d times)\n", enEventTimeValidation.getKey(), enEventAdmissionEntry.dbTime, enEventAdmissionEntry.dbTolerance, enEventAdmissionEntry.inTestMinimumAdmissions, enEventAdmissionEntry.inTestAdmissions);

											// Test was unsuccessful
											blTestSuccessful = false;
										}
									}
									if (enEventAdmissionEntry.inTestMaximumAdmissions != null) {
										if (enEventAdmissionEntry.inTestAdmissions > enEventAdmissionEntry.inTestMaximumAdmissions) {

											// Prints error
											System.out.printf("ERROR: Event %s admission at %.05f~%.05f was observed more than the maximum times %d in the test (it was observed %d times)\n", enEventTimeValidation.getKey(), enEventAdmissionEntry.dbTime, enEventAdmissionEntry.dbTolerance, enEventAdmissionEntry.inTestMaximumAdmissions, enEventAdmissionEntry.inTestAdmissions);

											// Test was unsuccessful
											blTestSuccessful = false;
										}
									}
								}
							}

							// Verifies test warnings
							if (blTestWarning) {

								// Prints warning
								System.out.printf("WARNING: Warnings were issued during the test\n");
							}

							// Verifies test's success
							if (!blTestSuccessful) {

								// The test was unsuccessful
								return PROCESSEVENT_UNSUCCESSFUL;

							} else {

								// The test was successful
								return PROCESSEVENT_SUCCESSFUL;
							}
						}
					} else {

						// Test round unsuccessful

						// Verifies test round warnings
						if (blTestRoundWarning) {

							// Prints warning
							System.out.printf("WARNING: Test round %d had warnings issued\n", inCurrentTestRound);
						}

						// Prints note
						System.out.printf("NOTE: Test round %d was unsuccessful\n", inCurrentTestRound);

						// Increases current test round
						inCurrentTestRound++;

						// Increases the number of unsuccessful test rounds
						inUnsuccessfulTestRounds++;

						// If the limit was reached, the test was unsuccessful
						if (inUnsuccessfulTestRounds >= inMaximumUnsuccessfulTestRounds) {
							return PROCESSEVENT_UNSUCCESSFUL;
						}
					}
				}

				// Prints note
				System.out.printf("NOTE: Test round %d starting\n", inCurrentTestRound);

				// Resets all event admission entries for the test round
				for (Map.Entry<String, Set<EventAdmissionEntry>> enEventTimeValidation : mpEventTimeValidation.entrySet()) {
					for (EventAdmissionEntry enEventAdmissionEntry : enEventTimeValidation.getValue()) {
						enEventAdmissionEntry.cmdResetTestRound();
					}
				}

				// Marks test round as running
				blTestRoundRunning = true;
				blTestRoundFailed = false;

				// Initializes test round environment
				blTestRoundWarning = false;
			}
		}

		// Verifies if there is a test round running
		if (blTestRoundRunning) {

			// Verifies major frame duration exceedance
			if (dbTime > dbMajorFrameDuration) {

				// Prints error
				System.out.printf("ERROR: Major frame duration exceeded, review major frame start events\n");

				// The current test round failed
				blTestRoundFailed = true;
			}

			// Validates event expected time
			if (!cmdAdmitEvent(mpEventTimeValidation, stEventDescriptor, dbTime, true)) {

				// The current test round failed
				blTestRoundFailed = true;
			}
		}

		// Proceed with the test
		return PROCESSEVENT_PROCEED;
	}

	/**
	 * Main method.
	 * 
	 * @param args Arguments.
	 */
	public static void main(String[] args) {
		try {

			// Rebuild flag
			boolean blRebuild = false;

			// Repeat flag
			boolean blRepeat = false;

			// Sets locale for number formatting
			Locale.setDefault(new Locale("en", "US"));

			// Gets tests
			List<String> lsTests = Tests.getTests();

			// TODO
			lsTests.clear();
			lsTests.add("001_SLOWPARTITIONSCHEDULING");
//			lsTests.add("002_FASTPARTITIONSCHEDULING");
//			lsTests.add("003_SLOWPROCESSSCHEDULING");
//			lsTests.add("004_FASTPROCESSSCHEDULING");
//			lsTests.add("005_TESTCOUNTERCALIBRATION");
//			lsTests.add("006_RETURNPOINT");
//			lsTests.add("007_SYSTEMPARTITION");

			// Sorts tests
			Collections.sort(lsTests);

			// Repetition loop
			lpRepeat: do {

				// Iterates tests
				Iterator<String> itTest = lsTests.iterator();
				while (itTest.hasNext()) {

					// Gets next test
					String stTest = itTest.next();

					// Test starting
					System.out.println("Test " + stTest + " starting...");

					// Output file
					File flOutput = new File("Test/Output/ARMV7A_AM335X/" + stTest + "_APP_XMODEM");

					// Verifies rebuilding
					if (blRebuild || !flOutput.exists()) {

						// Builds test
						Tests.cmdBuildTest(stTest);
					}

					// Verifies output file
					if (!flOutput.exists()) {
						throw new RuntimeException("Test output file '" + flOutput + "' does not exist");
					}

					// Resets device
					{

						// Creates serial port
						NativeSerialPortWindows spSerialPort = new NativeSerialPortWindows(Tests.stARMV7A_AM335X_SerialPort);

						// Sets attributes
						spSerialPort.setBaudRate(115200);
						spSerialPort.setDataBits(8);
						spSerialPort.setParity(NativeSerialPortWindows.PARITY_NOPARITY);
						spSerialPort.setStopBits(NativeSerialPortWindows.STOPBITS_1);

						// Opens serial port
						spSerialPort.cmdOpen();
						try {

							// Sends reset character
							System.out.printf("Resetting the device...\n");
							spSerialPort.getOutputStream().write(0);

							// Waits for reset
							int inCharacter;
							do {
								inCharacter = spSerialPort.getInputStream().read();
							} while ((inCharacter != -1) && (inCharacter != 'C'));
						} finally {

							// Closes serial port
							spSerialPort.cmdClose();
						}
					}

					// Sleeps
					Thread.sleep(1000);

					// Writes bootloader
					{

						// Creates serial port
						NativeSerialPortWindows spSerialPort = new NativeSerialPortWindows(Tests.stARMV7A_AM335X_SerialPort);

						// Sets attributes
						spSerialPort.setBaudRate(115200);
						spSerialPort.setDataBits(8);
						spSerialPort.setParity(NativeSerialPortWindows.PARITY_NOPARITY);
						spSerialPort.setStopBits(NativeSerialPortWindows.STOPBITS_1);

						// Opens serial port
						spSerialPort.cmdOpen();
						try {

							// Sends bootloader using XModem
							System.out.printf("Sending bootloader...\n");
							if (!new XModem(spSerialPort.getInputStream(), spSerialPort.getOutputStream()).cmdSend(new File(Tests.flARINC653Directory, "/MLO_XMODEM"), XModemMode.XMODEM1K, 50)) {
								throw new RuntimeException("Bootloader sending failed");
							}
						} finally {

							// Closes serial port
							spSerialPort.cmdClose();
						}
					}

					// Sleeps
					Thread.sleep(500);

					// Writes application
					{

						// Creates serial port
						NativeSerialPortWindows spSerialPort = new NativeSerialPortWindows(Tests.stARMV7A_AM335X_SerialPort);

						// Sets attributes
						spSerialPort.setBaudRate(230400);
						spSerialPort.setDataBits(8);
						spSerialPort.setParity(NativeSerialPortWindows.PARITY_NOPARITY);
						spSerialPort.setStopBits(NativeSerialPortWindows.STOPBITS_1);

						// Opens serial port
						spSerialPort.cmdOpen();
						try {

							// Sends application using XModem
							System.out.printf("Sending application...\n");
							if (!new XModem(spSerialPort.getInputStream(), spSerialPort.getOutputStream()).cmdSend(flOutput, XModemMode.XMODEM1K, 50)) {
								throw new RuntimeException("Bootloader sending failed");
							}
						} finally {

							// Closes serial port
							spSerialPort.cmdClose();
						}
					}

					// Reads test output
					{

						// Creates serial port
						NativeSerialPortWindows spSerialPort = new NativeSerialPortWindows(Tests.stARMV7A_AM335X_SerialPort);

						// Sets attributes
						spSerialPort.setBaudRate(230400);
						spSerialPort.setDataBits(8);
						spSerialPort.setParity(NativeSerialPortWindows.PARITY_NOPARITY);
						spSerialPort.setStopBits(NativeSerialPortWindows.STOPBITS_1);

						// Opens serial port
						spSerialPort.cmdOpen();
						try {

							// Validates test output
							System.out.printf("Validating test output...\n");

							// Creates reader
							BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(spSerialPort.getInputStream()));
							try {

								// Test file
								File flTestFile = new File("Test/Verification/" + stTest);

								// Loads test file
								if (!cmdLoadTestFile(flTestFile)) {
									throw new RuntimeException("Test file '" + flTestFile + "' could not be loaded");
								}

								// Initializes test environment
								dbTestRoundMajorFrameZeroTime = 0;
								blTestRoundRunning = false;
								blTestRoundFailed = false;
								inCurrentTestRound = 1;
								inSuccessfulTestRounds = 0;
								inUnsuccessfulTestRounds = 0;
								blTestWarning = false;
								blTestRoundWarning = false;

								// Resets all event admission entries for the test
								for (Map.Entry<String, Set<EventAdmissionEntry>> enEventTimeValidation : mpEventTimeValidation.entrySet()) {
									for (EventAdmissionEntry enEventAdmissionEntry : enEventTimeValidation.getValue()) {
										enEventAdmissionEntry.cmdResetTest();
									}
								}

								// Result
								int inResult;

								// Reads test output
								while (true) {

									// Reads next line
									String stLine = brBufferedReader.readLine();

									// Processes event
									inResult = cmdProcessEvent(stLine);

									// Verifies result
									if (inResult != PROCESSEVENT_PROCEED) {
										break;
									}
								}

								// Verifies result
								if (inResult == PROCESSEVENT_UNSUCCESSFUL) {

									// Test failed
									System.out.println("Test " + stTest + " failed.");
									break lpRepeat;
								}
							} finally {
								// Closes reader
								brBufferedReader.close();
							}
						} finally {

							// Closes serial port
							spSerialPort.cmdClose();
						}
					}

					// Test finished
					System.out.println("Test " + stTest + " finished.");

					// Sleeps
					Thread.sleep(1000);
				}
			} while (blRepeat);
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}
