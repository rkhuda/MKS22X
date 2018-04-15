import java.util.*;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){

	@SuppressWarnings("unchecked") ArrayList<Integer>[] bucket = new ArrayList[10];

	Integer max = data.get(data.max());

	for (int x = 0; x < 10; x++){
	    bucket[x] = new ArrayList<Integer>();
	}
	for (Integer x : data){
	    bucket[x%10].add(x);
	}
	
	MyLinkedListImproved<Integer> temp = new MyLinkedListImproved<Integer>();
	for (int x = 0; x < 10; x++){
	    for (Integer i: bucket[x]){
		temp.add(i);
	    }
	    bucket[x].clear();
	}
	
	Integer index = 0;
	for (Integer y : temp){
	    index = y;
	    
	    while (index >= 10){
		index = index/10;
	    }
	    if (y/10 < 10 && max/10 > 10){
		index = 0;
	    }
	    
	    int CT = bucket[index].size();
	    while (CT > 0 && y < bucket[index].get(CT - 1)){
		CT = CT - 1;
	    }
	    if (CT == bucket[index].size()){
		bucket[index].add(y);
	    }
	    else{
		bucket[index].add(CT, y);
	    }
	}
	temp.clear();
	for (int x = 0; x < 10; x++){
	    for (Integer i: bucket[x]){
		temp.add(i);
	    }
	}
	
	data.clear();
	for (Integer x : temp){
	    data.add(x);
	}
    }

    /*
    public static void main(String[] args){
	MyLinkedListImproved<Integer> data = new MyLinkedListImproved<Integer>();
	for (int x = 0; x < 10; x++){
	    int i = (int)(Math.random() * 1000);
	    data.add(new Integer(i));
	}
	System.out.println(data);
	radixsort(data);
	System.out.println(data);
    }
    */
    
}
