package main;

import resources.Action;
import resources.Node;
import resources.Problem;
import resources.State;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

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

                new State(array).printState();
                return new State(array);
            }

            @Override
            public List<Action> actions(State s) {

                int[] queue = (int[]) s.getStatus();
                List<Action> actions = new CopyOnWriteArrayList<>();

                for (int i = 0; i < queue.length-1; i++)
                    for (int j = i+1; j < queue.length; j++)
                    actions.add(new Action(new int[]{i,j}, 1));

                return actions;
            }

            @Override
            public State result(State s, Action a) {

                int[] queue = (int[]) s.getStatus();
                int[] copy = new int[queue.length];

                System.arraycopy(queue, 0, copy, 0, queue.length);

                int temp = copy[ ((int[]) a.getData())[0]];
                copy[ ((int[]) a.getData())[0]] = copy[ ((int[]) a.getData())[1]];
                copy[ ((int[]) a.getData())[1]] = temp;

                return new State(copy);
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
