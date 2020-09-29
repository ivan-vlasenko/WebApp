package entity.dishes;

public class Test {
    public static void main(String[] args) {
        DishAbstractClass concreteDish = ConcreteDish.newBuilder()
                .setName("123")
                .setCategory("sada")
                .setCuisine("sadaran")
                .build();
    }
}
