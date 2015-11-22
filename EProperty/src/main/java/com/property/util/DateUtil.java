package com.property.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.property.constants.ApplicationConstants;

import org.apache.log4j.Logger;

public class DateUtil {

	private static Logger logger = Logger.getLogger(DateUtil.class);
	private static DateUtil instance = new DateUtil();
	private DateFormat dateFormat;
	private DateFormat timestampFormat;

	private DateUtil() {
		dateFormat = new SimpleDateFormat(ApplicationConstants.DATE_FORMAT);
		timestampFormat = new SimpleDateFormat(
				ApplicationConstants.TIMESTAMP_FORMAT);
	}

	public static DateUtil getInstance() {
		return instance;
	}

	public Date getDateFromString(String dateStr) throws ParseException {
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);

		} catch (ParseException e) {
			logger.error("Error occured in parsing timeStamp to Date.", e);
			throw e;
		}
		return date;
	}

	public String getStringFromDate(Date date) {
		String dateStr = dateFormat.format(date);
		return dateStr;
	}

	public Date getTimestampFromString(String timestamp) throws ParseException {

		Date date = null;
		try {
			date = timestampFormat.parse(timestamp);

		} catch (ParseException e) {
			logger.error("Error occured in parsing timeStamp to Date.", e);
			throw e;
		}
		return date;

	}

	public String getStringFromTimestamp(Date date) {
		String dateStr = timestampFormat.format(date);
		return dateStr;

	}

}
