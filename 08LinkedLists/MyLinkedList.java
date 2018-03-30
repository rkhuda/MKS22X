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

	public int getValue(){
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
	length = 0;
    }

    //private Node getNode(int index){}

    //public void clear(){}

    public boolean add(Integer newData){
	//adds the value to the end
	Node current = new Node(newData);
	last = current;
	size = size + 1;
    }

    public int size(){
	//returns number of elements in the list
	Node current = first;
	while (current != null){
	    size = size + 1;
	    current = current.getNext();
	}
	return size;
    }

    public Integer get(int index){
	//return value of element at specified index
	//throws exceptions
	int CT = -1;
	Node current = first;
	while (current != null){
	    CT = CT + 1;
	    if (CT == index){
		return current.getValue();
	    }
	    current = current.getNext();
	}
    }

    public Integer set(int index, Integer value){
	//change value of element at specified index to newValue
	//return old value
	//throws exceptions
	int CT = -1;
	Node current = first;
	while (current != null){
	    CT = CT + 1;
	    if (CT == index){
		current.setValue(newValue);
		return current.getPrev().getValue();
	    }
	    current = current.getNext();
	}
    }

    public int indexOf(Integer value){
	//returns index of 1st occurence of value
	//returns -1 if not found
	int CT = -1;
	Node current = first;
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
	Node current = first;
	while (current != null){
	    CT = CT + 1;
	    if (CT == index){
		//add element
		length = length + 1;
	    }
	    current = current.getNext();
	}
    }

    public boolean remove(int index){
	//remove element at specified index
	//returns value removed
	//throws exceptions
    }

    public boolean remove(Integer value){}

    public String toString(){
	//returns string representation [0, 1, 2...]
	String ans = "[";
	int CT = 0;
	Node current = first;
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
