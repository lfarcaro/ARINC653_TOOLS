package arinc653.configuration;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import arinc653.configuration.parser.Module;

/**
 * Configuration.
 * 
 * @author Luís Fernando Arcaro
 */
public class Configuration {

	/**
	 * Core count.
	 */
	private int inCoreCount;

	/**
	 * Module list (one per core).
	 */
	private List<Module> lsModule = new LinkedList<Module>();

	/**
	 * Constructor.
	 * 
	 * @param inCoreCount Core count.
	 * @param ndModule    Modules (one per core).
	 */
	public Configuration(int inCoreCount, Module[] ndModule) throws Throwable {
		this.inCoreCount = inCoreCount;
		this.lsModule.addAll(Arrays.asList(ndModule));

		// Verifies module count
		if (ndModule.length != inCoreCount) {
			throw new Exception("ERROR: Exactly one module per core must be supplied");
		}

		// Iterates cores
		for (int inCore = 0; inCore < inCoreCount; inCore++) {

			// Verifies module
			if (ndModule[inCore] == null) {
				throw new Exception("ERROR: Null configuration provided for module at Core #" + inCore);
			}
		}
	}

	/**
	 * Core count getter.
	 */
	public int getCoreCount() {
		return inCoreCount;
	}

	/**
	 * Module list getter.
	 */
	public List<Module> getModuleList() {
		return lsModule;
	}
}
