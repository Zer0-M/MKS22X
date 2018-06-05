public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean animate;
  
    public MazeSolver(String mazeText){
      maze=new Maze(mazeText);
      animate=false;
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
                if(animate){
                    clearTerminal();
                    System.out.println(this);
              
                    wait(100);
                }
                Location next=frontier.next();
                maze.changeStatus(next, '.');
                if(next.compareTo(maze.getEnd())==0){
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
        else if(mode==1){
            frontier=new FrontierStack();
            frontier.add(maze.getStart());
            while(frontier.hasNext()){
                if(animate){
                    clearTerminal();
                    System.out.println(this);
              
                    wait(100);
                }
                Location next=frontier.next();
                maze.changeStatus(next, '.');
                if(next.compareTo(maze.getEnd())==0){
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
            }
            
        }
        else if(mode==2){
            frontier=new FrontierPriorityQueue();
            frontier.add(maze.getStart());
            while(frontier.hasNext()){
                if(animate){
                    clearTerminal();
                    System.out.println(this);
                    
                    wait(100);
                }
                Location next=frontier.next();
                maze.changeStatus(next, '.');
		
                if(next.compareTo(maze.getEnd())==0){
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
            }
        }
	else if(mode==3){
	    maze.setAStar(true);
            frontier=new FrontierPriorityQueue();
            frontier.add(maze.getStart());
            while(frontier.hasNext()){
                Location next=frontier.next();
		
		if(animate){
                    clearTerminal();
                    System.out.println(this);
                    wait(100);
                }
                maze.changeStatus(next, '.');
		
                if(next.getX()==maze.getEnd().getX()&&next.getY()==maze.getEnd().getY()){
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
    private void wait(int millis){
        try {
          Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
      }
    
    
      public void clearTerminal(){
    
        //erase terminal, go to top left of screen.
    
        System.out.println("\033[2J\033[1;1H");
    
      }
    public String toString(){
      return maze.toString();
    }
    public static void main(String[] args){
        MazeSolver bfs = new MazeSolver("data7.dat");
        bfs.solve(0);
        MazeSolver dfs = new MazeSolver("data7.dat");
        dfs.solve(1);
        MazeSolver priority =new MazeSolver("data7.dat");
        priority.solve(2);
	MazeSolver AStar =new MazeSolver("data7.dat");
        System.out.println(AStar.solve(3));
        System.out.println("bfs");
        System.out.println(bfs);
        System.out.println("dfs");
        System.out.println(dfs);
        System.out.println("priority");
        System.out.println(priority);
        System.out.println("A*");
        System.out.println(AStar);
    }
  }
