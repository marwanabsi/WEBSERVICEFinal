package BZU.WebServices.service.impl;

import BZU.WebServices.ApiRequestException;
import BZU.WebServices.models.ProductOrder;
import BZU.WebServices.repositories.ProductOrderRepo;
import BZU.WebServices.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    ProductOrderRepo productOrderRepo;


    @Override
    public List<ProductOrder> getAllProductOrder(){
        List <ProductOrder> productOrder = productOrderRepo.findAll();
        if(productOrder.size() == 0) throw new ApiRequestException("No Product Order in the system");
        return productOrder;
    }

    @Override
    public ProductOrder getProductOrder(int id){
        ProductOrder productOrder = productOrderRepo.findById(id).orElseThrow(() ->
                new ApiRequestException(String.format("The Product Order that has id %s not found",id)));
        return productOrder;
    }

    @Override
    public void addProductOrder(ProductOrder productOrder) throws ApiRequestException {
        boolean isProductOrderAlreadyExists = productOrderRepo.findById(productOrder.getId()).isPresent();
        if(isProductOrderAlreadyExists) throw new ApiRequestException("There is no two Product Order should have the same id");
        productOrderRepo.save(productOrder);
    }

    @Override
    public void updateProductOrder(int id, ProductOrder productOrder) throws ApiRequestException {
        boolean isProductOrderExists = productOrderRepo.findById(id).isPresent();
        if(!isProductOrderExists) throw new ApiRequestException("The Product Order you are trying to update does not exist");
        productOrderRepo.save(productOrder);
    }

    @Override
    public void deleteProductOrder(int id) throws ApiRequestException {
        boolean isProductOrderExists = productOrderRepo.findById(id).isPresent();
        if(!isProductOrderExists) throw new ApiRequestException("The Product Order you are trying to delete does not exist");
        productOrderRepo.deleteById(id);
    }
}
