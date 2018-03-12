import java.io.*;
import java.util.Scanner;
import java.util.*;
public class USACO{
    private static int[][] map;
    private static int[][] instructions;
    private static char[][] mapS;
    private static int[][] prev;
    private static int[][] next;
    private static int T;
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
        int N=0;
        int M=0;
        T=0;
        int R1=0;
        int C1=0;
        int R2=0;
        int C2=0;
        String m="";
        try{
        File text = new File(filename);
        Scanner inf = new Scanner(text);
        for(int i=0;inf.hasNext();i++){
            if(i==0){
                N=inf.nextInt();
            }
            if(i==1){
                M=inf.nextInt();
                mapS=new char[N][M];
                prev=new int[N][M];
                next=new int[N][M];
                
            }
            if(i==2){
                T=inf.nextInt();
            }
            if(i==3){
                int counter=0;
                if(inf.hasNextLine()){
                    String dispose=inf.nextLine();
                }
                while(inf.hasNext()&&counter<N){
                String line = inf.next();
                m+=line;
                counter++;
                }
            }
            int count=0;
            for(int ind=0;i==3&&ind<N;ind++){
                for(int j=0;j<M;j++){
                    char c=m.charAt(count);
                    mapS[ind][j]=c;
                    count++;
                }
            }
            if(i==4){
                R1=inf.nextInt()-1;
            }
            if(i==5){
                C1=inf.nextInt()-1;
            }
            if(i==6){
                R2=inf.nextInt()-1;
            }
            if(i==7){
                C2=inf.nextInt()-1;
            }

        }
        prev[R2][C2]=1;
        moves(R1, C1,0);
        return next[R1][C1];
    }catch(FileNotFoundException e){
            System.out.println("please provide vaild file");
            System.exit(0);
        }
        return 0;
    }
    public static String stringify(int[][] arr){
        String Map="";
        for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[i].length;j++){
            if(arr[i][j]<10){
            Map+=" "+arr[i][j]+" ";
            }
            else{
            Map+=arr[i][j]+" ";
            }
        }
        Map+="\n";
        }
        return Map;
    }
    public static void moves(int targetR,int targetC, int moves){
        if(moves!=T){
            for(int i=0;i<next.length;i++){
                for(int j=0;j<next[i].length;j++){
                    if(prev[i][j]>0){
                        if(i+1<next.length&&mapS[i+1][j]!='*'){
                            next[i+1][j]+=prev[i][j];
                        }
                        if(i-1>=0&&mapS[i-1][j]!='*'){
                            next[i-1][j]+=prev[i][j];
                        }
                        if(j+1<next[i].length&&mapS[i][j+1]!='*'){
                            next[i][j+1]+=prev[i][j];
                        }
                        if(j-1>=0&&mapS[i][j-1]!='*'){
                            next[i][j-1]+=prev[i][j];
                        }
                        next[i][j]=0;
                    }
                }
            }
            for(int i=0;i<prev.length;i++){
                for(int j=0;j<prev[i].length;j++){
                    prev[i][j]=next[i][j];
                }
            }
            moves(targetR,targetC,moves+1);
        }
    }

    public static void main(String[] args){
        for(int i=1;i<11;i++){
        int sol=USACO.bronze("makelake."+i+".in");
        int solS=USACO.silver("ctravel."+i+".in");
        int [] solsB={342144,102762432,1058992704,753121152,1028282688,72207936,265508928,776609856,2098830528,211201344};
        int[] solsS={1,74,6435,339246,0,14396412,1533810,456055,28,1321670};
        if(sol!=solsB[i-1]){
            System.out.println(USACO.bronze("makelake."+i+".in"));
        }
        if(solS!=solsS[i-1]){
            System.out.println(USACO.silver("ctravel."+i+".in"));
        }
        }
        

    }

}
