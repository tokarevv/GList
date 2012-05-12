package Tests;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import List.*;
import Sort.*;


@RunWith(Parameterized.class)
public class ListTest_Person {

	private String list;
	private final Person[] PatternList = {
			new Person("Nikolay", "Shvachka", 24), 
			new Person("Mike", "Richards", 28), 
			new Person("Nikolay", "Shvachka", 21)
			};
	
	private Object[] arrayToCompare;

	public ListTest_Person(String list) {
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
		iList<Person> list = getNewList();
		assertEquals(0, list.size());	
	}
	
	@Test
	public void initializtionViaArrayTest(){
		iList<Person> list = getNewList();
		list.init(PatternList);
		assertEquals(3, list.size());	
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getEmptyTest(){
		iList<Person> list = getNewList();
		list.get(0);
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void setEmptyTest(){
		iList<Person> list = getNewList();
		list.set(0,new Person("Nikolay", "Shvachka", 24));
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void setEmpty90Test(){
		iList<Person> list = getNewList();
		list.set(90,new Person("Nikolay", "Shvachka", 24));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeFirstEmptyTest(){
		iList<Person> list = getNewList();
		list.removeFirst();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeFromEndEmptyTest(){
		iList<Person> list = getNewList();
		list.removeFromEnd();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeFromIndexEmptyTest(){
		iList<Person> list = getNewList();
		list.removeFromIndex(0);
	}
	//****  for one   ****//
	@Test
	public void addToEndOneTest(){
		iList<Person> list = getNewList();
		list.addToEnd(new Person("Nikolay", "Shvachka", 24));
		assertEquals(1, list.size());	
	}
	
	@Test
	public void addToStartOneTest(){
		iList<Person> list = getNewList();
		list.addToStart(new Person("Nikolay", "Shvachka", 24));
		assertEquals(1, list.size());	
	}
	
	@Test
	public void addToIndexOneTest(){
		iList<Person> list = getNewList();
		list.addToIndex(0, new Person("Nikolay", "Shvachka", 24));
		assertEquals(1, list.size());	
	}
	
	@Test
	public void getOneTest(){
		iList<Person> list = getNewList();
		list.addToEnd(new Person("Nikolay", "Shvachka", 24));
		assertEquals(new Person("Nikolay", "Shvachka", 24), list.get(0));	
	}
	
	private iList getListOne() {
		iList res = getNewList();
		res.addToEnd(new Person("Nikolay", "Shvachka", 24));
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
		//arrayToCompare = new Integer[]{3,2,1};
		iList<Person> list = getNewList();
		list.addToStart(new Person("Nikolay", "Shvachka", 21));
		list.addToStart(new Person("Mike", "Richards", 28));
		list.addToStart(new Person("Nikolay", "Shvachka", 24));
		assertTrue(Arrays.deepEquals(PatternList, list.toArray()));	
	
		private final Person[] PatternList = {
				new Person("Nikolay", "Shvachka", 24), 
				new Person("Mike", "Richards", 28), 
				new Person("Nikolay", "Shvachka", 21)
				};
	}

	@Test
	public void addTest(){
		arrayToCompare = new Integer[]{1,2,3};
		iList<Person> list = getNewList();
		list.addToEnd(1);
		list.addToEnd(2);
		list.addToEnd(3);
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
	}
	
	@Test
	public void addToIndexTest(){
		arrayToCompare = new Integer[]{2,1,3};
		iList<Person> list = getNewList();
		list.addToIndex(0,1);
		list.addToIndex(1,3);
		list.addToIndex(0,2);
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
	}

	@Test
	public void getTes(){
		iList<Person> list = getNewList();
		list.init(new Integer[]{1,2,3});
		assertEquals(new Integer(2), list.get(1));	
	}
	
	@Test
	public void sizeTest(){
		iList<Person> list = getNewList();
		list.init(new Integer[]{1,2,3});
		assertEquals(3, list.size());	
	}
	
	@Test
	public void setTest(){
		arrayToCompare = new Integer[]{1,4,3};
		iList<Person> list = getNewList();
		list.init(new Integer[]{1,2,3});
		list.set(1,4);
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
	}

	@Test
	public void indexOfTest(){
		iList<Person> list = getNewList();
		assertEquals(-1, list.indexOf(2));	
		list.init(new Integer[]{1,5,4,2,3,2});
		assertEquals(3, list.indexOf(2));	
	}

	@Test
	public void sortTest(){
		arrayToCompare = new Integer[]{1,2,2,3,4,5};
		iList<Person> list = getNewList();
		list.init(new Integer[]{1,5,4,2,3,2});
		list.sort();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}
	
	@Test
	public void removeTest(){
		arrayToCompare = new Integer[]{1,5};
		iList<Person> list = getNewList();
		list.init(new Integer[]{1,5,4});
		list.removeFromEnd();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}
	
	@Test
	public void removeFirstTest(){
		arrayToCompare = new Integer[]{5,4};
		iList<Person> list = getNewList();
		list.init(new Integer[]{1,5,4});
		list.removeFirst();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}
	
	@Test
	public void removeFromIndexTest(){
		arrayToCompare = new Integer[]{1,4};
		iList<Person> list = getNewList();
		list.init(new Integer[]{1,5,4});
		list.removeFromIndex(1);
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}

	//sorting via iSort methods
	/*@Test
	public void sortBubbleTest(){
		arrayToCompare = new int[]{1,2,2,3,4,5};
		iList<Person> list = getNewList();
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
		iList<Person> list = getNewList();
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
		iList<Person> list = getNewList();
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
		iList<Person> list = getNewList();
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
		iList<Person> list = getNewList();
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
		iList<Person> list = getNewList();
		list.init(new int[]{1,5,4,2,3,2});
		SortHandler sh = new SortHandler(list);
		sh.setSortMethod(new Shell());
		sh.sort();
		//list.sort();
		assertTrue(Arrays.equals(arrayToCompare, list.toArray()));	
		
	}*/
		
	
	//***** inner
	private iList<Person> getNewList() {
		iList<Person> res = null;
		if (list.equals("ArList")){
			res = new ArList<Person>();
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

