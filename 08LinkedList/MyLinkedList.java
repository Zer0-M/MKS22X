import java.util.*;
public class MyLinkedList{
    private Node first;
    private Node last;
    private int length;
    public MyLinkedList(){
        length=0;
    }
    public void clear(){
        length=0;
    }
    public boolean add(Integer value){
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
            if(n.hasNext()){
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
    public Integer get(Integer index){
        Node n=first;
        //currently assuming index exists exceptions will be added later
        if(index>=size()||index<0){
            throw new IndexOutOfBoundsException();
        };
        for(Integer i=0;!i.equals(index);i++){
            n=n.getNext();
        }
        return n.getValue();
    }
    public Integer set(int index,Integer newValue){
        Node n=last;
        if(index>=size()||index<0){
            throw new IndexOutOfBoundsException();
        }
        for(Integer i=size()-1;!i.equals(index);i--){
            n=n.getPrev();
        }
        int old=n.getValue();
        n.setValue(newValue);
        return old;
    }
    public int indexOf(Integer value){
        Node n=first;
        for(int i=0;i<size();i++){
            if(value.equals(n.getValue())){
                return i;
            }
            n=n.getNext();
        }
        return -1;
    }
    public void add(int index,Integer value){
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
    public Integer remove(int index){
        if(index>size()||index<0){
            throw new IndexOutOfBoundsException();
        }
        Node n=getNode(index);
        int val=n.getValue();
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
    public boolean remove(Integer value){
        if(indexOf(value)>=0){
            remove(indexOf(value));
            return true;
        }
        return false;
    }
    private class Node{
        Node next,prev;
        int data;
        public Node(int dat){
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
        public int getValue(){
            return data;
        }
        public void setValue(int n){
            data=n;
        }
        public boolean hasNext(){
            if(getNext()==null){
                return false;
            }
            else{
                return true;
            }
        }
    }
    public static void main(String[] args){
        MyLinkedList L=new MyLinkedList();
        Random rand=new Random();
	long startTime = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            int value=rand.nextInt(100);
            L.add(value);
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
    //System.out.println(elapsedTime);
    	System.out.println(L);
        System.out.println(L.get(2));
        System.out.println(L);
        L.add(9,25);
        L.remove(9);
        System.out.println(L);
        L.add(8,10);
	    System.out.println(L);
        L.set(0,6);
        L.remove(4);
        System.out.println(L);
        Integer i=6;
        L.remove(i);
        System.out.println(L);
        L.clear();
        System.out.println(L);
        
	//System.out.println(L.set(4,5));
	//System.out.println(L.indexOf(5));
        //System.out.println(L);
        //System.out.println(L.indexOf(val));	
    }
}
