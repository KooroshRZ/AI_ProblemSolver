package main;

import resources.Action;
import resources.Node;
import resources.Problem;
import resources.State;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Problem5 {

    static Problem initialize(){

        return new Problem() {
            @Override
            public State initialState() {

                return new State( new int[][]{
                        {3,5,2,6,2,3,2,4,4},
                        {1,1,5,5,5,2,3,1,3},
                        {3,3,5,3,3,3,4,2,5},
                        {6,5,1,1,1,6,6,5,6},
                        {5,1,2,4,4,4,2,6,1},
                        {1,2,4,2,6,4,4,6,6}
                });

            }

            @Override
            public List<Action> actions(State s) {

                List<Action> actions = new CopyOnWriteArrayList<>();

                actions.add(new Action("U", 1));
                actions.add(new Action("UP", 1));
                actions.add(new Action("D", 1));
                actions.add(new Action("DP", 1));
                actions.add(new Action("R", 1));
                actions.add(new Action("RP", 1));
                actions.add(new Action("L", 1));
                actions.add(new Action("LF", 1));
                actions.add(new Action("F", 1));
                actions.add(new Action("FP", 1));
                actions.add(new Action("B", 1));
                actions.add(new Action("BP", 1));

                return actions;

            }

            @Override
            public State result(State s, Action a) {

                int[][] rubik = (int[][]) s.getStatus();
                int[][] copy = new int[rubik.length][rubik[0].length];

                for (int i = 0; i < rubik.length; i++)
                    System.arraycopy(rubik[i], 0, copy[i], 0, rubik[i].length);

                int [] tmp = {0,0,0};

                switch ((String) a.getData()){
                    case "U":
                        System.arraycopy(copy[3], 0, tmp, 0, 3);

                        for (int i = 0; i < 3; i++) {
                            copy[3][i] = copy[2][i];
                            copy[2][i] = copy[1][i];
                            copy[1][i] = copy[5][6+i];
                            copy[5][6+i] = tmp[2-i];
                        }
                        break;
                    case "UP":
                        System.arraycopy(copy[3], 0, tmp, 0, 3);

                        for (int i = 0; i < 3; i++) {
                            copy[3][i] = copy[5][8-i];
                            copy[5][8-i] = copy[1][i];
                            copy[1][i] = copy[2][i];
                            copy[2][i] = tmp[i];
                        }
                        break;
                    case "D":

                        System.arraycopy(copy[3], 6, tmp, 0, 3);
                        for (int i = 0; i < 3; i++) {
                            copy[3][6+i] = copy[2][6+i];
                            copy[2][6+i] = copy[1][6+i];
                            copy[1][6+i] = copy[5][2-i];
                            copy[5][2-i] = tmp[2-i];
                        }

                        break;
                    case "DP":
                        System.arraycopy(copy[3], 6, tmp, 0, 3);
                        for (int i = 0; i < 3; i++) {
                            copy[3][6+i] = copy[5][2-i];
                            copy[5][2-i] = copy[1][6+i];
                            copy[1][6+i] = copy[2][6+i];
                            copy[2][6+i] = tmp[i];
                        }
                        break;
                    case "R":
                        break;
                    case "RP":
                        break;
                    case "L":
                        break;
                    case "LP":
                        break;
                    case "F":
                        break;
                    case "FP":
                        break;
                    case "B":
                        break;
                    case "BP":
                        break;
                }

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
                return 0;
            }

            @Override
            public int checkStatus(List<Node> l, State s) {
                return 0;
            }

        };
    }

}
