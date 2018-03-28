public class MyLinkedList{
    public class Node{
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