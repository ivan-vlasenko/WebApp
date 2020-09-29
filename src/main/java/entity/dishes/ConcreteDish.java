package entity.dishes;

public class ConcreteDish extends DishAbstractClass<ConcreteDish> {

    private ConcreteDish() {}

    public static Builder newBuilder() {
        return new ConcreteDish().new Builder();
    }

    public class Builder extends BaseBuilder<Builder> {
        private Builder() {}
    }

}
