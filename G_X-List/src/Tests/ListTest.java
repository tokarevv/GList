package Tests;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import List.*;
import Sort.*;


@RunWith(Parameterized.class)
public class ListTest {

	private String list;
	private Object[] arrayToCompare;

	public ListTest(String list) {
		this.list = list;
	}
	
	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection data(){
		//ArList arList = ;
		Object[][] data = new Object[][] {
				{"ArList"},
				//{"Ar2List"},
				//{"CircleArList"},
				//{"LinkedList"},
				//{"LinkedList2"},
				//{"CircleLinkedList2"}
		};
		return Arrays.asList(data);
	}

	//****  for empty ****//
	@Test
	public void initializtionTest(){
		iList<Integer> list = getNewList();
		assertEquals(0, list.size());	
	}
	
	@Test
	public void initializtionViaArrayTest(){
		iList<Integer> list = getNewList();
		list.init(new Integer[]{2,1,3});
		assertEquals(3, list.size());	
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getEmptyTest(){
		iList<Integer> list = getNewList();
		list.get(0);
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void setEmptyTest(){
		iList<Integer> list = getNewList();
		list.set(0,0);
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void setEmpty90Test(){
		iList<Integer> list = getNewList();
		list.set(90,1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeFirstEmptyTest(){
		iList<Integer> list = getNewList();
		list.removeFirst();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeFromEndEmptyTest(){
		iList<Integer> list = getNewList();
		list.removeFromEnd();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeFromIndexEmptyTest(){
		iList<Integer> list = getNewList();
		list.removeFromIndex(0);
	}
	//****  for one   ****//
	@Test
	public void addToEndOneTest(){
		iList<Integer> list = getNewList();
		list.addToEnd(1);
		assertEquals(1, list.size());	
	}
	
	@Test
	public void addToStartOneTest(){
		iList<Integer> list = getNewList();
		list.addToStart(1);
		assertEquals(1, list.size());	
	}
	
	@Test
	public void addToIndexOneTest(){
		iList<Integer> list = getNewList();
		list.addToIndex(0, 3);
		assertEquals(1, list.size());	
	}
	
	@Test
	public void getOneTest(){
		iList<Integer> list = getNewList();
		list.addToEnd(3);
		assertEquals(new Integer(3), list.get(0));	
	}
	
	private iList getListOne() {
		iList res = getNewList();
		res.addToEnd(3);
		return res;
	}

	@Test
	public void removeFromEndOne() {
		iList list = getListOne();
		list.removeFromEnd();
		assertEquals(0, list.size());	
	}

	
	@Test
	public void removeFirstOne() {
		iList list = getListOne();
		list.removeFirst();
		assertEquals(0, list.size());	
	}

	
	@Test
	public void removeFromIndexOne() {
		iList list = getListOne();
		list.removeFromIndex(0);
		assertEquals(0, list.size());	
	}	
	
	
	
	
	//****  for many ****//
	@Test
	public void addToStartTest(){
		arrayToCompare = new Integer[]{3,2,1};
		iList<Integer> list = getNewList();
		list.addToStart(1);
		list.addToStart(2);
		list.addToStart(3);
		assertTrue(Arrays.deepEquals(arrayToCompare, list.toArray()));	
	}

	@Test
	public void addTest(){
		arrayToCompare = new Integer[]{1,2,3};
		iList<Integer> list = getNewList();
		list.addToEnd(1);
		list.addToEnd(2);
		list.addToEnd(3);
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
	}
	
	@Test
	public void addToIndexTest(){
		arrayToCompare = new Integer[]{2,1,3};
		iList<Integer> list = getNewList();
		list.addToIndex(0,1);
		list.addToIndex(1,3);
		list.addToIndex(0,2);
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
	}

	@Test
	public void getTes(){
		iList<Integer> list = getNewList();
		list.init(new Integer[]{1,2,3});
		assertEquals(new Integer(2), list.get(1));	
	}
	
	@Test
	public void sizeTest(){
		iList<Integer> list = getNewList();
		list.init(new Integer[]{1,2,3});
		assertEquals(3, list.size());	
	}
	
	@Test
	public void setTest(){
		arrayToCompare = new Integer[]{1,4,3};
		iList<Integer> list = getNewList();
		list.init(new Integer[]{1,2,3});
		list.set(1,4);
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
	}

	@Test
	public void indexOfTest(){
		iList<Integer> list = getNewList();
		assertEquals(-1, list.indexOf(2));	
		list.init(new Integer[]{1,5,4,2,3,2});
		assertEquals(3, list.indexOf(2));	
	}

	@Test
	public void sortTest(){
		arrayToCompare = new Integer[]{1,2,2,3,4,5};
		iList<Integer> list = getNewList();
		list.init(new Integer[]{1,5,4,2,3,2});
		list.sort();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}
	
	@Test
	public void removeTest(){
		arrayToCompare = new Integer[]{1,5};
		iList<Integer> list = getNewList();
		list.init(new Integer[]{1,5,4});
		list.removeFromEnd();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}
	
	@Test
	public void removeFirstTest(){
		arrayToCompare = new Integer[]{5,4};
		iList<Integer> list = getNewList();
		list.init(new Integer[]{1,5,4});
		list.removeFirst();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}
	
	@Test
	public void removeFromIndexTest(){
		arrayToCompare = new Integer[]{1,4};
		iList<Integer> list = getNewList();
		list.init(new Integer[]{1,5,4});
		list.removeFromIndex(1);
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}

	@Test
	public void ForEachTest(){
		arrayToCompare = new Integer[]{1,5,4,5,5,5};
		iList<Integer> list = getNewList();
		list.init(new Integer[]{1,5,4,5,5,5});

		int pos = 0;
		for (Integer j : list){
			assertEquals(arrayToCompare[pos++], j);	
		}
	}

	@Test
	public void ForEach2Test(){
		arrayToCompare = new Integer[]{1,5,4,5,5,5};
		iList<Integer> list = getNewList();
		list.init(new Integer[]{1,5,4,5,5,5});

		int pos = 0;
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()){
			assertEquals(arrayToCompare[pos++], it.next());	
		}
	}

	//sorting via iSort methods
	/*@Test
	public void sortBubbleTest(){
		arrayToCompare = new int[]{1,2,2,3,4,5};
		iList<Integer> list = getNewList();
		list.init(new int[]{1,5,4,2,3,2});
		SortHandler sh = new SortHandler(list);
		sh.setSortMethod(new Bubble());
		sh.sort();
		//list.sort();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}
		
	@Test
	public void sortSelectionTest(){
		arrayToCompare = new int[]{1,2,2,3,4,5};
		iList<Integer> list = getNewList();
		list.init(new int[]{1,5,4,2,3,2});
		SortHandler sh = new SortHandler(list);
		sh.setSortMethod(new Selection());
		sh.sort();
		//list.sort();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}
	
	@Test
	public void sortInsertionTest(){
		arrayToCompare = new int[]{1,2,2,3,4,5};
		iList<Integer> list = getNewList();
		list.init(new int[]{1,5,4,2,3,2});
		SortHandler sh = new SortHandler(list);
		sh.setSortMethod(new Insertion());
		sh.sort();
		//list.sort();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}
	
	
	@Test
	public void sortMergeTest(){
		arrayToCompare = new int[]{1,2,2,3,4,5};
		iList<Integer> list = getNewList();
		list.init(new int[]{1,5,4,2,3,2});
		SortHandler sh = new SortHandler(list);
		sh.setSortMethod(new Merge());
		sh.sort();
		//list.sort();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}
		
	
	@Test
	public void sortQuickTest(){
		arrayToCompare = new int[]{1,2,2,3,4,5};
		iList<Integer> list = getNewList();
		list.init(new int[]{1,5,4,2,3,2});
		SortHandler sh = new SortHandler(list);
		sh.setSortMethod(new Quick());
		sh.sort();
		//list.sort();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}
		
	@Test
	public void sortShellTest(){
		arrayToCompare = new int[]{1,2,2,3,4,5};
		iList<Integer> list = getNewList();
		list.init(new int[]{1,5,4,2,3,2});
		SortHandler sh = new SortHandler(list);
		sh.setSortMethod(new Shell());
		sh.sort();
		//list.sort();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}*/
		
	
	//***** inner
	private iList<Integer> getNewList() {
		iList<Integer> res = null;
		if (list.equals("ArList")){
			res = new ArList<Integer>();
		}
		/*else if (list.equals("Ar2List")){
			res = new Ar2List();
		}
		else if (list.equals("CircleArList")){
			res = new CircleArList();
		}
		else if (list.equals("LinkedList")){
			res = new LinkedList();
		}
		else if (list.equals("LinkedList2")){
			res = new LinkedList2();
		}
		else if (list.equals("CircleLinkedList2")){
			res = new CircleLinkedList2();
		}*/
		
		return res;
	}
	


}

