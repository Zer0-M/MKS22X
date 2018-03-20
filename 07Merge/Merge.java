import java.util.Arrays;

public class Merge{
    private static void merge(int[] data,int lo,int hi){
        int mid=lo+(hi-lo)/2;
        int[] temp=new int[data.length];
        int tempCounter=0;
		for(int i=lo,j=mid+1;i<=mid||j<=hi;){
            if(j>hi){
                temp[lo+tempCounter]=data[i];
                tempCounter++;
                i++;
            }
            else if(i>mid){
                temp[lo+tempCounter]=data[j];
                tempCounter++;
                j++;
            }
			else if(data[i]<data[j]){
                temp[lo+tempCounter]=data[i];
                tempCounter++;
                i++;
            }
            else{
                temp[lo+tempCounter]=data[j];
                tempCounter++;
                j++;
            }

        }
        for(int i=lo;i<=hi;i++){
            data[i]=temp[i];
        }
    }
    public static void mergesort(int[] data){
		mergesortH(data, 0, data.length-1);
    }
    private static void mergesortH(int[] data,int lo,int hi){
        if(lo<hi){
            int mid=lo+(hi-lo)/2;
            mergesortH(data, lo, mid);
            mergesortH(data, mid+1, hi);
            merge(data,lo,hi);
        }
    }
}