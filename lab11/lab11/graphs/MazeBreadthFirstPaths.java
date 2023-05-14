package lab11.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private Queue<Integer> queue;


    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        // Add more variables here!
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        queue = new ArrayDeque<Integer>(maze.V());
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs(int v) {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
        marked[s] = true;
        announce();
        if (v == t) {
            targetFound = true;
            return;
        }
        for (int w : maze.adj(v)) {
            queue.add(w);
            edgeTo[w] = v;
            marked[w] = true;
            announce();
            distTo[w] = distTo[v] + 1;
            if (w == t) {
                targetFound = true;
            }
            if (targetFound) {
                return;
            }
        }

        while (!queue.isEmpty()){
            int pop = queue.remove();
            for (int w : maze.adj(pop)) {
                if (!marked[w]) {
                    queue.add(w);
                    edgeTo[w] = pop;
                    marked[w] = true;
                    distTo[w] = distTo[pop] + 1;
                    announce();
                    if (w == t) {
                        targetFound = true;
                    }
                    if (targetFound){
                        return;
                    }
                }
            }
        }

    }


    @Override
    public void solve() {
        bfs(s);
    }
}

