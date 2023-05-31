package com.example.platzispringalejo.persistence;

import com.example.platzispringalejo.domain.Product;
import com.example.platzispringalejo.domain.repository.ProductRepository;
import com.example.platzispringalejo.persistence.crud.ProductoCrudRepositoy;
import com.example.platzispringalejo.persistence.entity.Producto;
import com.example.platzispringalejo.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository{
    @Autowired
    private ProductoCrudRepositoy productoCrudRepositoy;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepositoy.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos= productoCrudRepositoy.findByIdCategoriaOrderbyNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepositoy.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepositoy.findById(productId).map(producto -> mapper.toProduct(producto));

    }

    @Override
    public Product save(Product product) {
        Producto producto= mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepositoy.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepositoy.deleteById(productId);
    }





}
