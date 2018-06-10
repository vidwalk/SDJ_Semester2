package zair.domain.model;

import java.io.Serializable;

/**
 * Flyweight
 * @author Group 6, ICT Engineering, Semester 2
 * @param city
 * @param country
 * @param initials
 */
public abstract class AbstractPlaces implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String country;
	private String initials;

	/**
	 * The constructor has the argument city that is used to give city the value of
	 * its first 3 initials
	 *
	 * @param city
	 */
	public AbstractPlaces(String city) {
		this.city = Character.toUpperCase(city.charAt(0)) + city.substring(1).toLowerCase();
		setLocation();
	}

	/**
	 * Method used to get the location composed by the city, initials and country
	 *
	 * @return String of the location composed by city, initials, country fields
	 */
	public String getLocation() {
		return city + ", " + initials + ", " + country;
	}

	/**
	 * Method used to get the initials of the city
	 *
	 * @return String of the initials field
	 */
	public String getInitials() {
		return initials;
	}

	/**
	 * Method used to set the location by checking if the name is equal to a certain
	 * value
	 */
	private void setLocation() {

		if (city.equals("Copenhagen") || city.equals("Cph")) {
			country = "Denmark";
			initials = "CPH";
			city = "Copenhagen";
		} else if (city.equals("Bucharest") || city.equals("Buc")) {
			country = "Romania";
			initials = "BUC";
			city = "Bucharest";
		} else if (city.equals("London") || city.equals("Lon")) {
			country = "United Kingdom";
			initials = "LON";
			city = "London";
		} else if (city.equals("Warsaw") || city.equals("War")) {
			country = "Poland";
			initials = "WAR";
			city = "Warsaw";
		} else if (city.equals("Riga") || city.equals("Rig")) {
			country = "Latvia";
			initials = "RIG";
			city = "Riga";
		} else if (city.equals("Frankfurt") || city.equals("Fra")) {
			country = "Germany";
			initials = "FRA";
			city = "Frankfurt";
		} else if (city.equals("Madrid") || city.equals("Mad")) {
			country = "Spain";
			initials = "MAD";
			city = "Madrid";
		}
	}

	/**
	 * Method used to get the value the city has
	 * @return String of the city field
	 */
	public String getCity() {
		return city;
	}
}
