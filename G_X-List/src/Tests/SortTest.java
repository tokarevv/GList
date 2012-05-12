package Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Sort.*;

@RunWith(value = Parameterized.class)
public class SortTest {
	private int n = 5000;
	private iSort sortMethod;

	public SortTest(iSort sortMethod) {
		this.sortMethod = sortMethod;
	}

	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection data() {
		// ArList arList = ;
		Object[][] data = new Object[][] { 
				//{ new Bubble() },
				//{ new Insertion() }, 
				//{ new Selection() }, 
				//{ new Merge() },
				//{ new Quick() }, 
				{ new Shell() }
				};
		return Arrays.asList(data);
	}

	// ***** empty
	@Test
	public void testSortEmpty() {
		int[] a = new int[0];
		int[] sorted = new int[0];

		sortMethod.sort(a);
		assertArrayEquals(sorted, a);
	}

	// ***** one
	@Test
	public void testSortOne() {
		int[] a = new int[] { 1 };
		int[] sorted = new int[] { 1 };

		sortMethod.sort(a);
		assertArrayEquals(sorted, a);
	}

	// ***** few
	@Test
	public void testSortFew() {
		int[] a = new int[] { 5, 87, 85, 78, 45, 2, 7, 4 };
		int[] sorted = new int[] { 2, 4, 5, 7, 45, 78, 85, 87 };

		sortMethod.sort(a);
		assertArrayEquals(sorted, a);
	}

	// ***** many
	@Test
	public void testSortMany() {
		int[] a = new int[n];
		for (int i = 0; i < n; i++){
			a[i] = (int) (Math.random()*n);
		}
		int[] sorted = a.clone();
		Arrays.sort(sorted);

		sortMethod.sort(a);
		assertArrayEquals(sorted, a);
	}

}
