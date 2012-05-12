package Sort;

public class Quick implements iSort {

	@Override
	public void sort(int[] a) {
		sort(a, 0, a.length - 1);

	}

	private static void sort(int[] a, int left, int right) {
		int i, j;
		int x, y;
		
		if (left >= right){
			return;
		}
		
		i = left;
		j = right;
		x = a[(left + right) / 2];

		do {
			while ((a[i] < x) && (i < right))
				i++;
			while ((x < a[j]) && (j > left))
				j--;

			if (i <= j) {
				y = a[i];
				a[i] = a[j];
				a[j] = y;
				i++;
				j--;
			}
		} while (i <= j);

		if (left < j)
			sort(a, left, j);
		if (i < right)
			sort(a, i, right);

	}

}
