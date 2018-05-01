import java.util.*;
public class RunningMedians{
    MyHeap<Integer> max;
    MyHeap<Integer> min;
    int median;
    public RunningMedians(){
        max=new MyHeap<>();
        min=new MyHeap<>(false);
        median=0;
    }
    public void add(int value){
        if(max.size()==0&&min.size()==0){
            max.add(value);
        }
        else if(value<median){
            max.add(value);
        }
        else{
            min.add(value);
        }
        if(max.size()==min.size()){
            median=(max.peek()+min.peek())/2;
        }
        else if(Math.abs(max.size()-min.size())==1){
            if(max.size()>min.size()){
                median=max.peek();
            }
            else{
                median=min.peek();
            }
        }
        else if(Math.abs(max.size()-min.size())==2){
            if(max.size()>min.size()){
                min.add(max.remove());
            }
            else{
                max.add(min.remove());
            }
            median=(max.peek()+min.peek())/2;            
        }
    }
    public int getMedian(){
        return median;
    }
    public static void main(String[] args){
        RunningMedians r=new RunningMedians();
        r.add(50);
        r.add(30);
        r.add(100);
        r.add(10);
        r.add(60);
        r.add(101);
        System.out.println(r.getMedian());
    }
}