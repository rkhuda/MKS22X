import java.util.*;

public class MyDeque<E> {

    private int front;
    private int back;
    private int size;
    private E[] data;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[]) new Object[10];
	front = 0;
	back = 0;
	size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){

	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}

	data = (E[]) new Object[initialCapacity];
	front = 0;
	back = 0;
	size = 0;
    }

    public int size(){
	return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	E[] temp = (E[]) new Object[data.length * 2];
	if (front <= back){
	    for (int x = 0; x < data.length; x++){
		temp[x] = data[x];
	    }
	}
	else {
	    int index = 0;
	    for (int x = front; x < data.length; x++){
		temp[index] = data[x];
		index++;
	    }
	    for (int x = 0; x <= back; x++){
		temp[index] = data[x];
		index++;
	    }
	}
	data = temp;
	front = 0;
	back = size() - 1;
    }

    public void addFirst(E element){

	if (element == null){
	    throw new NullPointerException();
	}
	if (size() == data.length || back == front - 1){
	    resize();
	}
	if (front == 0){
	    if (data[front] == null){
		data[front] = element;
	    }
	    else {
		data[data.length - 1] = element;
		front = data.length - 1;
	    }
	}
	else {
	    data[front - 1] = element;
	    front = front - 1;
	}
	size = size + 1;
    }

    public void addLast(E element){

	if (element == null){
	    throw new NullPointerException();
	}
	if (size() == data.length || front == back + 1 || back == front + 1){
	    resize();
	}
	if (size == 0){
	    data[0] = element;
	}
        else {
	    if (back == data.length - 1){
		data[0] = element;
		back = 0;
	    }
	    else {
		data[back + 1] = element;
		back = back + 1;
	    }
	}
	size = size + 1;
    }

    public E removeFirst(){

	if (size() == 0){
	    throw new NoSuchElementException();
	}
	
	E ans = data[front];
	data[front] = null;
	if (front == data.length - 1){
	    front = 0;
	}
	else {
	    front = front + 1;
	}
	size = size - 1;
	return ans;
    }

    public E removeLast(){

	if (size() == 0){
	    throw new NoSuchElementException();
	}
	
	E ans = data[back];
	data[back] = null;
	if (back == 0){
	    back = data.length - 1;
	}
	else {
	    back = back - 1;
	}
	size = size - 1;
	return ans;
    }

    public E getFirst(){

	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[front];
    }

    public E getLast(){

	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[back];
    }

    /*
    public String toString(){
	String ans = "[";
	if(front <= back){
	    for (int i = front; i <= back; i++){
		ans += data[i] + " , ";
	    }
	}
	else{
	    for(int i = front; i < data.length; i++){
		ans += data[i] + ", ";
	    }
	    for(int i = 0; i <= back; i++){
		ans += data[i] + ", ";
	    }
	}
	ans = ans.substring(0, ans.length() - 2) + "]";
	return ans;
    }
    */
    

    /*
    public static void main(String[] args){
	MyDeque<String> a = new MyDeque<>();
	a.addFirst("0");
	a.addLast("1");
	System.out.println(a); // [0, 1]
	System.out.println(a.removeFirst()); // 0
	System.out.println(a); // [1]
	System.out.println(a.removeLast()); // 1
	System.out.println(a); // []
	System.out.println(a.getLast()); //exception
    }
    */
    

    /*
    public static void main(String[] args) {
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

	int size = Integer.parseInt(args[0]);
	for(int i = 0; i < size; i++){
	    int temp = (int)(Math.random() * 1000);
	    if(temp % 2 == 0){
		a.addFirst("" + temp);
		a1.addFirst("" + temp);
		b.add(0, "" + temp);
	    }
	    else{
		a.addLast("" + temp);
		a1.addLast("" + temp);
		b.add("" + temp);
	    }
	}

	int index = 0;
	boolean hasError = false;
	String errorEvaluation = "Errors found at these indices: ";
	for (String x : b){
	    if (!(x.equals(a.getFirst()))){
		System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
	    }
	    if (!(x.equals(a.removeFirst()))){
		System.out.println("There is an error at index " + index);
		errorEvaluation += index + ", ";
		hasError = true;
	    }
	    index++;
	}


	if(hasError){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
	}
	else{
	    System.out.println("Your deque is bug-free!");
	}

	//System.out.println(a.getFirst());
	//System.out.println(a.getLast());
    }
    */
    
}
