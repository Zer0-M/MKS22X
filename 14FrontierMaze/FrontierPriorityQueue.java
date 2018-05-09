public class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> priority;
    public FrontierPriorityQueue(){
        priority=new MyHeap<Location>(false);
    }
    public String toString(){
        return priority.toString();
    }
    public void add(Location n){
        priority.add(n);
    }
    public Location next(){
        return priority.remove();
    }
    public boolean hasNext(){
        return priority.peek()!=null;
    }
    public static void main(String[] args){
        Location a=new Location(0,0,null);
        Location b=new Location(3,4,null);
        Location c=new Location(5,6,null);
        Location d=new Location(2,1,null);
        Location e=new Location(10,0,null);
        Location f=new Location(34,20,null);
        FrontierPriorityQueue q=new FrontierPriorityQueue();
        q.add(a);
        q.add(b);
        System.out.println(q);
    }
}