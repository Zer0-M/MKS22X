import java.util.*;
public class MyLinkedList{
    private Node first;
    private Node last;
    private int length;
    public MyLinkedList(){
        length=0;
    }
    public boolean add(int value){
        Node addend=new Node(value);
        /*adding from the front
        if(first==null){
            first=addend;
            last=first;
        }
        else{
            Node temp=new Node(first.getValue());
            temp.setNext(first.getNext());
            temp.setPrev(first.getPrev());
            first.setPrev(addend);
            first=first.getPrev();
            first.setNext(temp);
        }*/
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
        for(int i=0;i<length;i++){
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
        if(index>=length||index<0){
            throw new IndexOutOfBoundsException();
        }
        for(int i=0;i!=index;i++){
            n=n.getNext();
        }
        return n;
    }
    public int get(int index){
        Node n=first;
        //currently assuming index exists exceptions will be added later
        if(index>=length||index<0){
            throw new IndexOutOfBoundsException();
        }
        for(int i=0;i!=index;i++){
            n=n.getNext();
        }
        return n.getValue();
    }
    public int set(int index,int newValue){
        Node n=last;
        if(index>=length||index<0){
            throw new IndexOutOfBoundsException();
        }
        for(int i=length-1;i!=index;i--){
            n=n.getPrev();
        }
        int old=n.getValue();
        n.setValue(newValue);
        return old;
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
        for(int i=0;i<10;i++){
            L.add(rand.nextInt(100));
        }
        System.out.println(L);	
    }
}
