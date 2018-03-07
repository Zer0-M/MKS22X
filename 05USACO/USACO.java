import java.io.*;
import java.util.Scanner;
import java.util.*;
public class USACO{
    private static int[][] map;
    private static int[][] instructions;
    public static int bronze(String filename){
        int R=0;
        int C=0;
        int E=0;
        int N=0;
        try{
        File text = new File(filename);
        Scanner inf = new Scanner(text);
        for(int i=0;inf.hasNext();i++){
            if(i==0){
                R=inf.nextInt();
            }
            if(i==1){
                C=inf.nextInt();
                map=new int[R][C];
            }
            if(i==2){
                E=inf.nextInt();
            }
            if(i==3){
                N=inf.nextInt();
                instructions=new int[N][3];
            }
            for(int ind=0;i==4&&ind<R;ind++){
                for(int j=0;j<C;j++){
                    map[ind][j]=inf.nextInt();
                }
            }
            for(int ind=0;i==5&&ind<N;ind++){
                for(int j=0;j<3;j++){
                    instructions[ind][j]=inf.nextInt();
                }
            }
        }
        System.out.println(R + " "+C +" "+ E+" "+N+" "+Arrays.deepToString(map)+" "+Arrays.deepToString(instructions));
        }
        catch(FileNotFoundException e){
            System.out.println("please provide vaild file");
            System.exit(0);
        }
        return 0;    
    }
    private void stomp(int i){
        int R_s=instructions[i][0]-1;
        int C_s=instructions[i][1]-1;
        int D_s=instructions[i][2];
        stompH(i,R_s,C_s,D_s);
    }
    private void stompH(int i,int r, int c, int d){
        int R_s=instructions[i][0]-1;
        int C_s=instructions[i][1]-1;
        int D_s=instructions[i][2];
        if((r>R_s+2&&c>C_s+2)||map[r][c]!=map[R_s][C_s]){        
	    if(map[r+1][c]>map[r][c]){
		if(map[r+1][c]-map[r][c]<d){
		    map[r+1][c]=map[r][c];
		    stompH(i,r+1,c,d);
		}
	    }
	    else{
		if(map[r][c]-map[r+1][c]<d){
		    map[r][c]=map[r+1][c];
		    stompH(i,r,c-1,d);
		}
	    }
	    if(map[r-1][c]>map[r][c]){
		if(map[r-1][c]-map[r][c]<d){
		    map[r-1][c]=map[r][c];
		    stompH(i,r-1,c,d);
		}
	    }
	    else{
		if(map[r][c]-map[r-1][c]<d){
		    map[r][c]=map[r-1][c];
		    stompH(i,r,c-1,d);
		}
	    }
	    if(map[r][c+1]>map[r][c]){
		if(map[r][c+1]-map[r][c]<d){
		    map[r][c+1]=map[r][c];
		    stompH(i,r,c+1,d);
		}
	    }
	    else{
		if(map[r][c]-map[r][c+1]<d){
		    map[r][c]=map[r][c+1];
		    stompH(i,r,c-1,d);
		}
	    }
	    if(map[r][c-1]>map[r][c]){
		if(map[r][c-1]-map[r][c]<d){
		    map[r][c-1]=map[r][c];
		    stompH(i,r,c-1,d);
		}
	    }
	    else{
		if(map[r][c]-map[r][c-1]<d){
		    map[r][c]=map[r][c-1];
		    stompH(i,r,c-1,d);
		}
	    }
	}
	
    }
    public static int silver(String filename){
	return 0;
    }
    public static void main(String[] args){
        System.out.println(USACO.bronze("makelake.in"));
    }

}
