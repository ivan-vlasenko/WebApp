package entity.dish;


public class MainDish implements Dish {
    private String name;
    private String cuisine;
    private String category;

    private MainDish() {}

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
        return new MainDish().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setName(String name) {
            MainDish.this.name = name;

            return this;
        }

        public Builder setCuisine(String cuisine) {
            MainDish.this.cuisine = cuisine;

            return this;
        }

        public Builder setCategory(String category) {
            MainDish.this.category = category;

            return this;
        }

        public MainDish build() {
            return MainDish.this;
        }
    }

}
