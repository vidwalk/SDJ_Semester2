package zair.domain.model;

import java.io.Serializable;
/**
 * Flyweight
 * @author Group 6, ICT Engineering, Semester 2
 *
 */
public class Time extends AbstractTime implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that uses the constructor in AbstractTime
	 * @param time
	 */
   public Time(String time)
   {
      super(time);
   }
}
