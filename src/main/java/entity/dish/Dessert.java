package entity.dish;


public class Dessert implements Dish {
    private String name;
    private String cuisine;
    private String category;

    private Dessert() {}

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public String getCuisine() {
        return cuisine;
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

        public Builder setCuisine(String cuisine) {
            Dessert.this.cuisine = cuisine;

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
