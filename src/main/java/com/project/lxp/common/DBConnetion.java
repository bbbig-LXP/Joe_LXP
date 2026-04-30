package com.project.lxp.common;


import com.mysql.cj.jdbc.JdbcConnection;
import com.zaxxer.hikari.HikariConfig;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.sql.DataSource;

public class DBConnetion {

    private static final HikariDataSource dataSource;


    static {


        try {
            Properties props = new Properties();
            props.load(DBConnetion.class.getClassLoader().getResourceAsStream("config.properties"));

            HikariConfig config = new HikariConfig();

            config.setJdbcUrl(props.getProperty("db.url"));
            config.setUsername(props.getProperty("db.username"));
            config.setPassword(props.getProperty("db.password"));

            config.setMaximumPoolSize(10);

            config.setMinimumIdle(5);

            config.setIdleTimeout(30000);

            config.setMaxLifetime(180000);

            config.setConnectionTimeout(2000);

            dataSource = new HikariDataSource(config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(){
        if(dataSource != null){
            dataSource.close();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

//    private static final String URL = requireEnv("LXP_DB_URL");
//    private static final String USER = requireEnv("LXP_DB_USER");
//    private static final String PASSWORD = requireEnv("LXP_DB_PASSWORD");
//
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
//
//    public static String requireEnv(String key) {
//        String value = System.getenv(key);
//        if (value == null || value.isBlank()) {
//            throw new IllegalArgumentException("환경 변수가 누락됨" + key);
//        }
//        return value;
//    }

}