package zair.domain.mediator;

import zair.domain.model.Credentials;
import zair.domain.model.Customer;
import zair.domain.model.Flight;
import zair.domain.model.Ticket;

public interface TargetDatabase
{
   void addFlight(Flight flight);
   void removeFlight(String flightID);
   Flight[] getAllFlights();
   void addCustomer(Customer customer);
   void saveSeats(Flight flight);
   Customer[] getAllCustomers();
   Credentials getCustomerCredentials(String id);
   void bookTicket(String flightID,String customerID, String seatValue, Ticket ticket);
   Ticket[] getTickets(String customerID);
   Flight getFlight(String id);
   void cancelTicket(String flightID,String customerID, String seatValue, Ticket ticket);
}
