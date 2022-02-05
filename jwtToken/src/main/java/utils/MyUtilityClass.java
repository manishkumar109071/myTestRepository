package utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MyUtilityClass {

	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String REGULAR_EX_ddMMyyyy = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
	public static final int MAX_VALID_YEAR = 9999;
	public static final int MIN_VALID_YEAR = 1800;

	public enum MonthName {

		JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10),
		NOVEMBER(11), DECEMBER(12);

		public final Integer value;

		MonthName(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
	}

	public enum MonthDay {

		JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(30), JUNE(30), JULY(31), AUGUST(31), SEPTEMBER(30),
		OCTOBER(31), NOVEMBER(30), DECEMBER(31);

		public final Integer value;

		MonthDay(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
	}

	public enum WeekDays {
		SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

		public final Integer value;

		private WeekDays(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
	}

	public enum Status {
		ACTIVE, INACTIVE;

	}

	public static LocalDate StringToDate(String myDate) throws ParseException {
		LocalDate localDate = null;
		if (isValidDate(myDate)) {
			localDate = LocalDate.parse(myDate, DateTimeFormatter.ofPattern(DATE_FORMAT));
			System.out.println("Local Date: " + localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
		}
		return localDate;
	}

	public static String DateToString(Date date) throws ParseException {
		String dateStr = null;
		if (isValidDate(date)) {
			DateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			dateStr = sdf.format(date);
		}
		return dateStr;
	}

	public static boolean isValidDate(Object dateStr) {
		DateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setLenient(false);
		if (dateStr instanceof String) {
			try {
				sdf.parse((String) dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (dateStr instanceof Date) {
			try {
				sdf.format((Date) dateStr);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

	public static String calculateAge(Object dateOfbirth) {
		Period difference = null;

		if (dateOfbirth instanceof String && isValidDate(dateOfbirth)) {
			LocalDate dob = LocalDate.parse(dateOfbirth.toString(), DateTimeFormatter.ofPattern(DATE_FORMAT));
			LocalDate currentDate = LocalDate.now();
			difference = Period.between(dob, currentDate);
		}

		return "You are " + difference.getYears() + " years " + difference.getMonths() + " month and "
				+ difference.getDays() + " days old.";
	}

}
