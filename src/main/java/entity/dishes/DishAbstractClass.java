package entity.dishes;

public abstract class DishAbstractClass<T extends DishAbstractClass<T>> {
    private String name;
    private String cuisine;
    private String category;

    private DishAbstractClass() {}

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

        private BaseBuilder() {}

        public BaseBuilder<B> setCuisine(String cuisine) {
            DishAbstractClass.this.cuisine = cuisine;

            return this;
        }
        public BaseBuilder<B> setName(String name) {
            DishAbstractClass.this.name = name;

            return this;
        }
        public BaseBuilder<B> setCategory(String category) {
            DishAbstractClass.this.category = category;

            return this;
        }
        public DishAbstractClass<T> build() {
            return DishAbstractClass.this;
        }
    }
}
