package es.jmruirod.firstspring6productcrudjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jmruirod.firstspring6productcrudjpa.model.Product;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Product.
 * Utiliza Spring Data JPA para proporcionar implementaciones automáticas de estas operaciones.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
public interface ProductDao extends JpaRepository<Product, Integer>
{
    
}
