package zair.domain.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Flyweight
 *
 * @author Group 6, ICT Engineering, Semester 2
 * @param places
 */
public class PlacesFactory implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static HashMap<String, Places> places = new HashMap<String, Places>();

	/**
	 *
	 * @param city
	 * @return an AbstractPlaces object that is created if not already present in
	 *         the HashMap
	 */
	public static AbstractPlaces getPlace(String city) {
		Places item = places.get(city);
		if (item == null) {
			item = new Places(city);
			places.put(city, item);
		}

		return item;
	}
}
