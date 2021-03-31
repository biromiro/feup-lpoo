import java.util.List;

public class GenericRecipe extends Recipe {

    private final List<Ingredient> myGenericIngredients;

    public GenericRecipe(List<Ingredient> ingredients) {
        this.myGenericIngredients = ingredients;
    }

    @Override
    public Pizza makeMediumPizza() {
        Pizza newPizza = new MediumPizza();
        for(Ingredient ingredient: myGenericIngredients){
            newPizza.addIngredient(ingredient);
        }
        return newPizza;
    }
}
