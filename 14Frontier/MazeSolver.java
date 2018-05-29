public class MazeSolver {

    private Maze maze;
    private Frontier frontier;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
    }

    //Default to BFS
    public boolean solve() {
	return solve(0);
    }

    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    //2: Best-First
    public boolean solve(int mode){
	if (mode == 0){
	    frontier = new FrontierQueue();
	}
	if (mode == 1){
	    frontier = new FrontierStack();
	}
	if (mode == 2){
	    frontier = new FrontierPriorityQueue();
	}
	else {
	    frontier = new FrontierPriorityQueue();
	    maze.setAStar(true);
	}
	
	frontier.add(maze.getStart());	
	while (frontier.hasNext()){
	    Location next = frontier.next();
	    if ( !(next.equals(maze.getStart())) ){
		maze.set(next.getX(), next.getY(), '.');
	    }
	    Location[] neighbors = maze.getNeighbors(next);
	    for (int x = 0; x < neighbors.length; x++){
		if (neighbors[x] != null){
		    int xcor = neighbors[x].getX();
		    int ycor = neighbors[x].getY();
		    if (maze.get(xcor, ycor) == 'E'){
			while ( !(next.equals(maze.getStart())) ){
			    maze.set(next.getX(), next.getY(), '@');
			    next = next.getPrev();
			}
			return true;
		    }
		    frontier.add(neighbors[x]);
		    maze.set(xcor, ycor, '?');
		}
	    }
	}
	return false;
    }
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false

    public String toString(){
	return maze.toString();
    }
}
