import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Julian Canepa
 * @version Feb 13, 2021
 */
public class StockManager
{
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list if the ID is not already in use.
     * 
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        boolean unique = (
            findProduct(item.getID()) == null
        );
        
        if (unique) {
            stock.add(item);
        }
    }
    
    /**
     * Increase the quantity of the product by the given delivered amount.
     * 
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);
        
        if (product == null) { return; }
        
        product.increaseQuantity(amount);
    }
    
    /**
     * Try to find a product in stock with the given id.
     * @return Product | null
     */
    public Product findProduct(int id)
    {
        stock.trimToSize();
        int index = 0;
        
        while (index < stock.size()) {
            Product product = stock.get(index);

            if (product.getID() == id) {
                return product;
            }
            index ++;
        }
        return null;
    }
    
    /**
     * Try to find a product in stock with the given name.
     */
    public Product findProduct(String name)
    {
        stock.trimToSize();
        int index = 0;
        
        while (index < stock.size()) {
            Product product = stock.get(index);

            if (product.getName().equals(name)) {
                return product;
            }
            index ++;
        }
        return null;
    }
    
    /**
     * Locate a product with the given ID and
     * return how many of this item are in stock.
     * Return zero if ID does not match any product.
     * 
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product product = findProduct(id);
        
        if (product == null) { return 0; }
        
        return product.getQuantity();
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product product : stock) {
            System.out.println(
                product.toString()
            );
        }
    }
    
    /**
     * Print a list of products with quantities below a given threshold.
     */
    public void printLowInStock(int threshold)
    {
        for (Product product : stock) {
            if (product.getQuantity() < threshold) {
                System.out.println(product.toString());
            }
        }
    }
}
