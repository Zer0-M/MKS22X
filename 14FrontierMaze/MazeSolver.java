public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
  
    public MazeSolver(String mazeText){
      maze=new Maze(mazeText);
    }
  
    //Default to BFS
    public boolean solve(){ return solve(0); }
  
    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    private boolean hasNeighbors(Location l){
        Location[] n=maze.getNeighbors(l);
        for(int i=0;i<4;i++){
            if(n[i]!=null){
                return true;
            }
        }
        return false;
    }
    public boolean solve(int mode){
        if(mode==0){
            frontier=new FrontierQueue();
            frontier.add(maze.getStart());
            while(frontier.hasNext()){
                Location next=frontier.next();
                maze.changeStatus(next, '.');
                if(next.getX()==maze.getEnd().getX()&&next.getY()==maze.getEnd().getY()){
                    //System.out.println(next);
                    while(next.getPrev()!=null){
                        maze.changeStatus(next, '@');
                        next=next.getPrev();
                    }
                    maze.changeStatus(maze.getStart(),'S');
                    maze.changeStatus(maze.getEnd(),'E');
                    return true;
                }
                if(hasNeighbors(next)){
                    for(int i=0;i<4;i++){
                        if(maze.getNeighbors(next)[i]!=null){
                            frontier.add(maze.getNeighbors(next)[i]);
                            maze.changeStatus(maze.getNeighbors(next)[i], '?');
                        }
                    }
                }
                //System.out.println(frontier);
                //System.out.println(frontier.hasNext());

	        }
        }
      //initialize your frontier
      //while there is stuff in the frontier:
      //  get the next location
      //  process the location to find the locations (use the maze to do this)
      //  check if any locations are the end, if you found the end just return true!
      //  add all the locations to the frontier
      //when there are no more values in the frontier return false
      return false;
    }
  
    public String toString(){
      return maze.toString();
    }
    public static void main(String[] args){
        MazeSolver m = new MazeSolver("data7.dat");
        m.solve();
        System.out.println(m);
    }
  }