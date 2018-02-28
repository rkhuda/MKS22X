public class KnightBoard {

    private int[][] board;
    private int[][] moveCoordinate = { {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2} };

    public KnightBoard(int startingRows, int startingCols) {
	if (startingRows < 0 || startingCols < 0) {
	    throw new IllegalArgumentException();
	}
	board = new int[startingRows][startingCols];
	
       for (int x = 0; x < board.length; x++){
	    for (int y = 0; y < board[x].length; y++){
		board[x][y] = 0;
	    }
	}
    }

    public boolean solve(int startingRow, int startingCol){

	if (startingRow < 0 || startingCol < 0) {
	    throw new IllegalArgumentException();
	}

	if (startingRow > board.length || startingCol > board[0].length) {
	    throw new IllegalArgumentException();
	}

	for (int x = 0; x < board.length; x++){
	    for (int y = 0; y < board[x].length; y++) {
		if (board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveHelper(startingRow, startingCol, 1);
    }
    private boolean solveHelper(int row, int col, int level){

	if (board.length * board[0].length == level && board[row][col] == 0) {
	    board[row][col] = level;
	    return true;
	}

	for (int x = 0; x < moveCoordinate.length; x++) {
	    if ( (board[row][col] == 0) &&
	    (row + moveCoordinate[x][1] >= 0) && (row + moveCoordinate[x][1] < board.length) &&
	    (col + moveCoordinate[x][0] >= 0) && (col + moveCoordinate[x][0] < board[0].length) &&
	    (board[row + moveCoordinate[x][1]][col + moveCoordinate[x][0]] == 0) ) {
		board[row][col] = level;
		if (solveHelper(row + moveCoordinate[x][1], col + moveCoordinate[x][0], level + 1)) {
		    return true;
		}
		else {
		    board[row][col] = 0;
		}
	    }
	}
	return false;
    }

    public int countSolutions(int startingRow, int startingCol) {

	if (startingRow < 0 || startingCol < 0) {
	    throw new IllegalArgumentException();
	}

	if (startingRow > board.length || startingCol > board[0].length) {
	    throw new IllegalArgumentException();
	}
	
	for (int x = 0; x < board.length; x++){
	    for (int y = 0; y < board[x].length; y++) {
		if (board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}

	return countSolutionsHelper(startingRow, startingCol, 1);
    }

    private int countSolutionsHelper(int row, int col, int level) {
	if (board.length * board[0].length == level && board[row][col] == 0) {
	    return 1;
	}

	int CT = 0;
	for (int x = 0; x < moveCoordinate.length; x++) {
	    if ( (board[row][col] == 0) &&
	    (row + moveCoordinate[x][1] >= 0) && (row + moveCoordinate[x][1] < board.length) &&
	    (col + moveCoordinate[x][0] >= 0) && (col + moveCoordinate[x][0] < board[0].length) &&
	    (board[row + moveCoordinate[x][1]][col + moveCoordinate[x][0]] == 0) ) {
		board[row][col] = level;
		CT = CT + countSolutionsHelper(row + moveCoordinate[x][1], col + moveCoordinate[x][0], level + 1);
		board[row][col] = 0;
	    }
	}
	return CT;
    }

    public String toString(){

	String ans = "";
	
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		if (board[x][y] == 0) {
		    ans = ans + "_ ";
		}
		else if (board[x][y] < 10) {
		    ans = ans + " " + board[x][y] + " ";
		}
		else {
		    ans = ans + board[x][y] + " ";
		}
	    }
	    ans = ans + "\n";
	}
	return ans;
    }
}

