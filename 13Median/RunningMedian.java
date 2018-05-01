import java.util.*;
public class RunningMedian{
    MyHeap<Integer> max;
    MyHeap<Integer> min;
    int median;
    int length;
    public RunningMedian(){
        max=new MyHeap<>();
        min=new MyHeap<>(false);
        median=0;
	length=0;
    }
    public int size(){
	return length;
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
	length++;
    }
    public int getMedian(){
        return median;
    }
    public static void main(String[] args){
        RunningMedian r=new RunningMedian();
	Random rand=new Random();
        Integer[] d=new Integer[51];
        for(int i=0;i<51;i++){
            int val=rand.nextInt();
            d[i]=val;
	    r.add(val);
        }
        Arrays.sort(d);
	System.out.println(d[25]);
        System.out.println(r.getMedian());
    }
}
