package entity;

import java.util.Objects;

public class Drink {
    private String name;
    private String category;
    private String cuisine;

    public Drink(String name, String category, String cuisine) {
        this.name = name;
        this.category = category;
        this.cuisine = cuisine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return Objects.equals(name, drink.name) &&
                Objects.equals(category, drink.category) &&
                Objects.equals(cuisine, drink.cuisine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, cuisine);
    }
}
