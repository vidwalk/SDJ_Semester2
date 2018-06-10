package src.tasklist.view;
import src.tasklist.controller.TaskListController;
public interface TaskListView
{
 String get(String text);
 void show(String text);
 void startView(TaskListController controller);
}
