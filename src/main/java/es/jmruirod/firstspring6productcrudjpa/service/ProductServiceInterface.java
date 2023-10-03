package es.jmruirod.firstspring6productcrudjpa.service;

import java.util.List;

import es.jmruirod.firstspring6productcrudjpa.model.Product;

public interface ProductServiceInterface 
{
    public List<Product> getAll();
    public void updateStock(int id, int stock);
    public double getPrice(int id);
}
