package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @BeforeEach
    void setUp() {
    }

    @InjectMocks
    ProductController productController;

    @Mock
    ProductServiceImpl productService;

    @Test
    void testCreateProductPage() {
        Model model = mock(Model.class);
        String result = productController.createProductPage(model);
        assertEquals("CreateProduct", result);
    }

    @Test
    void testCreateProductPost() {
        Model model = mock(Model.class);
        Product product = new Product();
        Mockito.when(productService.create(product)).thenReturn(product);
        String result = productController.createProductPost(product);
        assertEquals("redirect:list", result);
    }

    @Test
    void testEditProductPage() {
        Model model = mock(Model.class);
        Product product = new Product();
        String result = productController.editProductPage(model, "eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertEquals("EditProduct", result);
    }

    @Test
    void testEditProductPost() {
        Model model = mock(Model.class);
        Product product = new Product();
        String result = productController.editProductPost(product, model,"eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertEquals("redirect:../list", result);
    }

    @Test
    void testDeleteProduct() {
        Model model = mock(Model.class);
        Product product = new Product();
        Mockito.when(productService.delete("eb558e9f-1c39-460e-8860-71af6af63bd6")).thenReturn(product);
        String result = productController.deleteProductGet(model,"eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertEquals("redirect:../list", result);
    }

    @Test
    void testProductListPage() {
        Model model = mock(Model.class);
        String result = productController.productListPage(model);
        assertEquals("ProductList", result);
    }
}