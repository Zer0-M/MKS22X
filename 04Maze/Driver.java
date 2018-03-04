import java.io.*;
public class Driver{

    public static void main(String[]args){
        try{
        Maze f;
        f = new Maze("data7.dat");//true animates the maze.
        
        f.setAnimate(false);
        System.out.println(f.solve());

        System.out.println(f);}catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
    }
}
