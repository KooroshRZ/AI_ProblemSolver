package searchers;

import resources.Action;
import resources.Node;
import resources.Problem;
import resources.State;
import utilities.GSException;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class HCSearcher extends Searcher{


    /**
     * User if Simple choice mode is requested
     */
    private boolean simpleHillClimbing = false;

    /**
     * Used if the First choice mode is requested.
     */
    private boolean firstChoiceHillClimbing = false;

    /**
     * Used if the Stochastic mode is requested.
     */
    private boolean stochasticHillClimbing = false;

    /**
     * Used if the Random restart mode is requested.
     */
    private boolean randomRestartHillClimbing = false;

    /**
    * Used for counting step for preventing from stuck in flats
    */
    private int steps = 0;

    /**
     * Constructor method. the frontier must be set at the end of constructing this object.
     *
     * @param problem {@link Problem} to be searched.
     */
    public HCSearcher(Problem problem) {
        super(problem);
        frontier = new CopyOnWriteArrayList<>();
    }

    @Override
    public Node search() throws GSException, InterruptedException {

        // Initialization
        Node current = rootNode();
        double objective1 = 0, objective2 = 0;
//        explored = new Vector<>();
        Node neighbor = null;
        double max = 10000;

        // Looping
        while (objective2 <= objective1){
//            Node neighbor = getUphillMove(current);

            // Measuring
            visitedNodesCount++;


            if (simpleHillClimbing) {
                for (Action a : problem.actions(current.getState())) {

                    max = problem.heuristic(current.getState());
                    if (problem.heuristic(childNode(current, a).getState()) < max) {
                        neighbor = childNode(current, a);
                        max = problem.heuristic(neighbor.getState());
                        objective2 = problem.heuristic(neighbor.getState());
                        objective1 = problem.heuristic(current.getState());
                    }

                    steps++;
                    int[] queue = (int[]) neighbor.getState().getStatus();
                    int[] copy = new int[queue.length];

                    System.arraycopy(queue, 0, copy, 0, queue.length);
                    current.getState().setStatus(copy);

                }
            } else if (firstChoiceHillClimbing){

                for (Action a : problem.actions(current.getState())) {
                    if (problem.heuristic(childNode(current, a).getState()) < problem.heuristic(current.getState())) {
                        neighbor = childNode(current, a);
                        objective2 = problem.heuristic(neighbor.getState());
                        objective1 = problem.heuristic(current.getState());
                    }
                    int[] queue = (int[]) neighbor.getState().getStatus();
                    int[] copy = new int[queue.length];

                    System.arraycopy(queue, 0, copy, 0, queue.length);
                    current.getState().setStatus(copy);

                    steps++;
                }


            } else if (stochasticHillClimbing){

                for (Action a : problem.actions(current.getState())) {

                    if (problem.heuristic(childNode(current, a).getState()) < problem.heuristic(current.getState())) {
                        neighbor = childNode(current, a);
                        frontier.add(neighbor);
                    }
                    steps++;

                }

                if (frontier.size() == 0) return current;

                int[] queue = (int[]) frontier.get(new Random().nextInt(frontier.size())).getState().getStatus();
                int[] copy = new int[queue.length];

                System.arraycopy(queue, 0, copy, 0, queue.length);
                current.getState().setStatus(copy);
                frontier.clear();

            } else if (randomRestartHillClimbing){

            }

            if (steps > 10000) return current;

            int[] queue = (int[]) neighbor.getState().getStatus();
            int[] copy = new int[queue.length];

            System.arraycopy(queue, 0, copy, 0, queue.length);
            current.getState().setStatus(copy);



//            System.out.println("akldh");

        }
        return current;
    }

    private Node randomNode() {
        return null;
    }

    private Node getUphillMove(Node current){

        System.out.println(" c " + current);
        List<Node> prioritizedNeighbors = new CopyOnWriteArrayList<>();
        Vector<Node> upwardMoves = new Vector<>();

        for (Action a : problem.actions(current.getState())) {
            Node next = childNode(current, a);
            System.out.println( " n " + next);
            if (firstChoiceHillClimbing){
                System.out.println(next.getState());
                System.out.println(current.getState());
                if (problem.heuristic(next.getState()) > problem.heuristic(current.getState()))
                    return next;
            } else if (stochasticHillClimbing) {
                if (problem.heuristic(next.getState()) > problem.heuristic(current.getState()))
                    upwardMoves.add(next);
            } else {
                prioritizedNeighbors.add(next);
            }
        }

            return null;
//        if (stochasticHillClimbing)
//            return upwardMoves.elementAt((new Random()).nextInt(upwardMoves.size()));
//        else
//            return prioritizedNeighbors.remove();
    }

    public void setFirstChoiceHillClimbing(boolean firstChoiceHillClimbing) {
        this.firstChoiceHillClimbing = firstChoiceHillClimbing;
    }

    public void setRandomRestartHillClimbing(boolean randomRestartHillClimbing) {
        this.randomRestartHillClimbing = randomRestartHillClimbing;
    }

    public void setStochasticHillClimbing(boolean stochasticHillClimbing) {
        this.stochasticHillClimbing = stochasticHillClimbing;
    }

    public void setSimpleHillCliming(boolean simpleHillClimbing) {
        this.simpleHillClimbing = simpleHillClimbing;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
