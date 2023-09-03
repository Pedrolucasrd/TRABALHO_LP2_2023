package com.lp2.leilao.controller;

import com.lp2.leilao.model.Lance;
import com.lp2.leilao.service.LanceService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "lance")
public class LanceController {

    @Autowired
    private LanceService lanceService;

    @PostMapping
    public void gerarLance (@RequestBody Lance lance){
        lanceService.gerarlance(lance);
    }
}
