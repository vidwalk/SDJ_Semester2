import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestOfStarSign
{
 public static void main(String[] args)
 {
 String[] legalStarSignNames = StarSign.LEGAL_NAMES;
 System.out.println("Legal star sign names:");
 for (int i=0; i<legalStarSignNames.length; i++)
 System.out.println(legalStarSignNames[i]);
 System.out.println();
Calendar calendar = new GregorianCalendar();
 Person[] list = new Person[10];
 StarSignFactory factory = new StarSignFactory();
 list[0] = new Person("Allan", factory.getStarSign("Leo"));
 list[1] = new Person("Bob", factory.getStarSign("Scorpio"));
 list[2] = new Person("Carl", factory.getStarSign("Leo"));
 list[3] = new Person("Dennis", factory.getStarSign("Saggitarius"));
 list[4] = new Person("Eric", factory.getStarSign("Leo"));
 list[5] = new Person("Franc", factory.getStarSign("Leo"));
 list[6] = new Person("Graham", factory.getStarSign("Sagittarius", calendar.getInstance(), "My hump"));
 list[7] = new Person("Hans", factory.getStarSign("Leo"));
 list[8] = new Person("Igor", factory.getStarSign("Virgo"));
 list[9] = new Person("Jens", factory.getStarSign(legalStarSignNames[8]));

 System.out.println("Person objects:");
 for (int i=0; i< list.length; i++)
 {
 System.out.printf("%-40s %d\n", list[i],list[i].getStarSign().hashCode());
 }
 }
}