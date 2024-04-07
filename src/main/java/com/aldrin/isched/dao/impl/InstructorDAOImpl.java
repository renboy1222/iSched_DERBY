/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched.dao.impl;

import com.aldrin.isched.dao.InstructorDAO;
import com.aldrin.isched.model.Instructor;
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
public class InstructorDAOImpl extends DBConnection implements InstructorDAO {

    @Override
    public void addInstructor(Instructor instructor) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO ALDRIN.INSTRUCTOR (ID,INSTRUCTOR) VALUES  (?,?) ");
            ps.setLong(1, getMaxId());
            ps.setString(2, instructor.getInstructor());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.INSTRUCTOR SET INSTRUCTOR =?  WHERE INSTRUCTOR.ID = ?");
            ps.setString(1, instructor.getInstructor());
            ps.setLong(2, instructor.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.INSTRUCTOR SET DELETED =? WHERE INSTRUCTOR.ID = ? ");
            ps.setBoolean(1, true);
            ps.setLong(2, instructor.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public ArrayList<Instructor> selectInstructor() {
        ArrayList<Instructor> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM ALDRIN.INSTRUCTOR WHERE INSTRUCTOR.DELETED =FALSE  ORDER BY INSTRUCTOR ASC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Instructor c = new Instructor();
                c.setId(rs.getLong("ID"));
                c.setInstructor(rs.getString("INSTRUCTOR"));
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
    public void comboBoxInstructor() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT * FROM ALDRIN.INSTRUCTOR WHERE INSTRUCTOR.DELETED =FALSE  ORDER BY INSTRUCTOR ASC ");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String namel = rs.getString("INSTRUCTOR");
                this.getList().add(new ComboBoxList(idl, namel));
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
                    + "    MAX(INSTRUCTOR.ID) AS ID  \n"
                    + "FROM \n"
                    + "    INSTRUCTOR ");
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
            PreparedStatement statement = getCon().prepareStatement("SELECT   INSTRUCTOR.ID FROM    ALDRIN.INSTRUCTOR WHERE INSTRUCTOR ='" + name + "'");
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

}
