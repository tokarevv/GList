package Sort;

public class Shell implements iSort {

	@Override
	public void sort(int[] a) {

		int h = 1; 

		while ((h * 3 + 1) < a.length) {
			h = 3 * h + 1;
		} 

		while (h > 0) { 
			
			for (int i = h - 1; i < a.length; i++) { 

				int tmp = a[i];
				int j = i; 

				for (j = i; (j >= h) && (a[j - h] > tmp); j -= h) {
					a[j] = a[j - h];
				} 
				a[j] = tmp;
			}
			h = h / 3;
		}
	}

}
