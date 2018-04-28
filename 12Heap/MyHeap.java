import java.util.Arrays;

public class MyHeap{
    String[] data;
    int length;
    boolean isMax;
    public MyHeap(){
        data=new String[13];
        isMax=true;
    }
    public MyHeap(boolean max){
        data=new String[13];
        isMax=max;
    }
    public String toString(){
        return Arrays.toString(data);
    }
    private void swap(String[] arr,int i,int j){
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int size(){
        return length;
    }
    public void add(String s){
        data[length]=s;
        int j=length;
        if(length>0){
            if(isMax){
                for(int i=(length-1)/2;s.compareTo(data[i])>0;i=(i-1)/2){
                    //System.out.println(i+" "+s.compareTo(data[i]));
                    //System.out.println(s+" "+data[i]);
                    swap(data,i,j);
                    j=i;
                }
            }
            else{
                for(int i=(length-1)/2;s.compareTo(data[i])<0;i=(i-1)/2){
                    //System.out.println(i+" "+s.compareTo(data[i]));
                    //System.out.println(s+" "+data[i]);
                    swap(data,i,j);
                    j=i;
                }
            }
        }
        length++;
        
    }
    public static void main(String[] args){
        MyHeap h=new MyHeap(false);
        h.add("Z");
        h.add("A");
        h.add("Sa");
        h.add("F");
        h.add("Z");
        h.add("bold");
        h.add("SZ");
        System.out.println(h);
    }
}