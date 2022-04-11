package arinc653.configuration.parsergenerator;

import java.util.List;
import java.util.Set;

/**
 * Attribute type.
 * 
 * @author Luís Fernando Arcaro
 */
public abstract class AttributeType {

	/**
	 * Java name.
	 */
	private String stJavaName;

	/**
	 * Java prefix.
	 */
	private String stJavaPrefix;

	/**
	 * Constructor.
	 * 
	 * @param stJavaName
	 *            Java name.
	 * @param stJavaPrefix
	 *            Java prefix.
	 */
	protected AttributeType(String stJavaName, String stJavaPrefix) {
		this.stJavaName = stJavaName;
		this.stJavaPrefix = stJavaPrefix;
	};

	/**
	 * Java name getter.
	 */
	public String getJavaName() {
		return stJavaName;
	}

	/**
	 * Java prefix getter.
	 */
	public String getJavaPrefix() {
		return stJavaPrefix;
	}

	/**
	 * Add imports method.
	 * 
	 * @param gnGenerator
	 *            Generator.
	 * @param stImport
	 *            Import.
	 */
	public abstract void cmdAddImports(ParserGenerator pgParserGenerator, Set<String> stImport);

	/**
	 * Generate class method.
	 * 
	 * @param gnGenerator
	 *            Generator.
	 * @param atAttribute
	 *            Attribute.
	 */
	public abstract void cmdGenerateClass(ParserGenerator pgParserGenerator, Attribute atAttribute) throws Throwable;

	/**
	 * Generate load method.
	 * 
	 * @param gnGenerator
	 *            Generator.
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Import.
	 * @param atAttribute
	 *            Attribute.
	 */
	public abstract void cmdGenerateLoad(ParserGenerator pgParserGenerator, String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport, Attribute atAttribute);

	/**
	 * Generate save method.
	 * 
	 * @param gnGenerator
	 *            Generator.
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Import.
	 * @param atAttribute
	 *            Attribute.
	 */
	public abstract void cmdGenerateSave(ParserGenerator pgParserGenerator, String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport, Attribute atAttribute);
}