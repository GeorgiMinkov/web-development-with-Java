package com.fmi.web.theaterticketsystem.controller;

import com.fmi.web.theaterticketsystem.model.Performer;
import com.fmi.web.theaterticketsystem.service.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/performer")
public class PerformerController {

    private PerformerService performerService;

    @Autowired
    public PerformerController(PerformerService performerService) {
        this.performerService = performerService;
    }


    @GetMapping
    public List<Performer> findAllPerformers(){
        return performerService.findAll();
    }
}
