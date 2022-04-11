package arinc653.configuration;

import arinc653.configuration.parsergenerator.Node;
import arinc653.configuration.parsergenerator.ParserGenerator;

/**
 * Class for generating the parser - Extended.
 * 
 * @author Luís Fernando Arcaro
 */
public class GenerateParser_Extended {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {

		// Prepares module node
		Node ndModule = ParserDefinition_Extended.cmdPrepareModuleNode();

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