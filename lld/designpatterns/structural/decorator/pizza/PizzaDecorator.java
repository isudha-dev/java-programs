package lld.designpatterns.structural.decorator.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class PizzaDecorator implements Pizza {
    protected Pizza decoratedPizza;

    public PizzaDecorator(Pizza pizza){
        this.decoratedPizza = pizza;
    }

    @Override
    public ArrayList<String> getIngredients() {
        return new ArrayList<>(decoratedPizza.getIngredients());
    }
}
