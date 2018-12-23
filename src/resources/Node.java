package resources;

public class Node implements Comparable<Node>{

    private Node parent;
    private Node secondParent;
    private State state;
    private Action action;

    private double pathCost;

    public Node(Node parent, State state, Action action, double pathCost){
        this.parent = parent;
        this.state = state;
        this.action = action;
        this.pathCost = pathCost;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPathCost(double pathCost) {
        this.pathCost = pathCost;
    }

    public double getPathCost() {
        return pathCost;
    }

    public void setSecondParent(Node secondParent) {
        this.secondParent = secondParent;
    }

    public int getDepth(){
        int depth = 0;
        if (parent == null)
            return depth;
        Node p = parent;
        while(p != null){
            depth++;
            p = p.getParent();
        }
        return depth;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}
