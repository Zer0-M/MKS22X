import java.util.*;
public class Sorts{
    public static void heapSort(Integer[] dat){
	MyHeap<Integer> h=new MyHeap<>();
	int end=dat.length-1;
	h.Heapify(dat); 
	for(;end>=0;end--){
	    int r=h.remove(end);
	    dat[end]=r;
	}

    }
    public static void main(String[] args){
        MyHeap<Integer> h=new MyHeap<>(false);
        Random rand=new Random();
        Integer[] d=new Integer[1000000];
	Integer[] e=new Integer[1000000];
        for(int i=0;i<1000000;i++){
            int val=rand.nextInt();
	    d[i]=val;
	    e[i]=val;
	    
        }
        long start,end;
	Arrays.sort(e);
        start=System.currentTimeMillis();
        Sorts.heapSort(d);
        end=System.currentTimeMillis();
	System.out.println(Arrays.equals(d,e));
        System.out.println(end-start);
    }
}
