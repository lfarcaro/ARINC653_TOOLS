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
public class DevelopmentTestPush_AM335X {

	/**
	 * Main method.
	 * 
	 * @param args Arguments.
	 */
	public static void main(String[] args) {
		try {

			boolean blPull = true;
			String stTest = "DEVELOPMENT";
			TargetPlatform tpTargetPlatform = TargetPlatform.ARMV7A_AM335X;
			File flTestTemplateDirectory = new File(Tests.flARINC653Directory, "Application");
			File flTestModule = new File(flTestTemplateDirectory, "module.xml");

			// Artifact
			Artifact arArtifact = null;

			// Pulls development test
			if (blPull) {

				// Creates artifact
				arArtifact = new Artifact(null);

				// Collapses
				arArtifact.cmdCollapse(Language_C.INSTANCE, flTestTemplateDirectory, ".+\\.[ch]", null, false);

				// Saves artifact
				Artifact.cmdSave(arArtifact, new File(Tests.flARINC653Directory, stTest + ".art"));
			}

			// Pushes test
			{

				// Creates template generator
				TemplateGenerator tgTemplateGenerator = TemplateGenerator.getInstance(tpTargetPlatform);

				// Generates template
				tgTemplateGenerator.cmdGenerateTemplate(new File[] { flTestModule }, tpTargetPlatform, flTestTemplateDirectory, null, null, null, null);

				// Verifies artifact
				if (arArtifact == null) {

					// Loads artifact
					arArtifact = Artifact.cmdLoad(null, new File(Tests.flARINC653Directory, stTest + ".art"));
				}

				// Expands
				arArtifact.cmdExpand(Language_C.INSTANCE, flTestTemplateDirectory, ".+\\.[ch]", null, true);
			}

			// Generates schedule
			ScheduleGenerator.cmdGenerateSchedule(flTestModule, "PNG", new File(flTestTemplateDirectory, "module.png"));
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}
