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
        Location l=new Location(3,2,null,1);
        Location f=new Location(1,1,null,4);
        FrontierPriorityQueue q=new FrontierPriorityQueue();
        q.add(l);
        q.add(f);
        System.out.println(q);
    }
}