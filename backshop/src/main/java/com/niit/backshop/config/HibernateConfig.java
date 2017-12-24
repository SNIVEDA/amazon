package com.niit.backshop.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.niit.backshop.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	private final static String Database_Url = "jdbc:h2:tcp://localhost/~/frontshop";
	private final static String Database_Driver = "org.h2.Driver";
	private final static String Database_Dialect = "org.hibernate.dialect.H2Dialect";
	private final static String Database_Username = "sa";
	private final static String Database_Password = "";

	// Database Connection- Datasource bean

	@Bean("dataSource")
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(Database_Driver);
		datasource.setUrl(Database_Url);
		datasource.setUsername(Database_Username);
		datasource.setPassword(Database_Password);
		return datasource;
	}

	// sessionFactory bean

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.niit.backshop.dto");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", Database_Dialect);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

		return properties;
	}

	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
