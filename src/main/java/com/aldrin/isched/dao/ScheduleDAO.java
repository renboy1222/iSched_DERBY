/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.isched.dao;

import com.aldrin.isched.model.Day;
import com.aldrin.isched.model.Schedule;
import com.aldrin.isched.model.SchoolYear;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public interface ScheduleDAO {

    public Long getMaxId();

    public void addSchedule(Schedule schedule);

    public void updateSchedule(Schedule schedule);

    public void deleteSchedule(Schedule schedule);

    public ArrayList<Schedule> selectSchedule(Long syId);

    public void comboBoxSchedule();

    public Boolean isConflictSchedule(Long dayId, Long roomId, String time,Long syId);

    public Integer instructorsSubject(Long instructorId,Long syId);

    public Integer subjectsUse(Long subjectId,Long syId);

    public Integer sectionUse(Long sectionId,Long syId);

    public ArrayList<Schedule> selectScheduleBySubjectId(Long subjectId);

    public ArrayList<Schedule> selectScheduleByInstructorId(Long instructorId);

    public ArrayList<Schedule> selectScheduleBySectionId(Long sectionId);

    public ArrayList<Schedule> selectScheduleByDayId(Long dayId);

    public Integer dayUse(Long dayId);

    public ArrayList<Schedule> selectScheduleByTimeId(Long timeId);

    public Integer timeUse(Long timeId);

    public ArrayList<Schedule> selectScheduleByRoomId(Long roomId);

    public Integer roomUse(Long roomId);
    
    public Schedule conflictScheduleDetails(Long dayId, Long roomId, String time, Long syId); 

}
