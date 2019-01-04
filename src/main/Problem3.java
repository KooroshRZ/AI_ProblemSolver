package main;

import resources.Action;
import resources.Node;
import resources.Problem;
import resources.State;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Problem3 {

    static Problem initialize(){

        return new Problem() {
            @Override
            public State initialState() {
                return new State(new int[][]{
                        {0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, -1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, -1, 0, 0},
                        {-1, 0, 0, -1, 0, 0, 0, 0},
                        {0, 0, 0, 0, -1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, -1, 0},
                        {0, 0, 0, 0, 2, 0, 0, 0},
                });
            }

            @Override
            public List<Action> actions(State s) {
                int[][] chessSet = (int[][]) s.getStatus();

                int row = -1, col = -1;
                for (int i = 0; i < chessSet.length; i++) {
                    for (int j = 0; j < chessSet[i].length; j++) {
                        if (chessSet[i][j] == 1 || chessSet[i][j] == 3) {
                            row = i;
                            col = j;
                        }
                    }
                }

                List<Action> actions = new CopyOnWriteArrayList<>();

                boolean upUpRight, upUpLeft,
                        upRightRight, upLeftLeft,
                        downDownRight, downDownLeft,
                        downRightRight, downLeftLeft;

                upUpRight = (((row - 2) > -1) && ((col + 1) < chessSet.length) && (chessSet[row-2][col+1] != -1) );
                upUpLeft = (((row - 2) > -1) && ((col - 1) > -1) && (chessSet[row-2][col-1] != -1) );
                upRightRight = (((row - 1) > -1) && ((col + 2) < chessSet.length) && (chessSet[row-1][col+2] != -1) );
                upLeftLeft = (((row - 1) > -1) && ((col - 2) > -1) && (chessSet[row-1][col-2] != -1) );

                downDownRight = (((row + 2) < chessSet.length) && ((col + 1) < chessSet.length) && (chessSet[row+2][col+1] != -1) );
                downDownLeft = (((row + 2) < chessSet.length) && ((col - 1) > -1) && (chessSet[row+2][col-1] != -1) );
                downRightRight = (((row + 1) < chessSet.length) && ((col + 2) < chessSet.length) && (chessSet[row+1][col+2] != -1) );
                downLeftLeft = (((row + 1) < chessSet.length) && (col - 2 > -1) && (chessSet[row+1][col-2] != -1) );

                if (upUpRight) actions.add(new Action("UpUpRight", 3));
                if (upUpLeft) actions.add(new Action("UpUpLeft", 3));
                if (upRightRight) actions.add(new Action("UpRightRight", 3));
                if (upLeftLeft) actions.add(new Action("UpLeftLeft", 3));
                if (downDownRight) actions.add(new Action("DownDownRight", 3));
                if (downDownLeft) actions.add(new Action("DownDownLeft", 3));
                if (downRightRight) actions.add(new Action("DownRightRight", 3));
                if (downLeftLeft) actions.add(new Action("DownLeftLeft", 3));

                return actions;
            }

            @Override
            public State result(State s, Action a) {


                int[][] chessSet = (int[][]) s.getStatus();
                int[][] copy = new int[chessSet.length][chessSet.length];
                int row = -1, col = -1;

                for (int i = 0; i < chessSet.length; i++)
                    System.arraycopy(chessSet[i], 0, copy[i], 0, chessSet[i].length);


                for (int i = 0; i < chessSet.length; i++) {
                    for (int j = 0; j < chessSet[i].length; j++) {
                        if (chessSet[i][j] == 1 || chessSet[i][j] == 3) {
                            row = i;
                            col = j;
                            copy[row][col] -= 1;
                        }

                    }
                }

                switch ((String) a.getData()) {

                    case "UpUpRight":
                        row -= 2;
                        col += 1;
                        break;
                    case "UpUpLeft":
                        row -= 2;
                        col -= 1;
                        break;
                    case "UpRightRight":
                        row -= 1;
                        col += 2;
                        break;
                    case "UpLeftLeft":
                        row -= 1;
                        col -= 2;
                        break;
                    case "DownDownRight":
                        row += 2;
                        col += 1;
                        break;
                    case "DownDownLeft":
                        row += 2;
                        col -= 1;
                        break;
                    case "DownRightRight":
                        row += 1;
                        col += 2;
                        break;
                    case "DownLeftLeft":
                        row += 1;
                        col -= 2;
                        break;
                }

                copy[row][col] += 1;

                return new State(copy);

            }

            @Override
            public boolean goalTest(State s) {

                int[][] chessSet = (int[][]) s.getStatus();
                for (int[] aChessSet : chessSet)
                    for (int j = 0; j < chessSet.length; j++)
                        if (aChessSet[j] == 3) return true;
                return false;
            }

            @Override
            public double actionCost(State s, Action a) {
                return 3;
            }

            @Override
            public double pathCost(Node n) {
                Node p = n.getParent();
                double cost = n.getPathCost();
                while (p != null) {
                    cost += p.getPathCost();
                    p = p.getParent();
                }
                return cost;
            }

            @Override
            public double heuristic(State s) {
                return 0;
            }

            @Override
            public int checkStatus(List<Node> l, State s) {
                int [][] chessSet = (int[][]) s.getStatus();
                boolean[] flags = new boolean[l.size()];

                for (int k = 0; k < l.size(); k++)
                    flags[k] = false;

                int k = 0;
                for (Node n: l) {

                    int[][] temp = (int[][]) (n.getState().getStatus());
                    for (int i = 0; i < chessSet.length; i++)
                        for (int j = 0; j < chessSet.length; j++)
                            if (chessSet[i][j] != temp[i][j]) flags[k]=true;
                    k++;
                }

                for (int i = 0; i < l.size(); i++)
                    if (!flags[i]) return i;
                return -1;
            }

        };

    }

}
