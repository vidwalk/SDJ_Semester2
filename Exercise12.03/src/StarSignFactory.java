import java.util.Calendar;
import java.util.HashMap;

public class StarSignFactory {
	private static HashMap<String, AbstractStarSign> signs = new HashMap<String, AbstractStarSign>();
public AbstractStarSign getStarSign(String name)
{
	if(signs.get(name) == null)
	{
		signs.put(name, new StarSign(name));
	}
	return signs.get(name);
}

	public AbstractStarSign getStarSign(String name, Calendar birthday, String location)
{
		if(signs.get(name) == null)
		{
			signs.put(name, new StarSignWithInterpretation(name, birthday, location));
		}
	return signs.get(name);
}
}
