public class Location implements Comparable<Location>{

    private int x,y;
    private Location previous;
    private double distance;
    private double distanceSoFar;

    public Location(int _x, int _y, Location prev, double d1, double d2) {
	x = _x;
	y = _y;
	previous = prev;
	distance = d1;
	distanceSoFar = d2;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public Location getPrev(){
	return previous;
    }

    public double getDist(){
	return distance;
    }

    public double getDistanceSoFar(){
	return distanceSoFar;
    }

    public int compareTo(Location n){
	if (this.getDist() > n.getDist()){
	    return 1;
	}
	else if (this.getDist() == n.getDist()){
	    return 0;
	}
	else if (this.getDist() < n.getDist()){
	    return -1;
	}
	return -2; //so it compiles
    }
}
