package searchers;

import resources.Action;
import resources.Node;
import resources.Problem;
import utilities.GSException;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.Vector;

public class HCSearcher extends Searcher{

    /**
     * Used if the First choice mode is requested.
     */
    private boolean firstChoiceHillClimbing;

    /**
     * Used if the Stochastic mode is requested.
     */
    private boolean stochasticHillClimbing;

    /**
     * Used if the Random restart mode is requested.
     */
    private boolean randomRestartHillClimbing;

    /**
     * Constructor method. the frontier must be set at the end of constructing this object.
     *
     * @param problem {@link Problem} to be searched.
     */
    public HCSearcher(Problem problem) {
        super(problem);
    }

    @Override
    public Node search() throws GSException, InterruptedException {
        // Initialization
        Node current = rootNode();
        double objective1 = 0, objective2 = 0;

        // Looping
        while (objective1 > objective2 || objective1 == objective2){
            Node neighbor = getUphillMove(current);

            // Measuring
            visitedNodesCount++;


            objective1 = problem.heuristic(neighbor.getState());
            objective2 = problem.heuristic(current.getState());

            if (objective1 < objective2 ){
                expandedNodesCount++;
                if (randomRestartHillClimbing && !problem.goalTest(current.getState()))
                    // Restarting from random state
                    current = randomNode();
                else
                    return current;
            }
            current = neighbor;
        }
        return null;
    }

    private Node randomNode() {
        return null;
    }

    private Node getUphillMove(Node current){
        PriorityQueue<Node> prioritizedNeighbors = new PriorityQueue<>((o1, o2) -> (int) (problem.heuristic(o1.getState()) - problem.heuristic(o2.getState())));
        Vector<Node> upwardMoves = new Vector<>();
        for (Action a : problem.actions(current.getState())) {
            Node next = childNode(current, a);
            if (firstChoiceHillClimbing){
                if (problem.heuristic(next.getState()) > problem.heuristic(current.getState()))
                    return next;
            } else if (stochasticHillClimbing) {
                if (problem.heuristic(next.getState()) > problem.heuristic(current.getState()))
                    upwardMoves.add(next);
            } else {
                prioritizedNeighbors.add(next);
            }
        }
        if (stochasticHillClimbing)
            return upwardMoves.elementAt((new Random()).nextInt(upwardMoves.size()));
        else
            return prioritizedNeighbors.remove();
    }

}
