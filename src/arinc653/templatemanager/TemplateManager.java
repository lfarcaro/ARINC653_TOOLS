package arinc653.templatemanager;

import java.io.File;

/**
 * Template manager.
 * 
 * @author Luís Fernando Arcaro
 */
public class TemplateManager {

	/**
	 * Verbose flag.
	 */
	private static boolean blVerbose = false;

	/**
	 * Verbose setter.
	 */
	public static void setVerbose(boolean blVerbose) {
		TemplateManager.blVerbose = blVerbose;
	}

	/**
	 * Verbose getter.
	 */
	public static boolean isVerbose() {
		return blVerbose;
	}

	/**
	 * Show usage method.
	 */
	private static void cmdShowUsage() {

		// Shows usage
		System.out.println("Usage:");
		System.out.println(TemplateManager.class.getSimpleName() + " <LANGUAGE> <OPERATION> <PATH> <TEMPLATE> <INCLUDE_PATTERN> <EXCLUDE_PATTERN> <WRITE>");
		System.out.println();
		System.out.println("Arguments:");
		System.out.println("\tLANGUAGE - C, XML or LATEX");
		System.out.println("\tOPERATION - EXPAND to expand a template");
		System.out.println("\t            COLLAPSE to collapse a template");
		System.out.println("\tPATH - Path to a directory or a file to operate");
		System.out.println("\tTEMPLATE - Template file used in operation");
		System.out.println("\tINCLUDE_PATTERN - Regular expression to include (select) files");
		System.out.println("\tEXCLUDE_PATTERN - Regular expression to exclude (ignore) files");
		System.out.println("\tWRITE - YES to write changes into affected files");
		System.out.println("\t        NO to keep affected files unchanged");
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {
		try {

			// Verifies arguments
			if (args.length != 7) {

				// Shows usage
				cmdShowUsage();
				return;
			}

			// Index
			int inIndex = 0;

			// Gets language
			String stLanguage = args[inIndex++];

			// Verifies language
			if ((!"C".equals(stLanguage)) && (!"XML".equals(stLanguage)) && (!"LATEX".equals(stLanguage))) {

				// Error
				System.err.println("Language must be C, XML or LATEX");
				return;
			}

			// Gets operation
			String stOperation = args[inIndex++];

			// Verifies operation
			if ((!"EXPAND".equals(stOperation)) && (!"COLLAPSE".equals(stOperation))) {

				// Error
				System.err.println("Operation must be EXPAND or COLLAPSE");
				return;
			}

			// Gets path
			File flPath = new File(args[inIndex++]);

			// Verifies path
			if ((!flPath.isDirectory()) && (!flPath.isFile())) {

				// Error
				System.err.println("Path does not exist");
				return;
			}

			// Gets template
			File flTemplate = new File(args[inIndex++]);

			// Verifies template
			if (flTemplate.isDirectory()) {

				// Error
				System.err.println("Template is a directory");
				return;
			}

			// Include pattern
			String stIncludePattern = args[inIndex++];

			// Exclude pattern
			String stExcludePattern = args[inIndex++];

			// Write flag
			boolean blWrite = "YES".equals(args[inIndex++]);

			// Message
			System.out.println("Include pattern: '" + stIncludePattern + "'");
			System.out.println("Exclude pattern: '" + stExcludePattern + "'");

			// Language
			Language lnLanguage = null;

			// Verifies language
			if ("C".equals(stLanguage)) {
				lnLanguage = Language_C.INSTANCE;
			} else if ("XML".equals(stLanguage)) {
				lnLanguage = Language_XML.INSTANCE;
			} else if ("LATEX".equals(stLanguage)) {
				lnLanguage = Language_LaTeX.INSTANCE;
			}

			// Sets verbose flag
			TemplateManager.setVerbose(true);

			// Verifies operation
			if ("EXPAND".equals(stOperation)) {

				// Verifies path
				if (flPath.isDirectory()) {

					// Verbose output
					if (TemplateManager.isVerbose()) {
						System.out.println("Loading template (artifact) '" + flTemplate + "'");
					}

					// Loads artifact
					Artifact arArtifact = Artifact.cmdLoad(null, flTemplate);

					// Expands
					arArtifact.cmdExpand(lnLanguage, flPath, stIncludePattern, stExcludePattern, blWrite);
				} else if (flPath.isFile()) {

					// Verbose output
					if (TemplateManager.isVerbose()) {
						System.out.println("Loading template (mask) '" + flTemplate + "'");
					}

					// Loads mask
					Mask msMask = Mask.cmdLoad(flTemplate);

					// Expands
					msMask.cmdExpand(lnLanguage, flPath, (blWrite ? flPath : null));
				}
			} else if ("COLLAPSE".equals(stOperation)) {

				// Verifies path
				if (flPath.isDirectory()) {

					// Creates artifact
					Artifact arArtifact = new Artifact(null);

					// Collapses
					arArtifact.cmdCollapse(lnLanguage, flPath, stIncludePattern, stExcludePattern, blWrite);

					// Verbose output
					if (TemplateManager.isVerbose()) {
						System.out.println("Saving template (artifact) '" + flTemplate + "'");
					}

					// Saves template
					Artifact.cmdSave(arArtifact, flTemplate);
				} else if (flPath.isFile()) {

					// Creates mask
					Mask msMask = new Mask();

					// Collapses
					msMask.cmdCollapse(lnLanguage, flPath, (blWrite ? flPath : null));

					// Verbose output
					if (TemplateManager.isVerbose()) {
						System.out.println("Saving template (mask) '" + flTemplate + "'");
					}

					// Saves template
					Mask.cmdSave(msMask, flTemplate);
				}
			}
		} catch (Throwable t) {

			// Shows throwable
			t.printStackTrace();
		}
	}
}