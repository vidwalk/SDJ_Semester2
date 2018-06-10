package zair.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Group 6, ICT Engineering, Semester 2
 *
 * @author Claudiu
 * @param customerNo
 * @param fname
 * @param email
 * @param phone
 * @param passportNo
 * @param tickets
 * @param credentials
 */
public class Customer implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String customerNo;
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String passportNo;
	private ArrayList<Ticket> tickets;
	private Credentials credentials;

	/**
	 * The constructor sets the values of the fields to the values of the arguments,
	 * creates an Credential object and a tickets arraylist
	 *
	 * @param fname
	 * @param lname
	 * @param email
	 * @param phone
	 * @param passportNo
	 * @param userId
	 * @param password
	 */
	public Customer(String fname, String lname, String email, String phone, String passportNo, String userId,
			String password) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.passportNo = passportNo;
		this.phone = phone;
		this.customerNo = fname + phone;
		credentials = new Credentials(userId, password);
		tickets = new ArrayList<Ticket>();
	}

	/**
	 *
	 * @return an array of tickets
	 */
	public Ticket[] getTickets() {
		Ticket[] allTickets = new Ticket[tickets.size()];
		for (int i = 0; i < tickets.size(); i++) {
			allTickets[i] = tickets.get(i);
		}

		return allTickets;
	}

	/**
	 * Method used to add a ticket to the tickets arraylist
	 *
	 * @param ticket
	 */
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	/**
	 *
	 * @return a string of the email field
	 */
	public String getEmail() {
		return email;
	}

	/**
	 *
	 * @return a string of the fname and lname fields
	 */
	public String getName() {
		return fname + " " + lname;
	}

	/**
	 *
	 * @return a string of the phone field
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 *
	 * @return a string of the passport number field
	 */
	public String getPassportNo() {
		return passportNo;
	}

	/**
	 *
	 * @return a Credentials object of the credentials field
	 */
	public Credentials getCredentials() {
		return credentials;
	}

	/**
	 *
	 * @return a string of the customer number
	 */
	public String getId() {
		return customerNo;
	}

	/**
	 * A method to remove the ticket with a certain flightID provided as an argument
	 *
	 * @param flightId
	 */
	public void removeTicket(String flightId) {
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getFlight().getId().equals(flightId)) {
				tickets.remove(tickets.get(i));
			}
		}
	}
}
