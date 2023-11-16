package com.sipl.dbConnection.sql.config;



import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "com.sipl.dbConnection.sql.repositories", entityManagerFactoryRef = "mssqlEntityManagerFactory", transactionManagerRef = "mssqlTransactionManager")
public class SqlDataSourceConfiguration {

	@Bean(name = "mssqlDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.mssql")
	public DataSource mssqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mssqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean mssqlEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("mssqlDataSource") DataSource mssqlDataSource) {
		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
		return builder.dataSource(mssqlDataSource).packages("com.sipl.dbConnection.sql.entities").properties(properties)
				.build();
	}

	@Bean(name = "mssqlTransactionManager")
	public JpaTransactionManager mssqlTransactionManager(
			@Qualifier("mssqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}