import java.util.*;

public class MyDeque<T>{
    private T[] data;
    private int length,start,end;
    @SuppressWarnings("unchecked")
    public MyDeque(){
        length=0;
        data=(T[])new Object[10];
        start=0;
        end=0;
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        if(initialCapacity<0){
            throw new IllegalArgumentException();
        }
        length=0;
        data=(T[])new Object[initialCapacity];
        start=0;
        end=0;
        
    }
    public String toString(){
        String str="[";
        int num=0;
        for(int i=start;num<size();){
            if(data[i]!=null){
                num++;
                if(!str.equals("[")){
                    str+=", ";
                }
                str+=data[i];
            }
            
            if(i>=data.length-1){
                i=0;
            }
            else{
                i++;
            }
        }
        return str+"]";
    }
    public int size(){
        return length;
    }
    public void addFirst(T v){
        if(size()==data.length){
            resize();
        }
        if(v==null){
            throw new NullPointerException();
        }
        if(data[start]==null){
            data[start]=v;
        }
        else if(start-1<0){
            int ind=data.length+(start-1);
            if(data[ind]==null){
                data[ind]=v;
                start=ind;
            }
        }
        else{
            if(data[(start-1)]==null){
                data[start-1]=v;
                start=start-1;
            }
        }
        length++;
    }
    public void addLast(T v){
        if(size()==data.length){
            resize();
        }
        if(v==null){
            throw new NullPointerException();
        }
        if(data[end]==null){
            data[end]=v;
        }
        else if(end+1>=data.length){
            int ind=(end+1)%data.length;
            if(data[ind]==null){
                data[ind]=v;
                end=ind;
            }
        }
        else{
            if(data[(end+1)]==null){
                data[end+1]=v;
                end=end+1;
            }
        }
        length++;
    }
    public T removeFirst(){
        if(size()==0){
            throw new NoSuchElementException();
        }
        T removed=null;
        removed=data[start];
        data[start]=null;
        if(start+1>=data.length){
            start=0;
        }
        else if(start-1==end){
            start=end;
        }
        else{
            start+=1;
        }
        length--;
        return removed;    
    }
    public T removeLast(){
        if(size()==0){
            throw new NoSuchElementException();
        }
        T removed=null;
        removed=data[end];
        data[end]=null;
        if(end-1<0){
            end=data.length-1;
        }
        else{
            end-=1;
        }
        length--;
        return removed;
    }
    public T getFirst(){
        if(size()==0){
            throw new NoSuchElementException();
        }
        System.out.println(Arrays.toString(data));
        System.out.println(start+" "+end);
        return data[start];  
    }
    public T getLast(){
        if(size()==0){
            throw new NoSuchElementException();
        }
        return data[end];   
    }
    @SuppressWarnings("unchecked")
    public void resize(){
        T[] newData=(T[])new Object[data.length*2];
        int num=0;
        for(int i=start,j=data.length+start;num<size();){
            newData[j]=data[i];
            num++;
            if(i==start){
                start=j;
            }
            if(i==end){
                end=j;
            }
            if(i>=data.length-1){
                i=0;
                j=0;
            }
            else{
                j++;
                i++;
            }
        }
        data=newData; 
    }
    public static void main(String[] args){
        MyDeque<Integer> D=new MyDeque<>();
        D.addLast(3);
        D.addLast(24);
	//System.out.println(D.removeFirst());
	//System.out.println(D.removeLast());
	//System.out.println(D.getLast());

    System.out.println(D.removeFirst());
    System.out.println(D.getFirst());
        System.out.println(D);        
    }
    
}
