public class MyLinkedList{

    Node first;
    Node last;
    int length;

    private class Node {

	Node next, prev;
	int data;

	public Node(int n){
	    data = n;
	}

	public Node getNext(){
	    return next;
	}
	public void setNext(int value){
	    next.setValue(value);
	}

	public Node getPrev(){
	    return prev;
	}
	public void setPrev(int value){
	    prev.setValue(value);
	}

	public int getValue(){
	    return data;
	}
	public void setValue(int value){
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

    public boolean add(int value){
	//adds the value to the end (try adding to front first)
	Node current = new Node(value);
	first = current;
	//last = current;
    }

    public int size(){
	//returns number of elements in the list
	int CT = 0;
	Node current = first;
	while (current != null){
	    CT = CT + 1;
	    current = current.getNext();
	}
	return CT;
    }

    public int get(int index){
	//return value of element at specified index
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

    public void set(int index, int newValue){
	//change value of element at specified index to newValue
	//return old value
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

    public int size(){}

    public void add(int index, int value){}

    public void remove(int index){}

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
