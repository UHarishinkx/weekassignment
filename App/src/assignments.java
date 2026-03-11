import java.util.*;

class InventoryManager {

    HashMap<String, Integer> stock = new HashMap<>();
    HashMap<String, Queue<Integer>> waitingList = new HashMap<>();

    public void addProduct(String productId, int quantity) {
        stock.put(productId, quantity);
        waitingList.put(productId, new LinkedList<>());
    }

    public synchronized String purchaseItem(String productId, int userId) {

        if (!stock.containsKey(productId)) {
            return "Product not found";
        }

        int currentStock = stock.get(productId);

        if (currentStock > 0) {
            stock.put(productId, currentStock - 1);
            return "Success, remaining: " + (currentStock - 1);
        }

        waitingList.get(productId).add(userId);
        return "Added to waiting list, position: " + waitingList.get(productId).size();
    }

    public int checkStock(String productId) {

        if (!stock.containsKey(productId)) {
            return 0;
        }

        return stock.get(productId);
    }

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        manager.addProduct("IPHONE15_256GB", 3);

        System.out.println("Stock: " + manager.checkStock("IPHONE15_256GB"));

        System.out.println(manager.purchaseItem("IPHONE15_256GB", 101));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 102));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 103));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 104));

        System.out.println("Remaining stock: " + manager.checkStock("IPHONE15_256GB"));
    }
}