package cl.tbd.trabajo2grupo2.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {
    @Bean
    public static Sql2o sql2o()
    {
        /*
         * url: jdbc:postgresql://localhost:5432/lab1
         * user: postgres
         * pass: postgres
        */
        return new Sql2o("jdbc:postgresql://localhost:5432/lab1", "postgres", "postgres");
    }
}
