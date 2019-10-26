package com.epam.model.configuration;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "com.epam.model")
public class ConnectionConfigurator {

    @Bean
    public DataSource dataSource(){
        EmbeddedPostgres postgres = null;
        try{
            postgres = EmbeddedPostgres.builder().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert postgres != null;
        return postgres.getPostgresDatabase();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public Flyway flyway(DataSource dataSource){
        FluentConfiguration fluentConfiguration = Flyway.configure().dataSource(dataSource);

        return new Flyway(fluentConfiguration);
    }

}
