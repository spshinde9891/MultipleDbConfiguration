package com.sipl.dbConnection.oracle.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sipl.dbConnection.oracle.entities.OracleCargoType;



@Repository
public interface OracleCargoTypeRepository extends CrudRepository<OracleCargoType, Integer> {

}