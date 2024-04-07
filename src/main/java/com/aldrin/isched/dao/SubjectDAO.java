/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.isched.dao;

import com.aldrin.isched.model.Subject;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public interface SubjectDAO {

    public Long getMaxId();

    public void addSubject(Subject subject);

    public void updateSubject(Subject subject);

    public void deleteSubject(Subject subject);

    public ArrayList<Subject> selectSubject();

    public void comboBoxSubject();

    public Boolean isDuplicate(String name);

}
