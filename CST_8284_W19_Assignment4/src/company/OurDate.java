/**OurDate.java
 * @author BradyHawkins
 * @version 1.0
 * 
 * Course Name: CST8284
 * Assignment title: CST8284_W19_Assign03_EmployementManagementSystem
 * Assignment due date: April. 14, 2019
 * 
 * Represents a date
 */

package company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;


public class OurDate implements java.io.Serializable {
	/**
	 * Creates an obj of Calendar to get a default value for each field created
	 */
	private static final Calendar CAL = Calendar.getInstance();
	/**
	 * Fields created to hold instance of passed int, representing day, month, year
	 * 
	 */
	private int day;
	private int month;
	private int year;

	/**
	 * Constructor
	 * <p>
	 * sets the default fields of this class to the current day, month, year
	 */
	public OurDate() {
		this.day = CAL.get(Calendar.DATE);
		this.month = CAL.get(Calendar.MONTH);
		this.year = CAL.get(Calendar.YEAR);
	} 

	/**
	 * Base constructor.
	 * @param day
	 * @param month
	 * @param year
	 */
	public OurDate(int day, int month, int year) {
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	} 
	public OurDate(String startDate) {
		String[] date = startDate.split("/");
		if(date.length != 3) {
			throw new IndexOutOfBoundsException("Format is not accurate; Please enter it as day/month/year");
		}
		try {
			day = Integer.parseInt(date[0]);
			month = Integer.parseInt(date[1]);
			year = Integer.parseInt(date[2]);
		} catch (NumberFormatException ex) {
			throw new NumberFormatException(ex.getMessage() + "; Please enter valid information");
		}
		if(day<0|| day> 31) {
			throw new IndexOutOfBoundsException("Invalid date format; Please another 1 - 31");
		}
		if(month <= 0 | month > 12) {
			throw new IndexOutOfBoundsException("Invalid date format; Please another 1 - 12");
		}
		if(year <= 0 ) {
			throw new IndexOutOfBoundsException("Invalid date format; Please enter a bigger year");
		}
		setDay(day);
		setMonth(month);
		setYear(year);
	}

	/**
	 * Returns int that represents the day of the month
	 * @return int
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Passes Day variable to the Constructor to save in memory
	 * @return void
	 * @param day
	 */
	private void setDay(int day) {
		this.day = day;
	}

	/**
	 * returns an int that represents the month 
	 * @return int
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * passes the month variable to the constructor
	 * @param month
	 * @return void
	 */
	private void setMonth(int month) {
		this.month = month;
	}

	/**
	 * returns an int that represents the year
	 * @return int
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Passes the year variable to the constructor
	 * @param year
	 * @return void
	 */
	private void setYear(int year) {
		this.year = year;
	}
	/**
	 * returns formatted set of Strings to pass to parent classes
	 * @return String
	 * @Override
	 */
	@Override	
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	/**
	 * Compares Obj passed to see if it's an instance of this class
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof OurDate;
	}	
} 
