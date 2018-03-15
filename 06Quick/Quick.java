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
        Random rand=new Random();
        int pivotI=start+rand.nextInt(end-start);
        int lt=start+1;
        int gt=end;
	int i=lt;
        swap(data,pivotI,start);
        while(i<=gt){
            if(data[i]==data[start]){
                i++;
            }
            if(data[i]>data[start]){
		swap(data,i,gt);
		gt--;
	    }
	    if(data[i]<data[start]){
		swap(data,i,lt);
                lt++;
		i++;
            }
        }
        swap(data,i,gt);
        
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
        Random rand=new Random();
        int length= rand.nextInt(50);
        int[] arr=new int[length];
        for(int i=0;i<length;i++){
            arr[i]=rand.nextInt(3);
        }
        System.out.println(Arrays.toString(arr));
        //for(int i=0;i<arr.length;i++){
        Quick.partitionD(arr,0,arr.length-1);
        //}
        System.out.println(Arrays.toString(arr));
    }
}
