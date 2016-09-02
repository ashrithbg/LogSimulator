package com.logsimulator.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ServerConfiguration {
	private static final String CONFIG_PATH = "resources/config/config.properties";

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
