import java.util.*;

public class RunningMedian {

    private int size;
    private MyHeap<Double> small;
    private MyHeap<Double> large;

    //makes an empty container for Doubles
    public RunningMedian() {
	small = new MyHeap<Double>();
	large = new MyHeap<Double>(false);
	size = 0;
    }

    //insert a Double into data structure
    public void add(Double value){
	if (size() == 0){
	    large.add(value);
	}
	else {
	    if (value > getMedian()){
		large.add(value);
	    }
	    else if (value <= getMedian()){
		small.add(value);
	    }
	}
	if (Math.abs(large.size() - small.size()) == 2){
	    if (large.size() > small.size()){
		small.add(large.peek());
		large.remove();
	    }
	    else if (small.size() > large.size()){
		large.add(small.peek());
		small.remove();
	    }
	}
	size = size + 1;
    }

    public String toString(){
	return small.toString() + large.toString();
    }

    //return current median
    //throws NoSuchElementException when size is 0
    public Double getMedian(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	else if (large.size() == small.size()){
	    return (large.peek() + small.peek()) / 2;
	}
	else if (large.size() > small.size()){
	    return large.peek();
	}
	else if (large.size() < small.size()){
	    return small.peek();
	}
	return -1.0; //so it compiles
    }

    public int size(){
	return size;
    }

    /*
    public static void main(String[] args){
	RunningMedian a = new RunningMedian();
	//System.out.println(a.size());

	a.add(60.0);
	System.out.println(a);
	System.out.println(a.getMedian());
	System.out.println(a.size());
	

	a.add(50.0);
	System.out.println(a);
	System.out.println(a.getMedian());
	System.out.println(a.size());

	a.add(30.0);
	System.out.println(a);
	System.out.println(a.getMedian());
	System.out.println(a.size());

	//doesnt work
	a.add(40.0);
	System.out.println(a);
	System.out.println(a.getMedian());
	System.out.println(a.size());
	

	
	a.add(70.0);
	System.out.println(a);
	System.out.println(a.getMedian());
	System.out.println(a.size());

	a.add(40.0);
	System.out.println(a);
	System.out.println(a.getMedian());
	System.out.println(a.size());

	
	a.add(90.0);
	System.out.println(a);
	System.out.println(a.getMedian());
	System.out.println(a.size());

	
	a.add(80.0);
	System.out.println(a);
	System.out.println(a.getMedian());
	System.out.println(a.size());

	
       
    }
    */
}
