package domain.model;

import java.io.Serializable;
import java.util.HashMap;

public class PreferenceFactory implements Serializable {
	private static HashMap<String, AbstractPreference> preferences = new HashMap<String, AbstractPreference>();

	public static AbstractPreference getPreference(String name) // use to get a
																// certain
																// preference
	{
		AbstractPreference item = preferences.get(name);
		if (item == null) {
			item = new Preference(name);
			preferences.put(name, item);
		}

		return item;
	}
}
