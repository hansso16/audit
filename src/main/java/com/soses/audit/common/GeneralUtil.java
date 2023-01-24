package com.soses.audit.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GeneralUtil {

	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("LLL dd, yyyy");
	
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("LLL dd, yyyy hh:mm a");

	public static final LocalDate getCurrentDate() {
		return LocalDate.now();
	}
	
	public static final LocalDate getMaxDate() {
		return LocalDate.of(9999, 12, 31);
	}
	
	public static final String formatDate(LocalDate date) {
		return date.format(dateFormatter);
	}
	
	public static final String formatDateTime(LocalDateTime date) {
		return date.format(dateTimeFormatter);
	}
	
	public static boolean isListEmpty(List<?> list) {
		return (list == null || list.size() == 0)? true:false;
	}
	
	public static LocalDateTime stringToLocalDateTime(String dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLL dd, yyyy hh:mm a"); 
		return LocalDateTime.parse(dateTime, formatter);
	}
}
