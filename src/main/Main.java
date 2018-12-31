package main;

import jdk.nashorn.internal.ir.debug.ASTWriter;
import resources.Action;
import resources.Node;
import resources.Problem;
import resources.State;
import searchers.*;
import utilities.GSException;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) {

//        p1();
//        p2();
        p3();

    }

    private static void p1(){
        Problem p1 = new Problem() {
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
//                System.out.println("**********************");
//                s.printState();
//                a.printActions();
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

//                temp.printState();
//                System.out.println("**********************");
//                new State(copy).printState();
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
//                int [][] puzzle = (int[][]) s.getStatus();
//                boolean[] flags = new boolean[l.size()];
//
//                for (int k = 0; k < l.size(); k++)
//                    flags[k] = false;
//
//                int k = 0;
//                for (Node n: l) {
//
//                    int[][] temp = (int[][]) (n.getState().getStatus());
//                    for (int i = 0; i < puzzle.length; i++)
//                        for (int j = 0; j < puzzle.length; j++)
//                            if (puzzle[i][j] != temp[i][j]) flags[k]=true;
//                    k++;
//                }
//
//                for (int i = 0; i < l.size(); i++)
//                    if (!flags[i]) return false;

                return 1;
            }

            @Override
            public boolean areSame(Node n1, Node n2) {
                return false;
            }
        };

        BFSearcher bfs = new BFSearcher(p1);
        DFSearcher dfs = new DFSearcher(p1);

        try {
            Node res1 = bfs.search();
            System.out.println("BFS: ");
            System.out.println((res1 != null ? " Path Cost: " +  res1.getPathCost() + " " : "NOT FOUND ") + bfs.toString() );
            Vector<State> solution = Problem.solution(res1);
            if (!solution.isEmpty())
                for(State n : solution)
                    n.printState();

            Node res2 = dfs.search();
            System.out.println("DFS: ");
            System.out.println("*********************");
            System.out.println((res2 != null ? " Path Cost: " +  res2.getPathCost() + " " : "NOT FOUND ") + dfs.toString() );
            Vector<State> solution2 = Problem.solution(res2);
            if (!solution2.isEmpty())
                for(State n : solution2) {
                    n.printState();
                    System.out.println("*********************");
                }

        } catch (GSException | InterruptedException e){
            e.printStackTrace();
        }

    }

    private static void p2(){

        Problem p2 = new Problem() {
            @Override
            public State initialState() {
                return new State(new int[][]{
                        {4, 1, 2},
                        {5, 8, 3},
                        {7, 6, 0}
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

//                System.out.println("**********************");
//                s.printState();
//                a.printActions();

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

                //                temp.printState();
//                System.out.println("**********************");

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

            @Override
            public boolean areSame(Node n1, Node n2) {

                int [][] copy1 = (int[][]) n1.getState().getStatus();
                int [][] copy2 = (int[][]) n2.getState().getStatus();

                for (int i = 0; i < copy1.length; i++)
                    for (int j = 0; j < copy2.length; j++)
                        if (copy1[i][j] != copy2[i][j]) return false;

                return true;
            }
        };

        BFSearcher bfs = new BFSearcher(p2);
        DFSearcher dfs = new DFSearcher(p2);
        UCSearcher ucs = new UCSearcher(p2);
        AStarSearcher aStar = new AStarSearcher(p2);

        BDSearcher bds = new BDSearcher(p2, new State(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,0}
        }));

        try {

            Node res1 = bfs.search();
            System.out.println("BFS: ");
            System.out.println("*********************");
            System.out.println((res1 != null ? " Path Cost: " +  res1.getPathCost() + " " : "NOT FOUND ") + bfs.toString() );
            Vector<State> solution1 = Problem.solution(res1);
            if (!solution1.isEmpty())
                for(State n : solution1) {
                    n.printState();
                    System.out.println("*********************");
                }

            Node res2 = dfs.search();
            System.out.println("DFS: ");
            System.out.println("*********************");
            System.out.println((res2 != null ? " Path Cost: " +  res2.getPathCost() + " " : "NOT FOUND ") + dfs.toString() );
            Vector<State> solution2 = Problem.solution(res2);
            if (!solution2.isEmpty())
                for(State n : solution2) {
                    n.printState();
                    System.out.println("*********************");
                }

            Node res3 = ucs.search();
            System.out.println("UCS: ");
            System.out.println("*********************");
            System.out.println((res3 != null ? " Path Cost: " +  res3.getPathCost() + " " : "NOT FOUND ") + ucs.toString() );
            Vector<State> solution3 = Problem.solution(res3);
            if (!solution3.isEmpty())
                for(State n : solution3) {
                    n.printState();
                    System.out.println("*********************");
                }

            System.out.println("searching");
            Node res4 = aStar.search();
            System.out.println("A*: ");
            System.out.println("*********************");
            System.out.println((res4 != null ? " Path Cost: " +  res4.getPathCost() + " " : "NOT FOUND ") + aStar.toString() );
            Vector<State> solution4 = Problem.solution(res4);
            if (!solution4.isEmpty())
                for(State n : solution4) {
                    n.printState();
                    System.out.println("*********************");
                }

//            System.out.println("searching");
            bds.search();
//            System.out.println("bds: ");
//            System.out.println("*********************");
//            System.out.println((res5 != null ? " Path Cost: " +  res5.getPathCost() + " " : "NOT FOUND ") + bds.toString() );
//            Vector<State> solution5 = Problem.solution(res5);
//            if (!solution5.isEmpty())
//                for(State n : solution5) {
//                    n.printState();
//                    System.out.println("*********************");
//                }


        } catch (GSException | InterruptedException e){
            e.printStackTrace();
        }

    }

    private static void p3() {
        Problem p3 = new Problem() {
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

            @Override
            public boolean areSame(Node n1, Node n2) {
                return false;
            }
        };

        BFSearcher bfs = new BFSearcher(p3);
        DFSearcher dfs = new DFSearcher(p3);
        UCSearcher ucs = new UCSearcher(p3);
//        AStarSearcher aStar = new AStarSearcher(p3);
        BDSearcher bds = new BDSearcher(p3, new State(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, -1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, -1, 0, 0},
                {-1, 0, 0, -1, 0, 0, 0, 0},
                {0, 0, 0, 0, -1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, -1, 0},
                {0, 0, 0, 0, 3, 0, 0, 0},
        }));

        try {

//            Node res1 = bfs.search();
//            System.out.println("BFS: ");
//            System.out.println("*********************");
//            System.out.println((res1 != null ? " Path Cost: " +  res1.getPathCost() + " " : "NOT FOUND ") + bfs.toString() );
//            Vector<State> solution1 = Problem.solution(res1);
//            if (!solution1.isEmpty())
//                for(State n : solution1) {
//                    n.printState();
//                    System.out.println("*********************");
//                }
//
//            Node res2 = dfs.search();
//            System.out.println("DFS: ");
//            System.out.println("*********************");
//            System.out.println((res2 != null ? " Path Cost: " +  res2.getPathCost() + " " : "NOT FOUND ") + dfs.toString() );
//            Vector<State> solution2 = Problem.solution(res2);
//            if (!solution2.isEmpty())
//                for(State n : solution2) {
//                    n.printState();
//                    System.out.println("*********************");
//                }
//
//            Node res3 = ucs.search();
//            System.out.println("UCS: ");
//            System.out.println("*********************");
//            System.out.println((res3 != null ? " Path Cost: " +  res3.getPathCost() + " " : "NOT FOUND ") + ucs.toString() );
//            Vector<State> solution3 = Problem.solution(res3);
//            if (!solution3.isEmpty())
//                for(State n : solution3) {
//                    n.printState();
//                    System.out.println("*********************");
//                }

            bds.search();

        } catch (GSException | InterruptedException e){
            e.printStackTrace();
        }

    }

}