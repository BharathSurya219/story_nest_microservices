package com.storynest.sn_gateway.filter;

import com.storynest.sn_gateway.util.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AbstractGatewayFilterFactory.NameConfig> {

    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private JwtUtility jwtUtility;

    public AuthenticationFilter(){
        super(NameConfig.class);
    }

    @Override
    public GatewayFilter apply(NameConfig config) {
        return ((exchange, chain) -> {
            if (routeValidator.isSecured.test(exchange.getRequest())){
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Missing authe header");
                }
                String header = String.valueOf(exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION));
                if (null != header && header.contains("Bearer")){
                    header = header.replaceAll(".*Bearer\\s*", "").trim();
                }
                jwtUtility.ValidateToken(header);
            }
            return chain.filter(exchange);
        });
    }


}
