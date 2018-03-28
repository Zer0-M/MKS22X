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
        System.out.println(L);
    }
}