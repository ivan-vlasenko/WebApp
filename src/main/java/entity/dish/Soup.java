package entity.dish;

public class Soup implements Dish {
    private String name;
    private String cuisine;
    private String category;

    private Soup() {}

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
        return new Soup().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setName(String name) {
            Soup.this.name = name;

            return this;
        }

        public Soup.Builder setCuisine(String cuisine) {
            Soup.this.cuisine = cuisine;

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
