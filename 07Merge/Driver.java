import java.util.*;
public class Driver{
    /*
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
	}*/
     //Sort testing code
  private static final int INCREASE = 0;
  private static final int DECREASE = 1;
  private static final int STANDARD = 2;
  private static final int SMALL_RANGE = 3;
  private static final int EMPTY = 4;

  private static String name(int i){
    if(i==0)return "Increassing";
    if(i==1)return "Decreassing";
    if(i==2)return "Normal Random";
    if(i==3)return "Random with Few Values";
    if(i==4)return "size 0 array";
    return "Error stat array";

  }

  private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
  }
    private static void sortSelect(int type,int[] data){
	if(type==1){
	    Merge.mergesort(data);
	}
	if(type==2){
	    Quick.quicksort(data);
	}
	if(type==3){
	    Merge.insertionSort(data,4,9);
	}
    }

  private static int[]makeArray(int size,int type){
    int[]ans =new int[size];
    if(type == STANDARD){
      for(int i = 0; i < size; i++){
        ans[i]= create(-1000000,1000000);
      }
    }
    if(type == INCREASE){
      int current = -5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current += 10;
      }
    }
    if(type == DECREASE){
      int current = 5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current -= 10;
      }
    }
    if(type == SMALL_RANGE){
      for(int i = 0; i < size; i++){
        ans[i]= create(-5,5);
      }
    }
    if(type == EMPTY){
      ans = new int[0];
    }
    return ans;
  }

  public static void main(String[]args){
      //if(args.length < 2)return;
    for(int i=0;i<5;i++){
    Random rand=new Random();
    int size =1000000; //rand.nextInt(1000000);
    int type =   i;

    int [] start = makeArray(size,type);
    int [] result = Arrays.copyOf(start,start.length);
    Arrays.sort(result);
    
    long startTime = System.currentTimeMillis();
    sortSelect(1,start);
    long elapsedTime = System.currentTimeMillis() - startTime;
    if(Arrays.equals(start,result)){
      System.out.println("PASS Case "+type+". "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
    }else{
      System.out.println("FAIL ! Case "+type+" ERROR! "+name(type)+" array, size:"+size+"  ERROR!");
    }
    }
  }
}
