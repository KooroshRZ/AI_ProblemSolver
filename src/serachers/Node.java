package serachers;

public class Node {

    private Node parent;
    private Node secondParent;
    private State state;
    private Action action;

    private double pathCost;

    public Node(Node parent, State state, Action action, double pathCost){
        this.parent = parent;
        this.state = state;
        this.action = action;
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

    public double getPathCost() {
        return pathCost;
    }

    public void setPathCost(double pathCost) {
        this.pathCost = pathCost;
    }
}
