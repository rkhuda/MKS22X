public class Recursion {

    public int fact(int n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n == 0) {
	    return 1;
	}
	return fact(n-1)*n;
    }

    public int fib(int n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n == 0) {
	    return 0;
	}
	if (n == 1) {
	    return 1;
	}
	return fibHelp(1, 1, 0, n);
    }

    public int fibHelp(int n, int sum, int sumBefore, int index) {
	if (n == index) {
	    return sum;
	}
	return fibHelp(n + 1, sum + sumBefore, sum, index);
    }
	

    public static double sqrt(double n){
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n == 0) {
	    return 0;
	}
	return sqrtHelp(n, n/2);
    }

    public static double sqrtHelp(double n, double guess) {
	if (Math.abs(((guess*guess) - n)) < 0.000001) {
	    return guess;
	}
	return sqrtHelp(n, (n / guess + guess) / 2);
    }
    /*
    public static void main(String[] args) {
	
	System.out.println(fact(-2));
	System.out.println(fact(0));
	System.out.println(fact(1));
	System.out.println(fact(2));
	System.out.println(fact(3));
	System.out.println(fact(5));
	
	System.out.println(fib(-1));
	System.out.println(fib(0));
	System.out.println(fib(1));
	System.out.println(fib(2));
	System.out.println(fib(3));
	System.out.println(fib(4));
	System.out.println(fib(5));
	System.out.println(fib(6));
	System.out.println(fib(7));
	System.out.println(fib(8));
	System.out.println(fib(9));
	
	System.out.println(sqrt(-3));
	System.out.println(sqrt(4));
	System.out.println(sqrt(10));
	System.out.println(sqrt(100));
	
    }
    */
}
