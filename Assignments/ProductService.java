package Assignments;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public String findProductNameByCode(int productCode) {
        for (Product product : ProductRepository.getProducts()) {
            if (product.getProductCode() == productCode) {
                return product.getName();
            }
        }
        return null;
    }

    public Product findMaxPriceProductInCategory(String category) {
        Product maxPriceProduct = null;
        double maxPrice = Double.MIN_VALUE;

        for (Product product : ProductRepository.getProducts()) {
            if (product.getCategory().equalsIgnoreCase(category) && product.getPrice() > maxPrice) {
                maxPriceProduct = product;
                maxPrice = product.getPrice();
            }
        }

        return maxPriceProduct;
    }

    public Product[] getProductsByCategory(String category) {
        List<Product> productsInCategory = new ArrayList<>();

        for (Product product : ProductRepository.getProducts()) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                productsInCategory.add(product);
            }
        }

        if (productsInCategory.isEmpty()) {
            return null;
        }

        return productsInCategory.toArray(new Product[0]);
    }
}