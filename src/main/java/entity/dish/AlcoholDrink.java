package entity.dish;


public class AlcoholDrink extends AbstractMenuItem<AlcoholDrink> {
    private AlcoholDrink() {}

    public static MenuBuilder newBuilder() {
        return new AlcoholDrink().new MenuBuilder();
    }

    public class MenuBuilder extends AbstractMenuBuilder<MenuBuilder> {
        private MenuBuilder() {}
    }
}
