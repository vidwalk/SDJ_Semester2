package utility.collection;

import java.time.LocalDateTime;

public class Clock {
public int hour;
public int minute;
public int second;

public Clock() {
this.hour = LocalDateTime.now().getHour();
this.minute = LocalDateTime.now().getMinute();
this.second = LocalDateTime.now().getSecond();
}

public void set(int hour, int minute, int second)
{
this.hour = hour;
this.minute = minute;
this.second = second;
}

public String toString()
{
return this.hour + ":" + this.minute + ":" + this.second;
}
}
