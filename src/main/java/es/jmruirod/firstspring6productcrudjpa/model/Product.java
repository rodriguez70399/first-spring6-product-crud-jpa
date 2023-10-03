package es.jmruirod.firstspring6productcrudjpa.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase que representa un producto.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double unitPrice;
    private int stock;
    
    /**
     * Constructor por defecto de la clase Product.
     */
    public Product() 
    {

    }

    /**
     * Constructor de la clase Product.
     * 
     * @param name      El nombre del producto.
     * @param unitPrice El precio unitario del producto.
     * @param stock     El stock disponible del producto.
     */
    public Product(String name, double unitPrice, int stock) 
    {
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    /**
     * Obtiene el ID del producto.
     * 
     * @return El ID del producto.
     */
    public int getId() 
    {
        return id;
    }

    /**
     * Establece el ID del producto.
     * 
     * @param id El ID del producto.
     */
    public void setId(int id) 
    {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto.
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param name El nombre del producto.
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Obtiene el precio unitario del producto.
     * 
     * @return El precio unitario del producto.
     */
    public double getUnitPrice() 
    {
        return unitPrice;
    }

    /**
     * Establece el precio unitario del producto.
     * 
     * @param unitPrice El precio unitario del producto.
     */
    public void setUnitPrice(double unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    /**
     * Obtiene el stock disponible del producto.
     * 
     * @return El stock disponible del producto.
     */
    public int getStock() 
    {
        return stock;
    }

    /**
     * Establece el stock disponible del producto.
     * 
     * @param stock El stock disponible del producto.
     */
    public void setStock(int stock) 
    {
        this.stock = stock;
    }

    /**
     * Sobrescribe el método toString para representar el objeto Product como una cadena.
     */
    @Override
    public String toString() 
    {
        return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", stock=" + stock + "]";
    }

    /**
     * Calcula el hash code del objeto Product basado en su ID.
     */
    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }

    /**
     * Compara dos objetos Product para determinar si son iguales.
     * Dos productos son iguales si tienen el mismo ID, nombre, precio unitario y stock.
     */
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Product other = (Product) obj;

        if (id != other.id)
            return false;

        if (name == null) 
        {
            if (other.name != null)
                return false;
        } 
        else if (!name.equals(other.name))
            return false;

        if (Double.doubleToLongBits(unitPrice) != Double.doubleToLongBits(other.unitPrice))
            return false;

        if (stock != other.stock)
            return false;

        return true;
    }    
}
