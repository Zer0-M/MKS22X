import java.util.Arrays;

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
        if(data[start]==null){
            data[start]=v;
        }
        else if(start-1<0){
            int ind=data.length+(start-1);
            System.out.println(ind);
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
            System.out.println(start);
        }
        length++;
    }
    public void addLast(T v){
        if(data[end]==null){
            data[end]=v;
        }
        if(end+1>data.length){
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
        T removed=null;
        removed=data[start];
        data[start]=null;
        if(start+1>=data.length){
            start=0;
        }
        else{
            start+=1;
        }
        length--;
        return removed;    
    }
    public T removeLast(){
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
      return data[start];  
    }
    public T getLast(){
     return data[end];   
    }
    public static void main(String[] args){
        MyDeque<Integer> D=new MyDeque<>();
        D.addFirst(9);
        D.addFirst(2);
        D.addLast(3);
        D.addFirst(56363);
        D.addLast(24);
        System.out.println(D);
        System.out.println(D.removeFirst());
        System.out.println(D.getFirst());
        System.out.println(D);
        System.out.println(D.removeLast());
        System.out.println(D.getLast());
        System.out.println(D);
    }
    
}
