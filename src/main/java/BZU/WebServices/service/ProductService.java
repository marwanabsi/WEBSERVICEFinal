package BZU.WebServices.service;

import BZU.WebServices.ApiRequestException;
import BZU.WebServices.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct() throws ApiRequestException;

    Product getProduct(int id) throws ApiRequestException;
    void addProduct(Product product) throws ApiRequestException;
    void updateProduct(int id,Product product) throws ApiRequestException;
    void deleteProduct(int id) throws ApiRequestException;

}
