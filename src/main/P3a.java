package main;

import resources.Node;
import resources.Problem;
import resources.State;
import searchers.UCSearcher;
import utilities.GSException;

import java.util.Vector;

class P3a {

    private Problem p3 = Problem3.initialize();

    private UCSearcher ucs = new UCSearcher(p3);

    void run(){

        Node res = null;
        try {
            res = ucs.search();
        } catch (GSException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("UCS: ");
        System.out.println("*********************");
        System.out.println((res != null ? " Path Cost: " +  res.getPathCost() + " " : "NOT FOUND ") + ucs.toString() );
        Vector<State> solution = Problem.solution(res);
        if (!solution.isEmpty())
            for(State n : solution) {
                n.printState();
                System.out.println("*********************");
            }
    }

}
