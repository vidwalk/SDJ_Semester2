package utility.collection;



import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock
{
   private DateTimeFormatter timeFormatter;

   public Clock()
   {
      timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
   }

   public String getCurrentTime()
   {
      return LocalTime.now().format(timeFormatter);
   }

}
