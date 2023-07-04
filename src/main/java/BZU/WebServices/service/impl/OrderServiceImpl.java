package BZU.WebServices.service.impl;


import BZU.WebServices.ApiRequestException;
import BZU.WebServices.models.Ordere;
import BZU.WebServices.repositories.OrderRepo;
import BZU.WebServices.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo orderRepo;


    @Override
    public List<Ordere> getAllOrder(){
        List <Ordere> orderList = orderRepo.findAll();
        if(orderList.size() == 0) throw new ApiRequestException("No Ordere in the system");
        return orderList;
    }

    @Override
    public Ordere getOrder(int id){
        Ordere order = orderRepo.findById(id).orElseThrow(() -> new ApiRequestException(String.format("The Order that has id %s not found",id)));
        return order;
    }

    @Override
    public void addOrder(Ordere order) throws ApiRequestException {
        boolean isOrderAlreadyExists = orderRepo.findById(order.getId()).isPresent();
        if(isOrderAlreadyExists) throw new ApiRequestException("There is no two Ordere should have the same id");
        orderRepo.save(order);
    }

    @Override
    public void updateOrder(int id, Ordere order) throws ApiRequestException {
        boolean isOrderExists = orderRepo.findById(id).isPresent();
        if(!isOrderExists) throw new ApiRequestException("The Order you are trying to update does not exist");
        orderRepo.save(order);
    }

    @Override
    public void deleteOrder(int id) throws ApiRequestException {
        boolean isOrderExists = orderRepo.findById(id).isPresent();
        if(!isOrderExists) throw new ApiRequestException("The Order you are trying to delete does not exist");
        orderRepo.deleteById(id);
    }
    
}
