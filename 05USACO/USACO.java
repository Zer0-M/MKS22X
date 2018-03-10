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
        for(int i=0;i<instructions.length;i++){
            stomp(i);
        }
        fill(E);
        int combinedDepth=0;
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(E-map[i][j]>0){
                    combinedDepth+=map[i][j];
                }
            }
        }
        
        return combinedDepth*72*72;
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
            for(int j=C_s;j<C_s+3&&j<map[ind].length;j++){
                if(map[ind][j]>peak){
                    peak=map[ind][j];
                }
            }
        }
        
        stompH(i,R_s,C_s,peak);
    }
    private static void stompH(int i,int r, int c,int peak){
        int D_s=instructions[i][2];
        for(int ind=r;ind<r+3&&ind<map.length;ind++){
            for(int j=c;j<c+3&&j<map[ind].length;j++){
                if(map[ind][j]-(peak-D_s)<=D_s&&map[ind][j]-(peak-D_s)>=0){
                    map[ind][j]=peak-D_s;
                }
            }
        }
        
    }
    private static void fill(int E){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(E-map[i][j]>0){
                    map[i][j]=E-map[i][j];
                }
                else{
                    map[i][j]=0;
                }
            }
        }
    }
    public static int silver(String filename){
	return 0;
    }
    public static void main(String[] args){
        for(int i=1;i<11;i++){
        int sol=USACO.bronze("makelake."+i+".in");
        int [] sols={342144,102762432,1058992704,753121152,1028282688,72207936,265508928,776609856,2098830528,211201344};
        System.out.println(sol==sols[i-1]);
        }
    }

}
