package com.sipl.dbConnection.oracle.config;

import java.util.HashMap;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory", transactionManagerRef = "oracleTransactionManager", basePackages = {
		"com.sipl.dbConnection.oracle.repositories" })
public class OracleDataSourceConfiguration {
@Bean
@Primary
@ConfigurationProperties(prefix = "spring.datasource.oracle")
public DataSource oracleDataSource() {
return DataSourceBuilder.create().build();
}

	@Primary
	@Bean(name = "oracleEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("oracleDataSource") DataSource oracleDataSource) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "validate");
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("driver-class-name", "oracle.jdbc.OracleDriver");
		return builder.dataSource(oracleDataSource).packages("com.sipl.dbConnection.oracle.entities")
				.properties(properties).build();
	}

	@Bean(name = "oracleTransactionManager")
	public PlatformTransactionManager oracleTransactionManager(EntityManagerFactory oracleEntityManagerFactory) {
		return new JpaTransactionManager(oracleEntityManagerFactory);
	}
}
