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
}