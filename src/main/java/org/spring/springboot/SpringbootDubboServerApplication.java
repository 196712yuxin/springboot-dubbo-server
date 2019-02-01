package org.spring.springboot;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Properties;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@MapperScan({"org.spring.springboot.dao"})
public class SpringbootDubboServerApplication {
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public javax.sql.DataSource dataSource() { return new org.apache.tomcat.jdbc.pool.DataSource(); }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception
    {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Interceptor[] plugins = { pageHelper() };
        sqlSessionFactoryBean.setPlugins(plugins);
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mappers/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboServerApplication.class, args);

    }

}

