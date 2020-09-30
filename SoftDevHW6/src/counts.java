
// TODO: Auto-generated Javadoc
/**
 * The Class counts.
 */
public class counts {

	/**
	 * Counting file.
	 *
	 * @param files the file selected
	 * @return the total lines of code
	 */
	// GET TOTAL COUNT WITHOUT COMMENTS
	public static int countingFile(String[] files) {
		int lines = 0;
		for (int i = 0; i <= files.length - 1; i++) {
			lines++;
			if (files[i].startsWith("//") || files[i].startsWith("/*")) {
				lines--;
				if (files[i].contains("/*")) {
					while (!files[i].contains("*/")) {
						i++;
					}
				}
			}
		}
		return lines;
	}

	/**
	 * Count loops.
	 *
	 * @param files the file selected
	 * @return the number of time each looping method is used
	 */
	public static String[][] countLoops(String[] files) {
		String[][] loops = new String[4][2];
		int fors = 0, ifs = 0, whiles = 0, switchs = 0;
		loops[0][0] = "for";
		loops[1][0] = "if";
		loops[2][0] = "while";
		loops[3][0] = "switch";
		for (int i = 0; i <= files.length - 1; i++) {
			if (files[i].contains("for"))
				fors++;
			else if (files[i].contains("if"))
				ifs++;
			else if (files[i].contains("while"))
				whiles++;
			else if (files[i].contains("switch"))
				switchs++;
		}
		loops[0][1] = Integer.toString(fors);
		loops[1][1] = Integer.toString(ifs);
		loops[2][1] = Integer.toString(whiles);
		loops[3][1] = Integer.toString(switchs);
		return loops;

	}

	/**
	 * Count methods.
	 *
	 * @param files the file selected
	 * @return the name of each method and the lines of code in each
	 */
	public static String countMethods(String[] files) {
		String mName = "";
		String ans = "";
		int mLoc = 0;
		int end = 0;
		int start = 0;
		// FINDING START OF METHOD INDEX AND METHOD NAME
		for (int i = 0; i <= files.length - 1; i++) {
			if (files[i].contains("public") && files[i].contains("{") && !files[i].contains("class")
					|| files[i].contains("private") && files[i].contains("{") && !files[i].contains("class")) {
				end = files[i].indexOf("(");
				int holder = end;
				while (files[i].charAt(holder) != ' ') {
					holder--;
				}
				start = holder;
				mName = files[i].substring(start + 1, end);
				mLoc = locMethod(files, i);
				ans += "Method Name: " + mName + " Loc: " + Integer.toString(mLoc) + "\n";
			}
		}

		System.out.println(ans);
		return ans;
	}

	/**
	 * Loc method.
	 *
	 * @param files the file selected
	 * @param index start index of method
	 * @return the lines of code in method
	 */
	public static int locMethod(String[] files, int index) {
		int ans = 0;
		int opens = 0;
		int start = index;
		int end = 0;
		// FIND START AND END INDEX OF METHOD
		for (int i = index; i <= files.length - 1; i++) {
			if (files[i].contains("{") && files[i].contains("}"))
				i++;
			else if (files[i].contains("{"))
				opens++;
			else if (files[i].contains("}"))
				opens--;
			if (opens == 0) {
				end = i;
				break;
			}
		}
		// COUNT LINES
		for (int i = start; i <= end; i++) {
			ans++;
			if (files[i].contains("//") || files[i].contains("/*")) {
				ans--;
				if (files[i].contains("/*")) {
					while (!files[i].contains("*/")) {
						i++;
					}
				}
			}
		}
		return ans;

	}

}
