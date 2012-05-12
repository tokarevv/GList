package List;

public class LinkedListNode2 {
	
	private int value = 0;
	private LinkedListNode2 next = null;
	private LinkedListNode2 prev = null;
	
	public LinkedListNode2(int value) {
		this.value = value;
	}
	
	public LinkedListNode2() {
	}
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public LinkedListNode2 getNext() {
		return next;
	}
	public void setNext(LinkedListNode2 next) {
		this.next = next;
	}

	public LinkedListNode2 getPrev() {
		return prev;
	}

	public void setPrev(LinkedListNode2 prev) {
		this.prev = prev;
	}
	
}
