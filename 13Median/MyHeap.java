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
        String heap="[";
        for(int i=0;i<length;i++){
            if(data[i]!=null){
                if(i==length-1){
                    heap+=data[i];
                }
                else{
                    heap+=data[i]+", ";
                }
            }
        }
        return heap+"]";
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
        pushDown(data, 0);
        return removed;   
    }
    public T remove(int limit){
        T removed=data[0];
        swap(data,0,size()-1);
        data[size()-1]=null;
        length--;
        pushDown(data, 0,limit);
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
    private void pushDown(T[] dat,int index,int limit){
        if(isMax){
            T s=dat[index];
            int j=index;
            int i=2*j+1;
            for(;i<limit&&dat[i]!=null&&data[i+1]!=null&&(s.compareTo(dat[i])<0||s.compareTo(dat[i+1])<0);i=2*j+1){
                if((dat[i+1]).compareTo(dat[i])>0){
                    swap(dat,i+1,j);
                    j=i+1;
                }
                else{
                    swap(dat,i,j);
                    j=i;
                }
                
            }
            if(i+1<dat.length&&dat[i+1]==null&&s.compareTo(dat[i])<0){
                swap(dat,i,j);
            }
    }
    else{
            T s=dat[index];
            int j=index;
            
            for(int i=2*j+1;i<dat.length&&dat[i]!=null&&dat[i+1]!=null&&(s.compareTo(dat[i])>0||s.compareTo(dat[i+1])>0);i=2*j+1){
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
    private void pushDown(T[] dat,int index){
        if(isMax){
                T s=dat[index];
                int j=index;
                int i=2*j+1;
                for(;i<dat.length&&i+1<dat.length&&dat[i]!=null&&dat[i+1]!=null&&(s.compareTo(dat[i])<0||s.compareTo(dat[i+1])<0);i=2*j+1){
                    if((dat[i+1]).compareTo(dat[i])>0){
                        swap(dat,i+1,j);
                        j=i+1;
                    }
                    else{
                        swap(dat,i,j);
                        j=i;
                    }

                    
                }
                if(i+1<dat.length&&dat[i]!=null&&dat[i+1]==null&&s.compareTo(dat[i])<0){
                    swap(dat,i,j);
                }
        }
        else{
                T s=dat[index];
                int j=index;
                int i=2*j+1;
                for(;i<dat.length&&i+1<dat.length&&dat[i]!=null&&dat[i+1]!=null&&(s.compareTo(dat[i])>0||s.compareTo(dat[i+1])>0);i=2*j+1){
                    if((dat[i+1]).compareTo(dat[i])<0){
                        swap(dat,i+1,j);
                        j=i+1;
                    }
                    else{
                        swap(dat,i,j);
                        j=i;
                    }
                }
                if(i+1<dat.length&&dat[i]!=null&&dat[i+1]==null&&s.compareTo(dat[i])>0){
                    swap(dat,i,j);
                } 
        }
    }
    public void Heapify(T[] dat){
            for(int ind=dat.length-1;ind>=0;ind--){
               pushDown(dat,ind);
            }
            length=dat.length;
            data=dat;
    }    
    public static void main(String[] args){
        MyHeap<Integer> h=new MyHeap<>(false);
        Random rand=new Random();
        Integer[] d=new Integer[1000000];
        for(int i=0;i<1000000;i++){
            d[i]=rand.nextInt();
        }
        long start,end;
        start=System.currentTimeMillis();
        end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
