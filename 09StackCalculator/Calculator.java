import java.util.*;

public class Calculator {

    public static double eval(String s){
	LinkedList<String> stack = new LinkedList<>();
	String[] expression = s.split(" ");
	double first = 0;
	double second = 0;
	double ans = 0;
	for (int x = 0; x < expression.length; x++){
	    if (expression[x].equals("+")){
		second = Double.parseDouble(stack.pop());
		first = Double.parseDouble(stack.pop());
		ans = first + second;
		stack.push(ans + "");
	    }
	    else if (expression[x].equals("-")){
		second = Double.parseDouble(stack.pop());
		first = Double.parseDouble(stack.pop());
		ans = first - second;
		stack.push(ans + "");
	    }
	    else if (expression[x].equals("*")){
		second = Double.parseDouble(stack.pop());
		first = Double.parseDouble(stack.pop());
		ans = first * second;
		stack.push(ans + "");
	    }
	    else if (expression[x].equals("/")){
		second = Double.parseDouble(stack.pop());
		first = Double.parseDouble(stack.pop());
		ans = first / second;
		stack.push(ans + "");
	    }
	    else if (expression[x].equals("%")){
		second = Double.parseDouble(stack.pop());
		first = Double.parseDouble(stack.pop());
		ans = first % second;
		stack.push(ans + "");
	    }
	    else {
		stack.push(expression[x]);
	    }
	}
	return ans;
    }

    /*
    public static void main(String[] args){
        System.out.println(eval("10 2.0 +"));
	System.out.println(eval("11 3 - 4 + 2.5 *"));
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
    */
    
}
