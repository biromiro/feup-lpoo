public class AddScoopCommand implements Command {

    private Flavor flavor;

    public AddScoopCommand(Flavor flavor){
        this.flavor = flavor;
    }

    @Override
    public void execute(Icecream icecream) {
        icecream.addScoop(flavor);
    }

    @Override
    public void undo(Icecream icecream) {
        icecream.removeScoop(flavor);
    }
}
