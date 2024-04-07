/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldrin.isched.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Java Programming with Aldrin
 */
public class DBConnection {

    private static Connection con;

    public void getDBConn() {
        synchronized ("") {
            try {
                if (this.getCon() == null || this.getCon().isClosed()) {
                    try {
                        String url = "jdbc:derby://localhost:1527/C:\\Users\\aldri\\Documents\\NetBeansProjects\\Aldrin Projects\\iSched Derby\\sched_db;";
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
//                         String url = "jdbc:derby:sched_db;";
//                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                        setCon(DriverManager.getConnection(url, "aldrin", "aldrin"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * @return the con
     */
    public static Connection getCon() {
        return con;
    }

    /**
     * @param aCon the con to set
     */
    public static void setCon(Connection aCon) {
        con = aCon;
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}