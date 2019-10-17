package xyz.samuel.gateway.service;

import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.net.URI;

@Component
public class CustomRouteDefinitionLocator implements RouteDefinitionLocator {
    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId("1");
        routeDefinition.setOrder(-1);
//        routeDefinition.setUri(URI.create("http://192.168.1.2:18080"));
        routeDefinition.setUri(URI.create("http://10.100.1.52:9200"));
        PredicateDefinition predicateDefinition = new PredicateDefinition("Path=/test");
        routeDefinition.getPredicates().add(predicateDefinition);
        /*routeDefinition.getFilters().add(new FilterDefinition("AddRequestParameter=querylist, 13812345678"));
        routeDefinition.getFilters().add(new FilterDefinition("AddRequestHeader=Authorization, Basic bkRiRTNmQmIzSDN1WDh6WjUyREw6c25nNXQ5RExCWndydVZrUGk0VFRkQkU0NjliYlNZS0JYb2N1YTJVcg=="));
        routeDefinition.getFilters().add(new FilterDefinition("SetPath=/mobile/location"));*/
        routeDefinition.getFilters().add(new FilterDefinition("SetPath=/"));
//        routeDefinition.getFilters().add(new FilterDefinition("RedirectTo=302, http://10.100.1.190:9200"));
        return Flux.just(routeDefinition);
    }
}
