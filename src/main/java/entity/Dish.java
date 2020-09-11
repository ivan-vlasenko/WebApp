package entity;

import java.util.Objects;

public class Dish {
    private String name;
    private String cuisine;
    private String category;

    public Dish(String name, String cuisine, String category) {
        this.name = name;
        this.cuisine = cuisine;
        this.category = category;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(name, dish.name) &&
                Objects.equals(cuisine, dish.cuisine) &&
                Objects.equals(category, dish.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cuisine, category);
    }
}
