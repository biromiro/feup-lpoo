package stringOperations;

public class StringDrinkRequest {

    private StringDrink drink;
    private StringRecipe recipe;

    public StringDrinkRequest(StringDrink drink, StringRecipe recipe){
        this.drink = drink;
        this.recipe = recipe;
    }

    public StringDrink getDrink() {
        return drink;
    }

    public StringRecipe getRecipe() {
        return recipe;
    }
}
