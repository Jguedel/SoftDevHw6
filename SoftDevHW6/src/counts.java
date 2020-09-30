
public class counts {

	// GET TOTAL COUNT WITHOUT COMMENTS
	public static int countingFile(String[] files) {
		int lines = 0;
		for (int i = 0; i <= files.length - 1; i++) {
			lines++;
			if (files[i].contains("//") || files[i].contains("/*") || files[i].contains("*/")) {
				lines--;
			}
		}
		return lines;
	}
	
	public static String[][] countLoops(String[] files) {
		String[][] loops = new String[4][2];
		int fors = 0, ifs = 0, whiles = 0, switchs = 0;
		loops[0][0] = "for";
		loops[1][0] = "if";
		loops[2][0] = "while";
		loops[3][0] = "switch";
		for (int i = 0; i <= files.length - 1; i++) {
			if(files[i].contains("for"))
				fors++;
			else if(files[i].contains("if"))
				ifs++;
			else if(files[i].contains("while"))
				whiles++;
			else if(files[i].contains("switch"))
				switchs++;
		}
		loops[0][1] = Integer.toString(fors);
		loops[1][1] = Integer.toString(ifs);
		loops[2][1] = Integer.toString(whiles);
		loops[3][1] = Integer.toString(switchs);
		return loops;
		
	}

}
