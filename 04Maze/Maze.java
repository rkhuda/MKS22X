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
	return solve(???, ???);
    }

    private int solve(int row, int col) {
	if (animate) {
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}
	return -1;
    }
    
    public static void main(String[] args) {
	
	Maze f;
	f = new Maze("data1.dat");

	f.setAnimate(true);
	f.solve();

	System.out.println(f);
	
    }
}
