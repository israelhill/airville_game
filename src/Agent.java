import java.util.ArrayList;

public class Agent {
    private int lineLimit;
    private ArrayList<InPersonLine> assignedAutomatedLines;

    /**
     * default Agent can rotate between 3 lines
     */
    public Agent(ArrayList<InPersonLine> automatedLines) {
        lineLimit = 3;
        assignedAutomatedLines = automatedLines;
    }

    public Agent(int lineLimit, ArrayList<InPersonLine> automatedLines) {
        this.lineLimit = lineLimit;
        assignedAutomatedLines = automatedLines;
    }

    public int getLineLimit() {
        return lineLimit;
    }

    public ArrayList<InPersonLine> getAssignedAutomatedLines() {
        return assignedAutomatedLines;
    }
}
