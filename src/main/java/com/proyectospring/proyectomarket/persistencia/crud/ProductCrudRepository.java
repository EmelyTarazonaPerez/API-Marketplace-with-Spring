package com.proyectospring.proyectomarket.persistencia.crud;

import com.proyectospring.proyectomarket.persistencia.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Producto,Integer> {

    List<Producto> findByidCategoriaOderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


}
