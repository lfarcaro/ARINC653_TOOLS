package arinc653.templatemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Mask.
 * 
 * @author Luís Fernando Arcaro
 */
public class Mask {

	/**
	 * Snippet map.
	 */
	private Map<String, Snippet> mpSnippet = new HashMap<String, Snippet>();

	/**
	 * Snippet names getter.
	 */
	public Set<String> getSnippetNames() {
		return mpSnippet.keySet();
	}

	/**
	 * Snippet getter.
	 */
	public Snippet getSnippet(String stSnippet) {
		return mpSnippet.get(stSnippet);
	}

	/**
	 * Snippet setter.
	 */
	public void setSnippet(String stSnippet, Snippet snSnippet) {
		if (snSnippet != null) {
			mpSnippet.put(stSnippet, snSnippet);
		} else {
			mpSnippet.remove(stSnippet);
		}
	}

	/**
	 * Empty verifier.
	 */
	public boolean isEmpty() {
		return mpSnippet.isEmpty();
	}

	/**
	 * Snippet existence verifier.
	 */
	public boolean hasSnippet(String stSnippet) {
		return mpSnippet.containsKey(stSnippet);
	}

	/**
	 * Generate unused snippet method.
	 */
	public String cmdGenerateSnippet() {

		// Next snippet
		int inNextSnippet = 1;

		// Snippet
		String stSnippet;
		do {

			// Sets snippet
			stSnippet = Integer.toString(inNextSnippet++);
		} while (mpSnippet.containsKey(stSnippet));

		// Returns snippet
		return stSnippet;
	}

	/**
	 * Expand method.
	 * 
	 * @param lnLanguage
	 *            Language.
	 * @param flFile
	 *            File.
	 * @param flOutputFile
	 *            Output file.
	 * @param stArtifactName
	 *            Artifact name.
	 */
	public void cmdExpand(Language lnLanguage, File flFile, File flOutputFile, String stArtifactName) throws IOException {

		// Verbose output
		if (TemplateManager.isVerbose()) {
			System.out.println("Expanding file '" + flFile + "'");
		}

		// Compiles patterns
		Pattern ptSnippet = Pattern.compile(lnLanguage.getArtifactSnippetPattern(stArtifactName));

		// File
		List<String> lsFile = new LinkedList<String>();

		// Changed flag
		boolean blChanged = false;

		// Creates reader
		BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(flFile)));
		try {

			// Read loop
			while (true) {

				// Reads line
				String stLine = brBufferedReader.readLine();

				// Verifies line
				if (stLine == null) {
					break;
				}

				// Verifies snippet
				Matcher mtSnippetMatcher = ptSnippet.matcher(stLine);
				if (mtSnippetMatcher.matches()) {

					// Snippet indentation
					String stSnippetIndentation = mtSnippetMatcher.group(1);

					// Snippet name
					String stSnippetName = mtSnippetMatcher.group(2);

					// Snippet
					Snippet snSnippet;

					// Gets snippet
					snSnippet = getSnippet(stSnippetName);

					// Verifies snippet
					if (snSnippet == null) {

						// Notifies
						System.out.println("Using empty snippet '" + stSnippetName + "' because it is not declared in the mask");
					}

					// Adds to file
					lsFile.add(lnLanguage.getArtifactSnippetStart(stSnippetIndentation, stArtifactName, stSnippetName));

					// Verifies snippet
					if (snSnippet != null) {

						// Adds snippet
						lsFile.addAll(snSnippet.getValue());
					}

					// Adds to file
					lsFile.add(lnLanguage.getArtifactSnippetEnd(stSnippetIndentation, stArtifactName, stSnippetName));

					// Sets changed flag
					blChanged = true;
					continue;
				}

				// Adds to file
				lsFile.add(stLine);
			}
		} finally {

			// Closes reader
			brBufferedReader.close();
		}

		// Verifies changed flag and output file
		if ((blChanged) && (flOutputFile != null)) {

			// Verifies parent directory
			if (!flOutputFile.getCanonicalFile().getParentFile().exists()) {

				// Creates parent directory
				flOutputFile.getCanonicalFile().getParentFile().mkdirs();
			}

			// Creates writer
			PrintWriter pwPrintWriter = new PrintWriter(flOutputFile);
			try {

				// Iterates file
				Iterator<String> itFile = lsFile.iterator();
				while (itFile.hasNext()) {

					// Writes file
					pwPrintWriter.print(itFile.next() + "\n");
				}
			} finally {

				// Closes writer
				pwPrintWriter.close();
			}
		}
	}

	/**
	 * Expand method.
	 * 
	 * @param lnLanguage
	 *            Language.
	 * @param flFile
	 *            File.
	 * @param flOutputFile
	 *            Output file.
	 */
	public void cmdExpand(Language lnLanguage, File flFile, File flOutputFile) throws IOException {
		cmdExpand(lnLanguage, flFile, flOutputFile, null);
	}

	/**
	 * Collapse method.
	 * 
	 * @param lnLanguage
	 *            Language.
	 * @param flFile
	 *            File.
	 * @param flOutputFile
	 *            Output file.
	 * @param stArtifactName
	 *            Artifact name.
	 */
	public void cmdCollapse(Language lnLanguage, File flFile, File flOutputFile, String stArtifactName) throws IOException {

		// Verbose output
		if (TemplateManager.isVerbose()) {
			System.out.println("Collapsing file '" + flFile + "'");
		}

		// Compiles patterns
		Pattern ptSnippetStart = Pattern.compile(lnLanguage.getArtifactSnippetStartPattern(stArtifactName));
		Pattern ptSnippetEnd = Pattern.compile(lnLanguage.getArtifactSnippetEndPattern(stArtifactName));

		// File
		List<String> lsFile = new LinkedList<String>();

		// Creates reader
		BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(flFile)));
		try {

			// Snippet
			Snippet snSnippet = null;

			// Snippet indentation
			String stSnippetIndentation = null;

			// Snippet name
			String stSnippetName = null;

			// Read loop
			while (true) {

				// Reads line
				String stLine = brBufferedReader.readLine();

				// Verifies line
				if (stLine == null) {
					break;
				}

				// Verifies snippet
				if (snSnippet != null) {

					// Verifies snippet end
					Matcher mtSnippetEndMatcher = ptSnippetEnd.matcher(stLine);
					if (mtSnippetEndMatcher.matches()) {

						// Verifies group count
						if (mtSnippetEndMatcher.groupCount() > 1) {

							// Verifies snippet name
							if (mtSnippetEndMatcher.group(2) != null) {

								// Compares snippet start and end names
								if (!mtSnippetEndMatcher.group(2).equals(stSnippetName)) {
									throw new RuntimeException("Snippets starts and ends with different identifiers '" + stSnippetName + "' and '" + mtSnippetEndMatcher.group(2) + "'");
								}
							}
						}

						// Verifies snippet
						if (hasSnippet(stSnippetName)) {

							// Gets snippet
							Snippet snExistingSnippet = getSnippet(stSnippetName);

							// Compares snippets values
							if (!snExistingSnippet.getValue().equals(snSnippet.getValue())) {
								throw new RuntimeException("Snippets with same identifier '" + stSnippetName + "' but with different content");
							}
						}

						// Sets snippet
						setSnippet(stSnippetName, snSnippet);

						// Adds to file
						lsFile.add(lnLanguage.getArtifactSnippet(stSnippetIndentation, stArtifactName, stSnippetName));

						// Ends snippet
						snSnippet = null;
						continue;
					}

					// Adds to snippet value
					snSnippet.getValue().add(stLine);
					continue;
				}

				// Verifies snippet start
				Matcher mtSnippetStartMatcher = ptSnippetStart.matcher(stLine);
				if (mtSnippetStartMatcher.matches()) {

					// Sets snippet indentation
					stSnippetIndentation = mtSnippetStartMatcher.group(1);

					// Sets snippet name
					stSnippetName = (mtSnippetStartMatcher.groupCount() > 1 ? (mtSnippetStartMatcher.group(2) != null ? mtSnippetStartMatcher.group(2) : cmdGenerateSnippet()) : cmdGenerateSnippet());

					// Creates snippet
					snSnippet = new Snippet();
					continue;
				}

				// Adds to file
				lsFile.add(stLine);
			}

			// Verifies snippet
			if (snSnippet != null) {
				throw new RuntimeException("File '" + flFile.getName() + "' ends with open snippet '" + stSnippetName + "'");
			}
		} finally {

			// Closes reader
			brBufferedReader.close();
		}

		// Verifies mask and output file
		if ((!isEmpty()) && (flOutputFile != null)) {

			// Verifies parent directory
			if (!flOutputFile.getCanonicalFile().getParentFile().exists()) {

				// Creates parent directory
				flOutputFile.getCanonicalFile().getParentFile().mkdirs();
			}

			// Creates writer
			PrintWriter pwPrintWriter = new PrintWriter(flOutputFile);
			try {

				// Iterates file
				Iterator<String> itFile = lsFile.iterator();
				while (itFile.hasNext()) {

					// Writes file
					pwPrintWriter.print(itFile.next() + "\n");
				}
			} finally {

				// Closes writer
				pwPrintWriter.close();
			}
		}
	}

	/**
	 * Collapse method.
	 * 
	 * @param lnLanguage
	 *            Language.
	 * @param flFile
	 *            File.
	 * @param flOutputFile
	 *            Output file.
	 */
	public void cmdCollapse(Language lnLanguage, File flFile, File flOutputFile) throws IOException {
		cmdCollapse(lnLanguage, flFile, flOutputFile, null);
	}

	/**
	 * Load method.
	 * 
	 * @param flMask
	 *            Mask.
	 */
	public static Mask cmdLoad(File flMask) throws IOException {

		// Compiles patterns
		Pattern ptSnippetStart = Pattern.compile("^" + Pattern.quote("SNIPPET_START ") + "(.+)$");
		Pattern ptSnippetEnd = Pattern.compile("^" + Pattern.quote("SNIPPET_END") + "$");

		// Verifies mask
		if (!flMask.isFile()) {
			throw new FileNotFoundException(flMask.getAbsolutePath());
		}

		// Creates mask
		Mask msMask = new Mask();

		// Creates reader
		BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(flMask)));
		try {

			// Reads header
			String stHeader = brBufferedReader.readLine();

			// Verifies header
			if (stHeader == null) {
				throw new RuntimeException("Empty mask");
			}

			// Verifies header
			if (!"MASK_START".equals(stHeader)) {
				throw new RuntimeException("Invalid mask");
			}

			// Snippet
			Snippet snSnippet = null;

			// Snippet name
			String stSnippetName = null;

			// Finished flag
			boolean blFinished = false;

			// Read loop
			while (true) {

				// Reads line
				String stLine = brBufferedReader.readLine();

				// Verifies line
				if (stLine == null) {
					break;
				}

				// Verifies snippet
				if (snSnippet != null) {

					// Verifies snippet end
					Matcher mtSnippetEnd = ptSnippetEnd.matcher(stLine);
					if (mtSnippetEnd.matches()) {

						// Sets snippet
						msMask.setSnippet(stSnippetName, snSnippet);

						// Ends snippet
						snSnippet = null;
						continue;
					}

					// Adds to snippet value
					snSnippet.getValue().add(stLine);
					continue;
				}

				// Verifies snippet start
				Matcher mtSnippetStartMatcher = ptSnippetStart.matcher(stLine);
				if (mtSnippetStartMatcher.matches()) {

					// Sets snippet name
					stSnippetName = mtSnippetStartMatcher.group(1);

					// Creates snippet
					snSnippet = new Snippet();
					continue;
				}

				// Verifies mask end
				if ("MASK_END".equals(stLine)) {

					// Sets finished flag
					blFinished = true;
					break;
				}
			}

			// Verifies finished flag
			if (!blFinished) {
				throw new RuntimeException("Corrupted mask");
			}
		} finally {

			// Closes reader
			brBufferedReader.close();
		}

		// Returns mask
		return msMask;
	}

	/**
	 * Save method.
	 * 
	 * @param msMask
	 *            Mask.
	 * @param flMask
	 *            Mask.
	 */
	public static void cmdSave(Mask msMask, File flMask) throws IOException {

		// Verifies parent directory
		if (!flMask.getCanonicalFile().getParentFile().exists()) {

			// Creates parent directory
			flMask.getCanonicalFile().getParentFile().mkdirs();
		}

		// Creates writer
		PrintWriter pwPrintWriter = new PrintWriter(flMask);
		try {

			// Writes header
			pwPrintWriter.print("MASK_START" + "\n");

			// Creates snippet name list
			List<String> lsSnippetName = new LinkedList<String>(msMask.getSnippetNames());

			// Sorts snippet name list
			Collections.sort(lsSnippetName);

			// Iterates snippet names
			Iterator<String> itSnippetName = lsSnippetName.iterator();
			while (itSnippetName.hasNext()) {

				// Gets next snippet name
				String stSnippetName = itSnippetName.next();

				// Gets snippet
				Snippet snSnippet = msMask.getSnippet(stSnippetName);

				// Writes snippet
				pwPrintWriter.print("SNIPPET_START " + stSnippetName + "\n");

				// Iterates snippet
				Iterator<String> itSnippet = snSnippet.getValue().iterator();
				while (itSnippet.hasNext()) {

					// Writes snippet
					pwPrintWriter.print(itSnippet.next() + "\n");
				}

				// Writes snippet
				pwPrintWriter.print("SNIPPET_END" + "\n");
			}

			// Writes mask
			pwPrintWriter.print("MASK_END" + "\n");
		} finally {

			// Closes writer
			pwPrintWriter.close();
		}
	}

	/**
	 * Merge method.
	 * 
	 * @param msMasks
	 *            Masks to merge.
	 */
	public static Mask cmdMerge(Mask... msMasks) {

		// Creates mask
		Mask msMask = new Mask();

		// Iterates masks
		for (int i = 0; i < msMasks.length; i++) {

			// Iterates snippet names
			Iterator<String> itSnippetName = msMasks[i].getSnippetNames().iterator();
			while (itSnippetName.hasNext()) {

				// Gets next snippet name
				String stSnippetName = itSnippetName.next();

				// Gets snippet
				Snippet snSnippet = msMasks[i].getSnippet(stSnippetName);

				// Gets existing snippet
				Snippet snExistingSnippet = msMask.getSnippet(stSnippetName);

				// Verifies existing snippet
				if (snExistingSnippet == null) {

					// Sets snippet
					msMask.setSnippet(stSnippetName, snSnippet.cmdClone());
				} else if (!snExistingSnippet.getValue().equals(snSnippet.getValue())) {

					// Shows warning
					System.err.println("Snippets with same name '" + stSnippetName + "' but with different content found");
				}
			}
		}

		// Returns mask
		return msMask;
	}
}