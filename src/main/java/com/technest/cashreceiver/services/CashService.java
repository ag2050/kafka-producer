package com.technest.cashreceiver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.technest.cashreceiver.domain.CashDetails;

public interface CashService {

    public Integer produceCash(CashDetails cashDetails) throws JsonProcessingException;
}
