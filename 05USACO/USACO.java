import java.io.*;
import java.util.Scanner;
import java.util.*;
public class USACO{
    public static int[][] map;
    public static int[][] instructions;
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
        int R_s=instructions[i][0];
        int C_s=instructions[i][1];
        int D_s=instructions[i][2];
        stompH(i,R_s,C_s,D_s);
    }
    private void stompH(int i,int r, int c, int d){
        int R_s=instructions[i][0];
        int C_s=instructions[i][1];
        int D_s=instructions[i][2];
        if((r>R_s+2&&c>C_s+2)||map[r][c]!=map[R_s][C_s]){
            System.out.println(Arrays.deepToString(map));
        }
    }
    public static int silver(String filename){
	return 0;
    }
    public static void main(String[] args){
        System.out.println(USACO.bronze("makelake.in"));
    }

}
