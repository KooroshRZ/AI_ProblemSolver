package searchers;

import resources.Action;
import resources.Node;
import resources.Problem;
import utilities.GSException;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class BFSearcher extends Searcher{

    /**
     * Constructor method. the frontier must be set at the end of constructing this object.
     *
     * @param problem {@link Problem} to be searched.
     */
    public BFSearcher(Problem problem){
        super(problem);
        frontier = new CopyOnWriteArrayList<>();
    }

    @Override
    public Node search() throws GSException, InterruptedException {

        if (frontier == null)
            throw new GSException("Frontier is null!");
        frontier.add(rootNode());
        explored = new Vector<>();

        // Looping
        while (!frontier.isEmpty()){
            //Measuring
            if (frontier.size() + explored.size() > maxNodesInMemory)
                maxNodesInMemory = frontier.size() + explored.size();

            Node leaf = frontier.get(0);
            frontier.remove(0);

            // Measuring
            visitedNodesCount++;

            // Goal Test
            if (problem.goalTest(leaf.getState())) {
                return leaf;
            }

            // Leaf is not a goal. Then it must be expanded. Making sure not to visit this node again!
            explored.add(leaf);

            // Expanding the leaf node
            List<Action> actions = problem.actions(leaf.getState());
            for(Action a : actions){
                Node child = childNode(leaf, a);


                // Measuring
                expandedNodesCount++;

                if (problem.checkStatus(explored, child.getState()) == -1)
//                    if ( !( frontier.contains(child) && explored.contains(leaf) ) )
                    frontier.add(child);
            }

//            frontier.remove(0);
        }

        return null;
    }


}
