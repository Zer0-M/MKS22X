import java.util.*;
public class FrontierStack implements Frontier{
	private ArrayDeque<Location> front;
	public FrontierStack(){
		front=new ArrayDeque<>();
	}
	public void add(Location n){
		front.addLast(n);
	}
	public Location next(){
		return front.removeLast();
	}
	public boolean hasNext(){
		try{
			return !(front.removeLast().equals(null));
		}catch (NoSuchElementException e){
			return false;
		}
	}
	public static void main(String[] args){
		FrontierStack F=new FrontierStack();
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