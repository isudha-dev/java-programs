package lld.designpatterns.structural.decorator.pizza;

import java.util.ArrayList;

public class TomatoSauceDecorator extends PizzaDecorator {
    public TomatoSauceDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public ArrayList<String> getIngredients() {
        ArrayList<String> list = super.getIngredients();
        list.add("Tomato sauce");
        return list;
    }
}
