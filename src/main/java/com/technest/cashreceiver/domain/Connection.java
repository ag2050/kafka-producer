package com.technest.cashreceiver.domain;


import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "datasource")
public class Connection {

    private  String driverClassName;
    private  String url;
    private  String username;
    private  String password;

}
