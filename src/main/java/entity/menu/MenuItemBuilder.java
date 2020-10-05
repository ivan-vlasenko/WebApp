package entity.menu;

public interface MenuItemBuilder {

    MenuItemBuilder setName(String name);

    MenuItemBuilder setCategory(MenuItemCategory category);

    MenuItemBuilder fromCuisine(String cuisine);

    MenuItem build();
}
