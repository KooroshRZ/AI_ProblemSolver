package resources;

public class State {

    private Object status;

    public State(Object status){
        this.status = status;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public void printState(){
        int[] stat = (int[]) this.status;

//        for (int[] aStat : stat) System.out.println(aStat[0] + " " + aStat[1] + " " + aStat[2] + " " +aStat[3] + " " + aStat[4] + " " + aStat[5] + " " + aStat[6] + " " + aStat[7]);
//        for (int[] aStat : stat) System.out.println(aStat[0] + " " + aStat[1] + " " + aStat[2]);
//        twins
//        System.out.println(stat[0][0] + "  " + stat[0][1] + "  " + stat[0][2] + "  " );
//        System.out.println(stat[1][0] + "  " + stat[1][1] + "  " + stat[1][2] + "  " + stat[1][3] + "  " + stat[1][4] + "  " + stat[1][5] + "  " + stat[1][6] + "  " + stat[1][7]);
        System.out.println(stat[0] + " " + stat[1] + " " + stat[2] + " " + stat[3] + " " + stat[4] + " " + stat[5] + " " + stat[6] + " " + stat[7] + " " + stat[8]);
    }
}
