package com.logsimulator.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * Utility class to interact with files
 *
 */
public class FileOperations {
	/**
	 * the log file name to be generated
	 */
	private static final String logFileName = "log.txt";
	/**
	 * the data path directory where the log file will be stored
	 */
	private String path;

	/**
	 * A constructor which sets the data path for the FileOperations object
	 * @param path the data directory location in disk
	 */
	public FileOperations(String path) {
		this.path = path;
	}

	/**
	 * A helper method which reads a file(config.properties) and returns a file
	 * input stream
	 * 
	 * @return file input stream
	 * @throws FileNotFoundException when file path does not map to a physical location on disk
	 * @throws IOException when there is a run time exception while reading the file
	 */

	public FileInputStream readFile() throws FileNotFoundException, IOException {
		File file = new File(path);
		FileInputStream fileInput = new FileInputStream(file);
		return fileInput;
	}

	/**
	 * A helper method which writes a string builder object into file by
	 * converting it into bytes
	 * 
	 * @param sb
	 *            a string builder object which represents all the logs for all
	 *            the servers and cpus
	 */
	public void writeFile(StringBuilder sb) {
		File file = new File(path + "/" + logFileName);

		String content = sb.toString();
		try (FileOutputStream fop = new FileOutputStream(file)) {

			if (!file.exists()) {
				file.createNewFile();
			}

			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

		} catch (FileNotFoundException e) {
			System.out.println("the path " + path + " does'nt exist");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
