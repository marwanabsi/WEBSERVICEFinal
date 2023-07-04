package BZU.WebServices.controller;

import BZU.WebServices.models.Stock;
import BZU.WebServices.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStock()  {
        return stockService.getAllStock();
    }


    @GetMapping(value = "ids")
    public Stock getStockById(@PathVariable int id){
        return stockService.getStock(id);
    }

    @PostMapping
    public void addStock(@RequestBody Stock stock){
        stockService.addStock(stock);
    }



    @PatchMapping
    public void updateStock(@PathVariable int id,@RequestBody Stock stock){
        stockService.updateStock(id, stock);
    }

    @DeleteMapping
    public void deleteStock(@PathVariable int id){
        stockService.deleteStock(id);
    }
}
