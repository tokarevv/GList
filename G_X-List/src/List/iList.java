package List;

public interface iList<T> extends Iterable<T> {

	void addToEnd(T value);

	void addToStart(T value);

	void addToIndex(int ind, T value);


	void removeFromEnd();

	void removeFirst();

	void removeFromIndex(int ind);

	int indexOf(T i);

	void clear();

	void sort();
	
	void init(T[] a);

	int size();

	void set(int index, T value);

	T get(int index);

	T[] toArray();

}
