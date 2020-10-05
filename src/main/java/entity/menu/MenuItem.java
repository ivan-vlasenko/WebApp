package entity.menu;


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

    public static MenuItemBuilderImpl newBuilder() {
        return new MenuItem().new MenuItemBuilderImpl();
    }

    public class MenuItemBuilderImpl implements MenuItemBuilder {

        private MenuItemBuilderImpl() {}

        @Override
        public MenuItemBuilderImpl setName(String name) {
            MenuItem.this.name = name;

            return this;
        }

        @Override
        public MenuItemBuilderImpl setCategory(MenuItemCategory category) {
            MenuItem.this.category = category;

            return this;
        }

        @Override
        public MenuItemBuilderImpl fromCuisine(String cuisine) {
            MenuItem.this.cuisine = cuisine;

            return this;
        }

        @Override
        public MenuItem build() {
            return MenuItem.this;
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
