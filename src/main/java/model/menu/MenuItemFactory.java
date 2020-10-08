package model.menu;

public class MenuItemFactory {

    private MenuItemFactory() {}

    public static MenuItem createMenuItem(String name, String cuisine, String category) {

        if (category == null || category.isEmpty())
            return null;

        switch (category.toLowerCase()) {
            case "main":
                return MenuItem.newBuilder()
                        .setCategory(MenuItemCategory.MAIN_MEAL)
                        .setName(name)
                        .fromCuisine(cuisine)
                        .build();
            case "soup":
                return MenuItem.newBuilder()
                        .setCategory(MenuItemCategory.SOUP)
                        .setName(name)
                        .fromCuisine(cuisine)
                        .build();
            case "appetizer":
                return MenuItem.newBuilder()
                        .setCategory(MenuItemCategory.APPETIZER)
                        .setName(name)
                        .fromCuisine(cuisine)
                        .build();
            case "dessert":
                return MenuItem.newBuilder()
                        .setCategory(MenuItemCategory.DESSERT)
                        .setName(name)
                        .fromCuisine(cuisine)
                        .build();
            case "drink":
                return MenuItem.newBuilder()
                        .setCategory(MenuItemCategory.NON_ALCOHOL_DRINK)
                        .setName(name)
                        .fromCuisine(cuisine)
                        .build();
            case "alcohol drink":
                return MenuItem.newBuilder()
                        .setCategory(MenuItemCategory.ALCOHOL_DRINK)
                        .setName(name)
                        .fromCuisine(cuisine)
                        .build();
            default: return null;
        }
    }
}
