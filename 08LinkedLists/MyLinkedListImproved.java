public class MyLinkedListImproved<T>{ //implements Iterable<T>

    private class Node {

	Node next, prev;
	T data;

	public Node(T n){
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

	public T getValue(){
	    return data;
	}
	public void setValue(T value){
	    data = value;
	}

	public String toString(){
	    return data + "";
	}
    }

    private Node start, end;
    private int size;

    //constructor makes an empty list
    /*
    public MyLinkedList(){
	size = 0;
    }
    */

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
    public T get(int index){
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
	return current.getValue(); //so it compiles
    }

    //changes element at specified index to Integer value
    //returns old value
    public T set(int index, T value){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	
	int CT = -1;
	T oldValue = value;
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
	return oldValue; //so it compiles
    }

    //returns index of 1st occurence of value
    //returns -1 if not found
    public int indexOf(T value){
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
    public boolean add(T newData){	
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
    public void add(int index, T value){
	if (size() == 0 && index == 0){
	    add(value);
	}
	else if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	else{

	int CT = 0;
	Node current = start;
	Node temp = new Node(value);
	while (CT <= index){
	    if (CT == index){
		if (index == 0){
		    temp.setNext(current);
		    current.setPrev(temp);
		    start = temp;
		}
		else if (index == (size() - 1)){
		    end.setNext(temp);
		    temp.setPrev(end);
		    end = temp;
		}
		else {
		    temp.setPrev(current.getPrev());
		    temp.setNext(current);
		    current.getPrev().setNext(temp);
		    current.setPrev(temp);
		}
		size = size + 1;
	    }
	    CT = CT + 1;
	    current = current.getNext();
	}
	}
	
    }

    //removes element at specified index
    public T remove(int index){
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
	return current.getValue();
    }
    
    //removes 1st occurence of specified element
    public boolean remove(T value){
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

    public static void main(String[] args){
	MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
	n.add("fish");
	System.out.println(n);

	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
        m.add(new Integer(0));
	System.out.println(m);
    }
    
}
