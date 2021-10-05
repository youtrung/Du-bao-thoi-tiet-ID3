/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author trung
 */
public class SQLprovider {
      Connection connection=null;
    public void open() throws ClassNotFoundException, SQLException{
            String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String urlConnection="jdbc:sqlserver://localhost;databaseName=WEATHER_data;IntegratedSecurity=true;User=sa;password=sa12";
            Class.forName(driver);
            connection=DriverManager.getConnection(urlConnection);
           
    }
    public void close() throws SQLException
    {
            connection.close();
    }
    public ResultSet executeQuery(String sql) throws SQLException{
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            return rs;
    } 
}
