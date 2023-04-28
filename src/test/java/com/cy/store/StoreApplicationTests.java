package com.cy.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
    @Autowired // 自动装配
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    /**
     * 数据库连接池：
     * 1、JDBC
     * 2、C3P0
     * 3、Hikari
     * HikariProxyConnection@973068874 wrapping com.mysql.cj.jdbc.ConnectionImpl@3ba348ca
     * @throws SQLException
     */
    @Test
    void getConnect() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
