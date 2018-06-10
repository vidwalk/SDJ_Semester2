package chat.domain.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatMessage
{
   private String id;
   private String messageBody;
   private LocalDateTime dateTime;

   public ChatMessage(String id, String message)
   {
      this.dateTime = LocalDateTime.now();
      this.id = id;
      this.messageBody = message;
   }

   public ChatMessage(String message)
   {
      this("0", message);
      setId("" + (int) (messageBody.hashCode() * Math.random()));
   }

   public ChatMessage update()
   {
      this.dateTime = LocalDateTime.now();
      return this;
   }

   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }

   public String getBody()
   {
      return messageBody;
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
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss");
      return "id=" + id + ", time=" + dateTime.format(formatter) + ", message=\""
            + messageBody + "\"";
   }

}
