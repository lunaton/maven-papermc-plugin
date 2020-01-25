import java.io.File;
import java.io.IOException;

public class Main {

	private static final String[] cmd = {
			"java",
			"-Xms2G",
			"-Xmx2G",
			"-jar",
			"paper-75.jar",
			"nogui"
	};

	private static final String directoryPath = "D:/Users/Alejandro/Documents/PaperCraft";

//	public static void main(String[] args) {
////		process();
//		processBuilder();
//	}

	private static void processBuilder() {
		ProcessBuilder processBuilder = new ProcessBuilder(cmd);
		processBuilder.directory(new File(directoryPath));
		processBuilder.inheritIO();

		try {
			Process process = processBuilder.start();
			process.waitFor();

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
