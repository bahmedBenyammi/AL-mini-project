package com.example.proxyserver.Config;

import com.example.proxyserver.Filters.JwtFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routes {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/passenger/user/**").filters(f->
                        f.filter(new JwtFilter().apply(new JwtFilter.Config("USER"))).stripPrefix(1)).
                        uri("lb://PASSENGER")).build();


    }
}
