package com.musicg.math.quicksort;
public class QuickSortIndexPreserved {
	
	private QuickSortInteger quickSort;
	
	public QuickSortIndexPreserved(int[] array){
		quickSort=new QuickSortInteger(array);
	}

	public int[] getSortIndexes(){
		return quickSort.getSortIndexes();
	}

}