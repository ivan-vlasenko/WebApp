package entity.dishes;

public class DishFactory {

    public static Dish createDish(String category) {

        if (category == null || category.isEmpty())
            return null;

        if ("main".equalsIgnoreCase(category)) {
            return MainDish.newBuilder()
                    .setCategory(category)
                    .build();
        } else if ("soup".equalsIgnoreCase(category)) {
            return Soup.newBuilder()
                    .setCategory(category)
                    .build();
        } else if ("appetizer".equalsIgnoreCase(category)) {
            return Appetizer.newBuilder()
                    .setCategory(category)
                    .build();
        } else if ("dessert".equalsIgnoreCase(category)) {
            return Dessert.newBuilder().setCategory(category).build();
        }

        return null;
    }
}
