package searchers;

import resources.Action;
import resources.Node;
import resources.Problem;
import utilities.GSException;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class DFSearcher extends Searcher{

    /**
     * Used in Limited DFS.
     * If set to -1 the normal DFS will be performed
     */
    private int depthLimit;

    /**
     * Used in Iterative Deepening DFS.
     * If set to true, the depthLimit value will be ignored
     */
    private boolean iterating;

    /**
     * Used in Iterative Deepening DFS.
     * Only used when iterating flag set to true.
     */
    private int iteratingMaxDepth;

    /**
     * Constructor method. the frontier must be set at the end of constructing this object.
     *
     * @param problem {@link Problem} to be searched.
     */
    public DFSearcher(Problem problem) {
        super(problem);
        frontier = new CopyOnWriteArrayList<>();
    }

    public int getDepthLimit() {
        return depthLimit;
    }

    public void setDepthLimit(int depthLimit) {
        this.depthLimit = depthLimit;
    }

    public boolean isIterating() {
        return iterating;
    }

    public void setIterating(boolean iterating) {
        this.iterating = iterating;
    }

    public int getIteratingMaxDepth() {
        return iteratingMaxDepth;
    }

    public void setIteratingMaxDepth(int iteratingMaxDepth) {
        this.iteratingMaxDepth = iteratingMaxDepth;
    }

    @Override
    public Node search() throws GSException, InterruptedException {

        if (iterating)
            for (depthLimit = 1; depthLimit <= iteratingMaxDepth ; depthLimit++){
                explored = new Vector<>();
                Node res = recursiveSearch(rootNode());
                if (res != null)
                    return res;
            }
        else{
            explored = new Vector<>();
//            Node res = recursiveSearch(rootNode());
//            if (res != null)
//                return res;

            if (frontier == null)
                throw new GSException("Frontier is null!");
            frontier.add(rootNode());
            explored = new Vector<>();

            while (!frontier.isEmpty()){

                //Measuring
                if (frontier.size() + explored.size() > maxNodesInMemory)
                    maxNodesInMemory = frontier.size() + explored.size();

                Node leaf = frontier.get(frontier.size()-1);
                frontier.remove(frontier.size()-1);
//                System.out.println("**********************");
//                leaf.getState().printState();
//            leaf.getState().printState();


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
//                    child.getState().printState();
                    if (problem.checkStatus(explored, child.getState()) == -1)
                        frontier.add(child);
                }

            }


        }
        return null;
    }


    private Node recursiveSearch(Node root){
        explored.add(root);

        // Measuring
        if (explored.size() > maxNodesInMemory)
            maxNodesInMemory = explored.size();
        visitedNodesCount++;

        if (depthLimit != 0 &&  root.getDepth() > depthLimit)
            return null;
        if (problem.goalTest(root.getState()))
            return root;

        // Expanding the leaf node
        for (Action a : problem.actions(root.getState())){
            Node child = childNode(root, a);

            // Measuring
            expandedNodesCount++;

            if (!explored.contains(child)){
                Node res = recursiveSearch(child);
                if (res != null)
                    return res;
            }
        }
        // Reverting everything back to normal!
//        for (Action a : problem.actions(root.getState())){
//            Node n = childNode(root,a);
//            if (n.getParent() != null)
//                if (n.getParent().equals(root)){
//                    n.setTraversed(false);
//                    n.setExplored(false);
//            }
//        }
        return null;
    }
}
