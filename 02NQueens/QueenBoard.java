public class QueenBoard{
    private int[][]board;
    public QueenBoard(int size){
	board=new int[size][size];
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
  
    /**
     *@return false when the board is not solveable and leaves the board filled with zeros; 
     *        true when the board is solveable, and leaves the board in a solved state
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public boolean solve(){
	return true;
    }
  
    /**
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public int countSolutions(){
	return 0;
    }
    public static void main(String[] arg){	
	for(int i=1;i<6;i++){
	    QueenBoard q=new QueenBoard(i);
	    System.out.println(q);
	    System.out.println(q.solve());
	    System.out.println(q.countSolutions());
	}
    }
  

}
