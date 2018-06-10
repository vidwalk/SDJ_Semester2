package zair.domain.model;

import java.util.Comparator;
/**
 *
 * @author Group 6, ICT Engineering, Semester 2
 *
 */
public class SortByCost implements Comparator<Flight>
{
	/**
	 * Method to compare flights
	 * @return -1 if the price of the first flight is smaller than the second one
	 * 0 if they are equal
	 * 1 if the price of the first flight is bigger than the second one
	 */
   public int compare(Flight a, Flight b)
   {
      if (a.getPrice() < b.getPrice())
         return -1;
      else if (a.getPrice() == b.getPrice())
         return 0;
      else
         return 1;
   }
}
