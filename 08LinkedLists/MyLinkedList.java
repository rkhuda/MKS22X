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
    
}
