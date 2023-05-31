package com.example.platzispringalejo.persistence.crud;

import com.example.platzispringalejo.persistence.entity.Compra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra,Integer> {
    @Query("SELECT c FROM Compra c WHERE c.idCliente = :idCliente")
    Optional<List<Compra>> findIdCliente(@Param("idCliente") String idCliente);

}
