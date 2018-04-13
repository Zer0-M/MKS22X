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
    public static void radixsort(MyLinkedListImproved<Integer> data){
        int max=data.max();
        int maxdig=countDigits(data.get(max));
        for(int j=1;j<=maxdig;j++){
	    @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] arr=new MyLinkedListImproved[10];
	    //System.out.println(Arrays.toString(arr));
	    for(int i=0;i<arr.length;i++){
		arr[i]=new MyLinkedListImproved<Integer>();
	    }
	    for(Integer v:data){
		int i=getDigit(j, v);
		//System.out.println(arr[i]);
		arr[i].add(v);
	    }
	    data.clear();
	    for(int i=0;i<arr.length;i++){
		data.extend(arr[i]);
		//System.out.println("L: "+L);
	    }
        }
        
    }
    public static void main(String[] args){
        MyLinkedListImproved<Integer> L=new MyLinkedListImproved<>();
	Random rand=new Random();
	int[] arr=new int[1000000];
	String s="";
	long end,start=System.currentTimeMillis();
	for(int i=0;i<1000000;i++){
            int value=rand.nextInt(2147483647);
	    char c=(char)value;
	    //if(i%5==0){
		L.add(value);
		arr[i]=value;
		//LL.add(value*rand.nextInt(10));
		//	s="";
		//}
		//s+=c;
        }
	end=System.currentTimeMillis();
        radixsort(L);
	int i=0;
	Arrays.sort(arr);
	for(Integer v:L){
	    if(v!=arr[i]){
		System.out.println("not sorted");
	    }
	    i++;
	}
	System.out.println(Arrays.toString(arr));
        //System.out.println(L);
    }
}
