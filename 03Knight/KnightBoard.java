public class KnightBoard {

    private int[][] board;

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

	if (startingRow < 0 || startingCols < 0) {
	    throw new IllegalArgumentException();
	}
	if (startingRow > board.length || startingCols > board[0].length) {
	    throw new IllegalArgumentException();
	}
	for (int x = 0; x < board.length; x++){
	    for (int y = 0; y < board[x].length; y++) {
		if (board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}

	//return solveHelper(0, 0, 0);
    }
    public solveHelper(int row, int col, int level){
	//return solveHelper();
    }

    public int countSolutions(int startingRow, int startingCol) {

	if (startingRows < 0 || startingCols < 0) {
	    throw new IllegalArgumentException();
	}

	if (startingRow > board.length || startingCols > board[0].length) {
	    throw new IllegalArgumentException();
	}
	
	for (int x = 0; x < board.length; x++){
	    for (int y = 0; y < board[x].length; y++) {
		if (board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}

	return countSolutions(0, 0);
    }

    public String toString(){

	String ans = "";
	
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		if (board[x][y] == 0) {
		    ans = ans + "_ "
		}
		if (board[x][y] < 10) {
		    ans = ans + " " + board[x][y] + " ";
		}
		else {
		    ans = ans + board[x][y] + " ";
		}
	    }
	    ans = ans + "\n";
	}
    }
}
