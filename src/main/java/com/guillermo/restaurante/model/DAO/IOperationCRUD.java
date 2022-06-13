package com.guillermo.restaurante.model.DAO;

import java.util.List;

public interface IOperationCRUD <T>{
    public List<T> getAll();
    public T findById(T object);
    public int add(T object);
    public int update(T object);
    public int delete(T object);
}
