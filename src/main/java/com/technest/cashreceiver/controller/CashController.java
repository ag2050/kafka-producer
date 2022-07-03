package com.technest.cashreceiver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.technest.cashreceiver.domain.CashDetails;
import com.technest.cashreceiver.services.CashService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class CashController {
    private CashService cashService;

    public CashController(CashService cashService) {
        this.cashService = cashService;
    }

    @PostMapping("cashreceiver")
    public ResponseEntity<Integer> receiveCash(@RequestBody CashDetails cashDetails) {
        Integer result = null;
        try {
            result = cashService.produceCash(cashDetails);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
