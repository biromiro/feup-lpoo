import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IcecreamMachine {

    private Icecream icecream;

    private Stack<Command> previousCommands;

    public IcecreamMachine(Icecream icecream) {
        this.icecream = icecream;
        previousCommands = new Stack<Command>();
    }

    public IcecreamMachine executeCommand(Command command) {
        command.execute(icecream);
        previousCommands.push(command);
        return this;
    }

    public IcecreamMachine undoLastCommand() {
        if(!previousCommands.isEmpty()) previousCommands.pop().undo(icecream);
        return this;
    }
}
