import java.util.*;
public class Driver{
    public static void main(String[] args){
        for(int j=0;j<100;j++){
            Random rand=new Random();
            int length= rand.nextInt(1000);
            int[] arr=new int[length];
            int[] ary=new int[length];
            int[] ar=new int[length];
            int[] data=new int[length];
            for(int i=0;i<length;i++){
                int r=rand.nextInt(rand.nextInt(100)+1);
                arr[i]=r;
                ary[i]=r;
                ar[i]=r;
                data[i]=r;
            }
            long start,end;
            start = System.nanoTime();
            Quick.quicksort(arr);
            end = System.nanoTime();
            long elapsedD=end-start;
            start = System.nanoTime();
            Quick.quicksortOld(ar);
            end = System.nanoTime();
            long elapsed=end-start;
            if(elapsed>elapsedD){
                System.out.println("Dutch Flag Partition Wins");
            }
            else{
                System.out.println("Regular Partition Wins");
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
             for(int i=0;i<data.length;i++){
                 int k=Quick.quickselect(data, i);
                 if(ary[i]!=k){
                     System.out.println("quickselect Test failed");
                 }
             }
        }

    }
}
