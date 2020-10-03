package entity.dish;


public class MainMeal extends AbstractMenuItem<MainMeal> {
    private MainMeal() {}

    public static MenuBuilder newBuilder() {
        return new MainMeal().new MenuBuilder();
    }

    public class MenuBuilder extends AbstractMenuBuilder<MenuBuilder> {
        private MenuBuilder() {}
    }
}
