/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched.dao.impl;

import com.aldrin.isched.dao.SectionDAO;
import com.aldrin.isched.model.Section;
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
public class SectionDAOImpl extends DBConnection implements SectionDAO {

    @Override
    public void addSection(Section section) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO ALDRIN.SECTION (ID,CODE) VALUES  (?,?) ");
            ps.setLong(1, getMaxId());
            ps.setString(2, section.getCode());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSection(Section section) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.SECTION SET CODE =?  WHERE SECTION.ID = ?");
            ps.setString(1, section.getCode());
            ps.setLong(2, section.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSection(Section section) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.SECTION SET DELETED =? WHERE SECTION.ID = ? ");
            ps.setBoolean(1, true);
            ps.setLong(2, section.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public ArrayList<Section> selectSection() {
        ArrayList<Section> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM ALDRIN.SECTION WHERE SECTION.DELETED =FALSE  ORDER BY CODE ASC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Section c = new Section();
                c.setId(rs.getLong("ID"));
                c.setCode(rs.getString("CODE"));
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
    public void comboBoxSection() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT * FROM ALDRIN.SECTION WHERE SECTION.DELETED =FALSE  ORDER BY CODE ASC ");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String namel = rs.getString("CODE");
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
                    + "    MAX(SECTION.ID) AS ID  \n"
                    + "FROM \n"
                    + "    SECTION ");
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
            PreparedStatement statement = getCon().prepareStatement("SELECT   SECTION.ID FROM    SECTION WHERE CODE ='"+name+"'");
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
