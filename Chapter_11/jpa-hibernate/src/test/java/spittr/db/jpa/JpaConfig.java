package spittr.db.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan
public class JpaConfig {

    @Bean // datasource injection
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
        edb.setType(EmbeddedDatabaseType.H2);
        edb.addScript("spittr/db/jpa/schema.sql");
        edb.addScript("spittr/db/jpa/test-data.sql");
        EmbeddedDatabase embeddedDatabase = edb.build();
        return embeddedDatabase;
    }

    /* Configuration in xml. JpaVendorAdapter options are EclipseLinkJpaVendorAdapter, HibernateJpaVendorAdapter,
     * OpenJpaVendorAdapter, TopLinkJpaVendorAdapter(deprecated in Spring 3.1).
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean emf(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPersistenceUnitName("spittr");
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        //no need xml, scan package for @Entity classes
        emf.setPackagesToScan("spittr.domain");
        return emf;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.H2);
        // adapter.setDatabase("HSQL"); // no longer accepting string argument
        // adapter.setDatabase(Database.HSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        return adapter;
    }


    @Configuration
    @EnableTransactionManagement
    public static class TransactionConfig implements TransactionManagementConfigurer {
        @Inject
        private EntityManagerFactory emf;

        public PlatformTransactionManager annotationDrivenTransactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(emf);
            return transactionManager;
        }
    }

    @Bean // retrieve EntityManagerFactory from app server through JNDI
    public JndiObjectFactoryBean entityManagerFactory() {
        JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
        jndiObjectFB.setJndiName("jdbc/SpittrDS");
        return jndiObjectFB;
    }
}
