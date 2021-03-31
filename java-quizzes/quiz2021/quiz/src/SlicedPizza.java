import java.util.Set;

public class SlicedPizza implements Pizza {

    private final int slices;
    private final Pizza pizzaToSlice;
    private final static double slicedPizzaTax = 2.0;

    public SlicedPizza(Pizza pizza, int slices) {
        this.pizzaToSlice = pizza;
        this.slices = slices;
    }

    public int getSlices() {
        return this.slices;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return pizzaToSlice.addIngredient(ingredient);
    }

    @Override
    public int getIngredientCount() {
        return pizzaToSlice.getIngredientCount();
    }

    @Override
    public Set<Ingredient> getIngredients() {
        return pizzaToSlice.getIngredients();
    }

    @Override
    public double getPrice() {
        return pizzaToSlice.getPrice() + slicedPizzaTax;
    }

    @Override
    public void setPrice(double v) {
        pizzaToSlice.setPrice(v);
    }
}
