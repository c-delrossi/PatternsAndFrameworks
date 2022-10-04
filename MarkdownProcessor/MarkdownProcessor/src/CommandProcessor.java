import java.util.Stack;

public class CommandProcessor {
    private Stack<Command> commandStack = new Stack<>();

    public void doCommand(Command command) {
        commandStack.push(command);
        command.doCommand();
    }

    public void undoCommand() {
        commandStack.pop().undoCommand();
    }
}
