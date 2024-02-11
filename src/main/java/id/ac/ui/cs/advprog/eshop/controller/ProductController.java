package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage (Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost (@ModelAttribute Product product) {
        service.create(product);
        return "redirect:list";
    }


    @GetMapping(value="/edit/{id}")
    public String editProductPage(Model model, @PathVariable("id") String productId) {

        Product product = new Product();
        product.setProductId(productId);

        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PostMapping(value="/edit/{id}")
    public String editProductPost(@ModelAttribute Product product, Model model, @PathVariable("id") String productId) {

        product.setProductId(productId); // Reasoning: After posted by form, id becomes null
        service.edit(product);
        return "redirect:../list";
    }


    @GetMapping("/delete/{idProductDelete}")
    public String deleteProductGet (Model model, @PathVariable String idProductDelete) {
        service.delete(idProductDelete);
        return "redirect:../list";
    }



    @GetMapping("/list")
    public String productListPage (Model model) {
        List <Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";
    }
}