package entity.dish;

public class Soup extends AbstractMenuItem<Soup> {
    private Soup() {}

    public static MenuBuilder newBuilder() {
        return new Soup().new MenuBuilder();
    }

    public class MenuBuilder extends AbstractMenuBuilder<MenuBuilder> {
        private MenuBuilder() {}
    }
}
