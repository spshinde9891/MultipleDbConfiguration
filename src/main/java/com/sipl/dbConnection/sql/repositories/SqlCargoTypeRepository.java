package com.sipl.dbConnection.sql.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sipl.dbConnection.sql.entities.SqlCargoType;



@Repository
public interface SqlCargoTypeRepository extends CrudRepository<SqlCargoType, Integer> {

}