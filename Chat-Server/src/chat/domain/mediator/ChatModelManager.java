package chat.domain.mediator;

import java.io.IOException;
import java.util.Observable;

import chat.domain.model.ChatMessage;
import chat.domain.model.MessageList;

public class ChatModelManager extends Observable implements ChatModel
{
   private MessageList list;
   private ChatServer server;
 
   public ChatModelManager()
   {
      list = new MessageList();
      try
      {
         server = new ChatServer(this, 2910);
         Thread serverThread = new Thread(server);
         serverThread.start();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   @Override
   public void addMessage(ChatMessage message)
   {
      list.add(message);
      super.setChanged();
      super.notifyObservers(message);
   }

}
