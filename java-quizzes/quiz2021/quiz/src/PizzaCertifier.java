import java.util.Set;

public abstract class PizzaCertifier {
    public abstract boolean isCertified(Pizza pizza1);
    public abstract Set<Ingredient> getNeededIngredients();
}
