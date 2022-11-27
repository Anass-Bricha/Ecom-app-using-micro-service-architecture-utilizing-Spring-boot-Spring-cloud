package org.sid.billingservice;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "token")
@Data
@RefreshScope
public class MyConsulConfig {
    private long accessTokenTimeout;
    private long refreshTokenTimeout;
}
