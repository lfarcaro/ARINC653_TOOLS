package arinc653.configuration.parsergenerator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Attribute type - ENUMERATION.
 * 
 * @author Luís Fernando Arcaro
 */
public class AttributeType_ENUMERATION extends AttributeType {

	/**
	 * Values.
	 */
	private String[] stValues;

	/**
	 * Constructor.
	 * 
	 * @param stJavaName
	 *            Java name.
	 * @param stValues
	 *            Values.
	 */
	public AttributeType_ENUMERATION(String stJavaName, String[] stValues) {
		super(stJavaName, "en");

		// Sets attributes
		this.stValues = stValues;
	}

	/**
	 * Add imports method.
	 */
	public void cmdAddImports(ParserGenerator pgParserGenerator, Set<String> stImport) {

		// Adds imports
		stImport.add(pgParserGenerator.stPackage + "." + getJavaName());
	}

	/**
	 * Generate class method.
	 */
	public void cmdGenerateClass(ParserGenerator pgParserGenerator, Attribute atAttribute) throws Throwable {

		// Import set
		Set<String> stImport = new HashSet<String>();

		// Class list
		List<String> lsClass = new LinkedList<String>();

		// Generates
		lsClass.add("/**");
		lsClass.add(" * " + atAttribute.getAttributeType().getJavaName() + " enumeration.");
		lsClass.add(" */");
		lsClass.add("public enum " + atAttribute.getAttributeType().getJavaName() + " {");

		// Values
		StringBuffer sbValues = new StringBuffer();

		// Iterates values
		for (int i = 0; i < stValues.length; i++) {
			sbValues.append(sbValues.length() <= 0 ? "" : ", ").append(stValues[i]);
		}

		// Generates
		lsClass.add("\t" + sbValues);
		lsClass.add("}");

		// Creates file
		PrintWriter pwFile = new PrintWriter(new File(pgParserGenerator.flDirectory, atAttribute.getAttributeType().getJavaName() + ".java"));
		try {

			// Prints
			pwFile.println("package " + pgParserGenerator.stPackage + ";");
			pwFile.println();

			// Verifies imports
			if (!stImport.isEmpty()) {

				// Creates import list
				List<String> lsImport = new LinkedList<String>(stImport);

				// Sorts import list
				Collections.sort(lsImport);

				// Iterates imports
				Iterator<String> itImport = lsImport.iterator();
				while (itImport.hasNext()) {

					// Prints
					pwFile.println("import " + itImport.next() + ";");
				}

				// Prints
				pwFile.println();
			}

			// Iterates class
			Iterator<String> itClass = lsClass.iterator();
			while (itClass.hasNext()) {

				// Prints
				pwFile.println(itClass.next());
			}
		} finally {

			// Closes file
			pwFile.close();
		}
	}

	/**
	 * Generate load method.
	 */
	public void cmdGenerateLoad(ParserGenerator pgParserGenerator, String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport, Attribute atAttribute) {

		// Adds imports
		stImport.add(pgParserGenerator.stResourcesPackage + ".ConfigurationUtilities");

		// Gets root node
		Node ndRoot = ndSubject.getRoot();

		// Generates
		lsClass.add(stIndentation + "	try {");
		lsClass.add(stIndentation + "		nd" + ndSubject.getJavaName() + "." + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + " = ConfigurationUtilities.getEnumerationAttribute(ndNode, " + ndRoot.getJavaName() + ".ATTRIBUTENAME_" + atAttribute.getJavaName().toUpperCase() + ", " + atAttribute.getAttributeType().getJavaName() + ".class);");
		lsClass.add(stIndentation + "	} catch (Exception e) {");
		lsClass.add(stIndentation + "		throw new " + pgParserGenerator.stExceptionClass + "(\"Attribute " + atAttribute.getName() + " value cannot be parsed\");");
		lsClass.add(stIndentation + "	}");

		// Verifies review need
		if ((atAttribute.getRequired()) || ((!atAttribute.getRequired()) && (atAttribute.getDefaultValue() != null))) {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "	// Verifies required attribute");
			lsClass.add(stIndentation + "	if (nd" + ndSubject.getJavaName() + "." + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + " == null) {");

			// Verifies required
			if (atAttribute.getRequired()) {
				lsClass.add(stIndentation + "		throw new " + pgParserGenerator.stExceptionClass + "(\"Required attribute " + atAttribute.getName() + " not found\");");
			} else if (atAttribute.getDefaultValue() != null) {
				lsClass.add(stIndentation + "		nd" + ndSubject.getJavaName() + "." + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + " = " + atAttribute.getDefaultValue() + ";");
			}

			// Generates
			lsClass.add(stIndentation + "	}");
		}
	}

	/**
	 * Generate save method.
	 */
	public void cmdGenerateSave(ParserGenerator pgParserGenerator, String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport, Attribute atAttribute) {

		// Adds imports
		stImport.add(pgParserGenerator.stResourcesPackage + ".ConfigurationUtilities");

		// Gets root node
		Node ndRoot = ndSubject.getRoot();

		// Generates
		lsClass.add(stIndentation + "	el" + ndSubject.getJavaName() + ".setAttribute(" + ndRoot.getJavaName() + ".ATTRIBUTENAME_" + atAttribute.getJavaName().toUpperCase() + ", ConfigurationUtilities.getAttributeEnumeration(nd" + ndSubject.getJavaName() + ".get" + atAttribute.getJavaName() + "()));");
	}
}