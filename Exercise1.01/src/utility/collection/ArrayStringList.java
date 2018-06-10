package utility.collection;

public class ArrayStringList implements StringListADT {
	public int DEFAULT_CAPACITY = 100;
	public String list[];
	public int size;

	public ArrayStringList(int initialCapacity) {
		list = new String[initialCapacity];
		size = 0;
	}

	public ArrayStringList() {
		list = new String[this.DEFAULT_CAPACITY];
		size = 0;
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < list.length; i++)
			result = list[i] + " ";
		return result;
	}

	@Override
	public void add(int index, String element) {
		if (list[index] == null)
			list[index] = element;
		else
			System.out.println("Place is taken");
	}

	@Override
	public void add(String element) {
		if (size <= list.length) {
			list[size] = element;
			size++;

		} else
			throw new IllegalStateException();

	}

	@Override
	public void set(int index, String element) {
		list[index] = element;
	}

	@Override
	public String get(int index) {
		return list[index];
	}

	@Override
	public String remove(int index) {
		String result = list[index];
		list[index] = null;
		return result;
	}

	@Override
	public String remove(String element) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(element)) {
				list[i] = null;
				return list[i];
			}
		}
		return null;
	}

	@Override
	public int indexOf(String element) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(String element) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(element)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(list.length == size)
			return true;
		return false;
	}

	@Override
	public int size() {
		return size;
	}

}
