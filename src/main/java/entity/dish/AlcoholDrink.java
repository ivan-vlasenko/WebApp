package entity.dish;


public class AlcoholDrink implements Dish {
    private String name;
    private String cuisine;
    private String category;

    private AlcoholDrink() {}

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
        return new AlcoholDrink().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setName(String name) {
            AlcoholDrink.this.name = name;

            return this;
        }

        public Builder setCuisine(String cuisine) {
            AlcoholDrink.this.cuisine = cuisine;

            return this;
        }
        public Builder setCategory(String category) {
            AlcoholDrink.this.category = category;

            return this;
        }

        public AlcoholDrink build() {
            return AlcoholDrink.this;
        }
    }
}
