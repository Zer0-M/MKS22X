public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;

    public Location(int _x, int _y, Location prev){
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
    public int compareTo(Location other){
        int x_dist=other.getX()-getX();
        int y_dist=other.getY()-getY();
        int total=Math.abs(x_dist)+Math.abs(y_dist);//Math.sqrt(Math.pow(x_dist,2)+Math.pow(y_dist,2));
        return total;
    }
    public static void main(String[] args){
        Location l=new Location(1,5,null);
        Location f=new Location(5,2,null);
        System.out.println(f.compareTo(l));
    }
}
