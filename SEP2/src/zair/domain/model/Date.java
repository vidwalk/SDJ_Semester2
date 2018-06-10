package zair.domain.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Group 6, ICT Engineering, Semester 2
 * @param day
 * @param month
 * @param year
 */
public class Date implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int day;
	private int month;
	private int year;

	/**
	 *
	 * @return int of the field day
	 */
	public int getDay() {
		return day;
	}

	/**
	 *
	 * @return int of the field month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 *
	 * @return int of the field year
	 */
	public int getYear() {
		return year;
	}

	/**
	 *
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year) {
		setDate(day, month, year);
	}

	/**
	 * Constructor to set the day, month and year
	 */
	public Date() {
		Calendar currentDate = GregorianCalendar.getInstance();
		day = currentDate.get(Calendar.DAY_OF_MONTH);
		month = (currentDate.get(Calendar.MONTH) + 1);
		year = currentDate.get(Calendar.YEAR);
	}
/**
 * Method to set the date in a proper format
 * @param day
 * @param month
 * @param year
 */
	public void setDate(int day, int month, int year) {
		if (year < 0) {
			this.year = -year;
		} else {
			this.year = year;
		}

		if (month < 1) {
			this.month = 1;
		}

		else if (month > 12) {
			this.month = 12;
		} else {
			this.month = month;
		}

		if (day < 1) {
			this.day = 1;
		}

		else if (day > numberOfDaysInMonth()) {
			this.day = numberOfDaysInMonth();
		} else {
			this.day = day;
		}
	}
/**
 *
 * @return a boolean if the year is an leap year
 */
	private boolean isLeapYear() {
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			return true;

		}

		else {
			return false;
		}
	}
/**
 *
 * @return a String with the name of the day of the week
 */
	public String getDayOfTheWeek() {
		java.util.Date dateToConvert = new java.util.Date(year - 1900, month - 1, day);
		String output = new SimpleDateFormat("EE").format(dateToConvert);
		return output;
	}
/**
 *
 * @return an int for the number of days in a month
 */
	private int numberOfDaysInMonth() {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)

		{
			return 31;
		}

		if (month == 4 || month == 6 || month == 9 || month == 11)

		{
			return 30;
		}

		if (isLeapYear() == true) {
			return 29;
		}

		else {
			return 28;
		}
	}
/**
 * @return a String with the date format dd:mm:yyyy
 */
	public String toString() {
		if (day < 10 && month < 10) {
			return "0" + day + "/0" + month + "/" + year;
		} else if (day < 10) {
			return "0" + day + "/" + month + "/" + year;
		} else if (month < 10) {
			return day + "/0" + month + "/" + year;
		} else {
			return day + "/" + month + "/" + year;
		}
	}
/**
 *
 * @param other
 * @return a boolean if the date argument has a bigger value than the initial date
 */
	public boolean isBefore(Date other) {
		int d1 = year * 360 + month * 30 + day;
		int d2 = other.year * 360 + other.month * 30 + other.day;
		return d1 < d2;
	}
/**
 * @return a boolean if Date is equal to the obj argument
 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Date)) {
			return false;
		}

		Date other = (Date) obj;
		return day == other.getDay() && month == other.getMonth() && year == other.getYear();
	}
}
