package lld.designpatterns.structural.decorator.pizza;

import java.util.ArrayList;

public class PaneerDecorator extends PizzaDecorator{
    public PaneerDecorator(Pizza nextLater) {
        super(nextLater);
    }

    @Override
    public ArrayList<String> getIngredients() {
        ArrayList<String> list = super.getIngredients();
        list.add("Paneer");
        return list;
    }
}
