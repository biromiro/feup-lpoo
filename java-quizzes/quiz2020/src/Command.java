public interface Command {
    public void execute(Icecream icecream);
    public void undo(Icecream icecream);
}
