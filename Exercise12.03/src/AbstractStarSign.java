
public abstract class AbstractStarSign {
private String name;
private DateInterval interval;
public AbstractStarSign(String name) {
	this.name = name;
}
public String getName()
{
	return this.name;
}

public DateInterval getInterval()
{
return this.interval;
}
}
