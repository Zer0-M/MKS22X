import java.util.*;
public class Stack<T>{
    LinkedList<T> L;
    
    public Stack(){
		L=new LinkedList<T>();
    }
    public String toString(){
        return L.toString();
    }
    public void push(T e){
		L.add(e);
    }
    public T pop(){
        return L.remove(L.size()-1);
        
    }
    public static void main(String[] args){
        Stack<Integer> S= new Stack<>();
        S.push(13);
        S.push(12);
        S.push(2);
        S.push(-131);
        S.push(8970708);
        System.out.println(S);
        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S);
        //System.out.println(S.pop());
    }
    
}
