package zair.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Group 6, ICT Engineering, Semester 2
 * @param seats
 * @param dateDeparture
 * @param dateArrival
 * @param origin
 * @param destination
 * @param timeDeparture
 * @param timeArrival
 * @param price
 * @param flightID
 */
public class Flight implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Seat> seats;
	private Date dateDeparture;
	private Date dateArrival;
	private AbstractPlaces origin;
	private AbstractPlaces destination;
	private AbstractTime timeDeparture;
	private AbstractTime timeArrival;
	private double price;
	private String flightID;

	/**
	 * A constructor that sets the values of the fields based on the arguments,
	 * creates an arraylist of seats and fills it with values based on the rows in
	 * the plane
	 *
	 * @param dateDeparture
	 * @param dateArrival
	 * @param origin
	 * @param destination
	 * @param timeDeparture
	 * @param timeArrival
	 * @param price
	 */
	public Flight(Date dateDeparture, Date dateArrival, String origin, String destination, String timeDeparture,
			String timeArrival, double price) {
		this.dateDeparture = dateDeparture;
		this.dateArrival = dateArrival;
		this.origin = PlacesFactory.getPlace(origin);
		this.destination = PlacesFactory.getPlace(destination);
		this.timeDeparture = TimeFactory.getTime(timeDeparture);
		this.timeArrival = TimeFactory.getTime(timeArrival);
		this.price = price;
		flightID = createFlightID();
		seats = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String value = Integer.toString((i + 1));
			Seat seat = new Seat("A" + value);
			seats.add(seat);
		}
		for (int i = 10; i < 20; i++) {
			String value = Integer.toString(((i % 10) + 1));
			Seat seat = new Seat("B" + value);
			seats.add(seat);
		}
		for (int i = 20; i < 30; i++) {
			String value = Integer.toString(((i % 20) + 1));
			Seat seat = new Seat("C" + value);
			seats.add(seat);
		}
		for (int i = 30; i < 40; i++) {
			String value = Integer.toString(((i % 30) + 1));
			Seat seat = new Seat("D" + value);
			seats.add(seat);
		}
		for (int i = 40; i < 50; i++) {
			String value = Integer.toString(((i % 40) + 1));
			Seat seat = new Seat("E" + value);
			seats.add(seat);
		}
		for (int i = 50; i < 60; i++) {
			String value = Integer.toString(((i % 50) + 1));
			Seat seat = new Seat("F" + value);
			seats.add(seat);
		}
	}

	/**
	 *
	 * @return an arraylist of seats
	 */
	public ArrayList<Seat> getSeats() {
		return seats;
	}

	/**
	 *
	 * @return a string that is the result of creating a customer flightID
	 */
	private String createFlightID() {
		String[] parts = dateDeparture.toString().split("/");
		String[] parts1 = timeDeparture.toString().split(":");
		String id = "";
		id += destination.getInitials();
		id += origin.getInitials();
		id += parts[0] + parts[1] + parts[2];
		id += parts1[0] + parts1[1];

		return id;
	}

	/**
	 *
	 * @return the dateDeparture field
	 */
	public Date getDateDeparture() {
		return dateDeparture;
	}

	/**
	 * Method to set the departure date
	 *
	 * @param dateDeparture
	 */
	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	/**
	 *
	 * @return the dateArrival field
	 */
	public Date getDateArrival() {
		return dateArrival;
	}

	/**
	 * Method to set the arrival date
	 *
	 * @param dateArrival
	 */
	public void setDateArrival(Date dateArrival) {
		this.dateArrival = dateArrival;
	}

	/**
	 *
	 * @return the origin field
	 */
	public AbstractPlaces getOrigin() {
		return origin;
	}

	/**
	 * Method to set the origin
	 *
	 * @param origin
	 */
	public void setOrigin(AbstractPlaces origin) {
		this.origin = origin;
	}

	/**
	 *
	 * @return the destination field
	 */
	public AbstractPlaces getDestination() {
		return destination;
	}

	/**
	 * Method to set the destination
	 *
	 * @param destination
	 */
	public void setDestination(AbstractPlaces destination) {
		this.destination = destination;
	}

	/**
	 *
	 * @return the timeDeparture field
	 */
	public AbstractTime getTimeDeparture() {
		return timeDeparture;
	}

	/**
	 * Method to set the time of departure
	 *
	 * @param timeDeparture
	 */
	public void setTimeDeparture(AbstractTime timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	/**
	 *
	 * @return the timeArrival field
	 */
	public AbstractTime getTimeArrival() {
		return timeArrival;
	}

	/**
	 * Method to set the time of arrival
	 *
	 * @param timeArrival
	 */
	public void setTimeArrival(AbstractTime timeArrival) {
		this.timeArrival = timeArrival;
	}

	/**
	 *
	 * @return the price field
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
	 *
	 * @return an arraylist of available seats
	 */
	public ArrayList<Seat> getAvailableSeats() {
		ArrayList<Seat> output = new ArrayList<>();
		if (seats.size() > 0) {
			for (int i = 0; i < seats.size(); i++) {
				if (seats.get(i).isBooked() == false) {
					output.add(seats.get(i));
				}
			}
		}

		return output;
	}

	/**
	 *
	 * @return an int consisted of the number of tickets left
	 */
	public int getNumberOfTicketsLeft() {
		return getAvailableSeats().size();
	}

	/**
	 * Method to seat a certain seat to occupied
	 *
	 * @param value
	 */
	public void setSeatOccupied(String value) {
		for (int i = 0; i < seats.size(); i++) {
			if (seats.get(i).getSeatValue().equals(value)) {
				seats.get(i).setBooked();
			}
		}
	}

	/**
	 * Method to seat a certain seat to unoccupied
	 *
	 * @param value
	 */
	public void setSeatUnoccupied(String value) {
		for (int i = 0; i < seats.size(); i++) {
			if (seats.get(i).getSeatValue().equals(value)) {
				seats.get(i).setUnbooked();
			}
		}
	}

	/**
	 *
	 * @return a string of the flightID field
	 */
	public String getId() {
		return flightID;
	}

	/**
	 * Method to set the arraylist of seats to the value in the argument
	 *
	 * @param seatValues
	 */
	public void setAllSeats(ArrayList<Seat> seatValues) {
		seats = new ArrayList<>();

		for (int i = 0; i < seatValues.size(); i++) {
			seats.add(seatValues.get(i));
		}
	}

	/**
	 *
	 * @return arraylist of the seats field
	 */
	public ArrayList<Seat> getAllSeats() {
		return seats;
	}
}
