package arinc653.templatemanager;

import java.util.regex.Pattern;

/**
 * XML language.
 * 
 * @author Luís Fernando Arcaro
 */
public class Language_XML extends Language {

	/**
	 * Instance.
	 */
	public static final Language_XML INSTANCE = new Language_XML();

	@Override
	public String getArtifactSnippetPattern(String stArtifactName) {
		return "^(\\t*)" + Pattern.quote("<!--") + (stArtifactName != null ? Pattern.quote(" ARTIFACT " + stArtifactName) : "") + Pattern.quote(" SNIPPET ") + "(.+)?" + Pattern.quote(" -->") + "$";
	}

	@Override
	public String getArtifactSnippetStartPattern(String stArtifactName) {
		return "^(\\t*)" + Pattern.quote("<!--") + (stArtifactName != null ? Pattern.quote(" ARTIFACT " + stArtifactName) : "") + Pattern.quote(" SNIPPET_START") + "(?: (.+))?" + Pattern.quote(" -->") + "$";
	}

	@Override
	public String getArtifactSnippetEndPattern(String stArtifactName) {
		return "^(\\t*)" + Pattern.quote("<!--") + (stArtifactName != null ? Pattern.quote(" ARTIFACT " + stArtifactName) : "") + Pattern.quote(" SNIPPET_END") + Pattern.quote(" -->") + "$";
	}

	@Override
	public String getArtifactSnippet(String stSnippetIndentation, String stArtifactName, String stSnippetName) {
		return stSnippetIndentation + "<!--" + (stArtifactName != null ? " ARTIFACT " + stArtifactName : "") + " SNIPPET " + stSnippetName + " -->";
	}

	@Override
	public String getArtifactSnippetStart(String stSnippetIndentation, String stArtifactName, String stSnippetName) {
		return stSnippetIndentation + "<!--" + (stArtifactName != null ? " ARTIFACT " + stArtifactName : "") + " SNIPPET_START" + (!stSnippetName.matches("^[0-9]+$") ? " " + stSnippetName : "") + " -->";
	}

	@Override
	public String getArtifactSnippetEnd(String stSnippetIndentation, String stArtifactName, String stSnippetName) {
		return stSnippetIndentation + "<!--" + (stArtifactName != null ? " ARTIFACT " + stArtifactName : "") + " SNIPPET_END -->";
	}
}