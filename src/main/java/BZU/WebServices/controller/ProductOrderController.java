package BZU.WebServices.controller;


import BZU.WebServices.models.ProductOrder;
import BZU.WebServices.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "productOrder")
public class ProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;

    @GetMapping
    public List<ProductOrder> getAllProduct()  {
        return productOrderService.getAllProductOrder();
    }


    @GetMapping(value = "ids")
    public ProductOrder getProductOrderById(@PathVariable int id){
        return productOrderService.getProductOrder(id);
    }

    @PostMapping
    public void addProductOrder(@RequestBody ProductOrder productOrder){
        productOrderService.addProductOrder(productOrder);
    }



    @PatchMapping
    public void updateProductOrder(@PathVariable int id,@RequestBody ProductOrder productOrder){
        productOrderService.updateProductOrder(id, productOrder);
    }

    @DeleteMapping
    public void deleteProductOrder(@PathVariable int id){
        productOrderService.deleteProductOrder(id);
    }
}
