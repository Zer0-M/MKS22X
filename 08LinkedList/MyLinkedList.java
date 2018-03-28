public class MyLinkedList{
    private class Node{
        Node next,prev;
        int data;
        public Node(int dat){
            data=dat;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node n){
            
        }
        public Node getPrev(){
            return prev;
        }
        public void setPrev(Node n){
            
        }
        public int getValue(){
			return data;
        }
        public void setValue(int n){

        }
    }
}