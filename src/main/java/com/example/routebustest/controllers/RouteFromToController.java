package com.example.routebustest.controllers;

import com.example.routebustest.domain.RouteFromTo;
import org.springframework.web.bind.annotation.*;
import com.example.routebustest.service.RouteFromToService;

@RestController
@RequestMapping("/api")
public class RouteFromToController {

    private final RouteFromToService routeFromToService;

    public RouteFromToController(RouteFromToService routeFromToService) {
        this.routeFromToService = routeFromToService;
    }

    @GetMapping({"/direct"})
    public RouteFromTo routeFromTo (@RequestParam Integer from, @RequestParam Integer to){
        return new RouteFromTo(from, to, routeFromToService.availableRoute(from, to));
    }
}
