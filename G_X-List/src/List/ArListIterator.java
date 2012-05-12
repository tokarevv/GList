package List;

import java.util.Iterator;


public class ArListIterator<T> implements Iterator<T> {

	private int pos = 0;
	private iList<T> lst = null;
	
	public ArListIterator(iList<T> lst){
		this.lst = lst;
	}
	
	@Override
	public boolean hasNext() {
		boolean res = true;
		if(pos >= lst.size()){ 
			res = false;
		}
		
		return res;	
	}

	@Override
	public T next() {
		//System.out.println(pos);
		return lst.get(pos++);
	}

	@Override
	public void remove() {
		lst.removeFromIndex(--pos);
	}

}
