import java.util.*;
public class Sorts{
	public static int getDigit(int i,Integer num){
		double n=num%(Math.pow(10,i));
		n=n/(Math.pow(10,i-1));
		return (int)n;
	}
	public static int countDigits(Integer num){
		return num.toString().length();
	}
	public static void radixsort(MyLinkedListImproved<Integer> data){
		MyLinkedListImproved<Integer> absoluteData=new MyLinkedListImproved<>();
		for (Integer i:data){
			if(i<0){
				i=0-i;
			}
			absoluteData.add(i);
		}
		int max=absoluteData.max();
		if(max>=0){
			int maxdig=countDigits(data.get(max));
			for(int j=1;j<=maxdig;j++){
				@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] arr=new MyLinkedListImproved[10];
				@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] neg=new MyLinkedListImproved[10];
				
				for(int i=0;i<arr.length;i++){
					arr[i]=new MyLinkedListImproved<Integer>();
					neg[i]=new MyLinkedListImproved<Integer>();
				}
				for(Integer v:data){
					int i=getDigit(j, v);
					if(v<0){
						neg[9+i].add(v);
					}
					else{
						arr[i].add(v);
					}
				}
				data.clear();
				for(int i=0;i<neg.length;i++){
					data.extend(neg[i]);
				}
				for(int i=0;i<arr.length;i++){
					data.extend(arr[i]);
				}
			}
		}
	}
	public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
	    radixsort(data);
	}

	public static void main(String[] args){
		MyLinkedListImproved<Integer> L=new MyLinkedListImproved<>();
		Random rand=new Random();
		int[] arr=new int[1000000];
		
		for(int i=0;i<1000000;i++){
			int value=rand.nextInt();
			//if(i%2!=0){
			L.add(value);
			arr[i]=value;
			//}
			//else{
			//L.add(value);
			//arr[i]=value;
			//}
			
		}
		
		
		long end,start=System.currentTimeMillis();
		radixsort(L);
		end=System.currentTimeMillis();
		System.out.println(((float)(end-start))/1000);
		//Arrays.sort(arr);
		int i=0;
		
		/*for(Integer v:L){
			if(v!=arr[i]){
				System.out.println("not sorted");
				System.out.println(i+" "+v+" "+arr[i]);
				System.exit(0);
			}
			i++;
		}*/
	}
}
