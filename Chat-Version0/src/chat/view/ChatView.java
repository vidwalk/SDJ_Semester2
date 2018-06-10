package chat.view;

import chat.controller.ChatController;

public interface ChatView
{
   public void start(ChatController controller);
   public String getInput();
   public void showOutput(String text);
}
