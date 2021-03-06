import java.util.*;
public class KnightBoard{
  private int[][] board;
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
  /*private int[] possibleMoves(int r,int c,int i){
    int[] sols=new int[2];
    int incR=2;
    int incC=1;
    if(i==1){
      incC=0-incC;
    }
    if(i==2){
      incR=0-incR;
    }
    if(i==3){
      incC=0-incC;
    }
    if(i==4){
      incC=2;
      incR=1;
    }
    if(i==5){
      incC=-2;
      incR=1;
    }
    if(i==6){
      incC=-2;
      incR=-1;
    }
    if(i==7){
      incC=2;
      incR=-1;
    }
    sols[0]=incR;
    sols[1]=incC;
    
    return sols;
  }
  /**
    @throws IllegalStateException when the board contains non-zero values.
    @throws IllegalArgumentException when either parameter is negative 
    or out of bounds.
  
  public boolean solve(int startingRow, int startingCol){
    if(startingRow<0&&startingCol<0&&startingRow>=board.length&&startingCol>=board[0].length){
      throw new IllegalArgumentException();
    }
    return solver(startingRow,startingCol,1);
  }


  /**@throws IllegalStateException when the board contains non-zero values. 
     @throws IllegalArgumentException when either parameter is negative 
     or out of bounds.
  
  public int countSolutions(int startingRow, int startingCol){
    if(startingRow<0&&startingCol<0&&startingRow>=board.length&&startingCol>=board[0].length){
      throw new IllegalArgumentException();
    }
    return counter(startingRow,startingCol,1);
  }
  private boolean solver(int r ,int c, int level){
    if(board[r][c]>0){
      throw new IllegalStateException();
    }
    if(level==board.length*board[0].length){
      board[r][c]=level;
	    return true;
    }
    for(int i=0;i<8;i++){
      int rInc=possibleMoves(r,c,i)[0];
      int cInc=possibleMoves(r,c,i)[1];
      if(r+rInc<board.length&&c+cInc<board[0].length&&r+rInc>=0&&c+cInc>=0&&board[r+rInc][c+cInc]!=0){
        board[r][c]=level;
        if(solver(r+rInc,c+cInc,level+1)){
          return true;
        }
        else{
          board[r][c]=0;
        }
      }
    }
    return false;
  }
    private int counter(int r ,int c, int level){
      if(board[r][c]>0){
      throw new IllegalStateException();
    }
    int sum=0;
    if(level>=board.length*board[0].length){

      return 1;
    }
    for(int i=0;i<8;i++){
      if(possibleMoves(r,c,i)[0]!=board.length&&possibleMoves(r,c,i)[1]!=board[0].length){
        board[r][c]=level;
        sum+=counter(possibleMoves(r,c,i)[0],possibleMoves(r,c,i)[1],level+1);
        board[r][c]=0;
      }
    }
    return sum;
  }
  */
  private int[][] possibleMoves(int r, int c){
    int[][] sols=new int[8][2];
    int x=r;
    int y=c;
    int count=0;
    int incR=2;
    int incC=1;
    for(int i=0;i<8;i++){
	    if(i==1||i==5){
        incC=0-incC;
	    }
	    if(i==2||i==6){
        incR=0-incR;
	    }
	    if(i==3||i==7){
        incC=0-incC;
	    }
	    if(i==4){
        incC=2;
        incR=1;
	    }
      if(r+incR<board.length&&c+incC<board[0].length&&c+incC>=0&&r+incR>=0&&board[r+incR][c+incC]==0){
        sols[count][0]=r+incR;
        sols[count][1]=c+incC;
      }
      else{
        sols[count][0]=board.length;
        sols[count][1]=board[0].length;
      }
	    count+=1;
    }
    return sols;
  }
  /**
    @throws IllegalStateException when the board contains non-zero values.
    @throws IllegalArgumentException when either parameter is negative 
    or out of bounds.
  */
  public boolean solve(int startingRow, int startingCol){
    if(startingRow<0&&startingCol<0&&startingRow>=board.length&&startingCol>=board[0].length){
      throw new IllegalArgumentException();
    }
    return solver(startingRow,startingCol,1);
  }


  /**@throws IllegalStateException when the board contains non-zero values. 
     @throws IllegalArgumentException when either parameter is negative 
     or out of bounds.
  */
  public int countSolutions(int startingRow, int startingCol){
    if(startingRow<0&&startingCol<0&&startingRow>=board.length&&startingCol>=board[0].length){
      throw new IllegalArgumentException();
    }
    return counter(startingRow,startingCol,1);
  }
  private boolean solver(int r ,int c, int level){
    if(board[r][c]>0){
      throw new IllegalStateException();
    }
    if(level==board.length*board[0].length){
      board[r][c]=level;
	    return true;
    }
    for(int i=0;i<possibleMoves(r,c).length;i++){
      if(possibleMoves(r,c)[i][0]!=board.length||possibleMoves(r,c)[i][1]!=board[0].length){
        board[r][c]=level;
        if(solver(possibleMoves(r,c)[i][0],possibleMoves(r,c)[i][1],level+1)){
          return true;
        }
        else{
          board[r][c]=0;
        }
      }
    }
    return false;
  }
    private int counter(int r ,int c, int level){
     if(board[r][c]>0){
      throw new IllegalStateException();
    }
    int sum=0;
    if(level>=board.length*board[0].length){
	    return 1;
    }
    for(int i=0;i<possibleMoves(r,c).length;i++){
      if(possibleMoves(r,c)[i][0]!=board.length||possibleMoves(r,c)[i][1]!=board[0].length){
        board[r][c]=level;
        sum+=counter(possibleMoves(r,c)[i][0],possibleMoves(r,c)[i][1],level+1);
        board[r][c]=0;
      }
    }
    return sum;
  }

  public static void main(String[] args){
    KnightBoard k= new KnightBoard(5, 5);
    System.out.println(k.solve(1,1));
    System.out.println(k);
  }
}
