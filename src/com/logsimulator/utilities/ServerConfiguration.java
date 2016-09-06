package com.logsimulator.utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class represents the configuration variables such as number of servers,
 * number of cpus per server, number of days.
 */
public class ServerConfiguration {
	/**
	 * the path of the configuration file
	 */
	private static final String CONFIG_PATH = "resources/config/config.properties";

	/**
	 * reads the config.properties file, maps the file into a Properties object
	 * 
	 * @return Properties object which would be eventually used in the LogMaker
	 *         class
	 */

	public Properties getServerConfiguration() {
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileOperations(CONFIG_PATH).readFile();
			properties.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
