package com.platzi.market.persistencia;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistencia.entity.Producto;
import com.platzi.market.persistencia.mapper.ProductMapper;
import com.platzi.market.persistencia.crud.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;
    public List<Product> getAll (){
       List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return  mapper.toProducts(productos);
    }
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos= productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional <List<Producto>> producto = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return producto.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return  productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }
    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

    public Producto updateProduct(int idProducto, Producto producto){
        Producto productoExistente = productoCrudRepository.findById(idProducto)
                .orElseThrow(()-> new IllegalArgumentException("Producto no encontrado"));

        //actualizar los campos
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setCantidadStock(producto.getCantidadStock());
        productoExistente.setCodigoBarra(producto.getCodigoBarra());
        productoExistente.setPrecioVenta(producto.getPrecioVenta());
        productoExistente.setEstado(producto.getEstado());

        return productoCrudRepository.save(productoExistente);
    }

}
