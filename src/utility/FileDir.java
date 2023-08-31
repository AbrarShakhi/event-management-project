package utility;

import java.io.File;
import java.io.FileWriter;

public class FileDir {
	public static void createDir(String dir) {
		File path = new File(dir);

		if (!path.exists())
			path.mkdir();
	}

	public static boolean isExists(String path) {
		return new File(path).exists();
	}

	public static void resetFile(String filePath, String input) {

		createDir(FilePaths.DATA_FOLDER);

		FileWriter fr = null;

		try {
			fr = new FileWriter(FilePaths.DATA_FOLDER + "/" + filePath);
			fr.write(input);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fr != null)
				try {
					fr.close();
				} catch (Exception e) {
				}
		}

	}

}