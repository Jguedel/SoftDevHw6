/*
 * @author jguedel
 * @version 1.0
 * 
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// TODO: Auto-generated Javadoc
/**
 * The Class inputs.
 */
public class inputs {
	
	/** The files. */
	private static String[] files;
	
	/** The loc. */
	private static int loc;
	
	/** The loops. */
	private static String[][] loops;

	/**
	 * File.
	 *
	 * @param inp the inp
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void file(File inp) throws IOException {
		String input = new String(Files.readAllBytes(Paths.get(inp.toString())));
		// ELIMINATE BLANK SPACE
		input = input.replaceAll(" ", "@"); // SPACES NOW EQUAL @
		input = input.replaceAll("\\s+", " ");
		// SPLIT EVERY LINE INTO ARRAY
		files = input.split(" ");
		// CHANGES SPACES BACK
		for (int i = 0; i <= files.length - 1; i++) {
			files[i] = files[i].replaceAll("@", " ");
		}
		loc = counts.countingFile(files);
		loops = counts.countLoops(files);

	}
	
	/**
	 * Gets the loops.
	 *
	 * @return the loops
	 */
	public static String getLoops() {
		String ans= "";
		for(int i = 0; i <= 3; i++) {
				ans += loops[i][0];
				ans += ": ";
				ans += loops[i][1];
				ans += "\n";
			
		}
		return ans;
		
	}

	/**
	 * Gets the loc.
	 *
	 * @return the loc
	 */
	public static int getLoc() {
		return loc;
	}

}
