package entity.dishes;

public class DishFactory {

    public Dish createDish(String category) {

        if (category == null || category.isEmpty())
            return null;
        if ("main".equalsIgnoreCase(category)) {
            return new MainDish();
        } else if ("soup".equalsIgnoreCase(category)) {
            return new Soup();
        } else if ("appetizer".equalsIgnoreCase(category)) {
            return new Appetizer();
        } else if ("dessert".equalsIgnoreCase(category)) {
            return new Dessert();
        }
        return null;
    }
}
