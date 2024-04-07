/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.isched.dao;

import com.aldrin.isched.model.SchoolYear;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public interface SchoolYearDAO {

    public Long getMaxId();

    public void addSchoolYear(SchoolYear schoolYear);

    public void updateSchoolYear(SchoolYear schoolYear);

    public void deleteSchoolYear(SchoolYear schoolYear);

    public ArrayList<SchoolYear> selectSchoolYear();

    public void comboBoxSchoolYear();

    public Boolean isDuplicate(String name);

}
