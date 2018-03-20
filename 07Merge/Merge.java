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
    public static void main(String[] args){
        int[] arr={0,2,6,1,6,3,2,5};
        Merge.merge(arr,0,4);
        System.out.println(Arrays.toString(arr));

    }
}