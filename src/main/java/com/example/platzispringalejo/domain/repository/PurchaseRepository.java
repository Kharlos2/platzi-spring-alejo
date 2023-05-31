package com.example.platzispringalejo.domain.repository;

import com.example.platzispringalejo.domain.Purchase;

import java.io.PushbackInputStream;
import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);

}
