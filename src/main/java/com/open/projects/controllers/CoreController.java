package com.open.projects.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.open.projects.dtos.Resource;
import com.open.projects.services.ResourceServices;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/resources")
public class CoreController {

    private final ResourceServices resourceServices;

    @GetMapping("/list")
    public Flux<Resource> listResources(@RequestParam String dir){
            return resourceServices.listResources(dir);
    } 

}
