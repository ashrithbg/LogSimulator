package com.logsimulator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 
 * A model class representing each line to be written into the log file It has
 * fields like server ip, cpu id, minutes etc It generates a server name
 * starting from SUB_NET address making sure that the ip is a valid ip address
 * 
 */
public class Log {
	/**
	 * Variables representing the server ip, cpu id, minute respectively
	 */
	private int server, cpu, min;
	/**
	 * Variable which has a running string of the log line to be eventually
	 * written into the log file
	 */
	private StringBuilder line = new StringBuilder();
	/**
	 * the starting sub net from which the server name generation should start
	 */
	private static final String SUB_NET = "192.168.";
	/**
	 * the date for which the logs should be generated
	 */
	private static final String LOG_DATE = "2014-10-31";
	/**
	 * The format of the date which will be used through out the project
	 */
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

	/**
	 * A constructor which sets the server number, cpu id and minutes, called
	 * from the LogMaker class
	 * 
	 * @param server
	 *            the number of the server(1..n)
	 * @param cpu
	 *            the cpu id
	 * @param min
	 *            the minute of the day
	 */

	public Log(int server, int cpu, int min) {
		this.server = server;
		this.cpu = cpu;
		this.min = min;
	}

	/**
	 * this method constructs a formatted log line to be written into the log
	 * file
	 * 
	 * @return a string builder object which contains a log line in the format
	 *         TIMESTAMP IP ADDRESS CPU_ID CPU_USAGE
	 * 
	 */
	public StringBuilder getLine() {
		setTimeStamp();
		setServerName();
		setCpuId();
		setRandomCpuUsage();
		return line;
	}

	/**
	 * Helper method to generate a server ip address between 1 and n where 'n'
	 * represents the number of servers. for example if SUB_NET is "192.168.",
	 * and server number is 256 the ip address generated would be 192.168.2.0
	 */
	private void setServerName() {
		if (server < 256)
			line.append(SUB_NET).append("0." + server).append(" ");
		else if (server > 255 && server < 512) {
			line.append(SUB_NET).append("1." + (server % 256)).append(" ");
		} else if (server > 511 && server < 768) {
			line.append(SUB_NET).append("2." + (server % 512)).append(" ");
		} else {
			line.append(SUB_NET).append("3." + (server % 768)).append(" ");
		}

	}

	/**
	 * Helper method to append cpu id to the exisiting log line
	 */

	private void setCpuId() {
		line.append(cpu).append(" ");
	}

	/**
	 * Helper method to form a timestamp from the date string of the format
	 * "yyyy-MM-dd HH:mm"
	 */
	private void setTimeStamp() {
		long hours = TimeUnit.MINUTES.toHours((long) min);
		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		Date date = null;
		try {
			date = formatter.parse(LOG_DATE + " " + hours + ":" + (min % 60));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long output = date.getTime() / 1000L;
		String str = Long.toString(output);
		line.append(str).append(" ");
	}

	/**
	 * Helper method to generate a random number between 1 and 100 which will be
	 * set as the cpu usage for that minute
	 */

	private void setRandomCpuUsage() {
		line.append((int) (Math.random() * 100));
	}

}
