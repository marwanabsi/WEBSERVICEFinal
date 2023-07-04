package BZU.WebServices.controller;

import BZU.WebServices.models.Product;
import BZU.WebServices.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProduct()  {
        return productService.getAllProduct();
    }


    @GetMapping(value = "ids")
    public Product getProductById(@PathVariable int id){
        return productService.getProduct(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }



    @PatchMapping
    public void updateProduct(@PathVariable int id,@RequestBody Product product){
        productService.updateProduct(id, product);
    }

    @DeleteMapping
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }

}
