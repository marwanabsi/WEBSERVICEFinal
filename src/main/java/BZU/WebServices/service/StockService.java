package BZU.WebServices.service;

import BZU.WebServices.ApiRequestException;
import BZU.WebServices.models.Stock;

import java.util.List;

public interface StockService {
    List<Stock> getAllStock() throws ApiRequestException;

    Stock getStock(int id) throws ApiRequestException;
    void addStock(Stock stock) throws ApiRequestException;
    void updateStock(int id,Stock stock) throws ApiRequestException;
    void deleteStock(int id) throws ApiRequestException;

}
