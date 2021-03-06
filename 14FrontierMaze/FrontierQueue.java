import java.util.*;
public class FrontierQueue implements Frontier{
	private ArrayDeque<Location> front;
	public FrontierQueue(){
		front=new ArrayDeque<>();
	}
	public String toString(){
		return front.toString();
	}
	public void add(Location n){
		front.addLast(n);
	}
	public Location next(){
		return front.removeFirst();
	}
	public boolean hasNext(){
		try{
			return front.getFirst()!=(null);
		}catch (NoSuchElementException e){
			return false;
		}
	}
	public static void main(String[] args){
		FrontierQueue F=new FrontierQueue();
		Location l=new Location(1,3,null);
		Location i=new Location(5,3,null);
		Location j=new Location(2,3,null);
		F.add(l);
		F.add(i);
		F.add(j);
		System.out.println(F.next());
		System.out.println(F.next());
		System.out.println(F.next());
		System.out.println(F.hasNext());
	}
}
