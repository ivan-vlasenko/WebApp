package entity.drinks;

import java.util.Objects;

public class Drink {
    private String name;
    private String cuisine;
    private String category;

    public Drink(String name, String cuisine, String category) {
        this.name = name;
        this.cuisine = cuisine;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return Objects.equals(name, drink.name) &&
                Objects.equals(cuisine, drink.cuisine) &&
                Objects.equals(category, drink.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cuisine, category);
    }
}
