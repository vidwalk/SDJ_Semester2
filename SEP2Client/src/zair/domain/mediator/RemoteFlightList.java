package zair.domain.mediator;
import java.rmi.Remote;
import java.rmi.RemoteException;

import zair.domain.model.Customer;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.domain.model.Ticket;

public interface RemoteFlightList extends Remote
{
	   Flight[] getTodayFlights() throws RemoteException;
	   Flight[] getAllFlights() throws RemoteException;
	   Flight getFlight(int index) throws RemoteException;
	   Flight getFlight(String id) throws RemoteException;
	   Customer getCustomerBy(String username, String password) throws RemoteException;
	   Customer[] getAllCustomers() throws RemoteException;
	   void addCustomer(Customer customer) throws RemoteException;
	   void bookTicket(String flightID, String customerID, String seatValue, Ticket ticket) throws RemoteException;
	   void cancelTicket(String flightID, String customerID, String seatValue, Ticket ticket) throws RemoteException;
	   Flight[] getFlightByLocationAndDate(String origin, String destination, Date departureDate, Date arrivalDate) throws RemoteException;
	   Flight[] getCheapFlights() throws RemoteException;
	   boolean checkUsername(String username) throws RemoteException;
	   boolean checkAvailabilityCustomer(Customer customer, String flightID) throws RemoteException;
}
