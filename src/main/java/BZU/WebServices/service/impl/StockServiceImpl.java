package BZU.WebServices.service.impl;

import BZU.WebServices.ApiRequestException;
import BZU.WebServices.models.Stock;
import BZU.WebServices.repositories.StockRepo;
import BZU.WebServices.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepo stockRepo;


    @Override
    public List<Stock> getAllStock(){
        List <Stock> stockList = stockRepo.findAll();
        if(stockList.size() == 0) throw new ApiRequestException("No Stock in the system");
        return stockList;
    }

    @Override
    public Stock getStock(int id){
        Stock stock = stockRepo.findById(id).orElseThrow(() -> new ApiRequestException(String.format("The Stock that has id %s not found",id)));
        return stock;
    }

    @Override
    public void addStock(Stock stock) throws ApiRequestException {
        boolean isStockAlreadyExists = stockRepo.findById(stock.getId()).isPresent();
        if(isStockAlreadyExists) throw new ApiRequestException("There is no two Customer should have the same id");
        stockRepo.save(stock);
    }

    @Override
    public void updateStock(int id, Stock stock) throws ApiRequestException {
        boolean isStockExists = stockRepo.findById(id).isPresent();
        if(!isStockExists) throw new ApiRequestException("The Stock you are trying to update does not exist");
        stockRepo.save(stock);
    }

    @Override
    public void deleteStock(int id) throws ApiRequestException {
        boolean isStockExists = stockRepo.findById(id).isPresent();
        if(!isStockExists) throw new ApiRequestException("The Stock you are trying to delete does not exist");
        stockRepo.deleteById(id);
    }
}
