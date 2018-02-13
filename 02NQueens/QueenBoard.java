public class QueenBoard {

    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		board[x][y] = 0;
	    }
	}
    }

    public String toString() {
	String ans = "";
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		if (board[x][y] == 1) {
		    ans = ans + "Q ";
		}
		if (board[x][y] != 1) {
		    ans = ans +  "_ ";
		    //ans = ans + board[x][y] + " ";
		}
	    }
	    ans = ans + "\n";
	}
	return ans;
    }
    
    public boolean solve(){
	if (board[0][0] != 0) {
	    throw new IllegalStateException();
	}
	return solveHelper(0);
    }
    
    public boolean solveHelper(int col){
	if (col > board[0].length - 1) {
	    return true;
	}
	for (int x = 0; x < board.length; x++) {
		if (addQueen(x, col)){
		    if (solveHelper(col + 1)) {
			return true;
		    }
		    removeQueen(x, col);
		}
	}
	return false;
    }
    /*
    public int countSolutions(){
	if (board[0][0] != 0) {
	    throw new IllegalStateException();
	}
    }
    */
    private boolean addQueen(int r, int c) {
	if (board[r][c] != 0) {
	    return false;
	}
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[r].length; y++) {
		if (x == r || y == c || x+y == r+c || x-y == r-c) {
		    board[x][y] = -1;
		}
	    }
	}
	board[r][c] = 1;
	return true;
    }
    
    private boolean removeQueen(int r, int c){
	if (board[r][c] != 1) {
	    return false;
	}
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[r].length; y++) {
		if (x == r || y == c || x+y == r+c || x-y == r-c) {
		    board[x][y] = 0;
		}
	    }
	}
	board[r][c] = 0;
	return true;
    }
    
    public static void main(String[] args){
	QueenBoard b = new QueenBoard(4);

	System.out.println(b.solve()); //prints true
	System.out.println(b); //prints a valid solution
	/*
	try{
	    b.solve();
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    b.countSolutions();
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	for (int i = 0; i < 12; i++){
	    QueenBoard a = new QueenBoard(i);
	    System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
	}
	*/
    }
	
}
