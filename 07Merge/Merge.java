import java.util.Arrays;

public class Merge{
    private static void merge(int[] data,int[] temp,int lo,int hi){
        int mid=lo+(hi-lo)/2;

        int tempCounter=0;
		for(int i=lo,j=mid+1;i<=mid||j<=hi;){
            if(j>hi){
                data[lo+tempCounter]=temp[i];
                tempCounter++;
                i++;
            }
            else if(i>mid){
                data[lo+tempCounter]=temp[j];
                tempCounter++;
                j++;
            }
			else if(temp[i]<temp[j]){
                data[lo+tempCounter]=temp[i];
                tempCounter++;
                i++;
            }
            else{
                data[lo+tempCounter]=temp[j];
                tempCounter++;
                j++;
            }

        }
    }
    public static void mergesort(int[] data){
        int[] temp=new int[data.length];
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
		mergesortH(data,temp, 0, data.length-1);
    }
    public static void insertionSort(int[] data,int lo,int hi){
      for(int i=lo+1;i<=hi;i++){
        int startVal=data[i];
        int tempint=i-1;
        while(tempint>=0&&data[tempint]>startVal){
          data[tempint+1]=data[tempint];
          tempint--;  
        }
        data[tempint+1]=startVal;
        
      }
    }
    private static void mergesortH(int[] data,int[] temp,int lo,int hi){
	if(lo<hi){
		int mid=lo+(hi-lo)/2;
		mergesortH(temp,data, lo, mid);
		mergesortH(temp,data, mid+1, hi);

    }
}
