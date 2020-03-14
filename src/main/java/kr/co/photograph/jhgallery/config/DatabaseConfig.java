package kr.co.photograph.jhgallery.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableAutoConfiguration
@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    GlobalProperties globalProperties;

    @Bean
    @Primary
    public DataSource settingDataSource() {
        DataSource build = DataSourceBuilder
                .create()
                .url(globalProperties.getDataSourceUrl())
                .driverClassName(globalProperties.getDriverClassName())
                .username(globalProperties.getDataSourceUsername())
                .password(globalProperties.getDataSourcePassword())
                .build();
        return build;
    }

}
