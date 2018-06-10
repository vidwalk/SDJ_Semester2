package utility.collection;
import java.util.ArrayList;
public class LogList
{
 private ArrayList<Log> logs;
 public LogList()
 {
 logs = new ArrayList<>();
 }
 public void add(Log log)
 {
 logs.add(log);
 }

 public String toString()
 {
 return "" + logs;
 }
}