package main;

import resources.Action;
import resources.Node;
import resources.Problem;
import resources.State;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Problem1 {

    static Problem initialize(){

        return new Problem() {
            @Override
            public State initialState() {
                return new State(new int[][]{
                        {0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}
                });
            }

            @Override
            public List<Action> actions(State s) {

                List<Action> actions = new CopyOnWriteArrayList<>();
                int [][] spots = (int[][]) s.getStatus();

                switch (spots[0][0]){
                    case 0:
                        switch (spots[0][1]){
                            case 0:
                                actions.add(new Action(new int[]{0, 1}, 0));
                                actions.add(new Action(new int[]{0, 10}, 0));
                                actions.add(new Action(new int[]{0, 100}, 0));
                                actions.add(new Action(new int[]{0, 1000}, 0));
                                actions.add(new Action(new int[]{0, 2}, 0));
                                actions.add(new Action(new int[]{0, 20}, 0));
                                actions.add(new Action(new int[]{0, 200}, 0));
                                actions.add(new Action(new int[]{0, 2000}, 0));
                                actions.add(new Action(new int[]{1, 1}, 0));
                                actions.add(new Action(new int[]{1, 10}, 0));
                                actions.add(new Action(new int[]{1, 100}, 0));
                                actions.add(new Action(new int[]{1, 1000}, 0));
                                actions.add(new Action(new int[]{1, 2}, 0));
                                actions.add(new Action(new int[]{1, 20}, 0));
                                actions.add(new Action(new int[]{1, 200}, 0));
                                actions.add(new Action(new int[]{1, 2000}, 0));
                                break;
                            case 1:
                                actions.add(new Action(new int[]{0, 2}, 0));
                                actions.add(new Action(new int[]{0, 10}, 0));
                                actions.add(new Action(new int[]{0, 100}, 0));
                                actions.add(new Action(new int[]{0, 1000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            case 2:
                                actions.add(new Action(new int[]{0, 1}, 0));
                                actions.add(new Action(new int[]{0, 20}, 0));
                                actions.add(new Action(new int[]{0, 200}, 0));
                                actions.add(new Action(new int[]{0, 2000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            case 10:
                                actions.add(new Action(new int[]{0, 20}, 0));
                                actions.add(new Action(new int[]{0, 1}, 0));
                                actions.add(new Action(new int[]{0, 100}, 0));
                                actions.add(new Action(new int[]{0, 1000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            case 20:
                                actions.add(new Action(new int[]{0, 10}, 0));
                                actions.add(new Action(new int[]{0, 2}, 0));
                                actions.add(new Action(new int[]{0, 200}, 0));
                                actions.add(new Action(new int[]{0, 2000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            case 100:
                                actions.add(new Action(new int[]{0, 200}, 0));
                                actions.add(new Action(new int[]{0, 1}, 0));
                                actions.add(new Action(new int[]{0, 10}, 0));
                                actions.add(new Action(new int[]{0, 1000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            case 200:
                                actions.add(new Action(new int[]{0, 100}, 0));
                                actions.add(new Action(new int[]{0, 2}, 0));
                                actions.add(new Action(new int[]{0, 20}, 0));
                                actions.add(new Action(new int[]{0, 2000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            case 1000:
                                actions.add(new Action(new int[]{0, 2000}, 0));
                                actions.add(new Action(new int[]{0, 1}, 0));
                                actions.add(new Action(new int[]{0, 10}, 0));
                                actions.add(new Action(new int[]{0, 100}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            case 2000:
                                actions.add(new Action(new int[]{0, 1000}, 0));
                                actions.add(new Action(new int[]{0, 2}, 0));
                                actions.add(new Action(new int[]{0, 20}, 0));
                                actions.add(new Action(new int[]{0, 200}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                        }
                        break;
                    case 1:
                        switch (spots[0][1]){
                            case 0:
                                actions.add(new Action(new int[]{1, 2}, 0));
                                actions.add(new Action(new int[]{1, 10}, 0));
                                actions.add(new Action(new int[]{1, 100}, 0));
                                actions.add(new Action(new int[]{1, 1000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            default:
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                        }
                        break;
                    case 2:
                        switch (spots[0][1]){
                            case 0:
                                actions.add(new Action(new int[]{1, 1}, 0));
                                actions.add(new Action(new int[]{1, 20}, 0));
                                actions.add(new Action(new int[]{1, 200}, 0));
                                actions.add(new Action(new int[]{1, 2000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            default:
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                        }
                        break;
                    case 10:
                        switch (spots[0][1]){
                            case 0:
                                actions.add(new Action(new int[]{1, 20}, 0));
                                actions.add(new Action(new int[]{1, 1}, 0));
                                actions.add(new Action(new int[]{1, 100}, 0));
                                actions.add(new Action(new int[]{1, 1000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            default:
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                        }
                        break;
                    case 20:
                        switch (spots[0][1]){
                            case 0:
                                actions.add(new Action(new int[]{1, 10}, 0));
                                actions.add(new Action(new int[]{1, 2}, 0));
                                actions.add(new Action(new int[]{1, 200}, 0));
                                actions.add(new Action(new int[]{1, 2000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            default:
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                        }
                        break;
                    case 100:
                        switch (spots[0][1]){
                            case 0:
                                actions.add(new Action(new int[]{1, 200}, 0));
                                actions.add(new Action(new int[]{1, 1}, 0));
                                actions.add(new Action(new int[]{1, 10}, 0));
                                actions.add(new Action(new int[]{1, 1000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            default:
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                        }
                        break;
                    case 200:
                        switch (spots[0][1]){
                            case 0:
                                actions.add(new Action(new int[]{1, 100}, 0));
                                actions.add(new Action(new int[]{1, 2}, 0));
                                actions.add(new Action(new int[]{1, 20}, 0));
                                actions.add(new Action(new int[]{1, 2000}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            default:
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                        }
                        break;
                    case 1000:
                        switch (spots[0][1]){
                            case 0:
                                actions.add(new Action(new int[]{1, 2000}, 0));
                                actions.add(new Action(new int[]{1, 1}, 0));
                                actions.add(new Action(new int[]{1, 10}, 0));
                                actions.add(new Action(new int[]{1, 100}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            default:
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                        }
                        break;
                    case 2000:
                        switch (spots[0][1]){
                            case 0:
                                actions.add(new Action(new int[]{1, 1000}, 0));
                                actions.add(new Action(new int[]{1, 2}, 0));
                                actions.add(new Action(new int[]{1, 20}, 0));
                                actions.add(new Action(new int[]{1, 200}, 0));
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                            default:
                                actions.add(new Action(new int[]{3, 0}, 0));
                                break;
                        }
                        break;
                }

                for (Action a : actions){
                    int[] tmp = (int[]) a.getData();
                    int pos = -1;
                    switch (tmp[1]){
                        case 1:
                            pos = 0;
                            break;
                        case 2:
                            pos = 1;
                            break;
                        case 10:
                            pos = 2;
                            break;
                        case 20:
                            pos = 3;
                            break;
                        case 100:
                            pos = 4;
                            break;
                        case 200:
                            pos = 5;
                            break;
                        case 1000:
                            pos = 6;
                            break;
                        case 2000:
                            pos = 7;
                            break;
                    }


                    if (pos != -1 && spots[1][pos] == 1)
                        actions.remove(a);

                }

                return actions;
            }

            @Override
            public State result(State s, Action a) {

                int [][] spots = (int[][]) s.getStatus();
                int [][] copy = new int[][]{
                        {0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}
                };

                System.arraycopy(spots[0], 0, copy[0], 0, 3);
                System.arraycopy(spots[1], 0, copy[1], 0, 8);

                int [] act = ((int[])a.getData());
                int pos1 = -1, pos2;

                switch (spots[0][0]){
                    case 1:
                        pos1 = 0;
                        break;
                    case 2:
                        pos1 = 1;
                        break;
                    case 10:
                        pos1 = 2;
                        break;
                    case 20:
                        pos1 = 3;
                        break;
                    case 100:
                        pos1 = 4;
                        break;
                    case 200:
                        pos1 = 5;
                        break;
                    case 1000:
                        pos1 = 6;
                        break;
                    case 2000:
                        pos1 = 7;
                        break;
                    default:
                        break;
                }

                switch (spots[0][1]){
                    case 1:
                        pos2 = 0;
                        break;
                    case 2:
                        pos2 = 1;
                        break;
                    case 10:
                        pos2 = 2;
                        break;
                    case 20:
                        pos2 = 3;
                        break;
                    case 100:
                        pos2 = 4;
                        break;
                    case 200:
                        pos2 = 5;
                        break;
                    case 1000:
                        pos2 = 6;
                        break;
                    case 2000:
                        pos2 = 7;
                        break;
                    default:
                        pos2 = pos1;
                        break;
                }

                if (pos1==-1)
                    pos1 = pos2;

                switch (act[0]){
                    case 0:
                        copy[0][0] = act[1];
                        break;
                    case 1:
                        copy[0][1] = act[1];
                        break;
                    case 3:
                        copy[1][pos1] = 1;
                        copy[1][pos2] = 1;
                        copy[0][0] = 0;
                        copy[0][1] = 0;
                        copy[0][2]++;

                        break;
                }

                return new State(copy);
            }

            @Override
            public boolean goalTest(State s) {

                for (int i = 0; i < 8; i++)
                    if ( ( (int[][])s.getStatus() )[1][i] == 0)
                        return false;
                return true;
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
                int [][] puzzle = (int[][]) s.getStatus();
                boolean[] flags = new boolean[l.size()];

                for (int k = 0; k < l.size(); k++)
                    flags[k] = false;

                int k = 0;
                for (Node n: l) {

                    int[][] temp = (int[][]) (n.getState().getStatus());
                    for (int i = 0; i < puzzle.length; i++)
                        for (int j = 0; j < puzzle.length; j++)
                            if (puzzle[i][j] != temp[i][j]) flags[k]=true;
                    k++;
                }

                for (int i = 0; i < l.size(); i++)
                    if (!flags[i]) return i;

                return -1;
            }
        };
    }

}
