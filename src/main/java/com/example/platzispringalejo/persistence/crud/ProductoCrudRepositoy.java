package com.example.platzispringalejo.persistence.crud;

import com.example.platzispringalejo.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepositoy extends CrudRepository<Producto,Integer> {

    @Query("SELECT p FROM Producto p WHERE p.idCategoria = ?1 ORDER BY p.nombre ASC")
    List<Producto> findByIdCategoriaOrderbyNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock,boolean estado);

}
