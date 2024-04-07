/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.isched.dao;

import com.aldrin.isched.model.CampusHead;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public interface CampusHeadDAO {

    public Long getMaxId();

    public void addCampusHead(CampusHead schoolYear);

    public void updateCampusHead(CampusHead schoolYear);

    public void deleteCampusHead(CampusHead schoolYear);

    public ArrayList<CampusHead> selectCampusHead();

    public void comboBoxCampusHead();

    public void inActiveCampusHead();

    public Long getActiveCampusHeadId();

}
