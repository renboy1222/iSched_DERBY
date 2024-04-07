/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched.dao.impl;

import com.aldrin.isched.dao.CampusHeadDAO;
import com.aldrin.isched.model.CampusHead;
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
public class CampusHeadDAOImpl extends DBConnection implements CampusHeadDAO {

    @Override
    public void addCampusHead(CampusHead campusHead) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO ALDRIN.CAMPUS_HEAD (ID,CAMPUS_HEAD,SATELITE_DIRECTOR,VPAA,SCHOOL_YEAR_ID) VALUES  (?,?,?,?,?) ");
            ps.setLong(1, getMaxId());
            ps.setString(2, campusHead.getCampusHead());
            ps.setString(3, campusHead.getSateliteDirector());
            ps.setString(4, campusHead.getVpaa());
            ps.setLong(5, campusHead.getSchoolYear().getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCampusHead(CampusHead campusHead) {
        try {
            if (campusHead.getActive()) {
                inActiveCampusHead();
                getDBConn();
                java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.CAMPUS_HEAD SET CAMPUS_HEAD =?,SATELITE_DIRECTOR =?,VPAA=?,SCHOOL_YEAR_ID=? ,ACTIVE =?  WHERE CAMPUS_HEAD.ID = ?");
                ps.setString(1, campusHead.getCampusHead());
                ps.setString(2, campusHead.getSateliteDirector());
                ps.setString(3, campusHead.getVpaa());
                ps.setLong(4, campusHead.getSchoolYear().getId());
                ps.setBoolean(5, campusHead.getActive());
                ps.setLong(6, campusHead.getId());
                ps.execute();
                ps.close();
                closeConnection();
            } else if (campusHead.getActive() == false) {
                getDBConn();
                java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.CAMPUS_HEAD SET CAMPUS_HEAD =?,SATELITE_DIRECTOR =?,VPAA=?,SCHOOL_YEAR_ID=?  WHERE CAMPUS_HEAD.ID = ?");
                ps.setString(1, campusHead.getCampusHead());
                ps.setString(2, campusHead.getSateliteDirector());
                ps.setString(3, campusHead.getVpaa());
                ps.setLong(4, campusHead.getSchoolYear().getId());
                ps.setLong(5, campusHead.getId());
                ps.execute();
                ps.close();
                closeConnection();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inActiveCampusHead() {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.CAMPUS_HEAD SET  ACTIVE =FALSE  WHERE CAMPUS_HEAD.ID > 0");
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCampusHead(CampusHead campusHead) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ALDRIN.CAMPUS_HEAD SET DELETED =? WHERE ID = ? ");
            ps.setBoolean(1, true);
            ps.setLong(2, campusHead.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public ArrayList<CampusHead> selectCampusHead() {
        ArrayList<CampusHead> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "    ALDRIN.CAMPUS_HEAD.ID, \n"
                    + "    ALDRIN.CAMPUS_HEAD.SCHOOL_YEAR_ID, \n"
                    + "    ALDRIN.CAMPUS_HEAD.CAMPUS_HEAD, \n"
                    + "    ALDRIN.CAMPUS_HEAD.SATELITE_DIRECTOR, \n"
                    + "    ALDRIN.CAMPUS_HEAD.VPAA, \n"
                    + "    ALDRIN.SCHOOL_YEAR.SCHOOL_YEAR, \n"
                    + "    ALDRIN.SEMESTER.SEMESTER,ALDRIN.CAMPUS_HEAD.ACTIVE \n"
                    + "FROM \n"
                    + "    ALDRIN.CAMPUS_HEAD \n"
                    + "INNER JOIN \n"
                    + "    ALDRIN.SCHOOL_YEAR \n"
                    + "ON (ALDRIN.CAMPUS_HEAD.SCHOOL_YEAR_ID = ALDRIN.SCHOOL_YEAR.ID) \n"
                    + "INNER JOIN \n"
                    + "    ALDRIN.SEMESTER \n"
                    + "ON (ALDRIN.SCHOOL_YEAR.SEMESTER_ID = ALDRIN.SEMESTER.ID) ORDER BY  ALDRIN.CAMPUS_HEAD.SCHOOL_YEAR_ID DESC";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                CampusHead campusHead = new CampusHead();
                SchoolYear sy = new SchoolYear();
                Semester sem = new Semester();
                sem.setSemester(rs.getString("SEMESTER"));
                sy.setId(rs.getLong("SCHOOL_YEAR_ID"));
                sy.setSchoolYear(rs.getString("SCHOOL_YEAR"));
                sy.setSemester(sem);
                campusHead.setSchoolYear(sy);
                campusHead.setCampusHead(rs.getString("CAMPUS_HEAD"));
                campusHead.setSateliteDirector(rs.getString("SATELITE_DIRECTOR"));
                campusHead.setVpaa(rs.getString("VPAA"));
                campusHead.setId(rs.getLong("ID"));
                campusHead.setActive(rs.getBoolean("ACTIVE"));
                list.add(campusHead);
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
    public void comboBoxCampusHead() {
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
                    + "    MAX(CAMPUS_HEAD.ID) AS ID  \n"
                    + "FROM \n"
                    + "    CAMPUS_HEAD ");
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
    public Long getActiveCampusHeadId() {
        Long maxId = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT \n"
                    + "    CAMPUS_HEAD.ID  \n"
                    + "FROM \n"
                    + "    CAMPUS_HEAD WHERE ACTIVE =TRUE");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                maxId = idl;
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
