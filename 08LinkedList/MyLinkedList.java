public class MyLinkedList{
    private Node first;
    private Node last;
    private int length;
    public MyLinkedList(int len){

    }
    public boolean add(int value){
        return true;
    }
    public int size(){
        return length;
    }
    public String toString(){
        return"";
    }
    public int get(int index){
		return 0;
    }
    public int set(int index,int newValue){
		return 0;
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
    }
}