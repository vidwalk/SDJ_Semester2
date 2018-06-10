package zair.domain.model;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Group 6, ICT Engineering, Semester 2
 * @param seatNumber
 * @param ticketID
 * @param price
 * @param flight
 */
public class Ticket implements Serializable {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	private String seatNumber;
	private String ticketID;
	private double price;
	private Flight flight;

	/**
	 * Constructor for the ticket that creates a special id for the ticket and sets
	 * the values for the fields
	 *
	 * @param value
	 * @param flight
	 */
	public Ticket(String value, Flight flight) {
		this.flight = flight;
		seatNumber = value;
		ticketID = UUID.randomUUID().toString().substring(30).toUpperCase();
		price = flight.getPrice();
	}

	/**
	 *
	 * @return String of seatNumber
	 */
	public String getSeatNumber() {
		return seatNumber;
	}

	/**
	 *
	 * @return String of ticketID
	 */
	public String getTicketID() {
		return ticketID;
	}

	/**
	 * Method to set the ticketID
	 *
	 * @param ticketID
	 */
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	/**
	 *
	 * @return double of price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Method to set the price
	 *
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return a Flight object
	 */
	public Flight getFlight() {
		return flight;
	}

}
