public class App {
    public static void main(String[] args) throws Exception {
        
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Product 1", 20.0, 3);
        cart.addItem("Product 2", 99.99, 1);
        cart.addItem("Product 3", 10.0, 1);
        System.out.println("Total = "+ cart.calculateTotal());
        cart.removeItem("Product 1");
        cart.showItems();
    }
}
