package com.technest.cashreceiver.servicesimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.technest.cashreceiver.domain.CashDetails;
import com.technest.cashreceiver.services.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class CashServiceImpl implements CashService {

    private KafkaTemplate<Integer, String> kafkaTemplate;
    private ObjectMapper objectMapper;

    public CashServiceImpl(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Value("${spring.kafka.producer.topic}")
    private String topic;

    @Override
    public Integer produceCash(CashDetails cashDetails) throws JsonProcessingException {
        Integer key = cashDetails.getCashId();
        String value = objectMapper.writeValueAsString(cashDetails);

        ListenableFuture<SendResult<Integer, String>> sendResultListenableFuture = kafkaTemplate.send(topic, key, value);
        sendResultListenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("FAILED:" + ex);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                System.out.println("SUCCESS");
            }
        });
        return key;
    }
}
