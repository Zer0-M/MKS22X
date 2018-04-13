import java.util.*;
public class Sorts{
    public static int getDigit(int i,Integer num){
        double n=num%(Math.pow(10,i));
        n=n/(Math.pow(10,i-1));
        return (int)n;
    }
    public static int countDigits(Integer num){
        return num.toString().length();
    }
    public static void bucket(int digit,MyLinkedListImproved<Integer> data){
        MyLinkedListImproved[] arr=new MyLinkedListImproved[10];
        //System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            arr[i]=new MyLinkedListImproved<Integer>();
        }
        for(Integer v:data){
            int i=getDigit(digit, v);
            //System.out.println(arr[i]);
            arr[i].add(v);
        }
        MyLinkedListImproved<Integer> L=new MyLinkedListImproved<>();
        for(int i=0;i<arr.length;i++){
            L.extend(arr[i]);
            //System.out.println("L: "+L);
        }
        int i=0;
        for(Integer v:L){
            data.set(i,v);
            i++;
        }
        
    }
    public static void radixsort(MyLinkedListImproved<Integer> data){
        int max=data.max();
        int maxdig=countDigits(data.get(max));
        for(int i=1;i<=maxdig;i++){
             System.out.println(data);
             bucket(i,data);
        }
        System.out.println(data);
        
    }
    public static void main(String[] args){
        MyLinkedListImproved<Integer> L=new MyLinkedListImproved<>();
        L.add(221);
        L.add(24);
        L.add(27);
        L.add(33);
        L.add(16);
        L.add(19);
        L.add(71);
        L.add(35);
        L.add(96);
        radixsort(L);
        System.out.println(L);
    }
}
