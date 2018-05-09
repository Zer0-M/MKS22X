import java.util.*;
public class Location implements Comparable<Location>{
    private int x,y,dist;
    private Location previous;

    public Location(int _x, int _y, Location prev){
	x=_x;
	y=_y;
        previous=prev;
    }
    public Location(int _x, int _y, Location prev,int distance){
	x=_x;
	y=_y;
        previous=prev;
    }
    public String toString(){
	return "["+x+","+y+"]";
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
    public Integer getDistance(){
	return dist;
    }
    public int compareTo(Location other){
        return getDistance().compareTo(other.getDistance());
    }
    public static void main(String[] args){
        Location l=new Location(1,5,null);
        Location f=new Location(5,2,null);
    }
}
