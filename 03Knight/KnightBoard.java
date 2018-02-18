import java.util.*;
public class KnightBoard{
    int[][] board;
    public KnightBoard(int startingRows,int startingCols){
	board=new int[startingRows][startingCols];
    }

    public String toString(){
      String Board="";
      for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
          if(board[i][j]<10){
            Board+=" "+board[i][j]+" ";
          }
          else{
            Board+=board[i][j]+" ";
          }
        }
        Board+="\n";
      }
      return Board;
    
    }
    private int[][] possibleMoves(int r, int c){
	int[][] sols=new int[8][2];
	int x=r;
	int y=c;
	int count=0;
	int incR=3;
	int incC=1;
	for(int i=0;i<8;i++){
	    if(i==1||i==5){
		incC=0-incC;
	    }
	    if(i==2||i==6){
		incR=0-incR;
	    }
	    if(i==3&i==7){
		incC=0-incC;
	    }
	    if(i==4){
		incC=3;
		incR=1;
	    }
	    sols[count][0]=r+incR;
	    sols[count][1]=c+incC;
	    count+=1;
	}
	return sols;
    }
    public boolean solve(){
	int midR=board.length/2;
	int midC=board[0].length/2;
	return solver(midR,midC,1);
    }
    public int countSolutions(){
	return 0;
    }
    private boolean solver(int row ,int col, int level){
	if(level>=board.length*board[0].length){
	    return true;
	}
	return false;
    }
    public static void main(String[] args){
	KnightBoard k= new KnightBoard(5,5);
	for(int i=0;i<k.possibleMoves(3,3).length;i++){
	    board[possibleMoves(3,3)[i][0]][possibleMoves(3,3)[i][1]]==1;
	}
	System.out.println(k);
	System.out.println(Arrays.deepToString(k.possibleMoves(3,3)));
	k.solve();
	System.out.println(k);
    }
}
