package com.example.tbd.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {

    public static int cantDatabases = 3;

    //Definir url de la BD, usuario y password
    //Ejemplo: jdbc:postgresql://127.0.0.1:5432/postgres, usuario, password
    @Bean
    public Sql2o[] sql2o(){
        return new Sql2o[]{
                new Sql2o(
                    "jdbc:postgresql://127.0.0.1:5432/voluntariado-sql2o",
                    "postgres",
                    "passgreSQL13"),
                new Sql2o(
                    "jdbc:postgresql://127.0.0.1:5432/voluntariado-db",
                    "postgres",
                    "passgreSQL13"),
                new Sql2o(
                    "jdbc:postgresql://127.0.0.1:5432/voluntariado-poi",
                    "postgres",
                    "passgreSQL13")
        };
    }

}
