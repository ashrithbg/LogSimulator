package com.logsimulator;

import com.logsimulator.utilities.ServerConfiguration;

/**
 * 
 * This class represents the entry class for generating cpu usage logs The class
 * loads the properties such as number of cpus and servers from a properties
 * file through the ServerConfiguration class
 *
 */

public class Generate {
	/**
	 * This is the entry method of the LogSimulator project, creates a LogMaker
	 * object and generates the log file from it
	 * 
	 * @param args
	 *            args[0] is an array which contains the data path where the
	 *            file is supposed to be stoed
	 */
	public static void main(String[] args) {
		checkArguments(args);
		LogMaker lm = new LogMaker();
		lm.setPath(args[0]);
		ServerConfiguration props = new ServerConfiguration();
		lm.setProperties(props.getServerConfiguration());
		lm.generateLogFile();
	}

	/**
	 * This method checks if the shell script/user supplies the correct number
	 * of arguments. Exits if the number of arguments do not match
	 * 
	 * @param args
	 *            arguments representing the data path
	 */
	private static void checkArguments(String args[]) {
		if (args.length == 0) {
			System.out.println("Plese enter the data path and run again");
			System.exit(0);
		} else if (args.length > 1) {
			System.out.println("Wrong number of arguments");
			System.exit(0);
		}

	}

}
