public class App {
    public static void main(String[] args) {
        MyLinkedList food = new MyLinkedList();
        food.add("pizza");
        food.add("tiramisu");
        food.add("pasta");
        food.add("frittura mista");
        food.add("ice cream");
        food.add("chicheti");
        food.set("risotto", 3);

        MyLinkedList drink = new MyLinkedList<>();
        drink.add("wine");
        drink.add("prosecco");
        drink.add("aperol");
        food.addAll(drink);
        food.add("camariere", 2);
        food.remove("pasta");
        System.out.println("Size is " + food.size());
        for (int i = 0; i < food.size(); i++) {
            System.out.println((i + 1) + "-" + food.get(i));
        }
    }
}
