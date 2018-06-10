import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Log {
	private static Log instance;
	public DateTime date;
	private static File file = new File("logs.txt");;

	private Log() {
		date = new DateTime();
	}

	public static Log getInstance() {
		if (instance == null) {
			instance = new Log();
			instance.addToFile();
		}
		return instance;
	}

	private void addToFile() {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file, true));
			out.write(instance + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
