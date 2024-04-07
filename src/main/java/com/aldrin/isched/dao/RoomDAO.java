/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.isched.dao;

import com.aldrin.isched.model.Room;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public interface RoomDAO {

    public Long getMaxId();

    public void addRoom(Room room);

    public void updateRoom(Room room);

    public void deleteRoom(Room room);

    public ArrayList<Room> selectRoom();

    public void comboBoxRoom();

    public Boolean isDuplicate(String name);

}
