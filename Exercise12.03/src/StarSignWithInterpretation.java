import java.util.Calendar;

public class StarSignWithInterpretation extends AbstractStarSign {
	private Calendar birthday;
	private String location;
	private String name;
	private DateInterval interval;

	public StarSignWithInterpretation(String name, Calendar birthday, String location) {
		super(name);
		this.birthday = birthday;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public DateInterval getInterval() {
		return interval;
	}
	public String toString() {
		return getName() + " (" + interval + ")" + getInterpretation();
	}

	private String getInterpretation() {
		return "don't know man";
	}
}
