package com.gooddata.knapsack;

/**
 * TODO
 */
public class Item {
    private int weight;
    private int value = 1;

    public Item(int weight) {
        this.weight = weight;
    }

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Item item = (Item) o;

        if (value != item.value)
            return false;
        if (weight != item.weight)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = weight;
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}
