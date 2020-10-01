package entity.dish;


public class NonAlcoholDrink implements Dish {
    private String name;
    private String cuisine;
    private String category;

    private NonAlcoholDrink() {}

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
        return new NonAlcoholDrink().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setName(String name) {
            NonAlcoholDrink.this.name = name;

            return this;
        }

        public Builder setCuisine(String cuisine) {
            NonAlcoholDrink.this.cuisine = cuisine;

            return this;
        }
        public Builder setCategory(String category) {
            NonAlcoholDrink.this.category = category;

            return this;
        }

        public NonAlcoholDrink build() {
            return NonAlcoholDrink.this;
        }
    }
}
