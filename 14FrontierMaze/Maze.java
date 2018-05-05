import java.util.*;
import java.io.*;
public class Maze{
    private Location start,end;
    private char[][] maze;
    
    public Maze(String filename) {
        int Scount=0;
        int Ecount=0;
        try{
            File text = new File(filename);
            Scanner inf = new Scanner(text);
            String m="";
            int count=1;
            int n=0;
            if(inf.hasNextLine()){
                String line = inf.nextLine();
                n=line.length();
                m+=line;
            }
            while(inf.hasNextLine()){
                String line = inf.nextLine();
                m+=line;
                count+=1;
            }
            maze=new char[count][n];
            int counter=0;
            for(int i=0;i<count ;i++){
                for(int j=0;j<n;j++){
                    maze[i][j]=m.charAt(counter);
                    if(maze[i][j]=='S'){
                        Scount++;
                        start=new Location(i,j,null);
                    }
                    if(maze[i][j]=='E'){
                        Ecount++;
                        end=new Location(i,j,null);
                    }
                    counter++;
                }
                
            }
            if(Ecount>1||Ecount==0){
                throw new IllegalStateException();
            }
            if(Scount>1||Scount==0){
                throw new IllegalStateException();
            }
        }catch(FileNotFoundException f){
            System.exit(0);
            System.out.println("file not found");
        }
    }
    
    // '#' - wall 
    // ' ' - open space
    // '?' - frontier space
    // '.' - visited space
    // 'E' - end space (do not replace this)
    // '@' - part of solution
    // 'S' - starting space (do not replace this)
    public String toString(){
        String str="";
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                str+=maze[i][j];
            }
            str+="\n";
        }
        return str;
    }
    private static String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }
    private static String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }
    public static String colorize(String s){
        String ans = "";
        Scanner in = new Scanner(s);
        while(in.hasNext()){
            String line ="";
            for(char c : in.nextLine().toCharArray()){
                if(c == '#'){
                    line+= color(37,47)+c;
                }
                else if(c == '@'){
                    line+= color(33,40)+c;
                }
                else if(c == '?'){
                    line+= color(37,42)+c;
                }
                else if(c == '.'){
                    line+= color(36,40)+c;
                }
                else if(c == ' '){
                    line+= color(35,40)+c;
                }else{
                    line+=color(37,40)+c;
                }
                
            }
            ans += line+color(37,40)+"\n";
        }
        return ans;
    }
    // Work on this method as a group! 
    public String toStringColor(){
        return colorize(toString());
    }
    public void changeStatus(Location n,char c){
		int row=n.getX();
        int col=n.getY();
        maze[row][col]=c;
    }
    //return a list of Locations that are:
    // adjacent to n and  not visited
    // all the Locations in this list should have their previous set to n.
    public Location[] getNeighbors(Location n){
        Location[] neighbors=new Location[4];
        int row=n.getX();
        int col=n.getY();
        Location up,down,right,left;
        if(row+1<maze.length&&(maze[row+1][col]==' '||maze[row+1][col]=='E')){
            up=new Location(row+1,col,n);
            neighbors[0]=up;
        }
        if(col+1<maze[row].length&&(maze[row][col+1]==' '||maze[row][col+1]=='E')){
            right=new Location(row,col+1,n);
            neighbors[3]=right;
        }
        if(row-1>=0&&(maze[row-1][col]==' '||maze[row-1][col]=='E')){
            down=new Location(row-1,col,n);
            neighbors[1]=down;
        }
        if(col-1>=0&&(maze[row][col-1]==' '||maze[row][col-1]=='E')){
            left=new Location(row,col-1,n);
            neighbors[2]=left;
        }
        return neighbors;
    }
    
    public Location getStart(){
        return start;
    }
    
    public Location getEnd(){
        return end;
    }
    public static void main(String[] args){
        Maze m = new Maze("data1.dat");
        System.out.println(m);
        System.out.println(Arrays.toString(m.getNeighbors(m.getStart())));

    }
    
    
}
