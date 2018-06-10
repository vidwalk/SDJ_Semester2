package zair.domain.model;

import java.io.Serializable;
import java.util.HashMap;
/**
 * Flyweight
 * @author Group 6, ICT Engineering, Semester 2
 *
 */
public class TimeFactory implements Serializable
{
   /**
	 *
	 */
	private static final long serialVersionUID = 1L;
private static HashMap<String, Time> times = new HashMap<String, Time>();
/**
 *
 * @param time
 * @return AbstractTime object
 */
   public static AbstractTime getTime(String time)
   {
      Time item = times.get(time);
      if (item == null)
      {
         item = new Time(time);
         times.put(time, item);
      }

      return item;
   }
}
