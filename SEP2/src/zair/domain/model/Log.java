package zair.domain.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Singleton
 *
 * @author Group 6, ICT Engineering, Semester 2
 */
public class Log implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static Log instance;

	/**
	 * private empty Constructor
	 */
	private Log() {

	}

	/**
	 * use this to get the present time when you add a member
	 *
	 * @return a string of the time value in the format dd/MM/yyyy HH:mm:ss
	 */
	public String getTimestamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(Calendar.getInstance().getTime());
	}

	/**
	 *
	 * @return a Log object that is created if it doesn't already exist
	 */
	public static Log getInstance() {
		if (instance == null)
			instance = new Log();
		return instance;
	}
}
