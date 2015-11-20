import java.util.ArrayList;

public class Agent {
    private int lineLimit;
    private ArrayList<AutoLine> assignedAutomatedLines = new ArrayList<>();
    private final static int LINE_LIMIT = 5;

    // TODO add method for adding lines to agent's auto lines?

    public Agent() {
        this.lineLimit = LINE_LIMIT;
    }

    public int getLineLimit() {
        return lineLimit;
    }

    public ArrayList<AutoLine> getAssignedAutomatedLines() {
        return assignedAutomatedLines;
    }

    public void addLineAssignment(AutoLine line) throws InvalidOperationException {
        if(assignedAutomatedLines.size() < getLineLimit()) {
            assignedAutomatedLines.add(line);
            line.addAgent();
        }
        else {
            String message = "Cannot add line to this agent. Agent has reached line capacity";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INVALID_AGENT, message);
        }
    }
}
