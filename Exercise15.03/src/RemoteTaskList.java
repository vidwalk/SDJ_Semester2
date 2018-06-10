

import java.rmi.RemoteException;

import utility.observer.RemoteSubject;

public interface RemoteTaskList extends RemoteSubject<String> {
public void add(String task) throws RemoteException;
public void remove() throws RemoteException;
public int size() throws RemoteException;
}
