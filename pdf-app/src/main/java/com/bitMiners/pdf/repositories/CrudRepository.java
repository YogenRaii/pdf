package com.bitMiners.pdf.repositories;

import java.util.List;

public interface CrudRepository<T, ID> {
    ID add(T t);

    void delete(ID id);

    boolean update(T t);

    T findOne(ID id);

    List<T> findAll();
}
