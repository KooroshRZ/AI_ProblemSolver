package searchers;

import resources.Action;
import resources.Node;
import resources.Problem;
import resources.State;
import utilities.GSException;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class BDSearcher extends Searcher{

    /**
     * Constructor method. the frontier must be set at the end of constructing this object.
     *
     * @param problem {@link Problem} to be searched.
     */

    private List<Node> frontierFromGoal;
    private State goalState;

    public BDSearcher(Problem problem, State goalState) {
        super(problem);
        this.goalState = goalState;
        frontier = new CopyOnWriteArrayList<>();
        frontierFromGoal = new CopyOnWriteArrayList<>();
    }

    @Override
    public Node search() throws GSException, InterruptedException {

        if (frontier == null || frontierFromGoal == null)
            throw new GSException("One of frontiers are null!");

        Node node1 = rootNode();
        Node node2 = new Node(null, this.goalState, null, 0);

        frontier.add(node1);
        frontierFromGoal.add(node2);

        explored = new Vector<>();

        explored.add(node1);
        explored.add(node2);

        while (!frontier.isEmpty() && !explored.isEmpty()){

            // Measuring
            if (frontier.size() + frontierFromGoal.size() + explored.size() > maxNodesInMemory)
                maxNodesInMemory = frontier.size() + frontierFromGoal.size() + explored.size();

            Node leaf = frontier.get(0);
            frontier.remove(0);

            // Measuring
            visitedNodesCount++;

            if (problem.checkStatus(frontierFromGoal, leaf.getState()) != -1)
//                return leaf;
                buildPath(leaf, frontierFromGoal);

            // Leaf is not a goal. Then it must be expanded. Making sure not to visit this node again!
            explored.add(leaf);

            // Expanding the leaf node
            List<Action> actions = problem.actions(leaf.getState());
            for (Action a : actions) {
                Node child = childNode(leaf, a);

                // Measuring
                expandedNodesCount++;

                if (problem.checkStatus(explored, child.getState()) == -1)
                    frontier.add(child);
            }


            // Looping from the goal state.
            // Measuring
            if (frontier.size() + frontierFromGoal.size() + explored.size() > maxNodesInMemory)
                maxNodesInMemory = frontier.size() + frontierFromGoal.size() + explored.size();

            Node leafFromGoal = frontierFromGoal.get(0);
            frontierFromGoal.remove(0);


            // Measuring
            visitedNodesCount++;

            // Goal test
            if (problem.checkStatus(frontier, leafFromGoal.getState()) != -1)
                buildPath(leafFromGoal, frontier);
//                return leafFromGoal;

            // Leaf is not a goal. Then it must be expanded. Making sure not to visit this node again!
            explored.add(leafFromGoal);

            // Expanding the leaf node
            List<Action> actionsFromGoal = problem.actions(leafFromGoal.getState());
            for (Action action : actionsFromGoal) {
                Node child = childNode(leafFromGoal, action);

                // Measuring
                expandedNodesCount++;

                if (problem.checkStatus(explored, child.getState()) == -1)
                    frontierFromGoal.add(child);
            }

//            System.out.println("pretty goooood :D");
        }
        return null;

    }

    private void buildPath(Node node, List<Node> list){
        
        int index = problem.checkStatus(list, node.getState());
        Node temp = list.get(index);

        Vector<State> solution1 = Problem.solution(temp);
        if (!solution1.isEmpty())
            for(State n : solution1) {
                n.printState();
                System.out.println("*********************");
            }

        Vector<State> solution2 = Problem.solution(node);
        if (!solution2.isEmpty())
            for(State n : solution2) {
                n.printState();
                System.out.println("*********************");
            }

        System.exit(1);

    }

    private boolean hasIntersection(List<Node> open, List<Node> close){

        for (Node n1: open)
            for (Node n2: close)
                if (n1.getState().getStatus().equals(n2.getState().getStatus())) return true;
        return false;
    }
}