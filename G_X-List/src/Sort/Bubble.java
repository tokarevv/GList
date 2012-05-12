package Sort;

public class Bubble implements iSort {

	@Override
	public	void sort(int a[]){
		for (int i = a.length-1; i > 0; i--) {
			boolean swapIsMade = false;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					swapIsMade = true;
				}
			}
			if (!swapIsMade) { // we don't need further sort
				return;
			}
		}
	}
}
