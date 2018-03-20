import java.util.*;
public class Driver{
    public static void main(String[] args){
        for(int j=0;j<1000;j++){
            Random rand=new Random();
            int length= rand.nextInt(1000);
            int[] arr=new int[length];
            int[] ary=new int[length];
            for(int i=0;i<length;i++){
                int r=rand.nextInt(rand.nextInt(100)+1);
                if(i%5==0){
                    r=0-r;
                }
                arr[i]=r;
                ary[i]=r;
            }
            Merge.mergesort(arr);

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
    }
}