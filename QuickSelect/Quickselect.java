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
        int pivotI=3;//start+rand.nextInt(end-start);
        int pivot=data[pivotI];
        int small=start;
        int large=end;
        int tem=data[small];
        data[small]=pivot;
        data[pivotI]=tem;
        pivotI=small;
        small++;


        
        while(small<large){
            if(data[small]>=pivot){
                int temp=data[large];
                data[large]=data[small];
                large--;
                data[small]=temp;
            }
            else if(data[small]<pivot){
                small++;
            }
        }
        for(int i=start;i<end&&data[i+1]<data[i];i++){
                int temp=data[i+1];
                data[i+1]=data[i];
                data[i]=temp;
                pivotI=i+1;
                
        }
        return pivotI;
    }
    public static int quickSelect(int[] data, int k){
        int start=0;
        int end=data.length-1;
        int part=partition(data,start,end);
        while(part!=k){ 
            if(part>k){
                end=part;
            }
            else{
                start=part;
            }
            
            part=partition(data,start,end);
        }
        
        return data[part];
    }
    public static void main(String[] args){
        int[] arr={0,2,5,2};
        //for(int i=0;i<arr.length;i++){
        System.out.println(Quickselect.quickSelect(arr,2));
        //}
    }
}
