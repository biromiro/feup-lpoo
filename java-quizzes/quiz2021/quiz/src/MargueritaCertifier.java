import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MargueritaCertifier extends PizzaCertifier {

    private static final Set<Ingredient> neededIngredients =
            new HashSet<Ingredient>(Arrays.asList(
                    new Ingredient("Mozzarella"),
                    new Ingredient("Tomato"),
                    new Ingredient("Basil")));

    @Override
    public boolean isCertified(Pizza pizza1) {
        return neededIngredients.containsAll(pizza1.getIngredients()) &&
                pizza1.getIngredients().size() == neededIngredients.size();
    }

    @Override
    public Set<Ingredient> getNeededIngredients() {
        return neededIngredients;
    }
}
