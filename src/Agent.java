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

    public void addLineAssignment(AutoLine line) {
        if(assignedAutomatedLines.size() < LINE_LIMIT) {
            assignedAutomatedLines.add(line);
            line.addAgent();
        }
        else {
            //TODO throw an exception
        }
    }
}
