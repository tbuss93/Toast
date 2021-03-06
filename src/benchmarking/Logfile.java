package benchmarking;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Logfile {
	public static File file = new File("Log.txt");
	public static FileWriter writer;
	public static Scanner sc = new Scanner(System.in);
	public static boolean logging = true;

	public static StringBuilder sb = new StringBuilder();

	/**
	 * Methode zum erstellen eines Objektes in dem das Aktuelle Datum mit der
	 * Uhrzeit übergeben wird
	 * 
	 * @return timestamp-Objekt
	 */
	public static String getDate() {
		Date timestamp = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd.MM.yyyy HH:mm:ss");

		return simpleDateFormat.format(timestamp);
	}

	/**
	 * Methode zum schreiben aller Daten in die Log-Datei. Zur Übersichtlichkeit
	 * des Logs werden nach jedem Eintrag 2 Absätze eingefügt.
	 * 
	 * @param log
	 *            Bekommt einen kompletten String der alle Daten für das Logfile
	 *            übergeben.
	 * @throws IOException
	 */
	public static void updateLog(String log) throws IOException {
		if (logging == true) {
			writer = new FileWriter(file, true);
			writer.write(log);
			writer.write(System.getProperty("line.separator"));
			writer.write(System.getProperty("line.separator"));
			writer.flush();
			writer.close();
		}
	}

	/**
	 * Methode zu leeren des Logfiles. Das leeren wird durch ein setzten eines
	 * leeren Strings gewährleistet.
	 * 
	 * @throws IOException
	 */
	public static void clearLog() throws IOException {
		FileOutputStream writer = new FileOutputStream("Log.txt");
		writer.write((new String()).getBytes());
		writer.close();
	}

	/**
	 * Methode zum Auslesen und Ausgeben der Log.txt
	 * 
	 * @throws IOException
	 */
	public static void readLog() throws IOException {

		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader("Log.txt");
			br = new BufferedReader(fr);

			String line;
			line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

			fr.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Lesen der Datei ");
			System.out.println(e.toString());
		}

	}

}

//

