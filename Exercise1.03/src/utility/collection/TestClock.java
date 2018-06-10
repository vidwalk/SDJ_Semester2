package utility.collection;

public class TestClock // the Main thread controls when program ends
{
public static void main(String[] args)
{
Clock clock = new Clock();
Thread showClockThread = new Thread(new Show(clock));
Thread updateClockThread = new Thread(new Update(clock));
showClockThread.setDaemon(true);
updateClockThread.setDaemon(true);
showClockThread.start();
updateClockThread.start();
try
{
updateClockThread.sleep(5000);
}
catch (InterruptedException e) { /* nothing */ }
}
}