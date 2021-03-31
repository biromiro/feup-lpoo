public class MargueritaRecipe extends Recipe {

    private static MargueritaCertifier certifier = new MargueritaCertifier();

    @Override
    public Pizza makeMediumPizza() {
        Pizza newMediumPizza = new MediumPizza();
        for(Ingredient ingredient: certifier.getNeededIngredients()){
            newMediumPizza.addIngredient(ingredient);
        }
        return newMediumPizza;
    }
}
