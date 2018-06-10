package chat.domain.mediator;

import chat.domain.model.ChatMessage;
import chat.domain.model.MessageList;

public class ChatModelManager implements ChatModel
{
   private MessageList list;
 
   public ChatModelManager()
   {
      list = new MessageList();
   }

   @Override
   public void addMessage(ChatMessage message)
   {
      list.add(message);
   }

}
