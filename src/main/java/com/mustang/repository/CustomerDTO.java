package com.mustang.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mustang.models.Customers;

@Repository
public interface CustomerDTO extends CrudRepository<Customers, Integer> {

}
