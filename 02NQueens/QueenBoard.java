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
	if (col > board[0].length) {
	    return true;
	}
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		if (addQueen(x, y)){
		    if (solveHelper(col + 1)) {
			return true;
		    }
		}
		//removeQueen(x, y);
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
	board[r][c] = 0;
	return true;
    }
    
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(5);
	
	//System.out.println(a.toString());
	
	//a.addQueen(0, 0);	
	//System.out.println(a.toString());
	a.solve();
	System.out.println(a.toString());
	
	//a.addQueen(2, 1);
	//System.out.println(a.toString());

	//a.removeQueen(0, 0);
	//System.out.println(a.toString());
	
    }
}
