import java.util.HashSet;
import java.util.Set;


public class MediumPizza implements Pizza {
    private Set<Ingredient> pizzaIngredients;
    private double price;

    MediumPizza(){
        this.pizzaIngredients = new HashSet<Ingredient>();
        price = 0;
    }

    public boolean addIngredient(Ingredient ingredient) {
        return pizzaIngredients.add(ingredient);
    }

    public int getIngredientCount() {
        return pizzaIngredients.size();
    }

    @Override
    public Set<Ingredient> getIngredients() {
        return pizzaIngredients;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double v) {
        price = v;
    }
}
