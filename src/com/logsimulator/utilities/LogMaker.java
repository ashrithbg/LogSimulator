package com.logsimulator.utilities;

import java.util.Properties;

public class LogMaker {
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
	
	public void generateLogFile(){
		FileOperations operator = new FileOperations(path);
		operator.writeFile(buildLogContent());
	}

}
