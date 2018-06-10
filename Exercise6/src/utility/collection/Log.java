package utility.collection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Log
{
 private String ip;
 private Message message;
 private LocalDateTime dateTime;
 public Log(String ip, Message message)
 {
 this.dateTime = LocalDateTime.now();
 this.ip = ip;
 this.message = message;
 }
 public Log update()
 {
 this.dateTime = LocalDateTime.now();
 return this;
 }
 public String getIP()
 {
 return ip;
 }
 public void setIP(String ip)
 {
 this.ip = ip;
 }
 public Message getMessage()
 {
 return message;
 }
 public LocalDateTime getDateTime()
 {
 return dateTime;
 }
 public String getDateTime(String format)
 {
 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
 return dateTime.format(formatter);
 }
 public String toString()
 {
 DateTimeFormatter formatter
 = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss");
 return "IP=" + ip + ", time=" + dateTime.format(formatter)
 + ", message=[" + message + "]" + "\n";
 }
}
