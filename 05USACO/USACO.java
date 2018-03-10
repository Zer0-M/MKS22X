import java.io.*;
import java.util.Scanner;
import java.util.*;
public class USACO{
    private static int[][] map;
    private static int[][] instructions;
    private static boolean stompMap;

    public static int bronze(String filename){
        stompMap=true;
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
        for(int i=0;i<instructions.length;i++){
            stomp(i);
        }
        System.out.println(R + " "+C +" "+ E+" "+N+" "+Arrays.deepToString(map)+" "+Arrays.deepToString(instructions));
        }
        catch(FileNotFoundException e){
            System.out.println("please provide vaild file");
            System.exit(0);
        }
        return 0;    
    }
    private static void stomp(int i){
        int R_s=instructions[i][0]-1;
        int C_s=instructions[i][1]-1;
        int peak=map[R_s][C_s]; //since the cows wait for cows at higher level are on the same level
        for(int ind=R_s;ind<R_s+3&&ind<map.length;ind++){
            for(int j=C_s;j<C_s+3&&j<map[i].length;j++){
                if(map[ind][j]>peak){
                    peak=map[ind][j];
                }
            }
        }
        System.out.println(R_s+" "+C_s);
        stompH(i,R_s,C_s,peak);
    }
    private static void stompH(int i,int r, int c,int peak){
        int R_s=instructions[i][0]-1;
        int C_s=instructions[i][1]-1;
        int D_s=instructions[i][2];
        
        System.out.println((map[r][c+1]-(peak-D_s))+" "+Arrays.deepToString(map));
        if(r<map.length&&Math.abs(map[r+1][c]-(peak-D_s))<=D_s){
            map[r+1][c]=peak-D_s;
            stompH(i,r+1,c,peak);
        }
        if(c-1>=0&&Math.abs(map[r][c-1]-peak-D_s)<=D_s){
            int old=map[r][c-1];
            map[r][c-1]=peak-D_s;
            stompH(i,r,c-1,peak);
        }
        if(r-1>=0&&Math.abs(map[r-1][c]-peak-D_s)<=D_s){
            int old=map[r-1][c];
            map[r-1][c]=peak-D_s;
            stompH(i,r-1,c,peak);
        }
        if(c<map[0].length&&Math.abs(map[r][c+1]-peak-D_s)<=D_s){
            int old=map[r][c+1];
            map[r][c+1]=peak-D_s;
            stompH(i,r,c+1,peak);
        }
    }
    public static int silver(String filename){
	return 0;
    }
    public static void main(String[] args){
        System.out.println(USACO.bronze("makelake.in"));
    }

}
