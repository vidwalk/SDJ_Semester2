package utility.collection;

public interface StringListADT {
public void add(int index, String element);
public void add(String element);
public void set(int index, String element);
public String get(int index);
public String remove(int index);
public String remove(String element);
public int indexOf(String element);
public boolean contains(String element);
public boolean isEmpty();
public boolean isFull();
public int size();
}
