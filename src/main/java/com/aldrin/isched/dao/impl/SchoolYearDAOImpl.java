/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched.dao.impl;

import com.aldrin.isched.dao.SchoolYearDAO;
import com.aldrin.isched.model.SchoolYear;
import com.aldrin.isched.model.Semester;
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
public class SchoolYearDAOImpl extends DBConnection implements SchoolYearDAO {

    @Override
    public void addSchoolYear(SchoolYear schoolYear) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO ALDRIN.SCHOOL_YEAR (ID,SCHOOL_YEAR,SEMESTER_ID) VALUES  (?,?,?) ");
            ps.setLong(1, getMaxId());
            ps.setString(2, schoolYear.getSchoolYear());
            ps.setLong(3, schoolYear.getSemester().getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSchoolYear(SchoolYear schoolYear) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.SCHOOL_YEAR SET SCHOOL_YEAR =?,SEMESTER_ID =? WHERE SCHOOL_YEAR.ID = ?");
            ps.setString(1, schoolYear.getSchoolYear());
            ps.setLong(2, schoolYear.getSemester().getId());
            ps.setLong(3, schoolYear.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSchoolYear(SchoolYear schoolYear) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.SCHOOL_YEAR SET DELETED =? WHERE SCHOOL_YEAR_ID = ? ");
            ps.setBoolean(1, true);
            ps.setLong(2, schoolYear.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public ArrayList<SchoolYear> selectSchoolYear() {
        ArrayList<SchoolYear> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "    ALDRIN.SCHOOL_YEAR.ID,\n"
                    + "    ALDRIN.SCHOOL_YEAR.SEMESTER_ID,  \n"
                    + "    ALDRIN.SCHOOL_YEAR.SCHOOL_YEAR, \n"
                    + "    ALDRIN.SEMESTER.SEMESTER \n"
                    + "FROM \n"
                    + "    ALDRIN.SCHOOL_YEAR \n"
                    + "INNER JOIN \n"
                    + "    ALDRIN.SEMESTER \n"
                    + "ON \n"
                    + "    ( \n"
                    + "        ALDRIN.SCHOOL_YEAR.SEMESTER_ID = ALDRIN.SEMESTER.ID) WHERE ALDRIN.SCHOOL_YEAR.DELETED =FALSE ORDER BY ALDRIN.SCHOOL_YEAR.ID DESC";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                SchoolYear sy = new SchoolYear();
                Semester s = new Semester();
                sy.setId(rs.getLong("ID"));
                s.setId(rs.getLong("SEMESTER_ID"));
                s.setSemester(rs.getString("SEMESTER"));
                sy.setSemester(s);
                sy.setSchoolYear(rs.getString("SCHOOL_YEAR"));
                list.add(sy);
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
    public void comboBoxSchoolYear() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT \n"
                    + "    ALDRIN.SCHOOL_YEAR.ID, \n"
                    + "    ALDRIN.SCHOOL_YEAR.SEMESTER_ID, \n"
                    + "    ALDRIN.SCHOOL_YEAR.SCHOOL_YEAR, \n"
                    + "    ALDRIN.SEMESTER.SEMESTER \n"
                    + "FROM \n"
                    + "    ALDRIN.SCHOOL_YEAR \n"
                    + "INNER JOIN \n"
                    + "    ALDRIN.SEMESTER \n"
                    + "ON \n"
                    + "    (ALDRIN.SCHOOL_YEAR.SEMESTER_ID = ALDRIN.SEMESTER.ID) ORDER BY ALDRIN.SCHOOL_YEAR.ID DESC ");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String schoolYear = rs.getString("SCHOOL_YEAR");
                String semester = rs.getString("SEMESTER");

                this.getList().add(new ComboBoxList(idl, schoolYear + " [" + semester + "] "));
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
                    + "    MAX(SCHOOL_YEAR.ID) AS ID  \n"
                    + "FROM \n"
                    + "    SCHOOL_YEAR ");
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
            PreparedStatement statement = getCon().prepareStatement("SELECT   ALDRIN.SCHOOL_YEAR.ID FROM    ALDRIN.SCHOOL_YEAR WHERE SCHOOL_YEAR.SCHOOL_YEAR ='" + name + "'");
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
