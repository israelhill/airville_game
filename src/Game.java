import java.util.ArrayList;

public class Game {
    private int diamonds;
    private int supervisors;
    private ArrayList<AbstractLine> inPersonLines = new ArrayList<>();
    private ArrayList<AbstractLine> automatedLines = new ArrayList<>();
    private ArrayList<Queueable> passengers = new ArrayList<>();
    private ArrayList<Agent> agents = new ArrayList<>();

    //TODO create an exception class and possibly throw errors when the player does not have enough diamonds

    /**
     * a constructor for the class
     */
    public Game() {
        Agent agent = new Agent();
        agents.add(agent);

        InPersonLine line = new InPersonLine();
        inPersonLines.add(line);

        supervisors = 1;
        diamonds = 0;
    }

    /**
     * player gets an additional diamond
     */
    public void addDiamond() {
        diamonds++;
    }

    /**
     * spend a diamond to get an agent
     * @throws InvalidOperationException
     */
    public void redeemAgent() throws InvalidOperationException {
        checkDiamondCount();

        diamonds--;
        Agent agent = new Agent();
        agents.add(agent);
    }

    /**
     * spend a diamond to get a supervisor
     * @throws InvalidOperationException
     */
    public void redeemSupervisor() throws InvalidOperationException {
        checkDiamondCount();

        diamonds--;
        supervisors++;
    }

    /**
     * spend a diamond to get an automated line
     * @throws InvalidOperationException
     */
    public void redeemAutomatedLine() throws InvalidOperationException {
        checkDiamondCount();

        diamonds--;
        AutoLine line = new AutoLine();
        automatedLines.add(line);

    }

    /**
     * spend a diamond to get a in person line
     * @throws InvalidOperationException
     */
    public void redeemInPersonLines() throws InvalidOperationException {
        checkDiamondCount();

        diamonds--;
        InPersonLine line = new InPersonLine();
        inPersonLines.add(line);
    }

    /**
     * check if the player has diamonds before spending them
     * @throws InvalidOperationException
     */
    public void checkDiamondCount() throws InvalidOperationException {
        if(!hasDiamonds()) {
            String message = "Not enough diamonds to redeem this entity";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INSUFFICIENT_DIAMONDS, message);
        }
    }

    /**
     * decrease the diamond count by 1
     * @throws InvalidOperationException
     */
    public void decrementDiamonds() throws InvalidOperationException {
        if(hasDiamonds()) {
            diamonds--;
        }
        else {
            String message = "Removing diamonds that do not exist";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INSUFFICIENT_DIAMONDS, message);
        }
    }

    /**
     * check if the player has diamonds
     * @return true or false
     */
    public boolean hasDiamonds() {
        return diamonds > 0;
    }

    /**
     * return the number of supervisors
     * @return
     */
    public int getSupervisors() {
        return supervisors;
    }

    /**
     * return the amount of diamonds the player has
     * @return
     */
    public int getDiamonds() {
        return diamonds;
    }

    /**
     * return the list of agents
     * @return
     */
    public ArrayList<Agent> getAgents() {
        return agents;
    }

    /**
     * return the lis of in person lines
     * @return
     */
    public ArrayList<AbstractLine> getInPersonLines() {
        return inPersonLines;
    }

    /**
     * return the list of auto lines
     * @return
     */
    public ArrayList<AbstractLine> getAutomatedLines() {
        return automatedLines;
    }
}
