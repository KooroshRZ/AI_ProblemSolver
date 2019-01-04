package main;

import resources.Node;
import resources.Problem;
import resources.State;
import searchers.BDSearcher;
import utilities.GSException;

import java.util.Vector;

class P1b {

    private Problem p1 = Problem1.initialize();

    private BDSearcher bds = new BDSearcher(p1, new State(new int[][]{
            {0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1}
    }));

    void run(){

        Node res = null;
        try {
            res = bds.search();
        } catch (GSException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("BDS: ");
        System.out.println("*********************");
        System.out.println((res != null ? " Path Cost: " +  res.getPathCost() + " " : "NOT FOUND ") + bds.toString() );
        Vector<State> solution = Problem.solution(res);
        if (!solution.isEmpty())
            for(State n : solution) {
                n.printState();
                System.out.println("*********************");
            }
    }
}
