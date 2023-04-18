package org.andromeda.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.andromeda.repository",
        entityManagerFactoryRef = "postgresqlEntityManagerFactory",
        transactionManagerRef = "postgresqlTransactionManager"
)
public class DataSourcesConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.mariadb")
    public DataSourceProperties mariaDbProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.postgresql")
    public DataSourceProperties postgresqlProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name  = "postgresqlDataSource")
    public DataSource postgresqlDataSource() {
        return postgresqlProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean(name = "mariaDbDataSource")
    public DataSource mariaDbDataSource() {
        return mariaDbProperties()
                .initializeDataSourceBuilder()
                .build();
    }


}
