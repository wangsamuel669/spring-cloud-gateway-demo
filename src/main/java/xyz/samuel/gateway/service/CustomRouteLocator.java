package xyz.samuel.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.ConfigurableApplicationContext;
import reactor.core.publisher.Flux;

public class CustomRouteLocator implements RouteLocator {

    @Autowired
    private ConfigurableApplicationContext context;

    @Override
    public Flux<Route> getRoutes() {
        return null;
    }
}
