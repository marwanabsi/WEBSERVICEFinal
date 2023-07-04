package BZU.WebServices.service;

import BZU.WebServices.ApiRequestException;
import BZU.WebServices.models.ProductOrder;

import java.util.List;

public interface ProductOrderService {
    List<ProductOrder> getAllProductOrder() throws ApiRequestException;

    ProductOrder getProductOrder(int id) throws ApiRequestException;
    void addProductOrder(ProductOrder productOrder) throws ApiRequestException;
    void updateProductOrder(int id,ProductOrder productOrder) throws ApiRequestException;

    void deleteProductOrder(int id) throws ApiRequestException;


}
