public class MyHeap<T extends Comparable<T>> {

    private T[] data;
    private int size;
    private boolean isMax;

    @SuppressWarnings("unchecked")
    public MyHeap() {
	data = (T[])new Comparable[10];
	isMax = true;
	size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean max){
	data = (T[])new Comparable[10];
	isMax = max;
	size = 0;
    }

    public void add(T value){
	if (size == data.length){
	    resize();
	}
	data[size()] = value;
	size = size + 1;
	addHelp(size() - 1);
    }

    private void addHelp(int index){
	if (index > 0){
	    if (isMax){
		if (data[(index - 1) / 2].compareTo(data[index]) < 0){
		    swap((index - 1) / 2, index);
		    addHelp((index - 1) / 2);
		}
	    }
	    else {
		if (data[(index - 1) / 2].compareTo(data[index]) > 0){
		    swap((index - 1) / 2, index);
		    addHelp((index - 1) / 2);
		}
	    }
	}
    }

    @SuppressWarnings("unchecked")
    public T remove(){
	T ans = data[0];
	T[] temp = (T[])new Comparable[data.length];
	temp[0] = data[size() - 1];
	for (int x = 1; x < size() - 1; x++){
	    temp[x] = data[x];
	}
	data = temp;
	size = size - 1;
	removeHelp(0);
	return ans;
    }
    private void removeHelp(int index){
	if (index < size()){
	    if (isMax){
		if (data[(2*index) + 1].compareTo(data[index]) < 0){
		    swap((2*index) + 1, index);
		    removeHelp((2*index) + 1);
		}
	    }
	    else {
		if (data[(2*index) + 1].compareTo(data[index]) > 0){
		    swap((2*index) + 1, index);
		    removeHelp((2*index) + 1);
		}
	    }
	}
    }

    public T peek(){
	return data[0];
    }

    public int size(){
	return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	T[] temp = (T[])new Comparable[data.length * 2];
	for (int x = 0; x < data.length; x++){
	    temp[x] = data[x];
	}
	data = temp;
    }

    private  void swap(int index1, int index2){
	T tracker = data[index1];
	data[index1] = data[index2];
	data[index2] = tracker;
    }

    public String toString(){
	if (size() == 0){
	    return "[]";
	}
	String ans = "[";
	for (int x = 0; x < size() - 1; x++){
	    ans = ans + data[x] + ", ";
	}
	ans = ans + data[size() - 1] + "]";
	return ans;
    }

    /*
    public static void main(String[] args){
	MyHeap<String> test = new MyHeap<String>(false);
	//System.out.println(test);
	//System.out.println(test.size());
	//System.out.println(test.data.length);
	
	test.add("A");
	test.add("B");
	test.add("C");
	
	test.add("D");
	test.add("E");
	
	test.add("F");
	test.add("G");
	test.add("H");
	test.add("I");
	test.add("J");
	test.add("K");
	test.add("L");
	test.add("M");
	test.add("N");
	test.add("O");
	
	test.add("B");
	//test.add("I");
	
	System.out.println(test);
	System.out.println(test.size());

	
	System.out.println(test.remove());
	System.out.println(test);
	
	System.out.println(test.size());
	
    }
    */
    
    
}
