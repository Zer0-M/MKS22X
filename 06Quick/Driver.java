import java.util.*;
public class Driver{
    public static void main(String[] args){
        for(int j=0;j<1;j++){
            Random rand=new Random();
            int length= rand.nextInt(1000);
            int[] arr=new int[length];
            int[] ary=new int[length];
            int[] ar=new int[length];
            for(int i=0;i<length;i++){
                int r=rand.nextInt(rand.nextInt(100)+1);
                arr[i]=r;
                ary[i]=r;
                ar[i]=r;
            }
            // long startTime = System.nanoTime();
            Quick.quicksort(arr);
            // long stopTime = System.nanoTime();
            // long elapsedTime = stopTime - startTime;
            //System.out.println("Dutch Flag: "+elapsedTime);
            // startTime=System.nanoTime();
            Arrays.sort(ary);
            // stopTime = System.nanoTime();
            // long elapsedTimeB = stopTime - startTime;
            //System.out.println("Built in: "+elapsedTimeB);
            if(!Arrays.equals(arr,ary)){
                 System.out.println("Test failed");
                System.out.println(Arrays.toString(arr));
             }
             for(int i=0;i<ar.length;i++){
                 int k=Quick.quickselect(ar, i);
                 if(ary[i]!=k){
                     System.out.println("quickselect Test failed");
                 }
             }
        }

    }
}
