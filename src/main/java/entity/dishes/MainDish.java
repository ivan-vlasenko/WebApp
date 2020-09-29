package entity.dishes;


public class MainDish implements Dish {
    private String name;
    private String category;

    private MainDish() {}

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
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

        public Builder setCategory(String category) {
            MainDish.this.category = category;

            return this;
        }

        public MainDish build() {
            return MainDish.this;
        }
    }

}
