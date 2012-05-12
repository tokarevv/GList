package List;

import java.util.Arrays;


public class LinkedList2 implements iList {

	private LinkedListNode2 first = null;
	private LinkedListNode2 last  = null;
	private int length = 0;
	

	public LinkedList2(){}
	
	public LinkedList2(int[] a){
		init(a);
	}
	
	public void init(int[] a) {
		
		if (a.length == 0){
			return;
		}
		
		LinkedListNode2 prevNode = new LinkedListNode2(a[0]);
		first = prevNode;
		last  = prevNode;
		for (int i = 1; i < a.length; i++){
			LinkedListNode2 newNode = new LinkedListNode2(a[i]);
			prevNode.setNext(newNode);
			setPrev(prevNode, first);
			prevNode = newNode;
			last = newNode;
		}
		length = a.length;
	}	
	
	@Override
	public void addToEnd(int value) {
		
		LinkedListNode2 newNode = new LinkedListNode2(value);
		
		newNode.setPrev(last);
		setNext(last, newNode);
		last = newNode;
		
		if (first == null) {
			first = newNode;
		}
		
		length++;
	}

	@Override
	public void addToIndex(int ind, int value) {
		
		LinkedListNode2 newNode = new LinkedListNode2(value);
		if (ind == 0){
			addToStart(value);		
		}
		else
		{
		
			LinkedListNode2 prev = getNodeByIndex(ind-1); 
			LinkedListNode2 next = prev.getNext();
			
			newNode.setNext(next);
			newNode.setPrev(prev);
			prev.setNext(newNode);
			setPrev(next, newNode);
						
			length++;
		}

	}

	@Override
	public void addToStart(int value) {
		
		LinkedListNode2 newNode  = new LinkedListNode2(value);
		
		newNode.setNext(first);
		setPrev(first, newNode);
		first = newNode;
		
		if (last == null) {
			last = newNode;
		}

		length++;
	}

	@Override
	public void clear() {
		first = null;
		last  = null;
		length = 0;
	}

	@Override
	public int get(int index) {
		return getNodeByIndex(index).getValue();
	}
	
	@Override
	public void set(int index, int value) {
		LinkedListNode2 currNode = getNodeByIndex(index);
		currNode.setValue(value);
	}

	@Override
	public int indexOf(int a) {
		int res = -1;
		LinkedListNode2 currNode = first;		
		int i = 0;
		
		while (currNode != null) {
			if (currNode.getValue() == a) {
				res = i;
				break;
			}
			currNode = currNode.getNext();
			i++;
		}

		return res;
	}

	@Override
	public void removeFirst() {
		checkRoot(); //root is not null
		first = getNextNode(first);
		setPrev(first, null);
		length--;
	}

	@Override
	public void removeFromEnd() {

		checkLast(); //last is not null
		last = getPrevNode(last);
		setNext(last, null);
		length--;
	}

	@Override
	public void removeFromIndex(int ind) {
		
		if (ind == 0){
			removeFirst();
		}
		else if (ind == length){
			removeFromEnd();
		}
		else{
			checkRoot(); //root is not null
			
			LinkedListNode2 prev = getNodeByIndex(ind-1); 
			LinkedListNode2 next = getNextNode(getNextNode(prev)); 
			
			prev.setNext(next);
			setPrev(next, prev);
	
			length--;
		}
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public void sort() {
		int[] arrayToSort = toArray();
		Arrays.sort(arrayToSort);
		init(arrayToSort);
	}
	
	@Override
	public int[] toArray() {
		int[] res = new int[length];
		
		LinkedListNode2 currNode = first;
		for (int i = 0; i < length; i++){
			res[i] = currNode.getValue();
			currNode = currNode.getNext();
		}
		
		return res;
	}
	
//***** inner methods *****//
	private void setNext(LinkedListNode2 node, LinkedListNode2 next) {
		if(node != null){
			node.setNext(next);
		}
	}

	private void setPrev(LinkedListNode2 node, LinkedListNode2 prev) {
		if(node != null){
			node.setPrev(prev);
		}
	}
	
	private LinkedListNode2 getNextNode(LinkedListNode2 currNode) {
		LinkedListNode2 res = null;
		if (currNode != null){
			res = currNode.getNext();
		}
		return res;
	}
	
	private LinkedListNode2 getPrevNode(LinkedListNode2 currNode) {
		LinkedListNode2 res = null;
		if (currNode != null){
			res = currNode.getPrev();
		}
		return res;
	}
	
	private LinkedListNode2 getNodeByIndex(int index) {
		LinkedListNode2 res = first;	
		
		int i = 0;
		while (res != null) {
			if (i == index) {
				break;
			}
			res = res.getNext();
			i++;
		}

		if (i < index || res == null) {
			throw new IndexOutOfBoundsException();
		}
		
		return res;
	}
	
	private void checkRoot() {
		if ( first == null){
			throw new IndexOutOfBoundsException();
		}
	}

	private void checkLast() {
		if ( last == null){
			throw new IndexOutOfBoundsException();
		}
	}



}
