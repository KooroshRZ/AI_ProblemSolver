package main;

import resources.Node;
import resources.Problem;
import resources.State;
import searchers.HCSearcher;
import utilities.GSException;

import java.util.Vector;

class P4 {

    private Problem p4 = Problem4.initialize();

    private HCSearcher hcs = new HCSearcher(p4);


    void run(){

        Node res = null;
//        hcs.setFirstChoiceHillClimbing(true);
//        hcs.setSimpleHillCliming(true);
        hcs.setStochasticHillClimbing(true);

        try {
            res = hcs.search();
        } catch (GSException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("HCS: ");
        System.out.println("*********************");
        res.getState().printState();

    }
}
