package List;

import java.util.Arrays;
import java.util.Iterator;

public class ArList<T> implements iList<T> {

	private int length;
	private T[] arr;
	private static final int INIT_SIZE = 8;

	public ArList() {
		arr = (T[]) new Object[10];
		length = 0;
	}

	public ArList(T[] a) {
		this();
		init(a);
	}

	public void init(T[] a) {
		checkNewSize(a.length);
		for (int i = 0; i < a.length; i++){
			arr[i] = a[i];
		}
		length = a.length;
	}
	
	@Override
	public void addToEnd(T value) {
		addToIndex(length, value);
	}

	@Override
	public void addToStart(T value) {
		addToIndex(0, value);
	}

	@Override
	public void addToIndex(int ind, T value) {
		checkIndexForAddition(ind);
		checkNewSize(1);
		for (int i = length; i > ind; i--){
			arr[i] = arr[i-1];
		}
		arr[ind] = value;
		length++;
	}

	@Override
	public void removeFromEnd() {
		removeFromIndex(length-1);
	}

	@Override
	public void removeFirst() {
		removeFromIndex(0);
	}

	@Override
	public void removeFromIndex(int ind) {
		checkIndex(ind);
		for (int i = ind; i < length-1; i++){
			arr[i] = arr[i+1];
		}
		length--;
	}

	@Override
	public void clear() {
		/*for (int i = 0; i < length; i++) {
			arr[i] = 0;
		}*/
		length = 0;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public T get(int index) {
		checkIndex(index);
		return arr[index];
	}

	@Override
	public int indexOf(T a) {
		int res = -1;
		for (int i = 0; i < length; i++){
			if(arr[i].equals(a)){
				res = i;
				break;
			}
		}
		return res;
	}

	@Override
	public void set(int index, T value) {
		checkIndex(index);
		arr[index] = value;
	}

	@Override
	public void sort() {
		T[] arrayToSort = toArray();
		Arrays.sort(arrayToSort);
		for (int i = 0; i < length; i++){
			arr[i] = arrayToSort[i];
		}
	}
	
	@Override
	public T[] toArray() {
		T[] res = (T[]) new Object[length];
		for (int i = 0; i < length; i++){
			res[i] = arr[i];
		}
		return res;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof ArList))
			return false;
		ArList<T> otherObj = (ArList<T>) other;
		return (this.length == otherObj.length && equal(this.toArray(), otherObj.toArray()));
	}

	@Override
	public int hashCode() {
		int res = length;
		for (T i : arr){
			res = 13 * res + i.hashCode();
		}
		return res;
	}
	
	//*** inner methods
	private void checkIndexForAddition(int ind) {
		if(ind < 0 || ind > length){
			throw new IndexOutOfBoundsException();
		}
	}
	private void checkIndex(int ind) {
		if(ind < 0 || ind > length-1){
			throw new IndexOutOfBoundsException();
		}
	}

	private boolean equal(T[] arr1, T[] arr2) {
		boolean res = true;
		int j = 0;
		if (arr1.length == arr2.length) {
			for (int i = 0; i < arr1.length; i++) {
				if (!(arr1[i].equals(arr2[j]))) {
					res = false;
					break;
				}
				j++;
			}
		}
		return res;
	}

	private void checkNewSize(int count) {
		if (arr.length > (length+count)){
			return;
		}
		
		int newLength = (int) ((length + count) * 1.2);
		T[] newArray =  (T[]) new Object[newLength];
		
		//for (int i : arr) { no need to copy whole arr
		for (int i = 0; i < length; i++){
			newArray[i] = arr[i];
		}
		
		arr = newArray;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArListIterator<T>(this);
	}


}
