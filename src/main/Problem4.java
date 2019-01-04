package main;

import resources.Action;
import resources.Node;
import resources.Problem;
import resources.State;

import java.util.List;
import java.util.Random;

class Problem4 {

    static Problem initialize(){

        return new Problem() {
            @Override
            public State initialState() {

                int length = 3;
                Random r = new Random();
                int [] array = new int[3*length];
                for (int i = 0; i < array.length; i ++)
                    array[i] = r.nextInt(10);
                return new State(array);
            }

            @Override
            public List<Action> actions(State s) {
                return null;
            }

            @Override
            public State result(State s, Action a) {
                return null;
            }

            @Override
            public boolean goalTest(State s) {
                return false;
            }

            @Override
            public double actionCost(State s, Action a) {
                return 0;
            }

            @Override
            public double pathCost(Node n) {
                return 0;
            }

            @Override
            public double heuristic(State s) {

                int [] queue = (int[]) s.getStatus();
                int max = 0;
                for (int i = 0; i < queue.length; i+=3)
                    if (queue[i] + queue[i+1] + queue[i+2] > max) max = queue[i] + queue[i+1] + queue[i+2];

                return max;
            }

            @Override
            public int checkStatus(List<Node> l, State s) {
                return 0;
            }

        };

    }

}
