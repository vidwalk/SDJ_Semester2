package zair.domain.mediator;

import zair.domain.model.Customer;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.domain.model.Ticket;

public interface FlightModel
{

   void addFlight(Flight flight);
   void removeFlight(Flight flight);
   Flight[] getTodayFlights();
   Flight[] getAllFlights();
   Flight getFlight(int index);
   Flight getFlight(String id);
   Customer getCustomerByCredentials(String username, String password);
   Customer[] getAllCustomers();
   void addCustomer(Customer customer);
   void bookTicket(String flightID, String customerID, String seatValue, Ticket ticket);
   void cancelTicket(String flightID, String customerID, String seatValue, Ticket ticket);
   Flight[] getFlightByLocationAndDate(String origin, String destination, Date departureDate, Date arrivalDate);
   Flight[] getCheapFlights();
   boolean checkUsername(String username);
   boolean checkAvailabilityCustomer(Customer customer, String flightID);
}
