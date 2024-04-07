/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched.dao.impl;

import com.aldrin.isched.dao.TimeDAO;
import com.aldrin.isched.model.Time;
import com.aldrin.isched.util.ComboBoxList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class TimeDAOImpl extends DBConnection implements TimeDAO {

    @Override
    public void addTime(Time time) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO ALDRIN.TIME (ID,TIME,START_TIME,END_TIME) VALUES  (?,?,?,?) ");
            ps.setLong(1, getMaxId());
            ps.setString(2, time.getTime());
            ps.setString(3, time.getStartTime());
            ps.setString(4, time.getEndTime());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTime(Time time) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.TIME SET TIME =?,START_TIME=?,END_TIME=? WHERE TIME.ID = ?");
            ps.setString(1, time.getTime());
            ps.setString(2, time.getStartTime());
            ps.setString(3, time.getEndTime());
            ps.setLong(4, time.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTime(Time time) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.TIME SET DELETED =? WHERE TIME.ID = ? ");
            ps.setBoolean(1, true);
            ps.setLong(2, time.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;
    public ArrayList<String> timeAvailable;

    @Override
    public ArrayList<Time> selectTime() {
        ArrayList<Time> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM ALDRIN.TIME WHERE TIME.DELETED =FALSE  ORDER BY ID ASC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Time c = new Time();
                c.setId(rs.getLong("ID"));
                c.setTime(rs.getString("TIME"));
                list.add(c);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void comboBoxTime() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT * FROM ALDRIN.TIME WHERE TIME.DELETED =FALSE  ORDER BY ID ASC ");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String timel = rs.getString("TIME");
                this.getList().add(new ComboBoxList(idl, timel));
            }
            rs.close();
            statement.close();
            closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Long getMaxId() {
        Long maxId = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT \n"
                    + "    MAX(TIME.ID) AS ID  \n"
                    + "FROM \n"
                    + "    TIME ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                if (idl == 0) {
                    maxId = 1L;
                } else {
                    maxId = idl + 1;
                }
            }
            rs.close();
            statement.close();
//            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxId;
    }

    @Override
    public Boolean isDuplicate(String name) {
        Boolean maxId = false;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT   ALDRIN.TIME.ID FROM    ALDRIN.TIME WHERE TIME.TIME ='" + name + "'");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                if (idl > 0) {
                    maxId = true;
                }
            }
            rs.close();
            statement.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxId;
    }

    @Override
    public void comboBoxTimeAvailable() {
        this.setTimeAvailable(new ArrayList<String>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT * FROM ALDRIN.TIME WHERE TIME.DELETED =FALSE  ORDER BY ID ASC ");
            rs = statement.executeQuery();
            while (rs.next()) {
                String timel = rs.getString("TIME");
                this.getTimeAvailable().add(timel);
            }
            rs.close();
            statement.close();
            closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
