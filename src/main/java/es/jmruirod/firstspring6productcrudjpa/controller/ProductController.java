package es.jmruirod.firstspring6productcrudjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.jmruirod.firstspring6productcrudjpa.model.Product;
import es.jmruirod.firstspring6productcrudjpa.service.ProductServiceInterface;

/**
 * Controlador que gestiona las solicitudes relacionadas con los productos.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@RestController
public class ProductController 
{
    @Autowired
    private ProductServiceInterface service;

    /**
     * Obtiene un producto identificado por su ID.
     * 
     * @param id El ID del producto a buscar.
     * @return Producto buscado en formato JSON.
     * @apiNote GET: localhost:PUERTO/product/1
     */
    @GetMapping(value = "product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product findById(@PathVariable int id)
    {
        return this.service.findById(id);    
    }

    /**
     * Obtiene una lista de todos los productos disponibles.
     * 
     * @return Lista de productos en formato JSON.
     * @apiNote GET: localhost:PUERTO/products
     */
    @GetMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll() 
    {
        return this.service.getAll();    
    }

    /**
     * Actualiza el stock de un producto identificado por su ID.
     * 
     * @param id    El ID del producto a actualizar.
     * @param stock La cantidad de stock a establecer.
     * @apiNote PUT: localhost:PUERTO/product/1?stock=5
     */
    @PutMapping(value = "product/{id}")
    public ResponseEntity<?> updateStock(@PathVariable int id, @RequestParam int stock) 
    {
        Product product = this.service.findById(id);

        if (product == null) 
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto no se encuentra.");
        }

        this.service.updateStock(id, stock);

        return ResponseEntity.ok("Stock actualizado con exito.");
    }

    /**
     * Obtiene el precio de un producto identificado por su ID.
     * 
     * @param id El ID del producto del que se desea obtener el precio.
     * @return El precio del producto.
     * @apiNote GET: localhost:PUERTO/product/price/1
     */
    @GetMapping(value = "product/price/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getPrice(@PathVariable int id) 
    {
        return this.service.getPrice(id);
    }
}
