package arinc653.templatemanager;

import java.util.regex.Pattern;

/**
 * C language.
 * 
 * @author Luís Fernando Arcaro
 */
public class Language_C extends Language {

	/**
	 * Instance.
	 */
	public static final Language_C INSTANCE = new Language_C();

	@Override
	public String getArtifactSnippetPattern(String stArtifactName) {
		return "^([\\t ]*)" + Pattern.quote("//") + (stArtifactName != null ? Pattern.quote(" ARTIFACT " + stArtifactName) : "") + Pattern.quote(" SNIPPET ") + "(.+)?$";
	}

	@Override
	public String getArtifactSnippetStartPattern(String stArtifactName) {
		return "^([\\t ]*)" + Pattern.quote("//") + (stArtifactName != null ? Pattern.quote(" ARTIFACT " + stArtifactName) : "") + Pattern.quote(" SNIPPET_START") + "(?: (.+))?$";
	}

	@Override
	public String getArtifactSnippetEndPattern(String stArtifactName) {
		return "^([\\t ]*)" + Pattern.quote("//") + (stArtifactName != null ? Pattern.quote(" ARTIFACT " + stArtifactName) : "") + Pattern.quote(" SNIPPET_END") + "$";
	}

	@Override
	public String getArtifactSnippet(String stSnippetIndentation, String stArtifactName, String stSnippetName) {
		return stSnippetIndentation + "//" + (stArtifactName != null ? " ARTIFACT " + stArtifactName : "") + " SNIPPET " + stSnippetName;
	}

	@Override
	public String getArtifactSnippetStart(String stSnippetIndentation, String stArtifactName, String stSnippetName) {
		return stSnippetIndentation + "//" + (stArtifactName != null ? " ARTIFACT " + stArtifactName : "") + " SNIPPET_START" + (!stSnippetName.matches("^[0-9]+$") ? " " + stSnippetName : "");
	}

	@Override
	public String getArtifactSnippetEnd(String stSnippetIndentation, String stArtifactName, String stSnippetName) {
		return stSnippetIndentation + "//" + (stArtifactName != null ? " ARTIFACT " + stArtifactName : "") + " SNIPPET_END";
	}
}