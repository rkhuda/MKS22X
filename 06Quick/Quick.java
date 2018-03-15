import java.io.*;
import java.util.*;

public class Quick {

    //public static void quicksort(int[] ary){

    //int start = 0;
    //int end = ary.length - 1;
	
    //}

    public static int quickselect(int[] ary, int k) {

	int start = 0;
	int end = ary.length - 1;

	if ((k - 1) == partition(ary, start, end)) {
	    return ary[k - 1];
	}

	if ((k - 1) < partition(ary, start, end)){
	    end = partition(ary, start, end);
	    partition(ary, start, end);
	}

	if ((k - 1) > partition(ary, start, end)){
	    start = partition(ary, start, end);
	    partition(ary, start, end);
	}

	return ary[k - 1];
    }

    public static int partition(int[]data, int start, int end){

	int pivot = (int)(Math.random() * ((end - start) + 1) + start);

	swap(data, start, pivot);
	int small = start + 1;
	int large = end;
	
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
    /*
    public static void main(String[] args){

	int[] data = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
	System.out.println(Arrays.toString(data));

	//System.out.println(partition(data, 0, data.length - 1));
	System.out.println(quickselect(data, 2));
	System.out.println(Arrays.toString(data));
    }
    */
}
