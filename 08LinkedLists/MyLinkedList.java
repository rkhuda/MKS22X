public class MyLinkedList{

    private Node start, end;
    private int size;

    private class Node {

	Node next, prev;
	Integer data;

	public Node(Integer n){
	    data = n;
	}

	public Node getNext(){
	    return next;
	}
	public void setNext(Integer value){
	    next.setValue(value);
	}

	public Node getPrev(){
	    return prev;
	}
	public void setPrev(Integer value){
	    prev.setValue(value);
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
    
    public MyLinkedList(){
	//makes an empty list
	size = 0;
    }

    //private Node getNode(int index){}

    //public void clear(){}

    public boolean add(Integer newData){
	//adds the value to the end
	Node current = new Node(newData);
	if (size() == 0){
	    start = current;
	}
	end = current;
	size = size + 1;
	return true;
    }

    public int size(){
	//returns number of elements in the list
	Node current = start;
	while (current != null){
	    size = size + 1;
	    current = current.getNext();
	}
	return size;
    }

    public Integer get(int index){
	//return value of element at specified index
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
	return -1; //testing purposes
    }

    public Integer set(int index, Integer value){
	//change value of element at specified index to newValue
	//return old value
	//throws exceptions
	int CT = -1;
	Node current = start;
	while (current != null){
	    CT = CT + 1;
	    if (CT == index){
		current.setValue(value);
		return current.getPrev().getValue();
	    }
	    current = current.getNext();
	}
	return -1; //testing purposes
    }

    public int indexOf(Integer value){
	//returns index of 1st occurence of value
	//returns -1 if not found
	int CT = -1;
	Node current = start;
	while (current != null){
	    CT = CT + 1;
	    if (current.getValue() == value){
		return CT;
	    }
	    current = current.getNext();
	}
	return -1;
    }

    public void add(int index, Integer value){
	//insert new element at specified index
	//throws exceptions
	int CT = -1;
	Node current = start;
	while (current != null){
	    CT = CT + 1;
	    if (CT == index){
		//add element
		size = size + 1;
	    }
	    current = current.getNext();
	}
    }
    /*
    public boolean remove(int index){
	//remove element at specified index
	//returns value removed
	//throws exceptions
    }
    */

    //public boolean remove(Integer value){}

    public String toString(){
	//returns string representation [0, 1, 2...]
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
    
    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();

	//for (int x = 0; x < 10; x++){
	//a.add(new Integer((int)(Math.random()*100)));
	//}
	Integer b = new Integer(9);
	Integer c = new Integer(10);
	a.add(b);
	a.add(c);

	System.out.println(a);

	//for (int y = 0; y < 10; y++){
	    //System.out.println(y + ":" + a.get(y));
	//}
    }
    
}
