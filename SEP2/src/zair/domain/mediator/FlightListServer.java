package zair.domain.mediator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import zair.domain.model.Customer;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.domain.model.Ticket;

public class FlightListServer implements RemoteFlightList
{

   private FlightModel list;
   private static final long serialVersionUID = 1L;

   public FlightListServer(FlightModel list) {
      this.list = list;
      startRegistry();
      try {
         UnicastRemoteObject.exportObject(this, 0);
         Naming.rebind(InitServer.getInstance().getServerName(), this);
      }
      catch(RemoteException | MalformedURLException e)
      {
         e.printStackTrace();
      }
   }

   private void startRegistry() {
      try {
         Registry reg = LocateRegistry.createRegistry(InitServer.getInstance().getPort());
      } catch (RemoteException e) {
         e.printStackTrace();
      }
   }

   @Override
   public Flight[] getTodayFlights()
   {
      return list.getTodayFlights();
   }

   @Override
   public Flight[] getAllFlights()
   {
      return list.getAllFlights();
   }

   @Override
   public Flight getFlight(int index)
   {
      return list.getFlight(index);
   }

   @Override
   public Customer getCustomerBy(String username, String password)
   {
      return list.getCustomerByCredentials(username, password);
   }

   @Override
   public Customer[] getAllCustomers()
   {
      return list.getAllCustomers();
   }

   @Override
   public void addCustomer(Customer customer)
   {
      list.addCustomer(customer);
   }

   @Override
   public void bookTicket(String flightID, String customerID, String seatValue,
         Ticket ticket)
   {
      list.bookTicket(flightID, customerID, seatValue, ticket);
   }

   @Override
   public void cancelTicket(String flightID, String customerID,
         String seatValue, Ticket ticket)
   {
      list.cancelTicket(flightID, customerID, seatValue, ticket);
   }

   @Override
   public Flight getFlight(String id)
   {
      return list.getFlight(id);
   }

   @Override
   public Flight[] getFlightByLocationAndDate(String origin, String destination,
         Date departureDate, Date arrivalDate)
   {
      return list.getFlightByLocationAndDate(origin, destination, departureDate, arrivalDate);
   }

   @Override
   public Flight[] getCheapFlights()
   {
      return list.getCheapFlights();
   }

   @Override
   public boolean checkUsername(String username)
   {
      return list.checkUsername(username);
   }

   @Override
   public boolean checkAvailabilityCustomer(Customer customer, String flightID)
   {
      return list.checkAvailabilityCustomer(customer, flightID);
   }

}
