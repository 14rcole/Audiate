package com.musicg.math.quicksort;
public class QuickSortIndexPreserved {
	
	private QuickSort quickSort;
	
	public QuickSortIndexPreserved(int[] array){
		quickSort=new QuickSortInteger(array);
	}

	public int[] getSortIndexes(){
		return quickSort.getSortIndexes();
	}

}