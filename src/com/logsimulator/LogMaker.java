package com.logsimulator;

import java.util.Properties;

import com.logsimulator.utilities.FileOperations;

/**
 * 
 * This class builds the log content followed by making a single write call to
 * the file
 * 
 *
 */
public class LogMaker {
	/**
	 * getters and setters for the path and properties variables
	 */
	private String path;
	private Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * This method generates a log object for each of the s*c*24*60 lines to be
	 * generated which would eventually be written into a file
	 * 
	 * @return a string builder object which has s*c*24*60 lines separated by
	 *         "\n" where 's' represents the number of servers, 'c' represents
	 *         the number of cpus
	 */
	public StringBuilder buildLogContent() {
		StringBuilder sb = new StringBuilder();

		int numberOfServers = Integer.parseInt(properties.getProperty("numberOfServers"));
		int numberOfCpus = Integer.parseInt(properties.getProperty("numberOfCpus"));
		int numberOfDays = Integer.parseInt(properties.getProperty("numberOfDays"));
		int numberOfMins = numberOfDays * 24 * 60;

		for (int server = 0; server < numberOfServers; server++) {
			for (int cpu = 0; cpu < numberOfCpus; cpu++) {
				for (int min = 0; min < numberOfMins; min++) {
					sb.append(new Log(server, cpu, min).getLine()).append("\n");
				}
			}
		}
		return sb;

	}

	/**
	 * This method makes a final write of the StringBuilder object to the
	 * DATA_PATH directory
	 */

	public void generateLogFile() {
		FileOperations operator = new FileOperations(path);
		operator.writeFile(buildLogContent());
	}

}
