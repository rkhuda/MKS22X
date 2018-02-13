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
		    ans = ans + "_ ";
		}
	    }
	    ans = ans + "\n";
	}
	return ans;
    }
    /*
    public boolean solve(){
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		return solveHelper(y);
	    }
	}
    }

    public boolean solveHelper(int col){
	if (col passes last col) {
	    return true;
	}
	for (each row) {
	    if (addQueen()){
		if (solveR(col + 1)){
		return true;
		}
	    }
	    removeQueen();   
	}
	return false;
    }
    
    public int countSolutions(){
    }
    */
    private boolean addQueen(int r, int c) {
	if (board[r][c] != 0) {
	    return false;
	}
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[r].length; y++) {
		if (x == r || y == c) {
		    board[x][y] = -1;
		}
	    }
	}
	board[r][c] = 1;
	return true;
    }
    /*
    private boolean removeQueen(int r, int c){
	if (board[r][c] != 1) {
	    return false;
	}
    }
    */
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(5);
	
	//System.out.println(test.toString());
	
	//test.addQueen(0, 0);	
	//System.out.println(test.toString());
	
	//test.addQueen(2, 1);
	//System.out.println(test.toString());
	
    }
}
