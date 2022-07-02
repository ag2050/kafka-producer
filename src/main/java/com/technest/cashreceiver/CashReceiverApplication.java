package com.technest.cashreceiver;

import com.technest.cashreceiver.domain.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Connection.class)
public class CashReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashReceiverApplication.class, args);
	}

}
