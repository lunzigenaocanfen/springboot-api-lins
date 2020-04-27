package com.great.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootTest
public class BadgerDruidApplicationTests {
 
    @Autowired
    DataSource dataSource;
 
    @Test
    @DisplayName("第一次测试")
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement = connection
                .prepareStatement("select * from sys_menu");
        ResultSet resultSet = prepareStatement.executeQuery();
        while (resultSet.next()) {
            String cityName = resultSet.getString("menu_name");
            System.out.println(cityName);
        }
    }


    @Test
    @DisplayName("第一次测试")
    public void firstTest() {
        System.out.println("hello world");
    }


}