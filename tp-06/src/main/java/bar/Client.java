package bar;

import stringOperations.StringDrink;
import stringOperations.StringRecipe;

public interface Client extends BarObserver{

    void wants(StringDrink drink, StringRecipe recipe, StringBar bar);

}
