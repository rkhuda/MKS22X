import java.util.*;
import java.io.*;

public class Maze {
    
    private char[][] maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException {

	animate = false;

	File text = new File(filename);
	Scanner inf = new Scanner(text);

	int linesCT = 0;
	String line = "";
	while(inf.hasNextLine()){
	    linesCT = linesCT + 1;
	    line = inf.nextLine();
	}
	maze = new char[linesCT][line.length];

	int x = 0;
	while (inf.hasNextLine() && x < maze.length) {
	    line = inf.nextLine();
	    char[] charArray = line.toCharArray();
	    maze[x] = charArray;
	    x++;
	}

	int numS = 0;
	int numE = 0;
	for (int x = 0; x < maze.length; x++) {
	    for (int y = 0; y < maze[x].length; x++) {
		if (maze[x][y] == 'S') {
		    numS = numS + 1;
		}
		else if (maze[x][y] = 'E') {
		    numE = numE + 1;
		}
	    }
	}

	if (numS > 1 || numS < 1 || numsE > 1 || nums E < 1) {
	    throw new IllegalStateException();
	}
	
    }

    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void setAnimate(boolean b) {
	animate = b;
    }

    public void clearTerminal() {
	System.out.println("\033[2J\033[1;1H");
    }

    public int solve(){
	int row = 0;
	int col = 0;
	for (int x = 0; x < maze.length; x++) {
	    for (int y = 0; y < maze[x].length; y++) {
		if (maze[x][y] == 'S') {
		    row = x;
		    col = y;
		    maze[x][y] = '@';
		}
	    }
	}
	return solve(row, col);
    }

    private int solve(int row, int col) {
	if (animate) {
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}
	
	return -1;
    }

    public String toString() {
	String ans = "";
	for (int x = 0; x < maze.length; x++) {
	    for (int y = 0; y < maze[x].length; y++) {
		ans = ans + maze[x][y];
	    }
	    ans = ans + "\n";
	}
	return ans;
    }
    
    public static void main(String[] args) {
	
	Maze f;
	f = new Maze("data1.dat");

	f.setAnimate(true);
	f.solve();

	System.out.println(f);
	
    }
}
