package by.htp.project1.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBPool {
	
	private final static String URL = "jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC";
    private final static String USER = "root";
    private final static String PASSWORD = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void putConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
