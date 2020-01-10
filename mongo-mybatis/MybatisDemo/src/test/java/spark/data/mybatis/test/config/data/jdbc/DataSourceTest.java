package spark.data.mybatis.test.config.data.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceTest
 * @Description TODO
 * @Author Spark
 * @Date 10/17/2019 11:37 AM
 **/

@SpringBootTest
public class DataSourceTest {
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Test
    public void testDataSource() throws Exception {
        // 获取配置的数据源
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        // 查看配置数据源信息
        System.out.println(dataSource);
        System.out.println(dataSource.getClass().getName());
        System.out.println(dataSourceProperties);
    }
}
