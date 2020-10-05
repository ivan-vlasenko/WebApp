package entity.menu;

public class MenuItemFactory {

    public static MenuItem createMenuItem(String name, String cuisine, String category) {

        if (category == null || category.isEmpty())
            return null;

        if ("main".equalsIgnoreCase(category)) {
            return MenuItem.newBuilder()
                    .setCategory(MenuItemCategory.MAIN_MEAL)
                    .setName(name)
                    .fromCuisine(cuisine)
                    .build();
        } else if ("soup".equalsIgnoreCase(category)) {
            return MenuItem.newBuilder()
                    .setCategory(MenuItemCategory.SOUP)
                    .setName(name)
                    .fromCuisine(cuisine)
                    .build();
        } else if ("appetizer".equalsIgnoreCase(category)) {
            return MenuItem.newBuilder()
                    .setCategory(MenuItemCategory.APPETIZER)
                    .setName(name)
                    .fromCuisine(cuisine)
                    .build();
        } else if ("dessert".equalsIgnoreCase(category)) {
            return MenuItem.newBuilder()
                    .setCategory(MenuItemCategory.DESSERT)
                    .setName(name)
                    .fromCuisine(cuisine)
                    .build();
        } else if ("drink".equalsIgnoreCase(category)) {
            return MenuItem.newBuilder()
                    .setCategory(MenuItemCategory.NON_ALCOHOL_DRINK)
                    .setName(name)
                    .fromCuisine(cuisine)
                    .build();
        } else if ("alcohol drink".equalsIgnoreCase(category)) {
            return MenuItem.newBuilder()
                    .setCategory(MenuItemCategory.ALCOHOL_DRINK)
                    .setName(name)
                    .fromCuisine(cuisine)
                    .build();
        }

        return null;
    }
}
