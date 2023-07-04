package BZU.WebServices.service;

import BZU.WebServices.ApiRequestException;
import BZU.WebServices.models.Ordere;

import java.util.List;

public interface OrderService {
    List<Ordere> getAllOrder() throws ApiRequestException;

    Ordere getOrder(int id) throws ApiRequestException;
    void addOrder(Ordere ordere) throws ApiRequestException;
    void updateOrder(int id, Ordere ordere) throws ApiRequestException;
    void deleteOrder(int id) throws ApiRequestException;

}
