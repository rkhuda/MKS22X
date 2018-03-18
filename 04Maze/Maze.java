import java.util.*;
import java.io.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    
    private char[][] maze;
    private boolean animate;
    private int[][] moveCoordinate = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

    public Maze(String filename) {

	animate = false;

	try{
	    File text = new File(filename);
	    Scanner inf = new Scanner(text);

	    int row = 0;
	    int col = 0;
	    String all = "";
	    
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		row = row + 1;
		col = line.length();
		all = all + line;
	    }
	    
	    maze = new char[row][col];

	    int CT = 0;
	    int numS = 0;
	    int numE = 0;
	    for (int x = 0; x < maze.length; x++) {
		for (int y = 0; y < maze[x].length; y++) {

		    maze[x][y] = all.charAt(CT);

		    if (maze[x][y] == 'S') {
			numS = numS + 1;
		    }
		    if (maze[x][y] == 'E') {
			numE = numE + 1;
		    }

		    CT = CT + 1;
		}
	    }

	    if (numS != 1 || numE != 1) {
		throw new IllegalStateException();
	    }
	    
	}
	catch (FileNotFoundException e) {
	    System.out.println("File not found");
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
		    maze[x][y] = ' ';
		}
	    }
	}
	return solve(row, col, 0);
    }
    
    private int solve(int row, int col, int CT) {
	if (animate) {
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}

	if (maze[row][col] == 'E') {
	    return CT;
	}
	
	for (int x = 0; x < moveCoordinate.length; x++) {

	    int xcor = row + moveCoordinate[x][1];
	    int ycor = col + moveCoordinate[x][0];

	    maze[row][col] = '@';

	    if (maze[xcor][ycor] == ' ' || maze[xcor][ycor] == 'E'){
		int ans = solve(xcor, ycor, CT + 1);
		if (ans != -1){
		    return ans;
		}
	    }
	    
	    maze[row][col] = '.';
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
    
    /*
    public static void main(String[] args) {
	
	Maze f;
	f = new Maze("data1.dat");
	f.setAnimate(true);
	System.out.println(f.solve());
	System.out.println(f);
    }
    */
}
