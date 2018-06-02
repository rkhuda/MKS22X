import java.util.*;

public class Sorts {

    public static void heapsort(int[] data){

	MyHeap<Integer> heap = new MyHeap<Integer>(false);

	for (int x = 0; x < data.length; x++){
	    heap.add(data[x]);
	}
	//System.out.println(heap);

	for (int x = 0; x < data.length; x++){
	    data[x] = heap.remove();
	    //System.out.println(heap);
	}
    }

    /*
    public static void main(String[] args){
	int[] a = new int[10000];
	for (int x = 0; x < a.length; x++){
	    a[x] = (int)(Math.random()*10);
	}
	//System.out.println(Arrays.toString(a));

	heapsort(a);
	//System.out.println("finished");
    }
    */
}
