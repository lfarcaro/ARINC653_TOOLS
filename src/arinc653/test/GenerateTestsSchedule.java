package arinc653.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import arinc653.configuration.parser.Module;
import arinc653.configuration.parser.ModuleSchedule;
import arinc653.configuration.parser.Partition;
import arinc653.configuration.parser.PartitionSchedule;
import arinc653.configuration.parser.WindowSchedule;

/**
 * Tests' schedule generation class.
 * 
 * @author Luís Fernando Arcaro
 */
public class GenerateTestsSchedule {

	/**
	 * Seconds decimal format.
	 */
	private static DecimalFormat dfSeconds;
	static {
		DecimalFormatSymbols dfsSeconds = new DecimalFormatSymbols();
		dfsSeconds.setDecimalSeparator('.');
		dfSeconds = new DecimalFormat("0.###s", dfsSeconds);
	}

	/**
	 * Format seconds method.
	 * 
	 * @param obNumber
	 *            Number.
	 */
	private static String cmdFormatSeconds(Object obNumber) {
		return (obNumber == null ? "-" : dfSeconds.format(obNumber));
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {
		try {

			// Color list
			List<Color> lsColor = Arrays.asList(new Color[] { new Color(34, 177, 76), new Color(0, 128, 255), new Color(255, 128, 128), new Color(181, 181, 181), Color.BLUE, Color.YELLOW, Color.RED, Color.CYAN });

			// Iterates tests
			Iterator<String> itTest = TestUtilities.getTests().iterator();
			while (itTest.hasNext()) {

				// Gets next test
				String stTest = itTest.next();

				// Loads module
				Module ndModule = Module.cmdLoadFile(new File("Test/Output/AM335X/" + stTest + "/module.xml"));

				int inColorIndex = 0;
				int inWidth = 768;
				int inHeight = 80;
				int inLeftMargin = 10;
				int inRightMargin = 10;
				int inTopMargin = 20;
				int inBottomMargin = 20;
				int inTopTextMargin = 10;

				BufferedImage bi = new BufferedImage(inWidth, inHeight, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = (Graphics2D) bi.getGraphics();
				g.setColor(Color.BLACK);
				g.drawRect(inLeftMargin, inTopMargin, inWidth - inLeftMargin - inRightMargin - 1, inHeight - inTopMargin - inBottomMargin - 1);

				// Gets module schedule
				ModuleSchedule ndModuleSchedule = ndModule.getModuleScheduleList().get(0);

				String stMajorFrameStart = "0s";
				g.drawString(stMajorFrameStart, inLeftMargin - (g.getFontMetrics().stringWidth(stMajorFrameStart) / 2), inTopTextMargin);

				String stMajorFrameEnd = cmdFormatSeconds(ndModuleSchedule.getMajorFrameSeconds());
				g.drawString(stMajorFrameEnd, inWidth - inRightMargin - (g.getFontMetrics().stringWidth(stMajorFrameEnd) / 2), inTopTextMargin);

				double dbTotal = ndModuleSchedule.getMajorFrameSeconds().doubleValue();
				Set<String> stDrawn = new HashSet<String>();

				// Iterates partitions
				Iterator<Partition> itPartition = ndModule.getPartitionList().iterator();
				while (itPartition.hasNext()) {

					// Gets next partition
					Partition ndPartition = itPartition.next();

					// Gets partition schedule
					PartitionSchedule ndPartitionSchedule = ndModuleSchedule.getPartitionSchedule(ndPartition.getPartitionIdentifier());

					Color clPartition = lsColor.get(inColorIndex++);

					// Iterates window schedules
					Iterator<WindowSchedule> itWindowSchedule = ndPartitionSchedule.getWindowScheduleList().iterator();
					while (itWindowSchedule.hasNext()) {

						// Gets next window schedule
						WindowSchedule ndWindowSchedule = itWindowSchedule.next();

						double dbWindowStart = ndWindowSchedule.getWindowStartSeconds().doubleValue();
						double dbWindowDuration = ndWindowSchedule.getWindowDurationSeconds().doubleValue();
						double dbWindowEnd = dbWindowStart + dbWindowDuration;

						g.setColor(Color.BLACK);
						String stWindowStart = cmdFormatSeconds(dbWindowStart);
						if (!stDrawn.contains(stWindowStart)) {
							g.drawString(stWindowStart, (int) (inLeftMargin - (g.getFontMetrics().stringWidth(stWindowStart) / 2) + ((dbWindowStart * inWidth) / dbTotal)), inTopTextMargin);
							stDrawn.add(stWindowStart);
						}
						String stWindowEnd = cmdFormatSeconds(dbWindowEnd);
						if (!stDrawn.contains(stWindowEnd)) {
							g.drawString(stWindowEnd, (int) (inLeftMargin - (g.getFontMetrics().stringWidth(stWindowEnd) / 2) + ((dbWindowEnd * inWidth) / dbTotal)), inTopTextMargin);
							stDrawn.add(stWindowEnd);
						}

						g.setColor(clPartition);
						g.fillRect(inLeftMargin + (int) ((dbWindowStart * inWidth) / dbTotal), inTopMargin, (int) ((dbWindowDuration * inWidth) / dbTotal), inHeight - inTopMargin - inBottomMargin - 1);
						g.setColor(Color.BLACK);
						g.drawRect(inLeftMargin + (int) ((dbWindowStart * inWidth) / dbTotal), inTopMargin, (int) ((dbWindowDuration * inWidth) / dbTotal), inHeight - inTopMargin - inBottomMargin - 1);
					}
				}

				ImageIO.write(bi, "PNG", new File("Test/Schedule/" + stTest + ".png"));
			}
		} catch (Throwable t) {

			// Prints error
			t.printStackTrace();
		}
	}
}