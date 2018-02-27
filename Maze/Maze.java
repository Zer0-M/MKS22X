import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Maze {
  private char[][] maze;
  private  String m;
  public Maze() throws FileNotFoundException {
        File text = new File("Maze1.txt");
        Scanner inf = new Scanner(text);
        m="";
        int count=0;
        int n=0;
        if(inf.hasNextLine()){
          String line = inf.nextLine();
          n=line.length();
          m+=line;
        }
        m+="\n";
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            m+=line+"\n";
            count+=1;
        }
        maze=new char[count][n];
        int counter=0;
        for(int i=0;i<count ;i++){
          for(int j=0;j<n&&counter<m.length();j++){
            maze[i][j]=m.charAt(counter);
            counter++;
          }
         }
    }
  public String getString(){
    return m;
  }
  public char[][] getArray(){
    return maze;
  }
  public static void main(String[] args) throws FileNotFoundException{
    Maze mz=new Maze();
    System.out.println(Arrays.deepToString(mz.getArray()));
  }
}
