package main;

import resources.Node;
import resources.Problem;
import resources.State;
import searchers.DFSearcher;
import utilities.GSException;

import java.util.Vector;

class P3b {

    private Problem p2 = Problem3.initialize();

    private DFSearcher dfs = new DFSearcher(p2);

    void run(){

        Node res = null;
        dfs.setIterating(true);
        dfs.setDepthLimit(5);
        dfs.setIteratingMaxDepth(5);

        try {
            res = dfs.search();
        } catch (GSException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DFS: ");
        System.out.println("*********************");
        System.out.println((res != null ? " Path Cost: " +  res.getPathCost() + " " : "NOT FOUND ") + dfs.toString() );
        Vector<State> solution = Problem.solution(res);
        if (!solution.isEmpty())
            for(State n : solution) {
                n.printState();
                System.out.println("*********************");
            }
    }

}
