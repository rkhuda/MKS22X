import java.util.*;
import java.io.*;

public class Maze {
    
    private char[][] maze;
    private boolean animate;
    private int[][] moveCoordinate = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

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
	maze = new char[linesCT][line.length()];

	while (inf.hasNextLine()){
	    line = inf.nextLine();
	    for (int x = 0; x < maze.length; x++) {
		int index = 0;
		for (int y = 0; y < maze[x].length; y++) {
		    maze[x][y] = line.charAt(index);
		    index = index + 1;
		}
	    }
	}

	int numS = 0;
	int numE = 0;
	for (int x = 0; x < maze.length; x++) {
	    for (int y = 0; y < maze[x].length; y++) {
		if (maze[x][y] == 'S') {
		    numS = numS + 1;
		}
		if (maze[x][y] == 'E') {
		    numE = numE + 1;
		}
	    }
	}

	if (numS != 1 || numE != 1) {
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
	
	if (maze[row][col] == 'E') {
	    return 1;
	}

	int CT = 0;
	for (int x = 0; x < moveCoordinate.length; x++) {
	    if (maze[row][col] == ' ') {
		    maze[row][col] = '@';
		    CT = CT + solve(row + moveCoordinate[x][1],
			  col + moveCoordinate[x][0]);
		    
	    }
	    if (maze[row - moveCoordinate[x][1]][col - moveCoordinate[x][0]] ==
		'@') {
		maze[row][col] = '.';
		solve(row - moveCoordinate[x][1], col - moveCoordinate[x][0]);
	    }
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
    
    public static void main(String[] args) throws FileNotFoundException {
	
	Maze f;
	f = new Maze("data.txt");

	f.setAnimate(true);
	f.solve();

	System.out.println(f);
	
    }
}
