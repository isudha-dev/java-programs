package test.lld.designpatterns.structural.decorator;

import lld.designpatterns.structural.decorator.pizza.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PizzaTest {
    Pizza basePizza = null;

    @BeforeEach
    public void setUp(){
        basePizza = new BasePizza();
    }


    @Test
    public void test() {
        ArrayList<String> list = basePizza.getIngredients();
        assert list.contains("Pizza dough");

        Pizza saucePizza = new TomatoSauceDecorator(basePizza);
        list = saucePizza.getIngredients();
        assert list.containsAll(Arrays.asList("Pizza dough", "Tomato sauce"));

        Pizza paneerPizza = new PaneerDecorator(saucePizza);
        list = paneerPizza.getIngredients();
        assert list.containsAll(Arrays.asList("Pizza dough", "Tomato sauce", "Paneer"));

        Pizza cheesePizza = new CheeseDecorator(paneerPizza);
        list = cheesePizza.getIngredients();
        assert list.containsAll(Arrays.asList("Pizza dough", "Tomato sauce", "Paneer", "Cheese"));
    }
}
