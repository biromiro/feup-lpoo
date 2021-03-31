import java.util.Set;

public interface Pizza {
    public boolean addIngredient(Ingredient ingredient);
    public int getIngredientCount();
    public Set<Ingredient> getIngredients();
    double getPrice();
    void setPrice(double v);
}

