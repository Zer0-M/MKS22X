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

        
        for(int i=start;i<end;i++){
            System.out.println(i+" " +start+" "+end+" "+Arrays.toString(data));
            if(data[i]>pivot){
                int temp=data[end];
                data[end]=data[i];
                end--;
                data[i]=temp;
                System.out.println(i+" " +start+" "+end+" "+Arrays.toString(data));
            }
            else if(data[i]<pivot){
                int temp=data[start];
                data[start]=data[i];
                start++;
                data[i]=temp;
                System.out.println(i+" " +start+" "+end+" "+Arrays.toString(data));
            }
        }
        System.out.println(Arrays.toString(data));
        return pivot;
    }
    public static void main(String[] args){
        int arr[]={17, 61, 67,5,6};
        System.out.println(Quickselect.partition(arr,0,arr.length-1));
    }
}