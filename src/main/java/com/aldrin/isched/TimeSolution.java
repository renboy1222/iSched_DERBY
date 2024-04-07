/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched;

/**
 *
 * @author Java Programming with Aldrin
 */
public class TimeSolution {
//    SELECT * FROM TIME_CALCULATOR WHERE TIME_CALCULATOR.STARTTIME >= '08:30:00' AND TIME_CALCULATOR.ENDTIME <= '09:30:00'
    
//    CREATE TABLE TimeEntry (
//    EntryID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
//    ActivityName VARCHAR(100),
//    StartTime TIME,
//    EndTime TIME
//);
    
    String query ="""
                      SELECT 
                      ALDRIN.SCHEDULE.ID, 
                      ALDRIN.SCHEDULE.ROOM_ID, 
                      ALDRIN.SCHEDULE.DAY_ID, 
                      ALDRIN.SCHEDULE.TIME_ID, 
                      ALDRIN.TIME.START_TIME , ALDRIN.TIME.END_TIME, 
                      ALDRIN.DAY.DAY
                  FROM 
                      ALDRIN.SCHEDULE 
                  INNER JOIN 
                      ALDRIN.TIME 
                  ON (ALDRIN.SCHEDULE.TIME_ID = ALDRIN.TIME.ID) 
                  INNER JOIN 
                      ALDRIN.ROOM 
                  ON (ALDRIN.SCHEDULE.ROOM_ID = ALDRIN.ROOM.ID) 
                  INNER JOIN 
                      ALDRIN.DAY 
                  ON (ALDRIN.SCHEDULE.DAY_ID = ALDRIN.DAY.ID) 
                  INNER JOIN 
                      ALDRIN.INSTRUCTOR 
                  ON (ALDRIN.SCHEDULE.INSTRUCTOR_ID = ALDRIN.INSTRUCTOR.ID) WHERE  ALDRIN.SCHEDULE.ROOM_ID =2
                  AND ALDRIN.SCHEDULE.DAY_ID =1 AND  TIME.START_TIME < '10:00:00' AND TIME.END_TIME > '09:30:00
                  """;

    
    
}
