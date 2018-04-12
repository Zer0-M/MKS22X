import java.util.*;
public class Sorts{
    public static int getDigit(int i,int num){
	double n=num%(Math.pow(10,i));
	n=n/10;
	return (int)n;
    }
    public static void radixsort(MyLinkedListImproved<Integer> data){
	
    }
    public static void main(String[] args){
	System.out.println(getDigit(2,123));
    }
}
