package arinc653.templatemanager;

import java.util.LinkedList;
import java.util.List;

/**
 * Snippet.
 * 
 * @author Luís Fernando Arcaro
 */
public class Snippet {

	/**
	 * Value.
	 */
	private List<String> lsValue;

	/**
	 * Constructor.
	 */
	public Snippet() {
		this.lsValue = new LinkedList<String>();
	}

	/**
	 * Constructor.
	 * 
	 * @param lsValue
	 *            Value.
	 */
	public Snippet(List<String> lsValue) {
		this.lsValue = new LinkedList<String>(lsValue);
	}

	/**
	 * Value getter.
	 */
	public List<String> getValue() {
		return lsValue;
	}

	/**
	 * Clone method.
	 */
	public Snippet cmdClone() {

		// Creates clone
		Snippet snClone = new Snippet();

		// Fills clone
		snClone.lsValue.addAll(lsValue);
		return snClone;
	}
}