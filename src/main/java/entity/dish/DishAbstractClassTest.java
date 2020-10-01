package entity.dish;

public abstract class DishAbstractClassTest<T extends DishAbstractClassTest<T>> {
    private String name;
    private String cuisine;
    private String category;

    //private DishAbstractClass() {}

    public String getName() {
        return name;
    }
    public String getCuisine() {
        return cuisine;
    }
    public String getCategory() {
        return category;
    }

    public abstract class BaseBuilder<B extends BaseBuilder<B>>{

        //private BaseBuilder() {}

        public BaseBuilder<B> setCuisine(String cuisine) {
            DishAbstractClassTest.this.cuisine = cuisine;

            return this;
        }
        public BaseBuilder<B> setName(String name) {
            DishAbstractClassTest.this.name = name;

            return this;
        }
        public BaseBuilder<B> setCategory(String category) {
            DishAbstractClassTest.this.category = category;

            return this;
        }
        public DishAbstractClassTest<T> build() {
            return DishAbstractClassTest.this;
        }
    }
}
