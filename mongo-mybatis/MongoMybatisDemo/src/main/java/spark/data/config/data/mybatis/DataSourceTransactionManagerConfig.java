package spark.data.config.data.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceTransactionManagerConfig
 * @Description TODO
 * @Author Spark
 * @Date 10/17/2019 11:10 AM
 **/
@Configuration
@AutoConfigureAfter(DataSource.class)
@EnableTransactionManagement
public class DataSourceTransactionManagerConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
