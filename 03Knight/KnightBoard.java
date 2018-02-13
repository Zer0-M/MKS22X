public class KnightBoard{
    int[][] board
    public KnightBoard(int startingRows,int startingCols){
	board=new int[startingRows,startingCols];
    }
    //non square is required!

    public String toString(){
	return "";
    }

    public boolean solve(){
	return false;
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
