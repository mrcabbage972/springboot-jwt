package com.nouhoun.springboot.jwt.integration.config;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by nydiarra on 06/05/17.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nouhoun.springboot.jwt.integration.repository")
public class DatasourceConfig {

    @Bean
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase dataSource = builder
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase dataSource = builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("sql-scripts/schema.sql")
                .addScript("sql-scripts/data.sql")
                .build();
    }

    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("datasource") DataSource ds) throws PropertyVetoException{
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("datasource") DataSource ds) throws PropertyVetoException{
        entityManagerFactory.setDataSource(ds);
        entityManagerFactory.setPackagesToScan(new String[]{"com.nouhoun.springboot.jwt.integration.domain"});
        entityManagerFactory.setPackagesToScan(new String[]{"com.nouhoun.springboot.jwt.integration.domain"});
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        return entityManagerFactory;
    }

    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}