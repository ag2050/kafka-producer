package com.technest.cashreceiver.configuration;

import com.technest.cashreceiver.domain.Connection;
import com.technest.cashreceiver.util.CashingUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private Connection connection;

    public DataSourceConfig(Connection connection) {
        this.connection = connection;
    }

    @Bean
    public DataSource getDataSource() {

        System.out.println("My UserName:"+CashingUtil.decode(connection.getUsername()));
        return DataSourceBuilder.create()
                .driverClassName(connection.getDriverClassName())
                .url(CashingUtil.decode(connection.getUrl()))
                .username(CashingUtil.decode(connection.getUsername()))
                .password(CashingUtil.decode(connection.getPassword()))
                .build();
    }

}
