package com.sipl.dbConnection.sql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.dbConnection.sql.response.ApiResponse;
import com.sipl.dbConnection.sql.service.SqlCargoTypeService;


@RestController
@RequestMapping("/sql")
public class SqlCargoTypeController {

	private final SqlCargoTypeService sqlCargoTypeService;

	@Autowired
	public SqlCargoTypeController(SqlCargoTypeService sqlCargoTypeService) {
		this.sqlCargoTypeService = sqlCargoTypeService;
	}

	@GetMapping("/recordCount")
	public ApiResponse getRecordCount() {
		long count = sqlCargoTypeService.getRecordCount();
		return new ApiResponse("Success", "Total count retrieved successfully", count);
	}

}
