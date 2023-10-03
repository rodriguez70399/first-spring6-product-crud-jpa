package es.jmruirod.firstspring6productcrudjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.jmruirod.firstspring6productcrudjpa.model.Product;
import es.jmruirod.firstspring6productcrudjpa.service.ProductServiceInterface;

@RestController
public class ProductController 
{
    @Autowired
    private ProductServiceInterface service;

    @GetMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll() 
    {
        return this.service.getAll();    
    }

    @PutMapping(value = "product/{id}")
    public void updateStock(@PathVariable int id, @RequestParam int stock) 
    {
        this.service.updateStock(id, stock);            
    }

    @GetMapping(value = "product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getPrice(@PathVariable int id) 
    {
        return this.service.getPrice(id);
    }
}