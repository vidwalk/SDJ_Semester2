package zair.domain.model;

import java.io.Serializable;

/**
 * Flyweight
 *
 * @author Group 6, ICT Engineering, Semester 2
 *
 */
public class Places extends AbstractPlaces implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that is uses AbstractPlaces constructor
	 *
	 * @param city
	 */
	public Places(String city) {
		super(city);
	}
}
