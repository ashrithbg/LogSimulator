package com.logsimulator;

import com.logsimulator.utilities.ServerConfiguration;

public class Generate {
	/**
	 * 
	 * @param args - 
	 */
	public static void main(String[] args) {
		LogMaker lm = new LogMaker();
		lm.setPath("/Users/abangi/Documents/workspace/LogSimulator/log.txt");
		ServerConfiguration props = new ServerConfiguration();
		lm.setProperties(props.getServerConfiguration());
		lm.generateLogFile();
	}

}
