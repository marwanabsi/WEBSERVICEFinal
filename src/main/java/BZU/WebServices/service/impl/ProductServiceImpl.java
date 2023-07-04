package BZU.WebServices.service.impl;

import BZU.WebServices.ApiRequestException;
import BZU.WebServices.models.Product;
import BZU.WebServices.repositories.ProductRepo;
import BZU.WebServices.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;


    @Override
    public List<Product> getAllProduct(){
        List <Product> productList = productRepo.findAll();
        if(productList.size() == 0) throw new ApiRequestException("No Product in the system");
        return productList;
    }

    @Override
    public Product getProduct(int id){
        Product product = productRepo.findById(id).orElseThrow(() -> new ApiRequestException(String.format("The Product that has id %s not found",id)));
        return product;
    }

    @Override
    public void addProduct(Product product) throws ApiRequestException {
        boolean isProductAlreadyExists = productRepo.findById(product.getId()).isPresent();
        if(isProductAlreadyExists) throw new ApiRequestException("There is no two Customer should have the same id");
        productRepo.save(product);
    }

    @Override
    public void updateProduct(int id, Product product) throws ApiRequestException {
        boolean isProductExists = productRepo.findById(id).isPresent();
        if(!isProductExists) throw new ApiRequestException("The Product you are trying to update does not exist");
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(int id) throws ApiRequestException {
        boolean isProductExists = productRepo.findById(id).isPresent();
        if(!isProductExists) throw new ApiRequestException("The Product you are trying to delete does not exist");
        productRepo.deleteById(id);
    }

}
