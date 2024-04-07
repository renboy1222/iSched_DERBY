/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.isched.dao;

import com.aldrin.isched.model.School;
import java.util.List;

/**
 *
 * @author ALDRIN B. C.
 */
public interface SchoolDAO {

    public School selectSchool();

    public void updateSchool(School school);

}
