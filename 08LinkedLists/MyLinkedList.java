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
	if (index < 0 || index > size()){
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
		    temp.setPrev(current);
		    temp.setNext(current.getNext());
		    current.setNext(temp);
		}
		size = size + 1;
	    }
	    CT = CT + 1;
	    current = current.getNext();
	}
    }

    //removes element at specified index
    public boolean remove(int index){
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
		return true;
	    }
	    CT = CT + 1;
	}
	return false;
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
    public static void main(String[] args){
	System.out.println();
        System.out.println("--- Get ---");
        MyLinkedList a = new MyLinkedList();
        
        for (int x = 0; x < 10; x++) {
            a.add(new Integer((int) (Math.random() * 100)));
        }
        
        System.out.println(a);
        
        for (int y = 0; y < 10; y++) {
            System.out.println(y + ": " + a.get(y));
        }
        
        System.out.println();
        System.out.println("--- Set ---");
        System.out.println(a);
        
        int former;
        int replace;
        
        for (int q = 0; q < 10; q++) {
            replace = 10 - q;
            former = a.set(q, replace);
            System.out.println("Change " + former + " to " + replace);
        }
        
        System.out.println(a);
        
        System.out.println();
        System.out.println("--- Index Of ---");
        System.out.println(a);
        
        for (int z = 0; z < 12; z++) {
            System.out.println(z + ": " + a.indexOf(new Integer(z)));
        }
        
        System.out.println();
        System.out.println("--- Add At End ---");
        MyLinkedList b = new MyLinkedList();
        System.out.println(b);

        for (int i = 0; i < 10; i++) {
            b.add(new Integer((int) (Math.random() * 100)));
        }

        System.out.println(b);
        System.out.println("Size: " + b.size());
        
        System.out.println();
        System.out.println("--- Add At Index ---");
        System.out.println(b);
        
        for (int s = 0; s < 10; s += 6) {
            b.add(s, new Integer(-99));
            System.out.println("Index " + s + ": " + b);
        }
        
        System.out.println();
        System.out.println("--- Remove Value ---");
        MyLinkedList j = new MyLinkedList();
        
        for (int u = 1; u < 6; u++) {
            j.add(new Integer(u));
        }
        
        System.out.println(j);
        
        for (int k = 1; k < 6; k += 2) {
            System.out.println("Removing " + k);
            j.remove(new Integer(k));
            System.out.println(j);
        }
        
        System.out.println();
        System.out.println("--- Remove at Index ---");
        MyLinkedList c = new MyLinkedList();

	for (int f = 0; f < 10; f++) {
            c.add(new Integer((int) (Math.random() * 100)));
        }
        
        System.out.println(c);
        System.out.println("Size: " + c.size());
        
        System.out.println("Removed " + c.get(0) + " at index 0");
        c.remove(0);
        
        System.out.println("Removed " + c.get(4) + " at index 4");
        c.remove(4);
        
        System.out.println("Removed " + c.get(7) + " at index 7");
        c.remove(7);
        
        System.out.println(c);

	c.clear();
	System.out.println(c);
    }
    */
    
}
