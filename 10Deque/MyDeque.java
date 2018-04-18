public class MyDeque<T>{
    private T[] data;
    private int length,start,end;
    public MyDeque(){
	length=10;
	@SuppressWarnings("unchecked")
	data=new T[length];
	start=0;
	end=length-1;
    }
    public MyDeque(int initialCapacity){
	length=initialCapacity;
	@SuppressWarnings("unchecked")
	data=new T[length];
	start=0;
	end=length-1;

    }
    public String toString(){
	String str="";
	for(int i=start;i<=end;i++){
	    str+=data[i];
	}
	return str;
    }
    public int size(){
	return length;
    }
    public void addFirst(T E){
	if(start-1<0){
	    
	}
    }
    public void addLast(T E){

    }
    /*public T removeFirst(){
	
    }
    public T removeLast(){
	
    }
    public T getFirst(){
	
    }
    public T getLast(){
	
    }*/
    public static void main(String[] args){
	MyDeque<Integer> D=new MyDeque<>();
	System.out.println(D);
    }

}
