public class FrontierPriorityQueue implements Frontier{

    private MyHeap<Location> data;

    public FrontierPriorityQueue(){
	data = new MyHeap<Location>(false);
    }

    public Location next(){
	return data.remove();
    }

    public void add(Location n){
	data.add(n);
    }

    public boolean hasNext(){
	return data.peek() != null;
    }
}
