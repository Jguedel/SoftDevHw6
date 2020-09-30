import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class inputs {
	private static String[] files;
	private static int loc;
	private static String[][] loops;

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

	public static int getLoc() {
		return loc;
	}

}
