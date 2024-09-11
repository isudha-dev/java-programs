package lld.designpatterns.structural.decorator.pizza;

import java.util.ArrayList;

public class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza nextLater) {
        super(nextLater);
    }

    @Override
    public ArrayList<String> getIngredients() {
        ArrayList<String> list = super.getIngredients();
        list.add("Cheese");
        return list;
    }
}
