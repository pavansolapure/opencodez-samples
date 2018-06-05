package com.opencodez.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "mysqlEntityManager", 
		transactionManagerRef = "mysqlTransactionManager", 
		basePackages = "com.opencodez.dao.mysql.repo"
)
public class SecondaryDbConfig {

	public static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
	public static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	public static final String PROPERTY_NAME_HIBERNATE_FMT_SQL = "hibernate.format_sql";
	public static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = { "com.opencodez.dao.mysql.domain" };

	public static final String DB_URL = "mysql.db.url";
	public static final String DB_USER = "mysql.db.user";
	public static final String DB_PASSWORD = "mysql.db.password";
	public static final String DB_DRIVER = "mysql.db.driver";
	public static final String DB_DIALECT = "mysql.db.dialect";

	@Autowired
	private Environment env;

	@Bean
	public AnnotationMBeanExporter annotationMBeanExporter() {
		AnnotationMBeanExporter annotationMBeanExporter = new AnnotationMBeanExporter();
		annotationMBeanExporter.addExcludedBean("dataSource");
		annotationMBeanExporter.setRegistrationPolicy(RegistrationPolicy.IGNORE_EXISTING);
		return annotationMBeanExporter;
	}

	@Bean(name = "mysqlDataSource", destroyMethod = "close")
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty(DB_DRIVER));

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		dataSource.setJdbcUrl(env.getProperty(DB_URL));
		dataSource.setUser(env.getProperty(DB_USER));
		dataSource.setPassword(env.getProperty(DB_PASSWORD));
		dataSource.setAcquireIncrement(5);
		dataSource.setMaxStatementsPerConnection(20);
		dataSource.setMaxStatements(100);
		dataSource.setMaxPoolSize(500);
		dataSource.setMinPoolSize(5);
		return dataSource;
	}

	@Bean(name = "mysqlTransactionManager")
	public JpaTransactionManager jpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}

	@Bean(name = "mysqlEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPersistenceUnitManager(persistenceUnitManager());
		entityManagerFactoryBean.setPersistenceUnitName("mysql");
		entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
		
		entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());

		return entityManagerFactoryBean;
	}

	@Bean(name = "mysqlpersistenceUnitManager")
	public DefaultPersistenceUnitManager persistenceUnitManager() {
		DefaultPersistenceUnitManager persistenceUnitManager = new DefaultPersistenceUnitManager();
		persistenceUnitManager.setDefaultDataSource(dataSource());
		return persistenceUnitManager;
	}

	private HibernateJpaVendorAdapter vendorAdaptor() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabasePlatform(env.getProperty(DB_DIALECT));
		vendorAdapter.setShowSql(false);
		return vendorAdapter;
	}

	private Properties jpaHibernateProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_FMT_SQL, env.getProperty(PROPERTY_NAME_HIBERNATE_FMT_SQL));
		properties.put(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE,
				env.getProperty(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		return properties;
	}
}
