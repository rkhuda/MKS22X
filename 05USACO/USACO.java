import java.util.*;
import java.io.*;

public class USACO {

    public static int bronze(String filename) throws FileNotFoundException{

	File text = new File(filename);
	Scanner inf = new Scanner(text);

	int row = inf.nextInt();
	int col = inf.nextInt();
	int finalElevation = inf.nextInt();
	int moves = inf.nextInt();

	int[][] lake = new int[row][col];
	for (int x = 0; x < row; x++) {
	    for (int y = 0; y < col; y++) {
		lake[x][y] = inf.nextInt();
	    }
	}
	
	/*
	int[][] instructions = new int[moves][3];
	for (int x = 0; x < moves; x++) {
	    for (int y = 0; y < 3; y++) {
		instructions[x][y] = inf.nextInt();
	    }
	}
	*/

	int[] instructions = new int[3];
	int CT = 0;
	while (CT < moves) {

	    int max = 0;
	    int tracker = 0;
	    
	    for (int x = 0; x < 3; x++) {
		instructions[x] = inf.nextInt();
		//System.out.println(instructions[x]);
	    }

	    for (int x = instructions[0] - 1; x < instructions[0] + 2; x++){
		for (int y = instructions[1] - 1; y < instructions[1] + 2; y++) {
		    if (lake[x][y] > max) {
			max = lake[x][y];
			//System.out.println(max);
		    }
		}
	    }

	    for (int x = instructions[0] - 1; x < instructions[0] + 2; x++){
		for (int y = instructions[1] - 1; y < instructions[1] + 2; y++) {
		    if (lake[x][y] == max) {
			lake[x][y] = lake[x][y] - instructions[2];
			tracker = lake[x][y];
		    }
		}
	    }

	    for (int x = instructions[0] - 1; x < instructions[0] + 2; x++){
		for (int y = instructions[1] - 1; y < instructions[1] + 2; y++) {
		    if (lake[x][y] > tracker) {
			lake[x][y] = tracker;
		    }
		}
	    }

	    CT = CT + 1;
	}

	int depth = 0;
	for (int x = 0; x < row; x++) {
	    for (int y = 0; y < col; y++) {
		if (finalElevation - lake[x][y] > 0) {
		    depth = depth + (finalElevation - lake[x][y]);
		}
	    }
	}
	
	return depth*72*72;
	
    }

    //public static int silver(String filename) {}

    public static void main(String[] args) throws FileNotFoundException{
	System.out.println(bronze("lake.txt"));
    }
}
