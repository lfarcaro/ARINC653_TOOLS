package arinc653.test;

import java.io.File;

import arinc653.configuration.tools.TargetPlatform;

/**
 * Current test.
 * 
 * @author Luís Fernando Arcaro
 */
public class CurrentTest {

	/**
	 * ARINC653 directory.
	 */
	public static File flARINC653Directory = new File("/CCSWorkspace/ARINC653_AM335X");

	/**
	 * Target platform.
	 */
	public static TargetPlatform tpTargetPlatform = TargetPlatform.AM335X;

	/**
	 * Current test.
	 */
	public static String stCurrentTest = "001_SLOWPARTITIONSCHEDULING";

	/**
	 * Output directory.
	 */
	public static File flOutputDirectory = new File(flARINC653Directory, "Application");
}