package serachers;

public class Action {

    private Object data;
    private double cost;

    public Action(Object data, double cost){
        this.data = data;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
