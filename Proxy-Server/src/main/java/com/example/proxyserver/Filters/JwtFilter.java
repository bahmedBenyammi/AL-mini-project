package com.example.proxyserver.Filters;


import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class JwtFilter extends AbstractGatewayFilterFactory<JwtFilter.Config> {

    public JwtFilter() {
        super(Config.class);
    }

    private Mono<Void> onError(ServerWebExchange exchange, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);

        return response.setComplete();
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (!exchange.getRequest().getHeaders().containsKey("Authorization"))
                return onError(exchange, HttpStatus.FORBIDDEN);
            else {
                String authorizationHeader = exchange.getRequest().getHeaders().get("Authorization").get(0);
                if (!authorizationHeader.startsWith("Bearer "))
                    return onError(exchange, HttpStatus.BAD_GATEWAY);
                String token = authorizationHeader.substring(7);
                JwtUtil jwtUtil = new JwtUtil();
                List<String> strings = jwtUtil.extractRole(token);
                if (strings == null)
                    return onError(exchange, HttpStatus.FORBIDDEN);
                if (!checkRole(config, jwtUtil.extractRole(token)))
                    return onError(exchange, HttpStatus.UNAUTHORIZED);
                else {

                    String userName = jwtUtil.extractUsername(token);
                    ServerHttpRequest request = exchange.getRequest().mutate()
                            .header("userName", userName)
                            .build();

                    return chain.filter(exchange.mutate().request(request).build());

                }
            }
        };
    }

    private boolean checkRole(Config config, List<String> roles) {
        for (String s : roles)
            if (config.Role.equals(s)) {

                return true;
            }
        return false;
    }

    public static class Config {
        public Config(String role) {
            this.Role = "ROLE_"+role;
        }

        String Role;
    }
}
