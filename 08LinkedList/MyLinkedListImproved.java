import java.util.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    private Node first;
    private Node last;
    private int length;
    public MyLinkedListImproved(){
        length=0;
    }
    public void clear(){
        length=0;
    }
    public boolean add(T value){
        Node addend=new Node(value);
        if(last==null){
            last=addend;
            first=last;
        }
        else{
            last.setNext(addend);
            last.getNext().setPrev(last);
            last=last.getNext();
        }
        length++;
        //last.setNext(addend);
        
        return true;
    }
    public int size(){
        return length;
    }
    
    public String toString(){
        Node n=first;
        String s="[";
        for(int i=0;i<size();i++){
            if(n!=null){
                s+=n.getValue();
            }
            if(n.getNext()!=null){
                s+=",";
                n=n.getNext();
            }
        }
        s+="]";
        return s;
    }
    private Node getNode(int index){
        Node n=first;
        //currently assuming index exists exceptions will be added later
        if(index>size()||index<0){
            throw new IndexOutOfBoundsException();
        }
        for(int i=0;i!=index;i++){
            n=n.getNext();
        }
        return n;
    }
    public T get(int index){
        Node n=first;
        //currently assuming index exists exceptions will be added later
        if(index>=size()||index<0){
            throw new IndexOutOfBoundsException();
        };
        for(int i=0;i!=index;i++){
            n=n.getNext();
        }
        return n.getValue();
    }
    public T set(int index,T newValue){
        if(index>=size()||index<0){
            throw new IndexOutOfBoundsException();
        }
        Node n=getNode(index);
        T old=n.getValue();
        n.setValue(newValue);
        return old;
    }
    public int indexOf(T value){
        int i=0;
        for(T v:this){
            if(value.equals(v)){
                return i;
            }
            i++;
        }
        return -1;
    }
    public int max(){
	if(size()==0){
	    return -1;
	}
	T largest=first.getValue();
	int maxI=0;
	int i=0;
	for(T v:this){
	    if(largest.compareTo(v)<0){
		largest=v;
		maxI=i;
	    }
	    i++;
	}
	return maxI;
	
    }
    public int min(){
	if(size()==0){
	    return -1;
	}
	T smallest=first.getValue();
	int minI=0;
	int i=0;
	for(T v:this){
	    if(smallest.compareTo(v)>0){
		smallest=v;
		minI=i;
	    }
	    i++;
	}
	return minI;
	
    }
    public void add(int index,T value){
        Node addend=new Node(value);
        
        if(index==0){        
            if(first==null){
                first=addend;
                last=first;
            }
            else{
                first.setPrev(addend);
                first.getPrev().setNext(first);
                first=first.getPrev();
            }
            length++;
        }
        else if(index==size()){
            add(value);
        }
        else{
            if(index>size()||index<0){
                throw new IndexOutOfBoundsException();
            }
            Node n=getNode(index);
            Node n1=getNode(index-1);
            addend.setNext(n);
            addend.setPrev(n1);
            n.setPrev(addend);
            n1.setNext(addend);
            length++;
        }
    }
    public T remove(int index){
        if(index>size()||index<0){
            throw new IndexOutOfBoundsException();
        }
        Node n=getNode(index);
        T val=n.getValue();
        if(size()==1){
            n=n.getNext();
            return val;
        }
        else if(index==0){
            first=n.getNext();
            first.setPrev(null);
        }
        else if(index==size()-1){
            last=n.getPrev();
            last.setNext(null);
        }
        else{
            Node prev=n.getPrev();
            Node next=n.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            
            
        }
        length--;
        return val;
        
    }
    public boolean remove(T value){
        if(indexOf(value)>=0){
            remove(indexOf(value));
            return true;
        }
        return false;
    }
    
    public Iterator<T> iterator(){
        LinkedListIterator i=new LinkedListIterator(first);
        return i;
    }
    private class LinkedListIterator implements Iterator<T>{
        Node current;
        public LinkedListIterator(Node n){
            current=n;
        }
        public boolean hasNext(){
            return current!=null;
        }
        public T next(){
            T n=null;
            if(hasNext()){
                n= current.getValue();
                current=current.getNext();
            }
            else{
                System.exit(0);
            }
            return n;
            
        } 
    }
    private class Node{
        Node next,prev;
        T data;
        public Node(T dat){
            data=dat;
        }
        public String toString(){
            return "["+data+"]";
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node n){
            next=n;
        }
        public Node getPrev(){
            return prev;
        }
        public void setPrev(Node n){
            prev=n;  
        }
        public T getValue(){
            return data;
        }
        public void setValue(T n){
            data=n;
        }
    }
    public static void main(String[] args){
	MyLinkedListImproved<Character> L=new MyLinkedListImproved<>();
	Random rand=new Random();
	String s="";
	for(int i=1;i<26;i++){
            int value=65+rand.nextInt(57);
	    char c=(char)value;
	    //if(i%5==0){
		L.add(c);
		//	s="";
		//}
		//s+=c;
        }
	System.out.println(L);
	System.out.println(L.min());
	System.out.println(L.max());
    }
}
