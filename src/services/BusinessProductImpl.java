package services;

import Interface.IBusiness;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class BusinessProductImpl<T> implements IBusiness<Product<T>>  {

    private List<Product<T>> products;

    public BusinessProductImpl() {
        this.products = new ArrayList<>();
    }

    @Override
    public void add(Product<T> o) {
        products.add(o);
    }

    @Override
    public List<Product<T>> getAll() {
        return products;
    }

    @Override
    public Product<T> findById(long id) {
        return products.stream()
                .filter(p -> String.valueOf(id).equals(String.valueOf(p.getId())))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(long id) {
        products.removeIf(p -> String.valueOf(id).equals(String.valueOf(p.getId())));
    }
}
