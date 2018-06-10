package zair.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Group 6, ICT Engineering, Semester 2
 * @param flights
 */
public class FlightList implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Flight> flights;

	/**
	 * A constructor to create an arraylist of Flight
	 */
	public FlightList() {
		flights = new ArrayList<>();
	}

	/**
	 * A method to add a flight to the current list
	 *
	 * @param flight
	 */
	public void addFlight(Flight flight) {
		flights.add(flight);
	}

	/**
	 * A method to remove a flight from the current list
	 *
	 * @param flight
	 */
	public void removeFlight(Flight flight) {
		flights.remove(flight);
	}

	/**
	 *
	 * @return an array of flights that are today
	 */
	public Flight[] getTodayFlights() {
		ArrayList<Flight> output = new ArrayList<>();
		Date date = new Date();
		for (int i = 0; i < flights.size(); i++)
			if (flights.get(i).getDateDeparture().getDay() == date.getDay()
					&& flights.get(i).getDateArrival().getDay() == date.getDay()
					&& flights.get(i).getDateDeparture().getMonth() == date.getMonth()
					&& flights.get(i).getDateArrival().getMonth() == date.getMonth()
					&& flights.get(i).getDateDeparture().getYear() == date.getYear()
					&& flights.get(i).getDateArrival().getYear() == date.getYear()) {
				output.add(flights.get(i));
			}

		Flight[] result = null;
		if (output.size() > 0) {
			result = new Flight[output.size()];
			for (int i = 0; i < output.size(); i++) {
				result[i] = output.get(i);
			}
		}
		return result;
	}

	/**
	 *
	 * @return an array of flights
	 */
	public Flight[] getAllFlights() {
		Flight[] result = new Flight[flights.size()];
		for (int i = 0; i < flights.size(); i++) {
			result[i] = flights.get(i);
		}
		return result;
	}

	/**
	 *
	 * @param id
	 * @return a flight by its id
	 */
	public Flight getFlight(String id) {
		Flight result = null;
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getId().equals(id)) {
				result = flights.get(i);
			}
		}
		return result;
	}

	/**
	 *
	 * @param index
	 * @return a flight by its index
	 */
	public Flight getFlight(int index) {
		return flights.get(index);
	}

	/**
	 * Method used to book a ticket
	 *
	 * @param flightId
	 * @param seatValue
	 */
	public void bookTicket(String flightId, String seatValue) {
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getId().equals(flightId)) {
				flights.get(i).setSeatOccupied(seatValue);
			}
		}
	}

	/**
	 * Method used to cancel a booked ticket
	 *
	 * @param flightId
	 * @param seatValue
	 */
	public void cancelTicket(String flightId, String seatValue) {
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getId().equals(flightId)) {
				flights.get(i).setSeatUnoccupied(seatValue);
			}
		}
	}

	/**
	 *
	 * @param origin
	 * @param destination
	 * @param departureDate
	 * @param arrivalDate
	 * @return a Flight array by the origin, destination, departure date and arrival
	 *         date
	 */
	public Flight[] getFlightByLocationAndDate(String origin, String destination, Date departureDate,
			Date arrivalDate) {
		ArrayList<Flight> output = new ArrayList<Flight>();
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getOrigin().getCity().equals(origin)
					&& flights.get(i).getDestination().getCity().equals(destination)
					&& (departureDate.isBefore(flights.get(i).getDateDeparture())
							|| departureDate.equals(flights.get(i).getDateDeparture()))
					&& (flights.get(i).getDateArrival().isBefore(arrivalDate)
							|| arrivalDate.equals(flights.get(i).getDateArrival()))) {
				output.add(flights.get(i));
			}
		}

		Flight[] returnedArray = null;
		if (output.size() > 0) {
			returnedArray = new Flight[output.size()];
			for (int i = 0; i < returnedArray.length; i++) {
				returnedArray[i] = output.get(i);
			}
		}

		return returnedArray;
	}

	/**
	 * if there are less than 10 flights then it shows everything sorted if there
	 * are more than 10 flights then shows only top 10 cheapest
	 *
	 * @return a Flight array based on the price in descending order
	 */
	public Flight[] getCheapFlights() {

		Flight[] fl = getAllFlights();

		Arrays.sort(fl, new SortByCost());

		if (fl.length < 10) {
			System.out.println();
			return Arrays.copyOfRange(fl, 0, fl.length);
		} else {

			return Arrays.copyOfRange(fl, 0, 10);
		}
	}
}
