/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.isched.dao;

import com.aldrin.isched.model.Section;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public interface SectionDAO {

    public Long getMaxId();

    public void addSection(Section section);

    public void updateSection(Section section);

    public void deleteSection(Section section);

    public ArrayList<Section> selectSection();

    public void comboBoxSection();
    
    public Boolean isDuplicate(String name);

}
