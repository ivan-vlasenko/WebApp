package entity.dishes;


public class Appetizer implements Dish {
    private String name;
    private String category;

    private Appetizer() {}

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public static Builder newBuilder() {
        return new Appetizer().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setName(String name) {
            Appetizer.this.name = name;

            return this;
        }

        public Builder setCategory(String category) {
            Appetizer.this.category = category;

            return this;
        }

        public Appetizer build() {
            return Appetizer.this;
        }
    }
}
