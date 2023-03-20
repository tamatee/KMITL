package pack7Association;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<String, Product> productList;
    private Map<String, Integer> priceList;

    public Catalog() {
        productList = new HashMap<>();
        priceList = new HashMap<>();
    }
    public Product getProduct(String pName) {
        return productList.get(pName);
    }
    public int getPrice(String pName) {
        return priceList.get(pName);
    }
    public void add(Product p, int price) {
        boolean bo = false;
        for (Product pro : productList.values()) {
            System.out.println(p.getpName().equals(pro.getpName()));
            if (p.getpName().equals(pro.getpName())) {
                bo = true;
            }
            if (!bo) {
                productList.put(p.getpName(), p);
                priceList.put(p.getpName(), price);
            }
        }
    }
    public void showCatalog() {
        for (String a : productList.keySet()) {
            System.out.println(this.getProduct(a).getpName() + " @ " + this.getPrice(a));
        }
    }
}
