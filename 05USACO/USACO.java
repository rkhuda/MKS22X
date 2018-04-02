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

	int[] instructions = new int[3];
	int CT = 0;
	while (CT < moves) {

	    int max = 0;
	    int tracker = 0;
	    
	    for (int x = 0; x < 3; x++) {
		instructions[x] = inf.nextInt();
	    }

	    for (int x = instructions[0] - 1; x < instructions[0] + 2; x++){
		for (int y = instructions[1] - 1; y < instructions[1] + 2; y++) {
		    if (lake[x][y] > max) {
			max = lake[x][y];
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

    public static int silver(String filename) throws FileNotFoundException{

	File text = new File(filename);
	Scanner inf = new Scanner(text);

	int row = inf.nextInt();
	int col = inf.nextInt();
	int steps = inf.nextInt();
	
	inf.nextLine();
	
	char[][] map = new char[row][col];	
	for (int x = 0; x < row; x++) {
	    String line = inf.nextLine();
	    for (int y = 0; y < col; y++){
		map[x][y] = line.charAt(y);
	    }
	}

	int startRow = inf.nextInt();
	int startCol = inf.nextInt();
	int endRow = inf.nextInt();
	int endCol = inf.nextInt();

	int[][] allPath = new int[row][col];
	allPath[startRow - 1][startCol - 1] = 1;
	
	int CT = 0;
	while (CT < steps){
	    int[][] currentPath = new int[row][col];
	    for (int x = 0; x < row; x++){
		for (int y = 0; y < col; y++){
		    if (map[x][y] != '*'){
			if ((x+1) < row){
			    currentPath[x][y] = currentPath[x][y] + allPath[x+1][y];
			}
			if ((x-1) >= 0){
			    currentPath[x][y] = currentPath[x][y] + allPath[x-1][y];
			}
			if ((y+1) < col){
			    currentPath[x][y] = currentPath[x][y] + allPath[x][y+1];
			}
			if ((y-1) >= 0){
			    currentPath[x][y] = currentPath[x][y] + allPath[x][y-1];
			}
		    }
		}
	    }
	    for (int x = 0; x < row; x++){
		for (int y = 0; y < col; y++){
		    allPath[x][y] = currentPath[x][y];
		}
	    }
	    
	    CT = CT + 1;
	}

	return allPath[endRow - 1][endCol - 1];
    }
}
