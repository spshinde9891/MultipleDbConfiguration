package com.sipl.dbConnection.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.dbConnection.oracle.response.ApiResponse;
import com.sipl.dbConnection.oracle.service.OracleCargoTypeService;




@RestController
@RequestMapping("/api")
public class OracleCargoTypeController {

	private final OracleCargoTypeService oracleCargoTypeService;

	@Autowired
	public OracleCargoTypeController(OracleCargoTypeService oracleCargoTypeService) {
		this.oracleCargoTypeService = oracleCargoTypeService;
	}

	@GetMapping("/recordCount")
	public ApiResponse getRecordCount() {
		long count = oracleCargoTypeService.getRecordCount();
		return new ApiResponse("Success", "Total count retrieved successfully", count);
	}

}
