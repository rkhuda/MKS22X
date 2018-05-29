import java.util.*;

public class FrontierStack implements Frontier{

    private Stack<Location> stack;

    public FrontierStack() {
	stack = new Stack<Location>();
    }

    public Location next(){
	return stack.pop();
    }

    public void add(Location n){
	stack.push(n);
    }

    public boolean hasNext(){
	return stack.peek() != null;
    }
}
