import java.io.*;
import java.util.*;

public class Quick {

    //public static void quicksort(int[] ary){
	
    //}

    public static int quickselect(int[] ary, int k) {

	int start = 0;
	int end = ary.length - 1;

	if (k == partition(ary, start, end)) {
	    return ary[k];
	}

	if (k < partition(ary, start, end)){
	    end = partition(ary, start, end);
	    partition(ary, start, end);
	}

	if (k > partition(ary, start, end)){
	    start = partition(ary, start, end);
	    partition(ary, start, end);
	}

	return ary[k];
    }

    public static int partition(int[]data, int start, int end){

	int pivotI = (int)(Math.random() * ((end - start) + 1) + start);

	swap(data, start, pivotI);
	int small = start + 1;
	//int small = start;
	int large = end;
	//int index = small + 1;
	//int pivot = data[pivotI];
	/*
	while (index <= large) {
	    if (data[index] == pivot){
		index = index + 1;
	    }
	    if (data[index] > pivot) {
		swap(data, index, large);
		large = large - 1;
	    }
	    else {
		swap(data, small, index);
		small = small + 1;
		index = index + 1;
	    }
	}
	*/
	
		    
	while (small <= large) {
	    if (data[small] < data[start]) {
		small = small + 1;
	    }
	    else {
		swap(data, small, large);
		large = large - 1;
	    }
	    
	}
	    

	swap(data, large, start);
	
	return large;
    }

    private static void swap(int[] data, int index1, int index2){
	int tracker = 0;
	tracker = data[index1];
	data[index1] = data[index2];
	data[index2] = tracker;
    }
    
    public static void main(String[] args){
	int[] ary = {9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5};
	System.out.println(Quick.quickselect(ary,5) + " <- Should be 0");
	
	int[] ary1 = {9,5,8,7,5,6,5,-3,4,5,3,4,5,1,2,3,4,4,3,5,4,3};
	System.out.println(Quick.quickselect(ary1,19) + " <- Should be 7");
	System.out.println(Quick.quickselect(ary1,13) + " <- Should be 5");
	System.out.println(Quick.quickselect(ary1,0) + " <- Should be -3");
	System.out.println(Quick.quickselect(ary1,ary1.length-1) + " <- Should be 9");
	/*
	int[] ary2 = {3,6,1,2,4,6,8,99,1,2,32,45,123,-23,12,-30,-12,-3};
	Quick.quicksort(ary2);
	System.out.println("Your sorted array" + "\n" + Arrays.toString(ary2));
	System.out.println("The correct array\n[-30, -23, -12, -3, 1, 1, 2, 2, 3, 4, 6, 6, 8, 12, 32, 45, 99, 123]");
	*/

	//int[] data = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
	//System.out.println(Arrays.toString(data));

	//System.out.println(partition(data, 0, data.length - 1));
	//System.out.println(quickselect(data, 2));
	//System.out.println(Arrays.toString(data));
    }
    
}
