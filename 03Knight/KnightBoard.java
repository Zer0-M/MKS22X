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

    public boolean solve(){
	int midR=board.length/2;
	int midC=board[0].length/2;
	return solver(midR,midC,1);
    }
    public int countSolutions(){
	return 0;
    }
    private boolean solver(int row ,int col, int level){
	return false;
    }
    public static void main(String[] args){
	KnightBoard k= new KnightBoard(3,2);
	System.out.println(k);
	k.solve();
	System.out.println(k);
    }
}
