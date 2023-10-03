package es.jmruirod.firstspring6productcrudjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jmruirod.firstspring6productcrudjpa.dao.ProductDao;
import es.jmruirod.firstspring6productcrudjpa.model.Product;

/**
 * Implementación de la interfaz {@link ProductServiceInterface} que proporciona servicios para la gestión de productos.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@Service
public class ProductServiceInterfaceImplemented implements ProductServiceInterface
{
    @Autowired
    private ProductDao productDao;

    /**
     * Obtiene una lista de todos los productos disponibles.
     * 
     * @return Lista de productos.
     */
    @Override
    public List<Product> getAll() 
    {
        return this.productDao.findAll();        
    }

    /**
     * Actualiza el stock de un producto identificado por su ID.
     * 
     * @param id    El ID del producto a actualizar.
     * @param stock La cantidad de stock a establecer.
     */
    @Override
    public void updateStock(int id, int stock) 
    {
        Product product = this.productDao.findById(id).orElse(null);
        product.setStock(stock);
        this.productDao.save(product);        
    }

    /**
     * Obtiene el precio de un producto identificado por su ID.
     * 
     * @param id El ID del producto del que se desea obtener el precio.
     * @return El precio del producto. Si no se encuentra el producto, se devuelve -1.
     */
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
