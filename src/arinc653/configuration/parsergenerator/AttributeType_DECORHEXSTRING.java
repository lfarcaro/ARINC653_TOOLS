package arinc653.configuration.parsergenerator;

import java.util.List;
import java.util.Set;

/**
 * Attribute type - DECORHEXSTRING.
 * 
 * @author Luís Fernando Arcaro
 */
public class AttributeType_DECORHEXSTRING extends AttributeType {

	/**
	 * Instance.
	 */
	public static final AttributeType_DECORHEXSTRING INSTANCE = new AttributeType_DECORHEXSTRING();

	/**
	 * Constructor.
	 */
	private AttributeType_DECORHEXSTRING() {
		super("DecOrHexString", "dh");
	}

	/**
	 * Add imports method.
	 */
	public void cmdAddImports(ParserGenerator pgParserGenerator, Set<String> stImport) {

		// Adds imports
		stImport.add(pgParserGenerator.stResourcesPackage + ".DecOrHexString");
	}

	/**
	 * Generate class method.
	 */
	public void cmdGenerateClass(ParserGenerator pgParserGenerator, Attribute atAttribute) throws Throwable {
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
		lsClass.add(stIndentation + "		nd" + ndSubject.getJavaName() + "." + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + " = ConfigurationUtilities.getDecOrHexStringAttribute(ndNode, " + ndRoot.getJavaName() + ".ATTRIBUTENAME_" + atAttribute.getJavaName().toUpperCase() + ");");
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
		lsClass.add(stIndentation + "	el" + ndSubject.getJavaName() + ".setAttribute(" + ndRoot.getJavaName() + ".ATTRIBUTENAME_" + atAttribute.getJavaName().toUpperCase() + ", ConfigurationUtilities.getAttributeDecOrHexString(nd" + ndSubject.getJavaName() + ".get" + atAttribute.getJavaName() + "()));");
	}
}