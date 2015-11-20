import java.util.ArrayList;

public class Agent {
    private int lineLimit;
    private ArrayList<AutoLine> assignedAutomatedLines;

    // TODO add method for adding lines to agent's auto lines?

    public Agent(int lineLimit, ArrayList<AutoLine> automatedLines) {
        this.lineLimit = lineLimit;
        assignedAutomatedLines = automatedLines;
    }

    public int getLineLimit() {
        return lineLimit;
    }

    public ArrayList<AutoLine> getAssignedAutomatedLines() {
        return assignedAutomatedLines;
    }
}
