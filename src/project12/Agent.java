package project12;

import java.util.ArrayList;

public class Agent {
    private int lineLimit;
    private boolean isAutoLineAgent;
    private boolean isInPersonLineAgent;
    private boolean isFreeAgent;
    private ArrayList<AbstractLine> assignedLines = new ArrayList<>();
    private final static int LINE_LIMIT = 5;

    // TODO add method for adding lines to agent's auto lines?

    /**
     * a constructor for the class
     */
    public Agent() {
        this.lineLimit = LINE_LIMIT;
        isFreeAgent = true;
        isAutoLineAgent = false;
        isInPersonLineAgent = false;
    }

    /**
     * get the max number of automated lines this agent can visit
     * @return the number of automated lines this agent can visit
     */
    public int getLineLimit() {
        return lineLimit;
    }

    /**
     * get a list of the lines this agent is assigned to
     * @return an ArrayList of AbstractLines
     */
    public ArrayList<AbstractLine> getAssignedAutomatedLines() {
        return assignedLines;
    }

    /**
     * assign this agent another line if it has not reached its max
     * @param line
     * @throws InvalidOperationException
     */
    public void addAutoLineAssignment(AutoLine line) throws InvalidOperationException {
        if(isFreeAgent) {
            isFreeAgent = false;
            isAutoLineAgent = true;
        }
        else if (isInPersonLineAgent) {
            String message = "Can not add automated line to agent that has been assigned to in person lines.";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INVALID_AGENT, message);
        }

        if(assignedLines.size() < getLineLimit()) {
            assignedLines.add(line);
            line.addAgent();
        }
        else {
            String message = "Cannot add line to this agent. Agent has reached line capacity";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INVALID_AGENT, message);
        }
    }

    /**
     *
     * @param line
     * @throws InvalidOperationException
     */
    public void addInPersonLine(InPersonLine line) throws InvalidOperationException {
        if(isFreeAgent) {
            isFreeAgent = false;
            isInPersonLineAgent = true;
        }
        else if (isAutoLineAgent) {
            String message = "Can not add inperson line to agent that has been assigned to automated lines.";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INVALID_AGENT, message);
        }

        assignedLines.add(line);
        line.addAgent();
    }

}
