import java.util.ArrayList;

public class Game {
    private int diamonds;
    private int supervisors;
    private ArrayList<AbstractLine> inPersonLines = new ArrayList<>();
    private ArrayList<AbstractLine> automatedLines = new ArrayList<>();
    private ArrayList<Queueable> passengers = new ArrayList<>();
    private ArrayList<Agent> agents = new ArrayList<>();

    //TODO create an exception class and possibly throw errors when the player does not have enough diamonds

    public Game() {
        Agent agent = new Agent();
        agents.add(agent);

        InPersonLine line = new InPersonLine();
        inPersonLines.add(line);

        supervisors = 1;
        diamonds = 0;
    }


    public void addDiamond() {
        diamonds++;
    }

    public void redeemAgent(int lineLimit, ArrayList<AutoLine> list) {
        if(hasDiamonds()) {
            diamonds--;
            Agent agent = new Agent();
            agents.add(agent);
        }
    }

    public void redeemSupervisor() {
        if(hasDiamonds()) {
            diamonds--;
            supervisors++;
        }
    }

    public void redeemAutomatedLine() {
        if(hasDiamonds()) {
            diamonds--;
            AutoLine line = new AutoLine();
            automatedLines.add(line);
        }
    }

    public void redeemInPersonLines() {
        if(hasDiamonds()) {
            diamonds--;
            InPersonLine line = new InPersonLine();
            inPersonLines.add(line);
        }
    }

    public boolean hasDiamonds() {
        return diamonds > 0;
    }

    public int getSupervisors() {
        return supervisors;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public ArrayList<AbstractLine> getInPersonLines() {
        return inPersonLines;
    }

    public ArrayList<AbstractLine> getAutomatedLines() {
        return automatedLines;
    }
}
