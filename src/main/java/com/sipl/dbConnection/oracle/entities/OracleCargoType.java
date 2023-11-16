package com.sipl.dbConnection.oracle.entities;



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
@Table(name = "IPT_CARGOTYPE", schema = "IPORTMAN")
public class OracleCargoType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "CARGO_TYPE_CODE")
	private String cargoTypeCode;

	@Column(name = "CARGO_TYPE_NAME")
	private String cargoTypeName;
}