public class ItalicCommand implements Command {
    int start;
    int end;

    MarkdownString mdString;

    public ItalicCommand(MarkdownString mdString, int start, int end) {
        this.mdString = mdString;
        this.start = start;
        this.end = end + 1;
    }

    @Override
    public void doCommand() {
        insertString(end, "*");
        insertString(start, "*");
    }

    @Override
    public void undoCommand() {
        removeString(start, 1);
        removeString(end, 1);
    }

    private void insertString(int index, String insert) {
        String firstHalf = mdString.text.substring(0, index);
        String secondHalf = mdString.text.substring(index);
        mdString.text = firstHalf + insert + secondHalf;
    }

    private void removeString(int index, int stringLength) {
        String firstHalf = mdString.text.substring(0, index);
        String secondHalf = mdString.text.substring(index + stringLength);
        mdString.text = firstHalf + secondHalf;
    }
}
