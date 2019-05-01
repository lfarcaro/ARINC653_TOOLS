package arinc653.configuration.parsergenerator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser generator.
 * 
 * @author Luís Fernando Arcaro
 */
public class ParserGenerator {

	/**
	 * Directory.
	 */
	protected File flDirectory;

	/**
	 * Package.
	 */
	protected String stPackage;

	/**
	 * Resources package.
	 */
	protected String stResourcesPackage;

	/**
	 * Exception class.
	 */
	protected String stExceptionClass;

	/**
	 * Constructor.
	 * 
	 * @param flDirectory
	 *            Directory.
	 * @param stPackage
	 *            Package.
	 * @param stResourcesPackage
	 *            Resources package.
	 * @param stExceptionClass
	 *            Exception class.
	 */
	public ParserGenerator(File flDirectory, String stPackage, String stResourcesPackage, String stExceptionClass) {
		this.flDirectory = flDirectory;
		this.stPackage = stPackage;
		this.stResourcesPackage = stResourcesPackage;
		this.stExceptionClass = stExceptionClass;
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateNodeNameList(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Gets recursive node list
		List<Node> lsNode = ndSubject.getRecursiveNodeList();

		// Sorts list by node name
		Collections.sort(lsNode, new Comparator<Node>() {

			@Override
			public int compare(Node ndNode1, Node ndNode2) {
				return ndNode1.getJavaName().compareTo(ndNode2.getJavaName());
			}
		});

		// Node name set
		Set<String> stNodeName = new HashSet<String>();

		// Iterates nodes
		Iterator<Node> itNode = lsNode.iterator();
		while (itNode.hasNext()) {

			// Gets next node
			Node ndNode = itNode.next();

			// Verifies duplicates
			if (!stNodeName.add(ndNode.getJavaName().toUpperCase())) {
				continue;
			}

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * " + ndNode.getName() + " node name.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "public static final String NODENAME_" + ndNode.getJavaName().toUpperCase() + " = \"" + ndNode.getName() + "\";");
		}
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateAttributeNameList(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Gets recursive attribute list
		List<Attribute> lsAttribute = ndSubject.getRecursiveAttributeList();

		// Sorts list by attribute name
		Collections.sort(lsAttribute, new Comparator<Attribute>() {

			@Override
			public int compare(Attribute atAttribute1, Attribute atAttribute2) {
				return atAttribute1.getJavaName().compareTo(atAttribute2.getJavaName());
			}
		});

		// Attribute name set
		Set<String> stAttributeName = new HashSet<String>();

		// Iterates attributes
		Iterator<Attribute> itAttribute = lsAttribute.iterator();
		while (itAttribute.hasNext()) {

			// Gets next attribute
			Attribute atAttribute = itAttribute.next();

			// Verifies duplicates
			if (!stAttributeName.add(atAttribute.getJavaName().toUpperCase())) {
				continue;
			}

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * " + atAttribute.getName() + " attribute name.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "public static final String ATTRIBUTENAME_" + atAttribute.getJavaName().toUpperCase() + " = \"" + atAttribute.getName() + "\";");
		}
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateConstants(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Verifies ignored node pattern
		if (ndSubject.getIgnoredNodePattern() != null) {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * Pattern for ignored node names.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "public static final String NODENAME_IGNORED_PATTERN = \"" + ndSubject.getIgnoredNodePattern().replaceAll(Pattern.quote("\\"), Matcher.quoteReplacement("\\\\")).replaceAll(Pattern.quote("\""), Matcher.quoteReplacement("\\\"")) + "\";");
		}
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateAttributes(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Verifies root
		if (!ndSubject.isRoot()) {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * Parent node.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "private " + ndSubject.getParentNode().getJavaName() + " ndParent;");
		}

		// Iterates attributes
		Iterator<Attribute> itAttribute = ndSubject.getAttributes().iterator();
		while (itAttribute.hasNext()) {

			// Gets next attribute
			Attribute atAttribute = itAttribute.next();

			// Adds attribute type imports
			atAttribute.getAttributeType().cmdAddImports(this, stImport);

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * " + atAttribute.getName() + " attribute.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "private " + atAttribute.getAttributeType().getJavaName() + " " + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + ";");
		}

		// Verifies allow other attributes
		if (ndSubject.getAllowOtherAttributes()) {

			// Adds imports
			stImport.add("java.util.Map");
			stImport.add("java.util.HashMap");

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * Other attribute map.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "private Map<String, String> mpOtherAttribute = new HashMap<String, String>();");
		}
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateChildrenLists(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Iterates nodes
		Iterator<Node> itNode = ndSubject.getNodes().iterator();
		while (itNode.hasNext()) {

			// Gets next node
			Node ndNode = itNode.next();

			// Adds imports
			stImport.add("java.util.List");
			stImport.add("java.util.LinkedList");

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * " + ndNode.getName() + " node list.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "private List<" + ndNode.getJavaName() + "> ls" + ndNode.getJavaName() + " = new LinkedList<" + ndNode.getJavaName() + ">();");

			// Verifies identification attribute
			if (ndNode.getIdentificationAttribute() != null) {

				// Gets identification attribute
				Attribute atIdentificationAttribute = ndNode.getAttribute(ndNode.getIdentificationAttribute());

				// Verifies identification attribute
				if (atIdentificationAttribute == null) {
					throw new ParserGeneratorException("Identification attribute not found for " + ndNode.getName());
				}

				// Adds imports
				stImport.add("java.util.Map");
				stImport.add("java.util.HashMap");
				atIdentificationAttribute.getAttributeType().cmdAddImports(this, stImport);

				// Generates
				lsClass.add("");
				lsClass.add(stIndentation + "/**");
				lsClass.add(stIndentation + " * " + ndNode.getName() + " node map.");
				lsClass.add(stIndentation + " */");
				lsClass.add(stIndentation + "private Map<" + atIdentificationAttribute.getAttributeType().getJavaName() + ", " + ndNode.getJavaName() + "> mp" + ndNode.getJavaName() + " = new HashMap<" + atIdentificationAttribute.getAttributeType().getJavaName() + ", " + ndNode.getJavaName() + ">();");
			}
		}
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateConstructors(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * Constructor.");
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "private " + ndSubject.getJavaName() + "() {");
		lsClass.add(stIndentation + "}");

		// Verifies constructor absence
		if ((ndSubject.isRoot()) && (ndSubject.getAttributes().isEmpty())) {
			return;
		}

		// Adds imports
		stImport.add(stResourcesPackage + "." + stExceptionClass);

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * Constructor.");
		lsClass.add(stIndentation + " * ");

		// Verifies root
		if (!ndSubject.isRoot()) {

			// Generates
			lsClass.add(stIndentation + " * @param ndParent");
			lsClass.add(stIndentation + " *            Parent.");
		}

		// Parameters
		StringBuffer sbParameters = new StringBuffer((ndSubject.isRoot() ? "" : ndSubject.getParentNode().getJavaName() + " ndParent" + (!ndSubject.getAttributes().isEmpty() ? ", " : "")));

		// Iterates attributes
		Iterator<Attribute> itAttribute = ndSubject.getAttributes().iterator();
		while (itAttribute.hasNext()) {

			// Gets next attribute
			Attribute atAttribute = itAttribute.next();

			// Generates
			lsClass.add(stIndentation + " * @param " + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName());
			lsClass.add(stIndentation + " *            " + atAttribute.getName() + ".");

			// Appends parameters
			sbParameters.append(atAttribute.getAttributeType().getJavaName() + " " + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + (itAttribute.hasNext() ? ", " : ""));
		}

		// Generates
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "private " + ndSubject.getJavaName() + "(" + sbParameters + ") throws " + stExceptionClass + " {");

		// Verifies root
		if (!ndSubject.isRoot()) {

			// Generates
			lsClass.add(stIndentation + "	this.ndParent = ndParent;");
		}

		// Iterates attributes
		itAttribute = ndSubject.getAttributes().iterator();
		while (itAttribute.hasNext()) {

			// Gets next attribute
			Attribute atAttribute = itAttribute.next();

			// Generates
			lsClass.add(stIndentation + "	this." + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + " = " + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + ";");
		}

		// Verifies root
		if (!ndSubject.isRoot()) {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "	// Adds to parent");
			lsClass.add(stIndentation + "	if (!ndParent.add" + ndSubject.getJavaName() + "(this)) {");
			lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"" + ndSubject.getName() + " cannot be added (probably its identifier attribute is duplicated)\");");
			lsClass.add(stIndentation + "	}");
		}

		// Generates
		lsClass.add(stIndentation + "}");
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateAttributeOperators(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Verifies root
		if (!ndSubject.isRoot()) {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * Parent node getter.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "public " + ndSubject.getParentNode().getJavaName() + " getParent() {");
			lsClass.add(stIndentation + "	return ndParent;");
			lsClass.add(stIndentation + "}");
		}

		// Iterates attributes
		Iterator<Attribute> itAttribute = ndSubject.getAttributes().iterator();
		while (itAttribute.hasNext()) {

			// Gets next attribute
			Attribute atAttribute = itAttribute.next();

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * " + atAttribute.getName() + " getter.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "public " + atAttribute.getAttributeType().getJavaName() + " get" + atAttribute.getJavaName() + "() {");
			lsClass.add(stIndentation + "	return this." + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + ";");
			lsClass.add(stIndentation + "}");
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * " + atAttribute.getName() + " setter.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "public void set" + atAttribute.getJavaName() + "(" + atAttribute.getAttributeType().getJavaName() + " " + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + ") {");
			lsClass.add(stIndentation + "	this." + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + " = " + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + ";");
			lsClass.add(stIndentation + "}");
		}

		// Verifies allow other attributes
		if (ndSubject.getAllowOtherAttributes()) {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * Other attribute getter.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "public String getOtherAttribute(String stAttribute) {");
			lsClass.add("");
			lsClass.add(stIndentation + "	// Verifies attribute");
			lsClass.add(stIndentation + "	if (stAttribute == null) {");
			lsClass.add(stIndentation + "		return null;");
			lsClass.add(stIndentation + "	}");
			lsClass.add("");
			lsClass.add(stIndentation + "	// Gets other attribute");
			lsClass.add(stIndentation + "	return this.mpOtherAttribute.get(stAttribute.intern());");
			lsClass.add(stIndentation + "}");
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * Other attribute setter.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "public void setOtherAttribute(String stAttribute, String stValue) {");
			lsClass.add("");
			lsClass.add(stIndentation + "	// Verifies attribute");
			lsClass.add(stIndentation + "	if (stAttribute == null) {");
			lsClass.add(stIndentation + "		return;");
			lsClass.add(stIndentation + "	}");
			lsClass.add("");
			lsClass.add(stIndentation + "	// Verifies value");
			lsClass.add(stIndentation + "	if (stValue != null) {");
			lsClass.add("");
			lsClass.add(stIndentation + "		// Sets other attribute");
			lsClass.add(stIndentation + "		this.mpOtherAttribute.put(stAttribute.intern(), stValue);");
			lsClass.add(stIndentation + "	} else {");
			lsClass.add("");
			lsClass.add(stIndentation + "		// Removes other attribute");
			lsClass.add(stIndentation + "		this.mpOtherAttribute.remove(stAttribute.intern());");
			lsClass.add(stIndentation + "	}");
			lsClass.add(stIndentation + "}");
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * Other attributes getter.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "public Map<String, String> getOtherAttributes() {");
			lsClass.add("");
			lsClass.add(stIndentation + "	// Returns a map copy");
			lsClass.add(stIndentation + "	return new HashMap<String, String>(this.mpOtherAttribute);");
			lsClass.add(stIndentation + "}");
		}
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateOperators(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Iterates nodes
		Iterator<Node> itNode = ndSubject.getNodes().iterator();
		while (itNode.hasNext()) {

			// Gets next node
			Node ndNode = itNode.next();

			// Gets identification attribute
			Attribute atIdentificationAttribute = (ndNode.getIdentificationAttribute() != null ? ndNode.getAttribute(ndNode.getIdentificationAttribute()) : null);

			// Verifies identification attribute
			if ((ndNode.getIdentificationAttribute() != null) && (atIdentificationAttribute == null)) {
				throw new ParserGeneratorException("Identification attribute not found for " + ndNode.getName());
			}

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * " + ndNode.getName() + " adder.");
			lsClass.add(stIndentation + " * ");
			lsClass.add(stIndentation + " * @param nd" + ndNode.getJavaName());
			lsClass.add(stIndentation + " *            " + ndNode.getName() + ".");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "public boolean add" + ndNode.getJavaName() + "(" + ndNode.getJavaName() + " nd" + ndNode.getJavaName() + ") {");
			lsClass.add("");
			lsClass.add(stIndentation + "	// Verifies node");
			lsClass.add(stIndentation + "	if (nd" + ndNode.getJavaName() + " == null) {");
			lsClass.add(stIndentation + "		return false;");
			lsClass.add(stIndentation + "	}");

			// Verifies identification attribute
			if (atIdentificationAttribute != null) {

				// Generates
				lsClass.add("");
				lsClass.add(stIndentation + "	// Verifies identifier");
				lsClass.add(stIndentation + "	if (mp" + ndNode.getJavaName() + ".containsKey(nd" + ndNode.getJavaName() + ".get" + atIdentificationAttribute.getJavaName() + "())) {");
				lsClass.add(stIndentation + "		return false;");
				lsClass.add(stIndentation + "	}");
			}

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "	// Adds node");
			lsClass.add(stIndentation + "	ls" + ndNode.getJavaName() + ".add(nd" + ndNode.getJavaName() + ");");

			// Verifies identification attribute
			if (atIdentificationAttribute != null) {

				// Generates
				lsClass.add("");
				lsClass.add(stIndentation + "	// Maps node");
				lsClass.add(stIndentation + "	mp" + ndNode.getJavaName() + ".put(nd" + ndNode.getJavaName() + ".get" + atIdentificationAttribute.getJavaName() + "(), nd" + ndNode.getJavaName() + ");");
			}

			// Generates
			lsClass.add(stIndentation + "	return true;");
			lsClass.add(stIndentation + "}");

			// Verifies identification attribute
			if (atIdentificationAttribute != null) {

				// Adds imports
				stImport.add("java.util.Set");

				// Generates
				lsClass.add("");
				lsClass.add(stIndentation + "/**");
				lsClass.add(stIndentation + " * " + ndNode.getName() + " getter.");
				lsClass.add(stIndentation + " * ");
				lsClass.add(stIndentation + " * @param " + atIdentificationAttribute.getAttributeType().getJavaPrefix() + atIdentificationAttribute.getJavaName());
				lsClass.add(stIndentation + " *            " + atIdentificationAttribute.getName() + ".");
				lsClass.add(stIndentation + " */");
				lsClass.add(stIndentation + "public " + ndNode.getJavaName() + " get" + ndNode.getJavaName() + "(" + atIdentificationAttribute.getAttributeType().getJavaName() + " " + atIdentificationAttribute.getAttributeType().getJavaPrefix() + atIdentificationAttribute.getJavaName() + ") {");
				lsClass.add(stIndentation + "	return (" + atIdentificationAttribute.getAttributeType().getJavaPrefix() + atIdentificationAttribute.getJavaName() + " == null ? null : this.mp" + ndNode.getJavaName() + ".get(" + atIdentificationAttribute.getAttributeType().getJavaPrefix() + atIdentificationAttribute.getJavaName() + "));");
				lsClass.add(stIndentation + "}");
				lsClass.add("");
				lsClass.add(stIndentation + "/**");
				lsClass.add(stIndentation + " * " + ndNode.getName() + " " + atIdentificationAttribute.getName() + " set getter.");
				lsClass.add(stIndentation + " */");
				lsClass.add(stIndentation + "public Set<" + atIdentificationAttribute.getAttributeType().getJavaName() + "> get" + ndNode.getJavaName() + atIdentificationAttribute.getJavaName() + "Set() {");
				lsClass.add(stIndentation + "	return this.mp" + ndNode.getJavaName() + ".keySet();");
				lsClass.add(stIndentation + "}");
			}

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "/**");
			lsClass.add(stIndentation + " * " + ndNode.getName() + " list getter.");
			lsClass.add(stIndentation + " */");
			lsClass.add(stIndentation + "public List<" + ndNode.getJavaName() + "> get" + ndNode.getJavaName() + "List() {");
			lsClass.add(stIndentation + "	return new LinkedList<" + ndNode.getJavaName() + ">(this.ls" + ndNode.getJavaName() + ");");
			lsClass.add(stIndentation + "}");
		}
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateIdentificators(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// TODO

		// Gets identification attribute
		Attribute atIdentificationAttribute = (ndSubject.getIdentificationAttribute() != null ? ndSubject.getAttribute(ndSubject.getIdentificationAttribute()) : null);

		// Verifies identification attribute
		if ((ndSubject.getIdentificationAttribute() != null) && (atIdentificationAttribute == null)) {
			throw new ParserGeneratorException("Identification attribute not found for " + ndSubject.getName());
		}

		// Verifies identification attribute
		if (atIdentificationAttribute != null) {

			// Gets attribute type
			AttributeType atIdentificationAttributeType = atIdentificationAttribute.getAttributeType();

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "@Override");
			lsClass.add(stIndentation + "public int hashCode() {");
			lsClass.add(stIndentation + "	return (" + atIdentificationAttributeType.getJavaPrefix() + atIdentificationAttribute.getJavaName() + " != null ? " + atIdentificationAttributeType.getJavaPrefix() + atIdentificationAttribute.getJavaName() + ".hashCode() : super.hashCode());");
			lsClass.add(stIndentation + "}");
			lsClass.add("");
			lsClass.add(stIndentation + "@Override");
			lsClass.add(stIndentation + "public boolean equals(Object obObject) {");
			lsClass.add("");
			lsClass.add(stIndentation + "	// Verifies object");
			lsClass.add(stIndentation + "	if (!(obObject instanceof " + ndSubject.getJavaName() + ")) {");
			lsClass.add(stIndentation + "		return false;");
			lsClass.add(stIndentation + "	}");
			lsClass.add("");
			lsClass.add(stIndentation + "	// Casts object");
			lsClass.add(stIndentation + "	" + ndSubject.getJavaName() + " nd" + ndSubject.getJavaName() + " = (" + ndSubject.getJavaName() + ") obObject;");
			lsClass.add("");
			lsClass.add(stIndentation + "	// Verifies identifiers");
			lsClass.add(stIndentation + "	if ((nd" + ndSubject.getJavaName() + ".get" + atIdentificationAttribute.getJavaName() + "() == null) || (" + atIdentificationAttributeType.getJavaPrefix() + atIdentificationAttribute.getJavaName() + " == null)) {");
			lsClass.add(stIndentation + "		return ((nd" + ndSubject.getJavaName() + ".get" + atIdentificationAttribute.getJavaName() + "() == null) && (" + atIdentificationAttributeType.getJavaPrefix() + atIdentificationAttribute.getJavaName() + " == null));");
			lsClass.add(stIndentation + "	}");
			lsClass.add("");
			lsClass.add(stIndentation + "	// Verifies identifiers");
			lsClass.add(stIndentation + "	if (nd" + ndSubject.getJavaName() + ".get" + atIdentificationAttribute.getJavaName() + "().equals(" + atIdentificationAttributeType.getJavaPrefix() + atIdentificationAttribute.getJavaName() + ")) {");
			lsClass.add(stIndentation + "		return true;");
			lsClass.add(stIndentation + "	}");
			lsClass.add("");
			lsClass.add(stIndentation + "	// Not equal");
			lsClass.add(stIndentation + "	return false;");
			lsClass.add(stIndentation + "}");
			lsClass.add("");
			lsClass.add(stIndentation + "@Override");
			lsClass.add(stIndentation + "public String toString() {");
			lsClass.add(stIndentation + "	return (" + atIdentificationAttributeType.getJavaPrefix() + atIdentificationAttribute.getJavaName() + " != null ? " + atIdentificationAttributeType.getJavaPrefix() + atIdentificationAttribute.getJavaName() + ".toString() : super.toString());");
			lsClass.add(stIndentation + "}");
		}
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateLoader(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Adds imports
		stImport.add(stResourcesPackage + "." + stExceptionClass);
		stImport.add("org.w3c.dom.Node");

		// Gets root node
		Node ndRoot = ndSubject.getRoot();

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * Loading method.");
		lsClass.add(stIndentation + " * ");
		lsClass.add(stIndentation + " * @param ndNode");
		lsClass.add(stIndentation + " *            Node.");

		// Verifies root
		if (!ndSubject.isRoot()) {

			// Generates
			lsClass.add(stIndentation + " * @param ndParent");
			lsClass.add(stIndentation + " *            " + ndSubject.getParentNode().getName() + ".");
		}

		// Generates
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "public static " + ndSubject.getJavaName() + " cmdLoad(Node ndNode" + (!ndSubject.isRoot() ? ", " + ndSubject.getParentNode().getJavaName() + " ndParent" : "") + ") throws " + stExceptionClass + " {");

		// Verifies root
		if (!ndSubject.isRoot()) {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "	// Verifies parent");
			lsClass.add(stIndentation + "	if (ndParent == null) {");
			lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Cannot load non-root with null parent\");");
			lsClass.add(stIndentation + "	}");
		}

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "	// Verifies node");
		lsClass.add(stIndentation + "	if (ndNode == null) {");
		lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Cannot load null node\");");
		lsClass.add(stIndentation + "	}");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Verifies node");
		lsClass.add(stIndentation + "	if ((ndNode.getNodeType() != Node.ELEMENT_NODE) || (!" + ndRoot.getJavaName() + ".NODENAME_" + ndSubject.getJavaName().toUpperCase() + ".equals(ndNode.getNodeName()))) {");
		lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Node does not represent a " + ndSubject.getName() + "\");");
		lsClass.add(stIndentation + "	}");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Creates node");
		lsClass.add(stIndentation + "	" + ndSubject.getJavaName() + " nd" + ndSubject.getJavaName() + " = new " + ndSubject.getJavaName() + "();");

		// Verifies root
		if (!ndSubject.isRoot()) {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "	// Sets parent");
			lsClass.add(stIndentation + "	nd" + ndSubject.getJavaName() + ".ndParent = ndParent;");
		}

		// Iterates attributes
		Iterator<Attribute> itAttribute = ndSubject.getAttributes().iterator();
		while (itAttribute.hasNext()) {

			// Gets next attribute
			Attribute atAttribute = itAttribute.next();

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "	// Loads attribute");

			// Generates load
			atAttribute.getAttributeType().cmdGenerateLoad(this, stIndentation, ndSubject, lsClass, stImport, atAttribute);
		}

		// Adds imports
		stImport.add("org.w3c.dom.NamedNodeMap");

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "	// Iterates attributes");
		lsClass.add(stIndentation + "	NamedNodeMap nmAttributes = ndNode.getAttributes();");
		lsClass.add(stIndentation + "	for (int i = 0; i < nmAttributes.getLength(); i++) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Gets next attribute");
		lsClass.add(stIndentation + "		Node ndAttribute = nmAttributes.item(i);");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Verifies attribute");
		lsClass.add(stIndentation + "		if (ndAttribute.getNodeType() != Node.ATTRIBUTE_NODE) {");
		lsClass.add(stIndentation + "			continue;");
		lsClass.add(stIndentation + "		}");

		// Iterates attributes
		itAttribute = ndSubject.getAttributes().iterator();
		while (itAttribute.hasNext()) {

			// Gets next attribute
			Attribute atAttribute = itAttribute.next();

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "		// Verifies attribute");
			lsClass.add(stIndentation + "		if (" + ndRoot.getJavaName() + ".ATTRIBUTENAME_" + atAttribute.getJavaName().toUpperCase() + ".equals(ndAttribute.getNodeName())) {");
			lsClass.add(stIndentation + "			continue;");
			lsClass.add(stIndentation + "		}");
		}

		// Verifies allow other attributes
		if (ndSubject.getAllowOtherAttributes()) {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "		// Sets other attribute");
			lsClass.add(stIndentation + "		nd" + ndSubject.getJavaName() + ".mpOtherAttribute.put(ndAttribute.getNodeName().intern(), ndAttribute.getNodeValue());");
		} else {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "		// Throws exception");
			lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Unexpected attribute \" + ndAttribute.getNodeName() + \" found in " + ndSubject.getName() + " node\");");
		}

		// Generates
		lsClass.add(stIndentation + "	}");

		// Adds imports
		stImport.add("org.w3c.dom.NodeList");

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "	// Iterates child nodes");
		lsClass.add(stIndentation + "	NodeList nlNodeList = ndNode.getChildNodes();");
		lsClass.add(stIndentation + "	for (int i = 0; i < nlNodeList.getLength(); i++) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Gets next child node");
		lsClass.add(stIndentation + "		Node ndChildNode = nlNodeList.item(i);");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Verifies node");
		lsClass.add(stIndentation + "		if (ndChildNode.getNodeType() != Node.ELEMENT_NODE) {");
		lsClass.add(stIndentation + "			continue;");
		lsClass.add(stIndentation + "		}");

		// Iterates nodes
		Iterator<Node> itNode = ndSubject.getNodes().iterator();
		while (itNode.hasNext()) {

			// Gets next node
			Node ndNode = itNode.next();

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "		// Verifies node");
			lsClass.add(stIndentation + "		if (" + ndRoot.getJavaName() + ".NODENAME_" + ndNode.getJavaName().toUpperCase() + ".equals(ndChildNode.getNodeName())) {");
			lsClass.add("");
			lsClass.add(stIndentation + "			// Loads child");
			lsClass.add(stIndentation + "			" + ndNode.getJavaName() + " nd" + ndNode.getJavaName() + " = " + ndNode.getJavaName() + ".cmdLoad(ndChildNode, nd" + ndSubject.getJavaName() + ");");
			lsClass.add("");
			lsClass.add(stIndentation + "			// Verifies child");
			lsClass.add(stIndentation + "			if (nd" + ndNode.getJavaName() + " == null) {");
			lsClass.add(stIndentation + "				throw new " + stExceptionClass + "(\"Error while loading a " + ndNode.getName() + " node (" + ndSubject.getName() + " child)\");");
			lsClass.add(stIndentation + "			}");
			lsClass.add("");
			lsClass.add(stIndentation + "			// Adds child");
			lsClass.add(stIndentation + "			nd" + ndSubject.getJavaName() + ".add" + ndNode.getJavaName() + "(nd" + ndNode.getJavaName() + ");");
			lsClass.add(stIndentation + "			continue;");
			lsClass.add(stIndentation + "		}");
		}

		// Verifies ignored node pattern
		if (ndSubject.getIgnoredNodePattern() != null) {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "	// Verifies ignored nodes");
			lsClass.add(stIndentation + "	if (ndChildNode.getNodeName().matches(NODENAME_IGNORED_PATTERN)) {");
			lsClass.add(stIndentation + "		continue;");
			lsClass.add(stIndentation + "	}");
		}

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Unexpected node \" + ndChildNode.getNodeName() + \" found in " + ndSubject.getName() + " node\");");
		lsClass.add(stIndentation + "	}");

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "	// Returns node");
		lsClass.add(stIndentation + "	return nd" + ndSubject.getJavaName() + ";");
		lsClass.add(stIndentation + "}");
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateMultipleLoaders(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Adds imports
		stImport.add("org.w3c.dom.Document");
		stImport.add("javax.xml.parsers.DocumentBuilder");
		stImport.add("javax.xml.parsers.DocumentBuilderFactory");
		stImport.add("java.io.ByteArrayInputStream");
		stImport.add("java.io.File");
		stImport.add("java.io.FileInputStream");
		stImport.add("java.io.InputStream");

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * Document loading method.");
		lsClass.add(stIndentation + " * ");
		lsClass.add(stIndentation + " * @param dcDocument");
		lsClass.add(stIndentation + " *            Document.");
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "public static " + ndSubject.getJavaName() + " cmdLoadDocument(Document dcDocument) throws " + stExceptionClass + " {");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Verifies document");
		lsClass.add(stIndentation + "	if (dcDocument == null) {");
		lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Cannot load null document\");");
		lsClass.add(stIndentation + "	}");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Iterates child nodes");
		lsClass.add(stIndentation + "	NodeList nlNodeList = dcDocument.getChildNodes();");
		lsClass.add(stIndentation + "	for (int i = 0; i < nlNodeList.getLength(); i++) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Gets next child node");
		lsClass.add(stIndentation + "		Node ndChildNode = nlNodeList.item(i);");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Verifies node");
		lsClass.add(stIndentation + "		if ((ndChildNode.getNodeType() == Node.ELEMENT_NODE) && (" + ndSubject.getJavaName() + ".NODENAME_" + ndSubject.getJavaName().toUpperCase() + ".equals(ndChildNode.getNodeName()))) {");
		lsClass.add("");
		lsClass.add(stIndentation + "			// Loads node");
		lsClass.add(stIndentation + "			return " + ndSubject.getJavaName() + ".cmdLoad(ndChildNode);");
		lsClass.add(stIndentation + "		} else if (ndChildNode.getNodeType() == Node.ELEMENT_NODE) {");
		lsClass.add(stIndentation + "			throw new " + stExceptionClass + "(\"Unknown node found in document\");");
		lsClass.add(stIndentation + "		}");
		lsClass.add(stIndentation + "	}");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Throws exception");
		lsClass.add(stIndentation + "	throw new " + stExceptionClass + "(\"No node found in document\");");
		lsClass.add(stIndentation + "}");
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * Stream loading method.");
		lsClass.add(stIndentation + " * ");
		lsClass.add(stIndentation + " * @param isInputStream");
		lsClass.add(stIndentation + " *            Stream.");
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "public static " + ndSubject.getJavaName() + " cmdLoadStream(InputStream isInputStream) throws " + stExceptionClass + " {");
		lsClass.add(stIndentation + "	try {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Verifies stream");
		lsClass.add(stIndentation + "		if (isInputStream == null) {");
		lsClass.add(stIndentation + "			throw new " + stExceptionClass + "(\"Cannot load null stream\");");
		lsClass.add(stIndentation + "		}");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Creates document builder factory");
		lsClass.add(stIndentation + "		DocumentBuilderFactory fcDocumentBuilderFactory = DocumentBuilderFactory.newInstance();");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Creates document builder");
		lsClass.add(stIndentation + "		DocumentBuilder dbDocumentBuilder = fcDocumentBuilderFactory.newDocumentBuilder();");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Parses document");
		lsClass.add(stIndentation + "		Document dcDocument = dbDocumentBuilder.parse(isInputStream);");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Loads document");
		lsClass.add(stIndentation + "		return " + ndSubject.getJavaName() + ".cmdLoadDocument(dcDocument);");
		lsClass.add(stIndentation + "	} catch (" + stExceptionClass + " e) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw e;");
		lsClass.add(stIndentation + "	} catch (Throwable t) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Error while loading stream\", t);");
		lsClass.add(stIndentation + "	}");
		lsClass.add(stIndentation + "}");
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * File loading method.");
		lsClass.add(stIndentation + " * ");
		lsClass.add(stIndentation + " * @param flFile");
		lsClass.add(stIndentation + " *            File.");
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "public static " + ndSubject.getJavaName() + " cmdLoadFile(File flFile) throws " + stExceptionClass + " {");
		lsClass.add(stIndentation + "	try {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Creates input stream");
		lsClass.add(stIndentation + "		InputStream isInputStream = new FileInputStream(flFile);");
		lsClass.add(stIndentation + "		try {");
		lsClass.add("");
		lsClass.add(stIndentation + "			// Loads stream");
		lsClass.add(stIndentation + "			return " + ndSubject.getJavaName() + ".cmdLoadStream(isInputStream);");
		lsClass.add(stIndentation + "		} finally {");
		lsClass.add("");
		lsClass.add(stIndentation + "			// Closes input stream");
		lsClass.add(stIndentation + "			isInputStream.close();");
		lsClass.add(stIndentation + "		}");
		lsClass.add(stIndentation + "	} catch (" + stExceptionClass + " e) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw e;");
		lsClass.add(stIndentation + "	} catch (Throwable t) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Error while loading file\", t);");
		lsClass.add(stIndentation + "	}");
		lsClass.add(stIndentation + "}");
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * Resource loading method.");
		lsClass.add(stIndentation + " * ");
		lsClass.add(stIndentation + " * @param stResource");
		lsClass.add(stIndentation + " *            Resource.");
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "public static " + ndSubject.getJavaName() + " cmdLoadResource(String stResource) throws " + stExceptionClass + " {");
		lsClass.add(stIndentation + "	try {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Loads stream");
		lsClass.add(stIndentation + "		return " + ndSubject.getJavaName() + ".cmdLoadStream(" + ndSubject.getJavaName() + ".class.getResourceAsStream(stResource));");
		lsClass.add(stIndentation + "	} catch (" + stExceptionClass + " e) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw e;");
		lsClass.add(stIndentation + "	} catch (Throwable t) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Error while loading resource\", t);");
		lsClass.add(stIndentation + "	}");
		lsClass.add(stIndentation + "}");
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * String loading method.");
		lsClass.add(stIndentation + " * ");
		lsClass.add(stIndentation + " * @param stString");
		lsClass.add(stIndentation + " *            String.");
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "public static " + ndSubject.getJavaName() + " cmdLoadString(String stString) throws " + stExceptionClass + " {");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Verifies string");
		lsClass.add(stIndentation + "	if (stString == null) {");
		lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Cannot load null string\");");
		lsClass.add(stIndentation + "	}");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Loads stream");
		lsClass.add(stIndentation + "	return " + ndSubject.getJavaName() + ".cmdLoadStream(new ByteArrayInputStream(stString.getBytes()));");
		lsClass.add(stIndentation + "}");
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateSaver(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Adds imports
		stImport.add(stResourcesPackage + "." + stExceptionClass);
		stImport.add("org.w3c.dom.Element");

		// Gets root node
		Node ndRoot = ndSubject.getRoot();

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * Saving method.");
		lsClass.add(stIndentation + " * ");
		lsClass.add(stIndentation + " * @param elParent");
		lsClass.add(stIndentation + " *            Parent.");
		lsClass.add(stIndentation + " * @param nd" + ndSubject.getJavaName());
		lsClass.add(stIndentation + " *            " + ndSubject.getName() + ".");
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "public static Element cmdSave(Element elParent, " + ndSubject.getJavaName() + " nd" + ndSubject.getJavaName() + ") throws " + stExceptionClass + " {");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Creates element");
		lsClass.add(stIndentation + "	Element el" + ndSubject.getJavaName() + " = elParent.getOwnerDocument().createElement(" + ndRoot.getJavaName() + ".NODENAME_" + ndSubject.getJavaName().toUpperCase() + ");");

		// Iterates attributes
		Iterator<Attribute> itAttribute = ndSubject.getAttributes().iterator();
		while (itAttribute.hasNext()) {

			// Gets next attribute
			Attribute atAttribute = itAttribute.next();

			// Verifies required
			if (atAttribute.getRequired()) {

				// Generates
				lsClass.add("");
				lsClass.add(stIndentation + "	// Verifies required attribute");
				lsClass.add(stIndentation + "	if (nd" + ndSubject.getJavaName() + ".get" + atAttribute.getJavaName() + "() == null) {");
				lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Required attribute " + atAttribute.getName() + " not assigned in " + ndSubject.getName() + "\");");
				lsClass.add(stIndentation + "	}");

				// Generates
				lsClass.add("");
				lsClass.add(stIndentation + "	// Saves attribute");

				// Generates save
				atAttribute.getAttributeType().cmdGenerateSave(this, stIndentation, ndSubject, lsClass, stImport, atAttribute);
			} else {

				// Generates
				lsClass.add("");
				lsClass.add(stIndentation + "	// Verifies attribute");
				lsClass.add(stIndentation + "	if (nd" + ndSubject.getJavaName() + ".get" + atAttribute.getJavaName() + "() != null) {");
				lsClass.add("");
				lsClass.add(stIndentation + "		// Saves attribute");

				// Generates save
				atAttribute.getAttributeType().cmdGenerateSave(this, stIndentation + "\t", ndSubject, lsClass, stImport, atAttribute);

				// Generates
				lsClass.add(stIndentation + "	}");
			}
		}

		// Verifies allow other attributes
		if (ndSubject.getAllowOtherAttributes()) {

			// Adds imports
			stImport.add("java.util.Iterator");

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "	// Iterates other attributes");
			lsClass.add(stIndentation + "	Iterator<String> itOtherAttribute = nd" + ndSubject.getJavaName() + ".getOtherAttributes().keySet().iterator();");
			lsClass.add(stIndentation + "	while (itOtherAttribute.hasNext()) {");
			lsClass.add("");
			lsClass.add(stIndentation + "		// Gets next attribute");
			lsClass.add(stIndentation + "		String stAttribute = itOtherAttribute.next();");
			lsClass.add("");
			lsClass.add(stIndentation + "		// Saves attribute");
			lsClass.add(stIndentation + "		el" + ndSubject.getJavaName() + ".setAttribute(stAttribute, nd" + ndSubject.getJavaName() + ".getOtherAttribute(stAttribute));");
			lsClass.add(stIndentation + "	}");
		}

		// Iterates nodes
		Iterator<Node> itNode = ndSubject.getNodes().iterator();
		while (itNode.hasNext()) {

			// Gets next node
			Node ndNode = itNode.next();

			// Adds imports
			stImport.add("java.util.Iterator");

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "	// Iterates children");
			lsClass.add(stIndentation + "	Iterator<" + ndNode.getJavaName() + "> it" + ndNode.getJavaName() + " = nd" + ndSubject.getJavaName() + ".get" + ndNode.getJavaName() + "List().iterator();");
			lsClass.add(stIndentation + "	while (it" + ndNode.getJavaName() + ".hasNext()) {");
			lsClass.add("");
			lsClass.add(stIndentation + "		// Appends child");
			lsClass.add(stIndentation + "		el" + ndSubject.getJavaName() + ".appendChild(" + ndNode.getJavaName() + ".cmdSave(el" + ndSubject.getJavaName() + ", it" + ndNode.getJavaName() + ".next()));");
			lsClass.add(stIndentation + "	}");
		}

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "	// Returns element");
		lsClass.add(stIndentation + "	return el" + ndSubject.getJavaName() + ";");
		lsClass.add(stIndentation + "}");
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateMultipleSavers(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Adds imports
		stImport.add("org.w3c.dom.Document");
		stImport.add("javax.xml.parsers.DocumentBuilder");
		stImport.add("javax.xml.parsers.DocumentBuilderFactory");
		stImport.add("javax.xml.transform.OutputKeys");
		stImport.add("javax.xml.transform.Transformer");
		stImport.add("javax.xml.transform.TransformerFactory");
		stImport.add("javax.xml.transform.dom.DOMSource");
		stImport.add("javax.xml.transform.stream.StreamResult");
		stImport.add("java.io.File");
		stImport.add("java.io.StringWriter");
		stImport.add("java.io.PrintWriter");

		// Gets root node
		Node ndRoot = ndSubject.getRoot();

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * Document saving method.");
		lsClass.add(stIndentation + " * ");
		lsClass.add(stIndentation + " * @param nd" + ndSubject.getJavaName());
		lsClass.add(stIndentation + " *            " + ndSubject.getName() + ".");
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "public static Document cmdSaveDocument(" + ndSubject.getJavaName() + " nd" + ndSubject.getJavaName() + ") throws " + stExceptionClass + " {");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Document");
		lsClass.add(stIndentation + "	Document dcDocument = null;");
		lsClass.add(stIndentation + "	try {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Creates document builder factory");
		lsClass.add(stIndentation + "		DocumentBuilderFactory fcDocumentBuilderFactory = DocumentBuilderFactory.newInstance();");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Creates document builder");
		lsClass.add(stIndentation + "		DocumentBuilder dbDocumentBuilder = fcDocumentBuilderFactory.newDocumentBuilder();");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Creates document");
		lsClass.add(stIndentation + "		dcDocument = dbDocumentBuilder.newDocument();");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Sets as standalone");
		lsClass.add(stIndentation + "		dcDocument.setXmlStandalone(true);");
		lsClass.add(stIndentation + "	} catch (Throwable t) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Error while creating document\", t);");
		lsClass.add(stIndentation + "	}");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Creates root element");
		lsClass.add(stIndentation + "	Element el" + ndSubject.getJavaName() + " = dcDocument.createElement(" + ndRoot.getJavaName() + ".NODENAME_" + ndSubject.getJavaName().toUpperCase() + ");");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Appends child");
		lsClass.add(stIndentation + "	dcDocument.appendChild(" + ndSubject.getJavaName() + ".cmdSave(el" + ndSubject.getJavaName() + ", nd" + ndSubject.getJavaName() + "));");
		lsClass.add("");
		lsClass.add(stIndentation + "	// Returns document");
		lsClass.add(stIndentation + "	return dcDocument;");
		lsClass.add(stIndentation + "}");
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * String saving method.");
		lsClass.add(stIndentation + " * ");
		lsClass.add(stIndentation + " * @param nd" + ndSubject.getJavaName() + "");
		lsClass.add(stIndentation + " *            " + ndSubject.getName() + ".");
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "public static String cmdSaveString(" + ndSubject.getJavaName() + " nd" + ndSubject.getJavaName() + ") throws " + stExceptionClass + " {");
		lsClass.add(stIndentation + "	try {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Saves document");
		lsClass.add(stIndentation + "		Document dcDocument = " + ndSubject.getJavaName() + ".cmdSaveDocument(nd" + ndSubject.getJavaName() + ");");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Creates transformer");
		lsClass.add(stIndentation + "		Transformer trTransformer = TransformerFactory.newInstance().newTransformer();");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Sets indentation");
		lsClass.add(stIndentation + "		trTransformer.setOutputProperty(OutputKeys.INDENT, \"yes\");");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Creates stream result");
		lsClass.add(stIndentation + "		StreamResult srStreamResult = new StreamResult(new StringWriter());");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Creates source");
		lsClass.add(stIndentation + "		DOMSource srSource = new DOMSource(dcDocument);");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Transforms");
		lsClass.add(stIndentation + "		trTransformer.transform(srSource, srStreamResult);");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Returns");
		lsClass.add(stIndentation + "		return srStreamResult.getWriter().toString();");
		lsClass.add(stIndentation + "	} catch (" + stExceptionClass + " e) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw e;");
		lsClass.add(stIndentation + "	} catch (Throwable t) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Error while saving string\", t);");
		lsClass.add(stIndentation + "	}");
		lsClass.add(stIndentation + "}");
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * File saving method.");
		lsClass.add(stIndentation + " * ");
		lsClass.add(stIndentation + " * @param nd" + ndSubject.getJavaName() + "");
		lsClass.add(stIndentation + " *            " + ndSubject.getName() + ".");
		lsClass.add(stIndentation + " * @param flFile");
		lsClass.add(stIndentation + " *            File.");
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "public static void cmdSaveFile(" + ndSubject.getJavaName() + " nd" + ndSubject.getJavaName() + ", File flFile) throws " + stExceptionClass + " {");
		lsClass.add(stIndentation + "	try {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Saves string");
		lsClass.add(stIndentation + "		String stString = cmdSaveString(nd" + ndSubject.getJavaName() + ");");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Verifies string");
		lsClass.add(stIndentation + "		if (stString == null) {");
		lsClass.add(stIndentation + "			throw new " + stExceptionClass + "(\"Invalid string saved\");");
		lsClass.add(stIndentation + "		}");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Opens writer");
		lsClass.add(stIndentation + "		PrintWriter pwPrintWriter = new PrintWriter(flFile, \"UTF-8\");");
		lsClass.add(stIndentation + "		try {");
		lsClass.add("");
		lsClass.add(stIndentation + "			// Writes");
		lsClass.add(stIndentation + "			pwPrintWriter.write(stString);");
		lsClass.add(stIndentation + "		} finally {");
		lsClass.add("");
		lsClass.add(stIndentation + "			// Closes writer");
		lsClass.add(stIndentation + "			pwPrintWriter.close();");
		lsClass.add(stIndentation + "		}");
		lsClass.add(stIndentation + "	} catch (" + stExceptionClass + " e) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw e;");
		lsClass.add(stIndentation + "	} catch (Throwable t) {");
		lsClass.add("");
		lsClass.add(stIndentation + "		// Throws exception");
		lsClass.add(stIndentation + "		throw new " + stExceptionClass + "(\"Error while saving file\", t);");
		lsClass.add(stIndentation + "	}");
		lsClass.add(stIndentation + "}");
	}

	/**
	 * Generation method.
	 * 
	 * @param stIndentation
	 *            Indentation.
	 * @param ndSubject
	 *            Subject node.
	 * @param lsClass
	 *            Class.
	 * @param stImport
	 *            Imports.
	 */
	private void cmdGenerateInstantiator(String stIndentation, Node ndSubject, List<String> lsClass, Set<String> stImport) throws Throwable {

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "/**");
		lsClass.add(stIndentation + " * Constructor.");
		lsClass.add(stIndentation + " * ");

		// Verifies root
		if (!ndSubject.isRoot()) {

			// Generates
			lsClass.add(stIndentation + " * @param ndParent");
			lsClass.add(stIndentation + " *            Parent.");
		}

		// Parameters
		StringBuffer sbParameters = new StringBuffer((ndSubject.isRoot() ? "" : ndSubject.getParentNode().getJavaName() + " ndParent" + (!ndSubject.getAttributes().isEmpty() ? ", " : "")));
		StringBuffer sbParameterPassing = new StringBuffer((ndSubject.isRoot() ? "" : "ndParent" + (!ndSubject.getAttributes().isEmpty() ? ", " : "")));

		// Iterates attributes
		Iterator<Attribute> itAttribute = ndSubject.getAttributes().iterator();
		while (itAttribute.hasNext()) {

			// Gets next attribute
			Attribute atAttribute = itAttribute.next();

			// Generates
			lsClass.add(stIndentation + " * @param " + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName());
			lsClass.add(stIndentation + " *            " + atAttribute.getName() + ".");

			// Appends parameters
			sbParameters.append(atAttribute.getAttributeType().getJavaName() + " " + atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + (itAttribute.hasNext() ? ", " : ""));
			sbParameterPassing.append(atAttribute.getAttributeType().getJavaPrefix() + atAttribute.getJavaName() + (itAttribute.hasNext() ? ", " : ""));
		}

		// Generates
		lsClass.add(stIndentation + " */");
		lsClass.add(stIndentation + "public static " + ndSubject.getJavaName() + " newInstance(" + sbParameters + ") throws " + stExceptionClass + " {");

		// Verifies root
		if (!ndSubject.isRoot()) {

			// Generates
			lsClass.add("");
			lsClass.add(stIndentation + "	// Verifies parent");
			lsClass.add(stIndentation + "	if (ndParent == null) {");
			lsClass.add(stIndentation + "		return null;");
			lsClass.add(stIndentation + "	}");
		}

		// Generates
		lsClass.add("");
		lsClass.add(stIndentation + "	// Returns");
		lsClass.add(stIndentation + "	return new " + ndSubject.getJavaName() + "(" + sbParameterPassing + ");");
		lsClass.add(stIndentation + "}");
	}

	/**
	 * Generation method.
	 * 
	 * @param ndSubject
	 *            Subject node.
	 */
	public void cmdGenerate(Node ndSubject) throws Throwable {

		// Verifies directory
		if (!flDirectory.isDirectory()) {

			// Creates directory
			if (!flDirectory.mkdirs()) {
				throw new ParserGeneratorException("Directory cannot be created");
			}
		}

		// Import set
		Set<String> stImport = new HashSet<String>();

		// Class list
		List<String> lsClass = new LinkedList<String>();

		// Generates
		lsClass.add("/**");
		lsClass.add(" * Auto-generated parser for " + ndSubject.getName() + " node.");
		lsClass.add(" */");
		lsClass.add("public class " + ndSubject.getJavaName() + " {");

		// Verifies root
		if (ndSubject.isRoot()) {

			// Generates node name list
			cmdGenerateNodeNameList("\t", ndSubject, lsClass, stImport);

			// Generates attribute name list
			cmdGenerateAttributeNameList("\t", ndSubject, lsClass, stImport);
		}

		// Generates constants
		cmdGenerateConstants("\t", ndSubject, lsClass, stImport);

		// Generates attributes
		cmdGenerateAttributes("\t", ndSubject, lsClass, stImport);

		// Generates children lists
		cmdGenerateChildrenLists("\t", ndSubject, lsClass, stImport);

		// Generates constructors
		cmdGenerateConstructors("\t", ndSubject, lsClass, stImport);

		// Generates attribute operators
		cmdGenerateAttributeOperators("\t", ndSubject, lsClass, stImport);

		// Generates operators
		cmdGenerateOperators("\t", ndSubject, lsClass, stImport);

		// Generates identificators
		cmdGenerateIdentificators("\t", ndSubject, lsClass, stImport);

		// Generates loader
		cmdGenerateLoader("\t", ndSubject, lsClass, stImport);

		// Verifies root
		if (ndSubject.isRoot()) {

			// Generates multiple loaders
			cmdGenerateMultipleLoaders("\t", ndSubject, lsClass, stImport);
		}

		// Generates saver
		cmdGenerateSaver("\t", ndSubject, lsClass, stImport);

		// Verifies root
		if (ndSubject.isRoot()) {

			// Generates multiple savers
			cmdGenerateMultipleSavers("\t", ndSubject, lsClass, stImport);
		}

		// Generates instantiator
		cmdGenerateInstantiator("\t", ndSubject, lsClass, stImport);

		// Generates
		lsClass.add("}");

		// Creates file
		PrintWriter pwFile = new PrintWriter(new File(flDirectory, ndSubject.getJavaName() + ".java"));
		try {

			// Prints
			pwFile.println("package " + stPackage + ";");
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

		// Iterates nodes
		Iterator<Node> itNode = ndSubject.getNodes().iterator();
		while (itNode.hasNext()) {

			// Gets next node
			Node ndNode = itNode.next();

			// Generates
			cmdGenerate(ndNode);
		}
	}

	/**
	 * Generate attribute types method.
	 * 
	 * @param ndRoot
	 *            Root node.
	 */
	public void cmdGenerateAttributeTypes(Node ndRoot) throws Throwable {

		// Verifies directory
		if (!flDirectory.isDirectory()) {

			// Creates directory
			if (!flDirectory.mkdirs()) {
				throw new ParserGeneratorException("Directory cannot be created");
			}
		}

		// Gets recursive attribute list
		List<Attribute> lsAttribute = ndRoot.getRecursiveAttributeList();

		// Sorts list by attribute name
		Collections.sort(lsAttribute, new Comparator<Attribute>() {

			@Override
			public int compare(Attribute atAttribute1, Attribute atAttribute2) {
				return atAttribute1.getJavaName().compareTo(atAttribute2.getJavaName());
			}
		});

		// Attribute type name set
		Set<String> stAttributeTypeName = new HashSet<String>();

		// Iterates attributes
		Iterator<Attribute> itAttribute = lsAttribute.iterator();
		while (itAttribute.hasNext()) {

			// Gets next attribute
			Attribute atAttribute = itAttribute.next();

			// Verifies duplicates
			if (!stAttributeTypeName.add(atAttribute.getAttributeType().getJavaName().toUpperCase())) {
				continue;
			}

			// Generates
			atAttribute.getAttributeType().cmdGenerateClass(this, atAttribute);
		}
	}
}