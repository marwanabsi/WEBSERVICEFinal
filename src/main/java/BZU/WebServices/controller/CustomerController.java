package BZU.WebServices.controller;

import BZU.WebServices.models.Customer;
import BZU.WebServices.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer()  {
        return customerService.getAllCustomer();
    }


    @GetMapping(value = "ids")
    public Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }



    @PatchMapping
    public void updateCustomer(@PathVariable int id,@RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable int id){
        customerService.deleteCustomer(id);
    }


}
