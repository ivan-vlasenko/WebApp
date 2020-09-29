package entity.dishes;

public class Soup implements Dish {
    private String name;
    private String category;

    private Soup() {}

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public static Builder newBuilder() {
        return new Soup().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setName(String name) {
            Soup.this.name = name;

            return this;
        }

        public Soup.Builder setCategory(String category) {
            Soup.this.category = category;

            return this;
        }

        public Soup build() {
            return Soup.this;
        }
    }

}
