package kr.co.photograph.jhgallery.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource( value = "file:${user.home}/WebProject/etc/config.properties", ignoreResourceNotFound = true ),
        @PropertySource( value = "file:/var/jenkins_home/workspace/config/config.properties", ignoreResourceNotFound = true ),
        @PropertySource( value = "file:/home/janghyeon/service_jhgallery/config/config.properties", ignoreResourceNotFound = true )
})
@Getter
public class GlobalProperties {
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Value("${javaMailSender.setUsername}")
    private String mailUsername;

    @Value("${javaMailSender.setPassword}")
    private String mailPassword;


}
