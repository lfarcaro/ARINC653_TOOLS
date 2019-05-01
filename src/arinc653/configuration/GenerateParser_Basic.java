package arinc653.configuration;

import arinc653.configuration.parsergenerator.Node;
import arinc653.configuration.parsergenerator.ParserGenerator;

/**
 * Class for generating the parser - Basic.
 * 
 * @author Luís Fernando Arcaro
 */
public class GenerateParser_Basic {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {

		// Prepares module node
		Node ndModule = ParserDefinition_Basic.cmdPrepareModuleNode();

		// Generates parser
		try {

			// Creates parser generator
			ParserGenerator pgParserGenerator = new ParserGenerator(ParserDefinition_Basic.flDirectory, ParserDefinition_Basic.stPackage, ParserDefinition_Basic.stResourcesPackage, ParserDefinition_Basic.stExceptionClass);

			// Generates attribute types
			pgParserGenerator.cmdGenerateAttributeTypes(ndModule);

			// Generates
			pgParserGenerator.cmdGenerate(ndModule);
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}