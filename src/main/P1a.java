package main;

import resources.Node;
import resources.Problem;
import resources.State;
import searchers.BFSearcher;
import utilities.GSException;

import java.util.Vector;

class P1a {

    private Problem p1 = Problem1.initialize();

    private BFSearcher bfs = new BFSearcher(p1);

    void run(){

        Node res = null;
        try {
            res = bfs.search();
        } catch (GSException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("BFS: ");
        System.out.println("*********************");
        System.out.println((res != null ? " Path Cost: " +  res.getPathCost() + " " : "NOT FOUND ") + bfs.toString() );
        Vector<State> solution = Problem.solution(res);
        if (!solution.isEmpty())
            for(State n : solution) {
                n.printState();
                System.out.println("*********************");
            }
    }

}
