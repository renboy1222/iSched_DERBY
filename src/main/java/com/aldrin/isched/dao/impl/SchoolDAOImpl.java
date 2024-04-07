/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched.dao.impl;

import com.aldrin.isched.dao.SchoolDAO;
import com.aldrin.isched.model.School;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ALRIN B.C.
 */
public class SchoolDAOImpl extends DBConnection implements SchoolDAO {

    @Override
    public School selectSchool() {
        School school = null;
        Blob photo = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT  * FROM ALDRIN.SCHOOL  WHERE ID  =1 ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                School s = new School();
                s.setId(rs.getLong("ID"));
                s.setSchool(rs.getString("SCHOOL_NAME"));
                s.setAddress(rs.getString("ADDRESS"));
                s.setTel(rs.getString("TEL"));
                s.setTeleFax(rs.getString("TELEFAX"));
                s.setSite(rs.getString("SITE"));
                s.setTitle(rs.getString("TITLE"));
                s.setCampus(rs.getString("CAMPUS"));
                Blob picturel = rs.getBlob("LOGO");
                photo = picturel;
                byte[] bytes = convertBlobToBytes(picturel);
                s.setLogo(bytes);
                school = s;
            }
            rs.close();
            statement.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return school;
    }

    private static byte[] convertBlobToBytes(java.sql.Blob blob) throws IOException, SQLException {
        try (InputStream inputStream = blob.getBinaryStream()) {
            return convertInputStreamToBytes(inputStream);
        }
    }

    private static byte[] convertInputStreamToBytes(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
    }

    private static void writeBytesToFile(byte[] bytes, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(bytes);
        }
    }

    @Override
    public void updateSchool(School school) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE SCHOOL SET "
                    + "SCHOOL_NAME =?, ADDRESS =?, TEL=?, TELEFAX=?, SITE=?, TITLE=?, CAMPUS=? ,LOGO=?  WHERE SCHOOL.ID = 1");
            ps.setString(1, school.getSchool());
            ps.setString(2, school.getAddress());
            ps.setString(3, school.getTel());
            ps.setString(4, school.getTeleFax());
            ps.setString(5, school.getSite());
            ps.setString(6, school.getTitle());
            ps.setString(7, school.getCampus());
            ps.setBytes(8, school.getLogo());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
