package entity.dish;

import java.util.Objects;

public abstract class AbstractMenuItem<T extends AbstractMenuItem<T>> implements MenuItem {
    private String name;
    private String cuisine;
    private String category;
    private boolean isDiabetic;
    private boolean isGlutenFree;
    private boolean isAlcoholic;

    public boolean isDiabetic() {
        return isDiabetic;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getCategory() {
        return category;
    }


    public abstract class AbstractMenuBuilder<B extends AbstractMenuBuilder<B>> {

        public AbstractMenuBuilder<B> isAlcoholic(boolean isAlcoholic) {
            AbstractMenuItem.this.isAlcoholic = isAlcoholic;

            return this;
        }

        public AbstractMenuBuilder<B> isDiabetic(boolean isDiabetic) {
            AbstractMenuItem.this.isDiabetic = isDiabetic;

            return this;
        }

        public AbstractMenuBuilder<B> isGlutenFree(boolean isGlutenFree) {
            AbstractMenuItem.this.isGlutenFree = isGlutenFree;

            return this;
        }

        public AbstractMenuBuilder<B> setName(String name) {
            AbstractMenuItem.this.name = name;

            return this;
        }

        public AbstractMenuBuilder<B> fromCategory(String category) {
            AbstractMenuItem.this.category = category;

            return this;
        }

        public AbstractMenuBuilder<B> fromCuisine(String cuisine) {
            AbstractMenuItem.this.cuisine = cuisine;

            return this;
        }

        public MenuItem build() {
            return AbstractMenuItem.this;
        }
    }

    @Override
    public String toString() {
        return "AbstractDish{" +
                "name='" + name + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractMenuItem<?> that = (AbstractMenuItem<?>) o;
        return isDiabetic == that.isDiabetic &&
                isGlutenFree == that.isGlutenFree &&
                isAlcoholic == that.isAlcoholic &&
                Objects.equals(name, that.name) &&
                Objects.equals(cuisine, that.cuisine) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cuisine, category, isDiabetic, isGlutenFree, isAlcoholic);
    }
}
