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
    public String remove(){
        String removed=data[0];
        swap(data,0,size()-1);
        data[size()-1]=null;
        length--;
        int j=0;
        String s=data[j];
        if(length>0){
            if(isMax){
                for(int i=2*j+1;data[i]!=null&&s.compareTo(data[i])<0;i=2*i+1){
                    //System.out.println(i+" "+s.compareTo(data[i]));
                    //System.out.println(s+" "+data[i]);
                    if(data[i+1]!=null&&s.compareTo(data[i+1])<s.compareTo(data[i])){
                        swap(data,i+1,j);
                        j=i+1;
                    }
                    else{
                        swap(data,i,j);
                        j=i;
                    }
                    
                }
            }
            else{
                    
                }
            }
        return removed;
        
    }

    public static void main(String[] args){
        MyHeap h=new MyHeap(true);
        h.add("Z");
        h.add("A");
        h.add("a");
        h.add("F");
        h.add("Z");
        h.add("d");
        h.add("c");
        h.remove();
        h.remove();
        h.remove();
        h.remove();
        h.remove();
        System.out.println(h);
    }
}