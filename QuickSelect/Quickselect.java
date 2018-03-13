import java.util.*;
public class Quickselect{
    /*Choose a random pivot element, and modify the array such that:
    *1. Only the indices from start to end inclusive are considered in range
    *2. A random index from start to end inclusive is chosen, the corresponding 
    *   element is designated the pivot element. 
    *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
    *4. all elements in range that are larger than the pivot element are placed after the pivot element.
    *@return the index of the final position of the pivot element.
    */
    static int partition ( int [] data, int start, int end){
        Random rand=new Random();
        int pivotI=rand.nextInt(data.length);
        int pivot=data[pivotI];
    
        int tem=data[start];
        data[start]=pivot;
        start++;
        data[pivotI]=tem;
        pivotI=0;

        
        while(start<end){
            if(data[start]>=pivot){
                int temp=data[end];
                data[end]=data[start];
                end--;
                data[start]=temp;
            }
            else if(data[start]<pivot){
                start++;
            }
        }
        for(int i=0;i<data.length-1&&data[i+1]<data[i];i++){
                int temp=data[i+1];
                data[i+1]=data[i];
                data[i]=temp;
                pivotI=i+1;
                
        }
        return pivotI;
    }
    public static void main(String[] args){
        int[] arr={999,999,999,4,1,0,3,2,999,999,999};
        System.out.println(Quickselect.partition(arr,0,arr.length-1));
    }
}
