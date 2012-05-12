package Sort;

public class Insertion implements iSort {

	@Override
	public void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j = i;
			int n = a[i]; //curr - potentially max
			while ((j > 0) && (a[j - 1] > n)) {
				a[j] = a[j - 1]; 
				j--;
			}
			a[j] = n; //set curr instead of prev bigger
		}
	}

}
