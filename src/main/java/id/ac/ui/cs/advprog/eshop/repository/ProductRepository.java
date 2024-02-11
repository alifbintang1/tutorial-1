package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List <Product> productData = new ArrayList<>();

    public Product create (Product product) {
        product.setProductId(String.valueOf(UUID.randomUUID()));
        productData.add(product);
        return product;
    }
    public Product edit(Product product){
        System.out.println("MASUK SINI");
        for (Product currentProduct: productData) {
            System.out.println("currentProduct.getProductId() = " + currentProduct.getProductId());
            if (currentProduct.getProductId().equals(product.getProductId())) {
                currentProduct.setProductQuantity(product.getProductQuantity());
                currentProduct.setProductName(product.getProductName());
                return currentProduct;
            }
        }
        return null;
    }

    public Product delete (String idProductDelete) {
        for (Product currentProduct : productData) {
            if (currentProduct.getProductId().equals(idProductDelete)) {
                productData.remove(currentProduct);
                return currentProduct;
            }
        }
        return null;
    }
    public Iterator <Product> findAll() {
        return productData.iterator();
    }
}