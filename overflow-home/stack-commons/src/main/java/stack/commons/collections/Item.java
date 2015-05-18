package stack.commons.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Item {
    private int worth;

    public Item(int worth) {
        this.worth = worth;
    }

    public int getWorth() { return worth; }
}

 class Foo {
    public Foo() {
       List<Item> items = new ArrayList<Item>();
       items.add(new Item(50));
       items.add(new Item(892));
       items.add(new Item(12));
     
    }
}