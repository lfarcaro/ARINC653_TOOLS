package arinc653.templatemanager;

/**
 * Language.
 * 
 * @author Luís Fernando Arcaro
 */
public abstract class Language {

	/**
	 * Returns a pattern that matches snippet entries of a given artifact (if
	 * one is supplied). There must be two groups: the first returns the
	 * indentation (tabs) of the snippet, the second returns the snippet name.
	 * 
	 * @param stArtifactName
	 *            Artifact name.
	 */
	public abstract String getArtifactSnippetPattern(String stArtifactName);

	/**
	 * Returns a pattern that matches snippet start lines of a given artifact
	 * (if one is supplied). There must be a first group that returns the
	 * indentation (tabs) of the snippet. A second group is optional and may
	 * return the snippet name.
	 * 
	 * @param stArtifactName
	 *            Artifact name.
	 */
	public abstract String getArtifactSnippetStartPattern(String stArtifactName);

	/**
	 * Returns a pattern that matches snippet end lines of a given artifact (if
	 * one is supplied). There must be a first group that returns the
	 * indentation (tabs) of the snippet. A second group is optional and may
	 * return the snippet name.
	 * 
	 * @param stArtifactName
	 *            Artifact name.
	 */
	public abstract String getArtifactSnippetEndPattern(String stArtifactName);

	/**
	 * Returns the line that marks the insertion point of the given snippet of
	 * the given artifact with the given indentation.
	 * 
	 * @param stSnippetIndentation
	 *            Snippet indentation.
	 * @param stArtifactName
	 *            Artifact name.
	 * @param stSnippetName
	 *            Snippet name.
	 */
	public abstract String getArtifactSnippet(String stSnippetIndentation, String stArtifactName, String stSnippetName);

	/**
	 * Returns the line that marks the start of the given snippet of the given
	 * artifact with the given indentation.
	 * 
	 * @param stSnippetIndentation
	 *            Snippet indentation.
	 * @param stArtifactName
	 *            Artifact name.
	 * @param stSnippetName
	 *            Snippet name.
	 */
	public abstract String getArtifactSnippetStart(String stSnippetIndentation, String stArtifactName, String stSnippetName);

	/**
	 * Returns the line that marks the end of the given snippet of the given
	 * artifact with the given indentation.
	 * 
	 * @param stSnippetIndentation
	 *            Snippet indentation.
	 * @param stArtifactName
	 *            Artifact name.
	 * @param stSnippetName
	 *            Snippet name.
	 */
	public abstract String getArtifactSnippetEnd(String stSnippetIndentation, String stArtifactName, String stSnippetName);
}