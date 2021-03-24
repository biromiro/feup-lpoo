package stringOperations;

public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        String drinkStr = drink.getText();
        StringBuilder sb = new StringBuilder(drinkStr);

        for(int i=0; i < drinkStr.length(); ++i){
            sb.setCharAt(i,Character.isLowerCase(sb.charAt(i)) ? Character.toUpperCase(sb.charAt(i)) : Character.toLowerCase(sb.charAt(i)));
        }

        drink.setText(sb.toString());
    }

    @Override
    public void undo(StringDrink drink){
        execute(drink);
    }
}
