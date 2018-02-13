import java.util.*;
public class QueenBoard{
    private int[][]board;
  private int countQueens;
    public QueenBoard(int size){
	board=new int[size][size];
  countQueens=0;
    }
    /**
     *@return The output string formatted as follows:
     *All numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     *There are spaces between each symbol:  
     *Q _ _ _
     *_ _ Q _
     * etc.
     */
    public String toString(){
      String Board="";
      for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
          if(board[i][j]<0){
            Board+="Q ";
          }
          else{
            Board+="_ ";
          }
        }
        Board+="\n";
      }
      return Board;
    }
  private boolean addQueen(int r, int c){
    if(board[r][c]==0){
      board[r][c]-=1;
      countQueens+=1;
      for(int i=c+1;i<board.length;i++){
        board[r][i]+=1;
      }
      for(int i=r+1, j=c+1;i<board.length&&j<board.length;i++, j++){
        board[i][j]+=1;
      }
      for(int i=r-1, j=c+1;j<board.length&&i>=0;i--, j++){
        board[i][j]+=1;
      }
      return true;
    }
    return false;
  }
    private boolean removeQueen(int r, int c){
      board[r][c]+=1;
      countQueens-=1;
      for(int i=c+1;i<board.length;i++){
        board[r][i]-=1;
      }
      for(int i=r+1, j=c+1;i<board.length&&j<board.length;i++, j++){
        board[i][j]-=1;
      }
      for(int i=r-1, j=c+1;j<board.length&&i>=0;i--, j++){
        board[i][j]-=1;
      }

    return true;

    }
  
    /**
     *@return false when the board is not solveable and leaves the board filled with zeros; 
     *        true when the board is solveable, and leaves the board in a solved state
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public boolean solve(){
      if(!addQueen(0,0)){
        throw new IllegalStateException();
      }
      removeQueen(0,0);
      return solver(0,0);
    }
  public boolean solver(int r,int c){
    //if((board.length==2||board.length==3)&&countQueens==board.length-1){
    //  return true;
    //}
    if(countQueens==board.length){
      return true;
    }
    for(int i=0;i<board.length;i++){
      if(addQueen(i,c)){
        if(solver(0,c+1)){
          return true;
        }
      else{
        removeQueen(i,c);
        }
      }
    }
    return false;
  }
  
    /**
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public int countSolutions(){
      if(!addQueen(0,0)){
        throw new IllegalStateException();
      }
      removeQueen(0,0);
      return counter(0,0);
    }
  public int counter(int r, int c){ 
    int sum=0;
    //if((board.length==2||board.length==3)&&countQueens==board.length-1){
    //  return 1;
    //}
    if(countQueens==board.length){
      return 1;
    }
    for(int i=0;i<board.length;i++){
      if(addQueen(i,c)){
        sum+=counter(0,c+1);
        removeQueen(i,c);
        }
      }
      return sum;
    
  }
    public static void main(String[] arg){
      for(int i=1;i<10;i++){
	    QueenBoard q=new QueenBoard(i);
	    System.out.println(q.countSolutions());
	    System.out.println(q);
      }
    }
  

}
