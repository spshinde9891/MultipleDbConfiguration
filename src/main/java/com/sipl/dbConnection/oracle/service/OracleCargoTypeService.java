package com.sipl.dbConnection.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipl.dbConnection.oracle.repositories.OracleCargoTypeRepository;


@Service
public class OracleCargoTypeService {

	private final OracleCargoTypeRepository oracleCargoTypeRepository;

	@Autowired
	public OracleCargoTypeService(OracleCargoTypeRepository oracleCargoTypeRepository) {
		this.oracleCargoTypeRepository = oracleCargoTypeRepository;
	}

	public long getRecordCount() {
		return oracleCargoTypeRepository.count();
	}

}