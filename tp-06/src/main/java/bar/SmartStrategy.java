package bar;

import stringOperations.StringDrink;
import stringOperations.StringDrinkRequest;
import stringOperations.StringRecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SmartStrategy implements OrderingStrategy{

    private final HashMap<Bar, List<StringDrinkRequest>> orders;
    private final HashMap<Bar, Boolean> happyHourBars;

    SmartStrategy(){
        orders = new HashMap<>();
        happyHourBars = new HashMap<>();
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        Boolean inHappyHour = happyHourBars.get(bar);
        if(inHappyHour != null && inHappyHour.equals(true)) bar.order(drink,recipe);
        else {
            List<StringDrinkRequest> drinks = orders.get(bar);
            if(drinks == null) {
                drinks = new ArrayList<>();
                drinks.add(new StringDrinkRequest(drink, recipe));
            } else {
                drinks.add(new StringDrinkRequest(drink, recipe));
            }
            orders.put(bar, drinks);
        }
    }

    @Override
    public void happyHourStarted(Bar bar) {
        happyHourBars.put(bar, true);
        processWaitingOrders(bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {
        happyHourBars.put(bar, false);
    }

    private void processWaitingOrders(Bar bar){
        List<StringDrinkRequest> requests = orders.get(bar);
        if(requests == null) return;
        for(StringDrinkRequest request: requests){
            ((StringBar) bar).order(request.getDrink(), request.getRecipe());
        }
    }
}
