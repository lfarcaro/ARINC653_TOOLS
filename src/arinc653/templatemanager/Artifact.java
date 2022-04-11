package arinc653.templatemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
 * Artifact.
 * 
 * @author Luís Fernando Arcaro
 */
public class Artifact {

	/**
	 * Name.
	 */
	private String stName;

	/**
	 * Mask map.
	 */
	private Map<String, Mask> mpMask = new HashMap<String, Mask>();

	/**
	 * Constructor.
	 * 
	 * @param stName
	 *            Name.
	 */
	public Artifact(String stName) {
		this.stName = stName;
	}

	/**
	 * Name getter.
	 */
	public String getName() {
		return stName;
	}

	/**
	 * Name setter.
	 */
	public void setName(String stName) {
		this.stName = stName;
	}

	/**
	 * Mask names getter.
	 */
	public Set<String> getMaskNames() {
		return mpMask.keySet();
	}

	/**
	 * Mask getter.
	 * 
	 * @param flBaseDirectory
	 *            Base directory.
	 * @param flFile
	 *            File.
	 * @param blCreate
	 *            Create flag.
	 */
	public Mask getMask(File flBaseDirectory, File flFile, boolean blCreate) throws IOException {
		return getMask(getMaskName(flBaseDirectory, flFile), blCreate);
	}

	/**
	 * Mask getter.
	 * 
	 * @param stMask
	 *            Mask.
	 * @param blCreate
	 *            Create flag.
	 */
	public Mask getMask(String stMask, boolean blCreate) {

		// Prepares mask name
		stMask = stMask.replace('\\', '/');

		// Verifies mask name
		if (stMask.startsWith("/")) {
			stMask = stMask.substring(1);
		}

		// Gets mask
		Mask msMask = mpMask.get(stMask);

		// Verifies mask and create flag
		if ((msMask == null) && (blCreate)) {

			// Creates mask
			msMask = new Mask();

			// Sets mask
			setMask(stMask, msMask);
		}

		// Returns mask
		return msMask;
	}

	/**
	 * Mask setter.
	 * 
	 * @param stMask
	 *            Mask.
	 * @param msMask
	 *            Mask.
	 */
	public void setMask(String stMask, Mask msMask) {
		mpMask.put(stMask, msMask);
	}

	/**
	 * Mask name getter.
	 * 
	 * @param flBaseDirectory
	 *            Base directory.
	 * @param flFile
	 *            File.
	 */
	public static String getMaskName(File flBaseDirectory, File flFile) throws IOException {

		// Gets canonical paths
		String stBaseDirectory = flBaseDirectory.getCanonicalPath();
		String stMask = flFile.getCanonicalPath();

		// Verifies paths
		if (!stMask.startsWith(stBaseDirectory)) {
			throw new RuntimeException("Mask is not contained in base directory");
		}

		// Prepares mask name
		String stMaskName = stMask.substring(stBaseDirectory.length()).replace('\\', '/');

		// Verifies mask name
		if (stMaskName.startsWith("/")) {
			return stMaskName.substring(1);
		} else {
			return stMaskName;
		}
	}

	/**
	 * Expand method.
	 * 
	 * @param lnLanguage
	 *            Language.
	 * @param flBaseDirectory
	 *            Base directory.
	 * @param flDirectory
	 *            Directory.
	 * @param stIncludeFileNamePattern
	 *            Include file name pattern.
	 * @param stExcludeFileNamePattern
	 *            Exclude file name pattern.
	 * @param blWrite
	 *            Write flag.
	 */
	private void cmdExpand(Language lnLanguage, File flBaseDirectory, File flDirectory, String stIncludeFileNamePattern, String stExcludeFileNamePattern, boolean blWrite) throws IOException {

		// Verbose output
		if (TemplateManager.isVerbose()) {
			System.out.println("Expanding directory '" + flDirectory + "'");
		}

		// Gets files
		File[] flFiles = flDirectory.listFiles();

		// Iterates files
		for (int i = 0; i < flFiles.length; i++) {

			// Verifies directory
			if (flFiles[i].isDirectory()) {

				// Expands directory
				cmdExpand(lnLanguage, flBaseDirectory, flFiles[i], stIncludeFileNamePattern, stExcludeFileNamePattern, blWrite);
				continue;
			}

			// Verifies include file name pattern
			if (stIncludeFileNamePattern != null) {

				// Matches include file name pattern
				if (!flFiles[i].getName().matches(stIncludeFileNamePattern)) {

					// Verbose output
					if (TemplateManager.isVerbose()) {
						System.out.println("File '" + flFiles[i] + "' does not match include pattern");
					}
					continue;
				}
			}

			// Verifies exclude file name pattern
			if (stExcludeFileNamePattern != null) {

				// Matches exclude file name pattern
				if (flFiles[i].getName().matches(stExcludeFileNamePattern)) {

					// Verbose output
					if (TemplateManager.isVerbose()) {
						System.out.println("File '" + flFiles[i] + "' does match exclude pattern");
					}
					continue;
				}
			}

			// Gets mask
			Mask msMask = getMask(flBaseDirectory, flFiles[i], true);

			// Expands
			msMask.cmdExpand(lnLanguage, flFiles[i], (blWrite ? flFiles[i] : null), getName());
		}
	}

	/**
	 * Expand method.
	 * 
	 * @param lnLanguage
	 *            Language.
	 * @param flDirectory
	 *            Directory.
	 * @param stIncludeFileNamePattern
	 *            Include file name pattern.
	 * @param stExcludeFileNamePattern
	 *            Exclude file name pattern.
	 * @param blWrite
	 *            Write flag.
	 */
	public void cmdExpand(Language lnLanguage, File flDirectory, String stIncludeFileNamePattern, String stExcludeFileNamePattern, boolean blWrite) throws IOException {
		cmdExpand(lnLanguage, flDirectory, flDirectory, stIncludeFileNamePattern, stExcludeFileNamePattern, blWrite);
	}

	/**
	 * Collapse method.
	 * 
	 * @param lnLanguage
	 *            Language.
	 * @param flBaseDirectory
	 *            Base directory.
	 * @param flDirectory
	 *            Directory.
	 * @param stIncludeFileNamePattern
	 *            Include file name pattern.
	 * @param stExcludeFileNamePattern
	 *            Exclude file name pattern.
	 * @param blWrite
	 *            Write flag.
	 */
	private void cmdCollapse(Language lnLanguage, File flBaseDirectory, File flDirectory, String stIncludeFileNamePattern, String stExcludeFileNamePattern, boolean blWrite) throws IOException {

		// Verbose output
		if (TemplateManager.isVerbose()) {
			System.out.println("Collapsing directory '" + flDirectory + "'");
		}

		// Gets files
		File[] flFiles = flDirectory.listFiles();

		// Iterates files
		for (int i = 0; i < flFiles.length; i++) {

			// Verifies directory
			if (flFiles[i].isDirectory()) {

				// Collapses directory
				cmdCollapse(lnLanguage, flBaseDirectory, flFiles[i], stIncludeFileNamePattern, stExcludeFileNamePattern, blWrite);
				continue;
			}

			// Verifies include file name pattern
			if (stIncludeFileNamePattern != null) {

				// Matches include file name pattern
				if (!flFiles[i].getName().matches(stIncludeFileNamePattern)) {

					// Verbose output
					if (TemplateManager.isVerbose()) {
						System.out.println("File '" + flFiles[i] + "' does not match include pattern");
					}
					continue;
				}
			}

			// Verifies exclude file name pattern
			if (stExcludeFileNamePattern != null) {

				// Matches exclude file name pattern
				if (flFiles[i].getName().matches(stExcludeFileNamePattern)) {

					// Verbose output
					if (TemplateManager.isVerbose()) {
						System.out.println("File '" + flFiles[i] + "' does match exclude pattern");
					}
					continue;
				}
			}

			// Creates mask
			Mask msMask = new Mask();

			// Collapses
			msMask.cmdCollapse(lnLanguage, flFiles[i], (blWrite ? flFiles[i] : null), getName());

			// Verifies mask
			if (!msMask.isEmpty()) {

				// Sets mask
				setMask(Artifact.getMaskName(flBaseDirectory, flFiles[i]), msMask);
			}
		}
	}

	/**
	 * Collapse method.
	 * 
	 * @param lnLanguage
	 *            Language.
	 * @param flDirectory
	 *            Directory.
	 * @param stIncludeFileNamePattern
	 *            Include file name pattern.
	 * @param stExcludeFileNamePattern
	 *            Exclude file name pattern.
	 * @param blWrite
	 *            Write flag.
	 */
	public void cmdCollapse(Language lnLanguage, File flDirectory, String stIncludeFileNamePattern, String stExcludeFileNamePattern, boolean blWrite) throws IOException {
		cmdCollapse(lnLanguage, flDirectory, flDirectory, stIncludeFileNamePattern, stExcludeFileNamePattern, blWrite);
	}

	/**
	 * Load method.
	 * 
	 * @param stName
	 *            Name.
	 * @param flArtifact
	 *            Artifact.
	 */
	public static Artifact cmdLoad(String stName, File flArtifact) throws IOException {

		// Compiles patterns
		Pattern ptMaskStart = Pattern.compile("^" + Pattern.quote("MASK_START ") + "(.+)$");
		Pattern ptSnippetStart = Pattern.compile("^" + Pattern.quote("SNIPPET_START ") + "(.+)$");
		Pattern ptSnippetEnd = Pattern.compile("^" + Pattern.quote("SNIPPET_END") + "$");
		Pattern ptMaskEnd = Pattern.compile("^" + Pattern.quote("MASK_END") + "$");

		// Verifies mask
		if (!flArtifact.isFile()) {

			// Creates artifact
			return new Artifact(stName);
		}

		// Creates artifact
		Artifact arArtifact = new Artifact(stName);

		// Creates reader
		BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(flArtifact)));
		try {

			// Reads header
			String stHeader = brBufferedReader.readLine();

			// Verifies header
			if (stHeader == null) {
				throw new RuntimeException("Empty mask");
			}

			// Verifies header
			if (!"ARTIFACT_START".equals(stHeader)) {
				throw new RuntimeException("Invalid mask");
			}

			// Mask
			Mask msMask = null;

			// Mask name
			String stMaskName = null;

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

				// Verifies mask
				if (msMask != null) {

					// Verifies mask end
					Matcher mtMaskEnd = ptMaskEnd.matcher(stLine);
					if (mtMaskEnd.matches()) {

						// Verifies empty mask
						if (!msMask.isEmpty()) {

							// Sets mask
							arArtifact.setMask(stMaskName, msMask);
						}

						// Ends mask
						msMask = null;
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
				}

				// Verifies mask start
				Matcher mtMaskStartMatcher = ptMaskStart.matcher(stLine);
				if (mtMaskStartMatcher.matches()) {

					// Sets mask name
					stMaskName = mtMaskStartMatcher.group(1);

					// Creates mask
					msMask = new Mask();
					continue;
				}

				// Verifies artifact end
				if ("ARTIFACT_END".equals(stLine)) {

					// Sets finished flag
					blFinished = true;
					break;
				}
			}

			// Verifies finished flag
			if (!blFinished) {
				throw new RuntimeException("Corrupted artifact");
			}
		} finally {

			// Closes reader
			brBufferedReader.close();
		}

		// Returns artifact
		return arArtifact;
	}

	/**
	 * Save method.
	 * 
	 * @param arArtifact
	 *            Artifact.
	 * @param flArtifact
	 *            Artifact.
	 */
	public static void cmdSave(Artifact arArtifact, File flArtifact) throws IOException {

		// Verifies parent directory
		if (!flArtifact.getCanonicalFile().getParentFile().exists()) {

			// Creates parent directory
			flArtifact.getCanonicalFile().getParentFile().mkdirs();
		}

		// Creates writer
		PrintWriter pwPrintWriter = new PrintWriter(flArtifact);
		try {

			// Writes header
			pwPrintWriter.print("ARTIFACT_START" + "\n");

			// Creates mask name list
			List<String> lsMaskName = new LinkedList<String>(arArtifact.getMaskNames());

			// Sorts mask name list
			Collections.sort(lsMaskName);

			// Iterates mask names
			Iterator<String> itMaskName = lsMaskName.iterator();
			while (itMaskName.hasNext()) {

				// Gets next mask name
				String stMaskName = itMaskName.next();

				// Gets mask
				Mask msMask = arArtifact.getMask(stMaskName, false);

				// Writes file
				pwPrintWriter.print("MASK_START " + stMaskName + "\n");

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
			}

			// Writes footer
			pwPrintWriter.print("ARTIFACT_END" + "\n");
		} finally {

			// Closes writer
			pwPrintWriter.close();
		}
	}
}