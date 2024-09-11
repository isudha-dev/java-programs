package lld.designpatterns.structural.decorator.pizza;

import java.util.ArrayList;
import java.util.List;

public class BasePizza implements Pizza{
    @Override
    public ArrayList<String> getIngredients() {
        return new ArrayList<>(List.of("Pizza dough"));
    }
}
