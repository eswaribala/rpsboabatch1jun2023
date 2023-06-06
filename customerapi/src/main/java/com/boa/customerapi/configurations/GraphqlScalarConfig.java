package com.boa.customerapi.configurations;


import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlScalarConfig {

@Bean
public GraphQLScalarType dateType(){
    return ExtendedScalars.Date;
}
    @Bean
    public GraphQLScalarType jsonType(){
        return ExtendedScalars.Json;
    }

}
