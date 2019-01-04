package main;

import resources.Node;
import resources.Problem;
import resources.State;
import searchers.AStarSearcher;
import utilities.GSException;

import java.util.Vector;

class P2d {

    private Problem p2 = Problem2.initialize();

    private AStarSearcher aStarSearcher = new AStarSearcher(p2);

    void run(){

        Node res = null;
        try {
            res = aStarSearcher.search();
        } catch (GSException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A*: ");
        System.out.println("*********************");
        System.out.println((res != null ? " Path Cost: " +  res.getPathCost() + " " : "NOT FOUND ") + aStarSearcher.toString() );
        Vector<State> solution = Problem.solution(res);
        if (!solution.isEmpty())
            for(State n : solution) {
                n.printState();
                System.out.println("*********************");
            }
    }

}
