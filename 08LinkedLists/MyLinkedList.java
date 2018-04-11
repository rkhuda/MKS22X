import java.util.LinkedList;

public class MyLinkedList{

    private class Node {

	Node next, prev;
	Integer data;

	public Node(Integer n){
	    data = n;
	}
	
	public Node getNext(){
	    return next;
	}
	public void setNext(Node value){
	    next = value;
	}

	public Node getPrev(){
	    return prev;
	}
	public void setPrev(Node value){
	    prev = value;
	}

	public Integer getValue(){
	    return data;
	}
	public void setValue(Integer value){
	    data = value;
	}

	public String toString(){
	    return data + "";
	}
    }

    private Node start, end;
    private int size;

    //constructor makes an empty list
    public MyLinkedList(){
	size = 0;
    }

    private Node getNode(int index){
	Node current = start;
	int CT = 0;
	while (current != null){
	    if (CT == index){
		return current;
	    }
	    CT = CT + 1;
	    current = current.getNext();
	}
	return current;
    }

    //returns the number of elements in the list
    public int size(){
	return size;
    }

    //clears the list
    public void clear(){
	size = 0;
    }

    //returns value of element at specified index
    public Integer get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	
	int CT = -1;
	Node current = start;
	while (current != null){
	    CT = CT + 1;
	    if (CT == index){
		return current.getValue();
	    }
	    current = current.getNext();
	}
	return -1; //so it compiles
    }

    //changes element at specified index to Integer value
    //returns old value
    public Integer set(int index, Integer value){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	
	int CT = -1;
	int oldValue = 0;
	Node current = start;
	while (current != null){
	    CT = CT + 1;
	    if (CT == index){
		oldValue = current.getValue();
		current.setValue(value);
		return oldValue;
	    }
	    current = current.getNext();
	}
	return -1; //so it compiles
    }

    //returns index of 1st occurence of value
    //returns -1 if not found
    public int indexOf(Integer value){
	int CT = 0;
	Node current = start;
	while (current != null){
	    if (current.getValue().equals(value)){
		return CT;
	    }
	    CT = CT + 1;
	    current = current.getNext();
	}
	return -1;
    }

    //adds value to the end of the list
    public boolean add(Integer newData){	
	if (size() == 0){
	    start = new Node(newData);
	    end = start;
	}
	else {
	    Node last = new Node(newData);
	    end.setNext(last);
	    last.setPrev(end);
	    end = last;
	}
	size = size + 1;
	return true;
    }

    //inserts new element at specified index
    public void add(int index, Integer value){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	
	Node newNode = new Node(value);
	Node current = getNode(index);

	if (index == size()){
	    add(value);
	}
	else if (index == 0){
	    newNode.setNext(current);
	    current.setPrev(newNode);
	    start = newNode;
	    size = size + 1;
	}
	else{
	    current.getPrev().setNext(newNode);
	    newNode.setPrev(current.getPrev());
	    newNode.setNext(current);
	    current.setPrev(newNode);
	    size = size + 1;
	}
    }

    //removes element at specified index
    public Integer remove(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}

	int CT = 0;
	Node current = getNode(index);
	while (CT <= index){
	    if (CT == index){
		if (index == 0){
		    start = current.getNext();
		}
		else if (index == (size() - 1)){
		    end = current.getPrev();
		    end.setNext(null);
		}
		else {
		    current.getPrev().setNext(current.getNext());
		    current.getNext().setPrev(current.getPrev());
		}
		size = size - 1;
		return current.getValue();
	    }
	    CT = CT + 1;
	}
	return -1;
    }
    
    //removes 1st occurence of specified element
    public boolean remove(Integer value){
	Node current = start;
	while (current != null){
	    if (current.getValue().equals(value)){
		if (current.equals(start)){
		    start = current.getNext();
		}
		else if (current.equals(end)){
		    end = current.getPrev();
		    end.setNext(null);
		}
		else {
		    current.getPrev().setNext(current.getNext());
		    current.getNext().setPrev(current.getPrev());
		}
		size = size - 1;
		return true;
	    }
	    current = current.getNext();
	}
	return false;
    }

    //return list in the form of an array
    public String toString(){
	if (size() == 0){
	    return "[]";
	}
	String ans = "[";
	Node current = start;
	while (current != null){
	    if (current.getNext() == null){
		ans = ans + current.getValue() + "]";
	    }
	    else {
		ans = ans + current.getValue() + ", ";
	    }
	    current = current.getNext();
	}
	return ans;
    }
    /*
    public static void main(String[]args){
      MyLinkedList nums = new MyLinkedList();
      LinkedList<Integer> nums2 = new LinkedList<>();

      
      for(int i = 0; i < 2000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
	
        nums.add(index,i);
        nums2.add(index,i);
	
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds");
      
      int max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        if(nums.remove(i)!=nums2.remove(i).intValue()){
          System.out.println("FAIL while removing index: "+i);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL consecutive removes");
          return;
        }
      }
      System.out.println("PASS consecutive removes");
      
      
      for(int i = 0; i < 1000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds phase 2");
      
      
      max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        int index = (int)(Math.random()*nums.size());
        if(nums.remove(index)!=nums2.remove(index).intValue()){
          System.out.println("FAIL while removing index: "+index);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL randomized removes");
          return;
        }
      }
      System.out.println("PASS randomized removes");
      
      //get-------------------
      try{
        nums.get(-3);
        System.out.println("FAIL get access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds negateive index ");
      }
      
      try{
        nums.get(nums.size());
        System.out.println("FAIL get access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds index too large");
      }
      
      
      //set-------------------
      try{
        nums.set(-3,5);
        System.out.println("FAIL set access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds negateive index ");
        
      }
      
      try{
        nums.set(nums.size(),5);
        System.out.println("FAIL set access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds index too large");
      }
      
      
      
      //add-------------------
      try{
        nums.add(nums.size()+1,5);
        System.out.println("FAIL add access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds index too large");
      }
      
      try{
        nums.add(-1,5);
        System.out.println("FAIL add access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds negative index");
      }
      
      
      
      //remove-------------------
      try{
        nums.remove(nums.size()+1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      try{
        nums.remove(-1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      
      //
      nums.clear();
      if(nums.size()==0){
        System.out.println("PASS clear");
      }else{
        System.out.println("FAIL clear");
        return;
      }
      
      
      
      //REMOVE BY VALUE (not index)
      nums.clear();
      for(int i = 0; i < 10; i++){
        nums.add(0,Integer.valueOf(i));
      }
      if(nums.remove(Integer.valueOf(0)) && nums.remove(Integer.valueOf(1)) &&
      nums.remove(Integer.valueOf(5)) && nums.remove(Integer.valueOf(3)) &&
      nums.remove(Integer.valueOf(8))&& nums.remove(Integer.valueOf(9)))  {
        try{
          int[]result = { 7, 6, 4, 2};
          for(int i = 0; i < nums.size();i++ ){
            if(result[i]!=nums.get(i).intValue()){
              System.out.println("FAIL to remove by value. Final State bad");
              return;
            }
          }
        }catch(Exception e){
          System.out.println("FAIL to remove by value. Exception thrown");
          return;
        }
      }else{
        System.out.println("FAIL to remove by value.");
        return;
      }
      System.out.println("PASS remove by values (Integer, not int).");
      
      nums.clear();
      long end,start = System.currentTimeMillis();
      
      System.out.println("#Adding to 100000 values to the front, and 100000 to the end, should be fast.\n#If the next line doesn't print right away you have some issues.");
      for(int i = 0; i < 100000; i++  ){
	nums.add(i);
        nums.add(nums.size(),i);
      }
      end = System.currentTimeMillis();
      //mine was 8msec on a laptop, so 250 should be fine!
      if(end - start > 250){
        System.out.println("FAIL! Should be much faster than "+(end-start)+"msec");
        return;
      }else{
        System.out.println("PASS "+ (end-start)+" msec current size: "+nums.size());
      }
    }
    */
}
