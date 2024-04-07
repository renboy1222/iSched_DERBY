/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ALRIN B.C.
 */
@Setter
@Getter
@ToString
public class Schedule {

    private Long id;
    private SchoolYear schoolYear;
    private Subject subject;
    private Instructor instructor;
    private Section section;
    private Day day;
    private Time time;
    private Room room;
    private School school;
    private CampusHead campusHead;
    private Boolean deleted;
    
}
