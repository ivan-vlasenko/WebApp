package entity.dish;


public class NonAlcoholDrink extends AbstractMenuItem<NonAlcoholDrink> {
    private NonAlcoholDrink() {}

    public static MenuBuilder newBuilder() {
        return new NonAlcoholDrink().new MenuBuilder();
    }

    public class MenuBuilder extends AbstractMenuBuilder<MenuBuilder> {
        private MenuBuilder() {}
    }
}
