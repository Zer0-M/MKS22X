import java.util.*;

public class MyHeap<T extends Comparable<T>>{
    T[] data;
    int length;
    boolean isMax;
    @SuppressWarnings("unchecked")
    public MyHeap(){
        data=(T[])new Comparable[15];
        isMax=true;
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean max){
        data=(T[])new Comparable[15];
        isMax=max;
    }
    public String toString(){
        return Arrays.toString(data);
    }
    private void swap(T[] arr,int i,int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int size(){
        return length;
    }
    public void add(T s){
        if(length==data.length){
            resize();
        }
        data[length]=s;
        int j=length;
        if(length>0){
            if(isMax){
                for(int i=(length-1)/2;s.compareTo(data[i])>0;i=(i-1)/2){
                    //System.out.println(i+" "+s.compareTo(data[i]));
                    //System.out.println(s+" "+data[i]);
                    swap(data,i,j);
                    j=i;
                }
            }
            else{
                for(int i=(length-1)/2;s.compareTo(data[i])<0;i=(i-1)/2){
                    //System.out.println(i+" "+s.compareTo(data[i]));
                    //System.out.println(s+" "+data[i]);
                    swap(data,i,j);
                    j=i;
                }
            }
        }
        length++;
        
    }
    public T remove(){
        T removed=data[0];
        swap(data,0,size()-1);
        data[size()-1]=null;
        length--;
        int j=0;
        T s=data[j];
        if(length>0){
            if(isMax){
                for(int i=2*j+1;i<data.length&&data[i]!=null&&data[i+1]!=null&&(s.compareTo(data[i])<0||s.compareTo(data[i+1])<0);i=2*j+1){
                    //System.out.println(i+" "+s.compareTo(data[i]));
                    //System.out.println(s+" "+data[i]);
                    if((data[i+1]).compareTo(data[i])>0){
                        swap(data,i+1,j);
                        j=i+1;
                    }
                    else{
                        swap(data,i,j);
                        j=i;
                    }
                    
                }
            }
            else{
                for(int i=2*j+1;i<data.length&&data[i]!=null&&data[i+1]!=null&&(s.compareTo(data[i])>0||s.compareTo(data[i+1])>0);i=2*j+1){
                    //System.out.println(i+" "+s.compareTo(data[i]));
                    //System.out.println(s+" "+data[i]);
                    if((data[i+1]).compareTo(data[i])<0){
                        swap(data,i+1,j);
                        j=i+1;
                    }
                    else{
                        swap(data,i,j);
                        j=i;
                    }
                    
                }
            }
        }
        return removed;
        
    }
    public T peek(){
        return data[0];
    }
    @SuppressWarnings("unchecked")
    private void resize(){
        T[] resized=(T[])new Comparable[2*data.length+1];
        for(int i=0;i<data.length;i++){
            resized[i]=data[i];
        }
        data=resized;
    }
    public void Heapify(T[] dat){
        if(isMax){
            for(int ind=dat.length-1;ind>=0;ind--){
                T s=dat[ind];
                int j=ind;
                //System.out.println(s);
                System.out.println(ind+" "+s);
                
                for(int i=2*j+1;i<dat.length&&dat[i]!=null&&dat[i+1]!=null&&(s.compareTo(dat[i])<0||s.compareTo(dat[i+1])<0);i=2*j+1){
                    //System.out.println(i+" "+s.compareTo(dat[i]));
                    System.out.println(s+" "+dat[i]);
                    if((dat[i+1]).compareTo(dat[i])>0){
                        swap(dat,i+1,j);
                        j=i+1;
                    }
                    else{
                        swap(dat,i,j);
                        j=i;
                    }
                    
                }
            }
        }
        else{
            for(int ind=dat.length-1;ind>=0;ind--){
                T s=dat[ind];
                int j=ind;
                //System.out.println(s);
                
                for(int i=2*j+1;i<dat.length&&dat[i]!=null&&dat[i+1]!=null&&(s.compareTo(dat[i])>0||s.compareTo(dat[i+1])>0);i=2*j+1){
                    //System.out.println(i+" "+s.compareTo(dat[i]));
                    System.out.println(s+" "+dat[i+1]);
                    System.out.println((dat[i+1]).compareTo(dat[i]));
                    if((dat[i+1]).compareTo(dat[i])<0){
                        swap(dat,i+1,j);
                        j=i+1;
                    }
                    else{
                        swap(dat,i,j);
                        j=i;
                    }
                }
            }  
        }
    }
    
    public static void main(String[] args){
        MyHeap<Integer> h=new MyHeap<>(false);
        Random rand=new Random();
        Integer[] d={31,415,5,6,72314,15,6,115,725,85,64,0,12,10,7};
        Integer z=new Integer(72314);
        Integer x=new Integer(415);
        System.out.println(x.compareTo(z));
        System.out.println(Arrays.toString(d));
        h.Heapify(d);
        System.out.println(Arrays.toString(d));
        System.out.println(h);
    }
}