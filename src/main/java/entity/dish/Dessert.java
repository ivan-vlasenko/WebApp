package entity.dish;


public class Dessert extends AbstractMenuItem<Dessert> {
    private Dessert() {}

    public static MenuBuilder newBuilder() {
        return new Dessert().new MenuBuilder();
    }

    public class MenuBuilder extends AbstractMenuBuilder<MenuBuilder> {
        private MenuBuilder() {}
    }
}
