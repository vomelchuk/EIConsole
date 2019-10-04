package com.ei.util;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class EILogger {
//	private static EILogger instance;
	private Logger logger;

	public EILogger() {
		this.logger = Logger.getLogger(EILogger.class.getName());
		DOMConfigurator.configure("log4j.xml");
	}

//	public static EILogger getInstance() {
//		if (instance == null) {
//			instance = new EILogger();
//		}
//		return instance;
//	}

	public void debug(String message) {
		this.logger.debug(message);
	}
	
	public void info(String message) {
		this.logger.info(message);
	}

	public void warn(String message) {
		this.logger.warn(message);
	}
	public void error(String message) {
		this.logger.error(message);
	}

}
