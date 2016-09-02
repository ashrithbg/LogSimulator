package com.logsimulator.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Log {
	private int server, cpu, min;
	private StringBuilder line = new StringBuilder();

	private static final String SUB_NET = "192.168.";
	private static final String LOG_DATE = "2014-10-31";

	public Log(int server, int cpu, int min) {
		this.server = server;
		this.cpu = cpu;
		this.min = min;
	}

	public StringBuilder getLine() {
		setTimeStamp();
		setServerName();
		setCpuId();
		setRandomCpuUsage();
		return line;
	}

	private void setServerName() {
		if (server < 256)
			 line.append(SUB_NET).append("0." + server).append(" ");
		else if (server > 255 && server < 512) {
			line.append(SUB_NET).append("1." + (server%256)).append(" ");
		} else if (server > 511 && server < 768) {
			line.append(SUB_NET).append("2." + (server%512)).append(" ");
		} else {
			line.append(SUB_NET).append("3." + (server%768)).append(" ");
		}

	}
	
	private void setCpuId(){
		line.append(cpu).append(" ");
	}

	private void setTimeStamp() {
		long hours = TimeUnit.MINUTES.toHours((long)min);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		Date date = null;
		try {
			date = formatter.parse(LOG_DATE + "-" + hours + "-" + (min % 60));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long output = date.getTime() / 1000L;
		String str = Long.toString(output);
		line.append(str).append(" ");
	}

	private void setRandomCpuUsage() {
		line.append((int) (Math.random() * 100));
	}

}
