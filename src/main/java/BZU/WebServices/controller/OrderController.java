package BZU.WebServices.controller;


import BZU.WebServices.models.Ordere;
import BZU.WebServices.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ordere")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Ordere> getAllOrder()  {
        return orderService.getAllOrder();
    }


    @GetMapping(value = "ids")
    public Ordere getOrderById(@PathVariable int id){
        return orderService.getOrder(id);
    }

    @PostMapping
    public void addOrder(@RequestBody Ordere ordere){
        orderService.addOrder(ordere);
    }



    @PatchMapping
    public void updateOrder(@PathVariable int id,@RequestBody Ordere ordere){
        orderService.updateOrder(id, ordere);
    }

    @DeleteMapping
    public void deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
    }
}
