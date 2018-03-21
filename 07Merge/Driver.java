import java.util.*;
public class Driver{
    public static void main(String[] args){
        int winD=0;
        int win=0;
        int winM=0;
        for(int j=0;j<1000;j++){
            Random rand=new Random();
            int length= rand.nextInt(1000);
            int[] arr=new int[length];
            int[] ary=new int[length];
            int[] ar=new int[length];
            int[] data=new int[length];
            for(int i=0;i<length;i++){
                int r=rand.nextInt(rand.nextInt(1000)+1);
                if(i%5==0){
                    r=0-r;
                }
                arr[i]=r;
                ary[i]=r;
                ar[i]=r;
                data[i]=r;
            }
            long start,end;
            start = System.nanoTime();
            Merge.mergesort(arr);
            end = System.nanoTime();
            long elapsedM=end-start;
            start = System.nanoTime();
            Quick.quicksort(data);
            end = System.nanoTime();
            long elapsedD=end-start;
            start = System.nanoTime();
            Quick.quicksortOld(ar);
            end = System.nanoTime();
            long elapsed=end-start;
            if(Math.max(elapsedM,Math.max(elapsedD,elapsed))==elapsedM){
                winM++;
            }
            if(Math.max(elapsedM,Math.max(elapsedD,elapsed))==elapsed){
               win++;
            }
            if(Math.max(elapsedM,Math.max(elapsedD,elapsed))==elapsedD){
               winD++;
            }
            // startTime=System.currentTimeMillis();
            Arrays.sort(ary);
            // stopTime = System.currentTimeMillis();
            // long elapsedTimeB = stopTime - startTime;
            //System.out.println("Built in: "+elapsedTimeB);
            if(!Arrays.equals(arr,ary)){
                 System.out.println("Test failed");
                System.out.println(Arrays.toString(arr));
             }
        }

        System.out.println("QuickSort Regular: "+win+" vs QuickSort Dutch: "+winD+" vs MergeSort: "+winM);
    }
}