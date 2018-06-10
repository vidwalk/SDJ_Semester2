package zair.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Group 6, ICT Engineering, Semester 2
 * @param customers
 */
public class CustomerList implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Customer> customers;

	/**
	 * Constructor that creates an arraylist of customers
	 */
	public CustomerList() {
		customers = new ArrayList();
	}

	/**
	 * Method to add a customer to the customers arraylist
	 *
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	/**
	 *
	 * @return an array of Customer
	 */
	public Customer[] getAllCustomers() {
		Customer[] result = new Customer[customers.size()];
		for (int i = 0; i < customers.size(); i++) {
			result[i] = customers.get(i);
		}
		return result;
	}

	/**
	 *
	 * @param username
	 * @param password
	 * @return a Customer object based on its credentials
	 */
	public Customer getCustomerByCredentials(String username, String password) {
		Customer result = null;
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getCredentials().getUserId().equals(username)
					&& customers.get(i).getCredentials().getPassword().equals(password)) {
				result = customers.get(i);
			}
		}
		return result;
	}

	/**
	 * Method to add a ticket to a customer by its id
	 *
	 * @param customerId
	 * @param ticket
	 */
	public void addTicket(String customerId, Ticket ticket) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getId().equals(customerId)) {
				customers.get(i).addTicket(ticket);
			}
		}
	}

	/**
	 * Method to remove a ticket from the customer by the flightID and the
	 * customerID
	 *
	 * @param customerId
	 * @param flightId
	 */
	public void removeTicket(String customerId, String flightId) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getId().equals(customerId)) {
				customers.get(i).removeTicket(flightId);
			}
		}
	}

	/**
	 * Method to check if the Customer already has that flight booked
	 *
	 * @param customer
	 * @param flightID
	 * @return
	 */
	public boolean checkAvailabilityCustomer(Customer customer, String flightID) {
		boolean valid = true;
		for (int i = 0; i < customer.getTickets().length; i++) {
			if (customer.getTickets()[i].getFlight().getId().equals(flightID)) {
				valid = false;
			}
		}
		return valid;
	}

	/**
	 *
	 * @param username
	 * @return a boolean as a result of checking if the username is found in the
	 *         system
	 */
	public boolean checkUsername(String username) {
		boolean valid = true;
		for (int i = 0; i < getAllCustomers().length; i++) {
			if (getAllCustomers()[i].getCredentials().getUserId().equals(username)) {
				valid = false;
			}
		}

		return valid;
	}
}
