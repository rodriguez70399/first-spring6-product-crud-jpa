package es.jmruirod.firstspring6productcrudjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jmruirod.firstspring6productcrudjpa.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>
{
    
}
