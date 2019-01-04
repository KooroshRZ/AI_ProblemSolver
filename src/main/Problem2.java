package main;

import resources.Action;
import resources.Node;
import resources.Problem;
import resources.State;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Problem2 {

    static Problem initialize(){

        return new Problem() {
            @Override
            public State initialState() {
                return new State(new int[][]{
                        {0, 1, 2},
                        {4, 5, 3},
                        {7, 8, 6}
                });
            }

            @Override
            public List<Action> actions(State s) {
                List<Action> actions = new CopyOnWriteArrayList<>();
                int row = -1;
                int col = -1;

                int [][] status = (int [][]) s.getStatus();
                for (int i = 0; i < status.length; i++) {
                    for (int j = 0; j < status[i].length; j++) {
                        if (status[i][j] == 0) {
                            row = i;
                            col = j;
                        }
                    }
                }
                if (col == 0)
                    actions.add(new Action("RIGHT", 1));
                else if (col == status.length-1)
                    actions.add(new Action("LEFT", 1));
                else if (col > 0 && col < status.length-1){
                    actions.add(new Action("RIGHT", 1));
                    actions.add(new Action("LEFT", 1));
                }
                if (row == 0)
                    actions.add(new Action("DOWN", 1));
                else if (row == status.length-1)
                    actions.add(new Action("UP", 1));
                else if (row > 0 && row < status.length-1){
                    actions.add(new Action("DOWN", 1));
                    actions.add(new Action("UP", 1));
                }
                return actions;
            }

            @Override
            public State result(State s, Action a) {

                int[][] puzzle = (int [][]) s.getStatus();
                int row = -1, col =  -1;
                int [][] copy = new int[3][3];

                for (int i = 0; i < puzzle.length; i++) {
                    for (int j = 0; j < puzzle[i].length; j++) {
                        if (puzzle[i][j] == 0){
                            row = i;
                            col = j;
                        }
                        copy[i][j] = puzzle[i][j];
                    }
                }

                switch ((String)a.getData()){
                    case "UP":
                        copy[row][col] = copy[row-1][col];
                        copy[row-1][col] = 0;
                        break;
                    case "DOWN":
                        copy[row][col] = copy[row+1][col];
                        copy[row+1][col] = 0;
                        break;
                    case "LEFT":
                        copy[row][col] = copy[row][col-1];
                        copy[row][col-1] = 0;
                        break;
                    case "RIGHT":
                        copy[row][col] = copy[row][col+1];
                        copy[row][col+1] = 0;
                        break;
                }

                return new State(copy);
            }

            @Override
            public boolean goalTest(State s) {

                int[][] puzzle = (int[][]) s.getStatus();

                for (int i = 0; i < puzzle.length; i++)
                    for (int j = 0; j < puzzle[i].length; j++)
                        if (puzzle[i][j] != (i * (puzzle.length) + j + 1) % 9 ) return false;

                return true;
            }

            @Override
            public double actionCost(State s, Action a) {
                return 1;
            }

            @Override
            public double pathCost(Node n) {
                Node p = n.getParent();
                double cost = n.getPathCost();
                while(p != null){
                    cost += p.getPathCost();
                    p = p.getParent();
                }
                return cost;
            }

            @Override
            public double heuristic(State s) {
                int h = 0;
                int[][] puzzle = (int [][]) s.getStatus();
                for (int i = 0; i < puzzle.length; i++)
                    for (int j = 0; j < puzzle.length; j++)
                        h += Math.abs( ( (puzzle[i][j] - (j + 1) ) / puzzle.length ) - ( puzzle[i][j] - (i * puzzle.length) - 1 ) );
                return h;
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
