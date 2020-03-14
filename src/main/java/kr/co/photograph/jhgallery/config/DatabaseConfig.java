package kr.co.photograph.jhgallery.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.DriverManager;

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
