package BZU.WebServices.service;

import BZU.WebServices.ApiRequestException;
import BZU.WebServices.models.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService  {

    ResponseEntity<List<Customer>> getAllCustomer() throws ApiRequestException;

    Customer getCustomer(int id) throws ApiRequestException;
    void addCustomer(Customer customer) throws ApiRequestException;
    void updateCustomer(int id, Customer customer) throws ApiRequestException;

    void deleteCustomer(int id) throws ApiRequestException;

}
