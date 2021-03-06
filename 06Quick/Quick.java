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
    static int partition0 ( int [] data, int start, int end){
        Random rand=new Random();
        if(start==end){
            return data[start];
	}
        int pivotI=start+rand.nextInt(end-start);
        swap(data,pivotI,start);
        int small=start+1;
        int large=end;
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
    static int[] partition ( int [] data, int start, int end){
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
        int[] part=new int[2];
        part[0]=lt-1;
        part[1]=i;
        return part;
    }
    public static int quickselect(int[] data, int k){
        int start=0;
        int end=data.length-1;
        int part=partition0(data,start,end);
        while(start<end&&k!=part){ 
            if(part>k){
                end=part-1;
            }
            else if(part<k){
                start=part+1;
            }
            part=partition0(data,start,end);
        }
        return data[k];
    }
    public static void quicksort(int[] data){
        sortHelper(data, 0,data.length-1 );
    }
    public static void insertionSort(int[] data,int lo,int hi){
        for(int i=lo;i<=hi;i++){
            int startVal=data[i];
            int tempint=i-1;
            while(tempint>=lo&&data[tempint]>startVal){
                data[tempint+1]=data[tempint];
                tempint--;  
            }
            data[tempint+1]=startVal;
            
        }
    }
    private static void sortHelper(int[] data,int start, int end){
        if(start<end){
            if((end-start)<10){
                insertionSort(data,start,end);
            }
            else{
            int[] part=partition(data,start,end);
            sortHelper(data,start,part[0]);
            sortHelper(data,part[1],end);
            }
        }
    }
    public static void quicksortOld(int[] data){
        sortHelperOld(data, 0,data.length-1 );
    }
    private static void sortHelperOld(int[] data,int start, int end){
        if(start<end){
            int part=partition0(data,start,end);
            sortHelperOld(data,start,part-1);
            sortHelperOld(data,part+1,end);
        }
    }
}
