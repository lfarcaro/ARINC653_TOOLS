package arinc653.test;

import java.io.File;

import arinc653.configuration.tools.TargetPlatform;
import arinc653.configuration.tools.schedulegenerator.ScheduleGenerator;
import arinc653.configuration.tools.templategenerator.TemplateGenerator;
import arinc653.templatemanager.Artifact;
import arinc653.templatemanager.Language_C;

/**
 * Development test pushing class.
 * 
 * @author Luís Fernando Arcaro
 */
public class DevelopmentTestPush_Z7000 {

	/**
	 * Main method.
	 * 
	 * @param args Arguments.
	 */
	public static void main(String[] args) {
		try {

			boolean blPull = true;
			String stTest = "DEVELOPMENT";
			TargetPlatform tpTargetPlatform = TargetPlatform.ARMV7A_Z7000;
			File flBaseDirectory = new File("D:\\VivadoWorkspace\\ARINC653_ARMV7A_Z7000_v2018.3\\ARINC653_ARMV7A_Z7000.sw\\MEASURE");
			File flTestTemplateDirectory = new File(flBaseDirectory, "src/Application");
			File flTestModule1 = new File(flTestTemplateDirectory, "module1.xml");
			File flTestModule2 = new File(flTestTemplateDirectory, "module2.xml");

			// Artifact
			Artifact arArtifact = null;

			// Pulls development test
			if (blPull) {

				// Creates artifact
				arArtifact = new Artifact(null);

				// Collapses
				arArtifact.cmdCollapse(Language_C.INSTANCE, flTestTemplateDirectory, ".+\\.[ch]", null, false);

				// Saves artifact
				Artifact.cmdSave(arArtifact, new File(flBaseDirectory, stTest + ".art"));
			}

			// Pushes test
			{

				// Creates template generator
				TemplateGenerator tgTemplateGenerator = TemplateGenerator.getInstance(tpTargetPlatform);

				// Generates template
				tgTemplateGenerator.cmdGenerateTemplate(new File[] { flTestModule1, flTestModule2 }, tpTargetPlatform, flTestTemplateDirectory, null, null, null, null);

				// Verifies artifact
				if (arArtifact == null) {

					// Loads artifact
					arArtifact = Artifact.cmdLoad(null, new File(flBaseDirectory, stTest + ".art"));
				}

				// Expands
				arArtifact.cmdExpand(Language_C.INSTANCE, flTestTemplateDirectory, ".+\\.[ch]", null, true);
			}

			// Generates schedule
			ScheduleGenerator.cmdGenerateSchedule(flTestModule1, "PNG", new File(flTestTemplateDirectory, "module1.png"));
			ScheduleGenerator.cmdGenerateSchedule(flTestModule2, "PNG", new File(flTestTemplateDirectory, "module2.png"));
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}
