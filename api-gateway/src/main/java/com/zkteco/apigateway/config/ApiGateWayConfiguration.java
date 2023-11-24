package com.zkteco.apigateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;
import java.util.function.Predicate;

@Configuration
public class ApiGateWayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return  builder.routes()
                .route(p->p.path("/get")
                        .filters(f->f.addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
                .route(p->p.path("/bus-api/**")
                        .uri("lb://bus-service"))
                .route(p->p.path("/user-api/**")
                        .uri("lb://user-service"))
//                .route(p->p.path("/api/**")
//                        .uri("lb://user-service"))
                .build();
    }
}
