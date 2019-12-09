/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author David pinto
 */
public class Conexion {
    private static final String bd = "Veterinaria";
    private static final String url = "jdbc:mysql://localhost:3306/" + bd;
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String User = "root";
    private static final String Pass = "";
    private Driver driver = null;

    public Connection getConexion() throws SQLException {
        if (driver == null) {
            try {
                Class driverClass = Class.forName(Driver);
                driver = (Driver) driverClass.newInstance();
                DriverManager.registerDriver(driver);

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return DriverManager.getConnection(url, User, Pass);
    }

    public void close(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {

        }
    }

    public void close(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {

        }
    }

    public void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {

        }
    }
    
}
