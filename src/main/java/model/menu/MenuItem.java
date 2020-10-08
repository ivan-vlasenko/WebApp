package model.menu;


import java.util.Objects;

public class MenuItem {
    private String name;
    private String cuisine;
    private MenuItemCategory category;

    private MenuItem() {}

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public MenuItemCategory getCategory() {
        return category;
    }

    public static MenuItemBuilder newBuilder() {
        return new MenuItemBuilder();
    }

    public static class MenuItemBuilder {
        private String name;
        private String cuisine;
        private MenuItemCategory category;

        private MenuItemBuilder() {}

        public MenuItemBuilder setName(String name) {
            this.name = name;

            return this;
        }

        public MenuItemBuilder setCategory(MenuItemCategory category) {
            this.category = category;

            return this;
        }

        public MenuItemBuilder fromCuisine(String cuisine) {
            this.cuisine = cuisine;

            return this;
        }

        public MenuItem build() {
            MenuItem menuItem = new MenuItem();

            menuItem.name = this.name;
            menuItem.category = this.category;
            menuItem.cuisine = this.cuisine;

            return menuItem;
        }
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(name, menuItem.name) &&
                Objects.equals(cuisine, menuItem.cuisine) &&
                category == menuItem.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cuisine, category);
    }
}
