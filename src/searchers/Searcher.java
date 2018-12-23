package searchers;

import resources.Action;
import resources.Node;
import resources.Problem;
import utilities.GSException;

import java.util.List;
import java.util.Vector;

abstract class Searcher {

    /**
     * The problem to be searched and solved
     */
    Problem problem;
    
    /**
     * The main queue from which the nodes will be checked.
     */
    List<Node> frontier;

    /**
     * Explored set used on graphs.
     */
    Vector<Node> explored;

    /**
     * Performance measurement values of the search algorithm.
     */
    int visitedNodesCount;
    int expandedNodesCount;
    int maxNodesInMemory;

    /**
     * Constructor method. the frontier must be set at the end of constructing this object.
     *
     * @param problem {@link Problem} to be searched.
     */
    Searcher(Problem problem){
        this.problem = problem;
        visitedNodesCount = 0;
        expandedNodesCount = 0;
        maxNodesInMemory = 0;
    }

    /**
     * The actuator function and main responsibility of this class.
     *
     * @return Null if no solution found | {@link Node} containing a solution.
     * @throws GSException if the frontier is not initialized.
     */
    public abstract Node search() throws GSException, InterruptedException;

    /**
     * Building the child node and the path from parent to it.
     *
     * @param parent {@link Node} the father!
     * @param a {@link Action} the action which lead a step from father to this node.
     * @return {@link Node} the child!
     */
    Node childNode(Node parent, Action a){
//        problem.result(parent.getState(), a).printState();
        return new Node(parent, problem.result(parent.getState(), a), a,
                parent.getPathCost() + problem.actionCost(parent.getState(), a));
    }

    Node rootNode(){
        return new Node(null, problem.initialState(), null, 0);
    }

    @Override
    public String toString() {
        return "#Visited Nodes: " + visitedNodesCount + ", #Expanded Nodes: " + expandedNodesCount + ", #Maximum Memory Cells Used: " + maxNodesInMemory;
    }

}
