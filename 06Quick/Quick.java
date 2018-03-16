import java.util.*;

public class Quick{
    public static void swap(int[]data, int a, int b){
        int tem=data[a];
        data[a]=data[b];
        data[b]=tem;
    }
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
        int pivotI=start+rand.nextInt(end-start);
        int small=start+1;
        int large=end;
        swap(data,pivotI,start);
        while(small<=large){
            if(data[small]>=data[start]){
                swap(data,large,small);
                large--;
            }
            else {
                small++;
            }
        }
        swap(data,start,large);
        
        return large;
    }
    static void partitionD ( int [] data, int start, int end){
        if(start<end){
        Random rand=new Random();
        int pivotI=start+rand.nextInt(end-start);
        int pivot=data[pivotI];
        int lt=start;
        int gt=end;
        int i=start;
        while(i<=gt){
            if(data[i]==pivot){
                i++;
            }
            else if(data[i]>pivot){
                swap(data,i,gt);
                gt--;
            }
            else if(data[i]<pivot){
                swap(data,i,lt);
                lt++;
                i++;
            }
        }
        partitionD(data,start,lt-1);
        partitionD(data,i,end);
    }

    }
    public static int quickselect(int[] data, int k){
        int start=0;
        int end=data.length-1;
        int part=partition(data,start,end);
        while(part!=k&&end>start){ 
            part=partition(data,start,end);
            
            if(part>k){
                end=part-1;
            }
            else{
                start=part+1;
            }
        }
        return data[k];
    }
    public static void quicksort(int[] data){
        sortHelper(data,0,data.length-1);
    }
    private static void sortHelper(int[] data,int start, int end){
        if(start<end){
            int part=partition(data,start,end);
            sortHelper(data,start,part-1);
            sortHelper(data,part+1,end);
        }
    }
    public static void main(String[] args){
        for(int j=0;j<100;j++){
            Random rand=new Random();
            int length= rand.nextInt(100);
            int[] arr=new int[length];
            int[] ary=new int[length];
            for(int i=0;i<length;i++){
                int r=rand.nextInt(500);
                arr[i]=r;
                ary[i]=r;
            }
            Quick.partitionD(arr,0,arr.length-1);
            Arrays.sort(ary);
            if(!Arrays.equals(arr,ary)){
                 System.out.println("Test failed");
                System.out.println(Arrays.toString(arr));
             }
        }
    }
    
}
