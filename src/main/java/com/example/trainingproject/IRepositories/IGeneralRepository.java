package com.example.trainingproject.IRepositories;

import java.util.List;
import java.util.Optional;

public interface IGeneralRepository<T> {
     List<T> findAll();

     Optional<T> findById(int id);

     T insert(T t);

     T update(T t);

     void delete(int id);

}
