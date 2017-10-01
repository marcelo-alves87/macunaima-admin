package org.macunaima.gui.ui;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	private static java.text.DateFormat dateFormat;

	public static Format getDefaultFormat() {
		createDateFormatIfNull();
		return dateFormat;
	}

	public static String format(Date date) {
		createDateFormatIfNull();
		return date != null ? dateFormat.format(date) : null;
	}

	public static Date parse(String date) throws ParseException {
		createDateFormatIfNull();
		return date != null && !date.isEmpty() ? dateFormat.parse(date) : null;
	}

	private static void createDateFormatIfNull() {
		if (dateFormat == null) {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
	}

}
