package zair.view;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Singleton
 *
 * @author Group 6, ICT Engineering, Semester 2
 *
 */
public class MyNumericValidator extends InputVerifier {

	private static MyNumericValidator instance;

	/**
	 * private empty constructor
	 */
	private MyNumericValidator() {

	}

	/**
	 *
	 * @return a MyNumericValidor object
	 */
	public static MyNumericValidator getInstance() {
		if (instance == null) {
			instance = new MyNumericValidator();
		}
		return instance;
	}

	@Override
	/**
	 * Method to verify in value of the input
	 *
	 * @param input
	 */
	public boolean verify(JComponent input) {
		boolean valid = true;
		String text = ((JTextField) input).getText();
		try {
			Double.parseDouble(text);
		} catch (NumberFormatException e) {
			valid = false;
			JOptionPane.showMessageDialog(null, "Price has to be a number! No other characters are allowed.");
		}

		return valid;
	}

}
