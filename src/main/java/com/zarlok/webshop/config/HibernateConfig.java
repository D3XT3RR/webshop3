package com.zarlok.webshop.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.zarlok.webshop")
@PropertySource("/resources/mysql.properties")
public class HibernateConfig {

    @Autowired
    Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.zarlok.webshop.entity");

        return sessionFactoryBean;
    }

    @Bean
    public ComboPooledDataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setUser(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));


        dataSource.setInitialPoolSize(
                getIntProperty("connection.pool.initialPoolSize"));
        dataSource.setMaxPoolSize(
                getIntProperty("connection.pool.maxPoolSize"));
        dataSource.setMinPoolSize(
                getIntProperty("connection.pool.minPoolSize"));
        dataSource.setMaxIdleTime(
                getIntProperty("connection.pool.maxIdleTime"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return transactionManager;
    }

    private final Properties hibernateProperties(){
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
        hibernateProperties.setProperty(
                "hibernate.dialect", environment.getProperty("hibernate.dialect")
        );
        return hibernateProperties;
    }



    private int getIntProperty(String propertyName){
        String propertyValue = environment.getProperty(propertyName);
        return Integer.parseInt(propertyValue);
    }

}
