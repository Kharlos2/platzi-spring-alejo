package com.example.platzispringalejo.persistence;

import com.example.platzispringalejo.domain.Purchase;
import com.example.platzispringalejo.domain.repository.PurchaseRepository;
import com.example.platzispringalejo.persistence.mapper.PurchaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Override
    public List<Purchase> getAll() {
        return null;
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return Optional.empty();
    }

    @Override
    public Purchase save(Purchase purchase) {
        return null;
    }
}
