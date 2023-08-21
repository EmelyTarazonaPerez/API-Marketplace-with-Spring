package com.proyectospring.proyectomarket.persistencia;

import com.proyectospring.proyectomarket.persistencia.crud.ProductCrudRepository;
import com.proyectospring.proyectomarket.persistencia.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Producto> getAll (){
       return  (List<Producto>) productCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productCrudRepository.findByidCategoriaOderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getById(int idProducto){
        return  productCrudRepository.findById(idProducto);
    }

    public void deleteProduct(int idProducto){
        productCrudRepository.deleteById(idProducto);
    }

    public Producto save(Producto producto){
        return  productCrudRepository.save(producto);
    }
    public Producto updateProduct(int idProducto, Producto producto){
        Producto productoExistente = productCrudRepository.findById(idProducto)
                .orElseThrow(()-> new IllegalArgumentException("Producto no encontrado"));

        //actualizar los campos
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setCantidadSto(producto.getCantidadSto());
        productoExistente.setCodigoBarra(producto.getCodigoBarra());
        productoExistente.setPrecioVenta(producto.getPrecioVenta());
        productoExistente.setEstado(producto.getEstado());

        return productCrudRepository.save(productoExistente);
    }

}
