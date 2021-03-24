package stringOperations;

public class StringReplacer implements StringTransformer{

    private Character oldChar, newChar;

    public StringReplacer(Character oldChar, Character newChar){
        this.oldChar = oldChar;
        this.newChar = newChar;
    }

    @Override
    public void execute(StringDrink drink) {
        drink.setText(drink.getText().replace(oldChar,newChar));
    }

    @Override
    public void undo(StringDrink drink){
        drink.setText(drink.getText().replace(newChar,oldChar));
    }
}
