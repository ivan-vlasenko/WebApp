package entity.dishes;


public class Dessert implements Dish {
    private String name;
    private String category;

    private Dessert() {}

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public static Builder newBuilder() {
        return new Dessert().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setName(String name) {
            Dessert.this.name = name;

            return this;
        }

        public Builder setCategory(String category) {
            Dessert.this.category = category;

            return this;
        }

        public Dessert build() {
            return Dessert.this;
        }
    }
}
