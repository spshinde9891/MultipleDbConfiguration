package com.sipl.dbConnection.sql.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cargo_types_tmp")
public class SqlCargoType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cargo_type_id")
	private Integer id;

	@Column(name = "e_cargo_type_id")
	private String cargoTypeCode;

	@Column(name = "cargo_type_name")
	private String cargoTypeName;
}
