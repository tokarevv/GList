package Sort;

public class Merge implements iSort {

	private int[] tmp;
	
	@Override
	public	void sort(int a[]){
		tmp = new int[a.length];
		sort(a, 0, a.length - 1);
	}
	
	private void sort(int a[], int indexFrom, int indexTo){ 
		if (indexFrom >= indexTo) {
			return;
		}
		
		int mid = (indexFrom + indexTo) / 2;

		
		sort(a, indexFrom, mid); 
		sort(a, mid + 1, indexTo); 

		
		int i = indexFrom;   //start for 1st part
		int j = mid + 1;	 //start for 2nd part
		int ind = indexFrom; 
		
		int end_1st_part = mid;
		int end_2nd_part = indexTo;
		//here we have 2 sorted sub-arrays - [start - end_1st_part] and [start_2nd_part - end]
		//and we have to merge them.
		while ((i <= end_1st_part) | (j <= end_2nd_part)) {
			if (j > end_2nd_part || (i <= end_1st_part && a[i] < a[j])){
				tmp[ind] = a[i];
				i++;
			}
			else{
				tmp[ind] = a[j];
				j++;
			}
			ind++;
		}
		
		//move sorted data from tmp array to origin array
		for (i = indexFrom; i <= indexTo; i++){
			a[i] = tmp[i];
		}
		
	}


}
