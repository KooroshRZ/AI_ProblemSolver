package searchers;

import resources.Action;
import resources.Node;
import resources.Problem;
import utilities.GSException;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class UCSearcher extends Searcher{
    /**
     * Constructor method. the frontier must be set at the end of constructing this object.
     *
     * @param problem {@link Problem} to be searched.
     */
    public UCSearcher(Problem problem) {
        super(problem);
        frontier = new CopyOnWriteArrayList<>();
    }

    @Override
    public Node search() throws GSException, InterruptedException {
        // Initializations
        if (frontier == null)
            throw new GSException("Frontier is null!");
        frontier.add(rootNode());
        explored = new Vector<>();

        // Looping
        while (!frontier.isEmpty()){

            Node leaf = this.getShortest(frontier);
            frontier.remove(leaf);

            // Measuring
            //Measuring
            if (frontier.size() + explored.size() > maxNodesInMemory)
                maxNodesInMemory = frontier.size() + explored.size();

            visitedNodesCount++;

            // Goal test
            if (problem.goalTest(leaf.getState()))
                return leaf;

            // Leaf is not a goal. Then it must be expanded. Making sure not to visit this node again!
            explored.add(leaf);

            // Expanding the leaf node
            List<Action> actions = problem.actions(leaf.getState());
            for (Action a : actions) {
                Node child = childNode(leaf, a);

                // Measuring
                expandedNodesCount++;

                if (problem.checkStatus( frontier, child.getState()) == -1)
                    frontier.add(child);

            }
            frontier.remove(leaf);

        }
        return null;
    }

    private Node getShortest(List<Node> list){

        double cost = 100000;
        Node res = null;

        for (Node n: list){
            if (n.getPathCost() < cost){
                cost = n.getPathCost();
                res = n;
            }
        }
        return res;
    }
}
