package entity.dish;

public class DishFactory {

    public static Dish createDish(String name, String cuisine, String category) {

        if (category == null || category.isEmpty())
            return null;

        if ("main".equalsIgnoreCase(category)) {
            return MainDish.newBuilder()
                    .setName(name)
                    .setCuisine(cuisine)
                    .setCategory(category)
                    .build();
        } else if ("soup".equalsIgnoreCase(category)) {
            return Soup.newBuilder()
                    .setName(name)
                    .setCuisine(cuisine)
                    .setCategory(category)
                    .build();
        } else if ("appetizer".equalsIgnoreCase(category)) {
            return Appetizer.newBuilder()
                    .setName(name)
                    .setCuisine(cuisine)
                    .setCategory(category)
                    .build();
        } else if ("dessert".equalsIgnoreCase(category)) {
            return Dessert.newBuilder()
                    .setName(name)
                    .setCuisine(cuisine)
                    .setCategory(category)
                    .build();
        } else if ("drink".equalsIgnoreCase(category)) {
            return NonAlcoholDrink.newBuilder()
                    .setName(name)
                    .setCuisine(cuisine)
                    .setCategory(category)
                    .build();
        } else if ("alcohol drink".equalsIgnoreCase(category)) {
            return AlcoholDrink.newBuilder()
                    .setName(name)
                    .setCuisine(cuisine)
                    .setCategory(category)
                    .build();
        }

        return null;
    }
}
