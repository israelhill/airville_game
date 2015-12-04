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

    public Agent() {
        this.lineLimit = LINE_LIMIT;
        isFreeAgent = true;
        isAutoLineAgent = false;
        isInPersonLineAgent = false;
    }

    public int getLineLimit() {
        return lineLimit;
    }

    public ArrayList<AbstractLine> getAssignedAutomatedLines() {
        return assignedLines;
    }

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

    public void setAgentType() {
        if(isFreeAgent) {

        }
    }
}
