package es.jmruirod.firstspring6productcrudjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jmruirod.firstspring6productcrudjpa.dao.ProductDao;
import es.jmruirod.firstspring6productcrudjpa.model.Product;

@Service
public class ProductServiceInterfaceImplemented implements ProductServiceInterface
{
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAll() 
    {
        return this.productDao.findAll();        
    }

    @Override
    public void updateStock(int id, int stock) 
    {
        Product product = this.productDao.findById(id).orElse(null);
        product.setStock(stock);
        this.productDao.save(product);        
    }

    @Override
    public double getPrice(int id) 
    {
        Product product = this.productDao.findById(id).orElse(null);
        double price = -1;

        if (product != null) 
        {
            price = product.getUnitPrice();
        }

        return price;
    }
}
