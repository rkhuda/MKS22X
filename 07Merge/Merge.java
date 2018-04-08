public class Merge {

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length - 1);
    }

    private static void msort(int[] data, int[] temp, int lo, int hi){
	if (lo >= hi){
	    return;
	}
	for (int x = lo; x <= hi; x++){
	    temp[x] = data[x];
	}
	
	int mid = (hi + lo)/2;
	msort(temp, data, lo, mid);
	msort(temp, data, mid + 1, hi);
	merge(data, temp, lo, mid, mid + 1, hi);
    }

    private static void merge(int[] data, int[] temp, int lo, int mid, int next, int hi){
	int CT = lo;

	while (lo <= mid && next <= hi){
	    if (temp[lo] < temp[next]){
		data[CT] = temp[lo];
		lo = lo + 1;
	    }
	    else {
		data[CT] = temp[next];
		next = next + 1;
	    }
	    CT = CT + 1;
	}

	while (lo <= mid){
	    data[CT] = temp[lo];
	    CT = CT + 1;
	    lo = lo + 1;
	}

	while (next <= hi){
	    data[CT] = temp[next];
	    CT = CT + 1;
	    next = next + 1;
	}
    }
    /*
    public static String toString(int[] data){
	String ans = "[";
	for (int x = 0; x < data.length; x++){
	    if (x == data.length - 1){
		ans = ans + data[x] + "]";
	    }
	    else {
		ans = ans + data[x] + ", ";
	    }
	}
	return ans;
    }

    public static void main(String[] args){
	//int[] a = new int[] {3,2,1,853,7,54,11,76,865,999};
       	//mergesort(a);
	//System.out.println(toString(a));

	int[] b = {1, 300, 20, 50000, 7000000, 4000, 600000, 900000000};
	mergesort(b);
	System.out.println(toString(b));
    }
    */
}
