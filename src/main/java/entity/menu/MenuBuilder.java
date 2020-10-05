package entity.menu;

public interface MenuBuilder {

    MenuBuilder setName(String name);

    MenuBuilder setCategory(MenuItemCategory category);

    MenuBuilder fromCuisine(String cuisine);

    MenuItem build();
}
