package com.sipl.dbConnection.sql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipl.dbConnection.sql.repositories.SqlCargoTypeRepository;



@Service
public class SqlCargoTypeService {

	private final SqlCargoTypeRepository sqlCargoTypeRepository;

	@Autowired
	public SqlCargoTypeService(SqlCargoTypeRepository sqlCargoTypeRepository) {
		this.sqlCargoTypeRepository = sqlCargoTypeRepository;
	}

	public long getRecordCount() {
		return sqlCargoTypeRepository.count();
	}

}