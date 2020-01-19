//package com.digiprisma.infra.config.actuator;
//
//import java.util.Map;
//
//import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
//import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
//import org.springframework.stereotype.Component;
//
//import com.google.common.collect.ImmutableMap;
//
//@Component
//@Endpoint(id = "alivecheck")
//public class AliveHealthCheckEndpoint {
//
//    @ReadOperation
//    public Map<?,?> invoke() {
//        return ImmutableMap.of("status", "UP");
//    }
//}
