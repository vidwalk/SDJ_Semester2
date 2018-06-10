package zair.domain.model;

import java.io.Serializable;

/**
 *
 * @author Group 6, ICT Engineering, Semester 2
 * @param seatValue
 * @param isBooked
 */
public class Seat implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String seatValue;
	private boolean isBooked;

	/**
	 * Constructor that uses the argument to set the seatValue and sets isBooked to
	 * false
	 *
	 * @param seatValue
	 */
	public Seat(String seatValue) {
		this.seatValue = seatValue;
		isBooked = false;
	}

	/**
	 * Method that sets isBooked to true
	 */
	public void setBooked() {
		isBooked = true;
	}

	/**
	 *
	 * @return isBooked boolean value
	 */
	public boolean isBooked() {
		return isBooked;
	}

	/**
	 * Method to set isBooked to false
	 */
	public void setUnbooked() {
		isBooked = false;
	}

	/**
	 *
	 * @return seatValue String value
	 */
	public String getSeatValue() {
		return seatValue;
	}
}
