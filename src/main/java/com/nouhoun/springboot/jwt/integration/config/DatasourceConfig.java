package com.nouhoun.springboot.jwt.integration.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.PropertyVetoException;

/**
 * Created by nydiarra on 06/05/17.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nouhoun.springboot.jwt.integration.repository")
@EntityScan("com.nouhoun.springboot.jwt.integration.domain")
public class DatasourceConfig {

    @Bean
    public DataSource datasource() throws PropertyVetoException {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase dataSource = builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("sql-scripts/schema.sql")
                .addScript("sql-scripts/data.sql")
                .build();

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("datasource") DataSource ds) throws PropertyVetoException{
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(ds);
        entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManagerFactory.setPackagesToScan(new String[]{"com.nouhoun.springboot.jwt.integration.domain"});
        entityManagerFactory.setPackagesToScan(new String[] { "com.nouhoun.springboot.jwt.integration.domain", "com.nouhoun.springboot.jwt.integration.service.impl" }); // add service.impl package for spring boot auto configuration to pick up the application details service
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        return entityManagerFactory;
    }
    }\n\n    @Bean\n    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){\n         JpaTransactionManager transactionManager = new JpaTransactionManager();\n-        transactionManager.setEntityManagerFactory(entityManagerFactory); // set the factory
        transactionManager.setEntityManagerFactory(entityManagerFactory);
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}