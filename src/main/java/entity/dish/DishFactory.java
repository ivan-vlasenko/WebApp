package entity.dish;

public class DishFactory {

    public static MenuItem createDish(String name, String cuisine, String category) {

        if (category == null || category.isEmpty())
            return null;

        if ("main".equalsIgnoreCase(category)) {
            return MainMeal.newBuilder()
                    .setName(name)
                    .fromCuisine(cuisine)
                    .fromCategory(category)
                    .build();
        } else if ("soup".equalsIgnoreCase(category)) {
            return Soup.newBuilder()
                    .setName(name)
                    .fromCuisine(cuisine)
                    .fromCategory(category)
                    .build();
        } else if ("appetizer".equalsIgnoreCase(category)) {
            return Appetizer.newBuilder()
                    .setName(name)
                    .fromCuisine(cuisine)
                    .fromCategory(category)
                    .build();
        } else if ("dessert".equalsIgnoreCase(category)) {
            return Dessert.newBuilder()
                    .setName(name)
                    .fromCuisine(cuisine)
                    .fromCategory(category)
                    .build();
        } else if ("drink".equalsIgnoreCase(category)) {
            return NonAlcoholDrink.newBuilder()
                    .setName(name)
                    .fromCuisine(cuisine)
                    .fromCategory(category)
                    .isAlcoholic(false)
                    .build();
        } else if ("alcohol drink".equalsIgnoreCase(category)) {
            return AlcoholDrink.newBuilder()
                    .setName(name)
                    .fromCuisine(cuisine)
                    .fromCategory(category)
                    .isAlcoholic(true)
                    .build();
        }

        return null;
    }
}
