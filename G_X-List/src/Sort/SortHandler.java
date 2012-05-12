package Sort;

import List.iList;

public class SortHandler {
	
	private iList list;
	private iSort sortMethod = new Bubble(); //default
	
	public SortHandler(){}

	public SortHandler(iList list){
		this.list = list;
	}
	
	public void sort(){
		int[] a = list.toArray();
		sortMethod.sort(a);
		list.init(a);
	}

	//getteres and setters
	public void setList(iList list) {
		this.list = list;
	}

	public void setSortMethod(iSort sorter) {
		this.sortMethod = sorter;
	}
	
	//i'm not sure if i need getters here, but jic
	public iSort getSortMethod() {
		return sortMethod;
	}

	public iList getList() {
		return list;
	}
	
}
