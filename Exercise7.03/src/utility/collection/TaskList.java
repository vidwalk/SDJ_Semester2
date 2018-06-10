package utility.collection;

import java.util.ArrayList;

public class TaskList {
private ArrayList<String> tasks;
public TaskList() {
	tasks = new ArrayList<String>();
}
public void addTask(String task)
{
	tasks.add(task);
}

public String getAndRemoveTask()
{
	String result = tasks.get(0);
	tasks.remove(0);
	return result;
}

public int size()
{
	return tasks.size();
}
}
