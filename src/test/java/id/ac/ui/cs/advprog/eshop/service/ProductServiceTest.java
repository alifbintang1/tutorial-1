package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MockitoExtension.class)

public class ProductServiceTest {
    @InjectMocks
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl service;

    Product createProduct(String name, String id, int quantity){
        Product product = new Product();
        product.setProductId(id);
        product.setProductName(name);
        product.setProductQuantity(quantity);

        return product;
    }

//    @Test
//    void testCreateProduct(){
//        Product newProduct = createProduct("nama","id",1);
//        Product result = service.create(newProduct);
//        newProduct.setProductId("id"); // productRepo.create changes the id
//
//        assertEquals(newProduct.getProductId(), result.getProductId());
//        assertEquals(newProduct.getProductName(), result.getProductName());
//        assertEquals(newProduct.getProductQuantity(), result.getProductQuantity());
//    }
//
//    @Test
//    void testFindAllProduct(){
//        Product product1 = createProduct("nama","id",1);
//        service.create(product1);
//        product1.setProductId("id"); // productRepo.create changes the id
//
//        Product product2 = createProduct("nomu","uwu",2);
//        service.create(product2);
//        product2.setProductId("uwu");
//
//        List<Product> list = service.findAll();
//
//        assertEquals("id", list.get(0).getProductId());
//        assertEquals("nama", list.get(0).getProductName());
//        assertEquals(1, list.get(0).getProductQuantity());
//        assertEquals("uwu", list.get(1).getProductId());
//        assertEquals("nomu", list.get(1).getProductName());
//        assertEquals(2, list.get(1).getProductQuantity());
//    }
//
//    @Test
//    void testEditGetProduct(){
//        Product product1 = createProduct("nama","id",1);
//        service.create(product1);
//        product1.setProductId("id"); // productRepo.create changes the id
//
//        Product product2 = createProduct("nomu","id",2);
//        boolean hasEdit = service.edit(product2);
//        Product resultEdit = service.getProduct(product1.getProductId());
//
//        assertTrue(hasEdit);
//
//        assertEquals("id", resultEdit.getProductId());
//        assertEquals("nomu", resultEdit.getProductName());
//        assertEquals(2, resultEdit.getProductQuantity());
//    }
//    @Test
//    void testCreateDeleteProduct(){
//        Product product1 = createProduct("nama","id",1);
//        service.create(product1);
//        product1.setProductId("id"); // productRepo.create changes the id
//
//        boolean hasDelete = service.delete("id");
//
//        List<Product> list = service.findAll();
//        assertTrue(hasDelete);
//        assertEquals(0,list.size());
//    }
}