package BZU.WebServices.service.impl;


import BZU.WebServices.ApiRequestException;
import BZU.WebServices.models.Customer;
import BZU.WebServices.repositories.CustomerRepo;
import BZU.WebServices.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;


    @Override
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List <Customer> customerList = customerRepo.findAll();
        if(customerList.size() == 0) throw new ApiRequestException("No Customer in the system");
        return ResponseEntity.ok(customerList);
    }

    @Override
    public Customer getCustomer(int id){
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new ApiRequestException(String.format("The Customer that has id %s not found",id)));
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) throws ApiRequestException {
        boolean isCustomerAlreadyExists = customerRepo.findById(customer.getId()).isPresent();
        if(isCustomerAlreadyExists) throw new ApiRequestException("There is no two Customer should have the same id");
        customerRepo.save(customer);
    }

    @Override
    public void updateCustomer(int id, Customer customer) throws ApiRequestException {
        boolean isCustomerExists = customerRepo.findById(id).isPresent();
        if(!isCustomerExists) throw new ApiRequestException("The Customer you are trying to update does not exist");
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(int id) throws ApiRequestException {
        boolean isCustomerExists = customerRepo.findById(id).isPresent();
        if(!isCustomerExists) throw new ApiRequestException("The Customer you are trying to delete does not exist");
        customerRepo.deleteById(id);
    }


}
