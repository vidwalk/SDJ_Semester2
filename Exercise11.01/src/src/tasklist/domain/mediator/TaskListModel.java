package src.tasklist.domain.mediator;
import src.tasklist.domain.model.Task;
public interface TaskListModel
{
 void add(Task task);
 Task get();
 int size();
}
