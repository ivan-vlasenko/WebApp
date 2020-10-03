package entity.dish;


public class Appetizer extends AbstractMenuItem<Appetizer> {
    private Appetizer() {}

    public static MenuBuilder newBuilder() {
        return new Appetizer().new MenuBuilder();
    }

    public class MenuBuilder extends AbstractMenuBuilder<MenuBuilder> {
        private MenuBuilder() {}
    }
}
