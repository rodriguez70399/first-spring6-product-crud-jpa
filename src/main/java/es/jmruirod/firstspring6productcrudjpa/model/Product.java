package es.jmruirod.firstspring6productcrudjpa.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double unitPrice;
    private int stock;
    
    public Product() 
    {

    }

    public Product(String name, double unitPrice, int stock) 
    {
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public double getUnitPrice() 
    {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public int getStock() 
    {
        return stock;
    }

    public void setStock(int stock) 
    {
        this.stock = stock;
    }

    @Override
    public String toString() 
    {
        return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", stock=" + stock + "]";
    }

    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }

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
